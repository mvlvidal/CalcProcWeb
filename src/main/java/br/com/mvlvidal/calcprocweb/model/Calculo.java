/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvlvidal.calcprocweb.model;

import java.io.Serializable;

/**
 *
 * @author Marcus Vidal
 */
public class Calculo implements Serializable{

    private Float valorCo;
    private Float valorPorteMedico;
    private Float valorFilme;
    private Float valorCh;
    private Float valorAuxilio1;
    private Float valorAuxilio2;
    private Float valorAuxilio3;
    private Float total;
    private Float subtotal;
    private Float totalPorteMedico;
    private Float totalFilme;
    private Float totalCh;
    private Float totalAuxilio1;
    private Float totalAuxilio2;
    private Float totalAuxilio3;

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

    public Float getValorAuxilio1() {
        return valorAuxilio1;
    }

    public void setValorAuxilio1(Float valorAuxilio1) {
        this.valorAuxilio1 = valorAuxilio1;
    }

    public Float getValorAuxilio2() {
        return valorAuxilio2;
    }

    public void setValorAuxilio2(Float valorAuxilio2) {
        this.valorAuxilio2 = valorAuxilio2;
    }

    public Float getValorAuxilio3() {
        return valorAuxilio3;
    }

    public void setValorAuxilio3(Float valorAuxilio3) {
        this.valorAuxilio3 = valorAuxilio3;
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
     * @return the totalPorteMedico
     */
    public Float getTotalPorteMedico() {
        return totalPorteMedico;
    }

    /**
     * @param totalPorteMedico the totalPorteMedico to set
     */
    public void setTotalPorteMedico(Float totalPorteMedico) {
        this.totalPorteMedico = totalPorteMedico;
    }

    /**
     * @return the totalFilme
     */
    public Float getTotalFilme() {
        return totalFilme;
    }

    /**
     * @param totalFilme the totalFilme to set
     */
    public void setTotalFilme(Float totalFilme) {
        this.totalFilme = totalFilme;
    }

    /**
     * @return the totalCh
     */
    public Float getTotalCh() {
        return totalCh;
    }

    /**
     * @param totalCh the totalCh to set
     */
    public void setTotalCh(Float totalCh) {
        this.totalCh = totalCh;
    }

    /**
     * @return the totalAuxilio1
     */
    public Float getTotalAuxilio1() {
        return totalAuxilio1;
    }

    /**
     * @param totalAuxilio1 the totalAuxilio1 to set
     */
    public void setTotalAuxilio1(Float totalAuxilio1) {
        this.totalAuxilio1 = totalAuxilio1;
    }

    /**
     * @return the totalAuxilio2
     */
    public Float getTotalAuxilio2() {
        return totalAuxilio2;
    }

    /**
     * @param totalAuxilio2 the totalAuxilio2 to set
     */
    public void setTotalAuxilio2(Float totalAuxilio2) {
        this.totalAuxilio2 = totalAuxilio2;
    }

    /**
     * @return the totalAuxilio3
     */
    public Float getTotalAuxilio3() {
        return totalAuxilio3;
    }

    /**
     * @param totalAuxilio3 the totalAuxilio3 to set
     */
    public void setTotalAuxilio3(Float totalAuxilio3) {
        this.totalAuxilio3 = totalAuxilio3;
    }
    
    
}
