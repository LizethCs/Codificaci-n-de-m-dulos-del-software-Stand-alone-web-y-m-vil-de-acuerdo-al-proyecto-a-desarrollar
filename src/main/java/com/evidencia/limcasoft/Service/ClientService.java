package com.evidencia.limcasoft.Service;

import com.evidencia.limcasoft.Model.ClientModel;
import com.evidencia.limcasoft.Repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*Clase que implementa los casos de uso, se marca esta responsabilidad y se añade al 
contexto de Spring con la anotación estereotipo @Service*/
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * @return lista de objetos de la clase ClientModel
     */
    public List<ClientModel> getAll() {
        return clientRepository.getAll();
    }

    /**
     * @param id El id del cliente
     * @return la instancia del cliente
     */
    public Optional<ClientModel> getClient(int clientId) {
        return clientRepository.getClient(clientId);
    }

    /**
     * @param client la instancia del cliente a guardar
     * @return la instancia guardada
     */
    public ClientModel save(ClientModel client) {
        if (client.getId() == null) {
            return clientRepository.save(client);
        } else {
            Optional<ClientModel> element = clientRepository.getClient(client.getId());
            if (element.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    /**
     * @param client la instancia del cliente a guardar
     * @return la instancia guardada
     */
    public ClientModel update(ClientModel client) {
        if (client.getId() != null) {
            Optional<ClientModel> element = clientRepository.getClient(client.getId());
            if (!element.isEmpty()) {
                if (client.getName() != null) {
                    element.get().setName(client.getName());
                }
                if (client.getLastName() != null) {
                    element.get().setLastName(client.getLastName());
                }
                if (client.getEmail() != null) {
                    element.get().setEmail(client.getEmail());
                }
                if (client.getAddress() != null) {
                    element.get().setAddress(client.getAddress());
                }
                if (client.getNumber() != null) {
                    element.get().setNumber(client.getNumber());
                }
                if (client.getDocType() != null) {
                    element.get().setDocType(client.getDocType());
                }
                if (client.getDocument() != null) {
                    element.get().setDocument(client.getDocument());
                }
                clientRepository.save(element.get());
                return element.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    /**
     * @param client la instancia del cliente a eliminar
     * @return si fue eliminado o no
     */
    public boolean deleteClient(int id) {
        Boolean isDeleted = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return isDeleted;
    }

}
