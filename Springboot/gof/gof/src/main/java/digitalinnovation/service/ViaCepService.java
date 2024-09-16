package digitalinnovation.service;

// client do Feign

@FeignClient   (name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    RequestMapping(value = "/{cep}/json", method = RequestMethod.GET(value = "/{cep}/json"))
    Endereco consultarCep(@PathVariable("cep") String cep);

    

}
