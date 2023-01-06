package cr.sysco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cr.sysco.model.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {

    @Query(value = "SELECT * FROM CATALOGO_VUELO WHERE ORIGEN LIKE  %:origen% ", nativeQuery = true)
    List<Vuelo> buscarXOrigenSQL(@Param("origen") String origen);

    @Query(value = "SELECT vuelo FROM Vuelo vuelo WHERE vuelo.origen LIKE  %:origen%  ", nativeQuery = false)
    List<Vuelo> buscarXOrigenHQL(@Param("origen") String origen);

}
