public class Contador implements Runnable {

    private String nome;
    private int tempo;

    public Contador(String nome, int tempo) {
        this.nome = nome;
        this.tempo = tempo;
    }

    @Override
    public void run() {

        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                Thread.sleep(tempo);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(nome + " terminou a execução.");
    }
}


class Teste {

    public static void main(String[] args) {

        Contador contador = new Contador("Thread1", 900);

        Thread thread1 = new Thread(contador);

        thread1.start();
    }
}

// a) A classe pode implementar Runnable sem precisar herdar de Thread. Isso permite que ela possa herdar de outra classe, já que Java não permite herança múltipla de classes.
// b) O objeto Contador
// c) O objeto Thread