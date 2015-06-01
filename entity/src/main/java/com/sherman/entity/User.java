package com.sherman.entity;

import com.google.common.collect.Lists;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column
    private String name;

    @OneToMany(mappedBy = "user")
    private List<WordRecord> wordRecords = Lists.newArrayList();


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WordRecord> getWordRecords() {
        return wordRecords;
    }

    public void addWordRecord(WordRecord wordRecord) {
        if (wordRecords == null) {
            wordRecords = Lists.newArrayList();
        }
        wordRecords.add(wordRecord);

    }
}