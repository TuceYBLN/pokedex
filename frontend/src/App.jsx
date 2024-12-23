import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './Komponenten/Header';
import Suchleiste from './Komponenten/Suchleiste';
import PokeCard from './Komponenten/PokeCard';
import imageFilenames from "./imageList.js";

function App() {
  const uniqueNumbers = new Set();

  return (
    <div>
      <Header />
      <Suchleiste />
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(400px, 1fr))', gap: '10px' }} className="content-padding">
      {imageFilenames.map((filename, index) => {
        const dexID = filename.match(/pokemon_icon_(\d{3})/);
        const type = filename.match(/pokemon_icon_\d{3}_(\d{2}(?:_\d{2})?)/);

        return(
      <PokeCard key={index} picture={"Bilder/Pokemon/pokemon_icon_001_00.png"} image={filename} id={dexID[1]} type={type[1]}/>
        )
})}
      </div>
    </div>
  );
}

export default App;
