package cr.sysco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cr.sysco.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    /**
     * Este proceso es por SQL, utiliza los nombre de las tablas y las columnas, puede usar funciones propias del motor
     * pero de debe tener en cuenta que si el motor se llega a cambiar, puede ser que se deban realizar ajustes al código
     * @param nombre de tipo <code>String</code>
     * @return lista de usuario <code>List<Usuario></code> que cumplen con los criterios de búsqueda
     */
    @Query(value = "SELECT * FROM CATALOGO_USUARIO WHERE NOMBRE_USUARIO LIKE  %:nombre% ", nativeQuery = true)
    List<Usuario> buscarXNombreSQL(@Param("nombre") String nombre);

    /**
     * Este proceso es por HQL, utiliza los nombres de las clases y atributos, utiliza nombres de funciones estandar,
     * puede ser que algunos comandos propios de SQL no se interpreten
     * @param nombre de tipo <code>String</code>
     * @return  lista de usuario <code>List<Usuario></code> que cumplen con los criterios de búsqueda
     */
    @Query(value = "SELECT usuario FROM Usuario usuario WHERE usuario.nombre LIKE  %:nombre%  ", nativeQuery = false)
    List<Usuario> buscarXNombreHQL(@Param("nombre") String nombre);
 
}