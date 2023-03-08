/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static Principal.Principal.conex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ActualizaCodigoPrecioDAO {

    public static void actualizar(String precio, String codigo) throws SQLException {
// Then, create a SQL query string with placeholders for the parameters
        String query = "UPDATE [ventaempresa].[dbo].[producto] "
                + "SET [ventaempresa].[dbo].[producto].costoUnitario = ? "
                + "FROM [ventaempresa].[dbo].[producto] as a "
                + "INNER JOIN [dbo].[factura] as b ON a.folio = b.folio "
                + "WHERE b.vendedor = ? AND a.codigo = ?";

// Prepare the SQL statement and set the parameter values
        PreparedStatement stmt = conex.getConnection().prepareStatement(query);
        stmt.setString(1, precio);
        stmt.setString(2, "PATRICIO ROMAN");
        stmt.setString(3, codigo);

// Execute the update statement
        int rowsAffected = stmt.executeUpdate();

// Print the number of rows affected
        System.out.println(rowsAffected + " rows updated.");

// Close the statement and connection
        stmt.close();
    }
}
