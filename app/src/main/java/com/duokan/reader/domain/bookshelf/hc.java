package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.duokan.common.C0266h;
import com.duokan.common.CommonUtils;
import com.duokan.core.app.ApplicationsStateCallbacks;
import com.duokan.core.app.ai;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.FileUtil;
import com.duokan.core.p026a.C0285n;
import com.duokan.core.p029c.IRunTask;
import com.duokan.core.sys.C0366o;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ah;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.C0543b;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0562i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0630c;
import com.duokan.reader.common.webservices.duokan.C0651y;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.C0848h;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.av;
import com.duokan.reader.domain.cloud.cf;
import com.duokan.reader.domain.cloud.dn;
import com.duokan.reader.domain.cloud.et;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.provider.BookshelfHelper;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.Column;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.CommonColumn;
import com.duokan.reader.domain.statistics.dailystats.C1167a;
import com.duokan.reader.domain.store.C1176a;
import com.duokan.reader.domain.store.DkStoreBookCategory;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreCategory;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.personal.nl;
import com.google.android.collect.Lists;
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
import org.apache.http.protocol.HTTP;

@SuppressLint({"UseSparseArrays"})
public abstract class hc implements ai, ApplicationsStateCallbacks, C0562i, C0586j, cf, dn, et {
    /* renamed from: c */
    protected static final String f2728c = (ai.class.getName() + ".asyncTaskQueue");
    /* renamed from: l */
    static final /* synthetic */ boolean f2729l = (!hc.class.desiredAssertionStatus());
    /* renamed from: A */
    private WebSession f2730A = null;
    /* renamed from: B */
    private long f2731B = 1;
    /* renamed from: C */
    private long f2732C = -10;
    /* renamed from: D */
    private final ReentrantLock f2733D = new ReentrantLock();
    /* renamed from: E */
    private final ReentrantLock f2734E = new ReentrantLock();
    /* renamed from: F */
    private boolean f2735F = false;
    /* renamed from: G */
    private final CopyOnWriteArrayList<io> f2736G = new CopyOnWriteArrayList();
    /* renamed from: H */
    private final BookOrderHelper f2737H;
    /* renamed from: a */
    private final Context f2738a;
    /* renamed from: b */
    private final C1176a f2739b;
    /* renamed from: d */
    protected final C0559f f2740d;
    /* renamed from: e */
    protected final C0709k f2741e;
    /* renamed from: f */
    protected final ReaderEnv f2742f;
    /* renamed from: g */
    protected final C0285n f2743g;
    /* renamed from: h */
    protected final ConcurrentHashMap<Long, C0800c> f2744h = new ConcurrentHashMap();
    /* renamed from: i */
    protected ik f2745i;
    /* renamed from: j */
    protected al f2746j;
    /* renamed from: k */
    protected final am f2747k = new hp(this);
    /* renamed from: m */
    private final DkCloudStorage f2748m;
    /* renamed from: n */
    private final C1016b f2749n;
    /* renamed from: o */
    private final C0285n f2750o;
    /* renamed from: p */
    private final ConcurrentHashMap<Long, aa> f2751p = new ConcurrentHashMap();
    /* renamed from: q */
    private final CopyOnWriteArrayList<ip> f2752q = new CopyOnWriteArrayList();
    /* renamed from: r */
    private final CopyOnWriteArrayList<iq> f2753r = new CopyOnWriteArrayList();
    /* renamed from: s */
    private final CopyOnWriteArrayList<in> f2754s = new CopyOnWriteArrayList();
    /* renamed from: t */
    private final Runnable f2755t = new hd(this);
    /* renamed from: u */
    private final LinkedList<C0800c> f2756u = new LinkedList();
    /* renamed from: v */
    private final List<DkCloudStoreBook> f2757v = new ArrayList();
    /* renamed from: w */
    private int f2758w = 0;
    /* renamed from: x */
    private boolean f2759x = false;
    /* renamed from: y */
    private LinkedList<C0800c> f2760y = null;
    /* renamed from: z */
    private boolean f2761z = false;

    /* renamed from: a */
    public boolean m3903a(java.util.List<com.duokan.reader.domain.store.DkStoreItem> r15, java.util.List<com.duokan.reader.domain.store.DkStoreItem> r16) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r14 = this;
        if (r15 == 0) goto L_0x0008;
    L_0x0002:
        r2 = r15.size();
        if (r2 != 0) goto L_0x000a;
    L_0x0008:
        r2 = 0;
    L_0x0009:
        return r2;
    L_0x000a:
        r2 = r14.f2747k;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.mo1090a();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r10 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r10.<init>();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r11 = r15.iterator();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0018:
        r2 = r11.hasNext();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r2 == 0) goto L_0x0295;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x001e:
        r2 = r11.next();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r0 = r2;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r0 = (com.duokan.reader.domain.store.DkStoreItem) r0;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r9 = r0;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = r9 instanceof com.duokan.reader.domain.store.DkStoreBookDetail;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r2 == 0) goto L_0x023b;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x002a:
        r0 = r9;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r0 = (com.duokan.reader.domain.store.DkStoreBookDetail) r0;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r6 = r0;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = r6.getBook();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = r2.getBookUuid();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = r14.m3906b(r2);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r2 != 0) goto L_0x0018;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x003c:
        r2 = r14.m3842c(r6);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r2 == 0) goto L_0x00b9;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0042:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.getPrice();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r4 == 0) goto L_0x0062;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0050:
        r4 = com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager.m5029a();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r5 = r6.getBook();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r5 = r5.getBookUuid();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.m5052a(r5);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r4 == 0) goto L_0x0097;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0062:
        r2 = com.duokan.reader.domain.bookshelf.BookLimitType.NONE;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = r2;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0065:
        r2 = com.duokan.reader.domain.bookshelf.BookFormat.EPUB;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = com.duokan.reader.domain.bookshelf.BookPackageType.EPUB_OPF;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r5 = com.duokan.reader.domain.bookshelf.BookType.NORMAL;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r7 = com.duokan.reader.domain.bookshelf.BookState.PULLING;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = r14.m3832b(r2, r4, r5, r7);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = (com.duokan.reader.domain.bookshelf.fp) r2;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.m4482a(r6, r3);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0076:
        r0 = r16;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = r0.contains(r9);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r3 == 0) goto L_0x0234;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x007e:
        r3 = "free_newbie";	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.m4218c(r3);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0083:
        r3 = 0;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.m4483a(r3);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r14.m3925e(r2);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r10.add(r2);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x0018;
    L_0x008e:
        r2 = move-exception;
        r2 = 0;
        r3 = r14.f2747k;
        r3.mo1096b();
        goto L_0x0009;
    L_0x0097:
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.getLimitedTime();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r4 > 0) goto L_0x00b1;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x00a3:
        r4 = com.duokan.reader.domain.cloud.av.m5316a();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.m5334b();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.f3740a;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r2 <= 0) goto L_0x00b5;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x00b1:
        r2 = com.duokan.reader.domain.bookshelf.BookLimitType.TIME;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = r2;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x0065;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x00b5:
        r2 = com.duokan.reader.domain.bookshelf.BookLimitType.CONTENT;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = r2;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x0065;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x00b9:
        r2 = com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager.m5029a();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = r6.getBook();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = r3.getBookUuid();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = r2.m5052a(r3);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r2 != 0) goto L_0x00d5;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x00cb:
        r2 = r6.getBook();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = r2.getPrice();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r2 != 0) goto L_0x01c2;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x00d5:
        r2 = 1;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r7 = r2;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x00d7:
        r2 = com.duokan.reader.domain.cloud.av.m5316a();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = r2.m5334b();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = r2.f3740a;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r2 <= 0) goto L_0x01c6;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x00e9:
        r2 = 1;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r5 = r2;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x00eb:
        if (r7 != 0) goto L_0x00ef;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x00ed:
        if (r5 == 0) goto L_0x01ca;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x00ef:
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = r14.f2742f;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = r3.getCloudBookDirectory();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4.<init>();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8 = r6.getBook();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8 = r8.getBookUuid();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8 = ".";	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8 = r6.getRevision();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8 = ".epub";	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0123:
        r2 = android.net.Uri.fromFile(r2);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = r2.toString();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = com.duokan.reader.domain.bookshelf.BookFormat.EPUB;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = com.duokan.reader.domain.bookshelf.BookPackageType.EPUB;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8 = com.duokan.reader.domain.bookshelf.BookType.TRIAL;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r12 = com.duokan.reader.domain.bookshelf.BookState.CLOUD_ONLY;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = r14.m3864a(r2, r4, r8, r12);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = (com.duokan.reader.domain.bookshelf.fp) r2;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.getBookUuid();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.m4224e(r4);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.m4196a(r3);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r6.getRevision();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.m4227f(r4);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.m4176a(r12);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.getTitle();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.mo955p(r4);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r7 != 0) goto L_0x0164;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0162:
        if (r5 == 0) goto L_0x0200;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0164:
        r4 = com.duokan.reader.domain.bookshelf.BookType.NORMAL;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0166:
        r2.m4184a(r4);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r5 == 0) goto L_0x0204;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x016b:
        r4 = com.duokan.reader.domain.bookshelf.BookLimitType.TIME;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x016d:
        r2.m4183a(r4);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.isFree();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r4 == 0) goto L_0x020e;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x017a:
        r4 = 0;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x017b:
        r2.m4175a(r4);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.getNameLine();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.m4221d(r4);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r14.m3905b(r6);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.m4186a(r4);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.getCoverUri();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.m4212b(r4);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r7 != 0) goto L_0x019f;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x019d:
        if (r5 == 0) goto L_0x0218;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x019f:
        r4 = r6.getEpubUri();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r5 = r6.getRevision();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r6 = r6.getEpubMd5();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r7 = 1;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8 = new com.duokan.core.sys.af;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r12 = 1;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r12 = java.lang.Boolean.valueOf(r12);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8.<init>(r12);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.m4198a(r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x0076;
    L_0x01bb:
        r2 = move-exception;
        r3 = r14.f2747k;
        r3.mo1096b();
        throw r2;
    L_0x01c2:
        r2 = 0;
        r7 = r2;
        goto L_0x00d7;
    L_0x01c6:
        r2 = 0;
        r5 = r2;
        goto L_0x00eb;
    L_0x01ca:
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = r14.f2742f;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = r3.getCloudBookDirectory();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4.<init>();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8 = r6.getBook();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8 = r8.getBookUuid();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8 = ".";	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8 = r6.getRevision();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8 = ".trial.epub";	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.append(r8);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x0123;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0200:
        r4 = com.duokan.reader.domain.bookshelf.BookType.TRIAL;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x0166;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0204:
        if (r7 == 0) goto L_0x020a;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0206:
        r4 = com.duokan.reader.domain.bookshelf.BookLimitType.NONE;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x016d;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x020a:
        r4 = com.duokan.reader.domain.bookshelf.BookLimitType.CONTENT;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x016d;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x020e:
        r4 = r6.getBook();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r4.getNewPrice();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x017b;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0218:
        r4 = r6.getTrialUri();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r5 = r6.getRevision();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r6 = r6.getTrialMd5();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r7 = 0;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8 = new com.duokan.core.sys.af;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r12 = 1;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r12 = java.lang.Boolean.valueOf(r12);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r8.<init>(r12);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.m4198a(r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x0076;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0234:
        r3 = "newbie";	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2.m4218c(r3);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x0083;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x023b:
        r2 = r9 instanceof com.duokan.reader.domain.store.DkStoreFictionDetail;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r2 == 0) goto L_0x0018;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x023f:
        r0 = r9;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r0 = (com.duokan.reader.domain.store.DkStoreFictionDetail) r0;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = r0;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = r2.getFiction();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = r3.getBookUuid();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = r14.m3906b(r4);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = (com.duokan.reader.domain.bookshelf.ee) r3;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r3 == 0) goto L_0x025e;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0253:
        r5 = r3.m4417b(r2);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r5 == 0) goto L_0x025e;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0259:
        r3.m4418c(r2);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x0018;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x025e:
        r3 = com.duokan.reader.domain.bookshelf.C0800c.m4143o(r4);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r3 == 0) goto L_0x028c;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0264:
        r3 = com.duokan.reader.domain.bookshelf.BookFormat.SBK;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0266:
        r4 = com.duokan.reader.domain.bookshelf.BookPackageType.DIRECTORY;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r5 = com.duokan.reader.domain.bookshelf.BookType.SERIAL;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r6 = com.duokan.reader.domain.bookshelf.BookState.NORMAL;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = r14.m3832b(r3, r4, r5, r6);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3 = (com.duokan.reader.domain.bookshelf.ee) r3;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r4 = com.duokan.reader.domain.bookshelf.BookLimitType.CONTENT;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3.m4407a(r2, r4);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r0 = r16;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r2 = r0.contains(r9);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r2 == 0) goto L_0x028f;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x027f:
        r2 = "free_newbie";	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3.m4218c(r2);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0284:
        r14.m3925e(r3);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r10.add(r3);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x0018;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x028c:
        r3 = com.duokan.reader.domain.bookshelf.BookFormat.EPUB;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x0266;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x028f:
        r2 = "newbie";	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r3.m4218c(r2);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        goto L_0x0284;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x0295:
        r2 = r10.size();	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        if (r2 == 0) goto L_0x02a0;	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x029b:
        r2 = "";	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
        r14.m3896a(r2, r10);	 Catch:{ Throwable -> 0x008e, all -> 0x01bb }
    L_0x02a0:
        r2 = 1;
        r3 = r14.f2747k;
        r3.mo1096b();
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.hc.a(java.util.List, java.util.List):boolean");
    }

    protected hc(Context context, ReaderEnv readerEnv, C0559f c0559f, C0709k c0709k, C1176a c1176a, DkCloudStorage dkCloudStorage, C1016b c1016b) {
        this.f2738a = context;
        this.f2740d = c0559f;
        this.f2741e = c0709k;
        this.f2742f = readerEnv;
        this.f2739b = c1176a;
        this.f2748m = dkCloudStorage;
        this.f2749n = c1016b;
        File databaseDirectory = readerEnv.getDatabaseDirectory();
        this.f2743g = new C0285n(Uri.fromFile(new File(databaseDirectory, "Bookshelf.db")).toString(), Uri.fromFile(new File(readerEnv.getExternalFilesDirectory(), "Bookshelf.db")).toString());
        this.f2750o = new C0285n(Uri.fromFile(new File(databaseDirectory, "Bookshelf.cache.db")).toString(), null);
        this.f2737H = new BookOrderHelper();
        m3818a();
        mo971c();
        m3860z();
        m3859y();
        this.f2759x = true;
        this.f2746j = new al(this.f2741e.m3508d());
        DkApp.get().runPreReady(new hw(this));
        ah.m866a(new ic(this), f2728c);
    }

    /* renamed from: a */
    public void m3889a(ip ipVar) {
        if (f2729l || ipVar != null) {
            this.f2752q.addIfAbsent(ipVar);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public void m3912b(ip ipVar) {
        if (f2729l || ipVar != null) {
            this.f2752q.remove(ipVar);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void m3890a(iq iqVar) {
        if (f2729l || iqVar != null) {
            this.f2753r.addIfAbsent(iqVar);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public void m3913b(iq iqVar) {
        if (f2729l || iqVar != null) {
            this.f2753r.remove(iqVar);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void m3887a(in inVar) {
        this.f2754s.add(inVar);
    }

    /* renamed from: b */
    public void m3910b(in inVar) {
        this.f2754s.remove(inVar);
    }

    /* renamed from: b */
    public void mo962b() {
    }

    /* renamed from: d */
    public void mo965d() {
    }

    /* renamed from: a */
    public void mo961a(String[] strArr) {
        for (String b : strArr) {
            C0800c b2 = m3906b(b);
            if (b2 != null && b2.m4233i() == BookState.CLOUD_ONLY) {
                m3886a(b2, true);
            }
        }
    }

    /* renamed from: a */
    public void mo960a(List<DkCloudStoreBook> list) {
        if (this.f2745i == null) {
            m3844d((List) list);
        } else {
            this.f2757v.addAll(list);
        }
    }

    /* renamed from: e */
    public void mo966e() {
    }

    /* renamed from: b */
    public void mo964b(String[] strArr) {
        for (String b : strArr) {
            C0800c b2 = m3906b(b);
            if (b2 != null && b2.m4233i() == BookState.CLOUD_ONLY) {
                m3886a(b2, true);
            }
        }
    }

    /* renamed from: b */
    public void mo963b(List<DkCloudStoreBook> list) {
        if (this.f2745i == null) {
            m3844d((List) list);
        } else {
            this.f2757v.addAll(list);
        }
    }

    /* renamed from: f */
    public void mo967f() {
    }

    /* renamed from: a */
    public void mo958a(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
    }

    /* renamed from: a */
    public void mo959a(String str, DkCloudAnnotation[] dkCloudAnnotationArr) {
        C0800c b = m3906b(str);
        if (b != null) {
            b.m4203a(dkCloudAnnotationArr);
            b = (C0800c) this.f2744h.get(Long.valueOf(b.aH()));
            if (b != null) {
                b.at();
            }
        }
    }

    /* renamed from: a */
    public List<C0800c> m3879a(String str) {
        try {
            List<C0800c> arrayList;
            this.f2747k.mo1090a();
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
                arrayList = m3923e("book_name like " + str2);
                this.f2747k.mo1096b();
            }
            return arrayList;
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: a */
    public List<C0800c> m3878a(int i, BookTag bookTag) {
        String str;
        if (bookTag == null || bookTag.m3708a() < 0) {
            str = "SELECT  _id FROM books WHERE last_reading_date > 0 ORDER BY last_reading_date desc limit 0, " + i;
        } else {
            str = "SELECT * FROM books WHERE last_reading_date > 0 AND _id IN (SELECT book_id FROM book_tag_map WHERE tag_id = " + bookTag.m3708a() + ") ORDER BY last_reading_date DESC LIMIT 0, " + i;
        }
        return m3926f(str);
    }

    /* renamed from: g */
    public boolean m3930g() {
        try {
            this.f2747k.mo1090a();
            String str = "SELECT _id FROM books";
            Cursor a = this.f2743g.m670a("SELECT _id FROM books", null);
            boolean z = !a.moveToFirst();
            a.close();
            return z;
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: h */
    public int m3931h() {
        try {
            this.f2747k.mo1090a();
            int size = m3923e(null).size();
            return size;
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: a */
    protected C0800c m3863a(long j) {
        return (C0800c) this.f2744h.get(Long.valueOf(j));
    }

    /* renamed from: b */
    public C0800c m3906b(String str) {
        ArrayList f = m3926f(String.format("SELECT _id FROM books WHERE book_uuid == \"%s\"", new Object[]{str}));
        if (f.size() > 0) {
            return (C0800c) f.get(0);
        }
        return null;
    }

    /* renamed from: c */
    protected C0800c m3917c(String str) {
        return m3837c("book_uri = ?", new String[]{str});
    }

    /* renamed from: d */
    public C0800c m3920d(String str) {
        return m3837c("book_uri = ?", new String[]{Uri.fromFile(new File(str)).toString()});
    }

    /* renamed from: c */
    private C0800c m3837c(String str, String[] strArr) {
        String str2 = "SELECT * FROM books";
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + " WHERE " + str;
        }
        ArrayList b = m3907b(str2, strArr);
        if (b.size() >= 1) {
            return (C0800c) b.get(0);
        }
        return null;
    }

    /* renamed from: i */
    public C0800c[] m3934i() {
        return (C0800c[]) m3926f("SELECT _id FROM books").toArray(new C0800c[0]);
    }

    /* renamed from: j */
    public C0800c[] m3935j() {
        return (C0800c[]) m3926f("SELECT _id FROM books WHERE book_type = \"SERIAL\"").toArray(new C0800c[0]);
    }

    /* renamed from: d */
    private void m3844d(List<DkCloudStoreBook> list) {
        for (DkCloudStoreBook bookUuid : list) {
            if (m3906b(bookUuid.getBookUuid()) == null) {
                PersonalPrefs.m5175a().m5230g(true);
                return;
            }
        }
    }

    /* renamed from: e */
    protected ArrayList<C0800c> m3923e(String str) {
        return m3877a(str, null);
    }

    /* renamed from: a */
    protected ArrayList<C0800c> m3877a(String str, String[] strArr) {
        String str2 = "SELECT * FROM books ";
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + " WHERE " + str;
        }
        return m3907b(str2, strArr);
    }

    /* renamed from: f */
    protected ArrayList<C0800c> m3926f(String str) {
        return m3907b(str, null);
    }

    /* renamed from: b */
    protected ArrayList<C0800c> m3907b(String str, String[] strArr) {
        ArrayList<C0800c> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.f2743g.m670a(str, strArr);
            arrayList.ensureCapacity(cursor.getCount());
            while (cursor.moveToNext()) {
                C0800c c0800c = (C0800c) this.f2744h.get(Long.valueOf(cursor.getLong(0)));
                if (c0800c != null) {
                    arrayList.add(c0800c);
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

    /* renamed from: a */
    private void m3818a() {
        BookshelfHelper.m8427a(this.f2743g);
        int d = this.f2750o.m679d();
        if (d < 1) {
            this.f2750o.m677b();
            try {
                this.f2750o.m673a(String.format("CREATE TABLE %1$s (%2$s INTEGER PRIMARY KEY, %3$s INTEGER, %4$s TEXT, %5$s TEXT, %6$s BLOB, %7$s LONG, %8$s LONG, %9$s BLOB, %10$s TEXT)", new Object[]{"typesetting", "typesetting_id", "book_id", "kernel_version", "layout_params", "pagination_result", "file_size", "modified_date", "book_digest", "content_digest"}));
                this.f2750o.m673a(String.format("CREATE TABLE %1$s (%2$s INTEGER PRIMARY KEY, %3$s INTEGER, %4$s TEXT, %5$s BLOB, %6$s LONG, %7$s LONG)", new Object[]{"toc", "toc_id", "book_id", "kernel_version", "toc_data", "file_size", "modified_date"}));
                this.f2750o.m672a(5);
                this.f2750o.m681f();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.f2750o.m678c();
            }
        } else if (d < 5) {
            this.f2750o.m677b();
            if (d < 2) {
                try {
                    this.f2750o.m673a(String.format("ALTER TABLE %s ADD COLUMN %s LONG DEFAULT 0", new Object[]{"typesetting", "file_size"}));
                    this.f2750o.m673a(String.format("ALTER TABLE %s ADD COLUMN %s LONG DEFAULT 0", new Object[]{"typesetting", "modified_date"}));
                    this.f2750o.m672a(2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                } finally {
                    this.f2750o.m678c();
                }
            }
            if (d < 3) {
                this.f2750o.m673a(String.format("CREATE TABLE %1$s (%2$s INTEGER PRIMARY KEY,  %3$s INTEGER,  %4$s TEXT,  %5$s BLOB,  %6$s LONG,  %7$s LONG)", new Object[]{"toc", "toc_id", "book_id", "kernel_version", "toc_data", "file_size", "modified_date"}));
                this.f2750o.m672a(3);
            }
            if (d < 4) {
                this.f2750o.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"typesetting", "book_digest"}));
            }
            if (d < 5) {
                this.f2750o.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"typesetting", "content_digest"}));
            }
            this.f2750o.m681f();
            this.f2750o.m678c();
        }
    }

    /* renamed from: c */
    private void mo971c() {
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
            a = this.f2743g.m670a(stringBuilder.toString(), null);
            while (a.moveToNext()) {
                C0800c a2 = m3810a(a);
                this.f2731B = Math.max(this.f2731B, a2.aH());
                this.f2744h.put(Long.valueOf(a2.aH()), a2);
            }
            a.close();
        } catch (Throwable th) {
        }
    }

    /* renamed from: y */
    private void m3859y() {
        aa l = m3937l();
        this.f2737H.init(l);
        l.aQ();
        for (an anVar : this.f2751p.values()) {
            if (!(anVar == l || anVar.m3765f() <= 0 || l.m3762c(anVar))) {
                l.m3753a(l.m3765f(), anVar);
                l.aN();
            }
        }
        if (this.f2751p.size() == 1 && l.m3765f() == 0 && this.f2744h.size() > 0) {
            int i = 0;
            for (an anVar2 : this.f2744h.values()) {
                int i2;
                if (this.f2751p.contains(Long.valueOf(anVar2.aJ()))) {
                    i2 = i;
                } else {
                    l.m3753a(0, anVar2);
                    i2 = i + 1;
                }
                i = i2;
            }
            if (i > 0) {
                l.aN();
            }
        }
    }

    /* renamed from: z */
    private void m3860z() {
        Cursor a = this.f2743g.m670a(String.format("SELECT _id FROM %1$s", new Object[]{"book_categories"}), null);
        if (a != null) {
            while (a.moveToNext()) {
                long j = a.getLong(0);
                aa aaVar = new aa(this.f2747k, j, true);
                this.f2751p.put(Long.valueOf(aaVar.aH()), aaVar);
                this.f2732C = Math.min(this.f2732C, j);
            }
            a.close();
        }
    }

    /* renamed from: a */
    protected static String m3814a(String str, is isVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(File.separator);
        stringBuilder.append(CommonUtils.m607b(isVar.m4682b()));
        stringBuilder.append("_");
        stringBuilder.append(C0266h.m597a(isVar.m4685e()));
        stringBuilder.append("_");
        stringBuilder.append(isVar.m4684d());
        stringBuilder.append(File.separator);
        stringBuilder.append(isVar.m4682b());
        return new File(stringBuilder.toString()).getAbsolutePath();
    }

    /* renamed from: a */
    private String mo968a(is isVar) {
        return m3814a(this.f2742f.getMiCloudBookDirectory().getAbsolutePath(), isVar);
    }

    /* renamed from: a */
    public C0800c m3869a(DkStoreBookDetail dkStoreBookDetail) {
        try {
            this.f2747k.mo1090a();
            C0800c b = m3906b(dkStoreBookDetail.getBook().getBookUuid());
            if (b == null) {
                BookLimitType bookLimitType;
                long currentTimeMillis = System.currentTimeMillis();
                if (dkStoreBookDetail.getBook().getPrice() == 0 || DkUserPurchasedBooksManager.m5029a().m5052a(dkStoreBookDetail.getBook().getBookUuid()) != null) {
                    bookLimitType = BookLimitType.NONE;
                } else if (dkStoreBookDetail.getBook().getLimitedTime() > currentTimeMillis || av.m5316a().m5334b().f3740a > currentTimeMillis) {
                    bookLimitType = BookLimitType.TIME;
                } else {
                    bookLimitType = BookLimitType.CONTENT;
                }
                b = (fp) m3832b(BookFormat.EPUB, BookPackageType.EPUB_OPF, BookType.NORMAL, BookState.PULLING);
                b.m4482a(dkStoreBookDetail, bookLimitType);
                b.m4483a(null);
                m3925e(b);
                this.f2747k.mo1096b();
            }
            return b;
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: a */
    public C0800c m3874a(DkStoreFictionDetail dkStoreFictionDetail) {
        try {
            this.f2747k.mo1090a();
            if (f2729l || dkStoreFictionDetail != null) {
                String bookUuid = dkStoreFictionDetail.getFiction().getBookUuid();
                C0800c c0800c = (ee) m3906b(bookUuid);
                if (c0800c == null || !c0800c.m4417b(dkStoreFictionDetail)) {
                    c0800c = (ee) m3832b(C0800c.m4143o(bookUuid) ? BookFormat.SBK : BookFormat.EPUB, BookPackageType.DIRECTORY, BookType.SERIAL, BookState.NORMAL);
                    c0800c.m4407a(dkStoreFictionDetail, BookLimitType.CONTENT);
                    m3925e(c0800c);
                    this.f2747k.mo1096b();
                    return c0800c;
                }
                c0800c.m4418c(dkStoreFictionDetail);
                return c0800c;
            }
            throw new AssertionError();
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: a */
    public C0800c m3872a(DkStoreBookDetail dkStoreBookDetail, C0651y c0651y, af<Boolean> afVar) {
        try {
            this.f2747k.mo1090a();
            if (f2729l || dkStoreBookDetail != null) {
                UmengManager.get().onEvent("V2_SHELF_IMPORT_BOOK", "DuokanBook");
                m3811a(dkStoreBookDetail, c0651y);
                C0800c b = m3835b(dkStoreBookDetail, c0651y, (af) afVar);
                return b;
            }
            throw new AssertionError();
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: a */
    public C0800c m3875a(DkStoreItem dkStoreItem) {
        C0800c c0800c = null;
        if (dkStoreItem != null) {
            if (dkStoreItem instanceof DkStoreBookDetail) {
                DkStoreBookDetail dkStoreBookDetail = (DkStoreBookDetail) dkStoreItem;
                c0800c = m3906b(dkStoreBookDetail.getBook().getBookUuid());
                if (c0800c == null) {
                    if (m3842c(dkStoreBookDetail)) {
                        c0800c = m3869a(dkStoreBookDetail);
                    } else {
                        c0800c = m3871a(dkStoreBookDetail, new af(Boolean.valueOf(true)));
                    }
                }
            } else if (dkStoreItem instanceof DkStoreFictionDetail) {
                DkStoreFictionDetail dkStoreFictionDetail = (DkStoreFictionDetail) dkStoreItem;
                c0800c = m3906b(dkStoreFictionDetail.getFiction().getBookUuid());
                if (c0800c == null) {
                    c0800c = m3874a(dkStoreFictionDetail);
                }
            }
            if (c0800c != null && c0800c.aI()) {
                m3895a("", c0800c);
            }
        }
        return c0800c;
    }

    /* renamed from: a */
    public C0800c m3871a(DkStoreBookDetail dkStoreBookDetail, af<Boolean> afVar) {
        return m3870a(dkStoreBookDetail, 0, (af) afVar);
    }

    /* renamed from: a */
    public C0800c m3870a(DkStoreBookDetail dkStoreBookDetail, int i, af<Boolean> afVar) {
        int i2 = 0;
        try {
            this.f2747k.mo1090a();
            C0800c b = m3906b(dkStoreBookDetail.getBook().getBookUuid());
            if (b == null) {
                int i3;
                File file;
                int i4 = (DkUserPurchasedBooksManager.m5029a().m5052a(dkStoreBookDetail.getBook().getBookUuid()) != null || dkStoreBookDetail.getBook().getPrice() == 0) ? 1 : 0;
                if (av.m5316a().m5334b().f3740a > System.currentTimeMillis()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i4 == 0 && i3 == 0) {
                    file = new File(this.f2742f.getCloudBookDirectory(), dkStoreBookDetail.getBook().getBookUuid() + "." + dkStoreBookDetail.getRevision() + ".trial.epub");
                } else {
                    file = new File(this.f2742f.getCloudBookDirectory(), dkStoreBookDetail.getBook().getBookUuid() + "." + dkStoreBookDetail.getRevision() + ".epub");
                }
                FileUtil.deleteFile(file);
                String uri = Uri.fromFile(file).toString();
                b = (fp) m3864a(BookFormat.EPUB, BookPackageType.EPUB, BookType.TRIAL, BookState.CLOUD_ONLY);
                b.m4224e(dkStoreBookDetail.getBook().getBookUuid());
                b.m4196a(uri);
                b.m4227f(dkStoreBookDetail.getRevision());
                b.m4176a(System.currentTimeMillis());
                b.mo955p(dkStoreBookDetail.getBook().getTitle());
                BookType bookType = (i4 == 0 && i3 == 0) ? BookType.TRIAL : BookType.NORMAL;
                b.m4184a(bookType);
                BookLimitType bookLimitType = i3 != 0 ? BookLimitType.TIME : i4 != 0 ? BookLimitType.NONE : BookLimitType.CONTENT;
                b.m4183a(bookLimitType);
                if (!dkStoreBookDetail.getBook().isFree()) {
                    i2 = dkStoreBookDetail.getBook().getNewPrice();
                }
                b.m4175a(i2);
                b.m4221d(dkStoreBookDetail.getBook().getNameLine());
                b.m4186a(m3905b(dkStoreBookDetail));
                b.m4212b(dkStoreBookDetail.getBook().getCoverUri());
                m3925e(b);
                m3893a("", i, b);
                if (i4 == 0 && i3 == 0) {
                    b.m4198a(uri, dkStoreBookDetail.getTrialUri(), dkStoreBookDetail.getRevision(), dkStoreBookDetail.getTrialMd5(), false, afVar);
                } else {
                    b.m4198a(uri, dkStoreBookDetail.getEpubUri(), dkStoreBookDetail.getRevision(), dkStoreBookDetail.getEpubMd5(), true, afVar);
                }
                b.m4483a(null);
                this.f2747k.mo1096b();
            }
            return b;
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: a */
    public C0800c m3868a(is isVar, af<Boolean> afVar) {
        try {
            this.f2747k.mo1090a();
            if (isVar == null) {
                return null;
            }
            C0800c b = m3833b(m3834b(isVar), isVar, (af) afVar);
            this.f2747k.mo1096b();
            return b;
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: a */
    public C0800c m3867a(C0800c c0800c, is isVar, af<Boolean> afVar) {
        try {
            this.f2747k.mo1090a();
            C0800c b = m3833b(c0800c, isVar, (af) afVar);
            return b;
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: a */
    public List<C0800c> mo969a(List<File> list, boolean z) {
        LinkedList linkedList = new LinkedList();
        if (list == null || list.size() <= 0) {
            return linkedList;
        }
        try {
            this.f2747k.mo1090a();
            this.f2743g.m677b();
            for (File absolutePath : list) {
                String absolutePath2 = absolutePath.getAbsolutePath();
                C0800c d = m3920d(absolutePath2);
                if (d != null) {
                    linkedList.add(d);
                } else {
                    d = m3812a(absolutePath2, false);
                    linkedList.add(d);
                    if (d.aq() != -1) {
                        continue;
                    } else {
                        m3895a(z ? d.m4219d().getParentFile().getName() : "", d);
                    }
                }
            }
            this.f2743g.m681f();
            this.f2743g.m678c();
        } catch (Exception e) {
            e.printStackTrace();
            this.f2743g.m678c();
        } catch (Throwable th) {
            this.f2747k.mo1096b();
            m3949x();
            return linkedList;
        }
        this.f2747k.mo1096b();
        m3949x();
        return linkedList;
    }

    /* renamed from: a */
    public C0800c m3876a(File file) {
        C0800c d = m3920d(file.getPath());
        return d != null ? d : m3812a(file.getPath(), true);
    }

    /* renamed from: a */
    public List<C0800c> m3881a(File... fileArr) {
        return mo969a(Arrays.asList(fileArr), false);
    }

    /* renamed from: a */
    protected C0800c m3873a(DkStoreBookDetail dkStoreBookDetail, DkCloudBookManifest dkCloudBookManifest) {
        try {
            this.f2747k.mo1090a();
            C0800c b = m3906b(dkStoreBookDetail.getBook().getBookUuid());
            if (b != null) {
                return b;
            }
            int i;
            File file = new File(this.f2742f.getCloudBookDirectory(), dkStoreBookDetail.getBook().getBookUuid() + "." + dkCloudBookManifest.getBookRevision() + ".epub");
            DkPublic.rm(file);
            String uri = Uri.fromFile(file).toString();
            C0800c a = m3864a(BookFormat.EPUB, BookPackageType.EPUB, BookType.NORMAL, BookState.CLOUD_ONLY);
            a.m4224e(dkStoreBookDetail.getBook().getBookUuid());
            a.m4196a(uri);
            a.m4207b(dkStoreBookDetail.getEpubSize());
            a.m4227f(dkCloudBookManifest.getBookRevision());
            a.m4176a(System.currentTimeMillis());
            a.mo955p(dkStoreBookDetail.getBook().getTitle());
            a.m4184a(BookType.NORMAL);
            if (dkStoreBookDetail.getBook().isFree()) {
                i = 0;
            } else {
                i = dkStoreBookDetail.getBook().getNewPrice();
            }
            a.m4175a(i);
            a.m4221d(dkStoreBookDetail.getBook().getNameLine());
            a.m4186a(m3905b(dkStoreBookDetail));
            a.m4212b(dkStoreBookDetail.getBook().getCoverUri());
            if (PersonalPrefs.m5175a().m5250z()) {
                dd a2 = de.m4313a().m4338a(a.aq(), a.ar());
                if (a2 != null) {
                    a.m4220d(a2.f3004c);
                }
            }
            m3925e(a);
            C0651y bookCertification = dkCloudBookManifest.getBookCertification();
            if (bookCertification != null && bookCertification.f2184b.length > 0 && bookCertification.f2185c.length > 0) {
                a.mo1011a(new ad(this.f2742f.getDeviceIdVersion(), bookCertification.f2183a, C0366o.m1031a(bookCertification.f2184b) + "\n" + C0366o.m1031a(bookCertification.f2185c), 0));
                a.m4183a(BookLimitType.NONE);
            }
            m3895a("", a);
            this.f2747k.mo1096b();
            return a;
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: a */
    private C0800c m3811a(DkStoreBookDetail dkStoreBookDetail, C0651y c0651y) {
        C0800c b = m3906b(dkStoreBookDetail.getBook().getBookUuid());
        if (b != null) {
            m3886a(b, true);
        }
        File file = new File(this.f2742f.getCloudBookDirectory(), dkStoreBookDetail.getBook().getBookUuid() + "." + dkStoreBookDetail.getRevision() + ".epub");
        DkPublic.rm(file);
        String uri = Uri.fromFile(file).toString();
        C0800c a = m3864a(BookFormat.EPUB, BookPackageType.EPUB, BookType.NORMAL, BookState.CLOUD_ONLY);
        a.m4224e(dkStoreBookDetail.getBook().getBookUuid());
        a.m4196a(uri);
        a.m4207b(dkStoreBookDetail.getEpubSize());
        a.m4227f(dkStoreBookDetail.getRevision());
        a.m4176a(System.currentTimeMillis());
        a.mo955p(dkStoreBookDetail.getBook().getTitle());
        a.m4183a(BookLimitType.TIME);
        a.m4175a(dkStoreBookDetail.getBook().isFree() ? 0 : dkStoreBookDetail.getBook().getNewPrice());
        a.m4221d(dkStoreBookDetail.getBook().getNameLine());
        a.m4186a(m3905b(dkStoreBookDetail));
        a.m4212b(dkStoreBookDetail.getBook().getCoverUri());
        if (PersonalPrefs.m5175a().m5250z()) {
            dd a2 = de.m4313a().m4338a(a.aq(), a.ar());
            if (a2 != null) {
                a.m4220d(a2.f3004c);
            }
        }
        m3925e(a);
        a.mo1011a(new ad(this.f2742f.getDeviceIdVersion(), 100, C0366o.m1031a(c0651y.f2184b) + "\n" + C0366o.m1031a(c0651y.f2185c), c0651y.f2186d));
        m3895a("", a);
        return a;
    }

    /* renamed from: a */
    private void m3823a(C0800c c0800c, String str) {
        UThread.runOnThread(new id(this, c0800c, str));
    }

    /* renamed from: g */
    private boolean m3847g(C0800c c0800c) {
        if (!PersonalPrefs.m5175a().m5250z() || c0800c.aq() == -1) {
            return false;
        }
        if (c0800c.m4242o() == BookType.TRIAL && DkUserPurchasedBooksManager.m5029a().m5052a(c0800c.getId()) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private C0800c m3835b(DkStoreBookDetail dkStoreBookDetail, C0651y c0651y, af<Boolean> afVar) {
        try {
            this.f2747k.mo1090a();
            C0800c b = m3906b(dkStoreBookDetail.getBook().getBookUuid());
            if (b == null) {
                this.f2747k.mo1096b();
                return b;
            }
            int i;
            File file = new File(this.f2742f.getCloudBookDirectory(), dkStoreBookDetail.getBook().getBookUuid() + "." + dkStoreBookDetail.getRevision() + ".epub");
            DkPublic.rm(file);
            b.m4196a(Uri.fromFile(file).toString());
            b.m4207b(dkStoreBookDetail.getEpubSize());
            b.m4227f(dkStoreBookDetail.getRevision());
            if (dkStoreBookDetail.getBook().isFree()) {
                i = 0;
            } else {
                i = dkStoreBookDetail.getBook().getNewPrice();
            }
            b.m4175a(i);
            b.m4221d(dkStoreBookDetail.getBook().getNameLine());
            b.m4186a(m3905b(dkStoreBookDetail));
            m3928f(b);
            b.mo1011a(new ad(this.f2742f.getDeviceIdVersion(), 100, C0366o.m1031a(c0651y.f2184b) + "\n" + C0366o.m1031a(c0651y.f2185c), c0651y.f2186d));
            this.f2743g.m677b();
            b.aO();
            this.f2743g.m681f();
            this.f2743g.m678c();
            b.m4198a(b.m4225f(), dkStoreBookDetail.getEpubUri(), dkStoreBookDetail.getRevision(), dkStoreBookDetail.getEpubMd5(), true, afVar);
            m3949x();
            this.f2747k.mo1096b();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            this.f2743g.m678c();
            this.f2747k.mo1096b();
            return null;
        } catch (Throwable th) {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: b */
    private C0800c m3834b(is isVar) {
        File file = new File(mo968a(isVar));
        String uri = Uri.fromFile(file).toString();
        C0800c c = m3917c(uri);
        if (c == null) {
            BookPackageType bookPackageType;
            DkPublic.rm(file);
            BookFormat r = C0800c.m4145r(CommonUtils.m601a(isVar.m4682b()).toUpperCase(Locale.US));
            switch (hv.f3329a[r.ordinal()]) {
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
            c = m3864a(r, bookPackageType, BookType.NORMAL, BookState.CLOUD_ONLY);
            c.m4196a(uri);
            c.m4176a(System.currentTimeMillis());
            c.mo955p(CommonUtils.m610c(isVar.m4680a().m8162l()));
            c.m4184a(BookType.NORMAL);
            c.m4207b(isVar.m4684d());
            c.m4186a(new ab());
            c.m4189a(isVar);
            m3925e(c);
            if (PersonalPrefs.m5175a().m5250z()) {
                dd a = de.m4313a().m4338a(c.aq(), c.ar());
                if (a != null) {
                    c.m4220d(a.f3004c);
                }
            }
            c.m4190a(new ke(c.mo1039q(), null));
            m3895a("", c);
        }
        return c;
    }

    /* renamed from: b */
    private C0800c m3833b(C0800c c0800c, is isVar, af<Boolean> afVar) {
        if (isVar == null) {
            return null;
        }
        if (c0800c.am() == null) {
            return null;
        }
        if (!c0800c.am().m4686f().equals(isVar.m4686f())) {
            return null;
        }
        if (m3863a(c0800c.aH()) == null) {
            return null;
        }
        File file = new File(c0800c.m4222e());
        if (c0800c.m4233i() == BookState.NORMAL && file.exists()) {
            return c0800c;
        }
        File file2 = new File(mo968a(c0800c.am()));
        String uri = Uri.fromFile(file2).toString();
        DkPublic.rm(file2);
        c0800c.m4189a(isVar);
        c0800c.m4196a(uri);
        this.f2743g.m677b();
        try {
            c0800c.aO();
            this.f2743g.m681f();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            uri = this.f2743g;
            uri.m678c();
        }
        c0800c.m4198a(uri, "kuaipan:///" + c0800c.am().m4686f() + "?info=" + isVar.m4680a().m8150a(), "", "", true, afVar);
        m3949x();
        return c0800c;
    }

    /* renamed from: a */
    private C0800c m3812a(String str, boolean z) {
        C0800c c0800c;
        BookPackageType bookPackageType;
        File file = new File(str);
        String j = m3853j(str);
        String name = file.getName();
        Iterator it = m3877a(Column.FILE_SIZE + "=?", new String[]{String.valueOf(file.length())}).iterator();
        while (it.hasNext()) {
            c0800c = (C0800c) it.next();
            if (c0800c.aq() == 3 && c0800c.am().m4682b().equals(name)) {
                c0800c.m4197a(str, j);
                break;
            }
        }
        BookFormat r = C0800c.m4145r(CommonUtils.m601a(str).toUpperCase(Locale.US));
        switch (hv.f3329a[r.ordinal()]) {
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
            c0800c = m3832b(r, bookPackageType, BookType.NORMAL, BookState.NORMAL);
        } else {
            c0800c = m3864a(r, bookPackageType, BookType.NORMAL, BookState.NORMAL);
        }
        c0800c.m4224e(j);
        c0800c.m4196a(Uri.fromFile(file).toString());
        c0800c.m4176a(System.currentTimeMillis());
        c0800c.m4184a(BookType.NORMAL);
        c0800c.m4207b(file.length());
        c0800c.m4186a(new ab());
        m3925e(c0800c);
        c0800c.m4253y();
        if (TextUtils.isEmpty(c0800c.ay())) {
            c0800c.mo955p(CommonUtils.m610c(str));
        }
        c0800c.m4190a(new ke(c0800c.mo1039q(), null));
        return c0800c;
    }

    /* renamed from: b */
    private C0800c m3832b(BookFormat bookFormat, BookPackageType bookPackageType, BookType bookType, BookState bookState) {
        return m3809a(m3801A(), bookFormat, bookPackageType, bookType, bookState, true);
    }

    /* renamed from: a */
    protected C0800c m3864a(BookFormat bookFormat, BookPackageType bookPackageType, BookType bookType, BookState bookState) {
        return m3809a(m3801A(), bookFormat, bookPackageType, bookType, bookState, false);
    }

    /* renamed from: a */
    private C0800c m3809a(long j, BookFormat bookFormat, BookPackageType bookPackageType, BookType bookType, BookState bookState, boolean z) {
        C0800c fpVar;
        switch (hv.f3329a[bookFormat.ordinal()]) {
            case 1:
                fpVar = new fp(this.f2747k, j, bookPackageType, bookType, bookState, z, false);
                break;
            case 2:
                fpVar = new kb(this.f2747k, j, bookPackageType, bookType, bookState, z, false);
                break;
            case 5:
                fpVar = new kh(this.f2747k, j, bookPackageType, bookType, bookState, z, false);
                break;
            default:
                fpVar = new lo(this.f2747k, j, bookPackageType, bookType, bookState, z, false);
                break;
        }
        this.f2743g.m677b();
        try {
            this.f2743g.m674a("DELETE FROM annotations WHERE book_id = ?", new String[]{fpVar.aH() + ""});
            this.f2743g.m681f();
        } catch (Exception e) {
        } finally {
            this.f2743g.m678c();
        }
        fpVar.av();
        return fpVar;
    }

    /* renamed from: a */
    private C0800c m3810a(Cursor cursor) {
        C0800c fpVar;
        switch (hv.f3329a[C0800c.m4145r(cursor.getString(CommonColumn.BOOK_FORMAT.ordinal())).ordinal()]) {
            case 1:
                fpVar = new fp(this.f2747k, cursor);
                break;
            case 2:
                fpVar = new kb(this.f2747k, cursor);
                break;
            case 5:
                fpVar = new kh(this.f2747k, cursor);
                break;
            default:
                fpVar = new lo(this.f2747k, cursor);
                break;
        }
        if (fpVar.m4247s() == BookPackageType.EPUB_OPF && (fpVar.m4233i() == BookState.PULLING || fpVar.m4233i() == BookState.UPDATING)) {
            fpVar.aQ();
        }
        return fpVar;
    }

    /* renamed from: j */
    private String m3853j(String str) {
        return DkUtils.calcUniversalBookId(str);
    }

    /* renamed from: a */
    protected void mo970a(String str, int i, List<C0800c> list) {
        try {
            aa l;
            Object obj;
            this.f2747k.mo1090a();
            if (TextUtils.isEmpty(str)) {
                l = m3937l();
                obj = null;
            } else {
                aa g = m3929g(str);
                if (g != null) {
                    l = g;
                    obj = null;
                } else {
                    l = m3932h(str);
                    int obj2 = 1;
                }
            }
            for (an anVar : list) {
                l.m3753a(i, anVar);
                anVar.aP();
                this.f2744h.put(Long.valueOf(anVar.aH()), anVar);
                i++;
            }
            this.f2743g.m677b();
            for (C0800c aO : list) {
                aO.aO();
            }
            l.aO();
            if (obj2 != null) {
                m3937l().aO();
            }
            this.f2743g.m681f();
            this.f2743g.m678c();
        } catch (Throwable e) {
            WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs", e);
            this.f2743g.m678c();
        } catch (Throwable th) {
            this.f2747k.mo1096b();
        }
        this.f2747k.mo1096b();
    }

    /* renamed from: a */
    public void m3895a(String str, C0800c c0800c) {
        m3893a(str, 0, c0800c);
    }

    /* renamed from: a */
    public void m3893a(String str, int i, C0800c c0800c) {
        mo970a(str, i, Lists.newArrayList(c0800c));
    }

    /* renamed from: a */
    public void m3896a(String str, List<C0800c> list) {
        mo970a(str, 0, (List) list);
    }

    /* renamed from: a */
    public void m3886a(C0800c c0800c, boolean z) {
        try {
            this.f2747k.mo1090a();
            m3915b(Arrays.asList(new C0800c[]{c0800c}), z);
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: b */
    public void m3915b(List<C0800c> list, boolean z) {
        try {
            this.f2747k.mo1090a();
            m3840c((List) list, z);
            m3803C();
            m3949x();
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: k */
    public void m3936k() {
        new ie(this, aq.f2771a).open();
    }

    /* renamed from: c */
    private void m3840c(List<C0800c> list, boolean z) {
        this.f2743g.m677b();
        try {
            for (C0800c c0800c : list) {
                String I;
                m3821a(c0800c, m3862a((an) c0800c), z);
                C1167a d = C1167a.m8671d();
                if (c0800c.ak()) {
                    I = c0800c.getId();
                } else {
                    I = c0800c.ay();
                }
                d.m8678a(I, c0800c.m4155H().f3455c);
            }
            this.f2743g.m681f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.f2743g.m678c();
        }
    }

    /* renamed from: a */
    private void m3821a(C0800c c0800c, aa aaVar, boolean z) {
        if (this.f2744h.containsKey(Long.valueOf(c0800c.aH()))) {
            this.f2743g.m677b();
            try {
                if (c0800c.m4171X()) {
                    c0800c.ad();
                } else if (c0800c.m4169V()) {
                    it.m4692a().m4720a(c0800c.m4219d());
                }
                c0800c.aj();
                if (z && c0800c.af()) {
                    FileUtil.deleteFile(c0800c.m4219d());
                }
                aaVar.m3760b(c0800c);
                aaVar.aO();
                this.f2743g.m673a(String.format("DELETE FROM %1$s WHERE _id = %2$s", new Object[]{"books", Long.valueOf(c0800c.aH())}));
                this.f2744h.remove(Long.valueOf(c0800c.aH()));
                this.f2743g.m681f();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.f2743g.m678c();
            }
            m3849h(c0800c);
        }
    }

    /* renamed from: h */
    private void m3849h(C0800c c0800c) {
        UThread.runOnThread(new C0814if(this, c0800c));
    }

    /* renamed from: a */
    public void m3899a(C0800c[] c0800cArr, aa aaVar) {
        m3900a(c0800cArr, aaVar, null);
    }

    /* renamed from: a */
    public void m3900a(C0800c[] c0800cArr, aa aaVar, Runnable runnable) {
        try {
            this.f2747k.mo1090a();
            this.f2743g.m677b();
            HashSet hashSet = new HashSet();
            for (an anVar : c0800cArr) {
                aa a = m3862a(anVar);
                a.m3760b(anVar);
                aaVar.m3753a(0, anVar);
                hashSet.add(a);
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((aa) it.next()).aO();
            }
            aaVar.aO();
            this.f2743g.m681f();
            if (runnable != null) {
                runnable.run();
            }
            this.f2743g.m678c();
        } catch (Throwable th) {
            this.f2747k.mo1096b();
        }
        m3939n();
        m3949x();
        m3828a(aaVar.m3770k(), Arrays.asList(c0800cArr));
        this.f2747k.mo1096b();
    }

    /* renamed from: b */
    public aa m3904b(long j) {
        return (aa) this.f2751p.get(Long.valueOf(j));
    }

    /* renamed from: a */
    public aa m3862a(an anVar) {
        for (aa aaVar : this.f2751p.values()) {
            if (aaVar.m3762c(anVar)) {
                return aaVar;
            }
        }
        return null;
    }

    /* renamed from: l */
    public aa m3937l() {
        return m3904b(-9);
    }

    /* renamed from: m */
    public List<aa> m3938m() {
        List linkedList = new LinkedList();
        aa l = m3937l();
        linkedList.add(l);
        for (an anVar : l.m3768i()) {
            if (anVar instanceof aa) {
                linkedList.add((aa) anVar);
            }
        }
        return linkedList;
    }

    /* renamed from: g */
    public aa m3929g(String str) {
        for (aa aaVar : this.f2751p.values()) {
            if (aaVar.m3770k().equals(str)) {
                return aaVar;
            }
        }
        return null;
    }

    /* renamed from: h */
    public aa m3932h(String str) {
        try {
            this.f2747k.mo1090a();
            aa a = m3861a(m3937l().m3765f(), str);
            return a;
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: a */
    public aa m3861a(int i, String str) {
        Throwable th;
        try {
            this.f2747k.mo1090a();
            an g = m3929g(str);
            if (g != null) {
                this.f2747k.mo1096b();
                return g;
            }
            aa aaVar;
            this.f2743g.m677b();
            try {
                aaVar = new aa(this.f2747k, m3802B(), false);
                try {
                    aaVar.mo955p(str);
                    aa l = m3937l();
                    int max = Math.max(0, Math.min(i, l.m3765f()));
                    l.m3753a(max, (an) aaVar);
                    this.f2751p.put(Long.valueOf(aaVar.aH()), aaVar);
                    this.f2737H.addCategory(l, aaVar, max);
                    aaVar.aO();
                    l.aO();
                    this.f2743g.m681f();
                    this.f2743g.m678c();
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    this.f2743g.m678c();
                    this.f2747k.mo1096b();
                    return aaVar;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                aaVar = g;
                th = th4;
                th.printStackTrace();
                this.f2743g.m678c();
                this.f2747k.mo1096b();
                return aaVar;
            }
            this.f2747k.mo1096b();
            return aaVar;
        } catch (Throwable th5) {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: A */
    private long m3801A() {
        long j = this.f2731B + 1;
        this.f2731B = j;
        return j;
    }

    /* renamed from: B */
    private long m3802B() {
        long j = this.f2732C - 1;
        this.f2732C = j;
        return j;
    }

    /* renamed from: a */
    public boolean m3902a(aa aaVar, String str) {
        try {
            this.f2747k.mo1090a();
            if (C0543b.m2423a(aaVar.m3770k(), str)) {
                this.f2747k.mo1096b();
                return true;
            } else if (m3929g(str) != null) {
                return false;
            } else {
                aaVar.mo955p(str);
                aaVar.aN();
                m3828a(str, Arrays.asList(aaVar.m3763d()));
                this.f2747k.mo1096b();
                return true;
            }
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: a */
    private void m3828a(String str, Collection<C0800c> collection) {
        UThread.runOnThread(new ig(this, collection, str));
    }

    /* renamed from: a */
    public void m3883a(aa aaVar, boolean z, boolean z2) {
        try {
            this.f2747k.mo1090a();
            m3819a(aaVar, z);
            if (z2) {
                m3949x();
            }
            this.f2747k.mo1096b();
        } catch (Throwable th) {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: n */
    public void m3939n() {
        int i = 0;
        try {
            this.f2747k.mo1090a();
            this.f2743g.m677b();
            for (aa aaVar : this.f2751p.values()) {
                if (aaVar.m3761c()) {
                    i++;
                    m3883a(aaVar, true, false);
                }
                i = i;
            }
            this.f2743g.m681f();
            if (i > 0) {
                m3949x();
            }
            this.f2743g.m678c();
        } catch (Exception e) {
            e.printStackTrace();
            this.f2743g.m678c();
        } catch (Throwable th) {
            this.f2747k.mo1096b();
        }
        this.f2747k.mo1096b();
    }

    /* renamed from: a */
    private void m3819a(aa aaVar, boolean z) {
        this.f2743g.m677b();
        try {
            for (an anVar : aaVar.m3764e()) {
                if (anVar instanceof aa) {
                    m3819a((aa) anVar, z);
                } else if (anVar instanceof C0800c) {
                    m3821a((C0800c) anVar, aaVar, z);
                }
            }
            m3937l().m3760b(aaVar);
            m3937l().aO();
            if (!aaVar.m3767h()) {
                this.f2743g.m673a(String.format("DELETE FROM %1$s WHERE _id = %2$s", new Object[]{"book_categories", Long.valueOf(aaVar.aH())}));
                this.f2751p.remove(Long.valueOf(aaVar.aH()));
            }
            this.f2743g.m681f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.f2743g.m678c();
        }
    }

    /* renamed from: C */
    private void m3803C() {
        this.f2743g.m677b();
        try {
            for (aa aaVar : this.f2751p.values()) {
                if (aaVar.m3761c()) {
                    m3819a(aaVar, true);
                }
            }
            this.f2743g.m681f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.f2743g.m678c();
        }
    }

    /* renamed from: a */
    public void m3888a(io ioVar) {
        try {
            this.f2747k.mo1090a();
            if (ioVar != null) {
                if (this.f2745i != null) {
                    ioVar.mo1701a();
                }
                this.f2736G.addIfAbsent(ioVar);
            }
            this.f2747k.mo1096b();
        } catch (Throwable th) {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: b */
    public void m3911b(io ioVar) {
        try {
            this.f2747k.mo1090a();
            this.f2736G.remove(ioVar);
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: o */
    protected void m3940o() {
        try {
            this.f2747k.mo1090a();
            if (this.f2745i == null) {
                this.f2745i = new ik(this);
                Iterator it = this.f2736G.iterator();
                while (it.hasNext()) {
                    ((io) it.next()).mo1701a();
                }
                this.f2747k.mo1096b();
            }
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: p */
    protected void m3941p() {
        try {
            this.f2747k.mo1090a();
            if (this.f2745i != null) {
                m3943r();
                this.f2745i = null;
                Iterator it = this.f2736G.iterator();
                while (it.hasNext()) {
                    ((io) it.next()).mo1705b();
                }
                this.f2747k.mo1096b();
            }
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: i */
    protected void m3933i(String str) {
        try {
            this.f2747k.mo1090a();
            if (this.f2745i != null) {
                this.f2745i = null;
                m3943r();
                Iterator it = this.f2736G.iterator();
                while (it.hasNext()) {
                    ((io) it.next()).mo1702a(str);
                }
                this.f2747k.mo1096b();
            }
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: q */
    public boolean m3942q() {
        try {
            this.f2747k.mo1090a();
            if (this.f2735F) {
                return false;
            }
            this.f2735F = true;
            this.f2747k.mo1096b();
            return true;
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: r */
    public void m3943r() {
        try {
            this.f2747k.mo1090a();
            this.f2735F = false;
            m3844d(this.f2757v);
            this.f2757v.clear();
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: s */
    public void m3944s() {
        try {
            this.f2747k.mo1090a();
            if (this.f2745i != null) {
                this.f2745i.cancel(false);
                this.f2745i = null;
                m3943r();
                Iterator it = this.f2736G.iterator();
                while (it.hasNext()) {
                    ((io) it.next()).mo1702a("");
                }
                this.f2747k.mo1096b();
            }
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: a */
    public void m3882a(aa aaVar, an anVar, int i) {
        if (ReaderEnv.get().getBookShelfType() == BookShelfType.Simple) {
            this.f2737H.moveItem(aaVar, anVar, i);
        } else {
            aaVar.m3757a(anVar, i);
        }
    }

    /* renamed from: t */
    protected void m3945t() {
        UThread.post(new ih(this));
    }

    /* renamed from: a */
    protected void m3891a(jx jxVar) {
        int i;
        int i2;
        ArrayList D = m3804D();
        ArrayList arrayList = new ArrayList();
        Iterator it = D.iterator();
        while (it.hasNext()) {
            C0800c c0800c = (C0800c) it.next();
            is a = it.m4690a(c0800c, jxVar.m4791c());
            if (a != null) {
                c0800c.m4189a(a);
                arrayList.add(c0800c);
            }
        }
        if (!arrayList.isEmpty()) {
            int i3;
            for (i = 0; i < arrayList.size(); i = i3) {
                this.f2747k.mo1090a();
                this.f2743g.m677b();
                i2 = 0;
                i3 = i;
                while (i3 < arrayList.size() && i2 < 50) {
                    try {
                        ((C0800c) arrayList.get(i3)).aN();
                        i3++;
                        i2++;
                    } catch (Throwable th) {
                        this.f2747k.mo1096b();
                    }
                }
                this.f2743g.m681f();
                this.f2743g.m678c();
                this.f2747k.mo1096b();
            }
        }
        D = m3805E();
        HashMap hashMap = new HashMap();
        Iterator it2 = D.iterator();
        i2 = 0;
        while (it2.hasNext()) {
            c0800c = (C0800c) it2.next();
            ArrayList arrayList2 = (ArrayList) hashMap.get(c0800c.ar());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(1);
                hashMap.put(c0800c.ar(), arrayList2);
                arrayList = arrayList2;
            } else {
                arrayList = arrayList2;
            }
            C0800c c0800c2 = arrayList.size() == 0 ? null : (C0800c) arrayList.get(0);
            if (c0800c2 == null) {
                arrayList.add(c0800c);
                i = i2;
            } else if (c0800c2.m4233i() != BookState.NORMAL) {
                arrayList.add(0, c0800c);
                i = 1;
            } else if (c0800c.m4233i() != BookState.NORMAL) {
                arrayList.add(c0800c);
                i = 1;
            } else if (c0800c.ap()) {
                arrayList.add(c0800c);
                i = 1;
            } else {
                arrayList.add(0, c0800c);
                i = 1;
            }
            i2 = i;
        }
        if (i2 != 0) {
            try {
                this.f2747k.mo1090a();
                this.f2743g.m677b();
                for (ArrayList D2 : hashMap.values()) {
                    for (int i4 = 1; i4 < D2.size(); i4++) {
                        m3885a((C0800c) D2.get(i4));
                    }
                }
                this.f2743g.m681f();
                this.f2743g.m678c();
                this.f2747k.mo1096b();
            } catch (Throwable th2) {
                this.f2747k.mo1096b();
            }
        }
    }

    /* renamed from: b */
    protected final ab m3905b(DkStoreBookDetail dkStoreBookDetail) {
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

    /* renamed from: a */
    protected C0800c m3866a(bt btVar, DkCloudPurchasedFiction dkCloudPurchasedFiction, long j) {
        C0800c b = m3906b(dkCloudPurchasedFiction.getBookUuid());
        if (b != null) {
            if (b.az() < j) {
                b.m4220d(j);
            }
            b.aN();
        } else {
            String bookUuid = dkCloudPurchasedFiction.getBookUuid();
            b = (ee) m3864a(C0800c.m4143o(bookUuid) ? BookFormat.SBK : BookFormat.EPUB, BookPackageType.DIRECTORY, BookType.SERIAL, BookState.CLOUD_ONLY);
            b.m4224e(bookUuid);
            b.m4196a(Uri.fromFile(new File(this.f2742f.getCloudBookDirectory(), dkCloudPurchasedFiction.getBookUuid())).toString());
            b.mo955p(dkCloudPurchasedFiction.getTitle());
            b.m4176a(btVar.f2861e);
            b.m4220d(j);
            BookContent bookContent = C0800c.m4143o(bookUuid) ? dkCloudPurchasedFiction.isVerticalComic() ? BookContent.VERTICAL_COMIC : BookContent.PAGE_COMIC : BookContent.NORMAL;
            b.m4182a(bookContent);
            b.m4175a(0);
            b.m4221d(dkCloudPurchasedFiction.getAuthorLine());
            b.m4212b(dkCloudPurchasedFiction.getCoverUri());
            b.m4418c(null);
            m3925e(b);
            m3895a(btVar.f2859c, b);
        }
        return b;
    }

    /* renamed from: a */
    protected C0800c m3865a(bt btVar, is isVar, long j) {
        try {
            this.f2747k.mo1090a();
            String uri = Uri.fromFile(new File(mo968a(isVar))).toString();
            C0800c c = m3917c(uri);
            if (c != null) {
                if (c.az() < j) {
                    c.m4220d(j);
                }
                c.aN();
            } else {
                BookPackageType bookPackageType;
                BookFormat r = C0800c.m4145r(CommonUtils.m601a(isVar.m4682b()).toUpperCase(Locale.US));
                switch (hv.f3329a[r.ordinal()]) {
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
                c = m3864a(r, bookPackageType, BookType.NORMAL, BookState.CLOUD_ONLY);
                c.m4196a(uri);
                c.m4176a(btVar.f2861e);
                c.m4220d(j);
                c.mo955p(CommonUtils.m610c(isVar.m4680a().m8162l()));
                c.m4184a(BookType.NORMAL);
                c.m4207b(isVar.m4684d());
                c.m4186a(new ab());
                c.m4189a(isVar);
                m3925e(c);
                c.m4190a(new ke(c.mo1039q(), null));
                m3895a(btVar.f2859c, c);
                this.f2747k.mo1096b();
            }
            return c;
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: a */
    protected void m3884a(bt btVar, C0800c c0800c) {
        Object obj = null;
        try {
            this.f2747k.mo1090a();
            if (this.f2744h.containsKey(Long.valueOf(c0800c.aH()))) {
                this.f2743g.m677b();
                aa b = m3904b(c0800c.aJ());
                if (b != null) {
                    b.m3760b(c0800c);
                    b.aO();
                }
                b = m3929g(btVar.f2859c);
                if (b == null) {
                    b = m3932h(btVar.f2859c);
                    obj = 1;
                }
                b.m3753a(0, (an) c0800c);
                b.aO();
                if (obj != null) {
                    m3937l().aO();
                }
                c0800c.m4176a(btVar.f2861e);
                c0800c.aO();
                this.f2743g.m681f();
                this.f2743g.m678c();
                this.f2747k.mo1096b();
                return;
            }
            this.f2747k.mo1096b();
        } catch (Exception e) {
            e.printStackTrace();
            this.f2743g.m678c();
        } catch (Throwable th) {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: a */
    protected void m3885a(C0800c c0800c) {
        try {
            this.f2747k.mo1090a();
            if (this.f2744h.containsKey(Long.valueOf(c0800c.aH()))) {
                this.f2743g.m677b();
                if (c0800c.m4171X()) {
                    c0800c.ad();
                }
                aa b = m3904b(c0800c.aJ());
                if (b != null) {
                    b.m3760b(c0800c);
                    b.aO();
                }
                this.f2743g.m673a(String.format("DELETE FROM %1$s WHERE _id = %2$s", new Object[]{"books", Long.valueOf(c0800c.aH())}));
                this.f2744h.remove(Long.valueOf(c0800c.aH()));
                this.f2743g.m681f();
                this.f2743g.m678c();
                this.f2747k.mo1096b();
                return;
            }
            this.f2747k.mo1096b();
        } catch (Exception e) {
            e.printStackTrace();
            this.f2743g.m678c();
        } catch (Throwable th) {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: u */
    protected void m3946u() {
        Iterator it;
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.f2744h);
        while (!hashMap.isEmpty()) {
            for (C0800c c0800c : hashMap.values()) {
                C0800c c0800c2;
                c0800c2.m4214c();
                if (c0800c2.ao()) {
                    c0800c2.am().m4687g();
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.putAll(this.f2744h);
            Map hashMap3 = new HashMap();
            for (C0800c c0800c22 : hashMap2.values()) {
                if (!hashMap.containsKey(Long.valueOf(c0800c22.aH()))) {
                    hashMap3.put(Long.valueOf(c0800c22.aH()), c0800c22);
                }
            }
            hashMap.clear();
            hashMap.putAll(hashMap3);
        }
        hashMap = new HashMap();
        hashMap.putAll(this.f2751p);
        while (!hashMap.isEmpty()) {
            for (aa a : hashMap.values()) {
                aa a2;
                a2.m3752a();
            }
            new HashMap().putAll(this.f2751p);
            hashMap3 = new HashMap();
            for (aa a22 : hashMap3.values()) {
                if (!hashMap.containsKey(Long.valueOf(a22.aH()))) {
                    hashMap3.put(Long.valueOf(a22.aH()), a22);
                }
            }
            hashMap.clear();
            hashMap.putAll(hashMap3);
        }
        try {
            this.f2747k.mo1090a();
            ArrayList arrayList = new ArrayList();
            for (aa a222 : hashMap.values()) {
                if (!a222.m3767h() && (a222.m3765f() == 0 || !a222.aK())) {
                    arrayList.add(a222);
                }
            }
            if (!arrayList.isEmpty()) {
                this.f2743g.m677b();
                it = arrayList.iterator();
                while (it.hasNext()) {
                    a222 = (aa) it.next();
                    if (a222.aK()) {
                        m3937l().m3760b(a222);
                        m3937l().aN();
                    }
                    if (a222.m3765f() > 0) {
                        a222.m3769j();
                    }
                    this.f2743g.m673a(String.format("DELETE FROM %1$s WHERE _id = %2$s", new Object[]{"book_categories", Long.valueOf(a222.aH())}));
                    this.f2751p.remove(Long.valueOf(a222.aH()));
                }
                this.f2743g.m681f();
                this.f2743g.m678c();
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.f2743g.m678c();
        } catch (Throwable th) {
            this.f2747k.mo1096b();
        }
        ArrayList arrayList2 = new ArrayList();
        for (C0800c c0800c222 : this.f2744h.values()) {
            if (!c0800c222.aK()) {
                arrayList2.add(c0800c222);
            }
        }
        if (!arrayList2.isEmpty()) {
            this.f2743g.m677b();
            try {
                it = arrayList2.iterator();
                while (it.hasNext()) {
                    c0800c222 = (C0800c) it.next();
                    this.f2743g.m673a(String.format("DELETE FROM %1$s WHERE _id = %2$s", new Object[]{"books", Long.valueOf(c0800c222.aH())}));
                    this.f2744h.remove(Long.valueOf(c0800c222.aH()));
                }
                this.f2743g.m681f();
            } catch (Exception e2) {
                e2.printStackTrace();
            } finally {
                this.f2743g.m678c();
            }
        }
        this.f2747k.mo1096b();
    }

    /* renamed from: v */
    protected HashMap<String, C0800c> m3947v() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f2744h.values());
        HashMap<String, C0800c> hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0800c c0800c = (C0800c) it.next();
            if (c0800c.aq() != -1) {
                hashMap.put(c0800c.ar(), c0800c);
            }
        }
        return hashMap;
    }

    /* renamed from: D */
    private ArrayList<C0800c> m3804D() {
        return m3815a(new he(this));
    }

    /* renamed from: E */
    private ArrayList<C0800c> m3805E() {
        return m3815a(new hf(this));
    }

    /* renamed from: F */
    private ArrayList<C0800c> m3806F() {
        return m3815a(new hg(this));
    }

    /* renamed from: a */
    private ArrayList<C0800c> m3815a(IRunTask<C0800c> runTask) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f2744h.values());
        ArrayList<C0800c> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0800c c0800c = (C0800c) it.next();
            if (runTask.isExitRunTask(c0800c)) {
                arrayList2.add(c0800c);
            }
        }
        return arrayList2;
    }

    /* renamed from: b */
    public void m3909b(C0800c c0800c) {
        if (c0800c.az() == 0) {
            nl.m12344a().m12347b(this.f2738a);
        }
        long currentTimeMillis = System.currentTimeMillis();
        c0800c.m4220d(currentTimeMillis);
        c0800c.m4215c(currentTimeMillis);
        if (!c0800c.aI()) {
            if (c0800c.aJ() != -9) {
                an b = m3904b(c0800c.aJ());
                if (b != null) {
                    this.f2737H.moveItem(m3937l(), b, 0);
                    this.f2737H.moveItem(b, c0800c, 0);
                }
            } else {
                this.f2737H.moveItem(m3937l(), c0800c, 0);
            }
            c0800c.aN();
            m3949x();
        }
        m3852i(c0800c);
    }

    /* renamed from: c */
    public void m3918c(C0800c c0800c) {
        if (c0800c.aJ() != -9) {
            aa b = m3904b(c0800c.aJ());
            if (b != null) {
                m3882a(m3937l(), (an) b, 0);
                m3882a(b, (an) c0800c, 0);
            }
        } else {
            m3882a(m3937l(), (an) c0800c, 0);
        }
        c0800c.aN();
        m3949x();
    }

    /* renamed from: i */
    private void m3852i(C0800c c0800c) {
        UThread.runOnThread(new hh(this, c0800c));
    }

    /* renamed from: d */
    public void m3922d(C0800c c0800c) {
        try {
            this.f2747k.mo1090a();
            c0800c.m4220d(-1);
            c0800c.aN();
            UThread.runOnThread(new hi(this, c0800c));
        } finally {
            this.f2747k.mo1096b();
        }
    }

    /* renamed from: c */
    public void m3919c(List<C0800c> list) {
        try {
            this.f2747k.mo1090a();
            this.f2743g.m677b();
            for (C0800c c0800c : list) {
                c0800c.aG();
                if (c0800c.ao()) {
                    File file = new File(mo968a(c0800c.am()));
                    String uri = Uri.fromFile(file).toString();
                    DkPublic.rm(file);
                    c0800c.m4196a(uri);
                    c0800c.aN();
                }
            }
            this.f2743g.m681f();
            this.f2743g.m678c();
        } catch (Exception e) {
            e.printStackTrace();
            this.f2743g.m678c();
        } catch (Throwable th) {
            this.f2747k.mo1096b();
        }
        m3949x();
        this.f2747k.mo1096b();
    }

    /* renamed from: G */
    private void m3807G() {
        ListIterator listIterator = this.f2756u.listIterator();
        while (listIterator.hasNext()) {
            ij ijVar = (C0800c) listIterator.next();
            while (this.f2758w < 3) {
                FutureTask aF = ijVar.aF();
                if (aF == null) {
                    ijVar.m4229g(0);
                    ijVar.aN();
                    listIterator.remove();
                    break;
                }
                ijVar.f2687a.add(aF);
                this.f2758w++;
                ah.m871b(new hj(this, aF, ijVar));
            }
        }
    }

    /* renamed from: a */
    private void m3820a(C0800c c0800c, long j) {
        if (j >= 1) {
            c0800c.m4229g(j);
            c0800c.aN();
            this.f2756u.remove(c0800c);
            ListIterator listIterator = this.f2756u.listIterator();
            while (listIterator.hasNext()) {
                if (c0800c.m4163P() >= ((C0800c) listIterator.next()).m4163P()) {
                    listIterator.previous();
                    break;
                }
            }
            listIterator.add(c0800c);
        }
    }

    /* renamed from: e */
    protected void m3925e(C0800c c0800c) {
        try {
            if (TextUtils.isEmpty(c0800c.m4228g())) {
                File file = new File(Uri.parse(c0800c.m4231h()).getPath());
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (Throwable th) {
        }
        m3928f(c0800c);
    }

    /* renamed from: f */
    protected void m3928f(C0800c c0800c) {
        this.f2750o.m677b();
        try {
            this.f2750o.m673a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"typesetting", "book_id", "" + c0800c.aH()}));
            this.f2750o.m681f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.f2750o.m678c();
        }
    }

    /* renamed from: w */
    protected void m3948w() {
        if (C0559f.m2476b().m2486e()) {
            String str;
            if (this.f2760y == null) {
                str = "last_serial_update_date";
                if (System.currentTimeMillis() - this.f2742f.getPrefLong(PrivatePref.BOOKSHELF, "last_serial_update_date", 0) >= 7200000) {
                    this.f2760y = new LinkedList(Arrays.asList(m3935j()));
                    m3829a(this.f2760y, new hl(this));
                }
            }
            if (!this.f2761z) {
                str = "last_statistics_update_date";
                if (System.currentTimeMillis() - this.f2742f.getPrefLong(PrivatePref.BOOKSHELF, "last_statistics_update_date", 0) >= 3600000) {
                    this.f2761z = true;
                    C0848h.m5604a().m5619a(false, new hm(this));
                }
            }
            if (this.f2730A == null) {
                str = "last_revision_update_date";
                if (System.currentTimeMillis() - this.f2742f.getPrefLong(PrivatePref.BOOKSHELF, "last_revision_update_date", 0) >= 86400000) {
                    this.f2730A = new hn(this, C0630c.f2119a);
                    this.f2730A.open();
                }
            }
        }
    }

    /* renamed from: a */
    private void m3829a(LinkedList<C0800c> linkedList, Runnable runnable) {
        C0800c c0800c = (C0800c) linkedList.pollFirst();
        if (c0800c == null) {
            UThread.post(runnable);
        } else {
            m3822a(c0800c, new ho(this, linkedList, runnable));
        }
    }

    /* renamed from: a */
    private void m3822a(C0800c c0800c, Runnable runnable) {
        if (!(c0800c instanceof ee) || c0800c.aB()) {
            UThread.postDelayed(runnable, 200);
        } else {
            ((ee) c0800c).m4410a(false, new hs(this, runnable), new ht(this, runnable));
        }
    }

    /* renamed from: x */
    protected void m3949x() {
        UThread.removeCallbacks(this.f2755t);
        UThread.post(this.f2755t);
    }

    /* renamed from: j */
    private void m3855j(C0800c c0800c) {
        UThread.runOnThread(new hu(this, c0800c));
    }

    /* renamed from: c */
    private boolean m3842c(DkStoreBookDetail dkStoreBookDetail) {
        if (TextUtils.isEmpty(dkStoreBookDetail.getOpfUri())) {
            return false;
        }
        return fp.m4468a(dkStoreBookDetail.getFeatures());
    }
}
