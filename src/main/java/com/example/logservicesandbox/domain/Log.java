package com.example.logservicesandbox.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = Log.COLLECTION_NAME)
@ToString
@Builder
public class Log {
    public static final String COLLECTION_NAME = "logs";

    private ObjectId _id;
    private ObjectId user;
    private String message;
    private LocalDateTime time;
}
