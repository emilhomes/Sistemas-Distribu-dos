import java.io.*;
import java.net.*;

public class ClienteTCP {
    public static void main(String[] args) throws IOException, InterruptedException {
        String ipServidor = "192.168.10.1";
        int porta = 6000;

        Socket socket = new Socket(ipServidor, porta);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);

        String[] requisicoes = { "PRIMO;17", "PRIMO;18", "PRIMO;97" };

        for (String req : requisicoes) {
            System.out.println("Enviando: " + req);
            saida.println(req);
            String resposta = entrada.readLine();
            System.out.println("Resposta do servidor: " + resposta);
            Thread.sleep(3000);
        }

        socket.close();
    }
}