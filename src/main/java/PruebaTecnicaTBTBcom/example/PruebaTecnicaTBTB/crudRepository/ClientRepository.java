package PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.crudRepository;

import PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//Un repository ayuda a hacer operaciones sobre una base de datos de manera sencilla
//al heredar de CrudRepository se pasan como argumentos la tabla que se va a consultar y el tipo de su llave primaria
public interface ClientRepository  extends CrudRepository<Client, Integer> {

}
