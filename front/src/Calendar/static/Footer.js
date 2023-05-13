import React from 'react';
import { Typography, Link } from '@mui/material';
import { makeStyles } from '@mui/styles';

const useStyles = makeStyles(() => ({
    footer: {
        position: 'fixed',
        bottom: 0,
        left: 0,
        right: 0,
        backgroundColor: 'black',
        color: 'white',
        padding: '10px',
        textAlign: 'center',
    },
}));

function Footer() {
    const classes = useStyles();

    function Copyright(props) {
        return (
            <Typography variant="body2" align="center" {...props} className={classes.footer}>
                {'Copyright © '}
                <Link color="inherit" href="">
                    PFA
                </Link>{' '}
                {new Date().getFullYear()}
                {'.'}
            </Typography>
        );
    }

    return <Copyright />;
}

export default Footer;
