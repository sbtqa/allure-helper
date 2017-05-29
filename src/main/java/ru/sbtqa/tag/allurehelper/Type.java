package ru.sbtqa.tag.allurehelper;

public enum Type {

    TEXT("text/plain"),
    XML("application/xml"),
    HTML("text/html"),
    PNG("image/png"),
    JPEG("image/jpeg"),
    CSV("text/csv"),
    VIDEO("video/webm"),
    URI("text/uri-list"),
    TARGZIP("application/x-gtar");

    private final String type;

    private Type(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
