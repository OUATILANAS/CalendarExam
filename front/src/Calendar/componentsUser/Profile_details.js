import React from 'react';
import '../../css/bootstrap.min.css'
import '../../css/profile_details.css'
import Modal from '@mui/material/Modal';
import PasswordChanger from './PasswordChange';
import { TextField } from '@mui/material';



export default function ProfileUser() {

      const [open, setOpen] = React.useState(false);
      const handleOpen = () => setOpen(true);
      const handleClose = () => setOpen(false);

  return (
          
      <div class="container" style={{marginTop:200}}>
        <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description">
                <PasswordChanger/>
        </Modal>
        <div class="row ">
          <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12 ">
            <div class="card h-100">
              <div class="card-body mt-5">
                <div class="account-settings">
                  <div class="user-profile">
                    <div class="user-avatar">
                      <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="profile"/>
                    </div>
                    <h5 class="user-name" style={{color:'white'}}>Yuki Hayashi</h5>
                    <h6 class="user-email">profile@profile.com</h6>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
            <div class="card h-100">
              <div class="card-body">
                <div class="row gutters" >
                  <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <h6 class="mb-3 text-primary" style={{textAlign:'left'}}>Personal Details</h6>
                  </div>
                  <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <div class="form-group" style={{textAlign:'left'}}>
                        <label for="eMail">Nom</label><br/>
                        <TextField id="nom" defaultValue="Entre votre name" variant="standard"
                        InputProps={{
                          readOnly: true,
                          style: { color: 'white' }
                        }}/>
                    </div>
                  </div>
                  <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <div class="form-group">
                      <label for="email" style={{ fontWeight: 'bold' }}>Email</label><br/>
                      <TextField id="email" defaultValue="Entre votre email" variant="standard"
                        InputProps={{
                          readOnly: true,
                          style: { color: 'white' }
                        }}/>
                    </div>
                  </div>
                  <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <div class="form-group">
                      <label for="phone">Prenom</label><br/>
                      <TextField id="prenom" defaultValue="Entre votre prenom" variant="standard" 
                        InputProps={{
                          readOnly: true,
                          style: { color: 'white' }
                        }}/>
                    </div>
                  </div>
                  <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <div class="form-group">
                      <label for="website">Telephone</label><br/>
                      <TextField id="telephone" defaultValue="Entre votre telephone" variant="standard" 
                        InputProps={{
                          readOnly: true,
                          style: { color: 'white' }
                        }}/>
                    </div>
                  </div>
                </div>
                <div class="row gutters">
                  <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <div class="form-group">
                      <label for="Street">Matricule</label><br/>
                      <TextField id="matricule" defaultValue="Entre votre Matricule" variant="standard" 
                        InputProps={{
                          readOnly: true,
                          style: { color: 'white' }
                        }}/>
                    </div>
                  </div>
               
                  <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <div class="form-group">
                      <label for="filiere">Filiere</label><br/>
                      <TextField id="filiere" defaultValue="Entre votre filiere" variant="standard" 
                      InputProps={{
                          readOnly: true,
                          style: { color: 'white' }
                        }}
                          
                        />
                    </div>
                  </div>
                </div>
                <div class="row gutters">
                  <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="text-right">
                      <button type="button" id="submit" onClick={handleOpen} name="submit" class="btn btn-primary">Changer Password</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
  );
}
