import React, { useState, useEffect } from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./Komponenten/Header";
import Searchbar from "./Komponenten/Searchbar";
import Progress from "./Komponenten/Progress";
import PokeCard from "./Komponenten/PokeCard";
import Filter from "./Komponenten/Filter";
import Loading from "./Komponenten/Loading";
import axios from "axios";

function App() {
  const [message, setMessage] = useState([]);
  const [language, setLanguage] = useState("Deutsch");
  const [caughtStatus, setCaughtStatus] = useState({});
  const [loading, setLoading] = useState(true);
  const [searchQuery, setSearchQuery] = useState("");
  const [filters, setFilters] = useState({
    region: '',
    type: '',
    owned: '',
    shiny: ''
  })

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
      return  { ...prev, [variantId]: !prev[variantId] };
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
    return <div><Loading /></div>;
  }

  const caughtShinyCount = message.filter(poke => poke.shiny && caughtStatus[poke.id]).length;
  const shinyTotalCount = message.filter(poke => poke.shiny).length;
  const pokeTypes = Array.from(
      new Set(message.flatMap(poke => poke.types))
  );

  // sucht nach einem Match - zuerst alles kleingeschrieben fuer Vergleich und dann wird mit include gesucht statt nach einem 100% Match zu suchen
  const filteredMessage = message.filter((pokevariant) => {
    const searchQueryResult =
        pokevariant.nameDe.toLowerCase().includes(searchQuery.toLowerCase()) ||
        pokevariant.nameEn.toLowerCase().includes(searchQuery.toLowerCase()) ||
        pokevariant.nameFr.toLowerCase().includes(searchQuery.toLowerCase()) ||
        pokevariant.nameKr.toLowerCase().includes(searchQuery.toLowerCase()) ||
        pokevariant.nameJa.toLowerCase().includes(searchQuery.toLowerCase()) ||
        pokevariant.nameZh.toLowerCase().includes(searchQuery.toLowerCase());

    const regionResult = !filters.region || pokevariant.region === filters.region;
    const shinyResult = !filters.shiny || pokevariant.shiny === filters.shiny;
    const ownedResult = !filters.owned || pokevariant.owned === filters.owned;
    const typesResult = !filters.types || pokevariant.types.includes(filters.types);

    return searchQueryResult && regionResult && shinyResult && ownedResult && typesResult;
  });

  return (
    <div>
      <Header currentLanguage={language} onChangeLanguage={changeLanguage} />
      <Searchbar searchQuery={searchQuery} setSearchQuery={setSearchQuery}/>
        <Filter filters={filters} setFilters={setFilters} pokeTypes={pokeTypes}/>
      <Progress shinyCount={caughtShinyCount} shinyTotal={shinyTotalCount}/>
      <div
        className="content-padding pokecard-container"
      >
        {filteredMessage.map((pokevariant, index) => {
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
              types={pokevariant.types}
              handleToggle={() => handleToggle(pokevariant.id)}
            />
          );
        })}
      </div>
    </div>
  );
}

export default App;
