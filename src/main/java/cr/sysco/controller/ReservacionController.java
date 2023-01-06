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

import cr.sysco.model.Reservacion;
import cr.sysco.service.ReservacionService;


@RestController
public class ReservacionController {
    @Autowired
    private ReservacionService reservacionService;

    @PostMapping("/reservacion")
    public ResponseEntity<Map<String, Object>> insertar(@RequestBody Reservacion reservacion) {
        Map<String, Object> respuesta = new HashMap<String, Object>(); 
        String result = this.reservacionService.insertar(reservacion);

        respuesta.put("data",  reservacion);
        respuesta.put("result",  result);
        respuesta.put("status", HttpStatus.CREATED);
        
        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/reservacion/{id}")
    public ResponseEntity<Map<String, Object>> obtenerUno(@PathVariable(value = "id") Integer id ) {
        Map<String, Object> respuesta = new HashMap<String, Object>(); 

        respuesta.put("result",  this.reservacionService.obtenerUno(id));
        respuesta.put("status", HttpStatus.OK);
        
        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/reservacion")
    public ResponseEntity<Map<String, Object>> obtener() {
        Map<String, Object> respuesta = new HashMap<String, Object>(); 

        respuesta.put("result",  this.reservacionService.listar());
        respuesta.put("status", HttpStatus.OK);
        
        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }


    @DeleteMapping("/reservacion/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable(value = "id") Integer id ) {
        Map<String, Object> respuesta = new HashMap<String, Object>(); 
        String resultado = this.reservacionService.eliminar(id);

        respuesta.put("result", resultado);
        respuesta.put("status", HttpStatus.ACCEPTED);
        
        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }
}
