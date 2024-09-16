package digitalinnovation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/clientes")
@RestController

public class ClienteRestController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public Iterable<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }

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
