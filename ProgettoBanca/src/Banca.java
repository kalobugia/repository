
public class Banca {
	
	private String nome, radiceIban;
	private int contiMax, contiAttivi, numConto;
	private Conto[] conti;
	

	
	public Banca(String nome, String radiceIban, int contiMax, int contiAttivi) {
		this.setNome(nome);
		this.radiceIban = radiceIban;
		this.contiMax = contiMax;
		this.contiAttivi = contiAttivi;
		conti = new Conto[contiMax];
	}
	
	public Conto nuovoConto(Persona p, Banca b) {
		if(contiAttivi > contiMax) {
			System.out.println("ERRORE, numero conti massimo raggiunto");
			return null;
		}
		else {
			Conto c = new Conto(p, b);
			conti[contiAttivi] = c;
			contiAttivi++;
			return c;
		}
	}
	
	public double totaleSaldi() {
		double acc = 0;
				int i;
				for(i = 0; i < contiAttivi; i++) {
					acc = acc + conti[i].getSaldo();
				}
				return acc;
	}
	
	public boolean operazione(Conto c, double importo) {
		if(importo < 0) {
			return c.preleva(importo);
		}
		else {
			return c.deposita(importo);
		}
	}
	
	public Conto getConto(String iban) {
		int i = 0;
		while(iban == conti[i].getIban()) {
			i++;
		}
		return conti[i];
	}
	
	public String getRadiceIban() {
		return radiceIban;
	}
	
	public void setRadiceIban(String radiceIban) {
		this.radiceIban = radiceIban;
	}
	
	public int getContiAttivi() {
		return contiAttivi;
	}
	
	public void setContiAttivi(int contiAttivi) {
		this.contiAttivi = contiAttivi;
	}
	
	public void elencoConti() {
		for(int i = 0; i < contiAttivi; i++) {
			System.out.println(conti[i]);
		}
	}
	
	public int getNumConto() {
		return numConto;
	}

	public void setNumConto(int numConto) {
		this.numConto = numConto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public static void main(String[] args) {
		Banca b0 = new Banca("IntesaSanPaolo", "IT006", 12, 0);
		boolean esito;
		
		Persona p0 = new Persona("Marcello", "Bello", "BLLMRC1234");
		Conto c0 = b0.nuovoConto(p0, b0);
		esito = b0.operazione(c0, +1000);
		System.out.println("Esito deposito: "+esito);
		System.out.println("Saldo: "+c0.getSaldo());
		esito = b0.operazione(c0, -100);
		System.out.println("Esito deposito: "+esito);
		System.out.println("Saldo: "+c0.getSaldo());
		
		
		Persona p1 = new Persona("Pippo", "Dirado", "DRDPPP1234");
		Conto c1 = b0.nuovoConto(p1, b0);
		esito = b0.operazione(c1, +5000);
		System.out.println("Esito deposito: "+esito);
		System.out.println("Saldo: "+c1.getSaldo());
		esito = b0.operazione(c1, -250);
		System.out.println("Esito deposito: "+esito);
		System.out.println("Saldo: "+c1.getSaldo());
		
		
		System.out.println("Bilancio Intesa San Paolo: "+b0.totaleSaldi());
		
		System.out.println("Elenco Conti:");
		b0.elencoConti();
	}
	
}
