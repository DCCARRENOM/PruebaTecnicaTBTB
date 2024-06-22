package PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    //Dado que esta llave primaria se genera automaticamante de manera secuencial es necesario utilizar el decorador generatedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Se usa la anotación Id para indicar que este atributo es la clave primaria de la tabla
    @Column(name = "id") //Se especifica que columna de la tabla mapea este atributo
    private Integer id;

    @Column(name = "productname")
    private String productName;

    @Column (name = "price")
    private Integer price;

    @Column (name = "stock")
    private Integer stock;

    //Getter and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
