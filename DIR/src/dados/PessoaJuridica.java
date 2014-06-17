/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.ArrayList;

/**
 *
 * @author localhost
 */
public class PessoaJuridica {
    private ArrayList<ContraCheque> contraCheques;
    private ArrayList<NotaFiscal> notasFiscais;
    private String cnpj;
    private String nomePJ;
    private String endereco;
    private int numFuncionarios;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public ContraCheque getContraCheque(int index){
        return this.contraCheques.get(index);
    }
    
    public void addContraCheque(ContraCheque contraCheque){
        this.contraCheques.add(contraCheque);
    }
    
    public void removerContraCheque(ContraCheque contraCheque){
        this.contraCheques.remove(contraCheque);
    }
    
    public void removerContraCheque(int index){
        this.contraCheques.remove(index);
    }

    public ArrayList<ContraCheque> getContraCheques() {
        return contraCheques;
    }

    public void setContraCheques(ArrayList<ContraCheque> contraCheques) {
        this.contraCheques = contraCheques;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNomePJ() {
        return nomePJ;
    }

    public void setNomePJ(String nomePJ) {
        this.nomePJ = nomePJ;
    }
    
    public NotaFiscal getNotaFiscal(int index){
        return this.notasFiscais.get(index);
    }
    
    public void addNotaFiscal(NotaFiscal notaFiscal){
        this.notasFiscais.add(notaFiscal);
    }
    
    public void removerNotaFiscal(NotaFiscal notaFiscal){
        this.notasFiscais.remove(notaFiscal);
    }
    
    public void removerNotaFiscal(int index){
        this.notasFiscais.remove(index);
    }
    public ArrayList<NotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }

    public void setNotasFiscais(ArrayList<NotaFiscal> notasFiscais) {
        this.notasFiscais = notasFiscais;
    }

    public int getNumFuncionarios() {
        return numFuncionarios;
    }

    public void setNumFuncionarios(int numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }
}
