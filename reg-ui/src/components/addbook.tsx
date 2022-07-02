import React, { MouseEvent } from 'react';
import {
  Button, Card, FormControl, Input, InputLabel, styled,
} from '@mui/material';

const AddBookCard = styled(Card)`padding: 5vmin`;
const AddBookButton = styled(Button)`margin-top: 2vmin`;

type AddBookProps = {
  // eslint-disable-next-line no-unused-vars
  onAddBook: (e: MouseEvent) => void;
};

const AddBook = ({ onAddBook }: AddBookProps) => (
  <AddBookCard>
    <FormControl fullWidth>
      <InputLabel htmlFor="book-name">name</InputLabel>
      <Input id="book-name" fullWidth />
      <AddBookButton onClick={onAddBook} variant="contained">Add Book</AddBookButton>
    </FormControl>
  </AddBookCard>
);

export default AddBook;
