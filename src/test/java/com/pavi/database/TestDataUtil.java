package com.pavi.database;

import com.pavi.database.domain.Author;
import com.pavi.database.domain.Book;

public final class TestDataUtil {

    private TestDataUtil(){

    }

    public static Author CreateTestAuthor() {
        return Author.builder().
                id(9L).
                name("Abigail").
                age(80).
                build();
    }

    public static Author CreateTestAuthorA() {
        return Author.builder().
                id(10L).
                name("Peter").
                age(80).
                build();
    }

    public static Author CreateTestAuthorB() {
        return Author.builder().
                id(11L).
                name("Joel").
                age(50).
                build();
    }


    public static Book CreateTestBook() {
        return Book.builder().
                id(1L).
                title("No way out").
                authorId(1L).
                build();
    }

    public static Book CreateTestBook2() {
        return Book.builder().
                id(2L).
                title("I'm a potato").
                authorId(2L).
                build();
    }
}
