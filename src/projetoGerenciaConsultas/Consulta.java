package projetoGerenciaConsultas;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Consulta {
	
	Paciente paciente;
	DateTime data_consulta;
	String hora;
	Medico medico;

	public Consulta(Paciente paciente, DateTime data, Medico medico) {
		
		this.paciente = paciente;
		this.data_consulta = data;
		this.hora = hora;
		this.medico = medico;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public DateTime getData() {
		return data_consulta;
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
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
		LocalTime horario = new LocalTime(this.data_consulta);

		String s = "\n|  Data: "     + fmt.print(this.data_consulta) +	// pega a data da consulta
				   "\n|  Hora: " + horario.toString("HH:mm") +    	// pega o horário da consulta
				   "\n|  Paciente: " + this.paciente.getNome() +    	// pega o nome do paciente da consulta
				   "\n|  Médico: "   + this.medico.getNome() + "  |";	// pega o nome do medico da consulta
				   
		return s;
	}

	public void AtualizaHistorico(String informacao) {;
		String entradaHistorico = "Consulta realizada em "     + this.data_consulta + " Hora: "+
 				   				  "\n com o médico "   + this.medico.getNome() + " ("+ this.medico.getEspecialidade() + ")" +
 				   				  "\n Relatório da consulta: " + informacao;	   
				   
		// para adicionar a string recebida como parâmetro (String informacao)
		// no historico do paciente, use o método addHistorico da classe Paciente
		this.paciente.addHistorico(entradaHistorico);
		
	}	
}
