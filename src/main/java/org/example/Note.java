package org.example;

import com.alibaba.fastjson.annotation.JSONField;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Note {
    private final static SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
    @JSONField(name = "NAME", ordinal = 2)
    private StringBuffer title;
    @JSONField(name = "CONTENT", ordinal = 3)
    private StringBuffer content;
    @JSONField(name = "DATE OF CREATE", format="dd/MM/yyyy", ordinal = 4)
    private final Date create;
    @JSONField(name = "ID", ordinal = 1)
    private final UUID uuid;

    public Note(StringBuffer title, final Date create, StringBuffer content, UUID uuid){
        this.title = title;
        this.create = create;
        this.content = content;
        this.uuid = uuid;
    }

    public StringBuffer getTitle() {
        return title;
    }

    public Date getCreate() {
        return create;
    }

    public StringBuffer getContent() {
        return content;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setTitle(StringBuffer title) {
        this.title = title;
    }

    public void setContent(StringBuffer content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "_".repeat(40) + "\n" +
                "Название заметки: " + "\u001B[32m" + title + "\u001B[0m"
                + "\nДата создания заметки: " + "\u001B[34m" + date.format(create) + "\u001B[0m"
                + "\nID: " + uuid.toString() + "\n" + content
                + "\n" + "_".repeat(40);
    }
    public String shortInfo() {
        System.out.println();
        return "_".repeat(40) + "\n" +
                "Название заметки: " + "\u001B[32m" + title + "\u001B[0m"
                + "\nДата создания заметки: " + "\u001B[34m" + date.format(create) + "\u001B[0m"
                + "\nID: " + uuid.toString()
                + "\n" + "_".repeat(40);
    }
}

