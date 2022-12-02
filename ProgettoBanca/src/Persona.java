
public class Persona {
	private String nome, cognome, cf;
	
	

	public Persona(String nome, String cognome, String cf) {
		this.setNome(nome);
		this.setCognome(cognome);
		this.cf = cf;
	}
	
	public String getCf() {
		return cf;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
