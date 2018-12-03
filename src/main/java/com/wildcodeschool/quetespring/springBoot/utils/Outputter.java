package com.wildcodeschool.quetespring.springBoot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
	
import com.wildcodeschool.quetespring.springBoot.entities.School;
import com.wildcodeschool.quetespring.springBoot.repositories.SchoolDao;

@Component
public class Outputter implements CommandLineRunner{

    private Logger LOG = LoggerFactory.getLogger("School");

    @Autowired
    private SchoolDao schoolDao;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD        
        LOG.info("******************");
        LOG.info("Objects in DB : " + schoolDao.count());

        // Crée un nouvel utilisateur et l'enregistre dans la BDD
        School school1 = new School("Toulouse", 21, "Java");
        LOG.info("******************");
        LOG.info(school1 + " has been created !");
        schoolDao.save(school1);
        LOG.info(school1 + " has been saved !");

        // Crée un second utilisateur et l'enregistre dans la BDD
        School school2 = new School("Bordeaux", 2, "PHP");
        LOG.info("******************");
        LOG.info(school2 + " has been created !");
        schoolDao.save(school2);
        LOG.info(school2 + " has been saved !");

        // Lit les informations correspondant au second utilisateur
        School tempUser = schoolDao.findById(2L).get(); /* On écrit "2L" car 
                                                       le type de l'id est Long */
        LOG.info("******************");
        LOG.info("Second school's name is " + tempUser.getName());
        LOG.info("Second school's language is " + tempUser.getNumberStudents());
        LOG.info("Second school's numberStudents is " + tempUser.getLanguage());

        // Liste les utilisateurs enregistrés dans la BDD
        LOG.info("******************");
        LOG.info("Users in list are ");
        for(School mySchool : schoolDao.findAll()) {
            LOG.info(mySchool.toString());
        };

        // Supprime le second utilisateur de la BDD
        schoolDao.deleteById(2L); /* risque de provoquer une erreur si 
                                tu n'as pas vidé ta table avant de relancer 
                                ton application ! */

        /*     Liste les utilisateurs enregistrés dans la BDD
             (permet de vérifier que le second utilisateur
             a bien été supprimé de la BDD) */
        LOG.info("******************");
        LOG.info("Users in list are ");
        for(School mySchool : schoolDao.findAll()) {
            LOG.info(mySchool.toString());
        };
	    }    
	}

