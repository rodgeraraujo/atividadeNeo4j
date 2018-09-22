package com.rodger.aulaNeo4j.model;

import java.time.LocalDate;

public class Friend {
    private int friend_id;
    private int friend2_id;
    private LocalDate since;

    public Friend() {

    }

    public Friend(int friend_id, int friend2_id, LocalDate since) {
        this.friend_id = friend_id;
        this.friend2_id = friend2_id;
        this.since = since;
    }

    public int getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }

    public int getFriend2_id() {
        return friend2_id;
    }

    public void setFriend2_id(int friend2_id) {
        this.friend2_id = friend2_id;
    }

    public LocalDate getSince() {
        return since;
    }

    public void setSince(LocalDate since) {
        this.since = since;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "friend_id=" + friend_id +
                ", friend2_id=" + friend2_id +
                ", since=" + since +
                '}';
    }
}
