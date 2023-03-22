package model;

import java.util.Date;

public class Movimentacao {
    private int tipo, categoria;
    private Date data;
    private int valor;
    private String descricao;
    private boolean pago;

    public Movimentacao(int tipo, int categoria, Date data, int valor, String descricao, boolean pago) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
        this.pago = pago;
    }

    public Movimentacao(int tipo, int categoria, Date data, int valor) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
        this.pago = true;
    }

    public Movimentacao() {
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
