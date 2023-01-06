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

import cr.sysco.model.Tour;
import cr.sysco.service.TourService;

@RestController
public class TourController {

    @Autowired
    private TourService tourService;

    @PostMapping("/tour/agregar")
    public ResponseEntity<Map<String, Object>> agregar(@RequestBody Tour tour) {

        Map<String, Object> respuesta = new HashMap<String, Object>(); 
        String resultado = tourService.insertar(tour); 
        
        respuesta.put("data", tour);
        respuesta.put("result", resultado);
        respuesta.put("estado", HttpStatus.OK);
        
        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/tour/buscar/{id}")
    public ResponseEntity<Map<String, Object>> buscar(@PathVariable(value = "id") Integer id ) {

        Map<String, Object> respuesta = new HashMap<String, Object>();   
        respuesta.put("result",tourService.buscar(id)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

   
    @PostMapping("/tour/buscarSQL")
    public ResponseEntity<Map<String, Object>> buscarPostSQL(@RequestBody Tour tour) {

        Map<String, Object> respuesta = new HashMap<String, Object>();   
        respuesta.put("result",tourService.buscarSQL(tour)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping("/tour/buscarHQL")
    public ResponseEntity<Map<String, Object>> buscarPostHQL(@RequestBody Tour tour) {

        Map<String, Object> respuesta = new HashMap<String, Object>();   
        respuesta.put("result",tourService.buscarHQL(tour)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }
     

    @GetMapping("/tour/listar")
    public ResponseEntity<Map<String, Object>> listar() {

        Map<String, Object> respuesta = new HashMap<String, Object>(); 

         respuesta.put("result", tourService.listar()); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/tour/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable(value = "id") Integer id) {

        Map<String, Object> respuesta = new HashMap<String, Object>(); 
           
        respuesta.put("result", tourService.eliminar(id)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }
    
}
