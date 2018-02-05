package com.oxellerator.spring5webapp.repositories;

import com.oxellerator.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author <a:href="mailto:ol.sakura@gmail.com">Olexiy Sokurenko</a>
 **/
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
