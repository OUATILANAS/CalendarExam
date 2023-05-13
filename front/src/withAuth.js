import React from 'react';
import { Redirect } from 'react-router-dom';

const withAuth = (Component) => {
  return class extends React.Component {
    render() {
      const userToken = localStorage.getItem('userToken');
      if (userToken) {
        return <Component />;
      } else {
        return <Redirect to="/" />;
      }
    }
  };
};

export default withAuth;
