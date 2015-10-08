package control;

import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.InfoEntity;
import entity.Person;
import entity.Phone;
import exceptions.NotFoundException;
import facade.Facade;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ControlCRUD {

    private EntityManagerFactory emf;

    public ControlCRUD(EntityManagerFactory e) {
        
        emf = e;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//__________________________________________________________________________________
//    Person Methods
    public Person getPersonByPhonenum(String phoneNum) throws NotFoundException {
        EntityManager EM = getEntityManager();
        Query q = EM.createNamedQuery("Phone.findByPhonenum").setParameter("phonenum", phoneNum);
        Phone p = EM.find(Phone.class, phoneNum);
        return EM.find(Person.class, p.getId());

    }
    
    public List<Person> getAllPersons() throws NotFoundException {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("Person.findAll");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public Person getPerson(int id) throws NotFoundException {
        EntityManager em = getEntityManager();
        try {
            return em.find(Person.class, id);
        } finally {
            em.close();
        }
    }
    
    public Person createPerson(Person p) {
//        System.out.println(p);
        EntityManager EM = getEntityManager();
        
        try {
            EM.getTransaction().begin();
            EM.persist(p);
            EM.getTransaction().commit();
            return p;
        } finally {
            EM.close();
        }
    }
    
     public Person deletePerson(int id) throws NotFoundException {
        EntityManager em = getEntityManager();
        try {
            Person p = em.find(Person.class, id);
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    public Person editPerson(Person p) {
        EntityManager em = getEntityManager();
        try {
            Person edited = em.find(Person.class, p.getId());
            edited.setFirstname(p.getFirstname());
            edited.setLastname(p.getLastname());
            em.getTransaction().begin();
            em.merge(edited);
            em.getTransaction().commit();
            return edited;
        } finally {
            em.close();
        }
    }
//___________________________________________________________________________________________________
//    CityInfo Methods
     public static List<CityInfo> getZipcodes() throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//___________________________________________________________________________________________________
//    Company Methods
     public List<Company> getAllCompanys() throws NotFoundException {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("Company.findAll");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public static Company getCompanyByPhone(String phoneNumber) throws NotFoundException {
        Company c = new Company();
        return c;
    }
    
    public Company editCompany(Company c) {
        EntityManager em = getEntityManager();
        try {
            Company edited = em.find(Company.class, c.getId());
            edited.setCompanyName(c.getCompanyName());
            edited.setEmail(c.getEmail());
            edited.setCvr(c.getCvr());
            edited.setDescription(c.getDescription());
            edited.setMarketValue(c.getMarketValue());
            edited.setNumEmployees(c.getNumEmployees());
            em.getTransaction().begin();
            em.merge(edited);
            em.getTransaction().commit();
            return edited;
        } finally {
            em.close();
        }
    }
    
    public Company createCompany(Company p) {
//        System.out.println(p);
        EntityManager EM = getEntityManager();
        
        try {
            EM.getTransaction().begin();
            EM.persist(p);
            EM.getTransaction().commit();
            return p;
        } finally {
            EM.close();
        }
    }
    
    public Company deleteCompany(int id) throws NotFoundException {
        EntityManager em = getEntityManager();
        try {
            Company c = em.find(Company.class, id);
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            return c;
        } finally {
            em.close();
        }
    }
    
    public Company getCompany(int cvr) throws NotFoundException {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("Company.findByCvr");
            query.setParameter("cvr", cvr);
            return (Company) query.getResultList().get(0);
        } finally {
            em.close();
        }
    }
//________________________________________________________________________________
//    Hobby Methods
    public static void createHobby() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
