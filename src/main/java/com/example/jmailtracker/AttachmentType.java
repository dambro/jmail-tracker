package com.example.jmailtracker;

import lombok.Getter;

import java.io.File;
import java.net.URL;
import java.util.Arrays;

@Getter
public enum AttachmentType {
    FILE_5 ("5MB.zip", 5),
    FILE_10 ("10MB.zip", 10),
    FILE_20 ("20MB.zip", 20);

    AttachmentType (String filename, Integer dimension){
        this.filename = filename;
        this.dimension = dimension;
    }

    private String filename;
    private Integer dimension;

    public static AttachmentType find(Integer type){

        if (type == null){
            return null;
        }

        return Arrays.stream(AttachmentType.values())
                .filter(file -> file.getDimension().equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported type: ", type)));
    }

    public File getFile() {
        URL attachment = getClass().getResource("/attachments/" + getFilename());
        return new File(attachment.getFile());
    }

}
