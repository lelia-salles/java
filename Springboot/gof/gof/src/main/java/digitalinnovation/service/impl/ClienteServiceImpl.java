package digitalinnovation.service.impl;

import digitalinnovation.model.Cliente;
import digitalinnovation.model.ClienteRepository;
import digitalinnovation.model.Endereco;
import digitalinnovation.model.EnderecoRepository;
import digitalinnovation.service.ClienteService;
import digitalinnovation.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
        // TODO Singleton: Injetar os componenetes do Sping com @Autowired
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService; // cliente http


        // TODO Strategy: Implementar métodos definidos na interface
        // TODO Facade: Abstrair integração com subsistemas, provendo uma interface simples
        @Override
        public Iterable<Cliente> buscarTodos() {
        // FIXME Buscar Todos os Clientes
        return clienteRepository.findAll();
    }


    @Override
    public Cliente buscarPorId(Long id) {
        /// FIXME Buscar Clientes por ID
       Optional<Cliente> cliente = clienteRepository.findById(id);
       return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        // FIXME Verificar se endereço do cliente já existe pelo cep
            String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(Long.valueOf(cep)).orElseGet(() -> {
            // FIXME caso não exista, integrar com ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
    }


    @Override
    public void atualizar(Long id, Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {

    }

    /*@Override
    public void atualizar(Long id, Cliente cliente) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method stub

    }
*/

    
}
