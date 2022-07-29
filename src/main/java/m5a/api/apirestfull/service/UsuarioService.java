/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package m5a.api.apirestfull.service;


import java.util.Optional;
import m5a.api.apirestfull.modelo.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Pandora
 */
public interface UsuarioService {

    public Usuario crear(Usuario u);

    public Page<Usuario> findAll(Pageable pageable);

    public Iterable<Usuario> findAll();
    
    public Optional<Usuario> finById(Integer id);

    public void delete(Integer id);

}
