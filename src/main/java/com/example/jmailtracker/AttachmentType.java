package com.example.jmailtracker;

import lombok.Getter;

import java.io.File;
import java.net.URL;
import java.util.Arrays;

@Getter
public enum AttachmentType {
    FILE_5 ("5MB.zip", "5MB"),
    FILE_10 ("10MB.zip", "10MB"),
    FILE_20 ("20MB.zip", "20MB");

    private AttachmentType (String filename, String dimension){
        this.filename = filename;
        this.dimension = dimension;
    }

    private String filename;
    private String dimension;

    public static AttachmentType find(String type){

        if (type == null || type.isEmpty()){
            return null;
        }

        return Arrays.stream(AttachmentType.values())
                .filter(file -> file.getDimension().equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", type)));
    }

    public File getFile() {
        URL attachment = getClass().getResource("/attachments/" + getFilename());
        return new File(attachment.getFile());
    }

}
