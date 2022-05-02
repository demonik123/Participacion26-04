
package com.emergentes.dao;

import com.emergentes.modelo.usuarios;
import java.util.List;

public interface usuariosDAO {
    public void insert(usuarios usuario) throws Exception;
    public void update(usuarios usuario) throws Exception;
    public void delete(int id) throws Exception;
    public List<usuarios> getAll() throws Exception;
    public usuarios getById(int id) throws Exception;
}
