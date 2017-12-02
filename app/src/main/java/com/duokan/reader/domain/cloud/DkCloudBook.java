package com.duokan.reader.domain.cloud;

import java.io.Serializable;

public class DkCloudBook extends DkCloudJsonItem {
    private String mBookName = null;
    private DkCloudBookFormat mBookType = null;
    private final String mBookUuid;

    public enum DkCloudBookFormat implements Serializable {
        TXT,
        EPUB
    }

    protected DkCloudBook(String str) {
        super(0);
        this.mBookUuid = str;
    }

    protected DkCloudBook(DkCloudBook dkCloudBook) {
        super((DkCloudJsonItem) dkCloudBook);
        this.mBookUuid = dkCloudBook.mBookUuid;
        this.mBookName = dkCloudBook.mBookName;
        this.mBookType = dkCloudBook.mBookType;
    }

    public String getBookUuid() {
        return this.mBookUuid;
    }

    public String getTitle() {
        return this.mBookName;
    }

    public DkCloudBookFormat getBookType() {
        return this.mBookType;
    }

    protected void setTitle(String str) {
        this.mBookName = str;
    }

    protected void setBookType(DkCloudBookFormat dkCloudBookFormat) {
        this.mBookType = dkCloudBookFormat;
    }

    public String getCloudId() {
        return this.mBookUuid;
    }

    protected DkCloudItem merge(DkCloudItem dkCloudItem) {
        return null;
    }
}
