import ProgressBar from "react-bootstrap/ProgressBar";
import { useState, useEffect } from "react";

function Progress({pokemon}) {
  const [kanto, setKanto] = useState();
  const[johto, setJohto] = useState(0);
  const[hoenn, setHoenn] = useState(0);
  const[shiny, setShiny] = useState(0);

  const countPoke = (setCount) =>{
    
  }

  useEffect(() => {
    if (Array.isArray(pokemon)) {
      const kantoCount = pokemon.filter(
        (poke) => poke.region === "Kanto" && poke.owned
      ).length;
      setKanto(kantoCount);
    }
    if (Array.isArray(pokemon)) {
      const johtoCount = pokemon.filter(
        (poke) => poke.region === "Johto" && poke.owned
      ).length;
      setJohto(johtoCount);
    }
  }, [pokemon]);

  return (
    <div className="content-padding">
      <h4>Kanto: {kanto}</h4>
      <ProgressBar variant="success" now={(kanto / 150) * 100} />
      <h4>Johto {johto}</h4>
      <ProgressBar variant="info" now={(johto / 150) * 100} />
      <h4>Hoenn</h4>
      <ProgressBar variant="danger" now={80} />
      <h4>Shiny</h4>
      <ProgressBar variant="warning" now={60} />
    </div>
  );
}

export default Progress;
