package com.example.logservicesandbox.util.convertors;

import com.example.logservicesandbox.domain.Log;
import com.example.logservicesandbox.domain.LogDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LogKafkaMessageConverterJSONImpl implements KafkaMessageConverter<Log,LogDTO>{

    @Autowired
    private ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    public <Log> Log deserialize(String msg, Class<Log> dtoType) {
        return objectMapper.readValue(msg, dtoType);
    }

    @SneakyThrows
    @Override
    public String serialize(LogDTO object) {
        return objectMapper.writeValueAsString(object);
    }
}
