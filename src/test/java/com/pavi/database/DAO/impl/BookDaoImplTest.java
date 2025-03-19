package com.pavi.database.DAO.impl;

import com.pavi.database.TestDataUtil;
import com.pavi.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;


    @InjectMocks
    BookDaoImpl underTest;

    @Test
    public void testThatCreatesBookGeneratesCorrectSql(){
        Book book = TestDataUtil.CreateTestBook();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (id,title,authorId) VALUES (?,?,?)"),
                eq(1L), eq("No way out"), eq(1L));
    }

    @Test
    public void testThatFindOneBookGeneratesTheCorrectSql(){
        underTest.findOneBook(1L);

        verify(jdbcTemplate).query(
                eq("SELECT id, title, authorId FROM books WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq(1L)
        );

    }

    @Test
    public void testThatFindManyBookGeneratesCorrectSql(){
        underTest.findManyBook();
        verify(jdbcTemplate).query(
                eq("SELECT id, title, authorId FROM books"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any()
        );
    }
}
