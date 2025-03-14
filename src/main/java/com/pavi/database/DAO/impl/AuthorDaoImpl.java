package com.pavi.database.DAO.impl;

import com.pavi.database.DAO.AuthorDAO;
import com.pavi.database.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class AuthorDaoImpl implements AuthorDAO {

    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create
    @Override
    public void create(Author author) {
        jdbcTemplate.update(
                "INSERT INTO author (id,name,age) VALUES (?,?,?)",
                author.getId(),author.getName(),author.getAge());
    }

    // Read 1
    @Override
    public Optional<Author> findOneAuthor(long authorId) {

        List<Author> results = jdbcTemplate.query(
                "SELECT id, name, age FROM author WHERE id = ? LIMIT 1",
                new AuthorRowMapper(), authorId);
        return results.stream().findFirst();
    }


    // Read All
    @Override
    public List<Author> findManyAuthor() {
        return jdbcTemplate.query(
                "SELECT id, name, age FROM author",
                new AuthorRowMapper());
    }

    public static class AuthorRowMapper implements RowMapper<Author>{

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }

}
