/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao.tablemodel;

import apresentacao.ErrorDialog;
import apresentacao.mascara.MascaraCnpj;
import dados.PessoaJuridica;
import excecoes.Tratador;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author localhost
 */
public class PessoaJuridicaTableModel extends AbstractTableModel{

    //constantes que vão representar as colunas
    //(só para facilitar o entendimento do código)
    private final int COL_NOME = 0;
    private final int COL_CNPJ = 1;
    private final int COL_END = 2;
    
    private List<PessoaJuridica> pj;

    public PessoaJuridicaTableModel(){
        pj = new ArrayList<PessoaJuridica>();
    }
    
    public PessoaJuridicaTableModel(List<PessoaJuridica> pessoaJuridica){
        this();
        pj.addAll(pessoaJuridica);
    }
    
    public PessoaJuridica getPessoaJuridica(int pos){
          return pj.get(pos);
    }
        
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == COL_NOME) {
            return String.class;
        } else if (columnIndex == COL_CNPJ) {
            return Long.class;
        } else if (columnIndex == COL_END) {
            return String.class;
        }
        
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
         //qual o nome da coluna
        if (column == COL_NOME) {
            return "Nome";
        } else if (column == COL_CNPJ) {
            return "Cnpj";
        } else if (column == COL_END) {
            return "Endereço";
        }
        
        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public int getRowCount() {
        return pj.size();
    }

    @Override
    public int getColumnCount() {
        return 3; //serao tres colunas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PessoaJuridica pessoaJuridica = pj.get(rowIndex);
        if (columnIndex == COL_NOME) {
            return pessoaJuridica.getNomePJ();
        } else if (columnIndex == COL_CNPJ) {
          
            try {
                
                return MascaraCnpj.mascaraCpf(pessoaJuridica.getCnpj());
            
            } catch (ParseException ex) {
                     new Tratador().capturaExcecao(ex);
                     new ErrorDialog(null, true).setVisible(true);
                }
        } else if (columnIndex == COL_END) {
            return pessoaJuridica.getEndereco();
        }
        return "";
    }
    
}
