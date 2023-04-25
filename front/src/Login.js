import logo from './logo.svg';
import image1 from './img2.jpg';
import React, { useState } from 'react';
import './css/style.css';
import { FiEye, FiEyeOff } from 'react-icons/fi';

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [rememberMe, setRememberMe] = useState(true);
  const [showPassword, setShowPassword] = useState(false);

  function handleSubmit(e) {
    e.preventDefault();
    // Add code to handle login form submission
  }

  function togglePasswordVisibility() {
    setShowPassword(!showPassword);
  }

  return (
    <div className="img js-fullheight" style={{backgroundImage: `url(${image1})`, backgroundSize: 'cover', height: '100vh'}}>
      <section className="ftco-section overlay">
        <div className="container">
          <div className="row justify-content-center">
            <div className="col-md-6 text-center mb-5">
              <h2 className="heading-section">LOGIN</h2>
            </div>
          </div>
          <div className="row justify-content-center">
            <div className="col-md-6 col-lg-4">
              <div className="login-wrap p-0">
                <h3 className="mb-4 text-center">Have an account?</h3>
                <form onSubmit={handleSubmit} className="signin-form">
                  <div className="form-group">
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Username"
                      required
                      value={username}
                      onChange={(e) => setUsername(e.target.value)}
                    />
                  </div>
                  <div className="form-group">
                    <input
                      id="password-field"
                      type={showPassword ? 'text' : 'password'}
                      className="form-control"
                      placeholder="Password"
                      required
                      value={password}
                      onChange={(e) => setPassword(e.target.value)}
                    />
                    <span
                      onClick={togglePasswordVisibility}
                      className="field-icon toggle-password"
                    >
                      {showPassword ? <FiEyeOff /> : <FiEye />}
                    </span>
                  </div>
                  <div className="form-group">
                    <button type="submit" className="form-control btn submit px-3" style={{backgroundColor:"#294034"}}>
                      Sign In
                    </button>
                  </div>
                  <div className="form-group d-md-flex">
                    <div className="w-50">
                      <label className="checkbox-wrap checkbox-primary" style={{color:"#ffffff"}}>
                        Remember Me
                        <input
                          type="checkbox"
                          checked={rememberMe}
                          onChange={(e) => setRememberMe(e.target.checked)}
                        />
                        <span className="checkmark"  style={{backgroundColor:"#294034"}}></span>
                      </label>
                    </div>
                    <div className="w-50 text-md-right">
                      <a href="#" style={{ color: '#fff' }}>
                        Forgot Password
                      </a>
                    </div>
                  </div>
                </form>                
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}

export default Login;
