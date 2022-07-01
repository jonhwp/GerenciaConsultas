package projetoGerenciaConsultas;

public class Paciente {
	
	String codigo;
	String nome;
	String historico;
	
	public Paciente(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
		
		this.historico = "Paciente sem histórico prévio de doenças (aparentemente).";
	}
	
	public Paciente(String codigo, String nome, String doenca) {
		
		this.codigo = codigo;
		this.nome = nome;		
		this.historico = "Histórico prévio: " + doenca;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHistorico() {
		return historico;
	}

	
	public void addHistorico(String entrada) {
		this.historico += "\n" + entrada;
	}
	
	public String toString() {
		String s = "\nCódigo: "+codigo +
				   "\nNome: "+ nome; 
		
		return s;
	}
	
	public void exibeHistorico() {
		System.out.println(historico);
	}
	

}
