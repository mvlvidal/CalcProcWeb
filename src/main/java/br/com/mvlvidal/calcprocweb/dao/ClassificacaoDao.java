package br.com.mvlvidal.calcprocweb.dao;

import br.com.mvlvidal.calcprocweb.model.Classificacao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassificacaoDao {

    public List<String> carregaClassific() {

        List<Classificacao> classificacoes = Arrays.asList(Classificacao.values());
        List<String> lista = new ArrayList<>();

        for (int i = 0; i < classificacoes.size(); i++) {
            lista.add(classificacoes.get(i).getNome());
        }
        
        return lista;
    }

}
