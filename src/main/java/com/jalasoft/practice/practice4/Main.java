/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.practice4;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Rodney
 * @version 1.1
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Detalle cod1 = new Detalle("cod1", "cocina", 2, 1000, 10, "ped1");
        Detalle cod2 = new Detalle("cod2", "avadora", 1, 2500, 0, "ped1");
        Detalle cod3 = new Detalle("cod3", "plancha", 5, 300, 50, "ped1");
        Detalle cod4 = new Detalle("cod4", "mesa", 2, 700, 30, "ped2");
        Detalle cod5 = new Detalle("cod5", "muebles", 1, 3500, 0, "ped2");
        Detalle cod6 = new Detalle("cod6", "comoda", 3, 800, 100, "ped2");
        Detalle cod7 = new Detalle("cod7", "camisa", 10, 100, 100, "ped3");
        Detalle cod8 = new Detalle("cod8", "polera", 20, 80, 0, "ped3");
        Detalle cod9 = new Detalle("cod9", "zapatos", 8, 400, 200, "ped3");

        List<Detalle> detalleList1 = new ArrayList<>();
        detalleList1.add(cod1);
        detalleList1.add(cod2);
        detalleList1.add(cod3);

        List<Detalle> detalleList2 = new ArrayList<>();
        detalleList2.add(cod4);
        detalleList2.add(cod5);
        detalleList2.add(cod6);

        List<Detalle> detalleList3 = new ArrayList<>();
        detalleList3.add(cod7);
        detalleList3.add(cod8);
        detalleList3.add(cod9);

        Pedido ped1 = new Pedido("ped1", "normal", "Juan Perez", "2020-05-05", detalleList1);
        Pedido ped2 = new Pedido("ped2", "programado", "Maria Guaman", "2020-05-03", detalleList2);
        Pedido ped3 = new Pedido("ped3", "normal", "Juan Perez", "2020-05-10", detalleList3);

        List<Pedido> pedidoList = new ArrayList<>();
        pedidoList.add(ped1);
        pedidoList.add(ped2);
        pedidoList.add(ped3);

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Select cliente from Pedido");

        pedidoList.stream()
                .map(pedido -> pedido.getCliente())
                .forEach(cliente -> System.out.println(cliente));

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Select cliente from Pedido where tipoPedido = normal");

        pedidoList.stream()
                .filter(pedido -> pedido.getTipoPedido() == "normal")
                .map(pedido -> pedido.getCliente())
                .forEach(cliente -> System.out.println(cliente));

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Select codPedido from Pedido where fecha = 2020-05-05");

        pedidoList.stream()
                .filter(pedido -> pedido.getFecha() == "2020-05-05")
                .map(pedido -> pedido.getCodPedido())
                .forEach(cliente -> System.out.println(cliente));

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Select producto from Detalle,Pedido where Pedido.codPedido = Detalle.codPdido " +
                "and Detalle.codPedido = ped1");

        pedidoList.stream()
                .map(pedido -> pedido.getDetalleList())
                .flatMap(detalles -> detalles.stream())
                .filter(detalle -> detalle.getCodPedido() == "ped1")
                .map(detalle -> detalle.getProducto())
                .forEach(producto -> System.out.println(producto));

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Select Detalle.producto from Detalle,Pedido where Pedido.codPedido = Detalle.codPdido " +
                "and Detalle.cantidad > 8");

        pedidoList.stream()
                .map(pedido -> pedido.getDetalleList())
                .flatMap(detalles -> detalles.stream())
                .filter(detalle -> detalle.getCantidad() > 8)
                .map(detalle -> detalle.getProducto())
                .forEach(producto -> System.out.println(producto));

    }
}
