package com.pavi.database.DAO.impl;


import com.pavi.database.TestDataUtil;
import com.pavi.database.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorDaoImplIntegrationTest {

    private final AuthorDaoImpl underTest;

    @Autowired
    public AuthorDaoImplIntegrationTest(AuthorDaoImpl underTest){
        this.underTest = underTest;
    }

    /*
    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.CreateTestAuthor();
        underTest.create(author);
        Optional<Author> result = underTest.findOneAuthor(author.getId());
        assertThat(result).isPresent();
        assertThat(author).isEqualTo(author);
    }


    @Test
    public void testThatManyAuthorCanBeCreatedAndRecalled(){
        Author authorA = TestDataUtil.CreateTestAuthorA();
        underTest.create(authorA);
        Author authorB = TestDataUtil.CreateTestAuthorB();
        underTest.create(authorB);

        List<Author> result = underTest.findManyAuthor();

        assertThat(result)
                .isNotNull()
                .hasSize(4);
    }


    @Test
    public void testThatUpdatesAuthor(){
        Author authorA = TestDataUtil.CreateTestAuthorA();
        underTest.create(authorA);
        Author authorB = TestDataUtil.CreateTestAuthorB();

        underTest.update(authorA.getId(),authorB);

        Optional<Author> result = underTest.findOneAuthor(authorA.getId());

        assertThat(result).isPresent().isNotNull();
        assertThat(result.get().getName()).isEqualTo(authorB.getName());
    }

     */

    @Test
    public void testThatDeletesAuthor(){
        Author author = TestDataUtil.CreateTestAuthor();
        underTest.create(author);

        underTest.delete(author.getId());

        Optional<Author> result = underTest.findOneAuthor(author.getId());

        assertThat(result).isEmpty();
    }

}
