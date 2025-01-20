import Spinner from "react-bootstrap/Spinner";

function Loading() {
  return (
    <div className="loading-container">
      <Spinner animation="border" role="status">
        <span className="visually-hidden">Loading...</span>
      </Spinner>
    </div>
  );
}

export default Loading;
