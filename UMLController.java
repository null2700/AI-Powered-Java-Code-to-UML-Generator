package com.uml.generator;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.nio.file.Files;

@RestController
@RequestMapping("/uml")
public class UMLController {
    
    private final UMLService umlService;

    public UMLController(UMLService umlService) {
        this.umlService = umlService;
    }

    @PostMapping("/generate")
    public ResponseEntity<byte[]> generateUML(@RequestParam("file") MultipartFile file) {
        try {
            String dotFilePath = umlService.processJavaFile(file);
            File umlImage = UMLGenerator.generateImage(dotFilePath);
            byte[] imageBytes = Files.readAllBytes(umlImage.toPath());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "image/png");
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
