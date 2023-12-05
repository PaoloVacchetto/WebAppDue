import './LoginPage.css';
import 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Button, Col, Container, Form, Row} from "react-bootstrap";

function LoginPage() {
    return (
        <Container id="container_login">
            <Row className="container-md" id="row">

                <Col className="justify-content-md-center container-md" id="col">
                    <Form id="form">
                        <Form.Group id="email">
                            <Form.Label>Email Address</Form.Label>
                            <Form.Control type="email" placeholder="Enter e-mail"/>
                        </Form.Group>
                        <Form.Group id="password">
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" placeholder="Password" />
                        </Form.Group>
                        <div id="button_div">
                            <Button type="Submit" id="login_button">Login</Button>
                        </div>

                    </Form>
                </Col>

            </Row>
        </Container>
    )
}

export default LoginPage;