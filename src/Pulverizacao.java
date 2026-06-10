public class Pulverizacao extends IntervencaoOperacional {

    public Pulverizacao() {
        super("Pulveriza\u00e7\u00e3o");
    }

    @Override
    public void executarServico(TrechoRodovia trecho) {
        // Servico indicado quando a vegetacao ainda nao exige rocada pesada.
        System.out.println("Executando pulveriza\u00e7\u00e3o no KM " + trecho.getKmInicial()
                + " ao KM " + trecho.getKmFinal() + ".");
    }
}
