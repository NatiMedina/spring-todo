package com.naty.todo.dao;

import com.naty.todo.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }

    @Override
    public Usuario modificarUsuario(Long id, Usuario usuario) {
        Usuario oldUsuario = entityManager.find(Usuario.class, id);
        if (oldUsuario != null && usuario != null) {
            if (usuario.getNombre() != null) {
                oldUsuario.setNombre(usuario.getNombre());
            }
            if (usuario.getApellido() != null) {
                oldUsuario.setApellido(usuario.getApellido());
            }
            if (usuario.getEmail() != null){
                oldUsuario.setEmail(usuario.getEmail());
            }
            if (usuario.getPassword() != null){
                oldUsuario.setPassword(usuario.getPassword());
            }
        }
        return oldUsuario;
    }

}
