import java.io.*;

public class Serializador {
    public static void gravar(String nome_arquivo, Object objeto) throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nome_arquivo);
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);
        gravador.writeObject(objeto);
        gravador.close();
        arquivo.close();
    }
    public static Object ler(String nome_arquivo) throws IOException, ClassNotFoundException {
        FileInputStream arquivo = new FileInputStream(nome_arquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);
        Object objeto = restaurador.readObject();
        restaurador.close();
        arquivo.close();
        return objeto;
    }
}
