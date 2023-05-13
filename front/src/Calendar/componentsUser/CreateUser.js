import React, { useState } from 'react';
import Button from '@mui/material/Button';
import axios from 'axios';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { Autocomplete } from '@mui/material';
import UserModal from './UserModal';

const theme = createTheme();

export default function Contact() {
  const roles = [

    { label: 'admin', value: ["admin"] },
    { label: 'prof', value: ["prof"] },
    { label: 'etudiant', value: ["etudiant"] },
  ];

  const [formData, setFormData] = useState({
    matricule: '',
    nom: '',
    prenom: '',
    email: '',
    telephone: '',
    username: '',
    password: '',
    role: [],
  });

  const handleInputChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleAddUser = (e) => {
    e.preventDefault();
    console.log('Form Data:', formData);

    const rolesArray = [formData.role];

    axios
      .post('api/auth/create', {
        matricule: formData.matricule,
        nom: formData.nom,
        prenom: formData.prenom,
        email: formData.email,
        telephone: formData.telephone,
        username: formData.username,
        password: formData.password,
        role: rolesArray,
      })
      .then((response) => {
        console.log('Utilisateur ajouté avec succès:', response.data);

        setFormData({
          matricule: '',
          nom: '',
          prenom: '',
          email: '',
          telephone: '',
          username: '',
          password: '',
          role: '',

        });
        window.location.reload();
      })
      .catch((error) => {
        console.error('Error adding user:', error);
      });
  };
  return (
    <ThemeProvider theme={theme}>
      <Container component="main" maxWidth="sm">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 1,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            bgcolor: 'white',
            '@media (max-width: 600px)': {
              m: 0,
              height: '75px'

            }
          }}
        >
          <Box sx={{ maxWidth: '100%', width: '100%', display: 'flex', justifyContent: 'center' }}>
            <Typography variant="h6" component="h5" sx={{
              color: 'primary.main',
              textTransform: 'uppercase',
              textAlign: 'center',
              marginTop: 2
            }}>
              Ajouter un Utilisateur
            </Typography>
          </Box>
          <Box component="form"
            noValidate
            sx={{
              bgcolor: 'white',
              p: 2
            }}>
            <TextField
              margin="normal"
              required
              fullWidth
              id="matricule"
              label="Matricule"
              name="matricule"
              value={formData.matricule}
              onChange={handleInputChange}
              autoComplete="off"
              size="small"
            />
            <TextField
              margin="normal"
              fullWidth
              id="nom"
              label="Nom"
              name="nom"
              value={formData.nom}
              onChange={handleInputChange}
              autoComplete="off"
              size="small"

            />
            <TextField
              margin="normal"
              fullWidth
              id="prenom"
              label="Prénom"
              name="prenom"
              value={formData.prenom}
              onChange={handleInputChange}
              autoComplete="off"
              size="small"

            />

            <TextField
              margin="normal"
              required
              fullWidth
              id="email"
              label="Email"
              name="email"
              type="email"
              value={formData.email}
              onChange={handleInputChange}
              autoComplete="off"
              multiline
              size="small"

            />

            <TextField
              margin="normal"
              fullWidth
              id="telephone"
              label="Téléphone"
              name="telephone"
              value={formData.telephone}
              onChange={handleInputChange}
              autoComplete="off"
              size="small"

            />

            <TextField
              margin="normal"
              required
              fullWidth
              id="username"
              label="Utilisateur"
              name="username"
              value={formData.username}
              onChange={handleInputChange}
              autoComplete="off"
              size="small"

            />

            <TextField
              margin="normal"
              required
              fullWidth
              id="password"
              label="Mot de passe"
              name="password"
              type="password"
              value={formData.password}
              onChange={handleInputChange}
              autoComplete="off"
              size="small"

            />
            <Autocomplete
              margin="normal"
              required
              fullWidth
              id="role"
              label="Role"
              name="role"
              size="small"
              sx={{ mt: '10px' }}
              autoComplete="off"
              options={roles}
              getOptionLabel={(option) => option?.label || ""}
              renderInput={(params) => (
                <TextField {...params} inputProps={{ ...params.inputProps, placeholder: "Select a role" }} />
              )}
              value={formData.role} // Update this line
              onChange={(event, newValue) => {
                setFormData({ ...formData, role: newValue ? newValue.label : '' });
              }}
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 1 }}
              onClick={handleAddUser}
            >
              Ajouter
            </Button>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              
              sx={{ mt: 1, mb: 2 ,bgcolor:'grey'}}
              onClick={UserModal.handleClose}
            >
              Annuler
            </Button>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}
