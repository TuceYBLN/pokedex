import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

function PokeCard({image, id, type}) {
  return (
    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top"  src={`${process.env.PUBLIC_URL}/Bilder/Pokemon/${image}.png`}/>
      <Card.Body>
        <Card.Title>#{id} NAME</Card.Title>
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