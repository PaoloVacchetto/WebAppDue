import {Button, Container, Nav, Navbar} from "react-bootstrap";

function Navigation() {
    //const navigate = useNavigate();
    return (
        <>

            {/* -- NAVBAR -- */}

            <Navbar fixed="top" bg="primary" variant="dark">
                <Container fluid>
                    <Navbar.Brand style={{ cursor: 'pointer' }}  >Piano di Studi</Navbar.Brand>

                    <Nav>



                                <Button  variant='outline-light' size='sm' >Login</Button>


                    </Nav>

                </Container>
            </Navbar>
        </>
    );


}
export default Navigation;