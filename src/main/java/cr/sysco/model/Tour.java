package cr.sysco.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "CATALOGO_TOURS")
public class Tour implements Serializable {
    

    @Id
	private Integer id;

	private String nombre;

	private String descripcion;

	private Double precio;


}
