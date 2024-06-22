package PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.repository;

import PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.model.Client;
import PruebaTecnicaTBTBcom.example.PruebaTecnicaTBTB.crudRepository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientService {
    @Autowired //Para inyectar el repository al servicio
    private ClientRepository clientRepository;

    //Método para obtener todos los registros de la tabla
    public List<Client> getAll(){
        return (List<Client>) clientRepository.findAll();
    }

    public Optional<Client> findById(int idClient){
        return clientRepository.findById(idClient);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public void delete (int idClient){
        clientRepository.deleteById(idClient);
    }

    public String updateClient (String clientName, String lastName, String address, int id){
        clientRepository.updateClient(clientName,lastName,address,id);
        return "Cliente Actualizado";
    }

}
