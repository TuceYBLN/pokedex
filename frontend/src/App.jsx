import React, { useState, useEffect } from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./Komponenten/Header";
import Searchbar from "./Komponenten/Searchbar";
import PokeCard from "./Komponenten/PokeCard";
import axios from "axios";

function App() {
  const [message, setMessage] = useState([]);
  const [language, setLanguage] = useState("Deutsch");

  const changeLanguage = (text) => {
    setLanguage(text);
  };

  const getData = async () => {
    try {
      const response = await axios.get("http://localhost:8080/pokedata");
      setMessage(response.data);
    } catch (error) {
      console.error("Fetching error: ", error);
    }
  };

  useEffect(() => {
    getData();
  }, []);

  return (
    <div>
      <Header currentLanguage={language} onChangeLanguage={changeLanguage}/>
      <Searchbar />
      <div
        style={{
          display: "grid",
          gridTemplateColumns: "repeat(auto-fill, minmax(280px, 1fr))",
          gap: "10px",
        }}
        className="content-padding"
      >
        {message.map((pokevariant, index) => {
        let name;
        switch(language){
        case 'Deutsch':
            name = pokevariant.nameDe;
            break;
        case 'English':
            name = pokevariant.nameEn;
            break;
        case 'Français':
            name = pokevariant.nameFr;
            break;
        case '한글':
            name = pokevariant.nameKr;
            break;
        case '日本':
                    name = pokevariant.nameJa;
                    break;
        case '中文':
                    name = pokevariant.nameZh;
                    break;
        }
          return (
            <PokeCard
              key={index}
              image={pokevariant.image}
              id={pokevariant.dex}
              variant={pokevariant.variant}
              shiny={pokevariant.shiny}
              region={pokevariant.region}
              family={pokevariant.family}
              name={name}
            />
          );
        })}
      </div>
    </div>
  );
}

export default App;
