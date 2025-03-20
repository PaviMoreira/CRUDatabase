package com.pavi.database.DAO.impl;


import com.pavi.database.TestDataUtil;
import com.pavi.database.domain.Author;
import com.pavi.database.domain.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTest {

    private final BookDaoImpl underTest;

    @Autowired
    public BookDaoImplIntegrationTest(BookDaoImpl underTest){
        this.underTest = underTest;
    }

    /*
    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Book book = TestDataUtil.CreateTestBook();
        underTest.create(book);
        Optional<Book> result = underTest.findOneBook(book.getId());
        assertThat(result).isPresent();
        assertThat(book).isEqualTo(book);
    }


    @Test
    public void testThatManyAuthorCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.CreateTestAuthor();

        Book book1 = TestDataUtil.CreateTestBook();
        underTest.create(book1);
        Book book2 = TestDataUtil.CreateTestBook2();
        book1.setAuthorId(author.getId());
        underTest.create(book2);

        List<Book> result = underTest.findManyBook();

        Assertions.assertThat(result)
                .isNotNull()
                .hasSize(2);
    }



    @Test
    public void testThatUpdatesBook(){
        Book book = TestDataUtil.CreateTestBook();
        underTest.create(book);
        Book book2 = TestDataUtil.CreateTestBook2();

        underTest.update(book.getId(),book2);

        Optional<Book> result = underTest.findOneBook(book.getId());

        Assertions.assertThat(result).isPresent().isNotNull();
        Assertions.assertThat(result.get().getTitle()).isEqualTo(book2.getTitle());
    }

    */

    @Test
    public void testThatDeletesBook(){
        Book book = TestDataUtil.CreateTestBook();
        underTest.create(book);

        underTest.delete(book.getId());

        Optional<Book> result = underTest.findOneBook(book.getId());

        Assertions.assertThat(result).isEmpty();
    }

}
