public abstract class IntervencaoOperacional {
    private String nomeServico;

    public IntervencaoOperacional(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    // Cada tipo de intervencao define sua propria forma de execucao.
    public abstract void executarServico(TrechoRodovia trecho);
}
