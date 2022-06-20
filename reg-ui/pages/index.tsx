import React from 'react';
import type { NextPage } from 'next';
import Head from 'next/head';
import styles from '../styles/Home.module.css';

const Home: NextPage = () => (
  <div className={styles.container}>
    <Head>
      <title>books</title>
      <meta name="description" content="books" />
      <link rel="icon" href="/favicon.ico" />
    </Head>

    <main className={styles.main} />

    <footer className={styles.footer}>
      jared engler &copy; 2022
    </footer>
  </div>
);

export default Home;
