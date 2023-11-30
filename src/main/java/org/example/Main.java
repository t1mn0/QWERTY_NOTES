package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String comand; String ID;
        System.out.println("\u001B[36m" + "_".repeat(35) + "QWERTY___NOTES" + "_".repeat(35) + "\u001B[37m");
        Commands();
        while (!(comand = reader.readLine()).equals("finish")){
            switch (comand){
                case("New note"): NoteManager.createNote(); break;
                case("Show notes"): NoteManager.showNoteList(); break;
                case("Delete note"):
                    System.out.println("\u001B[33mEnter the ID of the note you want to delete (enter 'back' to go back a step)\u001B[37m");
                    ID = reader.readLine();
                    if (ID.equals("back")){
                        break;
                    }
                    NoteManager.deleteNote(ID);
                    break;
                case("Read note"):
                    System.out.println("\u001B[33mEnter the ID of the note you want to read (enter 'back' to go back a step)\u001B[37m");
                    ID = reader.readLine();
                    if (ID.equals("back")){
                        break;
                    }
                    NoteManager.readNote(ID);
                    break;
                //case("Change note"):
                //System.out.println("Enter the note ID you want to change");
                //ID = reader.readLine();
                //NoteManager.changeNote();
                // break;
                default:
                    System.out.println("\u001B[31mEnter correct name of comand:\u001B[0m");
                    break;
            }
            Commands();
        }
    }

    public static void Commands(){
        System.out.println("\u001B[34m" + "Basic commands of this program:" + "\u001B[0m" + "\u001B[32m" +
                "\n► enter 'New note' -> create & save new note" +
                "\n► enter 'Show notes' -> show notes list (notes are shown in short format)" +
                "\n► enter 'Read note' -> read selected note+ " +
                "\n► enter 'Delete note' -> delete note" +
                //"\n► enter 'Change note' -> change note" +
                "\n► enter 'finish' -> finish program execution" + "\u001B[0m");
    }

}