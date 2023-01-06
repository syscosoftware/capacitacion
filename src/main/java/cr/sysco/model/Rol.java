package cr.sysco.model;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name = "CATALOGO_ROL")
public class Rol implements Serializable {
 
    @Id
	@Column(name = "CODIGO")
	private Integer id;
  
    @Column(name = "NOMBRE")
	private String nombre;
 
  

}
