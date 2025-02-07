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
    region: "",
    type: "",
    owned: "",
    shiny: "",
  });

  // Sprache setzen
  const changeLanguage = (text) => {
    setLanguage(text);
  };

  // Pokedaten fetchen
  const getData = async () => {
    try {
      const response = await axios.get("http://localhost:8090/pokedata");
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
      // Loading zuruecksetzen
      setLoading(false);
    }
  };

  // setzt caughtStatus und bereitet POST-Request vor
  const handleToggle = async (variantId) => {
    setCaughtStatus((prev) => {
      return { ...prev, [variantId]: !prev[variantId] };
    });

    const variantIdForPokeOwner = { id: variantId };
    await postOwner(variantIdForPokeOwner);
  };

  // POST-Request fuer "is_owned"-Wert
  const postOwner = async (data) => {
    try {
      const response = await axios.post("http://localhost:8090/owner", data);
      console.log("Owner gesetzt:", response.data);
      getData();
    } catch (error) {
      console.error("Fetching error:", error);
    }
  };

  // Daten fetchen mit axios
  useEffect(() => {
    getData();
  }, []);

  // Laden-Komponente ausfuehren, wenn loading = true
  if (loading) {
    return (
      <div>
        <Loading />
      </div>
    );
  }

  // Anzahl der shiny-Pokémon im Besitz und insgesamt
  const caughtShinyCount = message.filter(
    (poke) => poke.shiny && caughtStatus[poke.id]
  ).length;
  const shinyTotalCount = message.filter((poke) => poke.shiny).length;
  // alle Types der POKE_VARIANT-Types in einem Array umwandeln fuer Dropdown
  const pokeTypes = Array.from(new Set(message.flatMap((poke) => poke.types)));

  /**
   * sucht nach einem Match der Such-Filtereingabe
   * zuerst alles kleingeschrieben fuer Vergleich und
   * dann wird mit include gesucht statt nach einem 100% Match zu suchen
   * @param {Array} message - Array der Pokémon-Daten
   * @returns {Array} - gefilterte Pokémon-Daten basierend auf Suchleiste oder Filterung
   */
  const filteredMessage = message.filter((pokevariant) => {
    const searchQueryResult =
      pokevariant.nameDe.toLowerCase().includes(searchQuery.toLowerCase()) ||
      pokevariant.nameEn.toLowerCase().includes(searchQuery.toLowerCase()) ||
      pokevariant.nameFr.toLowerCase().includes(searchQuery.toLowerCase()) ||
      pokevariant.nameKr.toLowerCase().includes(searchQuery.toLowerCase()) ||
      pokevariant.nameJa.toLowerCase().includes(searchQuery.toLowerCase()) ||
      pokevariant.nameZh.toLowerCase().includes(searchQuery.toLowerCase());

    const regionResult =
      !filters.region || pokevariant.region === filters.region;
    const shinyResult = !filters.shiny || pokevariant.shiny === filters.shiny;
    const ownedResult = !filters.owned || pokevariant.owned === filters.owned;
    const typesResult =
      !filters.types || pokevariant.types.includes(filters.types);

    return (
      searchQueryResult &&
      regionResult &&
      shinyResult &&
      ownedResult &&
      typesResult
    );
  });

  /**
   * Basierend auf die ausgewaehlte Sprache wird der Name ausgegeben.
   * @param {Object} pokevariant - Zu untersuchende Pokévarianten nach GET-Request und Such-Filteroperationen.
   * @returns {string} - Name des Pokémons basierend auf die Sprache.
   */
  const getPokemonNameBasedOnLanguage = (pokevariant) => {
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
    return name;
  };

  return (
    <div>
      <Header currentLanguage={language} onChangeLanguage={changeLanguage} />
      <Searchbar searchQuery={searchQuery} setSearchQuery={setSearchQuery} />
      <Filter filters={filters} setFilters={setFilters} pokeTypes={pokeTypes} />
      <Progress shinyCount={caughtShinyCount} shinyTotal={shinyTotalCount} />
      <div className="content-padding pokecard-container">
        {filteredMessage.map((pokevariant, index) => {
          let name = getPokemonNameBasedOnLanguage(pokevariant);
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
