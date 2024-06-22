package PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.controller;

import PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.model.Client;
import PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.repository.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client") //La ruta utilizada para consultar la API
public class ClientController {
    @Autowired //Para inyectar el servicio en el controlador
    private ClientService clientService;

    @GetMapping("/all") //Se especifica el tipo de request y la ruta donde se aloja el endpoint
    public List<Client> findAll(){
        return clientService.getAll();
    };

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int idClient) {
        return clientService.findById((idClient));
    };

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable("id") int idClient){
        clientService.delete(idClient);
    }

    @PostMapping("/save")
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateClient(@RequestBody Client client){
        try {
            clientService.updateClient(client.getClientName(), client.getLastName(), client.getAddress(), client.getId());
        }catch(Exception e){
            return new ResponseEntity<String>("Cliente Actualizado", HttpStatus.OK);
        }
        return null;
    }
}
