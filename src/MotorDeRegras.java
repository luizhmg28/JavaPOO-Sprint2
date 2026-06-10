public class MotorDeRegras {

    public void gerarRelatorioPrioridade(TrechoRodovia[] trechos) {
        System.out.println("========================================");
        System.out.println(" RELAT\u00d3RIO DE PRIORIDADE DE RO\u00c7ADA");
        System.out.println("========================================");

        for (int i = 0; i < trechos.length; i++) {
            TrechoRodovia trecho = trechos[i];
            AnalisePrioridade analise = analisarTrecho(trecho);

            System.out.println();
            System.out.println("Trecho " + (i + 1));
            System.out.println("----------------------------------------");
            trecho.exibirDados();
            System.out.println("Prioridade: " + analise.getPrioridade());
            System.out.println("Motivo: " + analise.getMotivo());
            System.out.println("A\u00e7\u00e3o recomendada: " + analise.getAcaoRecomendada());

            if (analise.getIntervencao() != null) {
                analise.getIntervencao().executarServico(trecho);
            }

            System.out.println("----------------------------------------");
        }
    }

    private AnalisePrioridade analisarTrecho(TrechoRodovia trecho) {
        double altura = trecho.getAlturaVegetacao();

        // Vegetacao baixa entra apenas como acompanhamento preventivo.
        if (altura < 30) {
            return new AnalisePrioridade(
                    "BAIXA",
                    "vegeta\u00e7\u00e3o abaixo de 30 cm, sem risco operacional no momento.",
                    "Apenas monitoramento.",
                    null
            );
        }

        // Altura intermediaria normalmente permite uma acao mais leve.
        if (altura <= 60) {
            IntervencaoOperacional intervencao = new Pulverizacao();
            return new AnalisePrioridade(
                    "M\u00c9DIA",
                    "vegeta\u00e7\u00e3o entre 30 cm e 60 cm.",
                    intervencao.getNomeServico() + ".",
                    intervencao
            );
        }

        if (trecho.isAcessoDificil()) {
            IntervencaoOperacional intervencao = new RocadaManual();
            return new AnalisePrioridade(
                    "ALTA",
                    "vegeta\u00e7\u00e3o acima de 60 cm em trecho de dif\u00edcil acesso.",
                    intervencao.getNomeServico() + ".",
                    intervencao
            );
        }

        IntervencaoOperacional intervencao = new RocadaMecanizada();
        return new AnalisePrioridade(
                "ALTA",
                "vegeta\u00e7\u00e3o acima de 60 cm em trecho com acesso adequado para equipamento.",
                intervencao.getNomeServico() + ".",
                intervencao
        );
    }

    // Guarda o resultado da avaliacao para deixar a impressao do relatorio mais limpa.
    private static class AnalisePrioridade {
        private String prioridade;
        private String motivo;
        private String acaoRecomendada;
        private IntervencaoOperacional intervencao;

        public AnalisePrioridade(String prioridade, String motivo, String acaoRecomendada, IntervencaoOperacional intervencao) {
            this.prioridade = prioridade;
            this.motivo = motivo;
            this.acaoRecomendada = acaoRecomendada;
            this.intervencao = intervencao;
        }

        public String getPrioridade() {
            return prioridade;
        }

        public String getMotivo() {
            return motivo;
        }

        public String getAcaoRecomendada() {
            return acaoRecomendada;
        }

        public IntervencaoOperacional getIntervencao() {
            return intervencao;
        }
    }
}
