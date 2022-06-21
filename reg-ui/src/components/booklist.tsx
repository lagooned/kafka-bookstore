import React from 'react';
import {
  Card, List, ListItem, ListItemText, styled, Typography,
} from '@mui/material';

const BookListCard = styled(Card)`
  margin-top: 3vmin;
  padding: 2vmin;
`;

export type BookData = {
  id: string,
  title: string
};

type BookListProps = {
  data: BookData[]
}

const BookList = ({ data }: BookListProps) => {
  const isEmpty = (data.length === 0);

  return (
    <BookListCard>
      {isEmpty && <Typography variant="subtitle1" gutterBottom>nothing to display</Typography>}
      {!isEmpty && (
        <List>
          {data.map(({ id, title }) => (
            <ListItem key={id}>
              <ListItemText>
                {title}
              </ListItemText>
            </ListItem>
          ))}
        </List>
      )}
    </BookListCard>
  );
};

export default BookList;
