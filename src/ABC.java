public class ABC{

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("A");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("B");
        });

        t1.start();
        t2.start();

        System.out.println("C");
    }
}

// a) Todas as quatro são saídas possíveis.
// b) Não tem ordem obrigatória, então a saída pode variar a cada execução.