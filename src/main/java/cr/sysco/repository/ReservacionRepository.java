package cr.sysco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cr.sysco.model.Reservacion;

@Repository
public interface ReservacionRepository extends JpaRepository<Reservacion, Integer> {

}