package com.duokan.kernel.epublib;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFindTextSnippet;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkNative;
import com.duokan.kernel.DkStream;

public class DkeBook extends DkNative {
    public static final int DKE_PARSER_PAGETABLE_BOOK = 0;
    public static final int DKE_PARSER_PAGETABLE_BUILTIN = 2;
    public static final int DKE_PARSER_PAGETABLE_CHAPTER = 1;
    private final Callback mCallback;
    private long mDkeHandle;

    public interface Callback {
        byte[][] queryCert();

        DkeResourceStream queryResource(DkeResourceDescriptor dkeResourceDescriptor);
    }

    public native long[] calcChapterPages(DkeParserOption dkeParserOption);

    public native void clearAllParsedPages();

    public native void clearChapterData(long j);

    public native void close();

    public native DkFlowPosition[] findTextInBook(DkFlowPosition dkFlowPosition, String str, int i);

    public native DkeFuzzyMatchResult fuzzyMatch(String str, DkFlowPosition dkFlowPosition, String str2);

    public native DkeResourceDescriptor[] getAllResources();

    public native DkeAudioText[] getAudioTexts(long j);

    public native void getBookCover(DKFileInfo dKFileInfo);

    public native String getBookId();

    public native void getBookInfo(DKEBookInfo dKEBookInfo);

    public native String getBookRevision();

    public native long[] getByteOffsetRange(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2);

    public native long getChapterCount();

    public native String getChapterId(long j);

    public native long getChapterIndex(String str);

    public native long getChapterIndexByUri(String str);

    public native long getChapterIndexOfFrame(long j);

    public native long[] getChapterOffsetRange(long j);

    public native long getChapterPackSize(long j);

    public native String getChapterPackUri(long j);

    public native DkeResourceDescriptor getChapterResource(long j);

    protected native long getChapterSize(long j);

    public native String getChapterTextOfRange(DkFlowPosition dkFlowPosition, DkFlowPosition dkFlowPosition2);

    public native int getChapterType(long j);

    public native DkeComicsFrame getComicsFrame(long j);

    public native long getComicsFrameCount();

    public native DkeExerciseFormInfo[] getExerciseForms(long j);

    public native DkStream getFileStream(String str);

    public native DkFindTextSnippet getFindTextSnippet(DkFlowPosition dkFlowPosition, String str, int i);

    public native DkFlowPosition getFlowPosition(long j, String str);

    public native DkFlowPosition getFlowPositionByLink(String str, String str2);

    public native DkFlowPosition[] getFlowPositionRange(long j, long j2, long j3, long j4);

    public native String[] getFontFamilies();

    public native int getFootnoteAppearanceType();

    public native int getLayoutType();

    public native long getLeadingChapterIndex();

    public native DkStream getMediaStream(long j, String str);

    public native long getPage(long j);

    public native long getPageCount();

    public native long getPageCountOfChapter(long j);

    protected native long getPageOfChapter(long j, long j2);

    public native DkeResourceDescriptor getResource(String str);

    public native long getTocRoot();

    public native int getWritingMode();

    public native boolean hasAudioText();

    public native boolean isComicsChapter(long j);

    public native boolean isDrmChapter(long j);

    public native boolean isDrmResource(String str);

    public native boolean isLinear();

    public native void open(String str, String str2);

    public native long openDrm(String str, String str2, byte[][] bArr);

    public native long openInc(String str, String[] strArr, String str2, String str3, String str4, boolean z);

    public native long parseContent(DkeParserOption dkeParserOption);

    public native void redirectChapter(String str, String str2);

    public native long renderImage(String str, DkFlowRenderOption dkFlowRenderOption, DkBox dkBox, DkBox dkBox2, int i, int i2);

    public native void resetAllTextColor();

    public native void setBodyFontFamily(String str, int i);

    public native void setBodyFontSize(double d);

    public native void setFirstLineIndent(double d);

    public native void setLineGap(double d);

    public native void setParaSpacing(double d);

    public native void setTabStop(double d);

    public native long updateByteOffset(String str, long j, String str2, String str3);

    public DkeBook(String str, String str2, Callback callback, byte[][] bArr) {
        this.mDkeHandle = 0;
        this.mCallback = callback;
        if (bArr == null) {
            open(str, str2);
        } else {
            openDrm(str, str2, bArr);
        }
    }

    public DkeBook(String str, String[] strArr, String str2, String str3, String str4, boolean z) {
        this.mDkeHandle = 0;
        this.mCallback = null;
        openInc(str, strArr, str2, str3, str4, z);
    }

    public DkePage getPageOfChapterEx(long j, long j2) {
        return new DkePage(getPageOfChapter(j, j2));
    }

    public boolean isValid() {
        return this.mDkeHandle != 0;
    }

    protected byte[][] onQueryCert() {
        if (this.mCallback == null) {
            return (byte[][]) null;
        }
        return this.mCallback.queryCert();
    }

    protected DkeResourceStream onQueryResource(DkeResourceDescriptor dkeResourceDescriptor) {
        if (this.mCallback == null) {
            return null;
        }
        return this.mCallback.queryResource(dkeResourceDescriptor);
    }
}
