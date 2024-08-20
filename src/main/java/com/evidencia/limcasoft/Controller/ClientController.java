package com.evidencia.limcasoft.Controller;

import com.evidencia.limcasoft.Model.ClientModel;
import com.evidencia.limcasoft.Service.ClientService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*Clase que contiene los métodos a ejecutar para una petición HTTP en
específico*/
@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * @return lista de objetos de la clase ClientModel
     */
    @GetMapping("/all")
    public List<ClientModel> getClients() {
        return clientService.getAll();
    }

    /**
     * @param clientId El id del cliente
     * @return la instancia del cliente
     */
    @GetMapping("/{id}")
    public Optional<ClientModel> getClient(@PathVariable("id") int clientId) {
        return clientService.getClient(clientId);
    }

    /**
     * @param client la instancia del cliente a guardar
     * @return la instancia guardada
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel save(@RequestBody ClientModel client) {
        return clientService.save(client);
    }

    /**
     * @param client la instancia del cliente a guardar
     * @return la instancia guardada
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel update(@RequestBody ClientModel client) {
        return clientService.update(client);
    }

    /**
     * @param id el id del cliente a eliminar
     * @return si fue eliminado o no
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return clientService.deleteClient(id);
    }
}
