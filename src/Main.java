import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int resposta;
        Scanner scan = new Scanner(System.in);

        System.out.println("-------------------BEM-VINDO A SUA AGENDA PESSOAL!----------------------");

        while (true){
            System.out.println("\nEscolha uma das opções: \n" +
                    "1) Criar um evento\n" +
                    "2) Criar um lembrete\n" +
                    "3) Criar uma tarefa\n" +
                    "4) Sair do programa");
            resposta = scan.nextInt();

            switch (resposta) {
                case 1:
                    Evento meuEvento = new Evento();
                    meuEvento.criarEvento();
                case 2:
                    Lembrete meuLembrete = new Lembrete();
//              meuLembrete.criarLembrete();
                case 3:
                    Tarefa minhaTarefa = new Tarefa();
//              minhaTarefa.criarTarefa();
                case 4:
                    break;
                default:
                    System.out.println("Um número válido!\n");
            }
        }


        //      Imprime o evento
//        System.out.println("Nome do Evento: " + getNome());
//
//        if (getDescricao() != null) {
//            System.out.println("Descrição: " + getDescricao() );
//        }
//        System.out.println("Local do Evento: " + getLocal());
//        System.out.println("Data do Evento: " + getDataFormatada());
//
//        if (getHoraFim() != null) {
//            System.out.println("Horário: " + getHoraInicio() + " - " + getHoraFim());
//        } else {
//            System.out.println("Horário: " + getHoraInicio());
//        }

    }
}
