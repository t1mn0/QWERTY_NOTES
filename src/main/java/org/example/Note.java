package org.example;

import com.alibaba.fastjson.annotation.JSONField;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Note {
    private final static SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
    @JSONField(name = "NAME", ordinal = 2)
    private StringBuffer name;
    @JSONField(name = "CONTENT", ordinal = 3)
    private StringBuffer content;
    @JSONField(name = "DATE OF CREATE", format="dd/MM/yyyy", ordinal = 4)
    private final Date create;
    @JSONField(name = "ID", ordinal = 1)
    private final UUID uuid;

    public Note(StringBuffer name, final Date create, StringBuffer content, UUID uuid){
        this.name = name;
        this.create = create;
        this.content = content;
        this.uuid = uuid;
    }

    public StringBuffer getName() {
        return name;
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

    @Override
    public String toString() {
        return "Название заметки: " + "\u001B[32m" + name + "\u001B[0m"
                + "\nДата создания заметки: " + "\u001B[34m" + date.format(create) + "\u001B[0m"
                + "\n" + content;
    }
}

