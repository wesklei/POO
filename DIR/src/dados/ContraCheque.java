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
public class ContraCheque {
    private int numProtocolo;
    private int codCC;

    public int getCodCC() {
        return codCC;
    }

    public void setCodCC(int codCC) {
        this.codCC = codCC;
    }
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
