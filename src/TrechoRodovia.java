public class TrechoRodovia {
    private int kmInicial;
    private int kmFinal;
    private double alturaVegetacao;
    private String tipoAmbiente;
    private boolean acessoDificil;

    public TrechoRodovia(int kmInicial, int kmFinal, double alturaVegetacao, String tipoAmbiente, boolean acessoDificil) {
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.alturaVegetacao = alturaVegetacao;
        this.tipoAmbiente = tipoAmbiente;
        this.acessoDificil = acessoDificil;
    }

    public int getKmInicial() {
        return kmInicial;
    }

    public int getKmFinal() {
        return kmFinal;
    }

    public double getAlturaVegetacao() {
        return alturaVegetacao;
    }

    public void setAlturaVegetacao(double alturaVegetacao) {
        this.alturaVegetacao = alturaVegetacao;
    }

    public String getTipoAmbiente() {
        return tipoAmbiente;
    }

    public boolean isAcessoDificil() {
        return acessoDificil;
    }

    public void simularCrescimento() {
        // O ambiente influencia diretamente a velocidade de crescimento.
        if (tipoAmbiente.equalsIgnoreCase("umido")) {
            alturaVegetacao += 15;
        } else if (tipoAmbiente.equalsIgnoreCase("seco")) {
            alturaVegetacao += 5;
        } else {
            alturaVegetacao += 10;
        }
    }

    public void exibirDados() {
        System.out.println("Trecho KM " + kmInicial + " ao KM " + kmFinal);
        System.out.println("Altura da vegeta\u00e7\u00e3o: " + alturaVegetacao + " cm");
        System.out.println("Tipo de ambiente: " + tipoAmbiente);
        System.out.println("Acesso dif\u00edcil: " + (acessoDificil ? "Sim" : "N\u00e3o"));
    }
}
