package com.duokan.kernel.txtlib;

import com.duokan.kernel.DkArgbColor;
import com.duokan.kernel.DkFindTextSnippet;
import com.duokan.kernel.DkNative;
import com.duokan.reader.domain.document.txt.aa;

import java.util.Iterator;
import java.util.LinkedList;

public class DktBook extends DkNative {
    private final long mDktHandle;
    private final LinkedList mDktPageList = new LinkedList();

    private native long createPage(DktParserOption dktParserOption, long j, int i);

    private native void destroyPage(long j);

    public native long calcNextPageOffset(DktParserOption dktParserOption, long j);

    public native long[] findTextInBook(long j, String str, int i);

    public native String getChapterTitle(long j);

    public native DkFindTextSnippet getFindTextSnippet(long j, String str, int i);

    public native int getLogicalPageCount();

    public native long getLogicalPageIndexByOffsetInByte(long j);

    public native long getLogicalPageOffsetInBytes(long j);

    public native long[] getToc();

    public native long prepareParseContent(int i);

    public native void setFirstLineIndent(double d);

    public native void setFontFamily(String str, int i);

    public native void setFontSize(double d);

    public native void setLineGap(double d);

    public native void setParaSpacing(double d);

    public native void setTabStop(double d);

    public native void setTextColor(DkArgbColor dkArgbColor);

    public native void setToc(long[] jArr);

    public DktBook(long j) {
        this.mDktHandle = j;
    }

    public void close() {
        if (this.mDktHandle != 0) {
            aa.c().a().closeDocument(this.mDktHandle);
        }
    }

    public DktPage acquirePage(long j, DktParserOption dktParserOption, int i) {
        DktPage acquirePage;
        DktPage dktPage = null;
        if (i == 2) {
            acquirePage = acquirePage(j, dktParserOption);
        } else {
            acquirePage = null;
        }
        if (acquirePage == null) {
            synchronized (this.mDktPageList) {
                if (j == Long.MIN_VALUE) {
                    dktPage = new DktDummyPage(Long.MIN_VALUE, 0);
                } else if (j == Long.MAX_VALUE) {
                    dktPage = new DktDummyPage(Long.MAX_VALUE, 0);
                } else {
                    long createPage = createPage(dktParserOption, j, i);
                    if (createPage != 0) {
                        dktPage = new DktPage(createPage);
                    }
                }
                if (dktPage != null) {
                    dktPage.mDktParserOption = dktParserOption;
                }
            }
            synchronized (this) {
                acquirePage = acquirePage(dktPage.mByteOffset, dktParserOption);
                if (acquirePage == null) {
                    dktPage.mRefCount++;
                    this.mDktPageList.addFirst(dktPage);
                    acquirePage = dktPage;
                } else if (dktPage.mDktHandle != 0) {
                    destroyPage(dktPage.mDktHandle);
                }
            }
        }
        return acquirePage;
    }

    public synchronized DktPage acquirePage(long j, DktParserOption dktParserOption) {
        DktPage dktPage;
        Iterator it = this.mDktPageList.iterator();
        while (it.hasNext()) {
            dktPage = (DktPage) it.next();
            if (dktPage.mByteOffset == j && dktPage.mDktParserOption.equals(dktParserOption)) {
                dktPage.mRefCount++;
                break;
            }
        }
        dktPage = null;
        return dktPage;
    }

    public synchronized void releasePage(long j, DktParserOption dktParserOption) {
        Iterator it = this.mDktPageList.iterator();
        while (it.hasNext()) {
            DktPage dktPage = (DktPage) it.next();
            if (dktPage.mByteOffset == j && dktPage.mDktParserOption.equals(dktParserOption)) {
                dktPage.mRefCount--;
                if (dktPage.mRefCount == 0) {
                    if (dktPage.mDktHandle != 0) {
                        destroyPage(dktPage.mDktHandle);
                    }
                    this.mDktPageList.remove(dktPage);
                }
            }
        }
    }

    public synchronized void releasePage(DktPage dktPage) {
        dktPage.mRefCount--;
        if (dktPage.mRefCount == 0) {
            if (dktPage.mDktHandle != 0) {
                destroyPage(dktPage.mDktHandle);
            }
            this.mDktPageList.remove(dktPage);
        }
    }
}
