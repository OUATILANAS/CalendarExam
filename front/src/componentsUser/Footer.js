import { Typography, Link } from "@mui/material";
import React from "react";
function Footer() {
    function Copyright(props) {
        return (
            <Typography variant="body2" color="text.secondary" align="center" {...props}>
                {'Copyright © '}
                <Link color="inherit" href="https://mui.com/">
                    Your Website
                </Link>{' '}
                {new Date().getFullYear()}
                {'.'}
            </Typography>
        );
    }
    return (
        <Copyright />
    );
}

export default Footer;
