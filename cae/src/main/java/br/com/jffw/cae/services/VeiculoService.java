package br.com.jffw.cae.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.jffw.cae.dto.VagaVeiculosDTO;
import br.com.jffw.cae.dto.VeiculoDTO;
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

//	public List<VagaVeiculoDTO > listarVeiculos(String id) {
//		return veiculoRepository.getVagaVeiculoDTOById(id);
//	}
//	

	public List<Veiculo> listarVeiculos() {
		return veiculoRepository.findAll();
	}

	public VeiculoDTO incluirVeiculo(Map<String, String> dados) throws ParseException {

		int idvaga = Integer.parseInt(dados.get("idvaga"));
		Vaga v = vagaRepository.getReferenceById(idvaga);
		String placa = dados.get("placa");
		Veiculo existingVeiculo = veiculoRepository.findById(placa).orElse(null);
		if (existingVeiculo != null) {
			throw new IllegalArgumentException("O veículo já está cadastrado.");
		}

		// criando o objeto veiculo
		Veiculo veiculo = new Veiculo();
		veiculo.setVaga(v);
		veiculo.setPlaca(dados.get("placa"));
		veiculo.setCor(dados.get("cor"));
		veiculo.setModelo(dados.get("modelo"));

		veiculoRepository.save(veiculo);

		return new VeiculoDTO(idvaga, veiculo.getPlaca(), veiculo.getCor(), veiculo.getModelo());

	}

	public String alterarVeiculo(Map<String, String> dados, String placa) {

	

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
