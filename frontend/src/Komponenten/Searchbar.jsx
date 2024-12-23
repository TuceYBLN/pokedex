import Form from 'react-bootstrap/Form';

function Searchbar() {
  return (
    <div className="content-padding">
    <Form>
      <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
        <Form.Control type="text" placeholder="Search" />
      </Form.Group>
    </Form>
    </div>
  );
}

export default Searchbar;