package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.Domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRespitory extends CrudRepository<Publisher,Long> {

}
