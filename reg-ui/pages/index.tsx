import React from 'react';
import type { NextPage } from 'next';
import { Box, Container, Typography } from '@mui/material';
import Meta from '../src/components/meta';
import styles from '../styles/Home.module.css';

const Home: NextPage = () => (
  <Container maxWidth="lg">
    <Meta title="books" />
    <Box sx={{ padding: '5vmin' }}>
      <Typography variant="h4" component="h1" gutterBottom>
        Books
      </Typography>
    </Box>
    <footer className={styles.footer}>
      jared engler &copy; 2022
    </footer>
  </Container>
);

export default Home;
