package com.QuickPoll.QuickPollHw.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POLL_ID",nullable = false)
    private Long id;

    @Column(name="QUESTION",nullable = false)
    @NotEmpty(message = "Question is a required feild")
    private String question;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="POLL_ID",nullable = false)
    @OrderBy
    @Size(min=2,max= 6)
    private Set<Options> options;

    public Poll() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<Options> getOptions() {
        return options;
    }

    public void setOptions(Set<Options> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", options=" + options +
                '}';
    }
}
