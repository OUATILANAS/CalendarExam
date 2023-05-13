
import './App.css';

import ResponsiveAppBar from './Calendar/static/header';
import { Route, Routes } from 'react-router-dom';
import UsersTable from './Calendar/componentsUser/Users';
import Footer from './Calendar/static/Footer';
import ProfileUser from './Calendar/componentsUser/Profile_details';
import Calendar from './Calendar/calendar';

import Login from './Login';

function App() {
  return (
    <div className="App">
      
    <Calendar />
    
  </div>
  );
}

export default App;
