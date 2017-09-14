package com.github.joraclista.kraken.controller;

import com.github.joraclista.kraken.KrakenDirectUploadApiImpl;
import com.github.joraclista.kraken.KrakenDirectUploader;
import com.github.joraclista.kraken.model.request.OptimizeRequestImpl;
import com.github.joraclista.kraken.model.request.ResizeItem;
import com.github.joraclista.kraken.model.request.ResizeRequestImpl;
import com.github.joraclista.kraken.model.request.ResizeStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Alisa
 * version 1.0.
 */
@RestController
@RequestMapping(value = "/kraken/file/upload")
@Slf4j
public class KrakenUploadController {

    private KrakenDirectUploader uploader;

    public KrakenUploadController() throws IOException {
        uploader = new KrakenDirectUploader(new KrakenDirectUploadApiImpl());
    }

    @RequestMapping(value = "/image/sync/optimize", method = RequestMethod.POST)
    public ResponseEntity handleSyncOptimizeFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            return ResponseEntity.ok().body(uploader.upload(OptimizeRequestImpl.syncBuilder().build(), file));
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }

    }

    @RequestMapping(value = "/image/async/optimize", method = RequestMethod.POST)
    public ResponseEntity handleAsyncOptimizeFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            return ResponseEntity.ok().body(uploader.upload(OptimizeRequestImpl.asyncBuilder()
                    .callbackUrl("http://86fbe85b.ngrok.io/kraken/callback//single")
                    .build(), file));
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }

    }

    @RequestMapping(value = "/image/sync/resize", method = RequestMethod.POST)
    public ResponseEntity handlSyncResizeFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            return ResponseEntity.ok().body(uploader.upload(ResizeRequestImpl.syncBuilder()
                    .resize(ResizeItem.builder().strategy(ResizeStrategy.PORTRAIT).height(100).build())
                    .build(), file));
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }

    }

    @RequestMapping(value = "/image/async/resize", method = RequestMethod.POST)
    public ResponseEntity handlASyncResizeFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            return ResponseEntity.ok().body(uploader.upload(ResizeRequestImpl.asyncBuilder()
                    .resize(ResizeItem.builder().strategy(ResizeStrategy.PORTRAIT).height(100).build())
                    .callbackUrl("http://86fbe85b.ngrok.io/kraken/callback//single")
                    .build(), file));
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }

    }
}
