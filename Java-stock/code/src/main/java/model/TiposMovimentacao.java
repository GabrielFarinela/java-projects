package model;

import java.util.Date;

public class TiposMovimentacao {
    String descricao;

    public TiposMovimentacao(String descricao) {
        this.descricao = descricao;
    }

    public TiposMovimentacao() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TiposMovimentacao{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
