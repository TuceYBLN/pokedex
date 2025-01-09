import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

function PokeCard({image, id, variant, shiny, region, family, name}) {
  return (
    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top"  src={`${process.env.PUBLIC_URL}/Bilder/Pokemon/${image}.png`}/>
      <Card.Body>
        <Card.Title>#{id} {name} {shiny && <img src={process.env.PUBLIC_URL + "/Bilder/Other/shiny.png"} />}</Card.Title>
        <Card.Text>
          Family: {family}
        </Card.Text>
        <Card.Text>
          Variant: {variant}
        </Card.Text>
        <Card.Text>
          Region: {region}
        </Card.Text>
        <Button variant="primary">CAUGHT</Button>
      </Card.Body>
    </Card>
  );
}

export default PokeCard;