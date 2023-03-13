/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static Principal.Principal.conex;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sopor
 */
public class UpdaterDAO {

    public static String select(String nombre) {
        String version = "";
        String consulta = "select version from [updater].[dbo].[update] where nombre = '" + nombre + "'";
        try (PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta); ResultSet res = estatuto.executeQuery()) {
            if (res.next()) {
                version = res.getString("version");
            }
            res.close();
            estatuto.close();
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        }
        return version;
    }
}
