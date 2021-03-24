package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    private final TimeEntryRepository timeEntryRepository;

    @Autowired
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
//        TimeEntry timeEntry = timeEntryRepository.create(timeEntryToCreate);
//        return new ResponseEntity<>(timeEntry, HttpStatus.CREATED);

        // Other way of doing
//        return ResponseEntity.created(null).body(timeEntryRepository.create(timeEntryToCreate));

        // Other way of doing
        return ResponseEntity.status(HttpStatus.CREATED).body(timeEntryRepository.create(timeEntryToCreate));
    }

    @GetMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);
//        if (timeEntry == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(timeEntry, HttpStatus.OK);

        // Other way of doing
        return timeEntry==null ? ResponseEntity.notFound().build() : ResponseEntity.ok(timeEntry);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
//        List<TimeEntry> timeEntryList = timeEntryRepository.list();
//        return new ResponseEntity<>(timeEntryList, HttpStatus.OK);

        // Other way of doing
        return ResponseEntity.status(HttpStatus.OK).body(timeEntryRepository.list());
    }

    @PutMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry> update(@PathVariable long timeEntryId, @RequestBody TimeEntry timeEntryToUpdate) {
        TimeEntry timeEntry = timeEntryRepository.update(timeEntryId, timeEntryToUpdate);
//        if (timeEntry == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(timeEntry, HttpStatus.OK);

        // Other way of doing
        return timeEntry==null ? ResponseEntity.notFound().build() : ResponseEntity.ok(timeEntry);
    }

    @DeleteMapping("{timeEntryId}")
    public ResponseEntity<Void> delete(@PathVariable long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        // Other way of doing
        return ResponseEntity.noContent().build();
    }
}
