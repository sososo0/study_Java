import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class PlayerRepository implements IRepository{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pnu.cse");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    public void save(Player t){

        Club club = new Club();
        Country country = new Country();

        club.getPlayers().add(t);
        country.getPlayers().add(t);

    }

    public void deleteById(int id){

        Optional<Player> player = findById(id);

        try{
            tx.begin();
            em.remove(player.orElseThrow(()-> new RuntimeException(
                    String.format("No %S entity with id %s exists!",Player.class,id)
            )));

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        em.close();
        emf.close();

    }

    public List<Player> findAll(){

        List<Player> players = em.createQuery(String.format("select x from %s x",Player.class.getSimpleName()),
                    Player.class).getResultList();

        em.close();
        emf.close();

        return players;

    }

    public Optional<Player> findById(int id){

        Player player = em.find(Player.class,Long.parseLong(String.valueOf(id)));
        Optional<Player> player1 = Optional.ofNullable(player);

        return player1;

    }
}
