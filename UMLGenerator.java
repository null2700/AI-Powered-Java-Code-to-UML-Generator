package com.uml.generator;

import java.io.File;
import java.io.IOException;

public class UMLGenerator {

    public static File generateImage(String dotFilePath) throws IOException {
        File outputImage = File.createTempFile("uml", ".png");
        ProcessBuilder processBuilder = new ProcessBuilder("dot", "-Tpng", dotFilePath, "-o", outputImage.getAbsolutePath());
        processBuilder.start().waitFor();
        return outputImage;
    }
}
