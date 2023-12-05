import logo from './logo.svg';
import './css/App.css';
import './css/styles.css';
import './css/custom.css';

import { BrowserRouter as Router, Routes, Route, useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import Layout from './components/Layout'
import LoginPage from "./login/LoginPage";
import Home from './components/home';
import {useState} from "react";


function App() {
  return (
    <Router>
      <App2 />
    </Router>
  );
}

function App2(){

    const [loggedIn, setLoggedIn] = useState(true)



  return(
      <>
          <Routes>
              <Route element={<Layout loggedIn={loggedIn}></Layout>}>
                  <Route path='/' element={loggedIn ? <Home></Home> : <LoginPage></LoginPage> }/>



              </Route>
          </Routes>
      </>
  )
}

export default App;
