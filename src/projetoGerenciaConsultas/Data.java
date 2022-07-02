package projetoGerenciaConsultas;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;

public class Data {
    public static DateTime  define_data(){

        // altera o formato toString da chasse:
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
        LocalDate hoje = new LocalDate();
        LocalTime agora = new LocalTime();
        int dia = 0;
        int mes = 0;
        int ano = hoje.getYear();
        int hora;
        int minutos;

        int confirma = 1;
        while (true) {
            // Instancia uma data atual para comparação.

            LocalTime hora_consulta;
            LocalDate data;
            while (true) {

                // definindo um dia
                dia = Console.leInteiro("Defina um dia para consulta:");
                while (!(dia > 0 && dia < 32)) {
                    dia = Console.leInteiro("Dia inexistente, tente novamente. Qual o melhor dia para a consulta? ");
                }

                // definindo um mês
                mes = Console.leInteiro("Defina um mês para consulta:");
                while (!(mes > 0 && mes <= 12)) {
                    mes = Console.leInteiro("Mês inexistente, tente novamente. Qual o melhor mês para a consulta? ");
                }

                // valida se a data é anterior a atual.

                data = new LocalDate(ano, mes, dia);
                Days d = Days.daysBetween(hoje, data);
                while (d.getDays() < 0) {
                    System.out.println("Ops, hoje é dia "+fmt.print(hoje)+"." +
                            "\nVocê escolheu uma data que já passou." +
                            "\nVamos tentar novamente.\n");
                    // definindo um dia
                    dia = Console.leInteiro("Defina um dia para consulta:");
                    while (!(dia > 0 && dia < 32)) {
                        dia = Console.leInteiro("Dia inexistente, tente novamente. Qual o melhor dia para consulta? ");
                    }
                    // definindo um mês
                    mes = Console.leInteiro("Defina um mês para consulta:");
                    while (!(mes > 0 && mes <= 12)) {
                        mes = Console.leInteiro("Mês inexistente, tente novamente. Qual o melhor mês para consulta? ");
                    }
                    break;
                }

                // defindo hora
                System.out.println("Nosso horário de atendimento é das 8:00 às 18:00 horas.");
                hora = Console.leInteiro("Qual o melhor horário para sua consulta?");
                while (!(hora > 7 && hora <= 18)) {
                    mes = Console.leInteiro("Hora indisponível, tente novamente. Qual o melhor horário para a consulta? ");
                }

                // defindo minutos
                int m = 0;
                for (int i = 0; m < 60; i++) {
                    agora = new LocalTime(hora, m);
                    System.out.println("Opção " + (i+1) + ": " + agora.toString("HH:mm"));
                    agora.plusMinutes(15);
                    m = m+15;
                }
                int valor = Console.leInteiro("\nEscolha uma das opções acima.");
                hora_consulta = new LocalTime();

                switch (valor) {
                    case 1:
                        hora_consulta = new LocalTime(hora, 00);
                        break;
                    case 2:
                        hora_consulta = new LocalTime(hora, 15);
                        break;
                    case 3:
                        hora_consulta = new LocalTime(hora, 30);
                        break;
                    case 4:
                        hora_consulta = new LocalTime(hora, 45);
                        break;
                    default:
                        break;
                }
                minutos = hora_consulta.getMinuteOfHour();
                break;
            }

            // Confirma com o cliente a data definida.
            DateTime confirmaData = new DateTime(ano, mes, dia, hora, minutos, 0, 0);
            confirma = Console.leInteiro("Você gostaria de confirmar o dia " + fmt.print(data) + " às "+hora_consulta.toString("HH:mm")+ " para sua consulta?\n1 - sim\n2 - não");


            if (confirma == 1) {
                System.out.println("A data foi definida com sucesso!");
                return confirmaData;
            }

        }
    }

    public static void main(String[] args) {

        define_data();
    }
}
