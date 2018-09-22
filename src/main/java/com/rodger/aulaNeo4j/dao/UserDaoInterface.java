package com.rodger.aulaNeo4j.dao;

import com.rodger.aulaNeo4j.model.Follow;
import com.rodger.aulaNeo4j.model.Friend;
import com.rodger.aulaNeo4j.model.Post;
import com.rodger.aulaNeo4j.model.User;

public interface UserDaoInterface {
    boolean saveUser(User user);
    boolean friendship(Friend friendship);
    boolean unfriend(Friend friendship);
    boolean savePost(Post post);
    boolean follow(Follow following);
    boolean unfollow(Follow following);
    void findFriendsOfFriend(String email);
    void close() throws Exception;

}
