
public class Conto {
	
	private String iban, cf_persona;
	private double saldo = 0;

	

	public Conto(Persona p, Banca b) {
		iban = this.nuovoIban(b);
		this.setCf_persona(p.getCf());
	}

	
	public boolean preleva(double importo) {
		double s = saldo + importo;
		if(s>=0) {	
			saldo = s;
			return true;
		}
		else 
			return false;
	}
	
	public boolean deposita(double importo) {
		saldo = saldo + importo;
		return true;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String nuovoIban(Banca b) {
		return b.getRadiceIban()+b.getContiAttivi();
	}
	
	public String getIban() {
		return iban;
	}
	
	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getCf_persona() {
		return cf_persona;
	}


	public void setCf_persona(String cf_persona) {
		this.cf_persona = cf_persona;
	}
	

}
