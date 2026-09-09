public class Consulta {
    public static String processar(String requisicao) {
        try {
            String[] partes = requisicao.split(";");
            String comando = partes[0].toUpperCase();

            if (comando.equals("PRIMO")) {
                int n = Integer.parseInt(partes[1]);
                return n + (ehPrimo(n) ? " é PRIMO" : " NÃO é primo");
            }

            return "ERRO: comando desconhecido. Use PRIMO;n";
        } catch (Exception e) {
            return "ERRO: requisicao invalida (" + e.getMessage() + ")";
        }
    }

    private static boolean ehPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}