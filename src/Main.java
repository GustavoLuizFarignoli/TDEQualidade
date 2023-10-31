import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean running = true;
        Perguntas perguntas;
        try {
            perguntas = (Perguntas) Serializador.ler("Perguntas");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Checklist.perguntas = null;
        Checklist.perguntas = perguntas.getPerguntas();

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        while(running) {
            if (Singleton.instancia == null) {
                running = loginmenu(teclado);
            } else {
                menu(teclado);
            }
        }
    }

    public static boolean loginmenu(Scanner teclado){
        int op = 0;
        boolean running = true;
        System.out.println("1-Login\n2-Sair\n3-Reinicializar Perguntas");
        op = teclado.nextInt();
        switch(op) {
            case 1:
                System.out.println("Digite o seu nome: ");
                teclado.nextLine();
                String nome = teclado.nextLine();
                Singleton.getInstance(nome);
                break;
            case 2:
                running = false;
                break;
            case 3:
                debug();
                break;
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        return running;
    }

    public static void menu(Scanner teclado){
        int op = 0;
        System.out.println("1-Verificar Conformidada\n2-Ver Perguntas\n3-Avaliar Perguntas\n4-Editar Avaliação\n5-Sair");
        op = teclado.nextInt();
        switch(op) {
            case 1:
                aderencia();
                break;
            case 2:
                Checklist.verPerguntas();
                break;
            case 3:
                //confere se há perguntas para serem avaliadas
                int tamanho = Checklist.vernull();
                if (tamanho == Checklist.perguntas.size()){
                    System.out.println("Não há pergunta para avaliar");

                } else {
                    for (Pergunta p : Checklist.perguntas){
                        if (p.getResultado() == null) {
                            //Achou uma pergunta para ser avaliada, pede ao usuário como proceder
                            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                            System.out.println(p.getDescricao());
                            System.out.println("1-Conforme\n2-Não Conforme - Prioridade Baixa\n3-Não Conforme - Prioridade Média\n4-Não Conforme - Prioridade Alta\n5-Pular Perguntas\n6-Parar de Avaliar");
                            int conformidade = teclado.nextInt();
                            if (conformidade == 6){
                                break;
                            } else if (conformidade == 1) {
                                p.setResultado(Checklist.conformidade(conformidade));
                                p.setAvaliador(Singleton.instancia);
                            } else if (conformidade != 5){
                                p.setResultado(Checklist.conformidade(conformidade));
                                p.setAvaliador(Singleton.instancia);
                                System.out.println("Digite as observações da avaliação");
                                teclado.nextLine();
                                p.setObservacoes(teclado.nextLine());
                                System.out.println("Digite as ações corretivas sugeridas");
                                p.setAcao(teclado.nextLine());
                            }
                            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                        }
                    }
                }
                break;
            case 4:
                System.out.println("Digite qual o número a pergunta que deseja avaliar");
                int indice = teclado.nextInt();
                if (indice > Checklist.perguntas.size() || indice < 0){
                    System.out.println("Essa não é uma pergunta válida, por favor tente novamente");
                } else {
                    Pergunta p = Checklist.perguntas.get(indice-1);
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println(p.getDescricao());
                    System.out.println("1-Conforme\n2-Não Conforme - Prioridade Baixa\n3-Não Conforme - Prioridade Média\n4-Não Conforme - Prioridade Alta\n5-Remover Avaliação\n6-Cancelar");
                    int conformidade = teclado.nextInt();
                    if (conformidade == 1){
                        p.setResultado(Checklist.conformidade(conformidade));
                        p.setAvaliador(Singleton.instancia);
                    } else if (conformidade < 5) {
                        p.setResultado(Checklist.conformidade(conformidade));
                        p.setAvaliador(Singleton.instancia);
                        System.out.println("Digite as observações da avaliação");
                        teclado.nextLine();
                        p.setObservacoes(teclado.nextLine());
                        System.out.println("Digite as ações corretivas sugeridas");
                        p.setAcao(teclado.nextLine());
                    } else if (conformidade == 5){
                        p.setAvaliador(null);
                        p.setObservacoes(null);
                        p.setAcao(null);
                        p.setResultado(Checklist.conformidade(conformidade));
                    }
                }
                break;
            case 5:
                System.out.println("Realizando log out...");
                Singleton.logout();
                break;
        }
        Perguntas perguntas = new Perguntas(Checklist.perguntas);
        try {
            Serializador.gravar("Perguntas", perguntas);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public static void debug(){
        Checklist.perguntas = new ArrayList<Pergunta>();
        Pergunta p4 = new Pergunta("Uma estratégia de integração dos componentes do produto foi estabelecida??","Gerente de Projetos");
        Checklist.perguntas.add(p4);
        Pergunta p5 = new Pergunta("Existem procedimentos e critérios definidos para a integração dos componentes?\n","Gerente de Projetos");
        Checklist.perguntas.add(p5);
        Pergunta p6 = new Pergunta("A descrição das interfaces internas e externas está disponível e assegura a cobertura, completude e consistência da solução?\n","Gerente de Projetos");
        Checklist.perguntas.add(p6);
        Pergunta p7 = new Pergunta("Foi estabelecido um ambiente dedicado à integração dos componentes do produto?\n","Gerente de Projetos");
        Checklist.perguntas.add(p7);
        Pergunta p8 = new Pergunta("O ambiente é regularmente mantido e atualizado para atender às necessidades de integração?\n","Gerente de Projetos");
        Checklist.perguntas.add(p8);
        Pergunta p9 = new Pergunta("Cada componente do produto é avaliado antes da integração?\n","Gerente de Projetos");
        Checklist.perguntas.add(p9);
        Pergunta p10 = new Pergunta("Essa avaliação garante que os componentes atendam aos requisitos, projeto e descrição das interfaces internas e externas?\n","Gerente de Projetos");
        Checklist.perguntas.add(p10);
        Pergunta p11 = new Pergunta("Os componentes do produto são integrados conforme a estratégia estabelecida?\n","Gerente de Projetos");
        Checklist.perguntas.add(p11);
        Pergunta p12 = new Pergunta("Os procedimentos e critérios são seguidos durante a integração?\n","Gerente de Projetos");
        Checklist.perguntas.add(p12);
        Pergunta p13 = new Pergunta("O ambiente de integração é utilizado como previsto?\n","Gerente de Projetos");
        Checklist.perguntas.add(p13);
        Pergunta p14 = new Pergunta("O produto integrado passa por testes?\n","Gerente de Projetos");
        Checklist.perguntas.add(p14);
        Pergunta p15 = new Pergunta("Os testes asseguram que o produto atenda aos requisitos e projeto?\n","Gerente de Projetos");
        Checklist.perguntas.add(p15);
        Pergunta p16 = new Pergunta("A compatibilidade das interfaces é verificada durante os testes?\n","Gerente de Projetos");
        Checklist.perguntas.add(p16);
        Pergunta p17 = new Pergunta("Os resultados dos testes são registrados?\n","Gerente de Projetos");
        Checklist.perguntas.add(p17);
        Pergunta p18 = new Pergunta("O produto integrado e o material de apoio são preparados?\n","Gerente de Projetos");
        Checklist.perguntas.add(p18);
        Pergunta p19 = new Pergunta("O ambiente é regularmente mantido e atualizado para atender às necessidades de integração?\n","Gerente de Projetos");
        Checklist.perguntas.add(p19);
        Pergunta p20 = new Pergunta("O produto integrado e o material de apoio são entregues às partes interessadas?\n","Gerente de Projetos");
        Checklist.perguntas.add(p20);
        Perguntas perguntas = new Perguntas(Checklist.perguntas);
        try {
            Serializador.gravar("Perguntas", perguntas);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void aderencia(){
        //tratar resultado caso o valor seja nulo para não ficar feio
        System.out.println("Conformidade (Aderência): " + String.format("%.2f",Checklist.verconforme())  + " %");
        System.out.println("Não Conformidade - Prioridade Baixa: " + String.format("%.2f",Checklist.verbaixa())  + " %");
        System.out.println("Não Conformidade - Prioridade Média: " + String.format("%.2f",Checklist.vermedia()) + " %");
        System.out.println("Não Conformidade - Prioridade Alta: " + String.format("%.2f",Checklist.veralta()) + " %");
        System.out.println("Total Avaliadas: " + Checklist.vernull() + "/" + Checklist.perguntas.size());
    }
}
