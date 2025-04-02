package com.uml.generator;

import java.io.File;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaParserUtil {
    
    public static String parseJavaFile(File javaFile) throws Exception {
        String content = Files.readString(javaFile.toPath());
        Pattern classPattern = Pattern.compile("class\\s+(\\w+)");
        Matcher classMatcher = classPattern.matcher(content);
        String className = classMatcher.find() ? classMatcher.group(1) : "Unknown";
        Pattern methodPattern = Pattern.compile("(public|private|protected)\\s+\\w+\\s+(\\w+)\\(");
        Matcher methodMatcher = methodPattern.matcher(content);
        StringBuilder methods = new StringBuilder();
        while (methodMatcher.find()) {
            methods.append(methodMatcher.group(2)).append("(); ");
        }
        return "digraph UML {\n" +
               "    \"" + className + "\" [shape=box];\n" +
               "    \"" + className + "\" -> {" + methods.toString() + "} [label=\"methods\"];\n" +
               "}";
    }
}
