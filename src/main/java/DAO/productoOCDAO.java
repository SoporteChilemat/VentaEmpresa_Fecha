/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.ProductoOC;
import static Principal.Principal.conex;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sopor
 */
public class productoOCDAO {

    public static void insertProductoOC(ProductoOC productoOC) throws IOException, SQLException {
        try {
            Statement estatuto = conex.getConnection().createStatement();
            System.out.println("INSERT INTO dbo.productoOC (codigo, descripcion, unidad, cantidad, precioFinal, costoUnitario, numeroOC, valorFlete) VALUES ('"
                    + productoOC.getCodigo().replace("Ñ", "N") + "','"
                    + productoOC.getDescripcion() + "','"
                    + productoOC.getUnidad() + "','"
                    + productoOC.getCantidad() + "','"
                    + productoOC.getPrecioFinal() + "','"
                    + productoOC.getCostoUnitario() + "','"
                    + productoOC.getNumeroOC() + "','"
                    + productoOC.getValorFlete() + "')");
            estatuto.execute("INSERT INTO dbo.productoOC (codigo, descripcion, unidad, cantidad, precioFinal, costoUnitario, numeroOC, valorFlete) VALUES ('"
                    + productoOC.getCodigo().replace("Ñ", "N") + "','"
                    + productoOC.getDescripcion() + "','"
                    + productoOC.getUnidad() + "','"
                    + productoOC.getCantidad() + "','"
                    + productoOC.getPrecioFinal() + "','"
                    + productoOC.getCostoUnitario() + "','"
                    + productoOC.getNumeroOC() + "','"
                    + productoOC.getValorFlete() + "')");
            estatuto.close();
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        }
    }

    public static ProductoOC productoOCPorCodigoOC(String codigo, String numeroOC) throws SQLException, IOException {
        ProductoOC productoOC = null;
        System.out.println("select codigo, descripcion, unidad, cantidad, precioFinal, costoUnitario, numeroOC from dbo.productoOC where codigo = '" + codigo + "' "
                + "AND numeroOC = '" + numeroOC + "'");
        try ( PreparedStatement estatuto = conex.getConnection().prepareStatement("select codigo, descripcion, unidad, cantidad, precioFinal, costoUnitario, numeroOC, valorFlete from dbo.productoOC where codigo = '" + codigo + "' "
                + "AND numeroOC = '" + numeroOC + "'");  ResultSet res = estatuto.executeQuery()) {
            if (res.next()) {
                productoOC = new ProductoOC();
                productoOC.setCodigo(res.getString("codigo"));
                productoOC.setDescripcion(res.getString("descripcion"));
                productoOC.setUnidad(res.getString("unidad"));
                productoOC.setCantidad(res.getString("cantidad"));
                productoOC.setPrecioFinal(res.getString("precioFinal"));
                productoOC.setCostoUnitario(res.getString("costoUnitario"));
                productoOC.setNumeroOC(res.getString("numeroOC"));
                productoOC.setValorFlete(res.getString("valorFlete"));
            }
            res.close();
            estatuto.close();
        }

        System.out.println(productoOC == null);
        return productoOC;
    }

    public static ArrayList<ProductoOC> productoOC(String numeroOC) throws SQLException, IOException {
        ArrayList<ProductoOC> arrProductoOC = new ArrayList<>();
        try ( PreparedStatement estatuto = conex.getConnection().prepareStatement("select codigo, descripcion, unidad, cantidad, precioFinal, costoUnitario, numeroOC, valorFlete from dbo.productoOC where numeroOC = '" + numeroOC + "'");  ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                ProductoOC productoOC = new ProductoOC();
                productoOC.setCodigo(res.getString("codigo"));
                productoOC.setDescripcion(res.getString("descripcion"));
                productoOC.setUnidad(res.getString("unidad"));
                productoOC.setCantidad(res.getString("cantidad"));
                productoOC.setPrecioFinal(res.getString("precioFinal"));
                productoOC.setCostoUnitario(res.getString("costoUnitario"));
                productoOC.setNumeroOC(res.getString("numeroOC"));
                productoOC.setValorFlete(res.getString("valorFlete"));
                arrProductoOC.add(productoOC);
            }
            res.close();
            estatuto.close();
        }
        return arrProductoOC;
    }

    public static void eliminarProductoOC(String numeroOC) throws IOException, SQLException {
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeQuery("DELETE FROM dbo.productoOC WHERE numeroOC = '" + numeroOC + "'");
            estatuto.close();
        } catch (SQLException s) {
            System.out.println(s);
        }
    }
}
