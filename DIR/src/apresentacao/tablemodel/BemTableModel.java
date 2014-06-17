/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao.tablemodel;

import apresentacao.mascara.MascaraMoeda;
import dados.Bem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author localhost
 */
public class BemTableModel extends AbstractTableModel {
    //constantes que vão representar as colunas
    //(só para facilitar o entendimento do código)
    private final int COL_DESC = 0;
    private final int COL_TIPO = 1;
    private final int COL_VAL = 2;
    
    List<Bem> bens;
    
    public BemTableModel(){
        bens = new ArrayList<Bem>();
    }
    
    public BemTableModel(List<Bem> bm){
        this();
        bens.addAll(bm);
    }
    
    public List<Bem> getBens(){
        return this.bens;
    }
    
    public Bem getBem(int pos){
        return bens.get(pos);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == COL_DESC) {
            return String.class;
        } else if (columnIndex == COL_TIPO) {
            return String.class;
        } else if (columnIndex == COL_VAL) {
            return BigDecimal.class;
        }
        
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
         //qual o nome da coluna
        if (column == COL_DESC) {
            return "Descrição";
        } else if (column == COL_TIPO) {
            return "Tipo";
        } else if (column == COL_VAL) {
            return "Valor";
        }
        
        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public int getRowCount() {
       return bens.size();
    }

    @Override
    public int getColumnCount() {
        //sao 3 colunas
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bem b = bens.get(rowIndex);
        if (columnIndex == COL_DESC) {
            return b.getNome();
        } else if (columnIndex == COL_TIPO) {
            return b.getTipo();
        } else if (columnIndex == COL_VAL) {
            BigDecimal valor = b.getValor();
            return MascaraMoeda.mascaraDinheiro(valor, MascaraMoeda.DINHEIRO_REAL);
        }
        return "";
    }
    
}

