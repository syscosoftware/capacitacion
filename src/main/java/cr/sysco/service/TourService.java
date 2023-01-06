package cr.sysco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.sysco.model.Tour;
import cr.sysco.repository.TourRepository;

@Service
public class TourService {
    
    @Autowired
    private TourRepository tourRepository;


    public String insertar(Tour tour){
        try{

            this.tourRepository.save(tour);
            
            return "success";
        }catch(Exception ex){
            ex.printStackTrace();
            return ex.getMessage();
        } 
    }

    public Tour buscar(Integer id){
        try{
            Optional<Tour> lista = this.tourRepository.findById(id);
            if(lista!=null){
                return lista.get();
            }else{
                return null;
            } 
        }catch(Exception ex){
            ex.printStackTrace(); 
            return null;
        } 
    }

    public  List<Tour> buscarSQL(Tour tour){
        try{
            List<Tour> lista = this.tourRepository.buscarXNombreSQL(tour.getNombre());

            if(lista!=null){
                return lista ;
            }else{
                return null;
            } 
        }catch(Exception ex){
            ex.printStackTrace(); 
            return null;
        } 
    }

    public  List<Tour> buscarHQL(Tour tour){
        try{
            List<Tour> lista = this.tourRepository.buscarXNombreHQL(tour.getNombre());

            
            if(lista!=null){
                return lista ;
            }else{
                return null;
            } 
        }catch(Exception ex){
            ex.printStackTrace(); 
            return null;
        } 
    }

    public  List<Tour> listar(){
        try{ 
            return this.tourRepository.findAll();
           
        }catch(Exception ex){
            ex.printStackTrace(); 
            return null;
        } 
    }

    public String eliminar(Integer id){
        try{
             this.tourRepository.deleteById(id);
            return "success";
        }catch(Exception ex){
            ex.printStackTrace(); 
            return ex.getMessage();
        } 
    }

   
}
