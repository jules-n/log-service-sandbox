package com.example.logservicesandbox.controllers;

import com.example.logservicesandbox.domain.Log;
import com.example.logservicesandbox.domain.LogDTO;
import com.example.logservicesandbox.repository.LogRepository;
import com.example.logservicesandbox.services.LogServiceConsumer;
import org.apache.logging.log4j.spi.LoggerRegistry;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    LogRepository logRepository;

    @GetMapping
    private List<Log> getAll(@RequestParam ObjectId _id){
        logRepository.save(Log.builder().message("kafka, for what?").time(LocalDateTime.now()).user(_id).build());
        return logRepository.findByUser(_id);
    }

}
