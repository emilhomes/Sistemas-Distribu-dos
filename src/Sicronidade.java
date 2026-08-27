public class Sicronidade implements Runnable{

    private String nome;
    private int tempo;

    public Sicronidade(String nome, int tempo) {
        this.nome = nome;
        this.tempo = tempo;
    }

    @Override
    public void run() {

        try {
            for(int i = 1; i <= 5; i++) {
                System.out.println(nome);
                Thread.sleep(tempo);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(nome + " terminou a execução.");

    }

}

class Imprimir {
    public static void main(String[] args) {

        Sicronidade c1 = new Sicronidade("Thread A", 1000);
        Sicronidade c2 = new Sicronidade("Thread B", 1000);
        Sicronidade c3 = new Sicronidade("Thread C", 1000);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);

        t1.start();
        t2.start();
        t3.start();

    }
}

/*

Quando você inicia múltiplas threads, a ordem exata em que elas ganham acesso ao processador não é garantida.
Isso ocorre porque as threads são tratadas como unidades de escalonamento independentes. O componente do sistema operacional
chamado escalonador é quem avalia as tarefas que estão prontas e define a ordem de execução.

Thread A
Thread C
Thread B
Thread C
Thread A
Thread B
Thread C
Thread A
Thread B
Thread A
Thread C
Thread B
Thread C
Thread A
Thread B

* */