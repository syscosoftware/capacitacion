package cr.sysco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cr.sysco.model.Tour;

@Repository
public interface TourRepository extends  JpaRepository<Tour, Integer> {


    @Query(value = "SELECT * FROM CATALOGO_TOURS WHERE NOMBRE LIKE  %:nombre% ", nativeQuery = true)
    List<Tour> buscarXNombreSQL(@Param("nombre") String nombre);



    @Query(value = "SELECT tour FROM Tour tour WHERE tour.nombre LIKE  %:nombre%  ", nativeQuery = false)
    List<Tour> buscarXNombreHQL(@Param("nombre") String nombre);
}
