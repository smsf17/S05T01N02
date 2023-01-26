package cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n02.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n02.domain.FlorEntity;
import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n02.dto.FlorDTO;
import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n02.repitory.FlorRepository;

@Service
public class FlorServiceImpl implements FlorService {

	@Autowired
	FlorRepository florRepo;
	
	@Override
	public FlorDTO add(FlorDTO florDTO) {
		
		FlorEntity flor = this.mapDTOToEntity(florDTO);
		FlorEntity saveFlor = florRepo.save(flor);
		FlorDTO saveFlorDTO = this.mapEntityToDTO(saveFlor);
		
		return saveFlorDTO;
	}

	@Override
	public FlorDTO update(FlorDTO flor) {
		FlorEntity florID = florRepo.findById(flor.getPk_FlorID()).get();
		florID.setNomFlor(flor.getNomFlor());
		florID.setPaisFlor(flor.getPaisFlor());
		FlorEntity updateFlor = florRepo.save(florID);
		
		return this.mapEntityToDTO(updateFlor);
	}

	@Override
	public void delete(int id) {
		florRepo.deleteById(id);

	}

	@Override
	public FlorDTO getOne(int id) {
		
		Optional<FlorEntity> optionalFlor = florRepo.findById(id);
		FlorEntity flor = optionalFlor.get();
		
		return this.mapEntityToDTO(flor);
	}

	@Override
	public List<FlorDTO> getAll() {
		
		List<FlorDTO> resultat = new ArrayList<FlorDTO>();
		List<FlorEntity> flores = florRepo.findAll();
		if (flores!=null && flores.size()>0) {
			for(FlorEntity flor: flores) {
				resultat.add(this.mapEntityToDTO(flor));
			}
		}
	
		return resultat;
	}
	
	private FlorEntity mapDTOToEntity(FlorDTO florDTO) {
		FlorEntity resultat = null;
		if(florDTO != null) {
			resultat = new FlorEntity();
			resultat.setPk_FlorID(florDTO.getPk_FlorID());;
			resultat.setNomFlor(florDTO.getNomFlor());
			resultat.setPaisFlor(florDTO.getPaisFlor());
		}
		return resultat;
	}
	
	private FlorDTO mapEntityToDTO(FlorEntity flor) {
		FlorDTO resultat = null;
		if(flor != null) {
			resultat = new FlorDTO();
			resultat.setPk_FlorID(flor.getPk_FlorID());;
			resultat.setNomFlor(flor.getNomFlor());
			resultat.setPaisFlor(flor.getPaisFlor());
			String pais=flor.getPaisFlor();
			resultat.getTipusFlor(pais);
		}
		return resultat;
	}

}
