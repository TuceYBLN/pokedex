import ProgressBar from "react-bootstrap/ProgressBar";
import { useState, useEffect } from "react";

function Progress({pokemon}) {
  const [kanto, setKanto] = useState();
  const[johto, setJohto] = useState();
  const[hoenn, setHoenn] = useState();
  const[shiny, setShiny] = useState();

  const countRegion = (pokemonArray, region) => {
    if (Array.isArray(pokemonArray)) {
      return pokemonArray.filter(poke => poke.region == region).length;
    }
  }

  const countShiny = (pokemonArray) => {
    if (Array.isArray(pokemonArray)) {
      return pokemonArray.filter(poke => poke.shiny).length;
    }
  }

  const countPokeRegion = (setCount, region) =>{
    if (Array.isArray(pokemon)) {
      const count = pokemon.filter(
        (poke) => poke.region === region && poke.owned
      ).length;
      setCount(count);
    }
  }

  const countPokeShiny = (setCount) =>{
    if (Array.isArray(pokemon)) {
      const count = pokemon.filter(
        (poke) => poke.shiny && poke.owned
      ).length;
      setCount(count);
    }
  }

  const totalKanto = countRegion(pokemon, "Kanto");
  const totalJohto = countRegion(pokemon, "Johto");
  const totalHoenn = countRegion(pokemon, "Hoenn");
  const totalShiny = countShiny(pokemon);

  useEffect(() => {
    countPokeRegion(setKanto, "Kanto");
    countPokeRegion(setJohto, "Johto");
    countPokeRegion(setHoenn, "Hoenn");
    countPokeShiny(setShiny);
  }, [pokemon]);

  return (
    <div className="content-padding">
      <h4>Kanto: {kanto}/{totalKanto}</h4>
      <ProgressBar variant="success" now={kanto/totalKanto*100} />
      <h4>Johto {johto}/{totalJohto}</h4>
      <ProgressBar variant="info" now={johto/totalJohto*100} />
      <h4>Hoenn {hoenn}/{totalHoenn}</h4>
      <ProgressBar variant="danger" now={hoenn/totalHoenn*100} />
      <h4>Shiny {shiny}/{totalShiny}</h4>
      <ProgressBar variant="warning" now={shiny/totalShiny*100} />
    </div>
  );
}

export default Progress;
