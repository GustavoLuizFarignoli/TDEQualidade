import java.io.Serializable;
import java.util.ArrayList;


public class Perguntas implements Serializable {
    private ArrayList<Pergunta> perguntas;

    public Perguntas(ArrayList<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public Perguntas() {
    }

    public ArrayList<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(ArrayList<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }
}
