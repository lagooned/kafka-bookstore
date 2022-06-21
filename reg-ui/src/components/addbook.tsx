import React from 'react';
import {
  Button, Card, FormControl, Input, InputLabel, styled,
} from '@mui/material';

const AddBookCard = styled(Card)`padding: 5vmin`;
const AddBookButton = styled(Button)`margin-top: 2vmin`;

const AddBook = () => (
  <AddBookCard>
    <FormControl fullWidth>
      <InputLabel htmlFor="book-name">name</InputLabel>
      <Input id="book-name" fullWidth />
      <AddBookButton variant="contained">Add Book</AddBookButton>
    </FormControl>
  </AddBookCard>
);

export default AddBook;
