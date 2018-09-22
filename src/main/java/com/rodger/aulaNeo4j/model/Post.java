package com.rodger.aulaNeo4j.model;

import java.time.LocalDate;

public class Post {
    private String user_name;
    private int post_id;
    private int user_id;
    private String post_content;
    private LocalDate post_date;

    public Post() {

    }

    public Post(String user_name, int post_id, int user_id, String post_content, LocalDate post_date) {
        this.user_name = user_name;
        this.post_id = post_id;
        this.user_id = user_id;
        this.post_content = post_content;
        this.post_date = post_date;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public LocalDate getPost_date() {
        return post_date;
    }

    public void setPost_date(LocalDate post_date) {
        this.post_date = post_date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "user_name='" + user_name + '\'' +
                ", post_id=" + post_id +
                ", user_id=" + user_id +
                ", post_content='" + post_content + '\'' +
                ", post_date=" + post_date +
                '}';
    }
}
