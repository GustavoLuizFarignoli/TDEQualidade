import java.io.Serializable;

public class Avaliador implements Serializable {
    private String nome;

    public Avaliador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
