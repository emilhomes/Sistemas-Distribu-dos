public class Contagem {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {

            for (int i = 1; i <= 3; i++) {

                System.out.println(i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        t.start();
    }
}

// a) Faz a thread atual pausar sua execução por 1000 milissegundos (1 segundo).
// b) 3 vezes — uma a cada iteração do laço for.
// c) Não necessariamente. O sleep garante um tempo mínimo de pausa, pode ser que o println demore alguns milissegundos a mais para ser executado por exemplo.
// d) O estado TIMED_WAITING.Ficando bloqueada por um tempo determinado antes de voltar ao estado executável (RUNNABLE).