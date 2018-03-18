package japan.data.dao;

import japan.data.entities.DbSamurai;

public interface SamuraisDao {
    DbSamurai getSamuraiById(int id);
    void addSamurai(DbSamurai samurai);
}
