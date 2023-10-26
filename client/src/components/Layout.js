import { Row } from "react-bootstrap";
import { Outlet } from "react-router-dom";
import Navigation from "./Navigation";

function Layout() {
    return (
        <>
            {/* -- NAVIGATION BAR -- */}
            <Row className = "g-0">
                <Navigation />
            </Row>

            {/* -- BODY  -- */}
            <div className = "row gx-0" id = "bg">
                <div className = "row gx-0">
                    <Outlet />
                </div>
            </div>
        </>
    )
};

export default Layout;