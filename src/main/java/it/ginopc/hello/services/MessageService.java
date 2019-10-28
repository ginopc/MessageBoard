package it.ginopc.hello.services;

import org.springframework.data.repository.CrudRepository;

import it.ginopc.hello.models.Message;

public interface MessageService extends CrudRepository<Message, Long> {

}
