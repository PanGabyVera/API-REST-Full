/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package m5a.api.apirestfull.repository;

import m5a.api.apirestfull.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pandora
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
