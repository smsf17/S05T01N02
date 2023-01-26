package cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n02.dto.FlorDTO;
import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n02.services.FlorServiceImpl;

@Controller
@RequestMapping("/flor")
public class FlorController {
	
	@Autowired
	private FlorServiceImpl florService;
	
	//http://localhost:9001/flor/add
	@PostMapping("/add")
	public ResponseEntity<FlorDTO> add(@RequestBody FlorDTO flor) {
		
		FlorDTO saveFlor = florService.add(flor);
		
		return new ResponseEntity<>(saveFlor, HttpStatus.CREATED);
	}
	

	//http://localhost:9001/flor/update
	@PutMapping("/update/{id}")
	public ResponseEntity<FlorDTO> update(@PathVariable("id") int id, @RequestBody FlorDTO flor) {
		
		flor.getPk_FlorID();
		FlorDTO updateFlor = florService.update(flor);
		
		return new ResponseEntity<>(updateFlor, HttpStatus.OK);
	}
	
		
	//http://localhost:9001/flor/delete/{id}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		
		florService.delete(id);
		
		return new ResponseEntity<>("Flor con id "+id+" eliminada!", HttpStatus.OK);
	}
	
	//http://localhost:9001/flor/getOne/{id}
	@GetMapping("/getOne/{id}")
	public ResponseEntity<FlorDTO> getOne(@PathVariable("id") int id) {
		FlorDTO flor = florService.getOne(id);
		return new ResponseEntity<>(flor, HttpStatus.OK);
	}
	
	//http://localhost:9001/flor/getAll
	@GetMapping("/getAll")
	public ResponseEntity<List<FlorDTO>> getAll() {
		List<FlorDTO> listadoFlores = florService.getAll();
		return new ResponseEntity<>(listadoFlores, HttpStatus.OK);
	}

}
