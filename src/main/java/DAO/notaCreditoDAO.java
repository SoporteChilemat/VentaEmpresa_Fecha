package DAO;

import Clases.NotaCredito;
import static Principal.Principal.conex;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class notaCreditoDAO {

    public static int insertNotaCredito(NotaCredito notaCredito) throws IOException, SQLException {
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.execute("INSERT INTO dbo.notaCredito (folio, fecha, cliente, razonSocial, giro, direccion, comuna, ciudad, neto, iva, total, tipoDocumento, folioReferencia, fechaReferencia, motivo, vendedor) VALUES ('"
                    + notaCredito.getFolio() + "','"
                    + notaCredito.getFecha() + "','"
                    + notaCredito.getCliente() + "','"
                    + notaCredito.getRazonSocial() + "','"
                    + notaCredito.getGiro() + "','"
                    + notaCredito.getDireccion() + "','"
                    + notaCredito.getComuna() + "','"
                    + notaCredito.getCiudad() + "','"
                    + notaCredito.getNeto() + "','"
                    + notaCredito.getIva() + "','"
                    + notaCredito.getTotal() + "','"
                    + notaCredito.getTipoDocuemnto() + "','"
                    + notaCredito.getFolioReferencia() + "','"
                    + notaCredito.getFechaReferencia() + "','"
                    + notaCredito.getMotivo() + "','"
                    + notaCredito.getVendedor() + "')");
            estatuto.close();

            return 0;
        } catch (Exception ex) {
            System.out.println("insertFactura ex " + ex);

            if (ex.toString().contains("PRIMARY KEY")) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    public static ArrayList<NotaCredito> selectNotaCredito(int tipo, String nombrex) throws IOException, SQLException {
        if (tipo == 0) {

            ArrayList<NotaCredito> arrNotaCredito = new ArrayList<>();
            try ( PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM dbo.notaCredito");  ResultSet res = consulta.executeQuery()) {
                while (res.next()) {
                    NotaCredito notaCredito = new NotaCredito();
                    notaCredito.setFolio(res.getString("folio"));
                    notaCredito.setFecha(res.getString("fecha"));
                    notaCredito.setCliente(res.getString("cliente"));
                    notaCredito.setRazonSocial(res.getString("razonSocial"));
                    notaCredito.setGiro(res.getString("giro"));
                    notaCredito.setDireccion(res.getString("direccion"));
                    notaCredito.setComuna(res.getString("comuna"));
                    notaCredito.setCiudad(res.getString("ciudad"));
                    notaCredito.setNeto(res.getString("neto"));
                    notaCredito.setIva(res.getString("iva"));
                    notaCredito.setTotal(res.getString("total"));
                    notaCredito.setTipoDocuemnto(res.getString("tipoDocumento"));
                    notaCredito.setFolioReferencia(res.getString("folioReferencia"));
                    notaCredito.setFechaReferencia(res.getString("fechaReferencia"));
                    notaCredito.setMotivo(res.getString("motivo"));
                    notaCredito.setVendedor(res.getString("vendedor"));
                    arrNotaCredito.add(notaCredito);
                }
            }
            return arrNotaCredito;
        } else {
            ArrayList<NotaCredito> arrNotaCredito = new ArrayList<>();
            try ( PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM dbo.notaCredito WHERE vendedor = '" + nombrex + "'");  ResultSet res = consulta.executeQuery()) {
                while (res.next()) {
                    NotaCredito notaCredito = new NotaCredito();
                    notaCredito.setFolio(res.getString("folio"));
                    notaCredito.setFecha(res.getString("fecha"));
                    notaCredito.setCliente(res.getString("cliente"));
                    notaCredito.setRazonSocial(res.getString("razonSocial"));
                    notaCredito.setGiro(res.getString("giro"));
                    notaCredito.setDireccion(res.getString("direccion"));
                    notaCredito.setComuna(res.getString("comuna"));
                    notaCredito.setCiudad(res.getString("ciudad"));
                    notaCredito.setNeto(res.getString("neto"));
                    notaCredito.setIva(res.getString("iva"));
                    notaCredito.setTotal(res.getString("total"));
                    notaCredito.setTipoDocuemnto(res.getString("tipoDocumento"));
                    notaCredito.setFolioReferencia(res.getString("folioReferencia"));
                    notaCredito.setFechaReferencia(res.getString("fechaReferencia"));
                    notaCredito.setMotivo(res.getString("motivo"));
                    notaCredito.setVendedor(res.getString("vendedor"));
                    arrNotaCredito.add(notaCredito);
                }
            }
            return arrNotaCredito;
        }
    }

    public static void actualizaFecha(String folio, String fecha) {
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            System.out.println("UPDATE dbo.notaCredito SET fecha ='" + fecha + "' WHERE folio = '" + folio + "'");
            estatuto.executeUpdate("UPDATE dbo.notaCredito SET fecha ='" + fecha + "' WHERE folio = '" + folio + "'");
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
