package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.common.Md5Util;
import com.duokan.common.tools;
import com.duokan.core.a.n;
import com.duokan.core.app.IActivityRunStatusChanged;
import com.duokan.core.app.ah;
import com.duokan.core.c.IRunTask;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.FileUtils;
import com.duokan.core.sys.af;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.MiuiAssistContent;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.c.f;
import com.duokan.reader.common.c.g;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.z;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.bd;
import com.duokan.reader.domain.cloud.cr;
import com.duokan.reader.domain.cloud.ec;
import com.duokan.reader.domain.cloud.fl;
import com.duokan.reader.domain.document.epub.DkFeature;
import com.duokan.reader.domain.downloadcenter.b;
import com.duokan.reader.domain.provider.BookshelfHelper;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.Column;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.CommonColumn;
import com.duokan.reader.domain.store.DkStoreBookCategory;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreCategory;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.a;
import com.duokan.reader.ui.personal.mx;
import com.google.android.collect.Lists;

import org.apache.http.protocol.HTTP;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

@SuppressLint({"UseSparseArrays"})
public abstract class hi implements ah, IActivityRunStatusChanged, g, h, cr, ec, fl {
    protected static final String c = (ai.class.getName() + ".asyncTaskQueue");
    static final /* synthetic */ boolean l = (!hi.class.desiredAssertionStatus());
    private WebSession A = null;
    private long B = 1;
    private long C = -10;
    private final ReentrantLock D = new ReentrantLock();
    private final ReentrantLock E = new ReentrantLock();
    private boolean F = false;
    private final CopyOnWriteArrayList G = new CopyOnWriteArrayList();
    private final BookOrderHelper H;
    private final Context a;
    private final a b;
    protected final f d;
    protected final i e;
    protected final ReaderEnv f;
    protected final n g;
    protected final ConcurrentHashMap h = new ConcurrentHashMap();
    protected iq i;
    protected ab j;
    protected final am k = new hv(this);
    private final DkCloudStorage m;
    private final b n;
    private final n o;
    private final ConcurrentHashMap p = new ConcurrentHashMap();
    private final CopyOnWriteArrayList q = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList r = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList s = new CopyOnWriteArrayList();
    private final Runnable t = new hj(this);
    private final LinkedList u = new LinkedList();
    private final List v = new ArrayList();
    private int w = 0;
    private boolean x = false;
    private LinkedList y = null;
    private boolean z = false;

    public boolean c(java.util.List r17) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r16 = this;
        r9 = 1;
        r10 = 0;
        if (r17 == 0) goto L_0x000a;
    L_0x0004:
        r2 = r17.size();
        if (r2 != 0) goto L_0x000c;
    L_0x000a:
        r2 = r10;
    L_0x000b:
        return r2;
    L_0x000c:
        r0 = r16;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = r0.getHeightPixels;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.setDrawable();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r11 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r11.<init>();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r12 = r17.iterator();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x001c:
        r2 = r12.hasNext();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r2 == 0) goto L_0x028e;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0022:
        r2 = r12.next();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = (com.duokan.reader.domain.store.DkStoreItem) r2;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = r2 instanceof com.duokan.reader.domain.store.DkStoreBookDetail;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r3 == 0) goto L_0x023e;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x002c:
        r0 = r2;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0 = (com.duokan.reader.domain.store.DkStoreBookDetail) r0;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r6 = r0;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = r6.getBook();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = r2.getBookUuid();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0 = r16;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = r0.getVisible(r2);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r2 != 0) goto L_0x001c;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0040:
        r0 = r16;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = r0.showAnimation(r6);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r2 == 0) goto L_0x00bd;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0048:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.getPrice();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r4 == 0) goto L_0x0068;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0056:
        r4 = com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager.setDrawable();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r5 = r6.getBook();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r5 = r5.getBookUuid();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.setDrawable(r5);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r4 == 0) goto L_0x009b;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0068:
        r2 = com.duokan.reader.domain.bookshelf.BookLimitType.NONE;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = r2;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x006b:
        r2 = com.duokan.reader.domain.bookshelf.BookFormat.EPUB;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = com.duokan.reader.domain.bookshelf.BookPackageType.EPUB_OPF;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r5 = com.duokan.reader.domain.bookshelf.BookType.NORMAL;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r7 = com.duokan.reader.domain.bookshelf.BookState.PULLING;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0 = r16;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = r0.getVisible(r2, r4, r5, r7);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = (com.duokan.reader.domain.bookshelf.fv) r2;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.setDrawable(r6, r3);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x007e:
        r3 = "newbie";	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.showAnimation(r3);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = 0;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.setDrawable(r3);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0 = r16;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0.getScaledPagingTouchSlop(r2);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r11.add(r2);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        goto L_0x001c;
    L_0x0090:
        r2 = move-exception;
        r0 = r16;
        r2 = r0.getHeightPixels;
        r2.getVisible();
        r2 = r10;
        goto L_0x000b;
    L_0x009b:
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.getLimitedTime();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r4 > 0) goto L_0x00b5;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x00a7:
        r4 = com.duokan.reader.domain.cloud.bd.setDrawable();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.getVisible();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.setDrawable;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r2 <= 0) goto L_0x00b9;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x00b5:
        r2 = com.duokan.reader.domain.bookshelf.BookLimitType.TIME;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = r2;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        goto L_0x006b;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x00b9:
        r2 = com.duokan.reader.domain.bookshelf.BookLimitType.CONTENT;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = r2;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        goto L_0x006b;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x00bd:
        r2 = com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager.setDrawable();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = r6.getBook();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = r3.getBookUuid();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = r2.setDrawable(r3);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r2 != 0) goto L_0x00d9;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x00cf:
        r2 = r6.getBook();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = r2.getPrice();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r2 != 0) goto L_0x01cc;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x00d9:
        r7 = r9;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x00da:
        r2 = com.duokan.reader.domain.cloud.bd.setDrawable();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = r2.getVisible();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = r2.setDrawable;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r2 <= 0) goto L_0x01cf;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x00ec:
        r5 = r9;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x00ed:
        if (r7 != 0) goto L_0x00f1;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x00ef:
        if (r5 == 0) goto L_0x01d2;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x00f1:
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0 = r16;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = r0.HttpLogger;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = r3.getCloudBookDirectory();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4.<init>();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8 = r6.getBook();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8 = r8.getBookUuid();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8 = ".";	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8 = r6.getRevision();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8 = ".epub";	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0127:
        r2 = android.net.Uri.fromFile(r2);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = r2.toString();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = com.duokan.reader.domain.bookshelf.BookFormat.EPUB;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = com.duokan.reader.domain.bookshelf.BookPackageType.EPUB;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8 = com.duokan.reader.domain.bookshelf.BookType.TRIAL;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r13 = com.duokan.reader.domain.bookshelf.BookState.CLOUD_ONLY;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0 = r16;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = r0.setDrawable(r2, r4, r8, r13);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = (com.duokan.reader.domain.bookshelf.fv) r2;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.getBookUuid();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.getScaledPagingTouchSlop(r4);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.setDrawable(r3);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r6.getRevision();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.HttpLogger(r4);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r14 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.setDrawable(r14);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.getTitle();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.o(r4);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r7 != 0) goto L_0x016a;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0168:
        if (r5 == 0) goto L_0x020a;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x016a:
        r4 = com.duokan.reader.domain.bookshelf.BookType.NORMAL;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x016c:
        r2.setDrawable(r4);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r5 == 0) goto L_0x020e;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0171:
        r4 = com.duokan.reader.domain.bookshelf.BookLimitType.TIME;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0173:
        r2.setDrawable(r4);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.isFree();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r4 == 0) goto L_0x0218;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0180:
        r4 = r10;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0181:
        r2.setDrawable(r4);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.getNameLine();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.getScaledTouchSlop(r4);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0 = r16;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r0.getVisible(r6);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.setDrawable(r4);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.getCoverUri();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.getVisible(r4);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r7 != 0) goto L_0x01a7;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x01a5:
        if (r5 == 0) goto L_0x0222;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x01a7:
        r4 = r6.getEpubUri();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r5 = r6.getRevision();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r6 = r6.getEpubMd5();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r7 = 1;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8 = new com.duokan.core.sys.af;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r13 = 1;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r13 = java.lang.Boolean.valueOf(r13);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8.<init>(r13);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.setDrawable(r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        goto L_0x007e;
    L_0x01c3:
        r2 = move-exception;
        r0 = r16;
        r3 = r0.getHeightPixels;
        r3.getVisible();
        throw r2;
    L_0x01cc:
        r7 = r10;
        goto L_0x00da;
    L_0x01cf:
        r5 = r10;
        goto L_0x00ed;
    L_0x01d2:
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0 = r16;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = r0.HttpLogger;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = r3.getCloudBookDirectory();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4.<init>();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8 = r6.getBook();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8 = r8.getBookUuid();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8 = ".";	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8 = r6.getRevision();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8 = ".trial.epub";	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        goto L_0x0127;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x020a:
        r4 = com.duokan.reader.domain.bookshelf.BookType.TRIAL;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        goto L_0x016c;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x020e:
        if (r7 == 0) goto L_0x0214;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0210:
        r4 = com.duokan.reader.domain.bookshelf.BookLimitType.NONE;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        goto L_0x0173;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0214:
        r4 = com.duokan.reader.domain.bookshelf.BookLimitType.CONTENT;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        goto L_0x0173;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0218:
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r4.getNewPrice();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        goto L_0x0181;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0222:
        r4 = r6.getTrialUri();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r5 = r6.getRevision();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r6 = r6.getTrialMd5();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r7 = 0;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8 = new com.duokan.core.sys.af;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r13 = 1;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r13 = java.lang.Boolean.valueOf(r13);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r8.<init>(r13);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2.setDrawable(r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        goto L_0x007e;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x023e:
        r3 = r2 instanceof com.duokan.reader.domain.store.DkStoreFictionDetail;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r3 == 0) goto L_0x001c;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0242:
        r2 = (com.duokan.reader.domain.store.DkStoreFictionDetail) r2;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = r2.getFiction();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = r3.getBookUuid();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0 = r16;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = r0.getVisible(r4);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = (com.duokan.reader.domain.bookshelf.ej) r3;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r3 == 0) goto L_0x0261;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0256:
        r5 = r3.getVisible(r2);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r5 == 0) goto L_0x0261;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x025c:
        r3.showAnimation(r2);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        goto L_0x001c;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0261:
        r3 = com.duokan.reader.domain.bookshelf.showAnimation.n(r4);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r3 == 0) goto L_0x028b;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0267:
        r3 = com.duokan.reader.domain.bookshelf.BookFormat.SBK;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0269:
        r4 = com.duokan.reader.domain.bookshelf.BookPackageType.DIRECTORY;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r5 = com.duokan.reader.domain.bookshelf.BookType.SERIAL;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r6 = com.duokan.reader.domain.bookshelf.BookState.NORMAL;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0 = r16;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = r0.getVisible(r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3 = (com.duokan.reader.domain.bookshelf.ej) r3;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r4 = com.duokan.reader.domain.bookshelf.BookLimitType.CONTENT;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3.setDrawable(r2, r4);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r2 = "newbie";	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r3.showAnimation(r2);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0 = r16;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0.getScaledPagingTouchSlop(r3);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r11.add(r3);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        goto L_0x001c;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x028b:
        r3 = com.duokan.reader.domain.bookshelf.BookFormat.EPUB;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        goto L_0x0269;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x028e:
        r2 = r11.size();	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        if (r2 == 0) goto L_0x029b;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x0294:
        r2 = "";	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0 = r16;	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
        r0.setDrawable(r2, r11);	 Catch:{ Throwable -> 0x0090, all -> 0x01c3 }
    L_0x029b:
        r0 = r16;
        r2 = r0.getHeightPixels;
        r2.getVisible();
        r2 = r9;
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.hi.showAnimation(java.util.List):boolean");
    }

    protected hi(Context context, ReaderEnv readerEnv, f fVar, i iVar, a aVar, DkCloudStorage dkCloudStorage, b bVar) {
        this.a = context;
        this.d = fVar;
        this.e = iVar;
        this.f = readerEnv;
        this.b = aVar;
        this.m = dkCloudStorage;
        this.n = bVar;
        File databaseDirectory = readerEnv.getDatabaseDirectory();
        this.g = new n(Uri.fromFile(new File(databaseDirectory, "Bookshelf.db")).toString(), Uri.fromFile(new File(readerEnv.getExternalFilesDirectory(), "Bookshelf.db")).toString());
        this.o = new n(Uri.fromFile(new File(databaseDirectory, "Bookshelf.cache.db")).toString(), null);
        this.H = new BookOrderHelper();
        a();
        c();
        z();
        y();
        this.x = true;
        this.j = new ab(this.e.c());
        DkApp.get().runPreReady(new ic(this));
        com.duokan.core.sys.ah.a(new ii(this), c);
    }

    public void a(iv ivVar) {
        if (l || ivVar != null) {
            this.q.addIfAbsent(ivVar);
            return;
        }
        throw new AssertionError();
    }

    public void b(iv ivVar) {
        if (l || ivVar != null) {
            this.q.remove(ivVar);
            return;
        }
        throw new AssertionError();
    }

    public void a(iw iwVar) {
        if (l || iwVar != null) {
            this.r.addIfAbsent(iwVar);
            return;
        }
        throw new AssertionError();
    }

    public void b(iw iwVar) {
        if (l || iwVar != null) {
            this.r.remove(iwVar);
            return;
        }
        throw new AssertionError();
    }

    public void a(it itVar) {
        this.s.add(itVar);
    }

    public void b(it itVar) {
        this.s.remove(itVar);
    }

    public void b() {
    }

    public void d() {
    }

    public void a(String[] strArr) {
        for (String b : strArr) {
            c b2 = b(b);
            if (b2 != null && b2.i() == BookState.CLOUD_ONLY) {
                a(b2, true);
            }
        }
    }

    public void a(List list) {
        if (this.i == null) {
            e(list);
        } else {
            this.v.addAll(list);
        }
    }

    public void e() {
    }

    public void b(String[] strArr) {
        for (String b : strArr) {
            c b2 = b(b);
            if (b2 != null && b2.i() == BookState.CLOUD_ONLY) {
                a(b2, true);
            }
        }
    }

    public void b(List list) {
        if (this.i == null) {
            e(list);
        } else {
            this.v.addAll(list);
        }
    }

    public void f() {
    }

    public void a(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
    }

    public void a(String str, DkCloudAnnotation[] dkCloudAnnotationArr) {
        c b = b(str);
        if (b != null) {
            b.a(dkCloudAnnotationArr);
            b = (c) this.h.get(Long.valueOf(b.aF()));
            if (b != null) {
                b.ar();
            }
        }
    }

    public List a(String str) {
        try {
            List arrayList;
            this.k.a();
            if (TextUtils.isEmpty(str)) {
                arrayList = new ArrayList();
            } else {
                String str2;
                String str3 = "'%" + str + "%" + "'";
                try {
                    str2 = new String(str3.getBytes(), HTTP.UTF_8);
                } catch (UnsupportedEncodingException e) {
                    str2 = str3;
                }
                arrayList = e("book_name like " + str2);
                this.k.b();
            }
            return arrayList;
        } finally {
            this.k.b();
        }
    }

    public List a(int i, BookTag bookTag) {
        String str;
        if (bookTag == null || bookTag.a() < 0) {
            str = "SELECT  _id FROM books WHERE last_reading_date > 0 ORDER BY last_reading_date desc limit 0, " + i;
        } else {
            str = "SELECT * FROM books WHERE last_reading_date > 0 AND _id IN (SELECT book_id FROM book_tag_map WHERE tag_id = " + bookTag.a() + ") ORDER BY last_reading_date DESC LIMIT 0, " + i;
        }
        return f(str);
    }

    public boolean g() {
        try {
            this.k.a();
            String str = "SELECT _id FROM books";
            Cursor a = this.g.a("SELECT _id FROM books", null);
            boolean z = !a.moveToFirst();
            a.close();
            return z;
        } finally {
            this.k.b();
        }
    }

    public int h() {
        try {
            this.k.a();
            int size = e(null).size();
            return size;
        } finally {
            this.k.b();
        }
    }

    protected c a(long j) {
        return (c) this.h.get(Long.valueOf(j));
    }

    public c b(String str) {
        ArrayList f = f(String.format("SELECT _id FROM books WHERE book_uuid == \"%s\"", new Object[]{str}));
        if (f.size() > 0) {
            return (c) f.get(0);
        }
        return null;
    }

    protected c c(String str) {
        return c("book_uri = ?", new String[]{str});
    }

    public c d(String str) {
        return c("book_uri = ?", new String[]{Uri.fromFile(new File(str)).toString()});
    }

    private c c(String str, String[] strArr) {
        String str2 = "SELECT * FROM books";
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + " WHERE " + str;
        }
        ArrayList b = b(str2, strArr);
        if (b.size() >= 1) {
            return (c) b.get(0);
        }
        return null;
    }

    public c[] i() {
        return (c[]) f("SELECT _id FROM books").toArray(new c[0]);
    }

    public c[] j() {
        return (c[]) f("SELECT _id FROM books WHERE book_type = \"SERIAL\"").toArray(new c[0]);
    }

    private void e(List list) {
        for (DkCloudStoreBook bookUuid : list) {
            if (b(bookUuid.getBookUuid()) == null) {
                PersonalPrefs.a().g(true);
                return;
            }
        }
    }

    protected ArrayList e(String str) {
        return a(str, null);
    }

    protected ArrayList a(String str, String[] strArr) {
        String str2 = "SELECT * FROM books ";
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + " WHERE " + str;
        }
        return b(str2, strArr);
    }

    protected ArrayList f(String str) {
        return b(str, null);
    }

    protected ArrayList b(String str, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.g.a(str, strArr);
            arrayList.ensureCapacity(cursor.getCount());
            while (cursor.moveToNext()) {
                c cVar = (c) this.h.get(Long.valueOf(cursor.getLong(0)));
                if (cVar != null) {
                    arrayList.add(cVar);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return arrayList;
    }

    private void a() {
        BookshelfHelper.a(this.g);
        int d = this.o.d();
        if (d < 1) {
            this.o.b();
            try {
                this.o.a(String.format("CREATE TABLE %1$s (%2$s INTEGER PRIMARY KEY, %3$s INTEGER, %4$s TEXT, %5$s TEXT, %6$s BLOB, %7$s LONG, %8$s LONG, %9$s BLOB, %10$s TEXT)", new Object[]{"typesetting", "typesetting_id", "book_id", "kernel_version", "layout_params", "pagination_result", "file_size", "modified_date", "book_digest", "content_digest"}));
                this.o.a(String.format("CREATE TABLE %1$s (%2$s INTEGER PRIMARY KEY, %3$s INTEGER, %4$s TEXT, %5$s BLOB, %6$s LONG, %7$s LONG)", new Object[]{"toc", "toc_id", "book_id", "kernel_version", "toc_data", "file_size", "modified_date"}));
                this.o.a(5);
                this.o.f();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.o.c();
            }
        } else if (d < 5) {
            this.o.b();
            if (d < 2) {
                try {
                    this.o.a(String.format("ALTER TABLE %s ADD COLUMN %s LONG DEFAULT 0", new Object[]{"typesetting", "file_size"}));
                    this.o.a(String.format("ALTER TABLE %s ADD COLUMN %s LONG DEFAULT 0", new Object[]{"typesetting", "modified_date"}));
                    this.o.a(2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                } finally {
                    this.o.c();
                }
            }
            if (d < 3) {
                this.o.a(String.format("CREATE TABLE %1$s (%2$s INTEGER PRIMARY KEY,  %3$s INTEGER,  %4$s TEXT,  %5$s BLOB,  %6$s LONG,  %7$s LONG)", new Object[]{"toc", "toc_id", "book_id", "kernel_version", "toc_data", "file_size", "modified_date"}));
                this.o.a(3);
            }
            if (d < 4) {
                this.o.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"typesetting", "book_digest"}));
            }
            if (d < 5) {
                this.o.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"typesetting", "content_digest"}));
            }
            this.o.f();
            this.o.c();
        }
    }

    private void c() {
        Cursor a;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT ");
            for (CommonColumn commonColumn : CommonColumn.values()) {
                if (commonColumn.ordinal() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(commonColumn.toString());
            }
            stringBuilder.append(" FROM books");
            a = this.g.a(stringBuilder.toString(), null);
            while (a.moveToNext()) {
                c a2 = a(a);
                this.B = Math.max(this.B, a2.aF());
                this.h.put(Long.valueOf(a2.aF()), a2);
            }
            a.close();
        } catch (Throwable th) {
        }
    }

    private void y() {
        aa l = l();
        this.H.init(l);
        l.aO();
        for (an anVar : this.p.values()) {
            if (!(anVar == l || anVar.f() <= 0 || l.c(anVar))) {
                l.a(l.f(), anVar);
                l.aL();
            }
        }
        if (this.p.size() == 1 && l.f() == 0 && this.h.size() > 0) {
            int i = 0;
            for (an anVar2 : this.h.values()) {
                int i2;
                if (this.p.contains(Long.valueOf(anVar2.aH()))) {
                    i2 = i;
                } else {
                    l.a(0, anVar2);
                    i2 = i + 1;
                }
                i = i2;
            }
            if (i > 0) {
                l.aL();
            }
        }
    }

    private void z() {
        Cursor a = this.g.a(String.format("SELECT _id FROM %1$s", new Object[]{"book_categories"}), null);
        if (a != null) {
            while (a.moveToNext()) {
                long j = a.getLong(0);
                aa aaVar = new aa(this.k, j, true);
                this.p.put(Long.valueOf(aaVar.aF()), aaVar);
                this.C = Math.min(this.C, j);
            }
            a.close();
        }
    }

    protected static String a(String str, iy iyVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(File.separator);
        stringBuilder.append(tools.substring(iyVar.b()));
        stringBuilder.append("_");
        stringBuilder.append(Md5Util.encryption(iyVar.e()));
        stringBuilder.append("_");
        stringBuilder.append(iyVar.d());
        stringBuilder.append(File.separator);
        stringBuilder.append(iyVar.b());
        return new File(stringBuilder.toString()).getAbsolutePath();
    }

    private String a(iy iyVar) {
        return a(this.f.getMiCloudBookDirectory().getAbsolutePath(), iyVar);
    }

    public c a(DkStoreBookDetail dkStoreBookDetail) {
        try {
            this.k.a();
            c b = b(dkStoreBookDetail.getBook().getBookUuid());
            if (b == null) {
                BookLimitType bookLimitType;
                long currentTimeMillis = System.currentTimeMillis();
                if (dkStoreBookDetail.getBook().getPrice() == 0 || DkUserPurchasedBooksManager.a().a(dkStoreBookDetail.getBook().getBookUuid()) != null) {
                    bookLimitType = BookLimitType.NONE;
                } else if (dkStoreBookDetail.getBook().getLimitedTime() > currentTimeMillis || bd.a().b().a > currentTimeMillis) {
                    bookLimitType = BookLimitType.TIME;
                } else {
                    bookLimitType = BookLimitType.CONTENT;
                }
                b = (fv) b(BookFormat.EPUB, BookPackageType.EPUB_OPF, BookType.NORMAL, BookState.PULLING);
                b.a(dkStoreBookDetail, bookLimitType);
                b.a(null);
                e(b);
                this.k.b();
            }
            return b;
        } finally {
            this.k.b();
        }
    }

    public c a(DkStoreFictionDetail dkStoreFictionDetail) {
        try {
            this.k.a();
            if (l || dkStoreFictionDetail != null) {
                String bookUuid = dkStoreFictionDetail.getFiction().getBookUuid();
                c cVar = (ej) b(bookUuid);
                if (cVar == null || !cVar.b(dkStoreFictionDetail)) {
                    cVar = (ej) b(c.n(bookUuid) ? BookFormat.SBK : BookFormat.EPUB, BookPackageType.DIRECTORY, BookType.SERIAL, BookState.NORMAL);
                    cVar.a(dkStoreFictionDetail, BookLimitType.CONTENT);
                    e(cVar);
                    this.k.b();
                    return cVar;
                }
                cVar.c(dkStoreFictionDetail);
                return cVar;
            }
            throw new AssertionError();
        } finally {
            this.k.b();
        }
    }

    public c a(DkStoreBookDetail dkStoreBookDetail, z zVar, af afVar) {
        try {
            this.k.a();
            if (l || dkStoreBookDetail != null) {
                UmengManager.get().onEvent("V2_SHELF_IMPORT_BOOK", "DuokanBook");
                a(dkStoreBookDetail, zVar);
                c b = b(dkStoreBookDetail, zVar, afVar);
                return b;
            }
            throw new AssertionError();
        } finally {
            this.k.b();
        }
    }

    public c a(DkStoreItem dkStoreItem) {
        c cVar = null;
        if (dkStoreItem != null) {
            if (dkStoreItem instanceof DkStoreBookDetail) {
                DkStoreBookDetail dkStoreBookDetail = (DkStoreBookDetail) dkStoreItem;
                cVar = b(dkStoreBookDetail.getBook().getBookUuid());
                if (cVar == null) {
                    if (c(dkStoreBookDetail)) {
                        cVar = a(dkStoreBookDetail);
                    } else {
                        cVar = a(dkStoreBookDetail, new af(Boolean.valueOf(true)));
                    }
                }
            } else if (dkStoreItem instanceof DkStoreFictionDetail) {
                DkStoreFictionDetail dkStoreFictionDetail = (DkStoreFictionDetail) dkStoreItem;
                cVar = b(dkStoreFictionDetail.getFiction().getBookUuid());
                if (cVar == null) {
                    cVar = a(dkStoreFictionDetail);
                }
            }
            if (cVar != null && cVar.aG()) {
                a("", cVar);
            }
        }
        return cVar;
    }

    public c a(DkStoreBookDetail dkStoreBookDetail, af afVar) {
        return a(dkStoreBookDetail, 0, afVar);
    }

    public c a(DkStoreBookDetail dkStoreBookDetail, int i, af afVar) {
        int i2 = 0;
        try {
            this.k.a();
            c b = b(dkStoreBookDetail.getBook().getBookUuid());
            if (b == null) {
                int i3;
                File file;
                int i4 = (DkUserPurchasedBooksManager.a().a(dkStoreBookDetail.getBook().getBookUuid()) != null || dkStoreBookDetail.getBook().getPrice() == 0) ? 1 : 0;
                if (bd.a().b().a > System.currentTimeMillis()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i4 == 0 && i3 == 0) {
                    file = new File(this.f.getCloudBookDirectory(), dkStoreBookDetail.getBook().getBookUuid() + "." + dkStoreBookDetail.getRevision() + ".trial.epub");
                } else {
                    file = new File(this.f.getCloudBookDirectory(), dkStoreBookDetail.getBook().getBookUuid() + "." + dkStoreBookDetail.getRevision() + ".epub");
                }
                FileUtils.deleteFile(file);
                String uri = Uri.fromFile(file).toString();
                b = (fv) a(BookFormat.EPUB, BookPackageType.EPUB, BookType.TRIAL, BookState.CLOUD_ONLY);
                b.e(dkStoreBookDetail.getBook().getBookUuid());
                b.a(uri);
                b.f(dkStoreBookDetail.getRevision());
                b.a(System.currentTimeMillis());
                b.o(dkStoreBookDetail.getBook().getTitle());
                BookType bookType = (i4 == 0 && i3 == 0) ? BookType.TRIAL : BookType.NORMAL;
                b.a(bookType);
                BookLimitType bookLimitType = i3 != 0 ? BookLimitType.TIME : i4 != 0 ? BookLimitType.NONE : BookLimitType.CONTENT;
                b.a(bookLimitType);
                if (!dkStoreBookDetail.getBook().isFree()) {
                    i2 = dkStoreBookDetail.getBook().getNewPrice();
                }
                b.a(i2);
                b.d(dkStoreBookDetail.getBook().getNameLine());
                b.a(b(dkStoreBookDetail));
                b.b(dkStoreBookDetail.getBook().getCoverUri());
                e(b);
                a("", i, b);
                if (i4 == 0 && i3 == 0) {
                    b.a(uri, dkStoreBookDetail.getTrialUri(), dkStoreBookDetail.getRevision(), dkStoreBookDetail.getTrialMd5(), false, afVar);
                } else {
                    b.a(uri, dkStoreBookDetail.getEpubUri(), dkStoreBookDetail.getRevision(), dkStoreBookDetail.getEpubMd5(), true, afVar);
                }
                b.a(null);
                this.k.b();
            }
            return b;
        } finally {
            this.k.b();
        }
    }

    public c a(iy iyVar, af afVar) {
        try {
            this.k.a();
            if (iyVar == null) {
                return null;
            }
            c b = b(b(iyVar), iyVar, afVar);
            this.k.b();
            return b;
        } finally {
            this.k.b();
        }
    }

    public c a(c cVar, iy iyVar, af afVar) {
        try {
            this.k.a();
            c b = b(cVar, iyVar, afVar);
            return b;
        } finally {
            this.k.b();
        }
    }

    public List a(List list, boolean z) {
        LinkedList linkedList = new LinkedList();
        if (list == null || list.size() <= 0) {
            return linkedList;
        }
        try {
            this.k.a();
            this.g.b();
            for (File absolutePath : list) {
                String absolutePath2 = absolutePath.getAbsolutePath();
                c d = d(absolutePath2);
                if (d != null) {
                    linkedList.add(d);
                } else {
                    d = a(absolutePath2, false);
                    linkedList.add(d);
                    if (d.ao() != -1) {
                        continue;
                    } else {
                        a(z ? d.d().getParentFile().getName() : "", d);
                    }
                }
            }
            this.g.f();
            this.g.c();
        } catch (Exception e) {
            e.printStackTrace();
            this.g.c();
        } catch (Throwable th) {
            this.k.b();
            x();
            return linkedList;
        }
        this.k.b();
        x();
        return linkedList;
    }

    public c a(File file) {
        c d = d(file.getPath());
        return d != null ? d : a(file.getPath(), true);
    }

    public List a(File... fileArr) {
        return a(Arrays.asList(fileArr), false);
    }

    protected c a(DkStoreBookDetail dkStoreBookDetail, DkCloudBookManifest dkCloudBookManifest) {
        try {
            this.k.a();
            c b = b(dkStoreBookDetail.getBook().getBookUuid());
            if (b != null) {
                return b;
            }
            int i;
            File file = new File(this.f.getCloudBookDirectory(), dkStoreBookDetail.getBook().getBookUuid() + "." + dkCloudBookManifest.getBookRevision() + ".epub");
            DkPublic.rm(file);
            String uri = Uri.fromFile(file).toString();
            c a = a(BookFormat.EPUB, BookPackageType.EPUB, BookType.NORMAL, BookState.CLOUD_ONLY);
            a.e(dkStoreBookDetail.getBook().getBookUuid());
            a.a(uri);
            a.b(dkStoreBookDetail.getEpubSize());
            a.f(dkCloudBookManifest.getBookRevision());
            a.a(System.currentTimeMillis());
            a.o(dkStoreBookDetail.getBook().getTitle());
            a.a(BookType.NORMAL);
            if (dkStoreBookDetail.getBook().isFree()) {
                i = 0;
            } else {
                i = dkStoreBookDetail.getBook().getNewPrice();
            }
            a.a(i);
            a.d(dkStoreBookDetail.getBook().getNameLine());
            a.a(b(dkStoreBookDetail));
            a.b(dkStoreBookDetail.getBook().getCoverUri());
            if (PersonalPrefs.a().y()) {
                dg a2 = dh.a().a(a.ao(), a.ap());
                if (a2 != null) {
                    a.d(a2.c);
                }
            }
            e(a);
            z bookCertification = dkCloudBookManifest.getBookCertification();
            if (bookCertification != null && bookCertification.b.length > 0 && bookCertification.c.length > 0) {
                a.a(new ad(this.f.getDeviceIdVersion(), bookCertification.a, o.a(bookCertification.b) + "\n" + o.a(bookCertification.c), 0));
                a.a(BookLimitType.NONE);
            }
            a("", a);
            this.k.b();
            return a;
        } finally {
            this.k.b();
        }
    }

    private c a(DkStoreBookDetail dkStoreBookDetail, z zVar) {
        c b = b(dkStoreBookDetail.getBook().getBookUuid());
        if (b != null) {
            a(b, true);
        }
        File file = new File(this.f.getCloudBookDirectory(), dkStoreBookDetail.getBook().getBookUuid() + "." + dkStoreBookDetail.getRevision() + ".epub");
        DkPublic.rm(file);
        String uri = Uri.fromFile(file).toString();
        c a = a(BookFormat.EPUB, BookPackageType.EPUB, BookType.NORMAL, BookState.CLOUD_ONLY);
        a.e(dkStoreBookDetail.getBook().getBookUuid());
        a.a(uri);
        a.b(dkStoreBookDetail.getEpubSize());
        a.f(dkStoreBookDetail.getRevision());
        a.a(System.currentTimeMillis());
        a.o(dkStoreBookDetail.getBook().getTitle());
        a.a(BookLimitType.TIME);
        a.a(dkStoreBookDetail.getBook().isFree() ? 0 : dkStoreBookDetail.getBook().getNewPrice());
        a.d(dkStoreBookDetail.getBook().getNameLine());
        a.a(b(dkStoreBookDetail));
        a.b(dkStoreBookDetail.getBook().getCoverUri());
        if (PersonalPrefs.a().y()) {
            dg a2 = dh.a().a(a.ao(), a.ap());
            if (a2 != null) {
                a.d(a2.c);
            }
        }
        e(a);
        a.a(new ad(this.f.getDeviceIdVersion(), 100, o.a(zVar.b) + "\n" + o.a(zVar.c), zVar.d));
        a("", a);
        return a;
    }

    private void a(c cVar, String str) {
        t.a(new ij(this, cVar, str));
    }

    private boolean g(c cVar) {
        if (!PersonalPrefs.a().y() || cVar.ao() == -1) {
            return false;
        }
        if (cVar.o() == BookType.TRIAL && DkUserPurchasedBooksManager.a().a(cVar.H()) == null) {
            return false;
        }
        return true;
    }

    private c b(DkStoreBookDetail dkStoreBookDetail, z zVar, af afVar) {
        try {
            this.k.a();
            c b = b(dkStoreBookDetail.getBook().getBookUuid());
            if (b == null) {
                this.k.b();
                return b;
            }
            int i;
            File file = new File(this.f.getCloudBookDirectory(), dkStoreBookDetail.getBook().getBookUuid() + "." + dkStoreBookDetail.getRevision() + ".epub");
            DkPublic.rm(file);
            b.a(Uri.fromFile(file).toString());
            b.b(dkStoreBookDetail.getEpubSize());
            b.f(dkStoreBookDetail.getRevision());
            if (dkStoreBookDetail.getBook().isFree()) {
                i = 0;
            } else {
                i = dkStoreBookDetail.getBook().getNewPrice();
            }
            b.a(i);
            b.d(dkStoreBookDetail.getBook().getNameLine());
            b.a(b(dkStoreBookDetail));
            f(b);
            b.a(new ad(this.f.getDeviceIdVersion(), 100, o.a(zVar.b) + "\n" + o.a(zVar.c), zVar.d));
            this.g.b();
            b.aM();
            this.g.f();
            this.g.c();
            b.a(b.f(), dkStoreBookDetail.getEpubUri(), dkStoreBookDetail.getRevision(), dkStoreBookDetail.getEpubMd5(), true, afVar);
            x();
            this.k.b();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            this.g.c();
            this.k.b();
            return null;
        } catch (Throwable th) {
            this.k.b();
        }
    }

    private c b(iy iyVar) {
        File file = new File(a(iyVar));
        String uri = Uri.fromFile(file).toString();
        c c = c(uri);
        if (c == null) {
            BookPackageType bookPackageType;
            DkPublic.rm(file);
            BookFormat q = c.q(tools.substringwerCase(iyVar.b()).toUpperCase(Locale.US));
            switch (ib.a[q.ordinal()]) {
                case 1:
                    bookPackageType = BookPackageType.EPUB;
                    break;
                case 2:
                    bookPackageType = BookPackageType.PDF;
                    break;
                default:
                    bookPackageType = BookPackageType.TXT;
                    break;
            }
            c = a(q, bookPackageType, BookType.NORMAL, BookState.CLOUD_ONLY);
            c.a(uri);
            c.a(System.currentTimeMillis());
            c.o(tools.getHeight(iyVar.a().l()));
            c.a(BookType.NORMAL);
            c.b(iyVar.d());
            c.a(new ab());
            c.a(iyVar);
            e(c);
            if (PersonalPrefs.a().y()) {
                dg a = dh.a().a(c.ao(), c.ap());
                if (a != null) {
                    c.d(a.c);
                }
            }
            c.a(new js(c.q(), null));
            a("", c);
        }
        return c;
    }

    private c b(c cVar, iy iyVar, af afVar) {
        if (iyVar == null) {
            return null;
        }
        if (cVar.ak() == null) {
            return null;
        }
        if (!cVar.ak().f().equals(iyVar.f())) {
            return null;
        }
        if (a(cVar.aF()) == null) {
            return null;
        }
        File file = new File(cVar.e());
        if (cVar.i() == BookState.NORMAL && file.exists()) {
            return cVar;
        }
        File file2 = new File(a(cVar.ak()));
        String uri = Uri.fromFile(file2).toString();
        DkPublic.rm(file2);
        cVar.a(iyVar);
        cVar.a(uri);
        this.g.b();
        try {
            cVar.aM();
            this.g.f();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            uri = this.g;
            uri.c();
        }
        cVar.a(uri, "kuaipan:///" + cVar.ak().f() + "?info=" + iyVar.a().a(), "", "", true, afVar);
        x();
        return cVar;
    }

    private c a(String str, boolean z) {
        c cVar;
        BookPackageType bookPackageType;
        File file = new File(str);
        String j = j(str);
        String name = file.getName();
        Iterator it = a(Column.FILE_SIZE + "=?", new String[]{String.valueOf(file.length())}).iterator();
        while (it.hasNext()) {
            cVar = (c) it.next();
            if (cVar.ao() == 3 && cVar.ak().b().equals(name)) {
                cVar.a(str, j);
                break;
            }
        }
        BookFormat q = c.q(tools.substringwerCase(str).toUpperCase(Locale.US));
        switch (ib.a[q.ordinal()]) {
            case 1:
                bookPackageType = BookPackageType.EPUB;
                break;
            case 2:
                bookPackageType = BookPackageType.PDF;
                break;
            default:
                bookPackageType = BookPackageType.TXT;
                break;
        }
        if (z) {
            cVar = b(q, bookPackageType, BookType.NORMAL, BookState.NORMAL);
        } else {
            cVar = a(q, bookPackageType, BookType.NORMAL, BookState.NORMAL);
        }
        cVar.e(j);
        cVar.a(Uri.fromFile(file).toString());
        cVar.a(System.currentTimeMillis());
        cVar.a(BookType.NORMAL);
        cVar.b(file.length());
        cVar.a(new ab());
        e(cVar);
        cVar.x();
        if (TextUtils.isEmpty(cVar.aw())) {
            cVar.o(tools.getHeight(str));
        }
        cVar.a(new js(cVar.q(), null));
        return cVar;
    }

    private c b(BookFormat bookFormat, BookPackageType bookPackageType, BookType bookType, BookState bookState) {
        return a(A(), bookFormat, bookPackageType, bookType, bookState, true);
    }

    protected c a(BookFormat bookFormat, BookPackageType bookPackageType, BookType bookType, BookState bookState) {
        return a(A(), bookFormat, bookPackageType, bookType, bookState, false);
    }

    private c a(long j, BookFormat bookFormat, BookPackageType bookPackageType, BookType bookType, BookState bookState, boolean z) {
        c fvVar;
        switch (ib.a[bookFormat.ordinal()]) {
            case 1:
                fvVar = new fv(this.k, j, bookPackageType, bookType, bookState, z, false);
                break;
            case 2:
                fvVar = new jp(this.k, j, bookPackageType, bookType, bookState, z, false);
                break;
            case 5:
                fvVar = new jv(this.k, j, bookPackageType, bookType, bookState, z, false);
                break;
            default:
                fvVar = new lb(this.k, j, bookPackageType, bookType, bookState, z, false);
                break;
        }
        this.g.b();
        try {
            this.g.a("DELETE FROM annotations WHERE book_id = ?", new String[]{fvVar.aF() + ""});
            this.g.f();
        } catch (Exception e) {
        } finally {
            this.g.c();
        }
        fvVar.at();
        return fvVar;
    }

    private c a(Cursor cursor) {
        c fvVar;
        switch (ib.a[c.q(cursor.getString(CommonColumn.BOOK_FORMAT.ordinal())).ordinal()]) {
            case 1:
                fvVar = new fv(this.k, cursor);
                break;
            case 2:
                fvVar = new jp(this.k, cursor);
                break;
            case 5:
                fvVar = new jv(this.k, cursor);
                break;
            default:
                fvVar = new lb(this.k, cursor);
                break;
        }
        if (fvVar.s() == BookPackageType.EPUB_OPF && (fvVar.i() == BookState.PULLING || fvVar.i() == BookState.UPDATING)) {
            fvVar.aO();
        }
        return fvVar;
    }

    private String j(String str) {
        return DkUtils.calcUniversalBookId(str);
    }

    protected void a(String str, int i, List list) {
        try {
            aa l;
            Object obj;
            this.k.a();
            if (TextUtils.isEmpty(str)) {
                l = l();
                obj = null;
            } else {
                aa g = g(str);
                if (g != null) {
                    l = g;
                    obj = null;
                } else {
                    l = h(str);
                    int i2 = 1;
                }
            }
            for (an anVar : list) {
                l.a(i, anVar);
                anVar.aN();
                this.h.put(Long.valueOf(anVar.aF()), anVar);
            }
            this.g.b();
            for (c aM : list) {
                aM.aM();
            }
            l.aM();
            if (obj != null) {
                l().aM();
            }
            this.g.f();
            this.g.c();
        } catch (Throwable e) {
            com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "shelf", "an exception occurs", e);
            this.g.c();
        } catch (Throwable th) {
            this.k.b();
        }
        this.k.b();
    }

    public void a(String str, c cVar) {
        a(str, 0, cVar);
    }

    public void a(String str, int i, c cVar) {
        a(str, i, Lists.newArrayList(cVar));
    }

    public void a(String str, List list) {
        a(str, 0, list);
    }

    public void a(c cVar, boolean z) {
        try {
            this.k.a();
            b(Arrays.asList(new c[]{cVar}), z);
        } finally {
            this.k.b();
        }
    }

    public void b(List list, boolean z) {
        try {
            this.k.a();
            c(list, z);
            C();
            x();
        } finally {
            this.k.b();
        }
    }

    public void k() {
        try {
            this.k.a();
            new ik(this).open();
        } finally {
            this.k.b();
        }
    }

    private void c(List list, boolean z) {
        this.g.b();
        try {
            for (c cVar : list) {
                String H;
                a(cVar, a((an) cVar), z);
                com.duokan.reader.domain.statistics.dailystats.a d = com.duokan.reader.domain.statistics.dailystats.a.d();
                if (cVar.ai()) {
                    H = cVar.H();
                } else {
                    H = cVar.aw();
                }
                d.a(H, cVar.G().c);
            }
            this.g.f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.g.c();
        }
    }

    private void a(c cVar, aa aaVar, boolean z) {
        if (this.h.containsKey(Long.valueOf(cVar.aF()))) {
            this.g.b();
            try {
                if (cVar.V()) {
                    cVar.ab();
                } else if (cVar.T()) {
                    com.duokan.reader.domain.micloud.i b = iz.a().b(cVar.e());
                    if (b != null) {
                        iz.a().a(b);
                    }
                }
                cVar.ah();
                if (z && cVar.ad()) {
                    FileUtils.deleteFile(cVar.d());
                }
                aaVar.b(cVar);
                aaVar.aM();
                this.g.a(String.format("DELETE FROM %1$s WHERE _id = %2$s", new Object[]{"books", Long.valueOf(cVar.aF())}));
                this.h.remove(Long.valueOf(cVar.aF()));
                this.g.f();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.g.c();
            }
            h(cVar);
            MiuiAssistContent.delete(cVar);
        }
    }

    private void h(c cVar) {
        t.a(new il(this, cVar));
    }

    public void a(c[] cVarArr, aa aaVar) {
        a(cVarArr, aaVar, null);
    }

    public void a(c[] cVarArr, aa aaVar, Runnable runnable) {
        try {
            this.k.a();
            this.g.b();
            HashSet hashSet = new HashSet();
            for (an anVar : cVarArr) {
                aa a = a(anVar);
                a.b(anVar);
                aaVar.a(0, anVar);
                hashSet.add(a);
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((aa) it.next()).aM();
            }
            aaVar.aM();
            this.g.f();
            if (runnable != null) {
                runnable.run();
            }
            this.g.c();
        } catch (Throwable th) {
            this.k.b();
        }
        n();
        x();
        a(aaVar.k(), Arrays.asList(cVarArr));
        this.k.b();
    }

    public aa b(long j) {
        return (aa) this.p.get(Long.valueOf(j));
    }

    public aa a(an anVar) {
        for (aa aaVar : this.p.values()) {
            if (aaVar.c(anVar)) {
                return aaVar;
            }
        }
        return null;
    }

    public aa l() {
        return b(-9);
    }

    public List m() {
        List linkedList = new LinkedList();
        aa l = l();
        linkedList.add(l);
        for (an anVar : l.i()) {
            if (anVar instanceof aa) {
                linkedList.add((aa) anVar);
            }
        }
        return linkedList;
    }

    public aa g(String str) {
        for (aa aaVar : this.p.values()) {
            if (aaVar.k().equals(str)) {
                return aaVar;
            }
        }
        return null;
    }

    public aa h(String str) {
        try {
            this.k.a();
            aa a = a(l().f(), str);
            return a;
        } finally {
            this.k.b();
        }
    }

    public aa a(int i, String str) {
        Throwable th;
        try {
            this.k.a();
            an g = g(str);
            if (g != null) {
                this.k.b();
                return g;
            }
            aa aaVar;
            this.g.b();
            try {
                aaVar = new aa(this.k, B(), false);
                try {
                    aaVar.o(str);
                    aa l = l();
                    int max = Math.max(0, Math.min(i, l.f()));
                    l.a(max, (an) aaVar);
                    this.p.put(Long.valueOf(aaVar.aF()), aaVar);
                    this.H.addCategory(l, aaVar, max);
                    aaVar.aM();
                    l.aM();
                    this.g.f();
                    this.g.c();
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    this.g.c();
                    this.k.b();
                    return aaVar;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                aaVar = g;
                th = th4;
                th.printStackTrace();
                this.g.c();
                this.k.b();
                return aaVar;
            }
            this.k.b();
            return aaVar;
        } catch (Throwable th5) {
            this.k.b();
        }
    }

    private long A() {
        long j = this.B + 1;
        this.B = j;
        return j;
    }

    private long B() {
        long j = this.C - 1;
        this.C = j;
        return j;
    }

    public boolean a(aa aaVar, String str) {
        try {
            this.k.a();
            if (com.duokan.reader.common.b.a(aaVar.k(), str)) {
                this.k.b();
                return true;
            } else if (g(str) != null) {
                return false;
            } else {
                aaVar.o(str);
                aaVar.aL();
                a(str, Arrays.asList(aaVar.d()));
                this.k.b();
                return true;
            }
        } finally {
            this.k.b();
        }
    }

    private void a(String str, Collection collection) {
        t.a(new im(this, collection, str));
    }

    public void a(aa aaVar, boolean z, boolean z2) {
        try {
            this.k.a();
            a(aaVar, z);
            if (z2) {
                x();
            }
            this.k.b();
        } catch (Throwable th) {
            this.k.b();
        }
    }

    public void n() {
        int i = 0;
        try {
            this.k.a();
            this.g.b();
            for (aa aaVar : this.p.values()) {
                if (aaVar.c()) {
                    i++;
                    a(aaVar, true, false);
                }
                i = i;
            }
            this.g.f();
            if (i > 0) {
                x();
            }
            this.g.c();
        } catch (Exception e) {
            e.printStackTrace();
            this.g.c();
        } catch (Throwable th) {
            this.k.b();
        }
        this.k.b();
    }

    private void a(aa aaVar, boolean z) {
        this.g.b();
        try {
            for (an anVar : aaVar.e()) {
                if (anVar instanceof aa) {
                    a((aa) anVar, z);
                } else if (anVar instanceof c) {
                    a((c) anVar, aaVar, z);
                }
            }
            l().b(aaVar);
            l().aM();
            if (!aaVar.h()) {
                this.g.a(String.format("DELETE FROM %1$s WHERE _id = %2$s", new Object[]{"book_categories", Long.valueOf(aaVar.aF())}));
                this.p.remove(Long.valueOf(aaVar.aF()));
            }
            this.g.f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.g.c();
        }
    }

    private void C() {
        this.g.b();
        try {
            for (aa aaVar : this.p.values()) {
                if (aaVar.c()) {
                    a(aaVar, true);
                }
            }
            this.g.f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.g.c();
        }
    }

    public void a(iu iuVar) {
        try {
            this.k.a();
            if (iuVar != null) {
                if (this.i != null) {
                    iuVar.a();
                }
                this.G.addIfAbsent(iuVar);
            }
            this.k.b();
        } catch (Throwable th) {
            this.k.b();
        }
    }

    public void b(iu iuVar) {
        try {
            this.k.a();
            this.G.remove(iuVar);
        } finally {
            this.k.b();
        }
    }

    protected void o() {
        try {
            this.k.a();
            if (this.i == null) {
                this.i = new iq(this);
                Iterator it = this.G.iterator();
                while (it.hasNext()) {
                    ((iu) it.next()).a();
                }
                this.k.b();
            }
        } finally {
            this.k.b();
        }
    }

    protected void p() {
        try {
            this.k.a();
            if (this.i != null) {
                r();
                this.i = null;
                Iterator it = this.G.iterator();
                while (it.hasNext()) {
                    ((iu) it.next()).b();
                }
                this.k.b();
            }
        } finally {
            this.k.b();
        }
    }

    protected void i(String str) {
        try {
            this.k.a();
            if (this.i != null) {
                this.i = null;
                r();
                Iterator it = this.G.iterator();
                while (it.hasNext()) {
                    ((iu) it.next()).a(str);
                }
                this.k.b();
            }
        } finally {
            this.k.b();
        }
    }

    public boolean q() {
        try {
            this.k.a();
            if (this.F) {
                return false;
            }
            this.F = true;
            this.k.b();
            return true;
        } finally {
            this.k.b();
        }
    }

    public void r() {
        try {
            this.k.a();
            this.F = false;
            e(this.v);
            this.v.clear();
        } finally {
            this.k.b();
        }
    }

    public void s() {
        try {
            this.k.a();
            if (this.i != null) {
                this.i.cancel(false);
                this.i = null;
                r();
                Iterator it = this.G.iterator();
                while (it.hasNext()) {
                    ((iu) it.next()).a("");
                }
                this.k.b();
            }
        } finally {
            this.k.b();
        }
    }

    public void a(aa aaVar, an anVar, int i) {
        if (ReaderEnv.get().getBookShelfType() == BookShelfType.Simple) {
            this.H.moveItem(aaVar, anVar, i);
        } else {
            aaVar.a(anVar, i);
        }
    }

    protected void t() {
        t.b(new in(this));
    }

    protected void a(jl jlVar) {
        int i;
        int i2;
        ArrayList D = D();
        ArrayList arrayList = new ArrayList();
        Iterator it = D.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            iy b = iz.b(cVar, jlVar.c());
            if (b != null) {
                cVar.a(b);
                arrayList.add(cVar);
            }
        }
        if (!arrayList.isEmpty()) {
            int i3;
            for (i = 0; i < arrayList.size(); i = i3) {
                this.k.a();
                this.g.b();
                i2 = 0;
                i3 = i;
                while (i3 < arrayList.size() && i2 < 50) {
                    try {
                        ((c) arrayList.get(i3)).aL();
                        i3++;
                        i2++;
                    } catch (Throwable th) {
                        this.k.b();
                    }
                }
                this.g.f();
                this.g.c();
                this.k.b();
            }
        }
        D = E();
        HashMap hashMap = new HashMap();
        Iterator it2 = D.iterator();
        i2 = 0;
        while (it2.hasNext()) {
            cVar = (c) it2.next();
            ArrayList arrayList2 = (ArrayList) hashMap.get(cVar.ap());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(1);
                hashMap.put(cVar.ap(), arrayList2);
                arrayList = arrayList2;
            } else {
                arrayList = arrayList2;
            }
            c cVar2 = arrayList.size() == 0 ? null : (c) arrayList.get(0);
            if (cVar2 == null) {
                arrayList.add(cVar);
                i = i2;
            } else if (cVar2.i() != BookState.NORMAL) {
                arrayList.add(0, cVar);
                i = 1;
            } else if (cVar.i() != BookState.NORMAL) {
                arrayList.add(cVar);
                i = 1;
            } else if (cVar.an()) {
                arrayList.add(cVar);
                i = 1;
            } else {
                arrayList.add(0, cVar);
                i = 1;
            }
            i2 = i;
        }
        if (i2 != 0) {
            try {
                this.k.a();
                this.g.b();
                for (ArrayList D2 : hashMap.values()) {
                    for (int i4 = 1; i4 < D2.size(); i4++) {
                        a((c) D2.get(i4));
                    }
                }
                this.g.f();
                this.g.c();
                this.k.b();
            } catch (Throwable th2) {
                this.k.b();
            }
        }
    }

    protected final ab b(DkStoreBookDetail dkStoreBookDetail) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (DkStoreBookCategory dkStoreBookCategory : dkStoreBookDetail.getCategories()) {
            stringBuffer.append(dkStoreBookCategory.getLabel());
            stringBuffer2.append(dkStoreBookCategory.getCategoryId());
            for (DkStoreCategory dkStoreCategory : dkStoreBookCategory.getChildBookCategories()) {
                stringBuffer.append("-");
                stringBuffer.append(dkStoreCategory.getLabel());
                stringBuffer2.append("-");
                stringBuffer2.append(dkStoreCategory.getCategoryId());
            }
            stringBuffer.append(",");
            stringBuffer2.append(",");
        }
        if (stringBuffer.length() >= 1) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        if (stringBuffer2.length() >= 1) {
            stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
        }
        return new ab(dkStoreBookDetail.getCopyright(), "", "", dkStoreBookDetail.getSummary(), dkStoreBookDetail.getHasAds(), dkStoreBookDetail.getAdTime(), dkStoreBookDetail.getWebUrl(), TextUtils.join(",", dkStoreBookDetail.getBookTags()), dkStoreBookDetail.getDistricts(), dkStoreBookDetail.getCopyrightId(), stringBuffer.toString(), stringBuffer2.toString());
    }

    protected c a(bu buVar, DkCloudPurchasedFiction dkCloudPurchasedFiction, long j) {
        c b = b(dkCloudPurchasedFiction.getBookUuid());
        if (b != null) {
            if (b.ax() < j) {
                b.d(j);
            }
            b.aL();
        } else {
            String bookUuid = dkCloudPurchasedFiction.getBookUuid();
            b = (ej) a(c.n(bookUuid) ? BookFormat.SBK : BookFormat.EPUB, BookPackageType.DIRECTORY, BookType.SERIAL, BookState.CLOUD_ONLY);
            b.e(bookUuid);
            b.a(Uri.fromFile(new File(this.f.getCloudBookDirectory(), dkCloudPurchasedFiction.getBookUuid())).toString());
            b.o(dkCloudPurchasedFiction.getTitle());
            b.a(buVar.e);
            b.d(j);
            BookContent bookContent = c.n(bookUuid) ? dkCloudPurchasedFiction.isVerticalComic() ? BookContent.VERTICAL_COMIC : BookContent.PAGE_COMIC : BookContent.NORMAL;
            b.a(bookContent);
            b.a(0);
            b.d(dkCloudPurchasedFiction.getAuthorLine());
            b.b(dkCloudPurchasedFiction.getCoverUri());
            b.c(null);
            e(b);
            a(buVar.c, b);
        }
        return b;
    }

    protected c a(bu buVar, iy iyVar, long j) {
        try {
            this.k.a();
            String uri = Uri.fromFile(new File(a(iyVar))).toString();
            c c = c(uri);
            if (c != null) {
                if (c.ax() < j) {
                    c.d(j);
                }
                c.aL();
            } else {
                BookPackageType bookPackageType;
                BookFormat q = c.q(tools.substringwerCase(iyVar.b()).toUpperCase(Locale.US));
                switch (ib.a[q.ordinal()]) {
                    case 1:
                        bookPackageType = BookPackageType.EPUB;
                        break;
                    case 2:
                        bookPackageType = BookPackageType.PDF;
                        break;
                    default:
                        bookPackageType = BookPackageType.TXT;
                        break;
                }
                c = a(q, bookPackageType, BookType.NORMAL, BookState.CLOUD_ONLY);
                c.a(uri);
                c.a(buVar.e);
                c.d(j);
                c.o(tools.getHeight(iyVar.a().l()));
                c.a(BookType.NORMAL);
                c.b(iyVar.d());
                c.a(new ab());
                c.a(iyVar);
                e(c);
                c.a(new js(c.q(), null));
                a(buVar.c, c);
                this.k.b();
            }
            return c;
        } finally {
            this.k.b();
        }
    }

    protected void a(bu buVar, c cVar) {
        Object obj = null;
        try {
            this.k.a();
            if (this.h.containsKey(Long.valueOf(cVar.aF()))) {
                this.g.b();
                aa b = b(cVar.aH());
                if (b != null) {
                    b.b(cVar);
                    b.aM();
                }
                b = g(buVar.c);
                if (b == null) {
                    b = h(buVar.c);
                    obj = 1;
                }
                b.a(0, (an) cVar);
                b.aM();
                if (obj != null) {
                    l().aM();
                }
                cVar.a(buVar.e);
                cVar.aM();
                this.g.f();
                this.g.c();
                this.k.b();
                return;
            }
            this.k.b();
        } catch (Exception e) {
            e.printStackTrace();
            this.g.c();
        } catch (Throwable th) {
            this.k.b();
        }
    }

    protected void a(c cVar) {
        try {
            this.k.a();
            if (this.h.containsKey(Long.valueOf(cVar.aF()))) {
                this.g.b();
                if (cVar.V()) {
                    cVar.ab();
                }
                aa b = b(cVar.aH());
                if (b != null) {
                    b.b(cVar);
                    b.aM();
                }
                this.g.a(String.format("DELETE FROM %1$s WHERE _id = %2$s", new Object[]{"books", Long.valueOf(cVar.aF())}));
                this.h.remove(Long.valueOf(cVar.aF()));
                this.g.f();
                this.g.c();
                this.k.b();
                return;
            }
            this.k.b();
        } catch (Exception e) {
            e.printStackTrace();
            this.g.c();
        } catch (Throwable th) {
            this.k.b();
        }
    }

    protected void u() {
        c cVar;
        Iterator it;
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.h);
        while (!hashMap.isEmpty()) {
            for (c cVar2 : hashMap.values()) {
                cVar2.c();
                if (cVar2.am()) {
                    cVar2.ak().g();
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.putAll(this.h);
            Map hashMap3 = new HashMap();
            for (c cVar22 : hashMap2.values()) {
                if (!hashMap.containsKey(Long.valueOf(cVar22.aF()))) {
                    hashMap3.put(Long.valueOf(cVar22.aF()), cVar22);
                }
            }
            hashMap.clear();
            hashMap.putAll(hashMap3);
        }
        hashMap = new HashMap();
        hashMap.putAll(this.p);
        while (!hashMap.isEmpty()) {
            for (aa a : hashMap.values()) {
                aa a2;
                a2.a();
            }
            new HashMap().putAll(this.p);
            hashMap3 = new HashMap();
            for (aa a22 : hashMap3.values()) {
                if (!hashMap.containsKey(Long.valueOf(a22.aF()))) {
                    hashMap3.put(Long.valueOf(a22.aF()), a22);
                }
            }
            hashMap.clear();
            hashMap.putAll(hashMap3);
        }
        try {
            this.k.a();
            ArrayList arrayList = new ArrayList();
            for (aa a222 : hashMap.values()) {
                if (!a222.h() && (a222.f() == 0 || !a222.aI())) {
                    arrayList.add(a222);
                }
            }
            if (!arrayList.isEmpty()) {
                this.g.b();
                it = arrayList.iterator();
                while (it.hasNext()) {
                    a222 = (aa) it.next();
                    if (a222.aI()) {
                        l().b(a222);
                        l().aL();
                    }
                    if (a222.f() > 0) {
                        a222.j();
                    }
                    this.g.a(String.format("DELETE FROM %1$s WHERE _id = %2$s", new Object[]{"book_categories", Long.valueOf(a222.aF())}));
                    this.p.remove(Long.valueOf(a222.aF()));
                }
                this.g.f();
                this.g.c();
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.g.c();
        } catch (Throwable th) {
            this.k.b();
        }
        ArrayList arrayList2 = new ArrayList();
        for (c cVar222 : this.h.values()) {
            if (!cVar222.aI()) {
                arrayList2.add(cVar222);
            }
        }
        if (!arrayList2.isEmpty()) {
            this.g.b();
            try {
                it = arrayList2.iterator();
                while (it.hasNext()) {
                    cVar222 = (c) it.next();
                    this.g.a(String.format("DELETE FROM %1$s WHERE _id = %2$s", new Object[]{"books", Long.valueOf(cVar222.aF())}));
                    this.h.remove(Long.valueOf(cVar222.aF()));
                }
                this.g.f();
            } catch (Exception e2) {
                e2.printStackTrace();
            } finally {
                this.g.c();
            }
        }
        this.k.b();
    }

    protected HashMap v() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.h.values());
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.ao() != -1) {
                hashMap.put(cVar.ap(), cVar);
            }
        }
        return hashMap;
    }

    private ArrayList D() {
        return a(new hk(this));
    }

    private ArrayList E() {
        return a(new hl(this));
    }

    private ArrayList F() {
        return a(new hm(this));
    }

    private ArrayList a(IRunTask bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.h.values());
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (bVar.isRunTask(cVar)) {
                arrayList2.add(cVar);
            }
        }
        return arrayList2;
    }

    public void b(c cVar) {
        if (cVar.ax() == 0) {
            mx.a().b(this.a);
        }
        long currentTimeMillis = System.currentTimeMillis();
        cVar.d(currentTimeMillis);
        cVar.c(currentTimeMillis);
        if (!cVar.aG()) {
            if (cVar.aH() != -9) {
                an b = b(cVar.aH());
                if (b != null) {
                    this.H.moveItem(l(), b, 0);
                    this.H.moveItem(b, cVar, 0);
                }
            } else {
                this.H.moveItem(l(), cVar, 0);
            }
            cVar.aL();
            x();
        }
        i(cVar);
    }

    public void c(c cVar) {
        if (cVar.aH() != -9) {
            aa b = b(cVar.aH());
            if (b != null) {
                a(l(), (an) b, 0);
                a(b, (an) cVar, 0);
            }
        } else {
            a(l(), (an) cVar, 0);
        }
        cVar.aL();
        x();
    }

    private void i(c cVar) {
        t.a(new hn(this, cVar));
    }

    public void d(c cVar) {
        try {
            this.k.a();
            cVar.d(-1);
            cVar.aL();
            t.a(new ho(this, cVar));
        } finally {
            this.k.b();
        }
    }

    public void d(List list) {
        try {
            this.k.a();
            this.g.b();
            for (c cVar : list) {
                cVar.aE();
                if (cVar.am()) {
                    File file = new File(a(cVar.ak()));
                    String uri = Uri.fromFile(file).toString();
                    DkPublic.rm(file);
                    cVar.a(uri);
                    cVar.aL();
                }
            }
            this.g.f();
            this.g.c();
        } catch (Exception e) {
            e.printStackTrace();
            this.g.c();
        } catch (Throwable th) {
            this.k.b();
        }
        x();
        this.k.b();
    }

    private void G() {
        ListIterator listIterator = this.u.listIterator();
        while (listIterator.hasNext()) {
            ip ipVar = (c) listIterator.next();
            while (this.w < 3) {
                FutureTask aD = ipVar.aD();
                if (aD == null) {
                    ipVar.g(0);
                    ipVar.aL();
                    listIterator.remove();
                    break;
                }
                ipVar.a.add(aD);
                this.w++;
                com.duokan.core.sys.ah.b(new hp(this, aD, ipVar));
            }
        }
    }

    private void a(c cVar, long j) {
        if (j >= 1) {
            cVar.g(j);
            cVar.aL();
            this.u.remove(cVar);
            ListIterator listIterator = this.u.listIterator();
            while (listIterator.hasNext()) {
                if (cVar.O() >= ((c) listIterator.next()).O()) {
                    listIterator.previous();
                    break;
                }
            }
            listIterator.add(cVar);
        }
    }

    protected void e(c cVar) {
        try {
            if (TextUtils.isEmpty(cVar.g())) {
                File file = new File(Uri.parse(cVar.h()).getPath());
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (Throwable th) {
        }
        f(cVar);
    }

    protected void f(c cVar) {
        this.o.b();
        try {
            this.o.a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"typesetting", "book_id", "" + cVar.aF()}));
            this.o.f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.o.c();
        }
    }

    protected void w() {
        if (f.b().e()) {
            String str;
            if (this.y == null) {
                str = "last_serial_update_date";
                if (System.currentTimeMillis() - this.f.getPrefLong(PrivatePref.BOOKSHELF, "last_serial_update_date", 0) >= 7200000) {
                    this.y = new LinkedList(Arrays.asList(j()));
                    a(this.y, new hr(this));
                }
            }
            if (!this.z) {
                str = "last_statistics_update_date";
                if (System.currentTimeMillis() - this.f.getPrefLong(PrivatePref.BOOKSHELF, "last_statistics_update_date", 0) >= 3600000) {
                    this.z = true;
                    com.duokan.reader.domain.cloud.h.a().a(false, new hs(this));
                }
            }
            if (this.A == null) {
                str = "last_revision_update_date";
                if (System.currentTimeMillis() - this.f.getPrefLong(PrivatePref.BOOKSHELF, "last_revision_update_date", 0) >= 86400000) {
                    this.A = new ht(this);
                    this.A.open();
                }
            }
        }
    }

    private void a(LinkedList linkedList, Runnable runnable) {
        c cVar = (c) linkedList.pollFirst();
        if (cVar == null) {
            t.b(runnable);
        } else {
            a(cVar, new hu(this, linkedList, runnable));
        }
    }

    private void a(c cVar, Runnable runnable) {
        if (!(cVar instanceof ej) || cVar.az()) {
            t.a(runnable, 200);
        } else {
            ((ej) cVar).a(false, new hy(this, runnable), new hz(this, runnable));
        }
    }

    protected void x() {
        t.c(this.t);
        t.b(this.t);
    }

    private void j(c cVar) {
        t.a(new ia(this, cVar));
    }

    private boolean c(DkStoreBookDetail dkStoreBookDetail) {
        if (TextUtils.isEmpty(dkStoreBookDetail.getOpfUri())) {
            return false;
        }
        int[] features = dkStoreBookDetail.getFeatures();
        int length = features.length;
        int i = 0;
        while (i < length) {
            try {
                if (!DkFeature.values()[features[i]].isLinearizable()) {
                    return false;
                }
                i++;
            } catch (Throwable th) {
                return false;
            }
        }
        return true;
    }
}
