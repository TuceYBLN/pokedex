import React from 'react';
import { Navbar, NavDropdown, Nav, Container } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import LanguageButton from "./LanguageButton";

function Header() {
        return (
          <div className="custom-navbar">
            <Navbar expand="lg" className="bg-body-tertiary">
              <Container>
                <Navbar.Brand href="#home">Pokédex</Navbar.Brand>
                   <LanguageButton />
              </Container>
            </Navbar>
            </div>
    );
}

export default Header;