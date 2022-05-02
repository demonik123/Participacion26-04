
package com.emergentes.controlador;


import com.emergentes.dao.usuariosDAO;
import com.emergentes.dao.usuariosDAOimpl;
import com.emergentes.modelo.usuarios;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        usuariosDAO dao = new usuariosDAOimpl();
        
        usuarios usu = new usuarios();
        int id;
        
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                break;
            case "edit":
                // AvisoController?action=edit&id=3
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    // obtener el objeto que corresponde al registro
                    usu = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Eror al obtener registro " + ex.getMessage());
                }
                // Colocar como atributo
                request.setAttribute("usuario", usu);
                // Transferir el control a frmaviso.jsp
                request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Erro al eliminar: " + ex.getMessage());
                }
                response.sendRedirect("UsuarioController");
                break;
            case "view":
                List<usuarios> lista = new ArrayList<usuarios>(); 
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar "+ex.getMessage());
                }
                request.setAttribute("usuarios", lista);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
      int id = Integer.parseInt(request.getParameter("id"));
        String Nombre =  request.getParameter("Nombre");
        String Correo =  request.getParameter("Correo");
        String Clave = request.getParameter("Clave");
        
        usuarios usu = new usuarios();
        
        usu.setId(id);
        usu.setNombre(Nombre);
        usu.setCorreo(Correo);
        usu.setClave(Clave);
        
        usuariosDAO dao = new usuariosDAOimpl();
        
        if (id == 0){
            try {
                // Nuevo
                dao.insert(usu);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        }
        else{
            try {
                // Edición
                dao.update(usu);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("UsuarioController");
   
   
}
}