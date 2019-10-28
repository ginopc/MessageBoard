package it.ginopc.hello.services;

import org.springframework.data.repository.CrudRepository;

import it.ginopc.hello.models.About;

public interface AboutService extends CrudRepository<About, Long> {

}
