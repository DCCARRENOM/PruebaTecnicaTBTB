package PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.model;

import jakarta.persistence.*;

@Entity //Se usa la anotacion entity para especificar que esta clase mapea una tabla de la base de datos
@Table(name = "clients") //Se especifica el nombre de la tabla que se va a mapear
public class Client {

    @Id //Se usa la anotación Id para indicar que este atributo es la clave primaria de la tabla
    @Column(name = "id") //Se especifica que columna de la tabla mapea este atributo
    private Integer id;

    @Column(name = "clientname")
    private String clientName;

    @Column (name = "lastname")
    private String lastName;

    @Column (name = "address")
    private String address;

    //Getter and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
