package com.pavi.database.DAO.impl;


import com.pavi.database.TestDataUtil;
import com.pavi.database.domain.Author;
import com.pavi.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTest {

    private BookDaoImpl underTest;

    @Autowired
    public BookDaoImplIntegrationTest(BookDaoImpl underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Book book = TestDataUtil.CreateTestBook();
        underTest.create(book);
        Optional<Book> result = underTest.findOneBook(book.getId());
        assertThat(result).isPresent();
        assertThat(book).isEqualTo(book);
    }

}
