package com.duokan.kernel.pdflib;

import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.ah;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkNative;
import com.duokan.kernel.DkRenderInfo;
import com.duokan.reader.domain.document.Document_a.o;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class DkpBook extends DkNative {
    private final ArrayList mDkpFixedPages = new ArrayList();
    private final LinkedList mDkpFlowPageList = new LinkedList();
    private final long mDkpHandle;
    private final int[] mPageHeights;
    private final int[] mPageWidths;
    private final Object mParseLock = new Object();

    private native DkpPage getPage(long j);

    private native DkpPageEx getPageEx(DkFlowPosition dkFlowPosition, DkpFlowParserOption dkpFlowParserOption, int i);

    private native void releasePage(DkpPage dkpPage);

    private native void releasePageEx(DkpPageEx dkpPageEx);

    private native void renderPage(DkRenderInfo dkRenderInfo);

    public native DkpOutlineItem[] getChildOutlineItems(int i);

    public native int getPageCount();

    public native void releaseAllPages();

    public native void setDefaultFont(String str, int i);

    protected DkpBook(long j) {
        this.mDkpHandle = j;
        int pageCount = getPageCount();
        this.mDkpFixedPages.ensureCapacity(pageCount);
        for (int i = 0; i < pageCount; i++) {
            this.mDkpFixedPages.add(i, null);
        }
        this.mPageWidths = new int[pageCount];
        this.mPageHeights = new int[pageCount];
        Arrays.fill(this.mPageWidths, -1);
        Arrays.fill(this.mPageHeights, -1);
    }

    public void close() {
        if (this.mDkpHandle != 0) {
            ah.a(new Runnable() {
                public void run() {
                    Iterator it = DkpBook.this.mDkpFixedPages.iterator();
                    while (it.hasNext()) {
                        DkpPage dkpPage = (DkpPage) it.next();
                        a c = a.c();
                        boolean z = dkpPage == null || (dkpPage.mRefCount == 0 && dkpPage.mReleased);
                        c.b(z);
                    }
                    o.c().a().closeBook(DkpBook.this);
                }
            }, DkpBook.class.toString());
        }
    }

    public int getPageWidth(long j) {
        if (this.mPageWidths[((int) j) - 1] < 0) {
            this.mPageWidths[((int) j) - 1] = (int) acquireFixedPage(j).getWidth();
            releaseFixedPage(j);
        }
        return this.mPageWidths[((int) j) - 1];
    }

    public int getPageHeight(long j) {
        if (this.mPageHeights[((int) j) - 1] < 0) {
            this.mPageHeights[((int) j) - 1] = (int) acquireFixedPage(j).getHeight();
            releaseFixedPage(j);
        }
        return this.mPageHeights[((int) j) - 1];
    }

    public DkpPage acquireFixedPage(long j) {
        Object obj = null;
        synchronized (this) {
            DkpPage dkpPage = (DkpPage) this.mDkpFixedPages.get(((int) j) - 1);
            if (dkpPage == null || dkpPage.mReleased) {
                dkpPage = getPage(j);
                this.mDkpFixedPages.set(((int) j) - 1, dkpPage);
                dkpPage.mRefCount++;
            } else if (dkpPage.mRefCount > 0) {
                dkpPage.mRefCount++;
            } else {
                obj = 1;
            }
        }
        if (obj != null) {
            synchronized (dkpPage) {
                if (dkpPage.mReleased) {
                    return acquireFixedPage(j);
                }
                dkpPage.mRefCount++;
                return dkpPage;
            }
        }
        a.c().a(dkpPage.mReleased);
        return dkpPage;
    }

    public synchronized void releaseFixedPage(long j) {
        final DkpPage dkpPage = (DkpPage) this.mDkpFixedPages.get(((int) j) - 1);
        a.c().b(dkpPage.mRefCount > 0);
        dkpPage.mRefCount--;
        if (dkpPage.mRefCount == 0) {
            ah.a(new Runnable() {
                public void run() {
                    if (!dkpPage.mReleased && dkpPage.mRefCount <= 0) {
                        synchronized (dkpPage) {
                            if (dkpPage.mRefCount > 0) {
                                return;
                            }
                            synchronized (DkpBook.this.mParseLock) {
                                if (dkpPage.mRefCount > 0) {
                                    return;
                                }
                                DkpBook.this.releasePage(dkpPage);
                                dkpPage.mReleased = true;
                            }
                        }
                    }
                }
            }, DkpBook.class.toString());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.duokan.kernel.pdflib.DkpPageEx acquireFlowPage(com.duokan.kernel.DkFlowPosition r5, com.duokan.kernel.pdflib.DkpFlowParserOption r6, int r7) {
        /*
        r4 = this;
        r1 = 0;
        r0 = 2;
        if (r7 != r0) goto L_0x0041;
    L_0x0004:
        r0 = r4.acquireFlowPage(r5, r6);
    L_0x0008:
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        r3 = r4.mParseLock;
        monitor-enter(r3);
        r2 = r4.getPageEx(r5, r6, r7);	 Catch:{ all -> 0x0031 }
        if (r2 != 0) goto L_0x0017;
    L_0x0014:
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        r0 = r1;
        goto L_0x000a;
    L_0x0017:
        r0 = r2.getPageStartPos();	 Catch:{ all -> 0x0031 }
        r2.mDkStartPos = r0;	 Catch:{ all -> 0x0031 }
        r2.mDkpParserOption = r6;	 Catch:{ all -> 0x0031 }
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        monitor-enter(r4);
        r0 = r2.mDkStartPos;	 Catch:{ all -> 0x002e }
        r0 = r4.acquireFlowPage(r0, r6);	 Catch:{ all -> 0x002e }
        if (r0 == 0) goto L_0x0034;
    L_0x0029:
        r4.releasePageEx(r2);	 Catch:{ all -> 0x002e }
    L_0x002c:
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
        goto L_0x000a;
    L_0x002e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
        throw r0;
    L_0x0031:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        throw r0;
    L_0x0034:
        r0 = r2.mRefCount;	 Catch:{ all -> 0x002e }
        r0 = r0 + 1;
        r2.mRefCount = r0;	 Catch:{ all -> 0x002e }
        r0 = r4.mDkpFlowPageList;	 Catch:{ all -> 0x002e }
        r0.addFirst(r2);	 Catch:{ all -> 0x002e }
        r0 = r2;
        goto L_0x002c;
    L_0x0041:
        r0 = r1;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.kernel.pdflib.DkpBook.acquireFlowPage(com.duokan.kernel.DkFlowPosition, com.duokan.kernel.pdflib.DkpFlowParserOption, int):com.duokan.kernel.pdflib.DkpPageEx");
    }

    public synchronized DkpPageEx acquireFlowPage(DkFlowPosition dkFlowPosition, DkpFlowParserOption dkpFlowParserOption) {
        DkpPageEx dkpPageEx;
        Iterator it = this.mDkpFlowPageList.iterator();
        while (it.hasNext()) {
            dkpPageEx = (DkpPageEx) it.next();
            if (dkpPageEx.mDkStartPos.equals(dkFlowPosition) && dkpPageEx.mDkpParserOption.equals(dkpFlowParserOption)) {
                dkpPageEx.mRefCount++;
                break;
            }
        }
        dkpPageEx = null;
        return dkpPageEx;
    }

    public synchronized void releaseFlowPage(DkFlowPosition dkFlowPosition, DkpFlowParserOption dkpFlowParserOption) {
        Iterator it = this.mDkpFlowPageList.iterator();
        while (it.hasNext()) {
            DkpPageEx dkpPageEx = (DkpPageEx) it.next();
            if (dkpPageEx.mDkStartPos.equals(dkFlowPosition) && dkpPageEx.mDkpParserOption.equals(dkpFlowParserOption)) {
                dkpPageEx.mRefCount--;
                if (dkpPageEx.mRefCount == 0) {
                    releasePageEx(dkpPageEx);
                    this.mDkpFlowPageList.remove(dkpPageEx);
                }
            }
        }
    }

    public synchronized void releaseFlowPage(DkpPageEx dkpPageEx) {
        dkpPageEx.mRefCount--;
        if (dkpPageEx.mRefCount == 0) {
            releasePageEx(dkpPageEx);
            this.mDkpFlowPageList.remove(dkpPageEx);
        }
    }

    public void renderFlowPage(DkFlowRenderOption dkFlowRenderOption, DkFlowPosition dkFlowPosition, DkpFlowParserOption dkpFlowParserOption) {
        DkpPageEx acquireFlowPage = acquireFlowPage(dkFlowPosition, dkpFlowParserOption);
        synchronized (this.mParseLock) {
            acquireFlowPage.renderPage(dkFlowRenderOption);
        }
        releaseFlowPage(acquireFlowPage);
    }

    public DkFlowPosition[] parseFixedPage(long j) {
        DkFlowPosition[] dkFlowPositionArr = new DkFlowPosition[2];
        DkpPage acquireFixedPage = acquireFixedPage(j);
        synchronized (this.mParseLock) {
            dkFlowPositionArr[0] = acquireFixedPage.getPageStartPos();
            dkFlowPositionArr[1] = acquireFixedPage.getPageEndPos();
        }
        releaseFixedPage(j);
        return dkFlowPositionArr;
    }

    public void renderFixedPage(DkRenderInfo dkRenderInfo) {
        acquireFixedPage(dkRenderInfo.mPageNum);
        try {
            synchronized (this.mParseLock) {
                renderPage(dkRenderInfo);
            }
        } finally {
            releaseFixedPage(dkRenderInfo.mPageNum);
        }
    }

    public DkpSearchResult[] findTextInPage(long j, String str, int i) {
        DkpPage acquireFixedPage = acquireFixedPage(j);
        try {
            DkpSearchResult[] findTextInPage;
            synchronized (this.mParseLock) {
                findTextInPage = acquireFixedPage.findTextInPage(str, i);
            }
            return findTextInPage;
        } finally {
            releaseFixedPage(j);
        }
    }
}
