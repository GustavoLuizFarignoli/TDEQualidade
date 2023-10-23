public class Singleton {
    public static Avaliador instancia;

    public static Avaliador getInstance(String nome){
        if(instancia == null){
            instancia = new Avaliador(nome);
        } else {
            System.out.println("Já há um Avaliador ativo, faça logout antes de fazer um novo login");
        }
        return instancia;
    }

    public static void logout(){
        instancia = null;
    }

}