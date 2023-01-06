package cr.sysco.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cr.sysco.model.Usuario;
import cr.sysco.service.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuario/agregar")
    public ResponseEntity<Map<String, Object>> agregar(@RequestBody Usuario user) {

        Map<String, Object> respuesta = new HashMap<String, Object>(); 
        String resultado = usuarioService.insertar(user); 
        
        respuesta.put("data", user);
        respuesta.put("result", resultado);
        respuesta.put("estado", HttpStatus.OK);
        
        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/usuario/buscar/{id}")
    public ResponseEntity<Map<String, Object>> buscar(@PathVariable(value = "id") Integer id ) {

        Map<String, Object> respuesta = new HashMap<String, Object>();   
        respuesta.put("result",usuarioService.buscar(id)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping("/usuario/buscarSQL")
    public ResponseEntity<Map<String, Object>> buscarPostSQL(@RequestBody Usuario user) {

        Map<String, Object> respuesta = new HashMap<String, Object>();   
        respuesta.put("result",usuarioService.buscarSQL(user)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping("/usuario/buscarHQL")
    public ResponseEntity<Map<String, Object>> buscarPostHQL(@RequestBody Usuario user) {

        Map<String, Object> respuesta = new HashMap<String, Object>();   
        respuesta.put("result",usuarioService.buscarHQL(user)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }
    

    @GetMapping("/usuario/listar")
    public ResponseEntity<Map<String, Object>> listar() {

        Map<String, Object> respuesta = new HashMap<String, Object>(); 
         
        //List<Usuario> lista = usuarioService.listar();
        //respuesta.put("result",lista ); 

         respuesta.put("result", usuarioService.listar()); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/usuario/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable(value = "id") Integer id) {

        Map<String, Object> respuesta = new HashMap<String, Object>(); 
           
        respuesta.put("result", usuarioService.eliminar(id)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }
    
}
