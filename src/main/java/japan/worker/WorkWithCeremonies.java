package japan.worker;

import japan.data.entities.Ceremony;
import japan.data.dao.CeremoniesDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WorkWithCeremonies {

    @Autowired
    CeremoniesDao ceremoniesDao;

    public Ceremony addCeremony(Ceremony ceremony){
        ceremony = ceremoniesDao.addCeremony(ceremony);
        System.out.println(ceremony);
        return ceremony;
    }

    public List<Ceremony> getAllCeremonies(){
        return ceremoniesDao.getAllCeremonies();
    }
}
