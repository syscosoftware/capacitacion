
package cr.sysco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import cr.sysco.model.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

    @Query(value = "SELECT * FROM CATALOGO_CLIENTE WHERE NOMBRE_CLIENTE LIKE  %:nombre% ", nativeQuery = true)
    List<Cliente> buscarXNombreSQL(@Param("nombre") String nombre);

    
@Query(value = "SELECT usuario FROM Cliente cliente WHERE cliente.nombre LIKE  %:nombre%  ", nativeQuery = false)
List<Cliente> buscarXNombreHQL(@Param("nombre") String nombre);
}

