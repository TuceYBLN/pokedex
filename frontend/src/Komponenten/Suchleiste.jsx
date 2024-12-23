import Form from 'react-bootstrap/Form';

function Suchleiste() {
  return (
    <div className="content-padding">
    <Form>
      <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
        <Form.Control type="text" placeholder="Suche" />
      </Form.Group>
    </Form>
    </div>
  );
}

export default Suchleiste;