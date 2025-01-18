import React from 'react';
import { Navbar, Container } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import LanguageButton from "./LanguageButton";

function Header({currentLanguage, onChangeLanguage}) {
        return (
          <div className="custom-navbar">
            <Navbar expand="lg" className="bg-body-tertiary">
              <Container>
                <Navbar.Brand href="/"><img src={`${process.env.PUBLIC_URL}/Bilder/Other/pokeball.png`} alt="Pokeball"/> Pokédex</Navbar.Brand>
                   <LanguageButton currentLanguage={currentLanguage} onChangeLanguage={onChangeLanguage}/>
              </Container>
            </Navbar>
            </div>
    );
}

export default Header;