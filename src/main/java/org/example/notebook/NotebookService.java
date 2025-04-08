package org.example.notebook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static jdk.internal.misc.OSEnvironment.initialize;

public class NotebookService {
    private List<String>  notes;
    private File file;


    public NotebookService(){
        notes = new ArrayList<>();
        file = new File("Notes.txt");
        initialize();
    }

    private void initialize(){
        if (!file.exists()){
            try {file.createNewFile();
            } catch (IOException e) {
                 e.printStackTrace();
            }
        }
    }

    public void loadNotes(){
        notes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("Notes.txt")) ) {
            String line;
            while ((line = reader.readLine()) !=null) {
                notes.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNote(String note){
        notes.add(note);
        try(FileWriter writer = new FileWriter(file,true)) {
            writer.write(note + "\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void listNotes(){
        for(String note : notes){
            System.out.println(note);
        }
    }


}
