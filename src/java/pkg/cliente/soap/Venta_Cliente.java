/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg.cliente.soap;

import java.util.List;
import pkg_servicio_web.ServicioWebServidor;
import pkg_servicio_web.ServicioWebServidor_Service;
import pkg_servicio_web_vent.ServiciowebServidorVen_Service;
import pkg_servicio_web_vent.ServiciowebServidorVen;

/**
 *
 * @author Paúl
 */
public class Venta_Cliente {

    private ServicioWebServidor_Service service = new ServicioWebServidor_Service();
    ServicioWebServidor port = service.getServicioWebServidorPort();
    private ServiciowebServidorVen_Service service2 = new ServiciowebServidorVen_Service();
    ServiciowebServidorVen port2 = service2.getServiciowebServidorVenPort();
    
    public String ven_id = "";
    public String clie_id = "";
    public String usu_id = "";
    public String ven_lugar = "";
    public String ven_nombre = "";
    public String mensaje = "";

    public ServicioWebServidor_Service getService() {
        return service;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setService(ServicioWebServidor_Service service) {
        this.service = service;
    }

    public ServicioWebServidor getPort() {
        return port;
    }

    public void setPort(ServicioWebServidor port) {
        this.port = port;
    }

    public String getVen_id() {
        return ven_id;
    }

    public void setVen_id(String ven_id) {
        this.ven_id = ven_id;
    }

    public String getClie_id() {
        return clie_id;
    }

    public void setClie_id(String clie_id) {
        this.clie_id = clie_id;
    }

    public String getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(String usu_id) {
        this.usu_id = usu_id;
    }

    public String getVen_lugar() {
        return ven_lugar;
    }

    public void setVen_lugar(String ven_lugar) {
        this.ven_lugar = ven_lugar;
    }

    public String getVent_nombre() {
        return ven_nombre;
    }

    public void setVent_nombre(String vent_nombre) {
        this.ven_nombre = vent_nombre;
    }

    /*METODO INSERTAR */
    public void insertar() {
        int resultado;
        try {
            resultado = port2.insertar(ven_id, clie_id, usu_id, ven_lugar, ven_nombre);
            if (resultado == 1) {
                mensaje = "Se insertó satisfactoriamente";
            } else {
                mensaje = "No se pudo insertar";
            }
        } catch (Exception ex) {
            mensaje = "No se pudo insertar";
        }
    }

    public void eliminar() {
        int resultado;
        try {
            resultado = port.eliminar(ven_id);
            if (resultado == 1) {
                mensaje = "Se eliminó satisfactoriamente";
            } else {
                mensaje = "No se pudo eliminar";
            }
        } catch (Exception ex) {
            mensaje = "No se pudo eliminar";
        }
    }

    public void modificar() {
        int resultado;
        try {
            resultado = port2.modificar(ven_id, clie_id, usu_id, ven_lugar, ven_nombre);
            if (resultado == 1) {
                mensaje = "Se modificó satisfactoriamente";
            } else {
                mensaje = "No se pudo modificar";
            }
        } catch (Exception ex) {
            mensaje = "No se pudo modificar";
        }
    }

    public void buscar() {
        String ls_dep_id;
        try {
            ls_dep_id = port2.buscar(ven_id);
            System.out.println("" + ls_dep_id);
            if (ls_dep_id != null) {
                ven_id = ls_dep_id;
                mensaje = "Registro encontrado";
            } else {
                mensaje = "No se pudo encontrar el registro";
            }
        } catch (Exception ex) {
            mensaje = "No se pudo encontrar el registro";
        }
    }

    public List<pkg_servicio_web_vent.Venta> buscartodo() {

        List aux = port2.buscartodoooo();
        //String ls_dep_id;
        List<pkg_servicio_web_vent.Venta> l1;

        l1 = port2.getList();
        System.out.println("dddddd" + l1.size());

        for (int i = 0; i < l1.size(); i++) {
            System.out.println("" + l1.get(i).getVenId());
        }

        return l1;
    }

}
