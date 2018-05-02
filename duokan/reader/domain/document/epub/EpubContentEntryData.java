package com.duokan.reader.domain.document.epub;

import java.io.Serializable;

public class EpubContentEntryData implements Serializable {
    private static final long serialVersionUID = 1;
    public long mChapterIndex = 0;
    public EpubContentEntryData[] mChildEntries = new EpubContentEntryData[0];
    public String mTitle = "";
}
