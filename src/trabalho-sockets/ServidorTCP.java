import java.io.*;
import java.net.*;

public class ServidorTCP {
    public static void main(String[] args) throws IOException {
        int porta = 6000;
        ServerSocket serverSocket = new ServerSocket(porta);
        System.out.println("Servidor TCP escutando na porta " + porta + "...");

        while (true) {
            Socket cliente = serverSocket.accept();
            System.out.println("Novo cliente conectado: " + cliente.getInetAddress());
            new Thread(new TratadorClienteTCP(cliente)).start();
        }
    }
}

class TratadorClienteTCP implements Runnable {
    private Socket socket;

    public TratadorClienteTCP(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String linha;
            while ((linha = entrada.readLine()) != null) {
                System.out.println("[" + socket.getInetAddress() + "] Recebido: " + linha);
                String resposta = Consulta.processar(linha);
                saida.println(resposta);
            }
        } catch (IOException e) {
            System.out.println("Cliente desconectado: " + socket.getInetAddress());
        } finally {
            try { socket.close(); } catch (IOException ignored) {}
        }
    }
}