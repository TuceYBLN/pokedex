import React, {useState} from 'react';
import { Navbar, NavDropdown, Nav, Container } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

function LanguageButton() {
    const allLanguages = {
        DE: {
            image: `${process.env.PUBLIC_URL}/Bilder/Laender/deutschland.png`,
            label: 'Deutsch'
        },
        EN: {
            image: `${process.env.PUBLIC_URL}/Bilder/Laender/vereinigtes-konigreich.png`,
            label: 'English'
        },
        KO: {
            image: `${process.env.PUBLIC_URL}/Bilder/Laender/sudkorea.png`,
            label: '한글'
        },
        JP: {
            image: `${process.env.PUBLIC_URL}/Bilder/Laender/japan.png`,
            label: '日本'
        },
        ZH: {
            image: `${process.env.PUBLIC_URL}/Bilder/Laender/china.png`,
            label: '中文'
        }
    };
    const[language, setLanguage] = useState('Deutsch');


    const currentLanguage = Object.values(allLanguages).find(lang => lang.label === language);

    const changeLanguage = (text) => {
        setLanguage(text);
    }

        return (
                 <div className="custom-navbar">
                     <Navbar.Collapse id="basic-navbar-nav" className="justify-content-end">
                         <Nav>
                             <NavDropdown title={<span><img src={currentLanguage.image} alt="Sprachenauswahl" /> {language}</span>} id="basic-nav-dropdown">
                                 {Object.values(allLanguages).map(lang => (
                                     <NavDropdown.Item key={lang.label} onClick={() => changeLanguage(lang.label)}>
                                         <img src={lang.image} alt="Sprache" /> {lang.label}
                                     </NavDropdown.Item>
                                 ))}
                             </NavDropdown>
                         </Nav>
                     </Navbar.Collapse>
                 </div>
             );
}

export default LanguageButton;