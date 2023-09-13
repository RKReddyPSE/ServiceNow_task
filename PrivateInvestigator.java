import java.io.*;
import java.util.*;

public class PrivateInvestigator {
    
        public static void main(String[] args) {
            String inputFilePath = "input.txt";
            String outputFilePath = "output.txt";
    
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
    
                Map<String, List<String>> patterns = new HashMap<>();
    
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    String timestamp = parts[0] + " " + parts[1];
                    String action = parts[2];
                    String key = timestamp + " " + action;
    
                    patterns.computeIfAbsent(key, k -> new ArrayList<>()).add(line);
                }
    
                for (List<String> pattern : patterns.values()) {
                    if (pattern.size() > 1) {
                        String[] parts = pattern.get(0).split(" ");
                        String changingWord = parts[parts.length - 1];
    
                        for (String sentence : pattern) {
                            writer.write(sentence + "\n");
                        }
                        writer.write("The changing word was: " + changingWord + "\n\n");
                    }
                }
                
                System.out.println("Output written to " + outputFilePath);
    
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    