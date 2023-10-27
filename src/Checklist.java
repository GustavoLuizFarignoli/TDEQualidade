import java.util.ArrayList;
import java.util.Objects;

public class Checklist {
    public static ArrayList<Pergunta> perguntas = new ArrayList<>();

    public static double verconforme(){
        int conforme = 0;
        int tamanho = vernull();
        for (Pergunta pergunta : perguntas) {
            if (Objects.equals(pergunta.getResultado(), "Conforme")) {
                conforme += 1;
            }
        }
        return (((double) conforme / tamanho) * 100);
    }

    public static double verbaixa(){
        int baixa = 0;
        int tamanho = vernull();
        for (Pergunta pergunta : perguntas) {
            if (Objects.equals(pergunta.getResultado(), "Não Conforme - Prioridade Baixa")) {
                baixa += 1;
            }
        }
        return (((double) baixa / tamanho) * 100);
    }
    public static double vermedia(){
        int media = 0;
        int tamanho = vernull();
        for (Pergunta pergunta : perguntas) {
            if (Objects.equals(pergunta.getResultado(), "Não Conforme - Prioridade Média")) {
                media += 1;
            }
        }
        return (((double) media / tamanho) * 100);
    }
    public static double veralta(){
        int alta = 0;
        int tamanho = vernull();
        for (Pergunta pergunta : perguntas) {
            if (Objects.equals(pergunta.getResultado(), "Não Conforme - Prioridade Alta")) {
                alta += 1;
            }
        }
        return (((double) alta / tamanho) * 100);
    }
    public static int vernull(){
        int tamanho = perguntas.size();
        for (Pergunta pergunta : perguntas) {
            if (pergunta.getResultado() == null) {
                tamanho -= 1;
            }
        }
        return tamanho;
    }
    public static void verPerguntas(){
        for (int i = 0; i < Checklist.perguntas.size(); i++){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-="+"\nPergunta N"+i);
            System.out.println("Descrição:");
            System.out.println(Checklist.perguntas.get(i).getDescricao());
            System.out.print("Avaliador:");
            System.out.println(Checklist.perguntas.get(i).getAvaliador());
            System.out.println("Observações:");
            if (Checklist.perguntas.get(i).getObservacoes() == null){
                System.out.println("Sem Observações");
            } else {
                System.out.println(Checklist.perguntas.get(i).getObservacoes());
            }
            System.out.println("Ação Corretiva:");
            if (Checklist.perguntas.get(i).getAcao() == null){
                System.out.println("Sem Observações");
            } else {
                System.out.println(Checklist.perguntas.get(i).getAcao());
            }
            System.out.print("Responsavél da área:");
            System.out.println(Checklist.perguntas.get(i).getResponsavel());
            System.out.print("Resultado:");
            if (Checklist.perguntas.get(i).getResultado() == null){
                System.out.println("Não Avaliado");
            } else {
                System.out.println(Checklist.perguntas.get(i).getResultado());
            }
        }
    }

}
