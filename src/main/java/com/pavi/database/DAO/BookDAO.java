package com.pavi.database.DAO;

import com.pavi.database.domain.Book;

import java.util.Optional;

public interface BookDAO {
    void create(Book book);

    Optional<Book> findOneBook(long l);
}
