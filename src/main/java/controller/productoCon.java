package controller;

import dao.productoImpl;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.producto;


@Named(value = "producto")
@SessionScoped

public class productoCon implements Serializable{
    
     private productoImpl dao = new productoImpl();
    private producto pro = new producto();
    
    
    public void registrar() throws Exception {
        try {
            dao.registrar(pro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registro exitoso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "producto no registrado en la base de datos"));
            
        }
    
    }

    public productoImpl getDao() {
        return dao;
    }

    public void setDao(productoImpl dao) {
        this.dao = dao;
    }

    public producto getPro() {
        return pro;
    }

    public void setPro(producto pro) {
        this.pro = pro;
    }
    
}














































