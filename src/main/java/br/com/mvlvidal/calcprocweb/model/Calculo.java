/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvlvidal.calcprocweb.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Marcus Vidal
 */
public class Calculo implements Serializable{

    private Float valorCo;
    private Float valorPorteMedico;
    private Float valorFilme;
    private Float valorCh;
    private List<Float> valoresAuxilio;
    private Float total;
    private Float subtotal;
    private Integer qtdAuxilio;
    private Float valorPorteAnestesico;

    public Float getValorCo() {
        return valorCo;
    }

    public void setValorCo(Float valorCo) {
        this.valorCo = valorCo;
    }

    public Float getValorPorteMedico() {
        return valorPorteMedico;
    }

    public void setValorPorteMedico(Float valorPorteMedico) {
        this.valorPorteMedico = valorPorteMedico;
    }

    public Float getValorFilme() {
        return valorFilme;
    }

    public void setValorFilme(Float valorFilme) {
        this.valorFilme = valorFilme;
    }

    public Float getValorCh() {
        return valorCh;
    }

    public void setValorCh(Float valorCh) {
        this.valorCh = valorCh;
    } 

    /**
     * @return the total
     */
    public Float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Float total) {
        this.total = total;
    }

    /**
     * @return the subtotal
     */
    public Float getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the valoresAuxilio
     */
    public List<Float> getValoresAuxilio() {
        return valoresAuxilio;
    }

    /**
     * @param valoresAuxilio the valoresAuxilio to set
     */
    public void setValoresAuxilio(List<Float> valoresAuxilio) {
        this.valoresAuxilio = valoresAuxilio;
    }

    /**
     * @return the qtdAuxilio
     */
    public Integer getQtdAuxilio() {
        return qtdAuxilio;
    }

    /**
     * @param qtdAuxilio the qtdAuxilio to set
     */
    public void setQtdAuxilio(Integer qtdAuxilio) {
        this.qtdAuxilio = qtdAuxilio;
    }

    /**
     * @return the valorPorteAnestesico
     */
    public Float getValorPorteAnestesico() {
        return valorPorteAnestesico;
    }

    /**
     * @param valorPorteAnestesico the valorPorteAnestesico to set
     */
    public void setValorPorteAnestesico(Float valorPorteAnestesico) {
        this.valorPorteAnestesico = valorPorteAnestesico;
    }

    
}
