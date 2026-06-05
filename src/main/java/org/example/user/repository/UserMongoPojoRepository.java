package org.example.user.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.config.MongoConfig;
import org.example.user.entity.User;
import org.example.user.entity.UserPojo;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserMongoPojoRepository {
    private final MongoCollection<UserPojo> collection;

    public UserMongoPojoRepository() {
        MongoDatabase db = MongoConfig.getPojoDatabase();
        this.collection = db.getCollection("user", UserPojo.class);
    }

    public void findAllPojo() {
        for(UserPojo pojo : collection.find()) {
            System.out.println(pojo);
        }
    }
}
