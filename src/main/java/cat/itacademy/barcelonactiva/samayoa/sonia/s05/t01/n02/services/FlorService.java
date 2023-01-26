package cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n02.services;

import java.util.List;

import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n02.dto.FlorDTO;

public interface FlorService {
	
	public FlorDTO add(FlorDTO flor);
	public FlorDTO update(FlorDTO flor);
	public void delete(int id);
	public FlorDTO getOne(int id);
	public List<FlorDTO> getAll();

}
