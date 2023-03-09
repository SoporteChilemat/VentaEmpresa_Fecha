package DAO;

import Clases.Factura;
import static Principal.Principal.conex;
import Principal.VentanaLogin;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class facturaDAO {

    public static int insertFactura(Factura factura) throws IOException, SQLException {
        try {
            if (VentanaLogin.nombrex.equals("NICOLAS ROJIC")) {
                Statement estatuto = conex.getConnection().createStatement();
                System.out.println("INSERT INTO dbo.factura (folio, fechaEmision, rutCliente, razonSocial, giro, direccion, comuna, ciudad, montoNeto, "
                        + "iva, montoTotal, tipoDocumento, folioReferencia, fechaReferencia, ocCliente, origen, vendedor, pagada) VALUES ('"
                        + factura.getFolio() + "','"
                        + factura.getFechaEmision() + "','"
                        + factura.getRutCliente() + "','"
                        + factura.getRazonSocial() + "','"
                        + factura.getGiro() + "','"
                        + factura.getDireccion() + "','"
                        + factura.getComuna() + "','"
                        + factura.getCiudad() + "','"
                        + factura.getMontoNeto() + "','"
                        + factura.getIva() + "','"
                        + factura.getMontoTotal() + "','"
                        + factura.getTipoDocuemnto() + "','"
                        + factura.getFolioReferencia() + "','"
                        + factura.getFechaReferencia() + "','"
                        + factura.getOcCliente() + "','"
                        + factura.getOrigen() + "','"
                        + factura.getVendedor() + "','"
                        + factura.getVendedor2() + "','"
                        + "false')");
                estatuto.execute("INSERT INTO dbo.factura (folio, fechaEmision, rutCliente, razonSocial, giro, direccion, comuna, ciudad, montoNeto, "
                        + "iva, montoTotal, tipoDocumento, folioReferencia, fechaReferencia, ocCliente, origen, vendedor, vendedor2, pagada) VALUES ('"
                        + factura.getFolio() + "','"
                        + factura.getFechaEmision() + "','"
                        + factura.getRutCliente() + "','"
                        + factura.getRazonSocial() + "','"
                        + factura.getGiro() + "','"
                        + factura.getDireccion() + "','"
                        + factura.getComuna() + "','"
                        + factura.getCiudad() + "','"
                        + factura.getMontoNeto() + "','"
                        + factura.getIva() + "','"
                        + factura.getMontoTotal() + "','"
                        + factura.getTipoDocuemnto() + "','"
                        + factura.getFolioReferencia() + "','"
                        + factura.getFechaReferencia() + "','"
                        + factura.getOcCliente() + "','"
                        + factura.getOrigen() + "','"
                        + factura.getVendedor() + "','"
                        + factura.getVendedor2() + "','"
                        + "false')");
                estatuto.close();

                return 0;
            } else {
                Statement estatuto = conex.getConnection().createStatement();
                System.out.println("INSERT INTO dbo.factura (folio, fechaEmision, rutCliente, razonSocial, giro, direccion, comuna, ciudad, montoNeto, "
                        + "iva, montoTotal, tipoDocumento, folioReferencia, fechaReferencia, ocCliente, origen, vendedor, pagada) VALUES ('"
                        + factura.getFolio() + "','"
                        + factura.getFechaEmision() + "','"
                        + factura.getRutCliente() + "','"
                        + factura.getRazonSocial() + "','"
                        + factura.getGiro() + "','"
                        + factura.getDireccion() + "','"
                        + factura.getComuna() + "','"
                        + factura.getCiudad() + "','"
                        + factura.getMontoNeto() + "','"
                        + factura.getIva() + "','"
                        + factura.getMontoTotal() + "','"
                        + factura.getTipoDocuemnto() + "','"
                        + factura.getFolioReferencia() + "','"
                        + factura.getFechaReferencia() + "','"
                        + factura.getOcCliente() + "','"
                        + factura.getOrigen() + "','"
                        + factura.getVendedor() + "','"
                        + factura.getVendedor2() + "','"
                        + "false')");
                estatuto.execute("INSERT INTO dbo.factura (folio, fechaEmision, rutCliente, razonSocial, giro, direccion, comuna, ciudad, montoNeto, "
                        + "iva, montoTotal, tipoDocumento, folioReferencia, fechaReferencia, ocCliente, origen, vendedor, pagada) VALUES ('"
                        + factura.getFolio() + "','"
                        + factura.getFechaEmision() + "','"
                        + factura.getRutCliente() + "','"
                        + factura.getRazonSocial() + "','"
                        + factura.getGiro() + "','"
                        + factura.getDireccion() + "','"
                        + factura.getComuna() + "','"
                        + factura.getCiudad() + "','"
                        + factura.getMontoNeto() + "','"
                        + factura.getIva() + "','"
                        + factura.getMontoTotal() + "','"
                        + factura.getTipoDocuemnto() + "','"
                        + factura.getFolioReferencia() + "','"
                        + factura.getFechaReferencia() + "','"
                        + factura.getOcCliente() + "','"
                        + factura.getOrigen() + "','"
                        + factura.getVendedor() + "','"
                        + "false')");
                estatuto.close();

                return 0;
            }
        } catch (Exception ex) {
            System.out.println("insertFactura ex " + ex);

            if (ex.toString().contains("PRIMARY KEY")) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    public static ArrayList<Factura> selectFacturasLocal(String tipoDocumento, int tipo, String nombrex) throws IOException, SQLException {
        if (tipo == 0) {
            ArrayList<Factura> arrFoliosVendedor = new ArrayList<>();
            try ( PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM dbo.factura WHERE tipoDocumento = '" + tipoDocumento + "'");  ResultSet res = consulta.executeQuery()) {
                while (res.next()) {
                    Factura factura = new Factura();
                    factura.setFolio(res.getString("folio"));
                    factura.setFechaEmision(res.getString("fechaEmision"));
                    factura.setRutCliente(res.getString("rutCliente"));
                    factura.setGiro(res.getString("giro"));
                    factura.setDireccion(res.getString("direccion"));
                    factura.setComuna(res.getString("comuna"));
                    factura.setCiudad(res.getString("ciudad"));
                    factura.setRazonSocial(res.getString("razonSocial"));
                    factura.setMontoNeto(res.getString("montoNeto"));
                    factura.setIva(res.getString("iva"));
                    factura.setMontoTotal(res.getString("montoTotal"));
                    factura.setTipoDocuemnto(res.getString("tipoDocumento"));
                    factura.setFolioReferencia(res.getString("folioReferencia"));
                    factura.setFechaReferencia(res.getString("fechaReferencia"));
                    factura.setOcCliente(res.getString("ocCliente"));
                    factura.setOrigen(res.getString("origen"));
                    factura.setVendedor(res.getString("vendedor"));
                    factura.setPagada(res.getString("pagada"));
                    arrFoliosVendedor.add(factura);
                }
                res.close();
                consulta.close();
            }
            return arrFoliosVendedor;
        } else {
            ArrayList<Factura> arrFoliosVendedor = new ArrayList<>();
            try ( PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM dbo.factura WHERE tipoDocumento = '" + tipoDocumento + "' AND vendedor = '" + nombrex + "'");  ResultSet res = consulta.executeQuery()) {
                while (res.next()) {
                    Factura factura = new Factura();
                    factura.setFolio(res.getString("folio"));
                    factura.setFechaEmision(res.getString("fechaEmision"));
                    factura.setRutCliente(res.getString("rutCliente"));
                    factura.setGiro(res.getString("giro"));
                    factura.setDireccion(res.getString("direccion"));
                    factura.setComuna(res.getString("comuna"));
                    factura.setCiudad(res.getString("ciudad"));
                    factura.setRazonSocial(res.getString("razonSocial"));
                    factura.setMontoNeto(res.getString("montoNeto"));
                    factura.setIva(res.getString("iva"));
                    factura.setMontoTotal(res.getString("montoTotal"));
                    factura.setTipoDocuemnto(res.getString("tipoDocumento"));
                    factura.setFolioReferencia(res.getString("folioReferencia"));
                    factura.setFechaReferencia(res.getString("fechaReferencia"));
                    factura.setOcCliente(res.getString("ocCliente"));
                    factura.setOrigen(res.getString("origen"));
                    factura.setVendedor(res.getString("vendedor"));
                    factura.setPagada(res.getString("pagada"));
                    arrFoliosVendedor.add(factura);
                }
                res.close();
                consulta.close();
            }
            return arrFoliosVendedor;
        }
    }

    public static Factura selectFacturaPorFolio(String folio) throws IOException, SQLException {
        Factura factura = new Factura();
        try ( PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM dbo.factura WHERE folio = '" + folio + "'");  ResultSet res = consulta.executeQuery()) {
            while (res.next()) {
                factura.setFolio(res.getString("folio"));
                factura.setFechaEmision(res.getString("fechaEmision"));
                factura.setRutCliente(res.getString("rutCliente"));
                factura.setGiro(res.getString("giro"));
                factura.setDireccion(res.getString("direccion"));
                factura.setComuna(res.getString("comuna"));
                factura.setCiudad(res.getString("ciudad"));
                factura.setRazonSocial(res.getString("razonSocial"));
                factura.setMontoNeto(res.getString("montoNeto"));
                factura.setIva(res.getString("iva"));
                factura.setMontoTotal(res.getString("montoTotal"));
                factura.setTipoDocuemnto(res.getString("tipoDocumento"));
                factura.setFolioReferencia(res.getString("folioReferencia"));
                factura.setFechaReferencia(res.getString("fechaReferencia"));
                factura.setOcCliente(res.getString("ocCliente"));
                factura.setOrigen(res.getString("origen"));
                factura.setVendedor(res.getString("vendedor"));
                factura.setPagada(res.getString("pagada"));
            }
            res.close();
            consulta.close();
        }
        return factura;
    }

    public static void eliminarFactura(String folio) throws IOException, SQLException {
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.execute("DELETE FROM dbo.factura WHERE folio = '" + folio + "'");
            estatuto.close();
        } catch (SQLException s) {
            System.out.println("eliminarFactura " + s);
        }
    }

    public static void actualizaFactura(String folio, String vendedor) {

        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("UPDATE dbo.factura SET vendedor ='" + vendedor + "' WHERE folio = '" + folio + "'");
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void actualizaFecha(String folio, String fecha) {
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            System.out.println("UPDATE dbo.factura SET fechaEmision ='" + fecha + "' WHERE folio = '" + folio + "'");
            estatuto.executeUpdate("UPDATE dbo.factura SET fechaEmision ='" + fecha + "' WHERE folio = '" + folio + "'");
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void actualizaPagada(String folio, String pagada) {

        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("UPDATE dbo.factura SET pagada ='" + pagada + "' WHERE folio = '" + folio + "'");
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
