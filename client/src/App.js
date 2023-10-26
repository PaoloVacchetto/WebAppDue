import logo from './logo.svg';
import './css/App.css';
import './css/styles.css';

import { BrowserRouter as Router, Routes, Route, useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import Layout from './components/Layout'
import Home from './components/home';


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
          <Routes>
              <Route element={<Layout></Layout>}>
                  <Route path='/' element={<Home></Home>}></Route>


              </Route>
          </Routes>
      </>
  )
}

export default App;
