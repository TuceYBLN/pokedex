import React from 'react';
import { Navbar, NavDropdown, Nav, Container } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

function Header() {
        return (
            <Navbar expand="lg" className="bg-body-tertiary">
              <Container>
                <Navbar.Brand href="#home">Pokédex</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav" className="justify-content-end">
                  <Nav>
                    <NavDropdown title="Language" id="basic-nav-dropdown">
                      <NavDropdown.Item href="#action/3.1"><img src={process.env.PUBLIC_URL + "Bilder/Laender/deutschland.png"} alt="Logo" /> Deutsch</NavDropdown.Item>
                      <NavDropdown.Item href="#action/3.2">
                      <img src={process.env.PUBLIC_URL + "Bilder/Laender/vereinigtes-konigreich.png"} alt="Logo" /> English
                      </NavDropdown.Item>
                      <NavDropdown.Item href="#action/3.3"><img src={process.env.PUBLIC_URL + "Bilder/Laender/sudkorea.png"} alt="Logo" /> 한글</NavDropdown.Item>
                      <NavDropdown.Item href="#action/3.4"><img src={process.env.PUBLIC_URL + "Bilder/Laender/japan.png"} alt="Logo" /> 日本</NavDropdown.Item>
                      <NavDropdown.Item href="#action/3.5"><img src={process.env.PUBLIC_URL + "Bilder/Laender/china.png"} alt="Logo" /> 中文</NavDropdown.Item>
                    </NavDropdown>
                  </Nav>
                </Navbar.Collapse>
              </Container>
            </Navbar>
    );
}

export default Header;