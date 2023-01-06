package cr.sysco.controller;

import java.util.HashMap;
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

import cr.sysco.model.Cliente;
import cr.sysco.service.ClienteService;;



@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @PostMapping("/cliente/agregar")
    public ResponseEntity<Map<String, Object>> agregar(@RequestBody Cliente client) {

        Map<String, Object> respuesta = new HashMap<String, Object>(); 
        String resultado = clienteService.insertar(client); 
        
        respuesta.put("data", client);
        respuesta.put("result", resultado);
        respuesta.put("estado", HttpStatus.OK);
        
        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/cliente/buscar/{id}")
    public ResponseEntity<Map<String, Object>> buscar(@PathVariable(value = "id") Integer id ) {

        Map<String, Object> respuesta = new HashMap<String, Object>();   
        respuesta.put("result",clienteService.buscar(id)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/cliente/buscarSQL")
    public ResponseEntity<Map<String, Object>> buscarPostSQL(@RequestBody Cliente client) {

        Map<String, Object> respuesta = new HashMap<String, Object>();   
        respuesta.put("result",clienteService.buscarSQL(client)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping("/cliente/buscarHQL")
    public ResponseEntity<Map<String, Object>> buscarPostHQL(@RequestBody Cliente client) {

        Map<String, Object> respuesta = new HashMap<String, Object>();   
        respuesta.put("result",clienteService.buscarHQL(client)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/cliente/listar")
    public ResponseEntity<Map<String, Object>> listar() {

        Map<String, Object> respuesta = new HashMap<String, Object>(); 

        respuesta.put("result", clienteService.listar()); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
}

@DeleteMapping("/cliente/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable(value = "id") Integer id) {

        Map<String, Object> respuesta = new HashMap<String, Object>(); 
           
        respuesta.put("result", clienteService.eliminar(id)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }


}
