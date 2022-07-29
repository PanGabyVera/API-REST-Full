/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m5a.api.apirestfull.service;

import java.util.Optional;
import m5a.api.apirestfull.modelo.Usuario;
import m5a.api.apirestfull.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Pandora
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{

    
    @Autowired
    private UsuarioRepository usuaRepository;
    
    @Override
    @Transactional
    public Usuario crear(Usuario u) {
        return usuaRepository.save(u);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> findAll(Pageable pageable) {
        return usuaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)//solo lectura no se guarda en a base
    public Iterable<Usuario> findAll() {
        return usuaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> finById(Integer id) {
        return usuaRepository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        usuaRepository.deleteById(id);
    }
    
}
