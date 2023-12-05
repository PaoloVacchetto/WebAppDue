import {Button, Container, Nav, Navbar} from "react-bootstrap";

function Navigation(props) {
    //const navigate = useNavigate();
    return (
        <>

            {/* -- NAVBAR -- */}

            <Navbar fixed="top" bg="primary" variant="dark">
                <Container fluid>
                    <Navbar.Brand style={{ cursor: 'pointer' }} >Ticketing service</Navbar.Brand>

                    <Nav>

                        {props.loggedIn === true  ?  <Button  variant='outline-light' size='sm' >Login</Button> : null   }
                    </Nav>

                </Container>
            </Navbar>
        </>
    );


}
export default Navigation;