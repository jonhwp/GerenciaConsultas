package projetoGerenciaConsultas;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class Consulta {
	
	Paciente paciente;
	LocalDate data;
	String hora;
	Medico medico;
	
	public Consulta(Paciente paciente, LocalDate data, String hora, Medico medico) {
		
		this.paciente = paciente;
		this.data = data;
		this.hora = hora;
		this.medico = medico;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(String data) {
		this.data = LocalDate.parse(data);
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public String toString() {
		String s = "\n" +
				   "|  Data: "     + this.data + " Hora: " + this.hora + 
				   "  |  Paciente: " + this.paciente.getNome() +    // pega o nome do paciente da consulta	   
				   "  |  Médico: "   + this.medico.getNome() + "  |";		  // pega o nome do medico da consulta	   
				   
		return s;
	}

	public void AtualizaHistorico(String informacao) {;
		String entradaHistorico = "Consulta realizada em "     + this.data + " Hora: " + this.hora + 
 				   				  "\n com o médico "   + this.medico.getNome() + " ("+ this.medico.getEspecialidade() + ")" +
 				   				  "\n Relatório da consulta: " + informacao;	   
				   
		// para adicionar a string recebida como parâmetro (String informacao)
		// no historico do paciente, use o método addHistorico da classe Paciente
		this.paciente.addHistorico(entradaHistorico);
		
	}	
}
