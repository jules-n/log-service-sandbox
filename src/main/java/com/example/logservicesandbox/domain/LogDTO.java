package com.example.logservicesandbox.domain;

import lombok.*;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogDTO {

    private ObjectId user;
    private String message;

}
