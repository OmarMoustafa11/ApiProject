package com.QuickPoll.QuickPollHw.controller;

import com.QuickPoll.QuickPollHw.domain.Poll;
import com.QuickPoll.QuickPollHw.exception.ResourceNotFoundException;
import com.QuickPoll.QuickPollHw.repository.PollRepository;
import com.QuickPoll.QuickPollHw.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
public class PollController {

    @Autowired
    PollService pollService;

    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
       return pollService.getAllPolls();
}

    @Autowired
    private PollRepository pollRepository;

    @PostMapping("/polls")
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
        poll = pollRepository.save(poll);
// Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(poll.getId()).toUri();
        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

//    @PutMapping("/polls/{pollId}")
//    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
//        // Save the entity
//        Poll p = pollRepository.save(poll);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @DeleteMapping("/polls/{pollId}")
//    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
//        pollRepository.deleteById(pollId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @GetMapping("/polls/{pollId}")
//    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
//        if(pollRepository.findById(pollId) == null) {
//            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
//        }
//            return new ResponseEntity<>(pollRepository.findById(pollId), HttpStatus.OK);
//        }
    protected void verifyPoll(Long pollId) throws ResourceNotFoundException {
        Poll poll = pollRepository.findById(pollId).orElse(null);
        if( poll == null) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        } }
    @GetMapping("/polls/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        verifyPoll(pollId);
        pollRepository.findById(pollId);
        return new ResponseEntity<> (pollRepository.findById(pollId), HttpStatus.OK);
    }
    @PutMapping("/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        verifyPoll(pollId);
        pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        verifyPoll(pollId);
        pollRepository.deleteById(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }




        }
