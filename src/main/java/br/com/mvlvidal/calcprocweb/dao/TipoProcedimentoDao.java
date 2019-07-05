package br.com.mvlvidal.calcprocweb.dao;

import br.com.mvlvidal.calcprocweb.model.TipoProcedimento;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TipoProcedimentoDao {
    
    public List<String> carregaTipos(){
        
        List<TipoProcedimento> tiposProc = Arrays.asList(TipoProcedimento.values());
        
        List<String> lista = new ArrayList<>();
        
        for (int i = 0; i < tiposProc.size(); i++) {
            lista.add(tiposProc.get(i).getNome());
        }
        
        return lista;
    }
    
}
