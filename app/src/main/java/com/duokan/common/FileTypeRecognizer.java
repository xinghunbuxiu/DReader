package com.duokan.common;

public class FileTypeRecognizer {

    public enum FileType {
        UNSUPPORTED,
        TXT,
        EPUB,
        PDF
    }

    /* renamed from: a */
    public static FileType m567a(String str) {
        String a = C0267i.m601a(str);
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
