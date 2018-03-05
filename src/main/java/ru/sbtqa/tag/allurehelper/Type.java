package ru.sbtqa.tag.allurehelper;

/**
 * Enum for a attachment to addAttachment method in ParamsHelper class.
 *
 * @see ru.sbtqa.tag.allurehelper.ParamsHelper *
 */

public enum Type {

    TEXT("text/plain", ".txt"),
    XML("application/xml", ".xml"),
    HTML("text/html", ".html"),
    PNG("image/png", ".png"),
    JPEG("image/jpeg", ".jpg"),
    CSV("text/csv", ".csv"),
    VIDEO("video/webm", ".webm"),
    URI("text/uri-list", ".uri"),
    TARGZIP("application/x-gtar", ".gtar");

    private final String type;
    private final String extension;

    Type(final String type, final String extension) {
        this.type = type;
        this.extension = extension;
    }

    @Override
    public String toString() {
        return type;
    }

    public String getExtension() {
        return extension;
    }
}
