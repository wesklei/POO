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
public class NotaFiscal {
    private int codNF;

    public int getCodNF() {
        return codNF;
    }

    public void setCodNF(int codNF) {
        this.codNF = codNF;
    }
    private int numProtocolo;
    private String cnpj;
    private BigDecimal valor;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getNumProtocolo() {
        return numProtocolo;
    }

    public void setNumProtocolo(int numProtocolo) {
        this.numProtocolo = numProtocolo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
