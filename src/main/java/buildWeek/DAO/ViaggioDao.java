package buildWeek.DAO;

import buildWeek.Entity.Mezzo;
import buildWeek.Entity.Tratta;
import buildWeek.Entity.Viaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ViaggioDao {

    private EntityManager em;

    public ViaggioDao(EntityManager em) {
        this.em = em;
    }

    public void save(Viaggio viaggio) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(viaggio);
        et.commit();
    }

    public Viaggio getViaggioById (int id) {
        return em.find(Viaggio.class, id);
    }

    public List<Integer> getAllViaggi() {
        return em.createQuery("SELECT v.id FROM Viaggio v", Integer.class).getResultList();
    }

    public void delete (int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Viaggio viaggio = getViaggioById(id);

        if (viaggio != null) {
            em.remove(viaggio);
        } else {
            System.out.println("Abbonamento non presente");
        }

        et.commit();
    }

    public Number getViaggiPerTratta(Tratta tratta, Mezzo mezzo) {
        return mezzo.getViaggi().stream().filter(viaggio -> viaggio.getTratta().equals(tratta)).count();
    }

}
