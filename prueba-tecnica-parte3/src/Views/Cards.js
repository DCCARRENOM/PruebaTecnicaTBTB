import React, { useState, useEffect } from "react";
import Card from "../Components/Card";
import "../Styles/Card.css";
import { useNavigate } from "react-router-dom";

function Cards() {
  //Se usa useNavigate para volver a la vista Home
  const navigate = useNavigate();

  const handleBack = () => {
    navigate("/");
  };

  //Se recuperan los datos del Endpoint y se almacenan en la variable User mediante un Hook
  useEffect(() => {
    getUsers();
  }, []);

  const [Users, setUsers] = useState({});
  const getUsers = async () => {
    const response = await fetch(`https://jsonplaceholder.typicode.com/users`);
    const data = await response.json();
    setUsers(data);
  };

  return (
    <div className="container-cards">
      <div class="users-container">
        <div class="users_box">
          {Object.entries(Users).map(([key, value]) => {
            return <Card Info={value} />;
            /*Se mapea el JSON obtenido del endpoint para renderizar cada usuario utilizando el componente Card*/
          })}
          <div class="users_item" onClick={handleBack}>
            <p href="#" class="users-body-card">
              <div class="users-item_bg"></div>
              <div class="users-back">Volver</div>
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Cards;
