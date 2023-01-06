package cr.sysco.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 
    
}
