import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class DatabaseTest {
    public static void main(String [] args){

        makePlayer();

    }

    public static JFrame makePlayer(){

        JFrame jFrame = new JFrame();
        JPanel jTextP = new JPanel();
        JPanel jB = new JPanel();
        JPanel jTot = new JPanel();

        JTextField id = new JTextField(20);
        JTextField name = new JTextField(20);
        JTextField height = new JTextField(20);
        JTextField country = new JTextField(20);
        JTextField club = new JTextField(20);
        JTextField overall = new JTextField(20);
        JTextField positions = new JTextField(20);

        JTextArea result = new JTextArea(300,100);

        JTextField [] jArr = {id,name,height,country,club,overall,positions};

        JLabel jId = new JLabel("id");
        JLabel jName = new JLabel("name");
        JLabel jHeight = new JLabel("height");
        JLabel jCountry = new JLabel("country");
        JLabel jClub = new JLabel("club");
        JLabel jOverall = new JLabel("overall");
        JLabel jPositions = new JLabel("positions");

        JButton jCreate = new JButton("Create");
        JButton jDelete = new JButton("Delete");
        JButton jSearch = new JButton("Search");

        JScrollPane jp ;

        jFrame.setSize(600,600);
        jFrame.setLayout(new BorderLayout());
        jTot.setLayout(new BorderLayout());
        jTextP.setLayout(new GridLayout(7,2));
        id.setSize(500,20);
        name.setSize(500,20);
        height.setSize(500,20);
        country.setSize(500,20);
        club.setSize(500,20);
        overall.setSize(500,20);
        positions.setSize(500,20);

        jTextP.add(jId);
        jTextP.add(id);
        jTextP.add(jName);
        jTextP.add(name);
        jTextP.add(jHeight);
        jTextP.add(height);
        jTextP.add(jCountry);
        jTextP.add(country);
        jTextP.add(jClub);
        jTextP.add(club);
        jTextP.add(jOverall);
        jTextP.add(overall);
        jTextP.add(jPositions);
        jTextP.add(positions);
        jTot.add(jTextP,BorderLayout.CENTER);

        jB.add(jCreate);
        jB.add(jDelete);
        jB.add(jSearch);
        jTot.add(jB,BorderLayout.SOUTH);

        jp = new JScrollPane(result);

        jFrame.add(jTot,BorderLayout.NORTH);
        jFrame.add(jp,BorderLayout.CENTER);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        jCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPlayer(jArr,result);
            }
        });
        jDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePlayer();
            }
        });
        jSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPlayer();
            }
        });

        return jFrame;
    }

    public static void createPlayer(JTextField [] j,JTextArea ja){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pnu.cse");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Club club = new Club();
        Country country = new Country();

        club.setName(j[4].getText());
        country.setName(j[3].getText());

        PlayerRepository repository = new PlayerRepository();

       try{
           tx.begin();

           Player player = em.find(Player.class,Long.parseLong(j[0].getText()));

           player.setId(Long.parseLong(j[0].getText()));
           player.setName(j[1].getText());
           player.setHeight(Integer.parseInt(j[2].getText()));
           player.setClub(club);
           player.setNationality(country);
           player.setOverall(Integer.parseInt(j[5].getText()));
           player.setPositions(j[6].getText());

           repository.save(player);

           ja.append(player.getId()+"Create!\n");

           em.persist(club);
           em.persist(country);
           tx.commit();
       }catch (NullPointerException ex){
           ex.printStackTrace();
           tx.rollback();
       }
       catch (NumberFormatException ex){
           ex.printStackTrace();
           tx.rollback();
       }
       catch (Exception ex) {
           ex.printStackTrace();
           tx.rollback();
       }

       em.close();
       emf.close();

    }

    public static void deletePlayer(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pnu.cse");
        EntityManager em = emf.createEntityManager();
        PlayerRepository repository = new PlayerRepository();

        JFrame jFrame = new JFrame();
        jFrame.setSize(600,500);
        jFrame.setLayout(new BorderLayout());

        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(1,2));
        JPanel jp2 = new JPanel();
        jp2.setLayout(new BorderLayout());
        JPanel jTot = new JPanel();
        jTot.setLayout(new BorderLayout());

        JTextField id= new JTextField();
        JLabel jl = new JLabel("id");
        JButton jb = new JButton("Delete");

        JTextArea ja = new JTextArea();

        jp1.add(jl);
        jp1.add(id);

        jp2.add(jb,BorderLayout.NORTH);
        jp2.add(ja,BorderLayout.CENTER);

        jTot.add(jp1,BorderLayout.NORTH);
        jTot.add(jp2,BorderLayout.CENTER);

        jFrame.add(jTot);

        jFrame.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        jFrame.setVisible(true);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repository.deleteById(Integer.parseInt(id.getText()));
                ja.append("Delete Success\n");
            }
        });

        em.close();
        emf.close();

    }

    public static void searchPlayer() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pnu.cse");
        EntityManager em = emf.createEntityManager();
        PlayerRepository repository = new PlayerRepository();

        JFrame jFrame = new JFrame();
        jFrame.setSize(600,500);
        jFrame.setLayout(new BorderLayout());

        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(1,2));
        JPanel jp2 = new JPanel();
        jp2.setLayout(new BorderLayout());
        JPanel jTot = new JPanel();
        jTot.setLayout(new BorderLayout());

        JTextField id = new JTextField();
        JLabel jl = new JLabel("id");
        JButton jb = new JButton("Search");

        JTextArea ja = new JTextArea();

        jp1.add(jl);
        jp1.add(id);

        jp2.add(jb,BorderLayout.NORTH);
        jp2.add(ja,BorderLayout.CENTER);

        jTot.add(jp1,BorderLayout.NORTH);
        jTot.add(jp2,BorderLayout.CENTER);

        jFrame.add(jTot);

        jFrame.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        jFrame.setVisible(true);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Optional<Player> player = repository.findById(Integer.parseInt(id.getText()));
                ja.append(player.toString());
            }
        });
        em.close();
        emf.close();
    }
}
