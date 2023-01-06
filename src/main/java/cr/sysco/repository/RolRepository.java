package cr.sysco.repository;
 
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import cr.sysco.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

     
}