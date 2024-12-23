import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './Komponenten/Header';
import Searchbar from './Komponenten/Searchbar';
import PokeCard from './Komponenten/PokeCard';
import imageFilenames from "./imageList.js";

function App() {
  const uniqueNumbers = new Set();

  return (
    <div>
      <Header />
      <Searchbar />
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(280px, 1fr))', gap: '10px' }} className="content-padding">
      {imageFilenames.map((filename, index) => {
        const dexID = filename.match(/pokemon_icon_(\d{3})/);
        const type = filename.match(/pokemon_icon_\d{3}_(\d{2}(?:_\d{2})?)/);
        const shiny = filename.match(/pokemon_icon_\d{3}_(\d{2}(?:_\d{2})?)_(shiny)/);

        return(
      <PokeCard key={index} picture={"Bilder/Pokemon/pokemon_icon_001_00.png"} image={filename} id={dexID[1]} type={type[1]} shiny={shiny}/>
        )

})}
      </div>
    </div>
  );
}

export default App;
