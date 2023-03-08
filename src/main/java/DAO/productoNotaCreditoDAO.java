package DAO;

import Clases.ProductoNotaCredito;
import static Principal.Principal.conex;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class productoNotaCreditoDAO {

    public static void insertProductoNotaCredito(ProductoNotaCredito productoNotaCredito) throws IOException, SQLException {
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.execute("INSERT INTO dbo.productoNotaCredito (folio, cantidad, codigo, descripcion, neto, total) VALUES ('"
                    + productoNotaCredito.getFolio() + "','"
                    + productoNotaCredito.getCantidad() + "','"
                    + productoNotaCredito.getCodigo().replace("Ñ", "N") + "','"
                    + productoNotaCredito.getDescripcion() + "','"
                    + productoNotaCredito.getNeto() + "','"
                    + productoNotaCredito.getTotal() + "')");
            estatuto.close();
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        }
    }

    public static ArrayList<ProductoNotaCredito> selectProductoNotaCreditoPorFolio(String folio) throws IOException, SQLException {
        ArrayList<ProductoNotaCredito> arrProductoNotaCredito = new ArrayList<>();
        try ( PreparedStatement consulta = conex.getConnection().prepareStatement("select folio, cantidad, codigo, descripcion, neto, total from dbo.productoNotaCredito where folio = '" + folio + "'");  ResultSet rs = consulta.executeQuery()) {
            while (rs.next()) {
                ProductoNotaCredito productoNotaCredito = new ProductoNotaCredito();
                productoNotaCredito.setFolio(rs.getString("folio"));
                productoNotaCredito.setCantidad(rs.getString("cantidad"));
                productoNotaCredito.setCodigo(rs.getString("codigo"));
                productoNotaCredito.setDescripcion(rs.getString("descripcion"));
                productoNotaCredito.setNeto(rs.getString("neto"));
                productoNotaCredito.setTotal(rs.getString("total"));
                arrProductoNotaCredito.add(productoNotaCredito);
            }
            rs.close();
            consulta.close();
        }
        return arrProductoNotaCredito;
    }
}
