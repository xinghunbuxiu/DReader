package com.duokan.reader.domain.cmread;

import java.util.List;

public class CmChapterInfo {
    private String mChapterID;
    private String mChapterName;
    private String mPageContent;
    private List mPageList;
    private int mType;

    public CmChapterInfo(List list, String str, String str2, int i, String str3) {
        this.mPageList = list;
        this.mChapterName = str;
        this.mPageContent = str2;
        this.mType = i;
        this.mChapterID = str3;
    }

    public List getPageList() {
        return this.mPageList;
    }

    public String getChapterName() {
        return this.mChapterName;
    }

    public String getPageContent() {
        return this.mPageContent;
    }

    public String getChapterID() {
        return this.mChapterID;
    }

    public int getType() {
        return this.mType;
    }
}
