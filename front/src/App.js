
import './App.css';

import ResponsiveAppBar from './Calendar/static/header';
import { Route, Routes } from 'react-router-dom';
import UsersTable from './Calendar/componentsUser/Users';
import Footer from './Calendar/static/Footer';
import ProfileUser from './Calendar/componentsUser/Profile_details';



function App() {
  return (
    <div>
    <ResponsiveAppBar />
    <Routes>

      <Route extract path='/staff' element={<UsersTable />} />
      <Route extract path='/Profile' element={<ProfileUser />} />
     
      
    </Routes>
    <Footer />
  </div>
  );
}

export default App;
