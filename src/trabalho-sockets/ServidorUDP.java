import java.net.*;
import java.util.concurrent.*;

public class ServidorUDP {
    public static void main(String[] args) throws Exception {
        int porta = 6001;
        DatagramSocket socket = new DatagramSocket(porta);
        System.out.println("Servidor UDP escutando na porta " + porta + "...");

        ExecutorService pool = Executors.newCachedThreadPool();

        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket pacoteRecebido = new DatagramPacket(buffer, buffer.length);
            socket.receive(pacoteRecebido); // bloqueia até chegar um pacote

            byte[] dados = pacoteRecebido.getData().clone();
            int tamanho = pacoteRecebido.getLength();
            InetAddress enderecoCliente = pacoteRecebido.getAddress();
            int portaCliente = pacoteRecebido.getPort();

            pool.submit(() -> tratarRequisicao(socket, dados, tamanho, enderecoCliente, portaCliente));
        }
    }

    private static void tratarRequisicao(DatagramSocket socket, byte[] dados, int tamanho,
                                          InetAddress endereco, int porta) {
        try {
            String requisicao = new String(dados, 0, tamanho).trim();
            System.out.println("[" + endereco + ":" + porta + "] Recebido: " + requisicao);

            String resposta = Consulta.processar(requisicao);
            byte[] respostaBytes = resposta.getBytes();
            DatagramPacket pacoteResposta = new DatagramPacket(respostaBytes, respostaBytes.length, endereco, porta);
            socket.send(pacoteResposta);
        } catch (Exception e) {
            System.out.println("Erro ao tratar requisicao: " + e.getMessage());
        }
    }
}