/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao.tablemodel;

import apresentacao.ErrorDialog;
import apresentacao.mascara.MascaraCpf;
import dados.Contribuinte;
import excecoes.Tratador;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author localhost
 */
public class ContribuinteTableModel extends AbstractTableModel{
    //constantes que vão representar as colunas
    //(só para facilitar o entendimento do código)
    private final int COL_NOME = 0;
    private final int COL_CPF = 1;
    private final int COL_CONTAB = 2;
    
    private List<Contribuinte> contribuintes;
    
    public ContribuinteTableModel(){
        contribuintes = new ArrayList<Contribuinte>();        
    }
    
    public ContribuinteTableModel(List<Contribuinte> c){
        this();
        contribuintes.addAll(c);
    }
    
    public Contribuinte getContribuinte(int pos){
        return contribuintes.get(pos);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == COL_NOME) {
            return String.class;
        } else if (columnIndex == COL_CPF) {
            return Long.class;
        } else if (columnIndex == COL_CONTAB) {
            return Long.class;
        }
        
        return String.class;
    }
    
    @Override
    public String getColumnName(int column) {
         //qual o nome da coluna
        if (column == COL_NOME) {
            return "Nome";
        } else if (column == COL_CPF) {
            return "Cpf";
        } else if (column == COL_CONTAB) {
            return "Conta Bancária";
        }
        
        return "";
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public int getRowCount() {
        return contribuintes.size();
    }

    @Override
    public int getColumnCount() {
        //apenas tres colunas
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contribuinte c = contribuintes.get(rowIndex);
        if (columnIndex == COL_NOME) {
            return c.getNome();
        } else if (columnIndex == COL_CPF) {
                
            try {
                         
                return MascaraCpf.mascaraCpf(c.getCpf());
                
                } catch (ParseException ex) {
                     new Tratador().capturaExcecao(ex);
                     new ErrorDialog(null, true).setVisible(true);
                }

        } else if (columnIndex == COL_CONTAB) {
            return c.getContaBancaria();            
        }
        return "";
    }
    
}
