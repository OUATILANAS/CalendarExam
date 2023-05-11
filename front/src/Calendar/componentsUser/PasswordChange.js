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




export default function PasswordChanger() {
 
  return (
        <Container component="main" maxWidth="xs" style={{backgroundColor:'white',borderRadius:20 }}>
          <form >
            <div class="form-icon">
            <span><i class="icon icon-user"></i></span>
            </div>
            <div class="form-group">
                <Grid item xs={12} sm={6}>
                <TextField margin="normal" required fullWidth id="old_password" label="Password" name="Password" autoFocus/>
                </Grid>
            </div>
            <div class="form-group">
                <Grid item xs={12} sm={6}>
                <TextField margin="normal" required fullWidth id="nw_Password" label="New Password" name="nw_Password" autoFocus/>
                </Grid>
            </div>
            <div class="form-group">
                <Grid item xs={12} sm={6}>
                <TextField margin="normal" required fullWidth id="verifier_new_Password" label="Retype New password" name="verifier_new_Password" autoFocus/>
                </Grid>
            </div>
            <div class="form-group">
              <Button type="submit" fullWidth variant="contained" onClick={() => {}} sx={{ mt: 3, mb: 2 }}>Update Password </Button>
            </div>
            
        </form>
        </Container>
       
  );
}