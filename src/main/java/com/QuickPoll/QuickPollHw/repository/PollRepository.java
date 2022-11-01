package com.QuickPoll.QuickPollHw.repository;

import com.QuickPoll.QuickPollHw.domain.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long> {

}
