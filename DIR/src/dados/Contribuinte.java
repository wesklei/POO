/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author localhost
 */
public class Contribuinte {
    private String cpf;
    private String nome;
    private int idade;
    private String endereco;
    private long contaBancaria;
    private ArrayList<NotaFiscal> despesas;
    private ArrayList<ContraCheque> receitas;
    private BigDecimal totalReceitas;
    private BigDecimal totalDespesas;

    public long getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(long contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public NotaFiscal getNotaFiscal(int index){
        return this.despesas.get(index);
    }
    
    public void addNotaFiscal(NotaFiscal notaFiscal){
        this.despesas.add(notaFiscal);
    }
    
    public void removerNotaFiscal(NotaFiscal notaFiscal){
        this.despesas.remove(notaFiscal);
    }
    
    public void removerNotaFiscal(int index){
        this.despesas.remove(index);
    }

    public ArrayList<NotaFiscal> getDespesas() {
        return despesas;
    }

    public void setDespesas(ArrayList<NotaFiscal> despesas) {
        this.despesas = despesas;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public ContraCheque getContraCheque(int index){
        return this.receitas.get(index);
    }
    
    public void addContraCheque(ContraCheque contraCheque){
        this.receitas.add(contraCheque);
    }
    
    public void removerContraCheque(ContraCheque contraCheque){
        this.receitas.remove(contraCheque);
    }
    
    public void removerContraCheque(int index){
        this.receitas.remove(index);
    }

    public ArrayList<ContraCheque> getReceitas() {
        return receitas;
    }

    public void setReceitas(ArrayList<ContraCheque> receitas) {
        this.receitas = receitas;
    }

    public BigDecimal getTotalDespesas() {
        return totalDespesas;
    }
    
    public BigDecimal getTotalReceitas() {
        return totalReceitas;
    }     
}
