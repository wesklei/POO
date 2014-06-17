/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao.tablemodel;

import apresentacao.ErrorDialog;
import apresentacao.mascara.MascaraCpf;
import dados.Dependente;
import excecoes.Tratador;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author localhost
 */
public class DependenteTableModel extends AbstractTableModel{
//constantes que vão representar as colunas
    //(só para facilitar o entendimento do código)
    private final int COL_NOME = 0;
    private final int COL_CPF = 1;
    private final int COL_IDAD = 2;
    
    private List<Dependente> dependentes;
    
     public DependenteTableModel(){
        dependentes = new ArrayList<Dependente>();        
    }
    
    public DependenteTableModel(List<Dependente> d){
        this();
        dependentes.addAll(d);
    }
    
    public List<Dependente> getDependentes(){
        return this.dependentes;
    }
    
    
    public Dependente getDependente(int pos){
        return dependentes.get(pos);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == COL_NOME) {
            return String.class;
        } else if (columnIndex == COL_CPF) {
            return Long.class;
        } else if (columnIndex == COL_IDAD) {
            return Integer.class;
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
        } else if (column == COL_IDAD) {
            return "Idade";
        }
        
        return "";
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public int getRowCount() {
        return dependentes.size();
    }

    @Override
    public int getColumnCount() {
        //apenas tres colunas
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dependente d = dependentes.get(rowIndex);
        if (columnIndex == COL_NOME) {
            return d.getNome();
        } else if (columnIndex == COL_CPF) {
                        
            try {
                         
                return MascaraCpf.mascaraCpf(d.getCpf());
                
                } catch (ParseException ex) {
                     new Tratador().capturaExcecao(ex);
                     new ErrorDialog(null, true).setVisible(true);
                }
        }else if (columnIndex == COL_IDAD) {
            return d.getIdade();            
        }
        return "";
    }
    
}

