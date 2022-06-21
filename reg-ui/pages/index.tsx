import React, { useEffect, useState } from 'react';
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

const Home: NextPage = () => {
  const [data, setData] = useState([] as BookData[]);

  const populateBooks = () => {
    fetch('http://localhost:8080/books')
      .then((r) => r.json())
      .then((j) => setData(j))
      .catch((e) => { console.log(e); setData([]) });
  };

  useEffect(() => {
    populateBooks();
  }, [])

  return (
    <Container maxWidth="md" >
      <Meta title={title} />
      <MainBox>
        <HeaderText>{title}</HeaderText>
        <AddBook />
        <BookList data={data} />
      </MainBox>
      <MainFooter>
        jared engler &copy; 2022
      </MainFooter>
    </Container >
  );
};

export default Home;
