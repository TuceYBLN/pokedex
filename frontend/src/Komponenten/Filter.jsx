import Dropdown from "react-bootstrap/Dropdown";
import Form from "react-bootstrap/Form";
import React from "react";

function Filter({filters, setFilters}) {

    const handleSelect = (name) => (value) => {
        setFilters((prev) => ({
            ...prev,
            [name]: value,
        }));
    }

  return (
    <div className="content-padding filter-container">
      <Dropdown className="filter-component">
        <Dropdown.Toggle id="dropdown-autoclose-true"> {filters.region || "Region"}</Dropdown.Toggle>
          <Dropdown.Menu>
              <Dropdown.Item onClick={() => handleSelect('region')('Kanto')}>Kanto</Dropdown.Item>
              <Dropdown.Item onClick={() => handleSelect('region')('Johto')}>Johto</Dropdown.Item>
              <Dropdown.Item onClick={() => handleSelect('region')('Hoenn')}>Hoenn</Dropdown.Item>
          </Dropdown.Menu>
      </Dropdown>
      <Dropdown className="filter-component">
        <Dropdown.Toggle id="dropdown-autoclose-true">Types</Dropdown.Toggle>
        <Dropdown.Menu>
          <Dropdown.Item>Kanto</Dropdown.Item>
          <Dropdown.Item>Johto</Dropdown.Item>
          <Dropdown.Item>Hoenn</Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
      <Form>
        <Form.Check label="Shiny" />
        <Form.Check label="Owning" />
      </Form>
    </div>
  );
}

export default Filter;
