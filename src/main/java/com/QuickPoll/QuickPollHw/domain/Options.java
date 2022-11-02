package com.QuickPoll.QuickPollHw.domain;

import javax.persistence.*;

@Entity
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="OPTION_ID",nullable = false)
    private Long id;

    @Column(name="OPTION_VALUE" ,nullable = false)
    private String value;

    public Options() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Options{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
