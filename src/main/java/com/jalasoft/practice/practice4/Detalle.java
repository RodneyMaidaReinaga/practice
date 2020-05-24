/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.practice4;

/**
 * Detalle class, it has the details related with a Pedido, each detail object has a code (codDetalle), the name of
 * the procudt (producto), a queantity requested of the product (cantidad), a unitary price (precio),
 * a discount (decuentp), the discount could be 0, a total price (total) which is calculated and the code of the
 * Pedido related with the Detale (codPedido)
 *
 * @author Rodney
 * @version 1.1
 */

public class Detalle {
    private String codDetalle;
    private String producto;
    private int cantidad;
    private double precio;
    private double descuento;
    private double total;
    private String codPedido;

    /**
     * Constructor of the Detalle class
     *
     * @param codDetalle: is the code of the Detalle
     * @param producto: is the name of the procut
     * @param cantidad: quantity requested of the product
     * @param precio: unitary price of the product
     * @param descuento: discout given on the specific product
     * @param codPedido: code of the Pedido in which this Detalle object was included
     */

    public Detalle(String codDetalle, String producto, int cantidad, double precio, double descuento, String codPedido) {
        this.codDetalle = codDetalle;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.total = calculateTotal(this.cantidad, this.precio, this.descuento);
        this.codPedido = codPedido;
    }

    /**
     * Get method that returns a string value that represents the code of the Detalle object
     *
     * @return codDetalle value
     */

    public String getCodDetalle() {
        return codDetalle;
    }

    /**
     * Set method that allows to set the codDetalle value of the Detalle object
     *
     * @param codDetalle: is a String that represent the code of the Detalle object
     */

    public void setCodDetalle(String codDetalle) {
        this.codDetalle = codDetalle;
    }

    /**
     * Get method that returns a string value that represents the product name (producto)
     *
     * @return producto value
     */

    public String getProducto() {
        return producto;
    }

    /**
     * Set method that allows to set the producto value of the Detalle object
     *
     * @param producto is a string that represents the product name
     */

    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * Get method that returns an int value that represents the quantity ofthe product is requested (cantidad)
     *
     * @return cantidad value
     */

    public int getCantidad() {
        return cantidad;
    }

    /**
     * Set method that allows to set the quantity requested for the product
     *
     * @param cantidad is an int that represnt the quantity ask of the product
     */

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Get method that returns a double value that represents the unitary price of the prodcut
     *
     * @return precio value
     */

    public double getPrecio() {
        return precio;
    }

    /**
     * Set method that allows to set the unitary price of the product
     *
     * @param precio is a dpuble that represent the unitary price of the producy
     */

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Get method that returns a double value that represents the discount made to the product
     *
     * @return descueno value
     */

    public double getDescuento() {
        return descuento;
    }

    /**
     * Set method that allows to set the discount made to the product
     *
     * @param descuento is adouble that represent the discount made to the product total price
     */

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * Get method that returns a double value that represents the total cost of the product
     *
     * @return total value
     */

    public double getTotal() {
        return total;
    }

    /**
     * Set method that allows to set the total price of the product
     *
     * @param total is a double that represent the totalprice of the product
     */

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Get method that returns a String value that represents the code of the Pedido object related with
     * the Detalle object
     *
     * @return
     */

    public String getCodPedido() {
        return codPedido;
    }

    /**
     * Set method that allows to set the code of the Pedido object reltead with the Detalle object
     *
     * @param codPedido is a string that represent the code of thePedido
     */

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    /**
     * calculateTotal is amethod that takes care of calculate the total price of aprodcut taking intou acoount the
     * quantity of the product requested, the uitary prce and the discunt made to the product
     *
     * @param cantidad is an int that represnt the amount of items requested of this product
     * @param precio is the unitary price of the product
     * @param descuento is the discount made to the total price related with this product
     * @return the total price calulated for the product
     */

    public double calculateTotal(int cantidad, double precio, double descuento) {
        return (cantidad * precio) - descuento;
    }

    /**
     * Override of the toString methods to allo to return the Detalle object values as a string
     *
     * @return a string that describe the details of the Detalle object
     */

    @Override
    public String toString() {
        return this.codDetalle + " | " + this.getProducto() + " | " + this.getCantidad() + " | " + this.getPrecio()
                + " | " + this.getDescuento() + " | " + this.getTotal() + " | " + this.getCodPedido();
    }
}

