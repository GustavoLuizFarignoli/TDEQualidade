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
}
