package buildWeek.Entity;

import buildWeek.Enum.Servizio;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tratta")
public class Tratta {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="zona_partenza")
    private String zonaPartenza;

    private String capolinea;


    public Tratta( String zonaPartenza, String capolinea, List<Mezzo> mezzi) {

        this.zonaPartenza = zonaPartenza;
        this.capolinea = capolinea;


    }
    public Tratta (){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZonaPartenza() {
        return zonaPartenza;
    }

    public void setZonaPartenza(String zonaPartenza) {
        this.zonaPartenza = zonaPartenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

}
