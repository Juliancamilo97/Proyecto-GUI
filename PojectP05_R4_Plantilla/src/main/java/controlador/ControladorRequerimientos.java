package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.dao.Requerimiento_1Dao;
import modelo.dao.Requerimiento_2Dao;
import modelo.dao.Requerimiento_3Dao;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;

public class ControladorRequerimientos {
    private Requerimiento_1Dao personadao1;
    private Requerimiento_2Dao personadao2;
    private Requerimiento_3Dao personadao3;


    public ControladorRequerimientos(){
        this.personadao1= new Requerimiento_1Dao();
        this.personadao2= new Requerimiento_2Dao();
        this.personadao3= new Requerimiento_3Dao();
    }

    public ArrayList<Requerimiento_1Vo> consultarRequerimiento1() throws SQLException {
        return this.personadao1.requerimiento1();
    }

    public ArrayList<Requerimiento_2Vo> consultarRequerimiento2() throws SQLException {
        return this.personadao2.requerimiento2();
    }

    public ArrayList<Requerimiento_3Vo> consultarRequerimiento3() throws SQLException {
        return this.personadao3.requerimiento3();
    }

}
