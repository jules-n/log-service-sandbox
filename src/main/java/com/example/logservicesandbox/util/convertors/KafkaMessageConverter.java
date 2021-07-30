package com.example.logservicesandbox.util.convertors;


public interface KafkaMessageConverter<T, U> {
    <T> T deserialize(String message, Class<T> dtoClass);
    String serialize(U object);
}