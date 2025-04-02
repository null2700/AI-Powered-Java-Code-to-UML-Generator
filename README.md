AI-Powered Java Code to UML Generator

Overview
This project is a Spring Boot-based AI-powered UML diagram generator that converts Java source code into UML-like diagrams. It extracts classes, methods, and relationships from Java code and generates Graphviz-based UML visualizations.

Features
- Parses Java class structures and methods.
- Generates Graphviz DOT files for UML diagrams.
- Converts UML diagrams into PNG format.
- REST API to accept Java files and return UML diagrams dynamically.

Tech Stack
- Java (Spring Boot) – Backend API.
- Graphviz – UML diagram generation.
- ANTLR (Java Parsing) – Extracting classes/methods.
- OpenAI API (Future Enhancement) – AI-powered structure analysis.

Installation
1. Install Graphviz
   - Linux/macOS:
     
     sudo apt install graphviz
     
   - Windows: [Download from Graphviz official site](https://graphviz.gitlab.io/download/)

2. Clone the Repository
   
   git clone https://github.com/your-username/uml-generator.git
   cd uml-generator
   

3. Build and Run the Application

   mvn spring-boot:run
   
Usage
1. Test API (Using cURL)
   
   curl -X POST -F "file=@Sample.java" http://localhost:8080/uml/generate --output uml.png
   
2. The generated UML diagram will be saved as `uml.png`.

## API Endpoints
| Method | Endpoint         | Description                        |
|--------|-----------------|------------------------------------|
| POST   | `/uml/generate` | Uploads a Java file and returns UML diagram |

## Example Java Input

public class Example {
    public void methodOne() {}
    public void methodTwo() {}
}


Generated UML Output (DOT Format)

digraph UML {
    "Example" [shape=box];
    "Example" -> {methodOne(); methodTwo();} [label="methods"];
}

Future Enhancements
- Extend UML Support – Add relationships like Inheritance, Interfaces, Aggregation.
- AI-Powered Analysis – Use LLMs for code documentation & improvement suggestions.
- Web-based UI – Integrate a front-end for interactive UML visualization.

 License
This project is licensed under the MIT License.

 Contributors
- [soham gurav] - Developer
Contact
For any questions or contributions, feel free to reach out or open an issue in the repository.

