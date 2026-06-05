package org.example.user.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.config.MongoConfig;
import org.example.user.entity.User;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserMongoRepository {
    private final MongoCollection<Document> collection;

    public UserMongoRepository() {
        MongoDatabase db = MongoConfig.getDatabase();
        this.collection = db.getCollection("user");
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        com.mongodb.client.FindIterable<Document> result = collection.find();

        for (Document doc : result) {
            User user = new User();
            user.setId(doc.getInteger("id", 0));
            user.setUserId(doc.getString("user_id"));
            user.setName(doc.getString("name"));
            user.setPassword(doc.getString("password"));
            Date createdAt = doc.getDate("created_at");
            user.setCreatedAt(createdAt.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            users.add(user);
        }

        return users;
    }




}
