package it.ginopc.hello.services;

import org.springframework.data.repository.CrudRepository;

import it.ginopc.hello.models.User;

public interface UserService extends CrudRepository<User, Long> {

}
