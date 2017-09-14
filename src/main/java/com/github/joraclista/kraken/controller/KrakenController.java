package com.github.joraclista.kraken.controller;

import com.github.joraclista.kraken.model.response.AbstractKrakenResponse.MultipleResizeResponseImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alisa
 * version 1.0.
 */
@RestController
@RequestMapping(value = "/kraken")
@Slf4j
public class KrakenController {

    @RequestMapping(value = "/callback/single", method = RequestMethod.POST)
    public void singleOptimizationResults(@RequestBody MultiValueMap<String, Object> krakenResponse) {
        log.info("results:   id = {}; success = {}; message= {}; file_name = {}; kraked_url = {}; timestamp= {}; saved_bytes = {}",
                krakenResponse.get("id"),
                krakenResponse.get("success"),
                krakenResponse.get("message"),
                krakenResponse.get("file_name"),
                krakenResponse.get("kraked_url"),
                krakenResponse.get("timestamp"),
                krakenResponse.get("saved_bytes"));
    }

    @RequestMapping(value = "/callback/multi", method = RequestMethod.POST)
    public void multiSetResults(@RequestBody MultipleResizeResponseImpl krakenResponse) {
        log.info("results:   id = {}; success = {}; message = {}; results = {}",
                krakenResponse.getId(),
                krakenResponse.isSuccess(),
                krakenResponse.getMessage(),
                krakenResponse.getResults());
    }
}