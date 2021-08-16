package vista;

import java.util.ArrayList;

import controlador.ControladorRequerimientos;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;

public class VistaRequerimientos {

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    public static void requerimiento1() {
        try{
            ArrayList<Requerimiento_1Vo> personas;
            personas= controlador.consultarRequerimiento1();

            for (Requerimiento_1Vo requerimiento_1Vo: personas){
                System.out.println(requerimiento_1Vo.getCiudadResidencia()+ " " + requerimiento_1Vo.getSalario());
            }
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void requerimiento2() {
        try {
            ArrayList<Requerimiento_2Vo> personas2;
            personas2= controlador.consultarRequerimiento2();

            for (Requerimiento_2Vo requerimiento_2Vo: personas2){
                System.out.println(requerimiento_2Vo.getIdProyecto()+ " " + requerimiento_2Vo.getProveedor());
            }
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void requerimiento3() {
        try {
            ArrayList<Requerimiento_3Vo> personas3;
            personas3= controlador.consultarRequerimiento3();

            for (Requerimiento_3Vo requerimiento_3Vo: personas3){
                System.out.println(requerimiento_3Vo.getIdProyecto()+ " " + requerimiento_3Vo.getNombreMaterial());
            }
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

}
