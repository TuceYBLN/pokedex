import React from "react";
import { Navbar, NavDropdown, Nav } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";

function LanguageButton({ currentLanguage, onChangeLanguage }) {
  const allLanguages = {
    DE: {
      image: `${process.env.PUBLIC_URL}/Bilder/Laender/deutschland.png`,
      label: "Deutsch",
    },
    EN: {
      image: `${process.env.PUBLIC_URL}/Bilder/Laender/vereinigtes-konigreich.png`,
      label: "English",
    },
    FR: {
      image: `${process.env.PUBLIC_URL}/Bilder/Laender/frankreich.png`,
      label: "Français",
    },
    KO: {
      image: `${process.env.PUBLIC_URL}/Bilder/Laender/sudkorea.png`,
      label: "한글",
    },
    JP: {
      image: `${process.env.PUBLIC_URL}/Bilder/Laender/japan.png`,
      label: "日本",
    },
    ZH: {
      image: `${process.env.PUBLIC_URL}/Bilder/Laender/china.png`,
      label: "中文",
    },
  };

  const currentLanguageDetails = Object.values(allLanguages).find(
    (lang) => lang.label === currentLanguage
  );

  return (
    <div className="custom-navbar">
      <Navbar.Collapse id="basic-navbar-nav" className="justify-content-end">
        <Nav>
          <NavDropdown
            title={
              <span>
                <img src={currentLanguageDetails.image} alt="Sprachenauswahl" />{" "}
                {currentLanguage}
              </span>
            }
            id="basic-nav-dropdown"
          >
            {Object.values(allLanguages).map((lang) => (
              <NavDropdown.Item
                key={lang.label}
                onClick={() => onChangeLanguage(lang.label)}
              >
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
