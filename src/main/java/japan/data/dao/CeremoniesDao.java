package japan.data.dao;

import japan.data.entities.Ceremony;

import java.util.List;

public interface CeremoniesDao {

    Ceremony addCeremony(Ceremony ceremony);

    Ceremony getCeremony(int id);

    void saveCeremony(Ceremony ceremony);

    List<Ceremony> getAllCeremonies();
}
