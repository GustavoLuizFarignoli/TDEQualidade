import java.io.IOException;
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
        System.out.println("1-Login\n2-Sair");
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
        //O Programa em si vem aqui
        int op = 0;
        System.out.println("1-Verificar Conformidada\n2-Ver Perguntas\n3-Avaliar Pergunta\n4-Sair");
        op = teclado.nextInt();
        switch(op) {
            case 1:
                aderencia();
                break;
            case 2:
                Checklist.verPerguntas();
                break;
            case 3:
                System.out.println("Avaliando");
                break;
            case 4:
                System.out.println("Realizando log out...");
                Singleton.logout();
                break;
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public static void debug(){
        Pergunta p1 = new Pergunta("Titulo?","Gustavo");
        p1.setResultado("Conforme");
        Checklist.perguntas.add(p1);
        Pergunta p2 = new Pergunta("Github?","Gustavo");
        p2.setResultado("Não Conforme - Prioridade Baixa");
        Checklist.perguntas.add(p2);
        Pergunta p3 = new Pergunta("Requisitos?","Gustavo");
        Checklist.perguntas.add(p3);
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
        System.out.println("Conformidade (Aderência): " + Checklist.verconforme() + " %");
        System.out.println("Não Conformidade - Prioridade Baixa: " + Checklist.verbaixa()+ " %");
        System.out.println("Não Conformidade - Prioridade Média: " + Checklist.vermedia()+ " %");
        System.out.println("Não Conformidade - Prioridade Alta: " + Checklist.veralta()+ " %");
        System.out.println("Total Avaliadas: " + Checklist.vernull());
    }
}
