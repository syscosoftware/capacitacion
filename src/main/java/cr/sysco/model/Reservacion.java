package cr.sysco.model;

import java.util.Date;

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
@Table(name = "CATALOGO_RESERVACION")
public class Reservacion {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FECHA ")
    private Date fecha;

    @Column(name = "CONDICION_VENTA")
    private String condicionVenta;

    @Column(name = "MEDIO_PAGO")
    private String medioPago;
}
