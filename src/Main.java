public class Main {
    public static void main(String[] args) {

        // Dados de exemplo para simular diferentes cenarios da rodovia.
        TrechoRodovia[] trechos = new TrechoRodovia[5];

        trechos[0] = new TrechoRodovia(10, 11, 20, "seco", false);
        trechos[1] = new TrechoRodovia(12, 13, 45, "normal", false);
        trechos[2] = new TrechoRodovia(14, 15, 75, "umido", false);
        trechos[3] = new TrechoRodovia(16, 17, 80, "umido", true);
        trechos[4] = new TrechoMonitoradoIoT(18, 19, 25, "umido", false, 101);

        System.out.println("SISTEMA DE MONITORAMENTO DE VEGETA\u00c7\u00c3O EM RODOVIAS");
        System.out.println();

        // Trechos com IoT atualizam a estimativa antes da analise final.
        for (int i = 0; i < trechos.length; i++) {
            if (trechos[i] instanceof MonitoravelViaIoT) {
                MonitoravelViaIoT trechoMonitorado = (MonitoravelViaIoT) trechos[i];
                trechoMonitorado.transmitirDadosSensor();
                System.out.println();
            }
        }

        MotorDeRegras motor = new MotorDeRegras();
        motor.gerarRelatorioPrioridade(trechos);
    }
}
