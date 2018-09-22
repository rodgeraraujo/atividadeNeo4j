package com.rodger.aulaNeo4j.model;

import java.time.LocalDate;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private LocalDate bithday;
    private LocalDate join_date;

    public User() {
    }

    public User(int id, String name, String email, String password, LocalDate bithday, LocalDate join_date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.bithday = bithday;
        this.join_date = join_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBithday() {
        return bithday;
    }

    public void setBithday(LocalDate bithday) {
        this.bithday = bithday;
    }

    public LocalDate getJoin_date() {
        return join_date;
    }

    public void setJoin_date(LocalDate join_date) {
        this.join_date = join_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bithday_date=" + bithday +
                ", join_date=" + join_date +
                '}';
    }
}
