package org.example;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.Date;
import java.util.UUID;

public class NoteManager {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public static Note createNote() throws IOException {
        System.out.print("Enter name of new note: ");
        StringBuffer name = new StringBuffer(reader.readLine());
        if (name.isEmpty()) name.append("Untitled");
        System.out.println("Enter content of new note (enter 'end_note' to finish the note):");
        String line; StringBuffer content = new StringBuffer();
        while (!(line = reader.readLine()).equals("end_note")){
            content.append(line + "\n");
        }
        Note note = new Note(name, new Date(), content, UUID.randomUUID());
        String jsonString = JSON.toJSONString(note);
        BufferedWriter writer;
        try {
             writer = new BufferedWriter(new FileWriter("./src/main/resources/notes.json", true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writer.write(jsonString);
        writer.newLine();
        writer.close();
        return note;
    }



    public static void showNoteList() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("./src/main/resources/notes.json"));
        String jsonString;
        while ((jsonString = fileReader.readLine()) != null){
            Note note = JSON.parseObject(jsonString, Note.class);
            System.out.println(note.shortInfo());
        }
        fileReader.close();
    }



    public static void deleteNote(String stringID) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("./src/main/resources/notes.json"));
        String jsonString; boolean flag = false;
        BufferedWriter writer;
        while ((jsonString = fileReader.readLine()) != null){
            Note note = JSON.parseObject(jsonString, Note.class);
            if (!(note.getUuid().toString().equals(stringID))){
                try {
                    if (flag) {
                        writer = new BufferedWriter(new FileWriter("./src/main/resources/notes.json", true));
                    }
                    else {
                        writer = new BufferedWriter(new FileWriter("./src/main/resources/notes.json", false));
                        flag = true;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                writer.write(jsonString);
                writer.newLine();
                writer.close();
            }
        }

    }


/* Функцию, изменяющую заметку необходимо доработать. Проблема: после изменения записать ее обратно в файл json
    public static void changeNote(String stringID) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("./src/main/resources/notes.json"));
        String jsonString; Note note = null; boolean flag = false;
        while ((jsonString = fileReader.readLine()) != null){
            Note jsonElement = JSON.parseObject(jsonString, Note.class);
            if (jsonElement.getUuid().toString().equals(stringID)){
                note = jsonElement;
                flag = true;
                break;
            }
        }
        fileReader.close();
        if (flag) {
            System.out.println(note.toString());
            System.out.println("Choose what you want to change: the 'content' or 'title' of the note");
            String whatChanging = reader.readLine();
            if (whatChanging.equals("content")) {
                System.out.println("Enter new content of new note (enter 'end_note'  to finish the note):");
                String line;
                StringBuffer newContent = new StringBuffer();
                while (!(line = reader.readLine()).equals("end_note")) {
                    newContent.append(line + "\n");
                }
                note.setContent(newContent);

            } else if (whatChanging.equals("title")) {
                System.out.println("Enter new title of new note");
                StringBuffer newTitle = new StringBuffer(reader.readLine());
                note.setTitle(newTitle);
            }
        }
    }
 */

    public static void readNote(String stringID) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("./src/main/resources/notes.json"));
        String jsonString;
        while ((jsonString = fileReader.readLine()) != null) {
            Note note = JSON.parseObject(jsonString, Note.class);
            if (note.getUuid().toString().equals(stringID)) {
                System.out.println(note.toString());
            }
        }
    }
}
