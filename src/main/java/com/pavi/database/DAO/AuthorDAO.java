package com.pavi.database.DAO;

import com.pavi.database.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDAO {
    void create(Author author);

    Optional<Author> findOneAuthor(long l);

    List<Author> findManyAuthor();

    void update(long l, Author author);
}
