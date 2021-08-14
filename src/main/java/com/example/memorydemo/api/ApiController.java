package com.example.memorydemo.api;

import com.example.memorydemo.service.MemoryConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

    private final MemoryConsumer memoryConsumer;

    @Autowired
    public ApiController(final MemoryConsumer memoryConsumer) {
        this.memoryConsumer = memoryConsumer;
    }

    @RequestMapping(
            path = { "/accumulate/{nIntegers}" },
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public ResponseEntity<String> accumulateMemory(@PathVariable final int nIntegers) {
        LOGGER.info("Request received for permanent memory accumulation of {} integers.", nIntegers);
        final Integer memoryLength = memoryConsumer.accumulateMemory(nIntegers);
        return ResponseEntity.ok("Accumulation endpoint called ok \n" + memoryLength + "\n");
    }

    @RequestMapping(
            path = { "/consume/{nIntegers}" },
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public ResponseEntity<String> consumeTemporarily(@PathVariable final int nIntegers) {
        LOGGER.info("Request received for temporary consumption of {} integers.", nIntegers);
        final Integer memoryLength = memoryConsumer.consumeTemporarily(nIntegers);
        return ResponseEntity.ok("Consume endpoint called ok \n" + memoryLength + "\n");
    }
}
