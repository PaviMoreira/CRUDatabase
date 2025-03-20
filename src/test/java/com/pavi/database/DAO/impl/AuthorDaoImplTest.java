package com.pavi.database.DAO.impl;

import com.pavi.database.TestDataUtil;
import com.pavi.database.domain.Author;
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
public class AuthorDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;


    @InjectMocks
    AuthorDaoImpl underTest;

    @Test
    public void testThatCreatesAuthorGeneratesCorrectSql(){
        Author author = TestDataUtil.CreateTestAuthor();

        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO author (id,name,age) VALUES (?,?,?)"),
                eq(9L), eq("Abigail"), eq(80));
    }

    @Test
    public void testThatFindOneAuthorGeneratesTheCorrectSql(){
        underTest.findOneAuthor(9L);

        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM author WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(9L)
        );

    }

    @Test
    public void testThatFindManyAuthorGeneratesCorrectSql(){
        underTest.findManyAuthor();
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM author"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any()
        );
    }

    @Test
    public void testThatUpdatesAuthorByIdGeneratesCorrectSql(){

        Author author = TestDataUtil.CreateTestAuthor();
        underTest.create(author);
        Author author1 = TestDataUtil.CreateTestAuthorA();

        underTest.update(author.getId(),author1);

        verify(jdbcTemplate).update(
                eq("UPDATE author SET name = ?, age = ? WHERE id = ?"),
                eq("Peter"), eq(80), eq(9L));
    }


}
