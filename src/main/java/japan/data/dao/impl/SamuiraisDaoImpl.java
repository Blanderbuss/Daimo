package japan.data.dao.impl;

import japan.data.DbSamurai;
import japan.data.dao.SamuraisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
                        student.setWeapon(rs.getInt(3));
                        return student;
                    }
                },id);

    }

    @Override
    public void addSamurai(DbSamurai samurai) {
        jdbcTemplate.update(SQL_INSERT_SAMURAI, samurai.getName(), samurai.getWeapon());
    }
}
