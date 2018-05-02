package com.duokan.reader.common.webservices.duokan;

public class DkCommentDetailInfo extends g {
    public String a = null;
    public String b = null;
    public String c = null;
    public String d = null;
    public String e = null;
    public CommentBookType f = CommentBookType.BOOK;

    public enum CommentBookType {
        UNKNOWN,
        BOOK,
        FICTION
    }
}
