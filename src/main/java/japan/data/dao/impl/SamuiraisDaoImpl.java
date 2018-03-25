package japan.data.dao.impl;

import japan.data.entities.DbSamurai;
import japan.data.dao.SamuraisDao;
import japan.data.entities.DbWeapon;
import japan.data.trans.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SamuiraisDaoImpl implements SamuraisDao {

    private static final String SQL_INSERT_SAMURAI = "insert into samurai (name,weapon) values (?,?)";
    private static final String SQL_SELECT_SAMURAI_BY_ID = "select id, name, weapon from samurai where id = ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public DbSamurai getSamuraiById(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_SAMURAI_BY_ID,
                new RowMapper<DbSamurai>() {
                    public DbSamurai mapRow(ResultSet rs, int rowNum) throws SQLException {
                        DbSamurai student = new DbSamurai();
                        student.setSamuraiId(rs.getInt(1));
                        student.setName(rs.getString(2));
                        student.setWeapon(rs.getObject(3, DbWeapon.class));
                        return student;
                    }
                },id);

    }

    @Override
    public void addSamurai(DbSamurai samurai) {
            final javax.persistence.EntityManagerFactory entityManagerFactory = EntityManagerFactory.getEntityManagerFactory();
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            try{
                entityManager.getTransaction().begin();
                DbSamurai createdEntity = entityManager.merge(samurai);
                entityManager.getTransaction().commit();
            } catch (Exception ex){
                entityManager.getTransaction().rollback();
            }finally {
                entityManager.close();
            }

    }
}
