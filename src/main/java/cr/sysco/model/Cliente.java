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
    @Table(name = "CATALOGO_CLIENTE")
    public class Cliente implements Serializable{
     
        @Id
        @Column(name = "IDENTIFICACION")
        private Integer id;

        @Column(name = "NOMBRE_CLIENTE")
        private String nombre;
      
        @Column(name = "CORREO")
        private String correo;

        @Column(name = "ANO_NACIMIENTO")
        private Integer anoNacimiento;
    
    }
        



