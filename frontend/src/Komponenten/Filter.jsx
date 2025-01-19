import Dropdown from 'react-bootstrap/Dropdown';
import React from "react";

function Filter() {


  return (
      <Dropdown className="content-padding">
        <Dropdown.Toggle id="dropdown-autoclose-true">
          Region
        </Dropdown.Toggle>

        <Dropdown.Menu>
          <Dropdown.Item>Kanto</Dropdown.Item>
          <Dropdown.Item>Johto</Dropdown.Item>
          <Dropdown.Item>Hoenn</Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
  );
}

export default Filter;