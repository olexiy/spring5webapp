package com.oxellerator.spring5webapp.model.repositories;

import com.oxellerator.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author <a:href="mailto:ol.sakura@gmail.com">Olexiy Sokurenko</a>
 **/
public interface BookRepository extends CrudRepository<Book, Long> {
}
