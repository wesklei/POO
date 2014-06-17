/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.math.BigDecimal;

/**
 *
 * @author localhost
 */
public class Bem {
    private String nome;
    private String tipo;
    private BigDecimal valor;
    private int codBem;

    public int getCodBem() {
        return codBem;
    }

    public void setCodBem(int codBem) {
        this.codBem = codBem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
