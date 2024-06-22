import React from "react";
import "../Styles/Table.css";

//Este componente se encarga de recibir los datos de un usuario
//y representarlos dentro de la tabla creada en filterTable
function User({ Info }) {
  console.log(Info);

  return (
    <tr>
      <td>{Info.name}</td>
      <td>{Info.username}</td>
      <td>{Info.email}</td>
      <td>{Info.address.street}</td>
      <td>{Info.address.city}</td>
      <td>{Info.company.name}</td>
    </tr>
  );
}

export default User;
