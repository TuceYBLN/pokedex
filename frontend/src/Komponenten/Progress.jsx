import ProgressBar from "react-bootstrap/ProgressBar";

function Progress({shinyCount, shinyTotal}) {

  return (
    <div className="content-padding">
      <h4><img src={process.env.PUBLIC_URL + "/Bilder/Other/shiny.png"} alt="shiny"/>Shiny {shinyCount}/{shinyTotal}</h4>
      <ProgressBar variant="warning" now={shinyCount/shinyTotal*100} />
    </div>
  );
}

export default Progress;
