package PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.repository;

import PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.crudRepository.ProductRepository;
import PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> findById(int idProduct){
        return productRepository.findById(idProduct);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void delete (int idProduct){
        productRepository.deleteById(idProduct);
    }

    public String updateProduct (String productName,int price,int stock, int id){
        productRepository.updateProduct(productName,price,stock,id);
        return "Producto Actualizado";
    }

}
