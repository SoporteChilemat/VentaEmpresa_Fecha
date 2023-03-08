package DAO;

import Clases.Maestra;
import Principal.MenuExcelDialog;
import static Principal.MenuExcelDialog.cont;
import static Principal.Principal.conex;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class maestraDAO {

    public static boolean insertMaestra(ArrayList<Maestra> arrMaestra) throws IOException, SQLException {
        try {
            PreparedStatement estatutoEliminar = conex.getConnection().prepareStatement("DELETE FROM dbo.maestra");
            estatutoEliminar.execute();

            PreparedStatement estatuto = conex.getConnection().prepareStatement("INSERT INTO dbo.maestra VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            arrMaestra.stream().forEach((Maestra maestra) -> {
                try {
                    MenuExcelDialog.jButton9.setText(cont.toString());
                    estatuto.setString(1, maestra.getCodigoProducto().replace("Ñ", "N"));
                    estatuto.setString(2, maestra.getDescripcion());
                    estatuto.setString(3, maestra.getStock());
                    estatuto.setString(4, maestra.getUnidad());
                    estatuto.setString(5, maestra.getMedida());
                    estatuto.setString(6, maestra.getCostoFinalSaf());
                    estatuto.setString(7, maestra.getMargen());
                    estatuto.setString(8, maestra.getNeto());
                    estatuto.setString(9, maestra.getPrecioFinal());
                    estatuto.setString(10, maestra.getFamilia());
                    estatuto.addBatch();

                    cont.getAndIncrement();
                } catch (SQLException ex) {
                    Logger.getLogger(maestraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            estatuto.executeBatch();
            estatuto.close();

            return true;
        } catch (Exception ex) {
            Logger.getLogger(maestraDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static int insertMaestraUnico(Maestra maestra) throws SQLException {
        try ( PreparedStatement estatuto = conex.getConnection().prepareStatement("INSERT INTO dbo.maestra VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            estatuto.setString(1, maestra.getCodigoProducto().replace("Ñ", "N"));
            estatuto.setString(2, maestra.getDescripcion());
            estatuto.setString(3, maestra.getStock());
            estatuto.setString(4, maestra.getUnidad());
            estatuto.setString(5, maestra.getMedida());
            estatuto.setString(6, maestra.getCostoFinalSaf());
            estatuto.setString(7, maestra.getMargen());
            estatuto.setString(8, maestra.getNeto());
            estatuto.setString(9, maestra.getPrecioFinal());
            estatuto.setString(10, maestra.getFamilia());
            estatuto.addBatch();
            estatuto.executeBatch();

            return 0;
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            if (ex.toString().contains("PRIMARY KEY")) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    public static String selectCostoFinalCodigoMaestra(String codigo, String ventaEmpresa) throws SQLException, IOException {
        String costoFinal = null;
        if (ventaEmpresa.equals("0")) {
            try ( PreparedStatement estatuto = conex.getConnection().prepareStatement("select costoFinal from dbo.maestra where codigoProducto = '" + codigo + "' COLLATE Latin1_general_CI_AI");  ResultSet res = estatuto.executeQuery()) {
                if (res.next()) {
                    costoFinal = res.getString("costoFinal");
                }
                res.close();
                estatuto.close();
            }
        } else {
            try ( PreparedStatement estatuto = conex.getConnection().prepareStatement("select costoFinal from dbo.maestra where codigoProducto = 'V.E." + codigo + "' COLLATE Latin1_general_CI_AI");  ResultSet res = estatuto.executeQuery()) {
                if (res.next()) {
                    costoFinal = res.getString("costoFinal");
                }
                res.close();
                estatuto.close();
            }
        }
        return costoFinal;
    }

    public static void eliminarUnoMaestra(String folio) throws IOException, SQLException {
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.execute("DELETE FROM dbo.maestra WHERE codigoProducto = '" + folio + "'");
            estatuto.close();
        } catch (SQLException s) {
            System.out.println(s);
        }
    }

    public static ArrayList<Maestra> selectAllMaestra() throws SQLException, IOException {
        ArrayList<Maestra> arrMaestra = new ArrayList<>();
        try ( PreparedStatement estatuto = conex.getConnection().prepareStatement("select * from dbo.maestra");  ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                Maestra maestra = new Maestra();
                maestra.setCodigoProducto(res.getString("codigoProducto"));
                maestra.setDescripcion(res.getString("descripcion"));
                maestra.setCostoFinalSaf(res.getString("costoFinal"));
                arrMaestra.add(maestra);
            }
            res.close();
            estatuto.close();
        }
        return arrMaestra;
    }

    public static void actualizaMaestra(Maestra maestra) throws IOException, SQLException {
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.execute("UPDATE dbo.maestra SET costoFinal = '" + maestra.getCostoFinalSaf()
                    + "' WHERE codigoProducto = '" + maestra.getCodigoProducto() + "'");
            estatuto.close();
        }
    }
}
