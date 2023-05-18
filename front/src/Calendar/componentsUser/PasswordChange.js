import React, { useState } from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Container from '@mui/material/Container';
import axios from 'axios';

export default function PasswordChanger() {
  const [oldPassword, setOldPassword] = useState('');
  const [newPassword, setNewPassword] = useState('');
  const [verifyPassword, setVerifyPassword] = useState('');

  const handlePasswordUpdate = async (e) => {
    e.preventDefault();

    if (newPassword !== verifyPassword) {
      console.error('New password and verify password do not match');
      return;
    }

    const user_id = "102";

    try {
      const response = await axios.put(`/api/auth/users/${user_id}/password`, {
        oldPassword: oldPassword,
        newPassword: newPassword,
      });

      if (response.status === 200) {
        console.log('Password updated successfully');
        // Clear input fields or perform any additional actions after successful update
      } else {
        console.error('Failed to update password');
      }
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <Container component="main" maxWidth="xs" style={{ backgroundColor: 'white', borderRadius: 20, marginTop: 30 }}>
      <form onSubmit={handlePasswordUpdate}>
        <div className="form-icon">
          <span><i className="icon icon-user"></i></span>
        </div>
        <div className="form-group">
          <Grid item xs={12} sm={6}>
            <TextField margin="normal" required fullWidth id="old_password" label="Password" name="Password" autoFocus value={oldPassword} onChange={(e) => setOldPassword(e.target.value)} />
          </Grid>
        </div>
        <div className="form-group">
          <Grid item xs={12} sm={6}>
            <TextField margin="normal" required fullWidth id="nw_Password" label="New Password" name="nw_Password" autoFocus value={newPassword} onChange={(e) => setNewPassword(e.target.value)} />
          </Grid>
        </div>
        <div className="form-group">
          <Grid item xs={12} sm={6}>
            <TextField margin="normal" required fullWidth id="verifier_new_Password" label="Retype New password" name="verifier_new_Password" autoFocus value={verifyPassword} onChange={(e) => setVerifyPassword(e.target.value)} />
          </Grid>
        </div>
        <div className="form-group">
          <Button type="submit" fullWidth variant="contained" sx={{ mt: 3, mb: 2 }}>Update Password</Button>
        </div>
      </form>
    </Container>
  );
}
