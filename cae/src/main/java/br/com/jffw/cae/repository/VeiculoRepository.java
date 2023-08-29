package br.com.jffw.cae.repository;

<<<<<<< HEAD
import java.util.List;

=======
 

import java.util.List;

>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jffw.cae.dto.VagaVeiculosDTO;
<<<<<<< HEAD
import br.com.jffw.cae.models.Vaga;
=======
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
import br.com.jffw.cae.models.Veiculo;
 

public interface VeiculoRepository  extends JpaRepository<Veiculo, String> {
<<<<<<< HEAD
	@Query("SELECT new br.com.jffw.cae.dto.VagaVeiculosDTO("
			+ "vc.placa, vc.cor, vc.modelo, v.id, v.bloco, v.numero) FROM Vaga v INNER JOIN v.veiculos vc")
	List<VagaVeiculosDTO> getVagaVeiculoDTO();
	
	@Query("SELECT new br.com.jffw.cae.dto.VagaVeiculosDTO("
			+ "vc.placa, vc.cor, vc.modelo, v.id, v.bloco, v.numero) FROM Vaga v "
			+ "INNER JOIN v.veiculos vc WHERE v.id = ?1")
	List<VagaVeiculosDTO> getVagaVeiculoDTOById(String placa);
	
	 @Query("SELECT vc FROM Veiculo vc WHERE vc.vaga.id = ?1 AND vc.placa <> ?2")
	    List<Veiculo> findByVagaAndNotPlaca(Vaga vaga, String placa);
=======
    @Query("SELECT new br.com.jffw.cae.dto.VagaVeiculosDTO("
            + "vc.placa, vc.cor, vc.modelo, v.id, v.bloco, v.numero) FROM Vaga v INNER JOIN v.veiculos vc")
    List<VagaVeiculosDTO> getVagaVeiculoDTO();
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea

    @Query("SELECT new br.com.jffw.cae.dto.VagaVeiculosDTO("
            + "vc.placa, vc.cor, vc.modelo, v.id, v.bloco, v.numero) FROM Vaga v "
            + "INNER JOIN v.veiculos vc WHERE v.id = ?1")
    List<VagaVeiculosDTO> getVagaVeiculoDTOById(String placa);

     @Query("SELECT vc FROM Veiculo vc WHERE vc.vaga.id = ?1 AND vc.placa <> ?2")
        List<Veiculo> findByVagaAndNotPlaca(int idVaga, String placa);

     Veiculo findByPlacaAndCorAndModelo(String placa, String cor, String modelo);

 

}