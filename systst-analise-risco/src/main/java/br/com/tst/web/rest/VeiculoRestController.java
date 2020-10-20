package br.com.tst.web.rest;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tst.domain.Veiculo;
import br.com.tst.repository.VeiculoRepository;

@RestController
@RequestMapping("/rest/veiculos")
@CrossOrigin("http://localhost:4200")
public class VeiculoRestController {

	@Autowired 
	private VeiculoRepository repository;
	
    @GetMapping
    public List<Veiculo> findAll() {
        return repository.findAll();
    }
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo create(@RequestBody @Valid Veiculo veiculo) {    	
        return repository.save(riskRating(veiculo));
    }

	private Veiculo riskRating(@Valid Veiculo veiculo) {
		if (veiculo.getAno() < 2010) {
			veiculo.setClassificacao("RISCO ALTO");
		} else if (veiculo.getAno() >= 2010 && veiculo.getAno() < 2015) {
			veiculo.setClassificacao("RISCO MÉDIO");
		} else if (veiculo.getAno() >= 2015) {
			veiculo.setClassificacao("RISCO BAIXO");
		}

		return veiculo;
	}
	
}
