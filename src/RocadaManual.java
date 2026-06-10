public class RocadaManual extends IntervencaoOperacional {

    public RocadaManual() {
        super("Ro\u00e7ada Manual");
    }

    @Override
    public void executarServico(TrechoRodovia trecho) {
        // Acesso dificil costuma pedir equipe manual por seguranca e precisao.
        System.out.println("Executando ro\u00e7ada manual no KM " + trecho.getKmInicial()
                + " ao KM " + trecho.getKmFinal() + ".");
    }
}
