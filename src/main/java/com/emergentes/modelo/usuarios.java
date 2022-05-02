
package com.emergentes.modelo;


public class usuarios {
    
    private int id;
    private String Nombre;
    private String Correo;
    private String Clave;

    public usuarios() {
        id=0;
        Nombre="";
        Correo="";
        Clave="";        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }
    
    
    
}
