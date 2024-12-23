import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

function PokeCard({image, id, type, shiny}) {
  return (
    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top"  src={`${process.env.PUBLIC_URL}/Bilder/Pokemon/${image}.png`}/>
      <Card.Body>
        <Card.Title>#{id} NAME {shiny !== null && <img src={process.env.PUBLIC_URL + "/Bilder/Other/shiny.png"} />}</Card.Title>
        <Card.Text>
          Family: 
        </Card.Text>
        <Card.Text>
          Type: {type}
        </Card.Text>
        <Card.Text>
          Region: 
        </Card.Text>
        <Button variant="primary">CAUGHT</Button>
      </Card.Body>
    </Card>
  );
}

export default PokeCard;