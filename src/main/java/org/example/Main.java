package org.example;

import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        Note note = NoteManager.createNote();
        System.out.println(note.toString());
    }

}