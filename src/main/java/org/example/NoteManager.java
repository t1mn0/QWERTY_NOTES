package org.example;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.UUID;

public class NoteManager {
    public static Note createNote() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer name, content = new StringBuffer(), line, endLine = new StringBuffer("END_NOTE!");
        do {
            name = new StringBuffer(reader.readLine());
        } while (name.isEmpty());

        while (!((line = new StringBuffer(reader.readLine())).compareTo(endLine) == 0)){
            content.append(line + "\n");
        }
        Note note = new Note(name, new Date(), content, UUID.randomUUID());
        String jsonObject = JSON.toJSONString(note);
        return note;
    }

    /*
    public static Note getNote(UUID uuid) {

    }

    public static Note updateNote(UUID uuid) {

    }

    public static Note deleteNote(UUID uuid) {

    }
    */

}
