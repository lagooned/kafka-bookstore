import React from 'react';
import {
  Card, List, ListItem, ListItemText, styled,
} from '@mui/material';

const BookListCard = styled(Card)`
  margin-top: 3vmin;
`;

type BookListProps = {
  data: { id: string, title: string }[]
}

const BookList = ({ data }: BookListProps) => (
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

export default BookList;
