package com.QuickPoll.QuickPollHw.repository;

import com.QuickPoll.QuickPollHw.domain.Options;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OptionRepository extends CrudRepository<Options, Long> {


}
