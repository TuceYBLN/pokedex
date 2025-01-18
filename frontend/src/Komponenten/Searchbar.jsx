import Form from "react-bootstrap/Form";

function Searchbar({ searchQuery, setSearchQuery }) {

    // nicht re-rendern bei Enter
    const handleSubmit = (event) => {
        event.preventDefault();
    };

  return (
    <div className="content-padding">
      <Form onSubmit={handleSubmit}>
        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
          <Form.Control
            type="text"
            placeholder="Search"
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
          />
        </Form.Group>
      </Form>
    </div>
  );
}

export default Searchbar;
