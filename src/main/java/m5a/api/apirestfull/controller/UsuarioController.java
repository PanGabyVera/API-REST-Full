/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m5a.api.apirestfull.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import m5a.api.apirestfull.modelo.Usuario;
import m5a.api.apirestfull.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pandora
 */
@RestController
@RequestMapping("/api/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuService;

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Usuario u) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuService.crear(u));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Optional<Usuario> oUser = usuService.finById(id);

        if (!oUser.isPresent()) {//si no encuentra al usuario

            //return ResponseEntity.notFound().build();//devuelve un cod de estado-respuesta
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(oUser);//devolvemos al usuario
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Usuario u) {
        Optional<Usuario> oUser = usuService.finById(id);

        if (!oUser.isPresent()) {
            return new ResponseEntity<>("Usuario no encontrado o no existe", HttpStatus.NOT_FOUND);
        } 
           //get es para llamar al objeto
                oUser.get().setNombre(u.getNombre());
                oUser.get().setEmail(u.getEmail());
                oUser.get().setClave(u.getClave());

                return ResponseEntity.status(HttpStatus.CREATED).body(usuService.crear(oUser.get()));

    }
    
     @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
         if (!usuService.finById(id).isPresent()) {
             return new ResponseEntity<>("Usuario No existe", HttpStatus.NOT_FOUND);
         }
         usuService.delete(id);
         return ResponseEntity.ok().build();
    }
    
    @GetMapping("/listar")
    public List<Usuario> listar() {
       List<Usuario> user = StreamSupport 
               .stream(usuService.findAll().spliterator(), false) //para que sea secuencial
               .collect(Collectors.toList());//para que se transforme a una lista
       return user;
    }

}
