package digitalinnovation.service.impl;

import digitalinnovation.model.Cliente;
import digitalinnovation.service.ClienteService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteServiceImpl implements ClienteService {

    @Override
    public Iterable<Cliente> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public void inserir(Cliente cliente) {
        // TODO Auto-generated method stub  

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method stub

    }   

    @Override
    public void buscarPorId(Long id) {
        // TODO Auto-generated method stub

    }   

    
}
