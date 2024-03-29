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
        double result = (((double) conforme / tamanho) * 100);
        if (Double.isNaN(result)){
            return 0;
        } else {
            return result;
        }
    }

    public static double verbaixa(){
        int baixa = 0;
        int tamanho = vernull();
        for (Pergunta pergunta : perguntas) {
            if (Objects.equals(pergunta.getResultado(), "Não Conforme - Prioridade Baixa")) {
                baixa += 1;
            }
        }
        double result = (((double) baixa / tamanho) * 100);
        if (Double.isNaN(result)){
            return 0;
        } else {
            return result;
        }
    }
    public static double vermedia(){
        int media = 0;
        int tamanho = vernull();
        for (Pergunta pergunta : perguntas) {
            if (Objects.equals(pergunta.getResultado(), "Não Conforme - Prioridade Média")) {
                media += 1;
            }
        }
        double result = (((double) media / tamanho) * 100);
        if (Double.isNaN(result)){
            return 0;
        } else {
            return result;
        }
    }
    public static double veralta(){
        int alta = 0;
        int tamanho = vernull();
        for (Pergunta pergunta : perguntas) {
            if (Objects.equals(pergunta.getResultado(), "Não Conforme - Prioridade Alta")) {
                alta += 1;
            }
        }
        double result = (((double) alta / tamanho) * 100);
        if (Double.isNaN(result)){
            return 0;
        } else {
            return result;
        }
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
    public static String conformidade(int op){
        if (op == 1){
            return "Conforme";
        }
        if (op == 2){
            return "Não Conforme - Prioridade Baixa";
        }
        if (op == 3){
            return "Não Conforme - Prioridade Média";
        }
        if (op == 4){
            return "Não Conforme - Prioridade Alta";
        }
        return null;
    }
    public static void verPerguntas(){
        for (int i = 0; i < Checklist.perguntas.size(); i++){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-="+"\nPergunta N"+(i+1));
            System.out.println("Descrição: ");
            System.out.println(Checklist.perguntas.get(i).getDescricao());
            System.out.print("Avaliador: ");
            if(Checklist.perguntas.get(i).getAvaliador() == null){
                System.out.println("Sem avaliador");
            } else {
                System.out.println(Checklist.perguntas.get(i).getAvaliador().getNome());
            }
            System.out.println("Observações: ");
            if (Checklist.perguntas.get(i).getObservacoes() == null){
                System.out.println("Sem Observações");
            } else {
                System.out.println(Checklist.perguntas.get(i).getObservacoes());
            }
            System.out.println("Ação Corretiva: ");
            if (Checklist.perguntas.get(i).getAcao() == null){
                System.out.println("Sem Especifições");
            } else {
                System.out.println(Checklist.perguntas.get(i).getAcao());
            }
            System.out.print("Responsavél da área: ");
            System.out.println(Checklist.perguntas.get(i).getResponsavel());
            System.out.print("Resultado: ");
            if (Checklist.perguntas.get(i).getResultado() == null){
                System.out.println("Não Avaliado");
            } else {
                System.out.println(Checklist.perguntas.get(i).getResultado());
            }
        }
    }

}
