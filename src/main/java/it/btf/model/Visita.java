package it.btf.model;
import javax.persistence.*;
import java.util.Date;


@Entity
public class Visita {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dataClick;

    @ManyToOne
    private Fornitore fornitore;

    public Visita(){

    }

    public Visita(Date dataClick, Fornitore fornitore) {
        this.dataClick = dataClick;
        this.fornitore = fornitore;
    }

    public Date getDataClick() {
        return dataClick;
    }

    public void setDataClick(Date dataClick) {
        this.dataClick = dataClick;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fornitore getFornitore() {
        return fornitore;
    }

    public void setFornitore(Fornitore fornitore) {
        this.fornitore = fornitore;
    }
}
