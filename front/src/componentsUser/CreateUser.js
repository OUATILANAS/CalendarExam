import * as React from 'react';
import Button from '@mui/material/Button';
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
  const Roles = [
    { label: 'Professeur' },
    { label: 'Etudiant' },
  ];

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
              Ajouter Un Utilisateur
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
                  id="Matricule"
                  label="Matricule"
                  name="Matricule"
                  autoFocus
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="Nom"
                  label="Nom"
                  name="Nom"
                  autoComplete="Nom"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  margin="normal"

                  fullWidth
                  id="Prénom"
                  label="Prénom"
                  name="Prénom"
                  autoComplete="Prénom"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="email"
                  label="Email"
                  name="Email"
                  autoComplete="Email"
                  multiline
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="Téléphone"
                  label="Téléphone"
                  name="Téléphone"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="field6"
                  label="Utilisateur"
                  name="Utilisateur"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  margin="normal"
                  required
                  type='password'
                  fullWidth
                  id="field6"
                  label="Mot de passe"
                  name="Mot de passe"
                />
              </Grid>
              <Grid item xs={12} sm={6} sx={{ marginTop: "15px" }}>
                <Autocomplete
                  margin="normal"

                  required
                  fullWidth
                  disablePortal
                  id="combo-box-demo"
                  options={Roles}
                  renderInput={(params) => <TextField {...params} label="Role" />}
                />
              </Grid>

            </Grid>

            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Ajouter
            </Button>

          </Box>
        </Box>

      </Container>
    </ThemeProvider>
  );
}
