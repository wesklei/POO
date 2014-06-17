/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author localhost
 */
public class Dependente {
    
    private String cpf;
    private String nome;
    private int idade;
    private String endereco;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
            
    
}
