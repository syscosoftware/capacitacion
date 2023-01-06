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

import cr.sysco.model.Hotel;
import cr.sysco.service.HotelService;

@RestController
public class HotelController {

    
    @Autowired
    private HotelService hotelService;
    @PostMapping("/hotel/agregar")
    public ResponseEntity<Map<String, Object>> agregar(@RequestBody Hotel hotel) {

        Map<String, Object> respuesta = new HashMap<String, Object>(); 
        String resultado = hotelService.insertar(hotel); 
        
        respuesta.put("data", hotel);
        respuesta.put("result", resultado);
        respuesta.put("estado", HttpStatus.OK);
        
        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/hotel/buscar/{id}")
    public ResponseEntity<Map<String, Object>> buscar(@PathVariable(value = "id") Integer id ) {

        Map<String, Object> respuesta = new HashMap<String, Object>();   
        respuesta.put("result",hotelService.buscar(id)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/hotel/buscarSQL")
    public ResponseEntity<Map<String, Object>> buscarPostSQL(@RequestBody Hotel hotel) {

        Map<String, Object> respuesta = new HashMap<String, Object>();   
        respuesta.put("result",hotelService.buscarSQL(hotel)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/hotel/buscarHQL")
    public ResponseEntity<Map<String, Object>> buscarPostHQL(@RequestBody Hotel hotel) {

        Map<String, Object> respuesta = new HashMap<String, Object>();   
        respuesta.put("result",hotelService.buscarHQL(hotel)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/hotel/listar")
    public ResponseEntity<Map<String, Object>> listar() {

        Map<String, Object> respuesta = new HashMap<String, Object>(); 
         
        

         respuesta.put("result", hotelService.listar()); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/hotel/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable(value = "id") Integer id) {

        Map<String, Object> respuesta = new HashMap<String, Object>(); 
           
        respuesta.put("result", hotelService.eliminar(id)); 
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

}
