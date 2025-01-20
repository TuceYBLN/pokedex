import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import React from "react";

function PokeCard({image, id, variant, shiny, region, family, name, caught, types, handleToggle}) {


  return (
    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top"  src={`${process.env.PUBLIC_URL}/Bilder/Pokemon/${image}.png`} alt="pokemon"/>
      <Card.Body>
        <Card.Title>#{id} {name} {shiny && <img src={process.env.PUBLIC_URL + "/Bilder/Other/shiny.png"} alt="shiny"/>}</Card.Title>
        <Card.Text>
          Family: {family}
        </Card.Text>
        <Card.Text>
          Variant: {variant}
        </Card.Text>
        <Card.Text>
          Region: {region}
        </Card.Text>
          <Card.Text>
              Type: {types.join(', ')}
          </Card.Text>
            <Form>
              <Form.Check
                type="switch"
                id="custom-switch"
                label="Captured!"
                checked={caught}
                onChange={handleToggle}
              />
              </Form>
      </Card.Body>
    </Card>
  );
}

export default PokeCard;