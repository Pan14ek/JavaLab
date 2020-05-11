package ua.nure.makieiev.labs.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.makieiev.labs.dto.EventDto;
import ua.nure.makieiev.labs.entity.Event;
import ua.nure.makieiev.labs.exception.NotFoundEventException;
import ua.nure.makieiev.labs.service.EventService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class EventController {

    private final ModelMapper modelMapper;
    private final EventService eventService;

    @Autowired
    public EventController(ModelMapper modelMapper, EventService eventService) {
        this.modelMapper = modelMapper;
        this.eventService = eventService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable long id) {
        Optional<Event> eventOptional = eventService.findById(id);
        if (eventOptional.isPresent()) {
            return new ResponseEntity<>(eventOptional.get(), HttpStatus.OK);
        }
        throw new NotFoundEventException("Event did not find by id");
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEvent(@RequestBody @Valid EventDto eventDto, BindingResult bindingResult) {
        Event event = modelMapper.map(eventDto, Event.class);
        event = eventService.create(event);
        if (event.getId() != 0) {
            return new ResponseEntity<>(event, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(bindingResult, HttpStatus.BAD_REQUEST);
    }

}
