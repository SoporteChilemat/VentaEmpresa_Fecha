package DAO;

import Clases.Flete;
import static Principal.Principal.conex;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class fleteDAO {

    public static boolean insertFlete(Flete flete) throws IOException, SQLException {
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.execute("INSERT INTO dbo.flete (fechaFa, numeroFa, vendedor, montoFa, montoFaVendedor, observacion) VALUES ('"
                    + flete.getFechaFa() + "','"
                    + flete.getNumeroFa() + "','"
                    + flete.getVendedor() + "','"
                    + flete.getMontoFa() + "','"
                    + flete.getMontoFaVendedor() + "','"
                    + flete.getObservacion() + "')");
            estatuto.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static ArrayList<Flete> selectFlete(int tipo, String nombrex) throws IOException, SQLException {
        if (tipo == 0) {
            ArrayList<Flete> arrFlete = new ArrayList<>();
            try ( PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM dbo.flete");  ResultSet res = consulta.executeQuery()) {
                while (res.next()) {
                    Flete flete = new Flete();
                    flete.setFechaFa(res.getString("fechaFa"));
                    flete.setNumeroFa(res.getString("numeroFa"));
                    flete.setVendedor(res.getString("vendedor"));
                    flete.setMontoFa(res.getString("montoFa"));
                    flete.setMontoFaVendedor(res.getString("montoFaVendedor"));
                    flete.setObservacion(res.getString("observacion"));
                    arrFlete.add(flete);
                }
                res.close();
                consulta.close();
            }
            return arrFlete;
        } else {
            ArrayList<Flete> arrFlete = new ArrayList<>();
            try ( PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM dbo.flete WHERE vendedor = '" + nombrex + "'");  ResultSet res = consulta.executeQuery()) {
                while (res.next()) {
                    Flete flete = new Flete();
                    flete.setFechaFa(res.getString("fechaFa"));
                    flete.setNumeroFa(res.getString("numeroFa"));
                    flete.setVendedor(res.getString("vendedor"));
                    flete.setMontoFa(res.getString("montoFa"));
                    flete.setMontoFaVendedor(res.getString("montoFaVendedor"));
                    flete.setObservacion(res.getString("observacion"));
                    arrFlete.add(flete);
                }
                res.close();
                consulta.close();
            }
            return arrFlete;
        }
    }

    public static void eliminarFlete(Flete flete) throws IOException, SQLException {
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.execute("DELETE FROM dbo.flete"
                    + " WHERE fechaFa = '" + flete.getFechaFa()
                    + "' AND numeroFa = '" + flete.getNumeroFa()
                    + "' AND vendedor = '" + flete.getVendedor()
                    + "' AND montoFa = '" + flete.getMontoFa()
                    + "' AND montoFaVendedor = '" + flete.getMontoFaVendedor()
                    + "' AND observacion = '" + flete.getObservacion() + "'");
            estatuto.close();
        } catch (SQLException s) {
            System.out.println(s);
        }
    }

    public static void actualizaFlete(Flete flete) throws IOException, SQLException {
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.execute("UPDATE dbo.flete SET observacion = '" + flete.getObservacion()
                    + "' WHERE fechaFa = '" + flete.getFechaFa()
                    + "' AND numeroFa = '" + flete.getNumeroFa()
                    + "' AND vendedor = '" + flete.getVendedor()
                    + "' AND montoFa = '" + flete.getMontoFa()
                    + "' AND montoFaVendedor = '" + flete.getMontoFaVendedor() + "'");
            estatuto.close();
        }
    }
}
