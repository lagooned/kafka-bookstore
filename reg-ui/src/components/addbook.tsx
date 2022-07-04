/* eslint-disable no-unused-vars */
import React, { ChangeEvent, MouseEvent } from 'react';
import {
  Button, Card, FormControl, Input, InputLabel, styled,
} from '@mui/material';

const AddBookCard = styled(Card)`padding: 5vmin`;
const AddBookButton = styled(Button)`margin-top: 2vmin`;

type AddBookProps = {
  onAddBook: (e: MouseEvent) => void;
  onChange: (e: ChangeEvent) => void;
  bookName: string;
};

const AddBook = ({ onAddBook, bookName, onChange }: AddBookProps) => (
  <AddBookCard>
    <FormControl fullWidth>
      <InputLabel htmlFor="book-name">name</InputLabel>
      <Input id="book-name" value={bookName} onChange={onChange} fullWidth />
      <AddBookButton onClick={onAddBook} variant="contained">Add Book</AddBookButton>
    </FormControl>
  </AddBookCard>
);

export default AddBook;
