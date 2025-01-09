import React, { useState, useEffect } from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./Komponenten/Header";
import Searchbar from "./Komponenten/Searchbar";
import PokeCard from "./Komponenten/PokeCard";
import imageFilenames from "./imageList.js";
import axios from "axios";

function App() {
  const [message, setMessage] = useState([]);

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
      <Header />
      <Searchbar />
      <div
        style={{
          display: "grid",
          gridTemplateColumns: "repeat(auto-fill, minmax(280px, 1fr))",
          gap: "10px",
        }}
        className="content-padding"
      >
        {imageFilenames.map((filename, index) => {
          const dexID = filename.match(/pokemon_icon_(\d{3})/);
          const type = filename.match(/pokemon_icon_\d{3}_(\d{2}(?:_\d{2})?)/);
          const shiny = filename.match(
            /pokemon_icon_\d{3}_(\d{2}(?:_\d{2})?)_(shiny)/
          );
          return (
            <PokeCard
              key={index}
              image={filename}
              id={dexID ? dexID[1] : ""}
              type={type ? type[1] : ""}
              shiny={shiny ? shiny[1] : ""}
            />
          );
        })}
      </div>
      <ul>
      <h1>TEST</h1>
        {message.map((item, index) => (
          <li key={index}>
            ID: {item.id}, Types: {item.image}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
