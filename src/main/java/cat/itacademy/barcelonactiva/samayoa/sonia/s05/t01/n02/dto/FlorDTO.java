package cat.itacademy.barcelonactiva.samayoa.sonia.s05.t01.n02.dto;

import java.util.Arrays;
import java.util.List;

public class FlorDTO {
	
	private int pk_FlorID;
	private String nomFlor;
	private String paisFlor;
	private String tipusFlor;
	
	String[] listaPaises = { "Alemania", "Belgica", "Croacia", "Dinamarca", "España", "Francia", "Irlanda", "Letonia",
			"Luxemburgo", "Paises Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta", "Polonia",
			"Republica Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungria", "Italia", "Lituania",
			"Portugal", "Rumania" };
	List<String> paisesEU = Arrays.asList(listaPaises);

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

	public String getTipusFlor(String pais) {
		this.tipusFlor = "Sense Tipus";
		int indice = paisesEU.indexOf(pais);
		if (indice != -1) {
			this.tipusFlor = "EU";
		} else {
			this.tipusFlor = "No EU";
		}

		return this.tipusFlor;

	}

}
