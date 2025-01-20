import Form from "react-bootstrap/Form";
import {useState} from "react";

function Searchbar({ searchQuery, setSearchQuery }) {
    const [inputValue, setInputValue] = useState(searchQuery);

    // Funktion zum Verarbeiten des Formular-Submit
    const handleSubmit = (event) => {
        event.preventDefault();
        setSearchQuery(inputValue);
    };

  return (
    <div className="content-padding">
      <Form onSubmit={handleSubmit}>
        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
          <Form.Control
            type="text"
            placeholder="Search"
            value={inputValue}
            onChange={(e) => setInputValue(e.target.value)}
            onKeyDown={(e) => {
                if (e.key === 'Enter') {
                    handleSubmit(e); // nur bei Enter wird es ausgefuehrt, um das rerendern bei jeder Tasteneingabe zu verhindern
                }
            }}
          />
        </Form.Group>
      </Form>
    </div>
  );
}

export default Searchbar;
