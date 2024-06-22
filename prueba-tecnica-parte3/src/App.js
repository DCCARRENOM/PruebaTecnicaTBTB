import React from "react";
import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Cards from "./Views/Cards";
import FilterTable from "./Views/FilterTable";
import Home from "./Views/Home";

//En el componente APP se tiene la parte de navegacion entre las 3 vistas creadas Home,Cards y filterTable
//Para ello se usa react router dom con BrowserRouter
function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/filterTable" element={<FilterTable />} />
          <Route path="/Cards" element={<Cards />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
