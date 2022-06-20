import React from 'react';
import Head from 'next/head';

type MetaProps = {
  title: string
}

const Meta = ({ title }: MetaProps) => (
  <Head>
    <title>{title}</title>
    <meta name="description" content="books" />
    <link rel="icon" href="/favicon.ico" />
  </Head>
);

export default Meta;
