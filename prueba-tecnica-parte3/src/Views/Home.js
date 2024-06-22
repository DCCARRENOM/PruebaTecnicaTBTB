import React from "react";
import "../Styles/Home.css";
import { useNavigate } from "react-router-dom";

//Se crea una vista Home para conectar las vistas de visualizacion de usuarios
//Con useNavigate es poder moverse entre las vistas creadas en APP
function Home() {
  const navigate = useNavigate();

  //Funcion para ir a la vista Cards al hacer click en el boton correspondiente
  const handleCards = () => {
    navigate("/Cards");
  };

  //Funcion para ir a la vista FilterTable al hacer click en el boton correspondiente
  const handleFilterTable = () => {
    navigate("/filterTable");
  };
  return (
    <div className="container-home">
      <div className="Home-main-container">
        <h1 id="Home-title">Prueba técnica Daniel Carreño</h1>
        <div className="Home-button-container">
          <div className="contenedor">
            <button className="button-home" onClick={handleCards}>
              Visualizar Cards
            </button>
          </div>
          <div className="Home-element">
            <button className="button-home" onClick={handleFilterTable}>
              Visualizar Tabla con filtro
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;
