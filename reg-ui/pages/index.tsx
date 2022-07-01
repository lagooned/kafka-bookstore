import React, { useEffect, useState, useCallback } from 'react';
import type { NextPage } from 'next';
import { Box, Container, styled } from '@mui/material';
import Meta from '../src/components/meta';
import BookList, { BookData } from '../src/components/booklist';
import AddBook from '../src/components/addbook';
import HeaderText from '../src/components/headertext';

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
const registryHost = process.env.NEXT_PUBLIC_REGISTRY_HOST ?? '';
const registryPort = process.env.NEXT_PUBLIC_REGISTRY_PORT ?? '';

const Home: NextPage = () => {
  const [data, setData] = useState([] as BookData[]);

  const fetchBooksHandler = useCallback(async () => {
    try {
      const response = await fetch(`http://${registryHost}:${registryPort}/books/`);
      if (!response.ok) { throw new Error(''); }
      const d = await response.json();
      setData(d);
    } catch (error) {
      // eslint-disable-next-line no-console
      console.log(error);
    }
  }, []);

  useEffect(() => {
    fetchBooksHandler();
  }, [fetchBooksHandler]);

  return (
    <Container maxWidth="md">
      <Meta title={title} />
      <MainBox>
        <HeaderText>{title}</HeaderText>
        <AddBook />
        <BookList data={data} />
      </MainBox>
      <MainFooter>
        jared engler &copy; 2022
      </MainFooter>
    </Container>
  );
};

export default Home;
