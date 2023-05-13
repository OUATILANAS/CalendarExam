import * as React from 'react';
import Button from '@mui/material/Button';
import Modal from '@mui/material/Modal';
import Contact from './recclamationForm';


export default function BasicModal() {
  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <div>
      <Button sx={{ color: 'black', borderWidth: '1px', borderColor: 'black', borderRadius: '15px', borderStyle: 'solid', margin: '15px' }} onClick={handleOpen}>Envoyer une recclamation</Button>

      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Contact />
      </Modal>
    </div>
  );
}
