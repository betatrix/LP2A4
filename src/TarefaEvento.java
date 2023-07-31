import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TarefaEvento extends Lembrete {
    protected String nome;
    protected String local;
    protected String descricao;
    protected LocalDate data;
    protected LocalTime horaInicio;
    protected LocalTime horaFim;

    public static TarefaEvento criarTarefaEvento(Class<? extends TarefaEvento> tipo) {
        Scanner scan = new Scanner(System.in);
        TarefaEvento tarefaEvento = null;

        try {
            tarefaEvento = tipo.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (tarefaEvento != null) {
            String resposta;

            while (true) {
                try {
                    if (tipo.getSimpleName().equalsIgnoreCase("Tarefa")){
                        System.out.println("\nCerto, vamos criar uma " + tipo.getSimpleName() + "!");
                    }else {
                        System.out.println("\nCerto, vamos criar um " + tipo.getSimpleName() + "!");
                    }
                    System.out.print("Insira o nome: ");
                    tarefaEvento.nome = scan.nextLine();

                    System.out.print("Insira o local: ");
                    tarefaEvento.local = scan.nextLine();

                    System.out.println("Gostaria de inserir uma descrição? (S/N)");

                    while (true) {
                        resposta = scan.nextLine();

                        if (resposta.equalsIgnoreCase("s")) {
                            System.out.print("Insira uma descrição: ");
                            tarefaEvento.descricao = scan.nextLine();
                            break;
                        } else if (resposta.equalsIgnoreCase("n")) {
                            break;
                        } else {
                            System.out.println("Valor inválido, insira novamente (S/N)");
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("Insira a data: (DD/MM/AAAA)");
                            String dataInput = scan.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            tarefaEvento.data = LocalDate.parse(dataInput, formatter);
                            break;
                        } catch (Exception e) {
                            System.out.println("Informe uma data válida!\n");
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("Insira a hora do início: (HH:MM) ");
                            String horaI_Input = scan.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                            tarefaEvento.horaInicio = LocalTime.parse(horaI_Input, formatter);
                            break;
                        } catch (Exception e) {
                            System.out.print("Insira um horário válido!\n");
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("Gostaria de inserir uma hora final? (S/N)");
                            resposta = scan.nextLine();

                            while (true) {
                                if (resposta.equalsIgnoreCase("s")) {
                                    System.out.print("Insira a hora final: (HH:MM) ");
                                    String horaF_Input = scan.nextLine();
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                                    tarefaEvento.horaFim = LocalTime.parse(horaF_Input, formatter);
                                    break;
                                } else if (resposta.equalsIgnoreCase("n")) {
                                    break;
                                } else {
                                    System.out.println("Valor inválido, insira novamente (S/N)");
                                }
                            }
                            break;
                        } catch (Exception e) {
                            System.out.print("Insira um horário válido!\n");
                        }
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Dados inseridos incorretamente. Tente novamente!\n");
                }
            }

            System.out.println("Gostaria de criar um lembrete para o seu " + tipo.getSimpleName() + "? (S/N)");
            resposta = scan.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                tarefaEvento.criarLembrete();
                System.out.println("Lembrete criado e " + tipo.getSimpleName().toLowerCase() + " salvo!");
            } else {
                System.out.println("Tudo bem! " + tipo.getSimpleName().toLowerCase() + " salvo com sucesso :)");
            }
        }

        return tarefaEvento;
    }


    public void criarLembrete() {
        String resposta;
        Scanner scan = new Scanner(System.in);

        System.out.print("Insira um nome para o lembrete: ");
        setMensagem(scan.nextLine());

        while (true) {
            try {
                System.out.println("Insira uma data para receber uma notificação: (DD/MM/AAAA) ");
                String dataInput = scan.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                data = LocalDate.parse(dataInput, formatter);
                break;
            } catch (Exception e) {
                System.out.println("Informe uma data válida!\n");
            }
        }

        while (true) {
            try {
                System.out.println("Insira um horário: (HH:MM) ");
                String horaI_Input = scan.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                horaInicio = LocalTime.parse(horaI_Input, formatter);
                break;
            } catch (Exception e) {
                System.out.print("Insira um horário válido!\n");
            }
        }

        System.out.println("Esse lembrete se repete? (S/N)");
        resposta = scan.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            setRepete(true);
        }
    }
}

