package digitalinnovation.service.impl;

import digitalinnovation.model.Cliente;
import digitalinnovation.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {
        // TODO Singleton: Injetar os componenetes do Sping com @Autowired
        // TODO Strategy: Implementar métodos definidos na interface
        // TODO Facade: Abstrair integração com subsistemas, provendo uma interface simples
    @Override
    public Iterable<Cliente> buscarTodos() {
        // FIXME Buscar Todos os Clientes
        return null;
    }


    @Override
    public Cliente buscarPorId(Long id) {
        /// FIXME Buscar Clientes por ID
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {
        // TODO Auto-generated method stub  

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
