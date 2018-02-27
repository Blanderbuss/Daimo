package japan.data.dao;

import japan.data.DbSamurai;

public interface SamuraisDao {
    DbSamurai getSamuraiById(int id);
    void addSamurai(DbSamurai samurai);
}
