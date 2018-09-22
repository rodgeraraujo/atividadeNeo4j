package com.rodger.aulaNeo4j.dao.impl;

import com.rodger.aulaNeo4j.dao.UserDaoInterface;
import com.rodger.aulaNeo4j.database.DriverFactory;
import com.rodger.aulaNeo4j.model.Follow;
import com.rodger.aulaNeo4j.model.Friend;
import com.rodger.aulaNeo4j.model.Post;
import com.rodger.aulaNeo4j.model.User;
import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.exceptions.ClientException;
import org.neo4j.driver.v1.exceptions.NoSuchRecordException;

import java.time.LocalDate;

import static org.neo4j.driver.v1.Values.parameters;
import static org.neo4j.driver.v1.Values.value;

public class UserDao implements UserDaoInterface {

    private Driver driver;
    private Session session;

    public UserDao() {
        driver = new DriverFactory().getDriver();
        session = driver.session();
    }

    @Override
    public boolean saveUser(User user) {
        int cont = 0;
        try (Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run(
                    "CREATE (:User{id:$id, name:$name, email:$email, password:$password, birthday:$birthday, join_date:$join_date})",
                    parameters("id", user.getId(),
                                              "name", user.getName(),
                                              "email", user.getEmail(),
                                              "password", user.getPassword(),
                                              "birthday", user.getBithday(),
                                              "join_date", user.getJoin_date()));

            tx.success();

            cont = result.summary().counters().nodesCreated();
        }catch (ClientException ex){
            return false;
        }
//        session.close();
//        driver.close();

        return cont > 0;
    }

    @Override
    public boolean friendship(Friend friendship) {
        int cont = 0;
        try (Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run(
                    "MATCH (x:User), (y:User) WHERE x.id = $id1 AND y.id = $id2 " +
                            "CREATE (x)-[f:FRIEND{since:$since}]->(y) " +
                            "RETURN x,f,y",
                    parameters("id1", friendship.getFriend_id(),
                                              "id2", friendship.getFriend2_id(),
                                              "since", friendship.getSince()));

            tx.success();

            cont = result.summary().counters().nodesCreated();
        }catch (ClientException ex){
            return false;
        }
        return cont > 0;
    }

    @Override
    public boolean unfriend(Friend friendship) {
        int cont = 0;
        try (Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run(
                    "MATCH (:User{id:$id1})-[r:FRIEND]->(:User{id:$id2}) DELETE r",
                    parameters("id1", friendship.getFriend_id(),
                            "id2", friendship.getFriend2_id()));

            tx.success();

            cont = result.summary().counters().nodesCreated();
        }catch (ClientException ex){
            return false;
        }
        return cont > 0;
    }

    @Override
    public boolean savePost(Post post) {
        int cont = 0;
        try (Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run("MATCH (u:User{name:$name}) " +
                                               "CREATE (u)-[:POSTED]->(:Post{id:$post_id, user_id:$user_id, " +
                                               "post_content:$post_content, post_date:$post_date})",
                    parameters("name", post.getUser_name(),
                                              "post_id", post.getPost_id(),
                                              "user_id", post.getUser_id(),
                                              "post_content", post.getPost_content(),
                                              "post_date", post.getPost_date()));

            tx.success();

            cont = result.summary().counters().nodesCreated();
        }catch (ClientException ex){
            return false;
        }
        return cont > 0;
    }

    @Override
    public boolean follow(Follow following) {
        int cont = 0;
        try (Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run(
                    "MATCH (x:User), (y:User) WHERE x.id = $follower AND y.id = $followed " +
                            "CREATE (x)-[f:FOLLOW{since:$since}]->(y) " +
                            "RETURN x,f,y",
                    parameters("follower", following.getFollower(),
                            "followed", following.getFollowed(),
                            "since", following.getSince()));

            tx.success();

            cont = result.summary().counters().nodesCreated();
        }catch (ClientException ex){
            return false;
        }
        return cont > 0;
    }

    @Override
    public boolean unfollow(Follow following) {
        int cont = 0;
        try (Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run(
                    "MATCH (:User{id:$id1})-[r:FOLLOW]->(:User{id:$id2}) DELETE r",
                    parameters("id1", following.getFollower(),
                            "id2", following.getFollowed()));

            tx.success();

            cont = result.summary().counters().nodesCreated();
        }catch (ClientException ex){
            return false;
        }
        return cont > 0;
    }


    @Override
    public void findFriendsOfFriend(String email) {
        try (Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run(
                     "MATCH (u:User)-[:FRIEND]->(:User)-[:FRIEND]->(friends:User) " +
                        "WHERE u.email = $email " +
                        "RETURN friends.email ",
                    parameters("email", email));

            if (result.hasNext()) {
                System.out.println("\nFRIENDS OF FRIENDS (EMAIL):");
                do System.out.println(result.next().values().toString());
                while(true);
            } else {
                System.out.println("No friends of friend!\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        session.close();
        driver.close();
    }
}
