public class RocadaMecanizada extends IntervencaoOperacional {

    public RocadaMecanizada() {
        super("Ro\u00e7ada Mecanizada");
    }

    @Override
    public void executarServico(TrechoRodovia trecho) {
        // Usada quando ha altura critica e espaco para operar equipamento.
        System.out.println("Executando ro\u00e7ada mecanizada no KM " + trecho.getKmInicial()
                + " ao KM " + trecho.getKmFinal() + ".");
    }
}
