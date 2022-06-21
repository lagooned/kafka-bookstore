import React, { memo } from 'react';
import type { NextPage } from 'next';
import {
  Box, Button, Card,
  Container, FormControl, Input,
  InputLabel, List, ListItem,
  ListItemText, styled, Typography,
} from '@mui/material';
import Meta from '../src/components/meta';

const MainBox = memo(styled(Box)`
  padding: 5vmin
`);

const MainFooter = memo(styled('footer')`
  display: flex;
  flex: 1;
  padding: 2rem 0;
  border-top: 1px solid #eaeaea;
  justify-content: center;
  align-items: center;
`);

type HeaderTextProps = {children: string};
const HeaderText = memo(({ children }: HeaderTextProps) => (
  <Typography variant="h1" gutterBottom>
    {children}
  </Typography>
));

const AddBook = () => {
  const AddBookCard = styled(Card)`padding: 5vmin`;
  const AddBookButton = styled(Button)`margin-top: 2vmin`;

  return (
    <AddBookCard>
      <FormControl fullWidth>
        <InputLabel htmlFor="book-name">name</InputLabel>
        <Input id="book-name" fullWidth />
        <AddBookButton variant="contained">Add Book</AddBookButton>
      </FormControl>
    </AddBookCard>
  );
};

const data = [
  { id: 'd0fbb33a-305e-43b1-b66c-a9abb0968e78', title: 'test1' },
  { id: '9ab83066-6f98-42ab-b1fa-ca7fcb0ef7b8', title: 'test2' },
  { id: '199a90c5-a882-402d-af2e-aa3745638f15', title: 'test3' },
];

const BookList = () => {
  const BookListCard = styled(Card)`
    margin-top: 3vmin;
  `;
  return (
    <BookListCard>
      <List>
        {data.map(({ id, title }) => (
          <ListItem key={id}>
            <ListItemText>
              {title}
            </ListItemText>
          </ListItem>
        ))}
      </List>
    </BookListCard>
  );
};

const Home: NextPage = () => (
  <Container maxWidth="lg">
    <Meta title="kafka-books" />
    <MainBox>
      <HeaderText>kafka-books</HeaderText>
      <AddBook />
      <BookList />
    </MainBox>
    <MainFooter>
      jared engler &copy; 2022
    </MainFooter>
  </Container>
);

export default Home;
