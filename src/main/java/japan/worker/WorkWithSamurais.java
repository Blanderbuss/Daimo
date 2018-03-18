package japan.worker;

import japan.data.entities.DbSamurai;
import japan.data.dao.SamuraisDao;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkWithSamurais {
    @Autowired
    SamuraisDao samuraisDao;

    public void saveSamuraiToDb(DbSamurai samurai){
        if ((samurai!=null)&&(samurai.getName()!=null)&&(!"".equals(samurai.getName()))){
            samuraisDao.addSamurai(samurai);
            System.out.println("Samurai have been saved "+samurai);
        }
    }

}
