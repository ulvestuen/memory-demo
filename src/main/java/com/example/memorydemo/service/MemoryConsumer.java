package com.example.memorydemo.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class MemoryConsumer {

    private final List<Integer> consumedMemory = new ArrayList<>();

    public Integer accumulateMemory(final int nIntegers) {
        consumedMemory.addAll(
                IntStream.range(0, nIntegers)
                         .boxed()
                         .collect(Collectors.toList())
        );
        return consumedMemory.size();
    }

    public Integer consumeTemporarily(final int nIntegers) {
        List<Integer> integerList = IntStream.range(0, nIntegers)
                                             .boxed()
                                             .collect(Collectors.toList());
        return integerList.size();
    }
}
