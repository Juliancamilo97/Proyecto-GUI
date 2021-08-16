package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.vo.Requerimiento_1Vo;
import util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1Vo> requerimiento1() throws SQLException {
            Connection conex = JDBCUtilities.getConnection();
            ArrayList<Requerimiento_1Vo> personas = new ArrayList<Requerimiento_1Vo>();
            String sql = "SELECT Ciudad_Residencia, AVG(Salario) as 'Promedio' from Lider group by Ciudad_Residencia HAVING AVG(Salario)<600000 ORDER BY AVG(Salario) DESC";
            try {
                PreparedStatement consulta = conex.prepareStatement(sql);
                ResultSet res = consulta.executeQuery();
                while(res.next()){
                    var persona = new Requerimiento_1Vo();
                    persona.setCiudadResidencia(res.getString("Ciudad_Residencia"));
                    persona.setSalario((int)Math.round(res.getDouble("Promedio")));
                    personas.add(persona);
                }
                res.close();
                consulta.close();
            } catch (SQLException ex) {
                System.out.println("Excepción SQL: " + ex.getMessage());
            }finally{
                if (conex!= null){
                    conex.close();
                }
            } return personas ;
    }

}