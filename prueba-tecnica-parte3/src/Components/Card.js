import React from "react";
import "../Styles/Card.css";

//Este componente se encarga de recibir los datos de un usuario
//y representarlo en su respectiva Card
function Card({ Info }) {
  console.log(Info);

  return (
    <div class="users_item">
      <p href="#" class="users-body-card">
        <div class="users-item_bg"></div>
        <div class="users-name">{Info.name}</div>
        <div class="users-info-box">
          <p class="users-info">Username: {Info.username}</p>
          <p class="users-info">Email: {Info.email}</p>
          <p class="users-info">Ciudad: {Info.address.city}</p>
          <p class="users-info">Compañia: {Info.company.name}</p>
        </div>
      </p>
    </div>
  );
}

export default Card;
