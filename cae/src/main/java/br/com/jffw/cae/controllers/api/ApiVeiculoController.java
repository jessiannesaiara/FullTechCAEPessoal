package br.com.jffw.cae.controllers.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.CrossOrigin;
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
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

<<<<<<< HEAD

=======
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
@RestController
@RequestMapping("/api/veiculos")
public class ApiVeiculoController {
	@Autowired
	VeiculoService veiculoService;

<<<<<<< HEAD
=======
	@CrossOrigin
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
	@PostMapping("/")
	public ResponseEntity<Object> incluirVeiculo(@RequestBody Map<String, String> dados) {
		try {
			return new ResponseEntity<Object>(veiculoService.incluirVeiculo(dados), HttpStatus.CREATED);
		} catch (Exception e) {
<<<<<<< HEAD
			return ResponseEntity.badRequest().body("Erro ao incluir veículo: " + e.getMessage());
		}

	}

=======
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@CrossOrigin
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
	@PutMapping("/{placa}")
	public ResponseEntity<String> alterarVeiculo(@RequestBody Map<String, String> dados, @PathVariable String placa) {
		try {

			return new ResponseEntity<String>(veiculoService.alterarVeiculo(dados, placa), HttpStatus.ACCEPTED);

		} catch (Exception e) {

<<<<<<< HEAD
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.toString());
=======
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea

		}

	}

<<<<<<< HEAD
=======
	@CrossOrigin
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
	@DeleteMapping("/{placa}")
	public ResponseEntity<String> deleteVeiculo(@PathVariable String placa) {
		try {

			return new ResponseEntity<String>(veiculoService.remover(placa), HttpStatus.ACCEPTED);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());

		}

	}
<<<<<<< HEAD
	
=======

	@CrossOrigin
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
	@GetMapping("/")
	public List<VagaVeiculosDTO> listarVeiculosDTO() {
		return veiculoService.listarVeiculosDTO();
	}

<<<<<<< HEAD
=======
	@CrossOrigin
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
	@GetMapping("/{placa}")
	public ResponseEntity<?> listarVeiculosPorPlaca(@PathVariable String placa) {

		try {
			VagaVeiculosDTO dto = veiculoService.listarVeiculosPorPlaca(placa);
<<<<<<< HEAD
				return ResponseEntity.ok(dto);
			
=======
			return ResponseEntity.ok(dto);

>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado");
		}

	}

<<<<<<< HEAD
}
=======
}
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
