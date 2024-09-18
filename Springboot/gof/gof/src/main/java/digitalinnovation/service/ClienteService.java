package digitalinnovation.service;

import digitalinnovation.model.Cliente;


public interface ClienteService {

    // TODO Strategy: Implementar métodos definidos na interface
    // TODO Facade: Abstrair integração com subsistemas, provendo uma interface simples
    // TODO Strategy: Implementar métodos definidos na interface
    // TODO Facade: Abstrair integração com subsistemas, provendo uma interface simples
    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);



}
