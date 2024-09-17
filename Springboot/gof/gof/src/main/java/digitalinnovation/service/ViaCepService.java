package digitalinnovation.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import digitalinnovation.model.Endereco;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// client do Feign

@FeignClient   (name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    RequestMapping(value = "/{cep}/json", method = RequestMethod.GET(value = "/{cep}/json"))
    Endereco consultarCep(@PathVariable("cep") String cep);

    

}
