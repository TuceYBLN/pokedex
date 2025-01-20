import Dropdown from "react-bootstrap/Dropdown";
import Form from "react-bootstrap/Form";
import React from "react";

function Filter({ filters, setFilters, pokeTypes }) {
  // Aktualisieren der Ausgabe-Ergebnisse basierend auf Filter
  const handleSelect = (name) => (value) => {
    setFilters((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  // Region-Dropdown rendern und Ausfuehren von handleSelect je nach Eingabe
  const filterRegionRendern = () => {
    const regions = ["Kanto", "Johto", "Hoenn"];
    return (
      <>
        {regions.map((region) => (
          <Dropdown.Item
            key={region}
            onClick={() => handleSelect("region")(region)}
          >
            {region || "Region"}
          </Dropdown.Item>
        ))}
      </>
    );
  };

  // Types-Dropdown rendern und Ausfuehren von handleSelect je nach Eingabe
  const filterTypesRendern = () => {
    return (
      <>
        {pokeTypes.map((types, index) => (
          <Dropdown.Item
            key={index}
            onClick={() => handleSelect("types")(types)}
          >
            {types}
          </Dropdown.Item>
        ))}
      </>
    );
  };

  return (
    <div className="content-padding filter-container">
      <Dropdown className="filter-component">
        <Dropdown.Toggle id="dropdown-autoclose-true">
          {filters.region || "Region"}
        </Dropdown.Toggle>
        <Dropdown.Menu>
          <Dropdown.Item onClick={() => handleSelect("region")("")}>
            Region
          </Dropdown.Item>
          <Dropdown.Divider />
          {filterRegionRendern()}
        </Dropdown.Menu>
      </Dropdown>

      <Dropdown className="filter-component">
        <Dropdown.Toggle id="dropdown-autoclose-true">
          {filters.types || "Types"}
        </Dropdown.Toggle>
        <Dropdown.Menu className="dropdown-component">
          <Dropdown.Item onClick={() => handleSelect("types")("")}>
            Types
          </Dropdown.Item>
          <Dropdown.Divider />
          {filterTypesRendern()}
        </Dropdown.Menu>
      </Dropdown>

      <Form>
        <Form.Check
          type="checkbox"
          label="Shiny"
          onClick={(e) => handleSelect("shiny")(e.target.checked)}
        />

        <Form.Check
          type="checkbox"
          label="Owning"
          onClick={(e) => handleSelect("owned")(e.target.checked)}
        />
      </Form>
    </div>
  );
}

export default Filter;
