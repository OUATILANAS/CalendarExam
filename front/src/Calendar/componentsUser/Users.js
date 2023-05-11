import React, { useState, useEffect } from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { Box, Typography, Grid } from '@mui/material';
import axios from 'axios';
import UserModal from './UserModal';

export default function UsersTable() {
    
const [users, setUsers] = useState([]);
useEffect(() => {
    axios
        .all([
            axios.get('/api/auth/users'),                
        ])
        .then(axios.spread((userResponse) => {              
            setUsers(userResponse.data);
        }))
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}, []);
    return (
        <Grid item xs={12} sm={6} textAlign="center">
                       
                  
        <Box sx={{ margin: '15px' }}>
            <Box sx={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', margin: '15px' }}>
                <Typography
                    component="h1"
                    variant="h6"
                    color="inherit"
                    noWrap
                    sx={{ flexGrow: 1, margin: '10px' }}>
                    Liste des utilisateurs
                </Typography>
                <UserModal />
            </Box>


            <TableContainer component={Paper} sx={{width:'80%'}}> 
                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>ID</TableCell>
                            <TableCell align="right">Matricule</TableCell>
                            <TableCell align="right">Nom</TableCell>
                            <TableCell align="right">Prénom</TableCell>
                            <TableCell align="right">Email</TableCell>
                            <TableCell align="right">Téléphone</TableCell>
                            <TableCell align="right">Nom Utilisateur</TableCell>
                            
                            
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {users.map((users) => (
                            <TableRow
                                key={users.name}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                <TableCell component="th" scope="row">
                                    {users.id}
                                </TableCell>
                                
                                <TableCell align="right">{users.matricule}</TableCell>
                                <TableCell align="right">{users.nom}</TableCell>
                                <TableCell align="right">{users.prenom}</TableCell>
                                <TableCell align="right">{users.email}</TableCell>
                                <TableCell align="right">{users.telephone}</TableCell>
                                <TableCell align="right">{users.username}</TableCell>
                               
                                
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </Box>
        </Grid>
    );
}