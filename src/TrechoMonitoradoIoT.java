public class TrechoMonitoradoIoT extends TrechoRodovia implements MonitoravelViaIoT {
    private int codigoSensor;

    public TrechoMonitoradoIoT(int kmInicial, int kmFinal, double alturaVegetacao, String tipoAmbiente, boolean acessoDificil, int codigoSensor) {
        super(kmInicial, kmFinal, alturaVegetacao, tipoAmbiente, acessoDificil);
        this.codigoSensor = codigoSensor;
    }

    public int getCodigoSensor() {
        return codigoSensor;
    }

    @Override
    public void transmitirDadosSensor() {
        System.out.println("Sensor " + codigoSensor + " transmitindo dados do trecho KM "
                + getKmInicial() + " ao KM " + getKmFinal() + ".");

        // Simula a leitura atualizada antes de enviar os dados para o relatorio.
        simularCrescimento();

        System.out.println("Nova altura estimada da vegeta\u00e7\u00e3o: " + getAlturaVegetacao() + " cm");
    }
}
