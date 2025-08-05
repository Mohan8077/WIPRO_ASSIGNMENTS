package springJDBC.spring6.dao;

import java.util.List;

public interface PersonDAO {
	void insert(Person person);         
    Person get(int id);                 
    List<Person> list();                
    void update(Person person);         
    void delete(int id);  
}
