import { Typography } from '@mui/material';
import React from 'react';

type HeaderTextProps = {children: string};

const HeaderText = ({ children }: HeaderTextProps) => (
  <Typography variant="h1" gutterBottom>
    {children}
  </Typography>
);

export default HeaderText;
