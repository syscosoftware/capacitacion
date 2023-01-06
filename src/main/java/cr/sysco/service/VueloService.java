package cr.sysco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.sysco.model.Vuelo;
import cr.sysco.repository.VueloRepository;

@Service
public class VueloService {

    @Autowired
    VueloRepository vueloRepository;

    public String insertarVuelo(Vuelo vuelo) {

        this.vueloRepository.save(vuelo);
        return "Vuelo success";
    }

    public Vuelo buscarVuelo(Integer id) {
        try {
            Optional<Vuelo> vuelo = this.vueloRepository.findById(id);
            if (vuelo != null) {
                return vuelo.get();
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Vuelo> buscarOrigenVueloSQL(Vuelo vuelo) {
        try {
            List<Vuelo> lista = this.vueloRepository.buscarXOrigenSQL(vuelo.getOrigen());

            if (lista != null) {
                return lista;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Vuelo> buscarOrigenVueloHQL(Vuelo vuelo) {
        try {
            List<Vuelo> lista = this.vueloRepository.buscarXOrigenHQL(vuelo.getOrigen());

            if (lista != null) {
                return lista;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Vuelo> listarVuelos() {
        try {
            return this.vueloRepository.findAll();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String eliminarVuelo(Integer id) {
        try {
            this.vueloRepository.deleteById(id);
            return "success";
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }
}
