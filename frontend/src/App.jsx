import React, { useState, useEffect } from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./Komponenten/Header";
import Searchbar from "./Komponenten/Searchbar";
import Progress from "./Komponenten/Progress";
import PokeCard from "./Komponenten/PokeCard";
import axios from "axios";

function App() {
  const [message, setMessage] = useState([]);
  const [language, setLanguage] = useState("Deutsch");
  const [caughtStatus, setCaughtStatus] = useState({});
  const [loading, setLoading] = useState(true);

  const changeLanguage = (text) => {
    setLanguage(text);
  };

  const getData = async () => {
    try {
      const response = await axios.get("http://localhost:8080/pokedata");
      setMessage(response.data);
      //uberprueft ob owned false ist -> wenn nicht, dann wird caught auf true gesetzt
      const initialCaughtStatus = {};
      response.data.forEach((pokevariant) => {
        initialCaughtStatus[pokevariant.id] = pokevariant.owned;
      });
      setCaughtStatus(initialCaughtStatus);
    } catch (error) {
      console.error("Fetching error: ", error);
    } finally {
      setLoading(false);
    }
  };

  const handleToggle = async (variantId) => {
    setCaughtStatus((prev) => {
      const newCaughtStatus = { ...prev, [variantId]: !prev[variantId] };
      return newCaughtStatus;
    });

    const variantIdForPokeOwner = { id: variantId };

    postOwner(variantIdForPokeOwner);
  };

  const postOwner = async (data) => {
    try {
      const response = await axios.post("http://localhost:8080/owner", data);
      console.log("Owner gesetzt:", response.data);
    } catch (error) {
      console.error("Fetching error:", error);
    }
  };

  useEffect(() => {
    getData();
  }, []);

  if (loading) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <Header currentLanguage={language} onChangeLanguage={changeLanguage} />
      <Searchbar />
      <Progress pokemon={message} />
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
          switch (language) {
            case "Deutsch":
              name = pokevariant.nameDe;
              break;
            case "English":
              name = pokevariant.nameEn;
              break;
            case "Français":
              name = pokevariant.nameFr;
              break;
            case "한글":
              name = pokevariant.nameKr;
              break;
            case "日本":
              name = pokevariant.nameJa;
              break;
            case "中文":
              name = pokevariant.nameZh;
              break;
            default:
              console.log("Sorry wanted language not available.");
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
              caught={caughtStatus[pokevariant.id]}
              handleToggle={() => handleToggle(pokevariant.id)}
            />
          );
        })}
      </div>
    </div>
  );
}

export default App;
