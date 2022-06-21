import React from 'react';
import type { NextPage } from 'next';
import { Box, Container, styled } from '@mui/material';
import Meta from '../src/components/meta';
import BookList from '../src/components/booklist';
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
const data = [
  { id: 'd0fbb33a-305e-43b1-b66c-a9abb0968e78', title: 'test1' },
  { id: '9ab83066-6f98-42ab-b1fa-ca7fcb0ef7b8', title: 'test2' },
  { id: '199a90c5-a882-402d-af2e-aa3745638f15', title: 'test3' },
];

const Home: NextPage = () => (
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

export default Home;
