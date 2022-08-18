package test;

import entities.Adresse;
import entities.Utilisateur;
import fr.m2i.javajpahibernate.SessionManager;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HibernateTest {
    private static SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    @BeforeClass
    public static void beforeTests() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    @Before
    public void setUp() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }
    @After
    public void tearDown() {
        transaction.rollback();
        session.close();
    }

    @Test
    public void testPersist() {
         Utilisateur user = new Utilisateur();
        Adresse address = new Adresse();
        address.setUtilisateur(user);
        user.setAdresses(Arrays.asList(address));
        session.persist(user);
        session.flush();
        session.clear();
    }

    @Test
    public void testMerge() {
        Long adresseId;
        Utilisateur christian = buildUtilisateur("Christian");
        Adresse adresse = buildAdresse(christian);
        christian.setAdresses(Arrays.asList(adresse));
        session.persist(christian);
        session.flush();
        adresseId = adresse.getIdAdresse();
        session.clear();
        Adresse savedAddressEntity = session.find(Adresse.class, adresseId);
        Utilisateur savedPersonEntity = savedAddressEntity.getUtilisateur();
        savedPersonEntity.setNom("RAKOTO Christian");
        savedAddressEntity.setRue("24");
        session.merge(savedPersonEntity);
        session.flush();
    }

    @Test
    public void testRemove() {
        Long userId;
        Utilisateur christian = buildUtilisateur("Christian");
        Adresse adresse = buildAdresse(christian);
        christian.setAdresses(Arrays.asList(adresse));
        session.persist(christian);
        session.flush();
        userId = christian.getIdUtilisateur();
        session.clear();

        Utilisateur savedChristianEntity = session.find(Utilisateur.class, userId);
        session.remove(savedChristianEntity);
        session.flush();
    }

    @Test
    public void testDetach() {

    }

    @Test
    public void testLock() {

    }

    @Test
    public void testRefresh() {
        Utilisateur christian = buildUtilisateur("Christian");
        Adresse adresse = buildAdresse(christian);
        christian.setAdresses(Arrays.asList(adresse));
        session.persist(christian);
        session.flush();
        christian.setNom("RAKOTOARIVOLOLONA");
        adresse.setRue("777");
        session.refresh(christian);
        Assertions.assertTrue(christian.getNom().equals("RAKOTOARIVOLOLONA"));
        Assertions.assertTrue(adresse.getRue().equals("10"));
    }

    @Test
    public void testReplicate() {
        Utilisateur kingkong = buildUtilisateur("KingKong");
        kingkong.setIdUtilisateur(2L);
        Adresse adresse = buildAdresse(kingkong);
        adresse.setIdAdresse(2L);
        kingkong.setAdresses(Arrays.asList(adresse));
        session.unwrap(Session.class).replicate(kingkong, ReplicationMode.OVERWRITE);
        session.flush();
        Assertions.assertTrue(kingkong.getIdUtilisateur()==(2L));
        Assertions.assertTrue(adresse.getIdAdresse()==(2L));
    }

    @Test
    public void testSaveOrUpdate() {
        Utilisateur kingkong = buildUtilisateur("KingKong");
        Adresse adresse = buildAdresse(kingkong);
        kingkong.setAdresses(Arrays.asList(adresse));
        session.saveOrUpdate(kingkong);
        session.flush();
    }

    private Adresse buildAdresse(Utilisateur moi) {
        Adresse adresse = new Adresse();
        adresse.setVille("Tours");
        adresse.setRue("10");
        adresse.setUtilisateur(moi);
        return adresse;
    }

    private Utilisateur buildUtilisateur(String name) {
        Utilisateur user = new Utilisateur();
        user.setNom(name);
        return user;
    }

}