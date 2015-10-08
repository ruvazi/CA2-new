package facade;

import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import java.util.List;

public interface Facade {

    Person getPerson(String phoneNumber);

    List<Person> getPersonsByHobby(Hobby hobby);

    List<Person> getPersonsByCity(String zip);

    Company getCompanyByPhone(String phoneNumber);

    Company getCompanyByCVR(int cvr);

    List<Company> getCompaniesByStaffCount(int staffMembers);

    int getHobbyCount(String hobby);

    List<CityInfo> getZipcodes();

    void createPerson();

    void createHobby();

    void createCompany();

    void deletePerson(long id);

    void editPerson(long id);
}
