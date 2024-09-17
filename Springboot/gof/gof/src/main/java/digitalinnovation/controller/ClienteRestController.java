package digitalinnovation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import digitalinnovation.model.Cliente;
import digitalinnovation.repository.ClienteRepository;
import digitalinnovation.service.ClienteService;

@RequestMapping("/clientes")
@RestController

public class ClienteRestController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){ 
        return ResponseEntity.ok(ClienteService.biuscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return clienteRepository.ok(ClienteService.buscarPorId(id);
    }
// revisar abaixo
    @PostMapping
    public void inserir(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);    
    }

    @PutMapping("/{id}")
    public void atualizar(Long id, @RequestBody Cliente cliente){
        clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }   

}
