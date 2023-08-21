package br.com.jffw.cae.services;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
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
		
	
	public VeiculoDTO incluirVeiculo(Map<String, String> dados) {
		
		int idvaga =  Integer.parseInt(dados.get("idvaga"));			
		Vaga v =  vagaRepository.getReferenceById(idvaga);
		
		// criando o objeto veiculo
		Veiculo veiculo = new Veiculo();
		veiculo.setVaga(v);
		veiculo.setPlaca(dados.get("placa"));
		veiculo.setCor(dados.get("cor"));
		veiculo.setModelo(dados.get("modelo"));			
	
		veiculoRepository.save(veiculo);
		
		return new VeiculoDTO(idvaga, veiculo.getPlaca(), veiculo.getCor(), veiculo.getModelo());
		
		}
	
	public void  alterarVeiculo(Map<String, String> dados, String placa) {	
		
		try {

			Veiculo veiculo1 = veiculoRepository.getReferenceById(placa);			
			
			int idvaga =  Integer.parseInt(dados.get("idvaga"));
			Vaga v =  vagaRepository.getReferenceById(idvaga);
			veiculo1.setVaga(v);
			veiculo1.setPlaca(dados.get("placa"));
			veiculo1.setCor(dados.get("cor"));
			veiculo1.setModelo(dados.get("modelo"));			
		
			veiculoRepository.save(veiculo1);
			
		} catch (Exception e) {
			throw new EntityNotFoundException("Este veículo não existe");
		}	  
	
	}
	

	public String remover(String placa) {
		try {
			veiculoRepository.deleteById(placa);
			return String.format("Veículo %s removido com sucesso", placa);
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	public List<VagaVeiculosDTO> listarVeiculos1() {
		return veiculoRepository.getVagaVeiculoDTO();
		
	}
	
	public List<VagaVeiculosDTO> listarVeiculos(Integer idVaga) {
		return veiculoRepository.getVagaVeiculoDTOById(idVaga);
		
	}

}
