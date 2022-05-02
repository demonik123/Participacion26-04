package com.emergentes.dao;

import com.emergentes.modelo.usuarios;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class usuariosDAOimpl extends ConexionBD implements usuariosDAO {

    @Override
    public void insert(usuarios usuario) throws Exception {
        String sql = "insert into usuarios (Nombre,Correo,Clave) values (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getCorreo());
        ps.setString(3, usuario.getClave());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(usuarios usuario) throws Exception {
        String sql = "update usuarios set Nombre=?, Correo=?, Clave=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getCorreo());
        ps.setString(3, usuario.getClave());
        ps.setInt(4, usuario.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from usuarios where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<usuarios> getAll() throws Exception {
     List<usuarios> lista = null;
        String sql = "select * from usuarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList<usuarios>();
        while(rs.next()){
            usuarios usu = new usuarios();
            
            usu.setId(rs.getInt("id"));
            usu.setNombre(rs.getString("Nombre"));
            usu.setCorreo(rs.getString("Correo"));
            usu.setClave(rs.getString("Clave"));

            lista.add(usu);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public usuarios getById(int id) throws Exception {
       usuarios usu = new usuarios();
        try {
            String sql = "select * from usuarios where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                usu.setId(rs.getInt("id"));
                usu.setNombre(rs.getString("Nombre"));
                usu.setCorreo(rs.getString("Correo"));
                usu.setClave(rs.getString("Clave"));
            }
        } catch (SQLException e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return usu;
    }

}
