package cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n02.repitory;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n02.domain.FlorEntity;
import cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n02.dto.FlorDTO;

public interface FlorRepository extends JpaRepository<FlorEntity, Integer> {

	FlorDTO save(FlorDTO flor);

}
