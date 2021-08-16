package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2Vo> requerimiento2() throws SQLException {
        Connection conex2 = JDBCUtilities.getConnection();
            ArrayList<Requerimiento_2Vo> personas2 = new ArrayList<Requerimiento_2Vo>();
            String sql = "SELECT  p.ID_Proyecto, c.Proveedor from Compra c join Proyecto p on p.ID_Proyecto = c.ID_Proyecto WHERE p.Ciudad = 'Quibdo' ORDER BY  p.ID_Proyecto ASC";
            try {
                PreparedStatement consulta2 = conex2.prepareStatement(sql);
                ResultSet res2 = consulta2.executeQuery();
                while(res2.next()){
                    var persona2 = new Requerimiento_2Vo();
                    persona2.setIdProyecto(res2.getInt("ID_Proyecto"));
                    persona2.setProveedor(res2.getString("Proveedor"));
                    personas2.add(persona2);
                }
                res2.close();
                consulta2.close();
            } catch (SQLException ex) {
                System.out.println("Excepción SQL: " + ex.getMessage());
            }finally{
                if (conex2!= null){
                    conex2.close();
                }
            } return personas2;
    }
}