package PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.controller;
import PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.model.Product;
import PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.repository.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product") //La ruta utilizada para consultar la API
public class ProductController {

    @Autowired //Para inyectar el servicio en el controlador
    private ProductService productService;

    @GetMapping("/all") //Se especifica el tipo de request y la ruta donde se aloja el endpoint
    public List<Product> findAll(){
        return productService.getAll();
    };

    @GetMapping("/{id}")
    public Optional<Product> getClient(@PathVariable("id") int idProduct) {
        return productService.findById((idProduct));
    };

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable("id") int idProduct){
        productService.delete(idProduct);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        try {
            productService.updateProduct(product.getProductName(), product.getPrice(), product.getStock(), product.getId());
        }catch(Exception e){
            return new ResponseEntity<String>("Producto Actualizado", HttpStatus.OK);
        }
        return null;
    }
}
