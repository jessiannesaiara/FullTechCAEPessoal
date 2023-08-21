package br.com.jffw.cae.controllers.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jffw.cae.dto.VagaVeiculosDTO;
import br.com.jffw.cae.services.VeiculoService;


@RestController
@RequestMapping("/api/veiculos")
public class ApiVeiculoController {
	@Autowired
	VeiculoService veiculoService;

	@PostMapping("/")
	public ResponseEntity<Object> incluirVeiculo(@RequestBody Map<String, String> dados) {
		try {
			return new ResponseEntity<Object>(veiculoService.incluirVeiculo(dados), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.toString());
		}

	}

	@PutMapping("/{placa}")
	public ResponseEntity<String> alterarVeiculo(@RequestBody Map<String, String> dados, @PathVariable String placa) {
		try {

			veiculoService.alterarVeiculo(dados, placa);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Alteração realizada com sucesso");

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.toString());

		}

	}

	@DeleteMapping("/{placa}")
	public ResponseEntity<String> deleteVeiculo(@PathVariable String placa) {
		try {

			return new ResponseEntity<String>(veiculoService.remover(placa), HttpStatus.ACCEPTED);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.toString());

		}

	}
	


	@GetMapping(path = { "/", "/{idVaga}" })
	public List<VagaVeiculosDTO> listarVeiculos(@PathVariable(name = "idVaga", required = false) Integer idVaga) {

		try {
			if (idVaga != null) {
				return veiculoService.listarVeiculos(idVaga);
			} else {
				return veiculoService.listarVeiculos1();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
