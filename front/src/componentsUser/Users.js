import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { Box, Typography } from '@mui/material';

import UserModal from './UserModal';


function createData(id, matricule, lastname, name, email, phone, username, password, role) {
    return { id, matricule, lastname, name, email, phone, username, password, role };
}

const rows = [
    createData(1, 'M1234', 'Naciri', 'Zineb', 'zineb@gmail.com', '0661616161', 'USERNAME', 'PWD', 'student'),
    createData(2, 'M1235', 'Najahi', 'Ahlam', 'ahlam@gmail.com', '0661616161', 'USERNAME', 'PWD', 'teacher'),
    createData(3, 'M1236', 'Ouatil', 'Anas', 'anas@gmail.com', '0661616161', 'USERNAME', 'PWD', 'student'),
    createData(4, 'M1237', 'Ounair', 'Zineb', 'ounair@gmail.com', '0661616161', 'USERNAME', 'PWD', 'student'),
    createData(5, 'M1238', 'Nejmeddine', 'Abdellah', 'nejm@gmail.com', '0661616161', 'USERNAME', 'PWD', 'teacher'),
];

export default function UsersTable() {
    return (
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


            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>ID</TableCell>
                            <TableCell align="right">Matricule</TableCell>
                            <TableCell align="right">Nom</TableCell>
                            <TableCell align="right">Prénom</TableCell>
                            <TableCell align="right">Email</TableCell>
                            <TableCell align="right">Téléphone</TableCell>
                            <TableCell align="right">Utilisateur</TableCell>
                            <TableCell align="right">Mot de passe</TableCell>
                            <TableCell align="right">Role</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {rows.map((row) => (
                            <TableRow
                                key={row.name}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                <TableCell component="th" scope="row">
                                    {row.id}
                                </TableCell>

                                <TableCell align="right">{row.matricule}</TableCell>
                                <TableCell align="right">{row.lastname}</TableCell>
                                <TableCell align="right">{row.name}</TableCell>
                                <TableCell align="right">{row.email}</TableCell>
                                <TableCell align="right">{row.phone}</TableCell>
                                <TableCell align="right">{row.username}</TableCell>
                                <TableCell align="right">{row.password}</TableCell>
                                <TableCell align="right">{row.role}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </Box>
    );
}