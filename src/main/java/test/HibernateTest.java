package test;

import entities.Adresse;
import entities.Utilisateur;
import helper.SessionHelper;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.Arrays;



class HibernateTest {
    private static EntityManager sessionHelper;
    private Transaction transaction;

    @BeforeClass
    public static void beforeTests() {
        sessionHelper = SessionHelper.getEntityManager();
    }
    @Before
    public void setUp() {

    }
    @After
    public void tearDown() {
        transaction.rollback();
        sessionHelper.close();
    }

    @Test
    public void testPersist() {
        Utilisateur user = new Utilisateur();
        Adresse address = new Adresse();
        address.setUtilisateur(user);
        user.setAdresses(Arrays.asList(address));
        sessionHelper.persist(user);
        sessionHelper.flush();
        sessionHelper.clear();
    }

    @Test
    public void testMerge() {
        Long adresseId;
        Utilisateur christian = buildUtilisateur("Christian");
        Adresse adresse = buildAdresse(christian);
        christian.setAdresses(Arrays.asList(adresse));
        sessionHelper.persist(christian);
        sessionHelper.flush();
        adresseId = adresse.getIdAdresse();
        sessionHelper.clear();
        Adresse savedAddressEntity = sessionHelper.find(Adresse.class, adresseId);
        Utilisateur savedPersonEntity = savedAddressEntity.getUtilisateur();
        savedPersonEntity.setNom("RAKOTO Christian");
        savedAddressEntity.setRue("24");
        sessionHelper.merge(savedPersonEntity);
        sessionHelper.flush();
    }

    @Test
    public void testRemove() {
        Long userId;
        Utilisateur christian = buildUtilisateur("Christian");
        Adresse adresse = buildAdresse(christian);
        christian.setAdresses(Arrays.asList(adresse));
        sessionHelper.persist(christian);
        sessionHelper.flush();
        userId = christian.getIdUtilisateur();
        sessionHelper.clear();
        Utilisateur savedChristianEntity = sessionHelper.find(Utilisateur.class, userId);
        sessionHelper.remove(savedChristianEntity);
        sessionHelper.flush();
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
        sessionHelper.persist(christian);
        sessionHelper.flush();
        christian.setNom("RAKOTOARIVOLOLONA");
        adresse.setRue("777");
        sessionHelper.refresh(christian);
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
        sessionHelper.unwrap(Session.class).replicate(kingkong, ReplicationMode.OVERWRITE);
        sessionHelper.flush();
        Assertions.assertTrue(kingkong.getIdUtilisateur()==(2L));
        Assertions.assertTrue(adresse.getIdAdresse()==(2L));
    }

    @Test
    public void testSaveOrUpdate() {
        Utilisateur kingkong = buildUtilisateur("KingKong");
        Adresse adresse = buildAdresse(kingkong);
        kingkong.setAdresses(Arrays.asList(adresse));
        //sessionHelper.saveOrUpdate(kingkong);
        sessionHelper.flush();
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