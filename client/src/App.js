import logo from './logo.svg';
import './App.css';
import Home from './components/home';
import { BrowserRouter as Router, Routes, Route, useNavigate } from 'react-router-dom';
import {Container, Row} from "react-bootstrap";
import MyNavbar from "./components/navbar";

function App() {
  return (
    <Router>
      <App2 />
    </Router>
  );
}

function App2(){
  return(
      <>
          <MyNavbar></MyNavbar>
          <Container fluid>
              <Row className='vheight-100'>
                  <Routes>
                      <Route path='/' element={<Home> </Home>} />

                  </Routes>


              </Row>
          </Container>
      </>
  )
}

export default App;
