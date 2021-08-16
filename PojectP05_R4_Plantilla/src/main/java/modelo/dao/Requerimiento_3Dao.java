package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.vo.Requerimiento_3Vo;
import util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3Vo> requerimiento3() throws SQLException {
        Connection conex3 = JDBCUtilities.getConnection();
            ArrayList<Requerimiento_3Vo> personas3 = new ArrayList<Requerimiento_3Vo>();
            String sql = "SELECT p.ID_Proyecto, mc.Nombre_Material from Proyecto p join Compra c on (p.ID_Proyecto = c.ID_Proyecto )join MaterialConstruccion mc on (mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion) WHERE p.ID_Proyecto BETWEEN 5 and 15 ORDER BY  p.ID_Proyecto  ASC";
            try {
                PreparedStatement consulta3 = conex3.prepareStatement(sql);
                ResultSet res3 = consulta3.executeQuery();
                while(res3.next()){
                    var persona3 = new Requerimiento_3Vo();
                    persona3.setIdProyecto(res3.getInt("ID_Proyecto"));
                    persona3.setNombreMaterial(res3.getString("Nombre_Material"));
                    personas3.add(persona3);
                }
                res3.close();
                consulta3.close();
            } catch (SQLException ex) {
                System.out.println("Excepción SQL: " + ex.getMessage());
            }finally{
                if (conex3!= null){
                    conex3.close();
                }
            } return personas3;
    }
}