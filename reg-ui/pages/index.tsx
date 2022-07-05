import React, {
  useEffect, useState, useCallback, ChangeEvent,
} from 'react';
import type { NextPage } from 'next';
import { Box, Container, styled } from '@mui/material';
import Meta from '../src/components/meta';
import BookList, { BookData } from '../src/components/booklist';
import AddBook from '../src/components/addbook';
import HeaderText from '../src/components/headertext';

const RegistryBaseUrl = process.env.NEXT_PUBLIC_REGISTRY_HOST ?? 'http://localhost:8080';

const MainBox = styled(Box)`
  padding: 5vmin
`;

const MainFooter = styled('footer')`
  display: flex;
  flex: 1;
  padding: 2rem 0;
  border-top: 1px solid #eaeaea;
  justify-content: center;
  align-items: center;
`;

const title = 'kafka-books';

const Home: NextPage = () => {
  const [data, setData] = useState([] as BookData[]);
  const [bookName, setBookName] = useState('');

  const fetchBooksHandler = useCallback(async () => {
    try {
      const response = await fetch(`${RegistryBaseUrl}/books/`);
      if (!response.ok) { throw new Error(''); }
      const d = await response.json();
      setData(d);
    } catch (error) {
      // eslint-disable-next-line no-console
      console.log(error);
    }
  }, [data]);

  const addBookHandler = async () => {
    try {
      await fetch(`${RegistryBaseUrl}/book/new`, {
        method: 'POST',
        headers: {
          'content-type': 'application/json',
        },
        body: JSON.stringify({
          title: bookName,
        }),
      });
      fetchBooksHandler();
    } catch (error) {
      // eslint-disable-next-line no-console
      console.log(error);
    }
    setBookName('');
  };

  const addBookTextHandler = ({ target }: ChangeEvent) => {
    const t = target as HTMLInputElement;
    setBookName(t.value);
  };

  useEffect(() => {
    fetchBooksHandler();
  }, [fetchBooksHandler]);

  return (
    <Container maxWidth="md">
      <Meta title={title} />
      <MainBox>
        <HeaderText>{title}</HeaderText>
        <AddBook
          onAddBook={addBookHandler}
          bookName={bookName}
          onChange={addBookTextHandler}
        />
        <BookList data={data} />
      </MainBox>
      <MainFooter>
        jared engler &copy; 2022
      </MainFooter>
    </Container>
  );
};

export default Home;
