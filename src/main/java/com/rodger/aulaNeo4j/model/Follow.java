package com.rodger.aulaNeo4j.model;

import java.time.LocalDate;

public class Follow {
    private int follower;
    private int followed;
    private LocalDate since;

    public Follow(int follower, int followed, LocalDate since) {
        this.follower = follower;
        this.followed = followed;
        this.since = since;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getFollowed() {
        return followed;
    }

    public void setFollowed(int followed) {
        this.followed = followed;
    }

    public LocalDate getSince() {
        return since;
    }

    public void setSince(LocalDate since) {
        this.since = since;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "follower=" + follower +
                ", followed=" + followed +
                ", since=" + since +
                '}';
    }
}

