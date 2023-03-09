
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.Factura;
import Clases.Producto;
import Clases.SumasNumeroOC;
import static Logica.Logica.arrFacturas;
import static Logica.Logica.arrFacturasF;
import static Logica.Logica.selectProductosPorFolio;
import static Logica.Logica.selectProductosPorFolioF;
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
public class productoDAO {

    public static void insertProducto(Producto producto) throws IOException, SQLException {
        try {
            Statement estatuto = conex.getConnection().createStatement();
            System.out.println("INSERT INTO dbo.producto (codigo, descripcion, unidad, precioUnitario, costoUnitario, cantidad, precioTotal, folio, costoFinal, numeroOC, codigoOC) VALUES ('"
                    + producto.getCodigo().replace("Ñ", "N") + "','"
                    + producto.getDescripcion() + "','"
                    + producto.getUnidad() + "','"
                    + producto.getPrecioUnitario() + "','"
                    + producto.getCostoUnitario() + "','"
                    + producto.getCantidad() + "','"
                    + producto.getPrecioTotal() + "','"
                    + producto.getFolio() + "','"
                    + producto.getCostoFinal() + "','"
                    + producto.getNumeroOC() + "','"
                    + producto.getCodigoOC() + "')");
            estatuto.execute("INSERT INTO dbo.producto (codigo, descripcion, unidad, precioUnitario, costoUnitario, cantidad, precioTotal, folio, costoFinal, numeroOC, codigoOC, cantidadOC) VALUES ('"
                    + producto.getCodigo().replace("Ñ", "N") + "','"
                    + producto.getDescripcion() + "','"
                    + producto.getUnidad() + "','"
                    + producto.getPrecioUnitario() + "','"
                    + producto.getCostoUnitario() + "','"
                    + producto.getCantidad() + "','"
                    + producto.getPrecioTotal() + "','"
                    + producto.getFolio() + "','"
                    + producto.getCostoFinal() + "','"
                    + producto.getNumeroOC() + "','"
                    + producto.getCodigoOC() + "','"
                    + producto.getCantidadOC() + "')");
            estatuto.close();
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        }
    }

    public static void prueba(String tipo, String usuario, String vendedor) {
        try {
            String query = "";
            if (usuario.equals("MOYRIC")) {
                query = "SELECT a.folio, fechaEmision, rutCliente, giro, direccion, comuna, ciudad, razonSocial, montoNeto, iva, montoTotal, tipoDocumento, folioReferencia, \n"
                        + "                     fechaReferencia, ocCliente, origen, vendedor, vendedor2, pagada, codigo, descripcion, unidad, precioUnitario, costoUnitario, cantidad, precioTotal, b.folio, \n"
                        + "                     costoFinal, numeroOC, codigoOC, cantidadOC, \n"
                        + "		ROW_NUMBER() OVER (\n"
                        + "            PARTITION BY a.folio, fechaEmision, rutCliente, giro, direccion, comuna, ciudad, razonSocial, montoNeto, iva, montoTotal, tipoDocumento, folioReferencia, \n"
                        + "                     fechaReferencia, ocCliente, origen, vendedor, vendedor2, pagada\n"
                        + "            ORDER BY a.folio, fechaEmision, rutCliente, giro, direccion, comuna, ciudad, razonSocial, montoNeto, iva, montoTotal, tipoDocumento, folioReferencia, \n"
                        + "                     fechaReferencia, ocCliente, origen, vendedor, vendedor2, pagada) rownum \n"
                        + "					 \n"
                        + "					 FROM dbo.factura as a inner join dbo.producto as b on a.folio = b.folio WHERE tipoDocumento = '" + tipo + "' and a.vendedor = 'PATRICIO ROMAN' order by a.folio asc";
            } else if (usuario.equals("ROJICN")) {
                query = "SELECT a.folio, fechaEmision, rutCliente, giro, direccion, comuna, ciudad, razonSocial, montoNeto, iva, montoTotal, tipoDocumento, folioReferencia, \n"
                        + "                     fechaReferencia, ocCliente, origen, vendedor, vendedor2, pagada, codigo, descripcion, unidad, precioUnitario, costoUnitario, cantidad, precioTotal, b.folio, \n"
                        + "                     costoFinal, numeroOC, codigoOC, cantidadOC, \n"
                        + "		ROW_NUMBER() OVER (\n"
                        + "            PARTITION BY a.folio, fechaEmision, rutCliente, giro, direccion, comuna, ciudad, razonSocial, montoNeto, iva, montoTotal, tipoDocumento, folioReferencia, \n"
                        + "                     fechaReferencia, ocCliente, origen, vendedor, vendedor2, pagada\n"
                        + "            ORDER BY a.folio, fechaEmision, rutCliente, giro, direccion, comuna, ciudad, razonSocial, montoNeto, iva, montoTotal, tipoDocumento, folioReferencia, \n"
                        + "                     fechaReferencia, ocCliente, origen, vendedor, vendedor2, pagada) rownum \n"
                        + "					 \n"
                        + "					 FROM dbo.factura as a inner join dbo.producto as b on a.folio = b.folio WHERE tipoDocumento = '" + tipo + "' and a.vendedor = 'NICOLAS ROJIC' order by a.folio asc";
            } else {
                if (vendedor.equals("VALDEK")
                        || vendedor.equals("TOSGIA")
                        || vendedor.equals("TOSFRA")
                        || vendedor.equals("KURSAD")
                        || vendedor.equals("ROJICD")
                        || vendedor.equals("CAMILO")
                        || vendedor.equals("ESPINV")) {
                    query = "SELECT a.folio, fechaEmision, rutCliente, giro, direccion, comuna, ciudad, razonSocial, montoNeto, iva, montoTotal, tipoDocumento, folioReferencia, \n"
                            + "                     fechaReferencia, ocCliente, origen, vendedor, vendedor2, pagada, codigo, descripcion, unidad, precioUnitario, costoUnitario, cantidad, precioTotal, b.folio, \n"
                            + "                     costoFinal, numeroOC, codigoOC, cantidadOC, \n"
                            + "		ROW_NUMBER() OVER (\n"
                            + "            PARTITION BY a.folio, fechaEmision, rutCliente, giro, direccion, comuna, ciudad, razonSocial, montoNeto, iva, montoTotal, tipoDocumento, folioReferencia, \n"
                            + "                     fechaReferencia, ocCliente, origen, vendedor, vendedor2, pagada\n"
                            + "            ORDER BY a.folio, fechaEmision, rutCliente, giro, direccion, comuna, ciudad, razonSocial, montoNeto, iva, montoTotal, tipoDocumento, folioReferencia, \n"
                            + "                     fechaReferencia, ocCliente, origen, vendedor, vendedor2, pagada) rownum \n"
                            + "					 \n"
                            + "					 FROM dbo.factura as a inner join dbo.producto as b on a.folio = b.folio WHERE tipoDocumento = '" + tipo + "' and a.vendedor <> 'NICOLAS ROJIC' and a.vendedor <> 'PATRICIO ROMAN' order by a.folio asc";
                } else {
                    query = "SELECT a.folio, fechaEmision, rutCliente, giro, direccion, comuna, ciudad, razonSocial, montoNeto, iva, montoTotal, tipoDocumento, folioReferencia, \n"
                            + "                     fechaReferencia, ocCliente, origen, vendedor, vendedor2, pagada, codigo, descripcion, unidad, precioUnitario, costoUnitario, cantidad, precioTotal, b.folio, \n"
                            + "                     costoFinal, numeroOC, codigoOC, cantidadOC, \n"
                            + "		ROW_NUMBER() OVER (\n"
                            + "            PARTITION BY a.folio, fechaEmision, rutCliente, giro, direccion, comuna, ciudad, razonSocial, montoNeto, iva, montoTotal, tipoDocumento, folioReferencia, \n"
                            + "                     fechaReferencia, ocCliente, origen, vendedor, vendedor2, pagada\n"
                            + "            ORDER BY a.folio, fechaEmision, rutCliente, giro, direccion, comuna, ciudad, razonSocial, montoNeto, iva, montoTotal, tipoDocumento, folioReferencia, \n"
                            + "                     fechaReferencia, ocCliente, origen, vendedor, vendedor2, pagada) rownum \n"
                            + "					 \n"
                            + "					 FROM dbo.factura as a inner join dbo.producto as b on a.folio = b.folio WHERE tipoDocumento = '" + tipo + "' and a.vendedor = '" + vendedor + "' and a.vendedor <> 'NICOLAS ROJIC' and a.vendedor <> 'PATRICIO ROMAN' order by a.folio asc";

                }
            }

            PreparedStatement estatuto = conex.getConnection().prepareStatement(query);

            // Iterar sobre los resultados y guardarlos en los arreglos correspondientes        
            try ( ResultSet rs = estatuto.executeQuery()) {
                while (rs.next()) {
                    Factura factura = new Factura();
                    String string = rs.getString(32);
                    if (string.equals("1")) {
                        factura.setFolio(rs.getString(1));
                        factura.setFechaEmision(rs.getString(2));
                        factura.setRutCliente(rs.getString(3));
                        factura.setGiro(rs.getString(4));
                        factura.setDireccion(rs.getString(5));
                        factura.setComuna(rs.getString(6));
                        factura.setCiudad(rs.getString(7));
                        factura.setRazonSocial(rs.getString(8));
                        factura.setMontoNeto(rs.getString(9));
                        factura.setIva(rs.getString(10));
                        factura.setMontoTotal(rs.getString(11));
                        factura.setTipoDocuemnto(rs.getString(12));
                        factura.setFolioReferencia(rs.getString(13));
                        factura.setFechaReferencia(rs.getString(14));
                        factura.setOcCliente(rs.getString(15));
                        factura.setOrigen(rs.getString(16));
                        factura.setVendedor(rs.getString(17));
                        factura.setVendedor2(rs.getString(18));
                        factura.setPagada(rs.getString(19));
                        if (tipo.equals("52")) {
                            arrFacturas.add(factura);
                        } else {
                            arrFacturasF.add(factura);
                        }
                    }

                    Producto producto = new Producto();
                    producto.setCodigo(rs.getString(20));
                    producto.setDescripcion(rs.getString(21));
                    producto.setUnidad(rs.getString(22));
                    producto.setPrecioUnitario(rs.getString(23));
                    producto.setCostoUnitario(rs.getString(24));
                    producto.setCantidad(rs.getString(25));
                    producto.setPrecioTotal(rs.getString(26));
                    producto.setFolio(rs.getString(27));
                    producto.setCostoFinal(rs.getString(28));
                    producto.setNumeroOC(rs.getString(29));
                    producto.setCodigoOC(rs.getString(30));
                    producto.setCantidadOC(rs.getString(31));
                    if (tipo.equals("52")) {
                        selectProductosPorFolio.add(producto);
                    } else {
                        selectProductosPorFolioF.add(producto);
                    }
                }
                rs.close();
                estatuto.close();
            } catch (Exception ex) {
                System.out.println("ex " + ex);
            }

            // Cerrar la conexión
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<SumasNumeroOC> prueba2(String tipo, String usuario, String vendedor) {
        ArrayList<SumasNumeroOC> arrsumasNumeroOC = new ArrayList<>();
        try {
            String query = "";
            if (usuario.equals("MOYRIC")) {
                query = "SELECT sum(cast(costoUnitario as float) * cast(cantidad as float)) as suma, a.numeroOC "
                        + "FROM dbo.producto as a inner join dbo.factura as b on a.folio = b.folio WHERE tipoDocumento = '" + tipo + "' and b.vendedor = 'PATRICIO ROMAN' group by b.folio, a.numeroOC order by b.folio asc";
            } else if (usuario.equals("ROJICN")) {
                query = "SELECT sum(cast(costoUnitario as float) * cast(cantidad as float)) as suma, a.numeroOC "
                        + "FROM dbo.producto as a inner join dbo.factura as b on a.folio = b.folio WHERE tipoDocumento = '" + tipo + "' and b.vendedor = 'NICOLAS ROJIC' group by b.folio, a.numeroOC order by b.folio asc";
            } else {
                if (vendedor.equals("VALDEK")
                        || vendedor.equals("TOSGIA")
                        || vendedor.equals("TOSFRA")
                        || vendedor.equals("KURSAD")
                        || vendedor.equals("ROJICD")
                        || vendedor.equals("CAMILO")
                        || vendedor.equals("ESPINV")) {
                    query = "SELECT sum(cast(costoUnitario as float) * cast(cantidad as float)) as suma , a.numeroOC "
                            + "FROM dbo.producto as a inner join dbo.factura as b on a.folio = b.folio WHERE tipoDocumento = '" + tipo + "' and b.vendedor <> 'NICOLAS ROJIC' and b.vendedor <> 'PATRICIO ROMAN' group by b.folio, a.numeroOC order by b.folio asc";
                } else {
                    query = "SELECT sum(cast(costoUnitario as float) * cast(cantidad as float)) as suma , a.numeroOC "
                            + "FROM dbo.producto as a inner join dbo.factura as b on a.folio = b.folio WHERE tipoDocumento = '" + tipo + "' and b.vendedor = '" + vendedor + "' and b.vendedor <> 'NICOLAS ROJIC' and b.vendedor <> 'PATRICIO ROMAN' group by b.folio, a.numeroOC order by b.folio asc";
                }
            }

            PreparedStatement estatuto = conex.getConnection().prepareStatement(query);
            try ( ResultSet rs = estatuto.executeQuery()) {
                while (rs.next()) {
                    SumasNumeroOC sumasNumeroOC = new SumasNumeroOC();
                    sumasNumeroOC.setSuma(rs.getDouble("suma"));
                    sumasNumeroOC.setNumeroOC(rs.getString("numeroOC"));
                    arrsumasNumeroOC.add(sumasNumeroOC);
                }
                rs.close();
                estatuto.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrsumasNumeroOC;
    }

//    public static ArrayList<Producto> selectProductosPorFolio(Factura factura) throws IOException, SQLException, InterruptedException {
//
//        ArrayList<Producto> arrProducto = new ArrayList<>();
//
//        try (PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT codigo, descripcion, unidad, precioUnitario, costoUnitario, cantidad, precioTotal, folio, costoFinal, numeroOC, codigoOC, cantidadOC FROM dbo.producto WHERE folio = ?")) {
//            estatuto.setString(1, factura.getFolio());
//            try (ResultSet rs = estatuto.executeQuery()) {
//                while (rs.next()) {
//                    Producto producto = new Producto();
//                    producto.setCodigo(rs.getString("codigo"));
//                    producto.setDescripcion(rs.getString("descripcion"));
//                    producto.setUnidad(rs.getString("unidad"));
//                    producto.setPrecioUnitario(rs.getString("precioUnitario"));
//                    producto.setCostoUnitario(rs.getString("costoUnitario"));
//                    producto.setCantidad(rs.getString("cantidad"));
//                    producto.setPrecioTotal(rs.getString("precioTotal"));
//                    producto.setFolio(rs.getString("folio"));
//                    producto.setCostoFinal(rs.getString("costoFinal"));
//                    producto.setNumeroOC(rs.getString("numeroOC"));
//                    producto.setCodigoOC(rs.getString("codigoOC"));
//                    producto.setCodigoOC(rs.getString("cantidadOC"));
//                    arrProducto.add(producto);
//                }
//            }
//        }
//
//        return arrProducto;
//    }
    public static void eliminarProducto(String folio) throws IOException, SQLException {
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeQuery("DELETE FROM dbo.producto WHERE folio = '" + folio + "'");
            estatuto.close();
        } catch (SQLException s) {
            System.out.println("eliminarProducto " + s);
        }
    }

    public static void actualizaProducto(String codigo, String costoUnitario, String folio) {

        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("UPDATE dbo.producto SET costoUnitario ='" + costoUnitario + "' WHERE codigo = '" + codigo + "' AND folio = '" + folio + "'");
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
