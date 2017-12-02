package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.domain.store.DkStoreAbsBook;

public class CommentBook extends DkStoreAbsBook {
    private int mRate = 0;
    private String mTag = "";

    public CommentBook(DkStoreAbsBookInfo dkStoreAbsBookInfo) {
        super(dkStoreAbsBookInfo);
    }

    public int getBookRate() {
        return this.mRate;
    }

    public void setBookRate(int i) {
        this.mRate = i;
    }

    public String getTag() {
        return this.mTag;
    }

    public void setTag(String str) {
        this.mTag = str;
    }
}
