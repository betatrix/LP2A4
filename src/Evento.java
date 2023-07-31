import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Evento extends Lembrete{
    private String nome;
    private String local;
    private String descricao;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    Scanner scan = new Scanner(System.in);


    public Evento() {
    }

//Evento --------------------------------------------------------------------------------------------------------------
    public void criarEvento() {
        String resposta;

        while (true) {
            try {
                System.out.println("\nCerto, vamos criar seu evento!");
                System.out.print("Insira o nome: ");
                nome = scan.nextLine();

                System.out.print("Insira o local: ");
                local = scan.nextLine();

                System.out.println("Gostaria de inserir uma descrição? (S/N)");

                while (true) {
                    resposta = scan.nextLine();

                    if (resposta.equalsIgnoreCase("s")) {
                        System.out.print("Insira uma descrição: ");
                        descricao = scan.nextLine();
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
                        data = LocalDate.parse(dataInput, formatter);
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
                        horaInicio = LocalTime.parse(horaI_Input, formatter);
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
                                horaFim = LocalTime.parse(horaF_Input, formatter);
                                break;
                            } else if (resposta.equalsIgnoreCase("n")) {
                                break;
                            } else {
                                System.out.println("Valor inválido, insira novamente (S/N)");
                            }
                        } break;
                    } catch (Exception e) {
                        System.out.print("Insira um horário válido!\n");
                    }
                } break;
            } catch (Exception e) {
                System.out.println("Dados inseridos incorretamente. Tente novamente!\n");
            }
        }

        System.out.println("Gostaria de criar um lembrete para o seu evento? (S/N)");
        if (resposta.equalsIgnoreCase("s")){
            criarLembrete();
            System.out.println("Lembrete criado e evento salvo!");
        } else {
            System.out.println("Tudo bem! Evento salvo com sucesso :)");
        }
    }


//    Lembrete ---------------------------------------------------------------------------------------------------------
    public void criarLembrete() {
        String resposta;

        System.out.print("Insira um nome para o lembrete: ");
        setMensagem(scan.nextLine());

        while (true){
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

        while (true){
            try {
                System.out.println("Insira um horário: (HH:MM) ");
                String horaI_Input = scan.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                horaInicio = LocalTime.parse(horaI_Input, formatter);
                break;
            } catch (Exception e){
                System.out.print("Insira um horário válido!\n");
            }
        }

        System.out.println("Esse lembrete se repete? (S/N)");
        resposta = scan.nextLine();
        if (resposta.equalsIgnoreCase("s")){
            setRepete(true);
        }
    }

// Data formatada ------------------------------------------------------------------------------------------------------
    public String getDataFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }


// Getter & Setters ----------------------------------------------------------------------------------------------------
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime hora) {
        this.horaInicio = hora;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime hora) {
        this.horaFim = hora;
    }
}
