package com.uml.generator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class UMLService {

    public String processJavaFile(MultipartFile file) throws Exception {
        Path tempFile = Files.createTempFile("uploaded", ".java");
        Files.copy(file.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);
        String dotFormat = JavaParserUtil.parseJavaFile(tempFile.toFile());
        Path dotFilePath = Files.createTempFile("uml", ".dot");
        Files.write(dotFilePath, dotFormat.getBytes());
        return dotFilePath.toString();
    }
}
