package control;

import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.InfoEntity;
import entity.Person;
import entity.Phone;
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

    public Person getPerson(String phoneNum) {
        EntityManager EM = getEntityManager();
        Query q = EM.createNamedQuery("Phone.findByPhonenum").setParameter("phonenum", phoneNum);
        Phone p = EM.find(Phone.class, phoneNum);
        return EM.find(Person.class, p.getId());

    }

//    public static List<Person> getPersonsByHobby(Hobby hobby) {
//        Query q = EM.createNamedQuery("Hobby.findByHobbyname").setParameter("hobbyname", hobby.getHobbyname());
//        List<Hobby> lh = q.getResultList();
//        List<Person> l = new ArrayList();
////        System.out.println(lh.iterator().next());
//        for (Hobby h : lh) {
//            l.add(h.getIdH());
//        }
//        return l;
//    }

//    public static List<Person> getPersonsByCity(String zip) {
////        Query q = EM.createNamedQuery("CityInfo.findByZipcode").setParameter("zipcode", zip);
////        CityInfo ci = (CityInfo) q.getSingleResult();
////        List<Address> la = (List<Address>) ci.getAddressCollection();
////        List<InfoEntity> lie = new ArrayList();
////        for (Address a : la) {
////            lie.add(a.getIdA());
////        }
////        List<Person> lp = (List<Person>) lie.get(0).getPersonCollection();
////        return lp;
//        Query query = EM.createNamedQuery("Person.findByCity");
//        query.setParameter("zip", zip);
//        return query.getResultList();
//
//    }

    public static Company getCompanyByPhone(String phoneNumber) {
//        Query q = EM.createNamedQuery("Phone.findByPhonenum").setParameter("phonenum", phoneNumber);
//        Phone p = (Phone) q.getSingleResult();
//        InfoEntity ie = p.getIdP();
//        List<Company> cc = (List<Company>) ie.getCompanyCollection();
        Company c = new Company();
        return c;
    }

//    public static Company getCompanyByCVR(int cvr) {
//        Query q = EM.createNamedQuery("Company.findByCvr");
//        q.setParameter("cvr", cvr);
//        return (Company) q.getSingleResult();
//    }

//    public static List<Company> getCompaniesByStaffCount(int staffMembers) {
//        Query q = EM.createNamedQuery("Company.findByNumemployees");
//        q.setParameter("numemployees", staffMembers);
//        return q.getResultList();
//    }

//    public static int getHobbyCount(String hobby) {
//        Query q = EM.createNamedQuery("Person.findByHobbyCount");
//        q.setParameter("hobbyname", hobby);
//        return (Integer) q.getSingleResult();
//
//    }

    public static List<CityInfo> getZipcodes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Person createPerson(Person p) {
        System.out.println(p);
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

    public static void createHobby() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void createCompany() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void deletePerson(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void editPerson(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
