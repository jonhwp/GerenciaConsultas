package projetoGerenciaConsultas;

import java.util.ArrayList;

public class AppOriginal {

	public static void main(String[] args) {
		
		/* CADASTRO DE PACIENTES */
		System.out.println("\n<<< Cadastro de Pacientes >>>\n");
		
		// Estas mensagens serão utilizadas apenas para exibir informações
		// para o usuário final		
		String msgEntradaCodigo = "Digite o código do paciente (somente números): ";		
		String msgEntradaNome = "Digite o nome completo do paciente (sem abreviações): ";
		
		// Lista de objetos criados a partir da classe Paciente
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>(); 
		
		while (true) {
			Paciente p = new Paciente(Console.leString(msgEntradaCodigo),
									 Console.leString(msgEntradaNome)); 
			pacientes.add(p);
			System.out.println("Paciente incluído com sucesso!");
			
			String c = Console.leString("Digite N para encerrar ou qualquer tecla para inserir um novo paciente: ");
			
			if (c.equalsIgnoreCase("N")) {
				break;
			}			
		}
		
		System.out.println("\nLista de Pacientes:");
		for (Paciente p : pacientes) {
			// Para recuperar o nome do paciente, use o getNome()
			System.out.println("\t" + p.getNome());
			
		}
		
		/* CADASTRO DE MÉDICOS */
		System.out.println("\n<<< Cadastro de Médicos >>>\n");
		// Estas mensagens serão utilizadas apenas para exibir informações
		// para o usuário final.
		String msgEntradaCRM = "Digite o CRM do médico (somente números): ";		
		String msgEntradaMedico = "Digite o nome completo do médico (sem abreviações): ";
		String msgEntradaEspec = "Digite a especialização do médico (sem abreviações): ";
		
		// Lista de objetos criados a partir da classe Medico
		ArrayList<Medico> medicos = new ArrayList<Medico>(); 
		
		// Uma outra forma de fazer o loop de cadastro. Note como a variavel 
		// insereNovoMedico foi inicializada e como ela é manipulada dentro do while. 
		
		String insereNovoMedico = "Y";
		do {
			if (insereNovoMedico.equalsIgnoreCase("Y")) {
						
				Medico p = new Medico(Console.leString(msgEntradaCRM),
									  Console.leString(msgEntradaMedico),
									  Console.leString(msgEntradaEspec) ); 
				
				// Adiciona o médico na lista de médicos
				medicos.add(p);		
				System.out.println("Médico incluído com sucesso!");				
			}
			
			insereNovoMedico = Console.leString("\nDeseja inserir outro médico (Y/N)? ");
						
		} while (!insereNovoMedico.equalsIgnoreCase("N"));
		
		System.out.println("\nLista de Médicos:");
		for (Medico m : medicos) {
			// Para recuperar o nome do medico, use o getNome()
			System.out.println("\t"+m.getNome());			
		}
		
		
		/* CADASTRO DE CONSULTAS */
		
		// Para criar um objeto consulta, precisamos de 4 atributos
		//    1 - um objeto da classe Medico
		//    2 - data da consulta
		//    3 - hora da consulta
		//    4 - um objeto da classe Paciente
		
		// Vamos preparar cada atributos, 1 por vez
		
		
		//	O objeto da classe Medico deve ser selecionado a partir da lista
		// de medicos (ArrayList<Medico> medicos)
		
		// Primeiro vamos exibir a lista de médicos e pedir ao usuário que escolha
		// uma das opções
		
		System.out.println("\n<<< Cadastro de Consultas >>>\n");
		// Lista de objetos criados a partir da classe Consulta
		ArrayList<Consulta> consultas = new ArrayList<Consulta>(); 
		
		// Uma outra forma de fazer o loop de cadastro. Note como a variavel 
		// insereNovoMedico foi inicializada e como ela é manipulada dentro do while. 
		
		boolean inserirNovaConsulta = true;
		
		do {
			if (inserirNovaConsulta) {
						
				// Seleciona o médico da consulta
				Medico medicoConsulta = null;
				
				int numMedico = 1;
				System.out.println("\nMedicos disponíveis: ");				
				for (Medico m : medicos) {
					System.out.println("\t" + numMedico + " - " + m.getNome());
					numMedico++; 
				}
				
				int numMedSelecao = Console.leInteiro("\nDigite o número do médico: ");
				
				while ( !(numMedSelecao > 0 && numMedSelecao <= medicos.size()) ) {
					// Aqui estamos garantindo que o número digitado seja uma
					// posição válida do ArrayList
					System.out.println("Posição do médico inválida!");
					numMedSelecao = Console.leInteiro("Digite o número do médico: ");
				}
				
				// Agora, a partir do número digitado, vamos recuperar o objeto da lista
				// de medicos. Lembra que temos que subtrair 1, pois o ArrayList é indexado
				// a partir do 0 (zero)			
				
				medicoConsulta = medicos.get(numMedSelecao-1); 
				
				// Seleciona o paciente da consulta
				Paciente pacienteConsulta = null;
				
				
				int numPaciente = 1;
				System.out.println("\nPacientes cadastrados: ");
				for (Paciente p : pacientes) {
					System.out.println("\t" + numPaciente + " - " + p.getNome());
					numPaciente++; 
				}
				
				int numPacSelecao = Console.leInteiro("Digite o número do paciente: ");
				
				// O número digitado deve estar entre 1 e pacientes.size()
				while (!(numPacSelecao > 0 && numPacSelecao <= pacientes.size())) {
					// Aqui estamos garantindo que o número digitado seja uma
					// posição válida do ArrayList
					System.out.println("Posição do paciente inválida!");
					numPacSelecao = Console.leInteiro("Digite o número do paciente: ");
				}	
				
				// Agora, a partir do número digitado, vamos recuperar o objeto da lista
				// de medicos. Lembra que temos que subtrair 1, pois o ArrayList é indexado
				// a partir do 0 (zero)			
				
				pacienteConsulta = pacientes.get(numPacSelecao-1); 
				
				// Recebe a data e hora da consulta
				
				// Estas mensagens serão utilizadas apenas para exibir informações
				// para o usuário final.
				String msgEntradaData = "Digite a data da consulta (formato DD/MM/YYYY): ";		
				String msgEntradaHora = "Digite a hora da consulta (formato hh:mm) : ";
								
				String dataConsulta = Console.leString(msgEntradaData);
				String horaConsulta = Console.leString(msgEntradaHora);
				
				// Cria uma nova consulta
								
				/*Consulta c = new Consulta(pacienteConsulta,
									  	  dataConsulta,
									  	  horaConsulta,
									  	  medicoConsulta); 
				
				// Adiciona na lista de consultas
				consultas.add(c);
				System.out.println("Consulta incluída com sucesso!");*/
			}
			
			String continuar = Console.leString("\nDeseja inserir outra consulta (Y/N)? ");
			
			if (continuar.equalsIgnoreCase("N"))
				inserirNovaConsulta = false;
			
		} while (inserirNovaConsulta == true);
		
		// Exibe todas as consultas
		System.out.println("\nLista de Consultas: ");
		for (Consulta c : consultas) {
			System.out.println(c);			
		}		
		
	}
}

