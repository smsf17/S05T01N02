package cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n02.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="flor_db")
public class FlorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_FlorID")
	private int pk_FlorID;

	@Column(name="nomFlor", length=50, unique=true, nullable=false)
	private String nomFlor;

	@Column(name="paisFlor", length=50)
	private String paisFlor;
	
	public int getPk_FlorID() {
		return pk_FlorID;
	}

	public void setPk_FlorID(int pk_FlorID) {
		this.pk_FlorID = pk_FlorID;
	}

	public String getNomFlor() {
		return nomFlor;
	}

	public void setNomFlor(String nomFlor) {
		this.nomFlor = nomFlor;
	}

	public String getPaisFlor() {
		return paisFlor;
	}

	public void setPaisFlor(String paisFlor) {
		this.paisFlor = paisFlor;
	}

}
