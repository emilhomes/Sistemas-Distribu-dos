public class MinhaThread extends Thread {

    private String nome;
    private int tempo;

    public MinhaThread(String nome, int tempo) {
        this.nome = nome;
        this.tempo = tempo;
    }

    @Override
    public void run() {
        System.out.println("Thread em execução!");
        System.out.println(nome + " terminou a execução.");
    }

}

class Principal {
    public static void main(String[] args) {
        MinhaThread minhaThread = new MinhaThread("Thread1", 1000);
        minhaThread.start();
    }
}

//a) É o metodo run(), é dentro dele que colocamos o código que a thread deve executar.
//b) É o metodo start(), é o responsável por inicializar a thread, permitindo que ela seja escalonada para execução independente.
//c) O metodo run() será executado como uma chamada normal de metodo, dentro da thread que já está executando o main, uma nova thread não será iniciada.