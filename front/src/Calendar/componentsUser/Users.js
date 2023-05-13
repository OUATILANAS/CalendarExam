import React, { useState, useEffect } from 'react';
import { DataGrid } from '@mui/x-data-grid';
import { Box, Typography, Grid } from '@mui/material';
import axios from 'axios';
import UserModal from './UserModal';
import DeleteIcon from '@mui/icons-material/Delete';
import IconButton from '@mui/material/IconButton';



export default function UsersTable() {
    const [users, setUsers] = useState([]);
    useEffect(() => {
        axios
            .get('/api/auth/users')
            .then((response) => {
                setUsers(response.data);
            })
            .catch((error) => {
                console.error('Error fetching data:', error);
            });
    }, []);

    const columns = [
        { field: 'id', headerName: 'ID', width: 100 },
        { field: 'matricule', headerName: 'Matricule', width: 150 },
        { field: 'nom', headerName: 'Nom', width: 150 },
        { field: 'prenom', headerName: 'Prénom', width: 150 },
        { field: 'email', headerName: 'Email', width: 200 },
        { field: 'telephone', headerName: 'Téléphone', width: 150 },
        { field: 'username', headerName: 'Nom Utilisateur', width: 150 },
        {
            field: 'action',
            headerName: 'Action',
            width: 150,
            renderCell: () => (
                <Box>
                    <IconButton>
                        <DeleteIcon />
                    </IconButton>
                </Box>
            ),
        },
    ];
    return (
        <Grid item xs={12} sm={6} textAlign="center">
            <Box sx={{ margin: '15px' }}>
                <Box
                    sx={{
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'space-between',
                        margin: '0px 100px 10px 100px',
                        '@media (max-width: 600px)': {
                            margin: '0px 20px 10px 20px',
                        },
                    }}
                >
                    <Typography component="h1" variant="h6" color="black" noWrap sx={{ margin: '10px' }}>
                        Liste des utilisateurs
                    </Typography>
                    <UserModal />
                </Box>


                <Grid container justifyContent="center">
                    <Grid item xs={12} sm={12} md={12} lg={10}>
                        <div style={{ height: 400, width: '100%' }}>
                            <DataGrid sx={{ bgcolor: '' }}
                                rows={users}
                                columns={columns}

                            />


                        </div>
                    </Grid>
                </Grid>


            </Box>
        </Grid>
    );
}

