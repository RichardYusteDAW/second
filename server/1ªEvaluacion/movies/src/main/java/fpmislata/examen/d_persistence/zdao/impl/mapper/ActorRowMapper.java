package fpmislata.examen.d_persistence.zdao.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fpmislata.examen.c_domain._2service.model.Actor;

public class ActorRowMapper implements RowMapper<Actor> {

    @Override
    @SuppressWarnings("null")
    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Actor actor = new Actor();

        actor.setId(rs.getInt("id"));
        actor.setName(rs.getString("name"));

        return actor;
    }
}