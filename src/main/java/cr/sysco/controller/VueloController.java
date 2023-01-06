package cr.sysco.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cr.sysco.model.Vuelo;
import cr.sysco.service.VueloService;

@RestController
public class VueloController {

    @Autowired
    VueloService vueloService;

    @PostMapping("/vuelo/insertarVuelo")
    public ResponseEntity<Map<String, Object>> insertarVuelo(@RequestBody Vuelo vuelo) {

        Map<String, Object> respuesta = new HashMap<String, Object>();
        String resultado = vueloService.insertarVuelo(vuelo);

        respuesta.put("data", vuelo);
        respuesta.put("result", resultado);
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/vuelo/buscarVuelo/{id}")
    public ResponseEntity<Map<String, Object>> buscarVuelo(@PathVariable(value = "id") Integer id) {

        Map<String, Object> respuesta = new HashMap<String, Object>();
        respuesta.put("result", vueloService.buscarVuelo(id));
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/vuelo/listarVuelos")
    public ResponseEntity<Map<String, Object>> listarVuelos() {

        Map<String, Object> respuesta = new HashMap<String, Object>();

        respuesta.put("result", vueloService.listarVuelos());
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/vuelo/buscarOrigenVueloSQL")
    public ResponseEntity<Map<String, Object>> buscarOrigenVueloSQL(@RequestBody Vuelo vuelo) {

        Map<String, Object> respuesta = new HashMap<String, Object>();
        respuesta.put("result", vueloService.buscarOrigenVueloSQL(vuelo));
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/vuelo/buscarOrigenVueloHQL")
    public ResponseEntity<Map<String, Object>> buscarOrigenVueloHQL(@RequestBody Vuelo vuelo) {

        Map<String, Object> respuesta = new HashMap<String, Object>();
        respuesta.put("result", vueloService.buscarOrigenVueloHQL(vuelo));
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/vuelo/eliminarVuelo/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable(value = "id") Integer id) {

        Map<String, Object> respuesta = new HashMap<String, Object>();

        respuesta.put("result", vueloService.eliminarVuelo(id));
        respuesta.put("estado", HttpStatus.OK);

        return new ResponseEntity<Map<String, Object>>(respuesta, new HttpHeaders(), HttpStatus.OK);
    }

}
