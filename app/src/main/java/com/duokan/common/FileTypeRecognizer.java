package com.duokan.common;

public class FileTypeRecognizer {

    public enum FileType {
        UNSUPPORTED,
        TXT,
        EPUB,
        PDF
    }

    public static FileType a(String str) {
        String a = tools.substringwerCase(str);
        if (a == null) {
            return FileType.UNSUPPORTED;
        }
        if (a.equalsIgnoreCase("epub")) {
            return FileType.EPUB;
        }
        if (a.equalsIgnoreCase("txt")) {
            return FileType.TXT;
        }
        if (a.equalsIgnoreCase("pdf")) {
            return FileType.PDF;
        }
        return FileType.UNSUPPORTED;
    }
}
