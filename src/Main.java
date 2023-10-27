import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean running = true;
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
    }

    public static void aderencia(){
        System.out.println("Conformidade (Aderência): " + Checklist.verconforme() + " %");
        System.out.println("Não Conformidade - Prioridade Baixa: " + Checklist.verbaixa()+ " %");
        System.out.println("Não Conformidade - Prioridade Média: " + Checklist.vermedia()+ " %");
        System.out.println("Não Conformidade - Prioridade Alta: " + Checklist.veralta()+ " %");
        System.out.println("Total Avaliadas: " + Checklist.vernull());
    }
}