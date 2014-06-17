/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao.tablemodel;

import apresentacao.ErrorDialog;
import apresentacao.mascara.MascaraCnpj;
import apresentacao.mascara.MascaraMoeda;
import dados.ContraCheque;
import excecoes.Tratador;
import java.math.BigDecimal;
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
public class ContraChequeTableModel extends AbstractTableModel {
    //constantes que vão representar as colunas
    //(só para facilitar o entendimento do código)
    private final int COL_PROTO = 0;
    private final int COL_CNPJ = 1;
    private final int COL_VAL = 2;
    
    List<ContraCheque> contraCheques;
    
    public ContraChequeTableModel(){
        contraCheques = new ArrayList<ContraCheque>();
    }
    
    public ContraChequeTableModel(List<ContraCheque> nf){
        this();
        contraCheques.addAll(nf);
    }
    
    public ContraCheque getContraCheque(int pos){
        return contraCheques.get(pos);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == COL_PROTO) {
            return Integer.class;
        } else if (columnIndex == COL_CNPJ) {
            return Long.class;
        } else if (columnIndex == COL_VAL) {
            return BigDecimal.class;
        }
        
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
         //qual o nome da coluna
        if (column == COL_PROTO) {
            return "Protocolo";
        } else if (column == COL_CNPJ) {
            return "Cnpj";
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
       return contraCheques.size();
    }

    @Override
    public int getColumnCount() {
        //sao 3 colunas
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ContraCheque cc = contraCheques.get(rowIndex);
        if (columnIndex == COL_PROTO) {
            return cc.getNumProtocolo();
        } else if (columnIndex == COL_CNPJ) {
            try {
                return MascaraCnpj.mascaraCpf(cc.getCnpj());
            } catch (ParseException ex) {
                 new Tratador().capturaExcecao(ex);
                 new ErrorDialog(null, true).setVisible(true);
                }
        } else if (columnIndex == COL_VAL) {
            return MascaraMoeda.mascaraDinheiro(cc.getValor(), MascaraMoeda.DINHEIRO_REAL);
        }
        return "";
    }
    
}
