package ua.nure.makieiev.labs.service;

import ua.nure.makieiev.labs.entity.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> findAll();

    Optional<Event> findById(long id);

    Event create(Event event);

}
