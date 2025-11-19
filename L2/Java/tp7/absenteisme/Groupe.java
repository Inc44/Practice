package tp7.absenteisme;

import java.util.ArrayList;

public class Groupe {
	private String code;
	private String formation;

	public Groupe(String code, String formation) {
		this.code = code;
		this.formation = formation;
	}

	public Groupe(String formation) {
		this.code = null;
		this.formation = formation;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFormation() {
		return formation;
	}
	public void setFormation(String formation) {
		this.formation = formation;
	}

	@Override
	public String toString() {
		return "Groupe [code=" + code + ", formation=" + formation + "]";
	}
}
