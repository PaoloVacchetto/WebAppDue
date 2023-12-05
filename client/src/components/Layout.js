import { Row } from "react-bootstrap";
import { Outlet } from "react-router-dom";
import Navigation from "./Navigation";

function Layout(props) {
    return (
        <>
            {/* -- NAVIGATION BAR -- */}
            <Row className = "g-0">
                <Navigation props={props}/>
            </Row>

            {/* -- BODY  -- */}
            <div className = "below-nav" id = "bg">
                <div>
                    <Outlet />
                </div>
            </div>
        </>
    )
};

export default Layout;