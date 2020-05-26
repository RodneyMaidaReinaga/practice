/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.practice4;

import java.util.List;

/**
 * Class that represent a Pedido, a Pedido can have multiple Detalle objects, so the Pedido object has the variables
 * codPedido, that represents the code of the Pedido, the tipoPedido that represents the type of the pedido,
 * the cliente which is the name of the client that made the Pedido, fecha which represents the date when the Pedido
 * was made and a detalleList that has the list of the Detalle objects related with a Pedido
 *
 * @author Rodney
 * @version 1.1
 */

public class Pedido {
    private String codPedido;
    private String tipoPedido;
    private String cliente;
    private String fecha;
    private List<Detalle> detalleList;

    /**
     * Constructor of the class Pedido
     *
     * @param codPedido: code of the Pedido object
     * @param tipoPedido: type of the pedido object
     * @param cliente: name of the client that made the pedido
     * @param fecha: date when the pedido was made
     * @param detalleList: List of the DEtalle objects reltaed with the pedido
     */

    public Pedido(String codPedido, String tipoPedido, String cliente, String fecha, List<Detalle> detalleList) {
        this.codPedido = codPedido;
        this.tipoPedido = tipoPedido;
        this.cliente = cliente;
        this.fecha = fecha;
        this.detalleList = detalleList;
    }

    /**
     * Get method that retuns a String that represent the code of the Pedido (codPedido)
     *
     * @return the codPedido value
     */

    public String getCodPedido() {
        return codPedido;
    }

    /**
     * Set method that allows to set the codPedido value
     *
     * @param codPedido is a string that represents the code of the Pedido
     */

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    /**
     * Get method that retuns thetipoPedido value
     *
     * @return a String that represents the type of pedido made
     */

    public String getTipoPedido() {
        return tipoPedido;
    }

    /**
     * Set method that allows to set tbe thetype ofthe pedido
     *
     * @param tipoPedido is a Stringthat represents the type of pedido made
     */

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    /**
     * Get method that retuns the name of the cliente that made the pedido
     *
     * @return a string that represents the name of the cliente that made the pedido
     */

    public String getCliente() {
        return cliente;
    }

    /**
     * Set method that allows to set the name of the cliente that made the pedido
     *
     * @param cliente value
     */

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Get method that retuns the date of when the pedido was made
     *
     * @returna String that represents the date ofwhen the pedido waw made
     */

    public String getFecha() {
        return fecha;
    }

    /**
     * Set method that allows to set the name of the client that made the pedido
     *
     * @param fecha is a stringvalue that represents the date of when the pedido was made
     */

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Get method that retuns the value of the detalleList, whic is a list of Detalle objects that are related with
     * the pedido objects that you made
     *
     * @return a List of Detalle objects
     */

    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    /**
     * Set method that allows to set the detalleList of the object
     *
     * @param detalleList
     */

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }

    /**
     * Override of the toString method in order to display all the information related with the pedido as a string
     *
     * @return a string that represents a String that descripe the pedido oject
     */

    @Override
    public String toString() {
        return this.getCodPedido() + " | " + this.getTipoPedido() + " | " + this.getCliente() + " | " + this.getFecha();
    }
}