package br.cefetmg.projeto4.dto;

    public enum EstadoManutencao {

        FALTANDO_PECAS("Faltando peças"),
        MAL_FUNCIONAMENTO("Mal funcionamento"),
        OUTRO("Outro");

        private String estado;

        EstadoManutencao(String estado) {
            this.estado = estado;
        }

        public String getEstado() {
            return estado;
        }
    }


