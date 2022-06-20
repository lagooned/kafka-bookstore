import React from 'react';
import type { NextPage } from 'next';
import { Box, Container, Typography } from '@mui/material';
import styled from '@emotion/styled';
import Meta from '../src/components/meta';

const MainBox = styled(Box)`
  padding: 5vmin
`;

const MainFooter = styled.footer`
  display: flex;
  flex: 1;
  padding: 2rem 0;
  border-top: 1px solid #eaeaea;
  justify-content: center;
  align-items: center;
`;

const Home: NextPage = () => (
  <Container maxWidth="lg">
    <Meta title="books" />
    <MainBox>
      <Typography variant="h4" component="h1" gutterBottom>
        Books
      </Typography>
    </MainBox>
    <MainFooter>
      jared engler &copy; 2022
    </MainFooter>
  </Container>
);

export default Home;
