import React, { useState } from 'react';
import Button from '@mui/material/Button';
import axios from 'axios';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { Autocomplete } from '@mui/material';

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
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            bgcolor: 'white'
          }}
        >
          <Box sx={{ maxWidth: '100%', width: '100%', display: 'flex', justifyContent: 'center' }}>
            <Typography variant="h6" component="h5" sx={{
              color: 'primary.main',
              textTransform: 'uppercase',
              textAlign: 'center',
              marginTop: 3
            }}>
              Ajouter un Utilisateur
            </Typography>
          </Box>

          <Box component="form"
            noValidate
            sx={{ mt: 1, bgcolor: 'white', p: 3 }}>
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="matricule"
                  label="Matricule"
                  name="matricule"
                  value={formData.matricule}
                  onChange={handleInputChange}
                  autoFocus
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="nom"
                  label="Nom"
                  name="nom"
                  value={formData.nom}
                  onChange={handleInputChange}
                  autoComplete="off"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  margin="normal"
                  fullWidth
                  id="prenom"
                  label="Prénom"
                  name="prenom"
                  value={formData.prenom}
                  onChange={handleInputChange}
                  autoComplete="off"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="email"
                  label="Email"
                  name="email"
                  value={formData.email}
                  onChange={handleInputChange}
                  autoComplete="off"
                  multiline
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="telephone"
                  label="Téléphone"
                  name="telephone"
                  value={formData.telephone}
                  onChange={handleInputChange}
                  autoComplete="off"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
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
                />
              </Grid>
              <Grid item xs={12} sm={6}>
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
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <Autocomplete
                  margin="normal"
                  fullWidth
                  id="role"
                  label="Role"
                  name="role"
                  options={roles}
                  getOptionLabel={(option) => option?.label || ""}
                  renderInput={(params) => (
                    <TextField {...params} />
                  )}
                  value={formData.role}
                  onChange={(event, newValue) => {
                    setFormData({ ...formData, role: newValue ? newValue.label : '' });
                  }}
                />
              </Grid>
            </Grid>

            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
              onClick={handleAddUser}
            >
              Ajouter
            </Button>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}
