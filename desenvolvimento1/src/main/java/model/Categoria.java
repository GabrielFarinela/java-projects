package model;

public class Categoria {
    String descricao;

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public Categoria() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
