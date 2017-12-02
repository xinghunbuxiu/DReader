package com.duokan.reader.domain.store;

import java.io.Serializable;

public class DkShareBook implements Serializable {
    private static final long serialVersionUID = 1;
    public String[] mAuthors = new String[0];
    public String mBookUuid = "";
    public String mCoverUri = "";
    public String mIntro = "";
    public String mSummary = "";
    public String mTitle = "";
    public String mTraceId = "";

    public String getBookUuid() {
        return this.mBookUuid;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getCoverUri() {
        return this.mCoverUri;
    }

    public String getAuthor() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.mAuthors) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public String getIntro() {
        return this.mIntro;
    }

    public String getSummary() {
        return this.mSummary;
    }

    public String getTraceId() {
        return this.mTraceId;
    }
}
