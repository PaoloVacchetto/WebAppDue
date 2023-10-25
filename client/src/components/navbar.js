import {useNavigate} from "react-router-dom";
import {Container, Nav, Navbar} from "react-bootstrap";

function MyNavbar() {
    const navigate = useNavigate();
    return(
        <Navbar fixed="top" bg="primary" variant="dark">
            <Container fluid>
                <Nav>
                    <Navbar.Brand>Welcome </Navbar.Brand>

                </Nav>
            </Container>
        </Navbar>
    )
}
export default MyNavbar;