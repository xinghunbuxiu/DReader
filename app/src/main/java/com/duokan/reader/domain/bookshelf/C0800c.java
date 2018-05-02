package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.duokan.common.C0259a;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.FileUtil;
import com.duokan.core.p026a.C0285n;
import com.duokan.core.p026a.C0293u;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.af;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.epublib.DKEBookInfo;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.download.DownloadFailCode;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.duokan.C0650x;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.cloud.C0847g;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudBookmark;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.cloud.DkCloudReadingInfo;
import com.duokan.reader.domain.cloud.DkCloudReadingProgress;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.cloud.DkCloudStorage.ConflictStrategy;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.document.C0808w;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0919l;
import com.duokan.reader.domain.document.C1011x;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.epub.C0936c;
import com.duokan.reader.domain.document.epub.C0952s;
import com.duokan.reader.domain.document.epub.ah;
import com.duokan.reader.domain.document.epub.ai;
import com.duokan.reader.domain.document.epub.ap;
import com.duokan.reader.domain.document.epub.aq;
import com.duokan.reader.domain.document.epub.ce;
import com.duokan.reader.domain.document.p045a.C0898a;
import com.duokan.reader.domain.document.p045a.C0904d;
import com.duokan.reader.domain.document.sbk.C0965b;
import com.duokan.reader.domain.document.sbk.C0969f;
import com.duokan.reader.domain.document.txt.C0986b;
import com.duokan.reader.domain.document.txt.C1000p;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.domain.micloud.bi;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.Column;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.CommonColumn;
import com.duokan.reader.domain.statistics.dailystats.C1167a;
import com.umeng.analytics.pro.C2295j;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;


public abstract class C0800c extends an {
    
    static final  boolean f2892C = (!C0800c.class.desiredAssertionStatus());
    
    protected LinkedList<C0837w> f2893A = null;
    
    protected boolean f2894B = false;
    
    private String f2895E = "";
    
    private String f2896F = "";
    
    private final ap<File, String> f2897G = new ap();
    
    private final ap<BookContent, String> f2898H = new ap();
    
    private final ap<is, String> f2899I = new ap();
    
    private final ap<ke, String> f2900J = new ap();
    
    private final ArrayList<C0836v> f2901K = new ArrayList();
    
    private final Set<Long> f2902L = new HashSet();
    
    private String f2903M = "";
    
    protected final AtomicInteger f2904a = new AtomicInteger(0);
    
    protected final BookPackageType f2905b;
    
    protected String f2906c = "";
    
    protected BookState f2907d = BookState.NORMAL;
    
    protected BookType f2908e = BookType.NORMAL;
    
    protected BookLimitType f2909f = BookLimitType.NONE;
    
    protected String f2910g = null;
    
    protected ab f2911h = null;
    
    protected long f2912i = 0;
    
    protected String f2913j = "本地";
    
    protected String f2914k = "";
    
    protected String f2915l = "";
    
    protected long f2916m = 0;
    
    protected long f2917n = 0;
    
    protected long f2918o = 0;
    
    protected kg f2919p = null;
    
    protected String f2920q = "";
    
    protected String f2921r = "";
    
    protected String f2922s = "";
    
    protected int f2923t = 0;
    
    protected int f2924u = 0;
    
    protected C0838x f2925v = new C0838x(this, "");
    
    protected long f2926w = 0;
    
    protected ac f2927x = new ac();
    
    protected DownloadCenterTask f2928y = null;
    
    protected C0839z f2929z = null;

    
    public abstract C0903n mo1026a(jz jzVar, C0808w c0808w);

    protected C0800c(am amVar, long j, BookPackageType bookPackageType, BookType bookType, BookState bookState, boolean z, boolean z2) {
        super(amVar, j, z, z2);
        this.f2905b = bookPackageType;
        this.f2908e = bookType;
        this.f2907d = bookState;
        this.f2898H.mo975a(BookContent.UNKNOWN);
    }

    protected C0800c(am amVar, Cursor cursor) {
        super(amVar, cursor.getLong(CommonColumn._ID.ordinal()), false, true);
        BookType q = C0800c.m4144q(cursor.getString(CommonColumn.BOOK_TYPE.ordinal()));
        BookPackageType a = C0800c.m4120a(cursor.getString(CommonColumn.PACKAGE_TYPE.ordinal()), mo1039q(), q);
        BookLimitType b = C0800c.m4135b(C0293u.m695c(cursor, CommonColumn.LIMIT_TYPE.ordinal()), cursor.getString(CommonColumn.BOOK_TYPE.ordinal()));
        String c = C0293u.m695c(cursor, CommonColumn.BOOK_UUID.ordinal());
        String c2 = C0293u.m695c(cursor, CommonColumn.BOOK_NAME.ordinal());
        BookState t = C0800c.mo1017t(cursor.getString(CommonColumn.BOOK_STATE.ordinal()));
        String c3 = C0293u.m695c(cursor, CommonColumn.BOOK_REVISION.ordinal());
        String a2 = C0293u.m692a(cursor, CommonColumn.LAST_REVISION.ordinal(), "");
        String a3 = C0293u.m692a(cursor, CommonColumn.ONLINE_COVER_URI.ordinal(), "");
        String a4 = C0293u.m692a(cursor, CommonColumn.LAST_READING_POSITION.ordinal(), null);
        String a5 = C0293u.m692a(cursor, CommonColumn.BOOK_URI.ordinal(), null);
        String a6 = C0293u.m692a(cursor, CommonColumn.BOOK_CONTENT.ordinal(), null);
        String a7 = C0293u.m692a(cursor, CommonColumn.MICLOUD.ordinal(), null);
        this.f2905b = a;
        this.f2909f = b;
        this.f2908e = q;
        this.f2920q = c;
        this.f2906c = c2;
        this.f2907d = t;
        this.f2921r = c3;
        this.f2922s = a2;
        this.f2895E = a3;
        this.f2900J.m4012c(a4);
        this.f2897G.m4012c(a5);
        this.f2898H.m4012c(a6);
        this.f2899I.m4012c(a7);
    }

    
    public boolean m4204a() {
        return this.f2904a.get() > 0;
    }

    
    public C0919l mo1033b() {
        return null;
    }

    
    public final void m4214c() {
        try {
            aV().mo1091a(aH());
            aQ();
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final File m4219d() {
        am amVar = null;
        ap apVar = this.f2897G;
        if (apVar.m4013d()) {
            try {
                aV().mo1091a(aH());
                File file;
                if (apVar.m861b()) {
                    file = (File) apVar.m858a();
                    return file;
                }
                apVar.mo975a(new File(Uri.parse((String) apVar.m4014e()).getPath()));
                file = (File) apVar.m858a();
                return file;
            } catch (Throwable th) {
                WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs", th);
                apVar.m4012c(null);
            } finally {
                amVar = aV();
                apVar = aH();
                amVar.mo1097b(apVar);
            }
        }
        return apVar.m861b() ? (File) apVar.m858a() : amVar;
    }

    
    public final String m4222e() {
        File d = m4219d();
        return d != null ? d.getPath() : "";
    }

    
    public final String m4225f() {
        File d = m4219d();
        return d != null ? Uri.fromFile(d).toString() : "";
    }

    
    public final void m4196a(String str) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2897G.mo975a(new File(Uri.parse(str).getPath()));
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final String m4228g() {
        return this.f2895E;
    }

    
    public final void m4212b(String str) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2895E = str;
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final String m4231h() {
        if (TextUtils.isEmpty(this.f2896F)) {
            Object I = m4156I();
            if (TextUtils.isEmpty(I)) {
                this.f2896F = "";
            } else {
                this.f2896F = Uri.fromFile(new File(aS(), I + ".cover")).toString();
            }
        }
        return this.f2896F;
    }

    
    public final BookState m4233i() {
        return this.f2907d;
    }

    
    public boolean mo1037j() {
        return false;
    }

    
    public boolean mo1038k() {
        return false;
    }

    
    public boolean m4239l() {
        switch (C0805f.f3150a[m4246r().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    
    public float m4240m() {
        return ((float) this.f2923t) / 100.0f;
    }

    
    public final DownloadFailCode m4241n() {
        if (this.f2905b == BookPackageType.EPUB_OPF) {
            return DownloadFailCode.NONE;
        }
        if (!aa()) {
            return DownloadFailCode.NONE;
        }
        try {
            aV().mo1091a(aH());
            aQ();
            DownloadFailCode o;
            if (this.f2928y != null) {
                o = this.f2928y.m7801o();
                return o;
            }
            o = DownloadFailCode.NONE;
            aV().mo1097b(aH());
            return o;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final BookType m4242o() {
        try {
            BookType bookType;
            aV().mo1091a(aH());
            if (BookType.TRIAL == this.f2908e) {
                aQ();
                bookType = TextUtils.isEmpty(this.f2920q) ? BookType.NORMAL : BookType.TRIAL;
                aV().mo1097b(aH());
            } else {
                bookType = this.f2908e;
                aV().mo1097b(aH());
            }
            return bookType;
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4184a(BookType bookType) {
        try {
            aV().mo1091a(aH());
            aQ();
            if (bookType != this.f2908e) {
                this.f2908e = bookType;
                m3744b(4);
            }
            aV().mo1097b(aH());
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    
    public final BookLimitType m4243p() {
        try {
            aV().mo1091a(aH());
            BookLimitType bookLimitType = this.f2909f;
            return bookLimitType;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4183a(BookLimitType bookLimitType) {
        try {
            aV().mo1091a(aH());
            aQ();
            if (bookLimitType != this.f2909f) {
                this.f2909f = bookLimitType;
                m3744b(32);
            }
            aV().mo1097b(aH());
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    
    public BookFormat mo1039q() {
        return BookFormat.UNKNOWN;
    }

    
    public final BookContent m4246r() {
        ap apVar = this.f2898H;
        if (apVar.m4013d()) {
            try {
                aV().mo1091a(aH());
                BookContent bookContent;
                if (apVar.m861b()) {
                    bookContent = (BookContent) apVar.m858a();
                    return bookContent;
                }
                apVar.mo975a(C0800c.mo1016s((String) apVar.m4014e()));
                bookContent = (BookContent) apVar.m858a();
                return bookContent;
            } catch (Throwable th) {
                WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs", th);
                apVar.m4012c(null);
            } finally {
                apVar = aV();
                apVar.mo1097b(aH());
            }
        }
        if (apVar.m861b()) {
            return (BookContent) apVar.m858a();
        }
        return BookContent.UNKNOWN;
    }

    
    public final void m4182a(BookContent bookContent) {
        try {
            aV().mo1091a(aH());
            if (!this.f2898H.m862b(bookContent)) {
                this.f2898H.mo975a(bookContent);
                m3744b(2);
            }
            aV().mo1097b(aH());
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    
    public final BookPackageType m4247s() {
        return this.f2905b;
    }

    
    public final ab m4248t() {
        try {
            aV().mo1091a(aH());
            aQ();
            if (this.f2911h == null) {
                this.f2911h = new ab(this.f2910g);
                this.f2910g = null;
            }
            ab abVar = this.f2911h;
            return abVar;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4186a(ab abVar) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2911h = abVar;
            this.f2910g = null;
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public boolean mo1018u() {
        return false;
    }

    
    public boolean mo1019v() {
        return true;
    }

    
    public boolean m4251w() {
        return m4149B().equals("newbie") || m4252x();
    }

    
    public boolean m4252x() {
        return m4149B().equals("free_newbie");
    }

    
    public boolean mo1012a(boolean z) {
        return false;
    }

    
    public void mo1009a(af<Boolean> afVar) {
    }

    
    public final void m4253y() {
        Object obj = null;
        try {
            aV().mo1091a(aH());
            aQ();
            if (mo1039q() == BookFormat.EPUB) {
                Object obj2 = !ak() ? 1 : null;
                boolean isEmpty = TextUtils.isEmpty(m4150C());
                if (m4246r() == BookContent.UNKNOWN) {
                    obj = 1;
                }
                if (!(obj2 == null && !isEmpty && obj == null)) {
                    aq a = ai.m6506a(m4225f(), (ap) mo1033b());
                    DkeBook dkeBook = a.f4489b;
                    if (dkeBook.isValid()) {
                        DKEBookInfo dKEBookInfo = new DKEBookInfo();
                        dkeBook.getBookInfo(dKEBookInfo);
                        if (!(obj2 == null || TextUtils.isEmpty(dKEBookInfo.mTitle))) {
                            mo955p(dKEBookInfo.mTitle);
                        }
                        if (isEmpty && !TextUtils.isEmpty(dKEBookInfo.mAuthor)) {
                            m4221d(dKEBookInfo.mAuthor);
                        }
                        if (obj != null) {
                            if (dkeBook.getComicsFrameCount() > 0) {
                                m4182a(BookContent.FRAME_COMIC);
                            } else if (dkeBook.getLayoutType() == 3) {
                                m4182a(BookContent.PAGE_COMIC);
                            } else if (dkeBook.getLayoutType() == 4) {
                                m4182a(BookContent.VERTICAL_COMIC);
                            } else if (dkeBook.hasAudioText()) {
                                m4182a(BookContent.AUDIO_TEXT);
                            } else {
                                m4182a(BookContent.NORMAL);
                            }
                        }
                    }
                    ai.m6512a(a);
                }
            } else {
                m4182a(BookContent.NORMAL);
            }
            aV().mo1097b(aH());
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    
    public ad mo1020z() {
        return null;
    }

    
    public void mo1011a(ad adVar) {
    }

    
    public final long m4148A() {
        try {
            aV().mo1091a(aH());
            aQ();
            long j = this.f2912i;
            return j;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4176a(long j) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2912i = j;
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final String m4149B() {
        try {
            aV().mo1091a(aH());
            aQ();
            String str = this.f2913j;
            return str;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4218c(String str) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2913j = str;
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final String m4150C() {
        try {
            aV().mo1091a(aH());
            aQ();
            String str = this.f2914k;
            return str;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4221d(String str) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2914k = str;
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final long m4151D() {
        try {
            aV().mo1091a(aH());
            aQ();
            long j = this.f2916m;
            return j;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4207b(long j) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2916m = j;
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final ke m4152E() {
        ke keVar;
        ap apVar = this.f2900J;
        if (apVar.m4013d()) {
            try {
                aV().mo1091a(aH());
                if (apVar.m861b()) {
                    keVar = (ke) apVar.m858a();
                    return keVar;
                }
                apVar.mo975a(new ke(mo1039q(), (String) apVar.m4014e()));
                keVar = (ke) apVar.m858a();
                return keVar;
            } catch (Throwable th) {
                WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs", th);
                apVar.m4012c(null);
            } finally {
                apVar = aV();
                apVar.mo1097b(aH());
            }
        }
        if (apVar.m861b()) {
            return (ke) apVar.m858a();
        }
        try {
            aV().mo1091a(aH());
            if (apVar.m861b()) {
                keVar = (ke) apVar.m858a();
                return keVar;
            }
            apVar.mo975a(new ke(mo1039q(), ""));
            keVar = (ke) apVar.m858a();
            aV().mo1097b(aH());
            return keVar;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4190a(ke keVar) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2900J.mo975a(keVar);
            m3744b((int) C2295j.f14325e);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final long m4153F() {
        try {
            aV().mo1091a(aH());
            aQ();
            long j = m4248t().f2716n;
            return j;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4215c(long j) {
        try {
            aV().mo1091a(aH());
            aQ();
            m4248t().f2716n = Math.max(j, m4248t().f2716n);
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4220d(long j) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2917n = j;
            m3744b((int) C2295j.f14325e);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final long m4154G() {
        try {
            aV().mo1091a(aH());
            aQ();
            long j = this.f2918o;
            return j;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4223e(long j) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2918o = j;
            m3744b((int) C2295j.f14325e);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final kg m4155H() {
        try {
            aV().mo1091a(aH());
            aQ();
            if (this.f2919p == null) {
                this.f2919p = new kg();
            }
            kg kgVar = this.f2919p;
            return kgVar;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4191a(kg kgVar) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2919p = kgVar;
            m3744b((int) C2295j.f14325e);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final String m4156I() {
        try {
            aV().mo1091a(aH());
            if (TextUtils.isEmpty(this.f2920q)) {
                if (m4167T()) {
                    this.f2920q = DkUtils.calcUniversalBookId(m4222e());
                } else {
                    this.f2920q = "";
                }
            }
            String str = this.f2920q;
            return str;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4224e(String str) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2920q = str;
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final String m4157J() {
        return this.f2921r;
    }

    
    public final void m4227f(String str) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2921r = str;
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final String m4158K() {
        return this.f2922s;
    }

    
    public final void m4230g(String str) {
        try {
            aV().mo1091a(aH());
            if (!TextUtils.equals(this.f2922s, str)) {
                this.f2922s = str;
                m3744b(2);
            }
            aV().mo1097b(aH());
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    
    public final int m4159L() {
        try {
            aV().mo1091a(aH());
            aQ();
            int i = this.f2924u;
            return i;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4175a(int i) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2924u = i;
            m3744b(16);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final long m4160M() {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2925v.m2226a();
            long a = this.f2925v.f3585c;
            return a;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4226f(long j) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2925v.m2226a();
            this.f2925v.f3585c = j;
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final String m4161N() {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2925v.m2226a();
            String b = this.f2925v.f3586d;
            return b;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4232h(String str) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2925v.m2226a();
            this.f2925v.f3586d = str;
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final String m4162O() {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2925v.m2226a();
            String c = this.f2925v.f3587e;
            return c;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4234i(String str) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2925v.m2226a();
            this.f2925v.f3587e = str;
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final long m4163P() {
        try {
            aV().mo1091a(aH());
            aQ();
            long j = this.f2926w;
            return j;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4229g(long j) {
        if (this.f2926w != j) {
            try {
                aV().mo1091a(aH());
                aQ();
                this.f2926w = j;
                m3744b(536870912);
            } finally {
                aV().mo1097b(aH());
            }
        }
    }

    
    public final void m4235j(String str) {
        kg H = m4155H();
        H.f3455c = str;
        m4191a(H);
    }

    
    public final void m4237k(String str) {
        this.f2903M = str;
    }

    
    public final String m4164Q() {
        return this.f2903M;
    }

    
    public void m4198a(String str, String str2, String str3, String str4, boolean z, af<Boolean> afVar) {
        try {
            String I;
            aV().mo1091a(aH());
            aQ();
            if (this.f2907d == BookState.PULLING || this.f2907d == BookState.UPDATING) {
                this.f2927x.m3779d(128);
                aE();
            }
            if (TextUtils.equals(this.f2921r, str3) && TextUtils.equals(m4225f(), str)) {
                this.f2907d = BookState.PULLING;
            } else {
                this.f2907d = BookState.UPDATING;
            }
            ac acVar = new ac(str, str2, str3, str4);
            acVar.m3774a(z, afVar);
            this.f2927x = acVar;
            this.f2927x.m3778c(240);
            this.f2923t = 0;
            m3744b(268435528);
            aN();
            aD();
            if (ak()) {
                I = m4156I();
            } else {
                I = ay();
            }
            C1167a.m8671d().m8686c(I, m4155H().f3455c);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final boolean m4165R() {
        return m4242o() == BookType.TRIAL;
    }

    
    public final boolean m4166S() {
        return m4243p() == BookLimitType.TIME;
    }

    
    public final boolean m4167T() {
        if (m4233i() == BookState.CLOUD_ONLY) {
            return false;
        }
        File d = m4219d();
        if (d.exists()) {
            return true;
        }
        String absolutePath = d.getAbsolutePath();
        LinkedList linkedList = new LinkedList();
        if (absolutePath.contains("/DuoKan/")) {
            linkedList.add(absolutePath.substring(absolutePath.indexOf("/DuoKan/")));
        } else if (absolutePath.contains("/DuoKanHD/")) {
            linkedList.add(absolutePath.substring(absolutePath.indexOf("/DuoKanHD/")));
        } else {
            List pathSegments = Uri.fromFile(d).getPathSegments();
            String str = "";
            for (int size = pathSegments.size() - 1; size >= 0; size--) {
                String str2 = ((String) pathSegments.get(size)) + str;
                linkedList.addFirst(str2);
                str = "/" + str2;
            }
        }
        Collection b;
        if (ak()) {
            b = FileUtil.getAllFile(ManagedApp.get());
        } else {
            b = FileUtil.getDiskFiles(ManagedApp.get());
        }
        for (File d2 : b) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                File file = new File(d2, (String) it.next());
                if (file.exists()) {
                    m4196a(Uri.fromFile(file).toString());
                    aN();
                    return true;
                }
            }
        }
        return false;
    }

    
    public final boolean m4168U() {
        switch (C0805f.f3151b[this.f2907d.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    
    public final boolean m4169V() {
        try {
            aV().mo1091a(aH());
            if (ak()) {
                return false;
            }
            if (am() != null) {
                aV().mo1097b(aH());
                return false;
            }
            aV().mo1097b(aH());
            return true;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final boolean m4170W() {
        try {
            aV().mo1091a(aH());
            boolean z = (!m4171X() || m4172Y() || m4173Z() || aa()) ? false : true;
            aV().mo1097b(aH());
            return z;
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    
    public final boolean m4171X() {
        try {
            aV().mo1091a(aH());
            if (this.f2907d == BookState.NORMAL || this.f2907d == BookState.CLOUD_ONLY) {
                aV().mo1097b(aH());
                return false;
            }
            aQ();
            if (this.f2927x.m3775a()) {
                aV().mo1097b(aH());
                return false;
            } else if (this.f2927x.m3777b(195)) {
                aV().mo1097b(aH());
                return false;
            } else {
                aV().mo1097b(aH());
                return true;
            }
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    
    public final boolean m4172Y() {
        try {
            aV().mo1091a(aH());
            aQ();
            if (!m4171X()) {
                return false;
            }
            if (this.f2927x.m3775a()) {
                aV().mo1097b(aH());
                return false;
            } else if (this.f2927x.m3777b(32)) {
                aV().mo1097b(aH());
                return true;
            } else if (this.f2928y == null || !this.f2928y.m7789c()) {
                aV().mo1097b(aH());
                return false;
            } else {
                aV().mo1097b(aH());
                return true;
            }
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final boolean m4173Z() {
        try {
            aV().mo1091a(aH());
            aQ();
            if (!m4171X()) {
                return false;
            }
            if (this.f2927x.m3775a()) {
                aV().mo1097b(aH());
                return false;
            } else if (this.f2927x.m3777b(16)) {
                aV().mo1097b(aH());
                return true;
            } else if (this.f2928y == null || !this.f2928y.m7789c()) {
                aV().mo1097b(aH());
                return false;
            } else {
                aV().mo1097b(aH());
                return true;
            }
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final boolean aa() {
        try {
            aV().mo1091a(aH());
            aQ();
            if (this.f2907d == BookState.NORMAL || this.f2907d == BookState.CLOUD_ONLY) {
                aV().mo1097b(aH());
                return false;
            } else if (this.f2927x.m3775a()) {
                aV().mo1097b(aH());
                return false;
            } else if (this.f2927x.m3776a(2)) {
                aV().mo1097b(aH());
                return true;
            } else if (this.f2928y == null || !this.f2928y.m7794h()) {
                aV().mo1097b(aH());
                return false;
            } else {
                aV().mo1097b(aH());
                return true;
            }
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    public final void ab() {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2927x.m3778c(240);
            this.f2927x.m3778c(2);
            m3744b(64);
            aN();
            aD();
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4208b(af<Boolean> afVar) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2927x.m3774a(this.f2927x.m3776a(C2295j.f14327g), afVar);
            ab();
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4201a(boolean z, af<Boolean> afVar) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2927x.m3774a(z, afVar);
            ab();
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final void ac() {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2927x.m3778c(240);
            this.f2927x.m3779d(16);
            m3744b(64);
            aN();
            aE();
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final void ad() {
        try {
            aV().mo1091a(aH());
            aQ();
            if (m4171X()) {
                this.f2907d = BookState.CLOUD_ONLY;
                this.f2927x.m3778c(240);
                this.f2927x.m3779d(128);
                m3744b(72);
                aN();
                aE();
            }
            aV().mo1097b(aH());
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    public final boolean ae() {
        try {
            aV().mo1091a(aH());
            aQ();
            if (ag()) {
                return true;
            }
            if (ao() && af()) {
                aV().mo1097b(aH());
                return true;
            }
            aV().mo1097b(aH());
            return false;
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final boolean af() {
        boolean z = false;
        try {
            aV().mo1091a(aH());
            aQ();
            if (m4167T()) {
                if (!ag()) {
                    z = true;
                }
                aV().mo1097b(aH());
            }
            return z;
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final boolean ag() {
        try {
            aV().mo1091a(aH());
            aQ();
            if (!m4167T()) {
                return false;
            }
            if (mo1037j()) {
                aV().mo1097b(aH());
                return true;
            } else if (ak()) {
                aV().mo1097b(aH());
                return true;
            } else {
                if (ao()) {
                    if (m4219d().getAbsolutePath().endsWith(hc.m3814a("", am()))) {
                        aV().mo1097b(aH());
                        return true;
                    }
                }
                aV().mo1097b(aH());
                return false;
            }
        } finally {
            aV().mo1097b(aH());
        }
    }

    public void ah() {
        try {
            aV().mo1091a(aH());
            aQ();
            ad();
            if (ae()) {
                aj();
                FileUtil.deleteFile(m4219d());
                if (this.f2907d != BookState.CLOUD_ONLY) {
                    this.f2907d = BookState.CLOUD_ONLY;
                    m3744b(8);
                }
                aN();
                aV().mo1097b(aH());
            }
        } finally {
            aV().mo1097b(aH());
        }
    }

    public long ai() {
        long j = 0;
        try {
            aV().mo1091a(aH());
            aQ();
            if (ae()) {
                File d = m4219d();
                if (mo1037j()) {
                    d = d.getParentFile();
                }
                if (d.isDirectory()) {
                    long j2 = 0;
                    for (File length : FileUtil.getDirFiles(d, new FileFilter[0])) {
                        j2 += length.length();
                    }
                    j = j2;
                } else {
                    j = d.length();
                }
                aV().mo1097b(aH());
            }
            return j;
        } finally {
            aV().mo1097b(aH());
        }
    }

    public void aj() {
        try {
            aV().mo1091a(aH());
            aQ();
            ad();
            if (ag()) {
                File d = m4219d();
                if (mo1037j()) {
                    FileUtil.deleteFile(d.getParentFile());
                } else if (ak()) {
                    FileUtil.deleteFile(d);
                } else if (ao()) {
                    if (d.getAbsolutePath().endsWith(hc.m3814a("", am()))) {
                        FileUtil.deleteFile(d.getParentFile());
                    }
                }
                if (this.f2907d != BookState.CLOUD_ONLY) {
                    this.f2907d = BookState.CLOUD_ONLY;
                    m3744b(8);
                }
                this.f2927x.m3778c(240);
                this.f2927x.m3778c(3);
                this.f2927x.m3779d(64);
                this.f2923t = 0;
                m3744b(268435520);
                aN();
                aV().mo1097b(aH());
            }
        } finally {
            aV().mo1097b(aH());
        }
    }

    public boolean ak() {
        return false;
    }

    public boolean al() {
        return false;
    }

    
    public static boolean m4140l(String str) {
        return new C0650x(str).m3046a().length() == 32;
    }

    
    public static boolean m4141m(String str) {
        if (TextUtils.isDigitsOnly(new C0650x(str).m3046a())) {
            return true;
        }
        return false;
    }

    
    public static boolean m4142n(String str) {
        C0650x c0650x = new C0650x(str);
        if (TextUtils.isDigitsOnly(c0650x.m3046a()) && Long.parseLong(c0650x.m3046a()) < 10000000) {
            return true;
        }
        return false;
    }

    
    public static boolean m4143o(String str) {
        C0650x c0650x = new C0650x(str);
        if (!TextUtils.isDigitsOnly(c0650x.m3046a())) {
            return false;
        }
        long parseLong = Long.parseLong(c0650x.m3046a());
        if (parseLong < 10000000 || parseLong >= 50000000) {
            return false;
        }
        return true;
    }

    
    public static boolean m4134a(boolean z, String str) {
        if (z) {
            return true;
        }
        if (TextUtils.isEmpty(str) || (str.charAt(0) >= 'g' && str.charAt(0) <= 'w' && str.charAt(0) != 'q')) {
            return false;
        }
        return true;
    }

    public final is am() {
        am amVar = null;
        ap apVar = this.f2899I;
        if (apVar.m4013d()) {
            try {
                aV().mo1091a(aH());
                is isVar;
                if (apVar.m861b()) {
                    isVar = (is) apVar.m858a();
                    return isVar;
                }
                apVar.mo975a(new is(new bi(new JSONObject((String) apVar.m4014e()))));
                isVar = (is) apVar.m858a();
                return isVar;
            } catch (Throwable th) {
                WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs", th);
                apVar.m4012c(null);
            } finally {
                amVar = aV();
                apVar = aH();
                amVar.mo1097b(apVar);
            }
        }
        return apVar.m861b() ? (is) apVar.m858a() : amVar;
    }

    
    public final void m4189a(is isVar) {
        try {
            aV().mo1091a(aH());
            this.f2899I.mo975a(isVar);
            m3744b(1024);
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final void an() {
        try {
            aV().mo1091a(aH());
            this.f2899I.mo975a(null);
            m3744b(1024);
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final boolean ao() {
        if (!this.f2899I.m4013d() && this.f2899I.m858a() == null) {
            return false;
        }
        return true;
    }

    public final boolean ap() {
        try {
            aV().mo1091a(aH());
            aQ();
            boolean z = am() != null && ReaderEnv.get().isMiCloudBookPath(m4222e());
            aV().mo1097b(aH());
            return z;
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    public final int aq() {
        try {
            aV().mo1091a(aH());
            aQ();
            if (am() != null) {
                return 3;
            }
            if (!ak()) {
                aV().mo1097b(aH());
                return -1;
            } else if (m4242o() == BookType.SERIAL) {
                aV().mo1097b(aH());
                return 1;
            } else {
                aV().mo1097b(aH());
                return 0;
            }
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final String ar() {
        try {
            String f;
            aV().mo1091a(aH());
            aQ();
            if (aq() == 3) {
                f = am().m4686f();
            } else {
                f = m4156I();
                aV().mo1097b(aH());
            }
            return f;
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final C0798a[] as() {
        return aX().m4989a();
    }

    
    public final void m4185a(C0798a c0798a) {
        aX().m4987a(c0798a);
        m4177a(m4160M(), UUID.randomUUID().toString());
        aY();
    }

    
    public final void m4200a(List<C0798a> list, boolean z) {
        for (C0798a b : list) {
            aX().m4991b(b);
        }
        m4177a(m4160M(), UUID.randomUUID().toString());
        if (z) {
            aY();
        }
    }

    
    public final void m4209b(C0798a c0798a) {
        aX().m4991b(c0798a);
        m4177a(m4160M(), UUID.randomUUID().toString());
        aY();
    }

    
    public final void m4216c(C0798a c0798a) {
        aX().m4992c(c0798a);
        m4177a(m4160M(), UUID.randomUUID().toString());
        aY();
    }

    
    public final void m4199a(List<C0798a> list) {
        C0285n aT;
        try {
            aV().mo1091a(aH());
            aT = aT();
            aT.m677b();
            for (C0798a c : list) {
                aX().m4992c(c);
            }
            m4177a(m4160M(), UUID.randomUUID().toString());
            aT.m681f();
            aT.m678c();
            aY();
            aV().mo1097b(aH());
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    
    public final void m4203a(DkCloudAnnotation[] dkCloudAnnotationArr) {
        aX().m4988a(dkCloudAnnotationArr);
        aY();
    }

    
    public void m4177a(long j, String str) {
        C0285n aT;
        try {
            aV().mo1091a(aH());
            m4226f(j);
            m4234i(str);
            aT = aT();
            aT.m677b();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("local_reading_info_version", m4160M());
            jSONObject.put("local_reading_info_revision", m4161N());
            jSONObject.put("local_annotation_change_id", m4162O());
            aT.m674a("UPDATE books SET cloud = ? WHERE _id = ?", new String[]{jSONObject.toString(), "" + aH()});
            aT.m681f();
            aT.m678c();
        } catch (Exception e) {
            e.printStackTrace();
            aT.m678c();
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
        aV().mo1097b(aH());
    }

    public void at() {
        aX().m4990b();
        aY();
    }

    
    public void m4192a(C0837w c0837w) {
        if (this.f2893A == null) {
            this.f2893A = new LinkedList();
        }
        this.f2893A.add(c0837w);
    }

    
    public void m4210b(C0837w c0837w) {
        if (this.f2893A == null) {
            this.f2893A = new LinkedList();
        }
        this.f2893A.remove(c0837w);
    }

    
    public void m4213b(boolean z) {
        this.f2894B = z;
    }

    public boolean au() {
        return this.f2894B;
    }

    
    public void m4194a(av avVar) {
        m4202a(true, new C0802d(this, avVar));
    }

    
    public void m4193a(C0801y c0801y) {
        m4202a(false, c0801y);
    }

    
    public void m4202a(boolean z, C0801y c0801y) {
        m4130a(this, new C0807g(this, c0801y), true);
        if (C0709k.m3476a().m3507c() && PersonalPrefs.m5175a().m5249y()) {
            DkCloudReadingProgress dkCloudReadingProgress;
            if (!m4152E().f3445a.mo1191d() || m4152E().m4818a()) {
                dkCloudReadingProgress = null;
            } else {
                dkCloudReadingProgress = new DkCloudReadingProgress(m4138c(m4152E().f3445a));
            }
            DkCloudAnnotation[] dkCloudAnnotationArr = new DkCloudAnnotation[0];
            C0798a[] as = as();
            if (as != null) {
                LinkedList linkedList = new LinkedList();
                String a = ah.m6500e().m6501a();
                for (C0798a a2 : as) {
                    linkedList.add(m4123a(m4157J(), a, a2, m4160M()));
                }
                dkCloudAnnotationArr = (DkCloudAnnotation[]) linkedList.toArray(new DkCloudAnnotation[0]);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(ay()).append(".").append(mo1039q().name());
            DkCloudStorage.m4994a().m5012a(new DkCloudReadingInfo(m4156I(), stringBuffer.toString(), ak(), m4160M(), ReaderEnv.get().getDeviceId(), m4157J(), ah.m6500e().m6501a(), dkCloudReadingProgress, dkCloudAnnotationArr), TextUtils.isEmpty(m4162O()) ? ConflictStrategy.TAKE_SERVER_VERSION : ConflictStrategy.MERGE, m4162O(), z, new C0810h(this, c0801y, z));
            return;
        }
        c0801y.mo1001a(this, false);
        c0801y.mo1003b(this, false);
    }

    public final void av() {
        try {
            aV().mo1091a(aH());
            aQ();
            aW();
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final boolean aw() {
        try {
            aV().mo1091a(aH());
            boolean z = (TextUtils.isEmpty(this.f2922s) || TextUtils.isEmpty(this.f2921r) || this.f2922s.compareTo(this.f2921r) <= 0) ? false : true;
            aV().mo1097b(aH());
            return z;
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    protected void ax() {
        super.ax();
        if (this.f2926w > 0) {
            aV().mo1094a(this, this.f2926w);
        }
        aD();
    }

    
    public void mo949a(C0559f c0559f) {
        if (aR()) {
            if (((c0559f.m2486e() && ManagedApp.get().getRunningState() == RunningState.FOREGROUND) || c0559f.m2485d()) && PersonalPrefs.m5175a().m5249y() && C0709k.m3476a().m3507c()) {
                kg H = m4155H();
                if (H.f3453a > 0 || H.f3454b > 0) {
                    m4194a(m4152E().f3445a);
                }
            }
            try {
                aV().mo1091a(aH());
                aD();
            } finally {
                aV().mo1097b(aH());
            }
        }
    }

    
    protected void mo990a(DownloadCenterTask downloadCenterTask) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2923t = (int) (downloadCenterTask.m7796j() * 100.0f);
            m3744b(268435456);
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    protected void mo992b(DownloadCenterTask downloadCenterTask) {
        try {
            aV().mo1091a(aH());
            aQ();
            if (this.f2907d == BookState.PULLING) {
                m4253y();
                this.f2916m = downloadCenterTask.m7798l();
                if (this.f2916m < 0) {
                    this.f2916m = m4219d().length();
                }
                this.f2907d = BookState.NORMAL;
                this.f2927x.m3778c(240);
                this.f2927x.m3779d(64);
                this.f2927x.m3779d(1);
                m3744b(74);
                aN();
                aE();
            } else if (this.f2907d == BookState.UPDATING) {
                File d = m4219d();
                this.f2916m = downloadCenterTask.m7798l();
                if (this.f2916m < 0) {
                    this.f2916m = d.length();
                }
                m4196a(this.f2927x.f2717a);
                m4184a(BookType.NORMAL);
                m4183a(BookLimitType.NONE);
                this.f2921r = this.f2927x.f2719c;
                this.f2922s = "";
                this.f2907d = BookState.NORMAL;
                this.f2927x.m3778c(240);
                this.f2927x.m3779d(64);
                this.f2927x.m3779d(2);
                m3744b(74);
                aN();
                aE();
                if (!d.equals(m4219d())) {
                    d.delete();
                }
            }
            aV().mo1097b(aH());
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    
    protected void mo993c(DownloadCenterTask downloadCenterTask) {
        try {
            aV().mo1091a(aH());
            aQ();
            if (this.f2907d == BookState.PULLING || this.f2907d == BookState.UPDATING) {
                this.f2927x.m3779d(2);
                m3744b(64);
                aN();
            }
            aV().mo1097b(aH());
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    public final String ay() {
        try {
            aV().mo1091a(aH());
            if (TextUtils.isEmpty(this.f2906c)) {
                aQ();
                this.f2906c = FileUtil.getRealFileName(m4219d());
                if (ao() && m4167T()) {
                    m4253y();
                }
                m3746c(false);
            }
            String str = this.f2906c;
            return str;
        } finally {
            aV().mo1097b(aH());
        }
    }

    
    protected final void mo955p(String str) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2906c = str;
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final long az() {
        try {
            aV().mo1091a(aH());
            aQ();
            long j = this.f2917n;
            return j;
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final boolean aA() {
        return true;
    }

    public boolean aB() {
        return this.f2907d == BookState.CLOUD_ONLY;
    }

    
    protected void mo951a(Cursor cursor) {
        this.f2910g = C0293u.m695c(cursor, Column.BOOK_DETAIL.ordinal());
        this.f2912i = C0293u.m694b(cursor, Column.ADDED_DATE.ordinal());
        this.f2913j = C0293u.m695c(cursor, Column.ADDED_FROM.ordinal());
        this.f2914k = C0293u.m695c(cursor, Column.AUTHOR.ordinal());
        this.f2915l = C0293u.m695c(cursor, Column.CONTENT_ENCODING.ordinal());
        this.f2916m = C0293u.m694b(cursor, Column.FILE_SIZE.ordinal());
        this.f2917n = C0293u.m694b(cursor, Column.LAST_READING_DATE.ordinal());
        this.f2919p = new kg(C0293u.m695c(cursor, Column.READING_STATISTICS.ordinal()));
        String c = C0293u.m695c(cursor, Column.CLOUD.ordinal());
        this.f2923t = C0293u.m689a(cursor, Column.TRANSFER_PROGRESS.ordinal());
        this.f2924u = C0293u.m689a(cursor, Column.BOOK_PRICE.ordinal());
        this.f2926w = C0293u.m694b(cursor, Column.TASK_PRIORITY.ordinal());
        this.f2918o = C0293u.m694b(cursor, Column.FINISH_READING_DATE.ordinal());
        this.f2925v = new C0838x(this, c);
        this.f2927x = new ac(C0293u.m695c(cursor, Column.DOWNLOAD_INFO.ordinal()));
    }

    
    protected void mo950a(ContentValues contentValues) {
        if (m3747c(2)) {
            contentValues.put(Column.ADDED_DATE.toString(), Long.valueOf(m4148A()));
            contentValues.put(Column.ADDED_FROM.toString(), m4149B());
            contentValues.put(Column.BOOK_NAME.toString(), ay());
            contentValues.put(Column.BOOK_UUID.toString(), m4156I());
            contentValues.put(Column.BOOK_URI.toString(), m4225f());
            contentValues.put(Column.ONLINE_COVER_URI.toString(), m4228g());
            contentValues.put(Column.BOOK_FORMAT.toString(), mo1039q().toString());
            contentValues.put(Column.FILE_SIZE.toString(), Long.valueOf(m4151D()));
            contentValues.put(Column.AUTHOR.toString(), m4150C());
            contentValues.put(Column.BOOK_DETAIL.toString(), m4248t().toString());
            contentValues.put(Column.BOOK_UUID.toString(), m4156I());
            contentValues.put(Column.BOOK_REVISION.toString(), m4157J());
            contentValues.put(Column.LAST_REVISION.toString(), m4158K());
            contentValues.put(Column.BOOK_CONTENT.toString(), m4246r().toString());
            contentValues.put(Column.PACKAGE_TYPE.toString(), m4247s().toString());
            if (!TextUtils.isEmpty(m4156I())) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("local_reading_info_version", m4160M());
                    jSONObject.put("local_reading_info_revision", m4161N());
                    jSONObject.put("local_annotation_change_id", m4162O());
                    contentValues.put(Column.CLOUD.toString(), jSONObject.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (m3747c(16)) {
            contentValues.put(Column.BOOK_PRICE.toString(), Integer.valueOf(m4159L()));
        }
        if (m3747c(36)) {
            contentValues.put(Column.BOOK_TYPE.toString(), m4242o().toString());
            contentValues.put(Column.LIMIT_TYPE.toString(), m4243p().toString());
        }
        if (m3747c(8)) {
            contentValues.put(Column.BOOK_STATE.toString(), this.f2907d.toString());
        }
        if (m3747c(536870912)) {
            contentValues.put(Column.TASK_PRIORITY.toString(), Long.valueOf(this.f2926w));
        }
        if (m3747c((int) C2295j.f14325e)) {
            contentValues.put(Column.LAST_READING_DATE.toString(), Long.valueOf(this.f2917n));
            contentValues.put(Column.FINISH_READING_DATE.toString(), Long.valueOf(this.f2918o));
            ke keVar = (ke) this.f2900J.m858a();
            if (keVar != null) {
                contentValues.put(Column.LAST_READING_POSITION.toString(), keVar.toString());
            }
            if (this.f2919p != null) {
                contentValues.put(Column.READING_STATISTICS.toString(), this.f2919p.toString());
            }
        }
        if (m3747c(64) && this.f2927x != null) {
            contentValues.put(Column.DOWNLOAD_INFO.toString(), this.f2927x.m3775a() ? "" : this.f2927x.toString());
        }
        if (m3747c(268435456)) {
            contentValues.put(Column.TRANSFER_PROGRESS.toString(), Integer.valueOf(this.f2923t));
        }
        if (m3747c(1024)) {
            is isVar = (is) this.f2899I.m858a();
            if (isVar != null) {
                contentValues.put(Column.MICLOUD.toString(), isVar.m4680a().m8150a().toString());
            }
        }
    }

    protected String aC() {
        return "books";
    }

    
    private void m4137b(av avVar) {
        DkCloudReadingProgress dkCloudReadingProgress;
        DkCloudAnnotation[] dkCloudAnnotationArr;
        if (m4152E().f3445a.mo1191d()) {
            dkCloudReadingProgress = new DkCloudReadingProgress(m4138c(m4152E().f3445a));
        } else {
            dkCloudReadingProgress = null;
        }
        if (TextUtils.isEmpty(m4162O())) {
            dkCloudAnnotationArr = null;
        } else {
            Object linkedList = new LinkedList();
            C0798a[] as = as();
            String a = ah.m6500e().m6501a();
            for (C0798a a2 : as) {
                linkedList.add(m4123a(m4157J(), a, a2, m4160M()));
            }
            Collections.sort(linkedList, new C0815j(this));
            dkCloudAnnotationArr = (DkCloudAnnotation[]) linkedList.toArray(new DkCloudAnnotation[0]);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ay()).append(".").append(mo1039q().name());
        DkCloudStorage.m4994a().m5010a((int) (m4152E().f3449e * 100.0f), m4155H(), new DkCloudReadingInfo(m4156I(), stringBuffer.toString(), ak(), m4160M(), ReaderEnv.get().getDeviceId(), m4157J(), ah.m6500e().m6501a(), dkCloudReadingProgress, dkCloudAnnotationArr), ConflictStrategy.MERGE, m4162O(), new C0816k(this, avVar));
    }

    
    private C0798a m4121a(BookFormat bookFormat, DkCloudAnnotation dkCloudAnnotation) {
        av a;
        if (dkCloudAnnotation instanceof DkCloudComment) {
            a = m4124a(bookFormat, dkCloudAnnotation.getStartPos(), dkCloudAnnotation.getBookRevision(), dkCloudAnnotation.getKernelVersion());
            av a2 = m4124a(bookFormat, dkCloudAnnotation.getEndPos(), dkCloudAnnotation.getBookRevision(), dkCloudAnnotation.getKernelVersion());
            ea eaVar = (ea) C0798a.m3713d(dkCloudAnnotation.getCloudId());
            eaVar.m3725c(dkCloudAnnotation.getCreationDate().getTime());
            eaVar.m3727d(dkCloudAnnotation.getModifiedDate().getTime());
            eaVar.m3718a(a);
            eaVar.m3722b(a2);
            eaVar.m3719a(dkCloudAnnotation.getSample());
            eaVar.m4380e(((DkCloudComment) dkCloudAnnotation).getNoteText());
            eaVar.m4379a(((DkCloudComment) dkCloudAnnotation).getHighlightColor());
            return eaVar;
        } else if (!(dkCloudAnnotation instanceof DkCloudBookmark)) {
            return null;
        } else {
            a = m4124a(bookFormat, dkCloudAnnotation.getStartPos(), dkCloudAnnotation.getBookRevision(), dkCloudAnnotation.getKernelVersion());
            ah ahVar = (ah) C0798a.m3712c(dkCloudAnnotation.getCloudId());
            ahVar.m3725c(dkCloudAnnotation.getCreationDate().getTime());
            ahVar.m3727d(dkCloudAnnotation.getModifiedDate().getTime());
            ahVar.m3718a(a);
            ahVar.m3722b(a);
            ahVar.m3719a(dkCloudAnnotation.getSample());
            return ahVar;
        }
    }

    
    private DkCloudAnnotation m4123a(String str, String str2, C0798a c0798a, long j) {
        if (c0798a instanceof ea) {
            return new DkCloudComment(str, str2, c0798a.m3732i(), j, new Date(c0798a.m3730g()), new Date(c0798a.m3731h()), m4138c(c0798a.m3726d()), m4138c(c0798a.m3728e()), c0798a.m3729f(), ((ea) c0798a).m4384m(), ((ea) c0798a).m4385n());
        } else if (!(c0798a instanceof ah)) {
            return null;
        } else {
            return new DkCloudBookmark(str, str2, c0798a.m3732i(), j, new Date(c0798a.m3730g()), new Date(c0798a.m3731h()), m4138c(c0798a.m3726d()), c0798a.m3729f());
        }
    }

    
    private C0847g m4138c(av avVar) {
        if (avVar instanceof C0936c) {
            C0936c c0936c = (C0936c) avVar;
            return new C0847g(c0936c.m6780g(), c0936c.m6781h(), c0936c.m6782i(), c0936c.m6784k(), c0936c.m6785l());
        } else if (avVar instanceof C0986b) {
            C0986b c0986b = (C0986b) avVar;
            return new C0847g(1, 0, c0986b.m7539g(), "", c0986b.m7539g());
        } else if (avVar instanceof C0898a) {
            C0898a c0898a = (C0898a) avVar;
            return new C0847g(1 + c0898a.m5795g(), c0898a.m5796h(), c0898a.m5797i(), "", -1);
        } else if (avVar instanceof C0965b) {
            C0965b c0965b = (C0965b) avVar;
            return new C0847g(c0965b.m7141g(), c0965b.m7142h(), c0965b.m7143i(), "", -1);
        } else if (f2892C) {
            return null;
        } else {
            throw new AssertionError();
        }
    }

    
    private av m4124a(BookFormat bookFormat, C0847g c0847g, String str, String str2) {
        if (bookFormat == BookFormat.EPUB) {
            return C0952s.m6988a(c0847g.m5591b(), c0847g.m5593c(), c0847g.m5594d(), str, c0847g.m5589a(), c0847g.m5595e(), str2);
        } else if (bookFormat == BookFormat.TXT) {
            return C1000p.m7689b(c0847g.m5594d());
        } else {
            if (bookFormat == BookFormat.PDF) {
                return C0904d.m5963a(c0847g.m5591b() - 1, c0847g.m5593c(), c0847g.m5594d());
            }
            if (bookFormat == BookFormat.SBK) {
                return C0969f.m7162a(c0847g.m5591b(), c0847g.m5593c(), c0847g.m5594d());
            }
            if (f2892C) {
                return null;
            }
            throw new AssertionError();
        }
    }

    
    private void m4130a(C0800c c0800c, C0806u c0806u, boolean z) {
        if (c0800c.mo1039q() != BookFormat.EPUB || c0800c.m4247s() == BookPackageType.EPUB_OPF || c0800c.m4166S()) {
            c0806u.mo1046c();
            return;
        }
        int aq = c0800c.aq();
        if (aq == 0 || aq == 2) {
            C0836v c0836v;
            if (z) {
                for (int size = this.f2901K.size() - 1; size >= 0; size--) {
                    c0836v = (C0836v) this.f2901K.get(size);
                    if (c0836v.f3581a.aH() == c0800c.aH()) {
                        break;
                    }
                }
            }
            c0836v = null;
            if (c0836v == null) {
                c0836v = new C0836v(this, c0800c);
                this.f2901K.add(c0836v);
            }
            c0836v.f3582b.add(c0806u);
            m4139c(c0836v.f3581a);
            return;
        }
        c0806u.mo1046c();
    }

    
    private void m4139c(C0800c c0800c) {
        if (!this.f2902L.contains(Long.valueOf(c0800c.aH()))) {
            C0836v c0836v;
            Iterator it = this.f2901K.iterator();
            while (it.hasNext()) {
                c0836v = (C0836v) it.next();
                if (c0836v.f3581a.aH() == c0800c.aH()) {
                    break;
                }
            }
            c0836v = null;
            if (c0836v != null) {
                this.f2902L.add(Long.valueOf(c0800c.aH()));
                m4133a(c0836v, new C0828m(this, c0836v, c0800c));
            }
        }
    }

    
    private void m4133a(C0836v c0836v, C0806u c0806u) {
        C0800c c0800c = c0836v.f3581a;
        C0798a[] as = c0800c.as();
        C0798a[] c0798aArr = new C0798a[as.length];
        for (int i = 0; i < as.length; i++) {
            c0798aArr[i] = as[i].mo957l();
        }
        C0259a.m568a(new C0829n(this, c0800c, c0798aArr, c0806u), new Void[0]);
    }

    
    private void m4132a(C0800c c0800c, C0798a[] c0798aArr, C0806u c0806u) {
        List arrayList = new ArrayList(c0798aArr.length);
        HashMap hashMap = new HashMap();
        for (C0798a c0798a : c0798aArr) {
            C1011x c1011x = new C1011x(ai.m6509a((C0936c) c0798a.m3726d(), (C0936c) c0798a.m3728e()), c0798a.m3729f());
            arrayList.add(c1011x);
            hashMap.put(c1011x, c0798a);
        }
        aq a = ai.m6506a(c0800c.m4225f(), (ap) c0800c.mo1033b());
        try {
            DkeBook dkeBook = a.f4489b;
            if (dkeBook == null) {
                c0806u.mo1045b();
            } else if (ai.m6516a(dkeBook, arrayList)) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C1011x c1011x2 = (C1011x) it.next();
                    C0798a c0798a2 = (C0798a) hashMap.get(c1011x2);
                    c0798a2.m3718a(((ce) c1011x2.m7779a()).m6813j());
                    c0798a2.m3722b(((ce) c1011x2.m7779a()).m6814k());
                    c0798a2.m3719a(c1011x2.m7782b());
                }
                c0806u.mo1044a();
            } else {
                c0806u.mo1046c();
            }
            ai.m6512a(a);
        } catch (Throwable th) {
            ai.m6512a(a);
        }
    }

    protected final void aD() {
        if (this.f2907d == BookState.PULLING || this.f2907d == BookState.UPDATING) {
            if ((m4242o() == BookType.SERIAL || !this.f2927x.m3775a()) && !this.f2927x.m3777b(211)) {
                ac acVar = new ac(this.f2927x);
                if (acVar.m3777b(2048)) {
                    acVar.m3778c(32);
                } else if (acVar.m3777b(1024)) {
                    if (C0559f.m2476b().m2485d()) {
                        acVar.m3778c(32);
                    } else {
                        acVar.m3779d(32);
                    }
                } else if (!ReaderEnv.get().getIsOnlyWifiUploadDownload()) {
                    acVar.m3778c(32);
                } else if (C0559f.m2476b().m2485d()) {
                    acVar.m3778c(32);
                } else {
                    acVar.m3779d(32);
                }
                if (acVar.f2721e != this.f2927x.f2721e) {
                    this.f2927x = acVar;
                    m3744b(64);
                    aN();
                }
            }
            aE();
        }
    }

    protected final void aE() {
        mo1010a(new ac(this.f2927x));
    }

    
    protected void mo1010a(ac acVar) {
        UThread.runOnThread(new C0834s(this, acVar));
    }

    protected FutureTask<?> aF() {
        return null;
    }

    
    protected final void m4197a(String str, String str2) {
        File file = new File(str);
        String name = file.getName();
        if (!ao() || !name.equals(am().m4682b())) {
            return;
        }
        if (this.f2907d != BookState.NORMAL || !m4167T()) {
            ad();
            m4224e(str2);
            m4196a(Uri.fromFile(file).toString());
            m4253y();
            this.f2907d = BookState.NORMAL;
            m3744b(10);
            aN();
        }
    }

    protected final void aG() {
        if (aq() != -1) {
            ad();
            this.f2907d = BookState.CLOUD_ONLY;
            m3744b(8);
            aN();
        }
    }

    private final void aW() {
        aU().m677b();
        try {
            aU().m673a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"typesetting", "book_id", "" + aH()}));
            aU().m673a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"toc", "book_id", "" + aH()}));
            aU().m681f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            aU().m678c();
        }
    }

    
    protected static final BookType m4144q(String str) {
        try {
            if (TextUtils.equals(str, "TIMED")) {
                return BookType.NORMAL;
            }
            return TextUtils.isEmpty(str) ? BookType.NORMAL : BookType.valueOf(str);
        } catch (Exception e) {
            e.printStackTrace();
            return BookType.NORMAL;
        }
    }

    
    protected static final BookLimitType m4135b(String str, String str2) {
        try {
            if (TextUtils.equals(str2, "TIMED")) {
                return BookLimitType.TIME;
            }
            return TextUtils.isEmpty(str) ? BookLimitType.NONE : BookLimitType.valueOf(str);
        } catch (Exception e) {
            e.printStackTrace();
            return BookLimitType.NONE;
        }
    }

    
    protected static final BookFormat m4145r(String str) {
        try {
            return TextUtils.isEmpty(str) ? BookFormat.TXT : BookFormat.valueOf(str);
        } catch (Exception e) {
            return BookFormat.UNKNOWN;
        }
    }

    
    private static final BookContent mo1016s(String str) {
        try {
            return TextUtils.isEmpty(str) ? BookContent.NORMAL : BookContent.valueOf(str);
        } catch (Throwable th) {
            return BookContent.NORMAL;
        }
    }

    
    private static final BookState mo1017t(String str) {
        try {
            return TextUtils.isEmpty(str) ? BookState.NORMAL : BookState.valueOf(str);
        } catch (Exception e) {
            return BookState.NORMAL;
        }
    }

    
    private static BookPackageType m4120a(String str, BookFormat bookFormat, BookType bookType) {
        try {
            if (TextUtils.isEmpty(str)) {
                switch (C0805f.f3152c[bookFormat.ordinal()]) {
                    case 1:
                        return bookType == BookType.SERIAL ? BookPackageType.DIRECTORY : BookPackageType.EPUB;
                    case 2:
                        return BookPackageType.PDF;
                    default:
                        return BookPackageType.TXT;
                }
            } else if (bookType == BookType.SERIAL && str.equals("EPUB")) {
                return BookPackageType.DIRECTORY;
            } else {
                return BookPackageType.valueOf(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BookPackageType.UNKNOWN;
        }
    }

    private C0839z aX() {
        try {
            aV().mo1091a(aH());
            aQ();
            if (this.f2929z == null) {
                this.f2929z = new C0839z(aV(), aH(), mo1039q());
            }
            C0839z c0839z = this.f2929z;
            return c0839z;
        } finally {
            aV().mo1097b(aH());
        }
    }

    private void aY() {
        UThread.runOnThread(new C0835t(this));
    }
}
