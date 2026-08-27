public class Juncao {

    public static void main(String[] args)
            throws InterruptedException {

        Thread t = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
            }

        });

        t.start();

        // t.join();

        System.out.println("Fim");
    }
}

// a) Faz a thread que chamou o método parar e esperar até que a thread termine completamente sua execução.
// b) Não, Como a main chama t.join(), ela fica bloqueada até que a thread t finalize todo o seu laço. Só depois imprime "Fim".
// c) A thread main. Ela é quem chama t.join() e, por isso, fica bloqueada.
// d) Sim, pode mudar.A main não espera mais a thread t terminar ela continua imediatamente após t.start().
// Exemplo sem o join: 
// Fim
// 1
// 2
// 3
// 4
// 5