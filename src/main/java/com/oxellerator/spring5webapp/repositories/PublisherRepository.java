package com.oxellerator.spring5webapp.repositories;

import com.oxellerator.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author <a:href="mailto:ol.sakura@gmail.com">Olexiy Sokurenko</a>
 **/
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
