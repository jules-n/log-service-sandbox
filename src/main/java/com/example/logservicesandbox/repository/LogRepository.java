package com.example.logservicesandbox.repository;

import com.example.logservicesandbox.domain.Log;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogRepository extends MongoRepository<Log, ObjectId> {
    List<Log> findByUser(ObjectId user);
}
