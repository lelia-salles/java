package digitalinnovation.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import digitalinnovation.model.Endereco;


// client do Feign


@FeignClient   (name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    Endereco consultarCep(@PathVariable("cep") String cep);

    

}
