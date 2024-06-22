package PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.crudRepository;

import PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.model.Client;
import PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query(value = "UPDATE product SET productname=?1, price=?2, stock=?3 WHERE product.id=?4 ", nativeQuery = true)
    void updateProduct (String productName, int price, int stock, int id);

}
