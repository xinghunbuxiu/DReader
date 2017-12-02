package com.duokan.kernel.epublib;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.epublib.DkeBook.Callback;

import java.util.Arrays;

public class DkeBookEx extends DkeBook {
    private final long[] mChapterPageCounts;
    private final long[] mChapterParseResult;

    public DkeBookEx(String str, String str2, Callback callback, byte[][] bArr) {
        super(str, str2, callback, bArr);
        if (isValid()) {
            this.mChapterPageCounts = new long[((int) getChapterCount())];
            this.mChapterParseResult = new long[((int) getChapterCount())];
            Arrays.fill(this.mChapterPageCounts, 0);
            Arrays.fill(this.mChapterParseResult, -1);
            return;
        }
        this.mChapterPageCounts = new long[0];
        this.mChapterParseResult = new long[0];
    }

    public DkeBookEx(String str, String[] strArr, String str2, String str3, String str4, boolean z) {
        super(str, strArr, str2, str3, str4, z);
        if (isValid()) {
            this.mChapterPageCounts = new long[((int) getChapterCount())];
            this.mChapterParseResult = new long[((int) getChapterCount())];
            Arrays.fill(this.mChapterPageCounts, 0);
            Arrays.fill(this.mChapterParseResult, -1);
            return;
        }
        this.mChapterPageCounts = new long[0];
        this.mChapterParseResult = new long[0];
    }

    public long parseContent(DkeParserOption dkeParserOption) {
        long parseContent = super.parseContent(dkeParserOption);
        if (parseContent == 0) {
            this.mChapterPageCounts[(int) dkeParserOption.mChapterIndex] = Math.max(0, super.getPageCountOfChapter(dkeParserOption.mChapterIndex) + ((long) dkeParserOption.mStuffings));
        } else {
            this.mChapterPageCounts[(int) dkeParserOption.mChapterIndex] = 1;
        }
        this.mChapterParseResult[(int) dkeParserOption.mChapterIndex] = parseContent;
        return parseContent;
    }

    public long[] calcChapterPages(DkeParserOption dkeParserOption) {
        long j = 0;
        long[] calcChapterPages = super.calcChapterPages(dkeParserOption);
        if (calcChapterPages.length < 1) {
            return new long[]{0};
        } else if (dkeParserOption.mStuffings <= 0) {
            return calcChapterPages;
        } else {
            long[] copyOf = Arrays.copyOf(calcChapterPages, calcChapterPages.length + dkeParserOption.mStuffings);
            if (calcChapterPages.length > 0) {
                j = calcChapterPages[calcChapterPages.length - 1];
            }
            long j2 = (long) ((int) (j >> 32));
            for (int length = calcChapterPages.length; length < copyOf.length; length++) {
                int length2 = length - calcChapterPages.length;
                copyOf[length] = (((((long) length2) + j2) + 1) << 32) | ((long) length2);
            }
            return copyOf;
        }
    }

    public long getPageCountOfChapter(long j) {
        if (this.mChapterParseResult[(int) j] < 0) {
            return super.getPageCountOfChapter(j);
        }
        return this.mChapterPageCounts[(int) j];
    }

    public DkePage getPageOfChapterEx(long j, long j2) {
        long j3 = this.mChapterParseResult[(int) j];
        if (j3 < 0) {
            return null;
        }
        if (j3 == 0) {
            long pageCountOfChapter = getPageCountOfChapter(j);
            if (pageCountOfChapter <= 0 || pageCountOfChapter < j2) {
                return null;
            }
            pageCountOfChapter = super.getPageCountOfChapter(j);
            if (j2 < pageCountOfChapter) {
                return new DkePage(getPageOfChapter(j, j2));
            }
            DkePage dkePage = new DkePage(super.getPageOfChapter(j, pageCountOfChapter - 1));
            DkFlowPosition dkFlowPosition = new DkFlowPosition();
            dkePage.getEndPosition(dkFlowPosition);
            int i = (int) (j2 - pageCountOfChapter);
            dkFlowPosition.mParaIndex = (dkFlowPosition.mParaIndex + ((long) i)) + 1;
            dkFlowPosition.mAtomIndex = (long) i;
            DkFlowPosition dkFlowPosition2 = new DkFlowPosition();
            dkFlowPosition2.mChapterIndex = dkFlowPosition.mChapterIndex;
            dkFlowPosition2.mParaIndex = dkFlowPosition.mParaIndex;
            dkFlowPosition2.mAtomIndex = (long) (i + 1);
            return new DkeStuffingPage(dkFlowPosition, dkFlowPosition2);
        } else if (j2 != 0) {
            return null;
        } else {
            return new DkeErrorPage(new DkFlowPosition(j, 0, 0), new DkFlowPosition(j, 0, 1), j3);
        }
    }

    public void clearAllParsedPages() {
        Arrays.fill(this.mChapterParseResult, -1);
        Arrays.fill(this.mChapterPageCounts, 0);
        super.clearAllParsedPages();
    }
}
