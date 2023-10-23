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
        System.out.println("1-Verificar Conformidada\n2-Ver Perguntas\n3-Sair");
        op = teclado.nextInt();
        switch(op) {
            case 1:
                aderencia();
                break;
            case 2:
                for (int i = 0; i < Checklist.perguntas.size(); i++){
                    if (Checklist.perguntas.get(i).getResultado() == null){
                        System.out.println(i + " " + Checklist.perguntas.get(i).getDescricao() + " Não Avaliado");
                    } else {
                        System.out.println(i + " " + Checklist.perguntas.get(i).getDescricao() + " " + Checklist.perguntas.get(i).getResultado());
                    }
                }
                break;
            case 3:
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
    }

    public static void aderencia(){
        System.out.println("Conformidade: " + Checklist.verconforme() + " %");
        System.out.println("Baixa: " + Checklist.verbaixa()+ " %");
        System.out.println("Média: " + Checklist.vermedia()+ " %");
        System.out.println("Alta: " + Checklist.veralta()+ " %");
    }
}