import React, { useState, useEffect } from "react";
import User from "../Components/User";
import "../Styles/Table.css";
import "../Styles/Box.css";
import { useNavigate } from "react-router-dom";

function FilterTable() {
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

  //Se recupera el valor seleccionado de la lista desplegable
  //y dependiendo de dicho valor se filtrara el campo segun el campo correspondiente
  const filter = () => {
    let filterOption = document.getElementById("options").value;
    let filterParameter;
    // eslint-disable-next-line default-case
    switch (filterOption) {
      case "Name":
        filterParameter = 0;
        break;
      case "Mail":
        filterParameter = 2;
        break;
      case "City":
        filterParameter = 4;
        break;
    }
    let input = document.getElementById("inputNombre");
    let filter = input.value.toUpperCase();
    let table = document.getElementById("TableUsers");
    let tr = table.getElementsByTagName("tr");
    let td;
    let txtValue;
    for (let i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[filterParameter];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  };

  return (
    <div className="container-table">
      <div class="controlBox">
        <div className="titleBox">
          <h1 id="title">Centro de filtrado de usuarios</h1>
        </div>
        <div className="inputBox">
          <label>Ingrese el parametro a buscar: </label>
          <input
            type="text"
            id="inputNombre"
            placeholder="Filtrar..."
            onChange={filter}
          />
          <label>Seleccione el atributo a filtrar: </label>
          <select id="options">
            <option value="Name">Nombre</option>
            <option value="Mail">Correo</option>
            <option value="City">Ciudad</option>
          </select>
        </div>
        <button className="backButton" onClick={handleBack}>
          Volver
        </button>
      </div>
      <div class="table-wrapper">
        <table class="fl-table" id="TableUsers">
          <thead>
            <tr>
              <th>Nombre</th>
              <th>Username</th>
              <th>Correo</th>
              <th>Calle</th>
              <th>Ciudad</th>
              <th>Compañia</th>
            </tr>
          </thead>
          <tbody>
            {Object.entries(Users).map(([key, value]) => {
              return <User Info={value} />;
              /* Se mapea el JSON obtenido del endpoint para renderizar cada usuario utilizando el componente User*/
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default FilterTable;
