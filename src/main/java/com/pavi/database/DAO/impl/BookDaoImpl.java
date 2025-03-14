package com.pavi.database.DAO.impl;

import com.pavi.database.DAO.BookDAO;
import com.pavi.database.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class BookDaoImpl implements BookDAO {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create
    @Override
    public void create(Book book){
        jdbcTemplate.update(
                "INSERT INTO books (id,title,authorId) VALUES (?,?,?)",
                book.getId(),book.getTitle(),book.getAuthorId());
    }

    // Find 1
    @Override
    public Optional<Book> findOneBook(long id) {

        List<Book> results = jdbcTemplate.query(
                "SELECT id, title, authorId FROM books WHERE id = ? LIMIT 1",
                new BookDaoImpl.BookRowMapper(), id);
        return results.stream().findFirst();

    }


    public static class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .id(rs.getLong("id"))
                    .title(rs.getString("name"))
                    .authorId(rs.getLong("authorId"))
                    .build();
        }
    }

}
