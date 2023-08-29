package br.com.jffw.cae.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
=======
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
import org.springframework.stereotype.Service;

import br.com.jffw.cae.dto.VagaVeiculosDTO;
import br.com.jffw.cae.dto.VeiculoDTO;
<<<<<<< HEAD
=======
import br.com.jffw.cae.models.Proprietario;
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
import br.com.jffw.cae.models.Vaga;
import br.com.jffw.cae.models.Veiculo;
import br.com.jffw.cae.repository.VagaRepository;
import br.com.jffw.cae.repository.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private VagaRepository vagaRepository;

<<<<<<< HEAD
//	public List<VagaVeiculoDTO > listarVeiculos(String id) {
//		return veiculoRepository.getVagaVeiculoDTOById(id);
//	}
//	
=======
//    public List<VagaVeiculoDTO > listarVeiculos(String id) {
//        return veiculoRepository.getVagaVeiculoDTOById(id);
//    }
//    
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea

	public List<Veiculo> listarVeiculos() {
		return veiculoRepository.findAll();
	}

	public VeiculoDTO incluirVeiculo(Map<String, String> dados) throws ParseException {

<<<<<<< HEAD
		int idvaga = Integer.parseInt(dados.get("idvaga"));
		Vaga v = vagaRepository.getReferenceById(idvaga);
		String placa = dados.get("placa");
		Veiculo existingVeiculo = veiculoRepository.findById(placa).orElse(null);
		if (existingVeiculo != null) {
			throw new IllegalArgumentException("O veículo já está cadastrado.");
=======
		String placa = dados.get("placa");
		String cor = dados.get("cor");
		String modelo = dados.get("modelo");
		int idVaga = Integer.parseInt(dados.get("idVaga"));
		
	    Vaga existingVaga = vagaRepository.findById(idVaga).orElse(null);
	    if (existingVaga == null) {
	        throw new IllegalArgumentException("Vaga não localizada.");
	    }
	
		if ((placa.isBlank()) || (cor.isBlank()) || (modelo.isBlank())) {
			throw new NullPointerException("A placa, cor e modelo devem ser informados.");
		}
		
		Veiculo vc = veiculoRepository.findByPlacaAndCorAndModelo(placa, cor, modelo);

		if (!Optional.ofNullable(vc).isEmpty()) {
			throw new RuntimeException("Este veiculo " + placa + " já existe");
		}

		List<Veiculo> veiculosdaVaga = existingVaga.getVeiculos();
		if (!veiculosdaVaga.isEmpty()) {
			throw new IllegalArgumentException("A vaga já está vinculada a outro veículo.");
		}

		Optional<Vaga> vagaOptional = vagaRepository.findById(idVaga);
		if (!vagaOptional.isPresent()) {
			throw new IllegalArgumentException("A vaga com o ID fornecido não existe.");
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
		}

		// criando o objeto veiculo
		Veiculo veiculo = new Veiculo();
<<<<<<< HEAD
		veiculo.setVaga(v);
		veiculo.setPlaca(dados.get("placa"));
		veiculo.setCor(dados.get("cor"));
		veiculo.setModelo(dados.get("modelo"));

		veiculoRepository.save(veiculo);

		return new VeiculoDTO(idvaga, veiculo.getPlaca(), veiculo.getCor(), veiculo.getModelo());
=======
		veiculo.setVaga(existingVaga);
		veiculo.setPlaca(placa);
		veiculo.setCor(cor);
		veiculo.setModelo(modelo);

		veiculoRepository.save(veiculo);

		return new VeiculoDTO(veiculo.getVaga().getId(), veiculo.getPlaca(), veiculo.getCor(), veiculo.getModelo());
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea

	}

	public String alterarVeiculo(Map<String, String> dados, String placa) {
<<<<<<< HEAD

	

			Veiculo veiculo1 = veiculoRepository.getReferenceById(placa);

			int idvaga = Integer.parseInt(dados.get("idvaga"));
			Vaga v = vagaRepository.getReferenceById(idvaga);
			veiculo1.setVaga(v);
			veiculo1.setPlaca(dados.get("placa"));
			veiculo1.setCor(dados.get("cor"));
			veiculo1.setModelo(dados.get("modelo"));
			
			if((placa.isBlank()) || (cor.isBlank()) || (modelo.isBlank())) {
				throw new RuntimeException("Veiculo não localizado");
			}	

			veiculoRepository.save(veiculo1);

		return "";
	}
	
//	public ResponseEntity<?> alterarVeiculo(Map<String, String> dados, String placa) {
//		Veiculo veiculo1 = veiculoRepository.findById(placa)
//				.orElseThrow(() -> new EntityNotFoundException("O Veículo a ser alterado não existe."));
//		
//				
//					
//					veiculo1.setPlaca(dados.get("placa"));
//					veiculo1.setCor(dados.get("cor"));
//					veiculo1.setModelo(dados.get("modelo"));
//					
//					int idvaga = dados.getVaga();
//					if (idvaga != null) {
//						 Vaga vaga = vagaRepository.findById(idVaga)
//				                    .orElseThrow(() -> new IllegalArgumentException("O ID do veiculo não existe."));
//
//					      List<Veiculo> veiculosVinculados = veiculoRepository
//				                    .findByVagaAndNotPlaca(vaga, placa);
//				            if (!veiculosVinculados.isEmpty()) {
//				                throw new IllegalArgumentException("O veiculo já está vinculado a outra vaga.");
//				            }
//				            
//				            veiculo1.setVaga(vaga);
//				            veiculoRepository.save(veiculo1);
//				            
//				            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Alteração realizada com sucesso");
//					 
//					}
//		
//			        throw new IllegalArgumentException("O ID da vaga é obrigatório para a alteração.");
//		
//	}
=======
        Veiculo veiculo = veiculoRepository.findById(placa)
                .orElseThrow(() -> new EntityNotFoundException("O veículo a ser alterado não existe."));

		
		String cor = dados.get("cor");
		String modelo = dados.get("modelo");
		int idVaga = Integer.parseInt(dados.get("idVaga"));

//		Optional<Veiculo> veiculoOptional = veiculoRepository.findById(placa);
//		if (!veiculoOptional.isPresent()) {
//			throw new IllegalArgumentException("O veículo com a placa fornecida não existe.");
//		}

		Optional<Vaga> vagaOptional = vagaRepository.findById(idVaga);
		if (!vagaOptional.isPresent()) {
			throw new IllegalArgumentException("A vaga com o ID fornecido não existe.");
		}

		if (((cor.isBlank()) || (modelo.isBlank()))) {
			throw new NullPointerException("A cor e modelo devem ser informados.");
		}

		
        List<Veiculo> veiculosVinculados = veiculoRepository
                .findByVagaAndNotPlaca(idVaga, placa);
        if (!veiculosVinculados.isEmpty()) {
            throw new IllegalArgumentException("A vaga já está vinculada a outro veículo.");
        }
		
		veiculo.setCor(cor);
		veiculo.setModelo(modelo);
		veiculo.setVaga(vagaOptional.get());

		veiculoRepository.save(veiculo);

		return "Alteração realizada com sucesso!";
	}
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea

	public String remover(String placa) {
		try {
			veiculoRepository.deleteById(placa);
			return String.format("Veículo %s removido com sucesso", placa);
		} catch (Exception e) {
			throw new RuntimeException("Veiculo informado não existe.");
		}
	}

	public List<VagaVeiculosDTO> listarVeiculos1() {
		return veiculoRepository.getVagaVeiculoDTO();

	}

	public VagaVeiculosDTO listarVeiculosPorPlaca(String placa) {
		Veiculo veiculo = veiculoRepository.findById(placa)
				.orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado"));
		VagaVeiculosDTO dto = new VagaVeiculosDTO();
		dto.setPlaca(veiculo.getPlaca());
		dto.setCor(veiculo.getCor());
		dto.setModelo(veiculo.getModelo());

		Vaga vaga = veiculo.getVaga();
		if (vaga != null) {
			dto.setVaga(vaga.getId());
			dto.setNumero(vaga.getNumero());
			dto.setBloco(vaga.getBloco());
		}

		return dto;
	}

	public List<VagaVeiculosDTO> listarVeiculosDTO() {
		List<Veiculo> veiculos = veiculoRepository.findAll();
		List<VagaVeiculosDTO> dtos = new ArrayList<>();

		for (Veiculo veiculo : veiculos) {
			VagaVeiculosDTO dto = new VagaVeiculosDTO();
			dto.setPlaca(veiculo.getPlaca());
			dto.setCor(veiculo.getCor());
			dto.setModelo(veiculo.getModelo());

			Vaga vaga = veiculo.getVaga();
			if (vaga != null) {
				dto.setVaga(vaga.getId());
				dto.setNumero(vaga.getNumero());
				dto.setBloco(vaga.getBloco());
			}

			dtos.add(dto);
		}

		return dtos;
	}
}
