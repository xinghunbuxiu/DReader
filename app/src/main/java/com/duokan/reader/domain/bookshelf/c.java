package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.core.a.u;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.af;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.epublib.DKEBookInfo;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.c.f;
import com.duokan.reader.common.download.DownloadFailCode;
import com.duokan.reader.common.webservices.duokan.y;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudBookmark;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.cloud.DkCloudReadingInfo;
import com.duokan.reader.domain.cloud.DkCloudReadingProgress;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.cloud.DkCloudStorage.ConflictStrategy;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.g;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.Document_a.d;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.epub.ah;
import com.duokan.reader.domain.document.epub.ai;
import com.duokan.reader.domain.document.epub.ap;
import com.duokan.reader.domain.document.epub.aq;
import com.duokan.reader.domain.document.epub.ce;
import com.duokan.reader.domain.document.epub.s;
import com.duokan.reader.domain.document.l;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.document.txt.b;
import com.duokan.reader.domain.document.w;
import com.duokan.reader.domain.document.x;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.domain.micloud.bi;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.Column;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.CommonColumn;

import org.json.JSONObject;

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

public abstract class c extends an {
    static final /* synthetic */ boolean C = (!c.class.desiredAssertionStatus());
    protected LinkedList A = null;
    protected boolean B = false;
    private String E = "";
    private String F = "";
    private final ao G = new ao();
    private final ao H = new ao();
    private final ao I = new ao();
    private final ao J = new ao();
    private final ArrayList K = new ArrayList();
    private final Set L = new HashSet();
    protected final AtomicInteger a = new AtomicInteger(0);
    protected final BookPackageType b;
    protected String c = "";
    protected BookState d = BookState.NORMAL;
    protected BookType e = BookType.NORMAL;
    protected BookLimitType f = BookLimitType.NONE;
    protected String g = null;
    protected ab h = null;
    protected long i = 0;
    protected String j = "本地";
    protected String k = "";
    protected String l = "";
    protected long m = 0;
    protected long n = 0;
    protected long o = 0;
    protected ju p = null;
    protected String q = "";
    protected String r = "";
    protected String s = "";
    protected int t = 0;
    protected int u = 0;
    protected x v = new x(this, "");
    protected long w = 0;
    protected ac x = new ac();
    protected DownloadCenterTask y = null;
    protected z z = null;

    public abstract n a(jn jnVar, w wVar);

    protected c(am amVar, long j, BookPackageType bookPackageType, BookType bookType, BookState bookState, boolean z, boolean z2) {
        super(amVar, j, z, z2);
        this.b = bookPackageType;
        this.e = bookType;
        this.d = bookState;
        this.H.a(BookContent.UNKNOWN);
    }

    protected c(am amVar, Cursor cursor) {
        super(amVar, cursor.getLong(CommonColumn._ID.ordinal()), false, true);
        BookType p = p(cursor.getString(CommonColumn.BOOK_TYPE.ordinal()));
        BookPackageType a = a(cursor.getString(CommonColumn.PACKAGE_TYPE.ordinal()), q(), p);
        BookLimitType b = b(u.c(cursor, CommonColumn.LIMIT_TYPE.ordinal()), cursor.getString(CommonColumn.BOOK_TYPE.ordinal()));
        String c = u.c(cursor, CommonColumn.BOOK_UUID.ordinal());
        String c2 = u.c(cursor, CommonColumn.BOOK_NAME.ordinal());
        BookState s = s(cursor.getString(CommonColumn.BOOK_STATE.ordinal()));
        String c3 = u.c(cursor, CommonColumn.BOOK_REVISION.ordinal());
        String a2 = u.a(cursor, CommonColumn.LAST_REVISION.ordinal(), "");
        String a3 = u.a(cursor, CommonColumn.ONLINE_COVER_URI.ordinal(), "");
        String a4 = u.a(cursor, CommonColumn.LAST_READING_POSITION.ordinal(), null);
        String a5 = u.a(cursor, CommonColumn.BOOK_URI.ordinal(), null);
        String a6 = u.a(cursor, CommonColumn.BOOK_CONTENT.ordinal(), null);
        String a7 = u.a(cursor, CommonColumn.MICLOUD.ordinal(), null);
        this.b = a;
        this.f = b;
        this.e = p;
        this.q = c;
        this.c = c2;
        this.d = s;
        this.r = c3;
        this.s = a2;
        this.E = a3;
        this.J.c(a4);
        this.G.c(a5);
        this.H.c(a6);
        this.I.c(a7);
    }

    public boolean a() {
        return this.a.get() > 0;
    }

    public l b() {
        return null;
    }

    public final void c() {
        try {
            aT().a(aF());
            aO();
        } finally {
            aT().b(aF());
        }
    }

    public final File d() {
        am amVar = null;
        ao aoVar = this.G;
        if (aoVar.d()) {
            try {
                aT().a(aF());
                File file;
                if (aoVar.b()) {
                    file = (File) aoVar.a();
                    return file;
                }
                aoVar.a(new File(Uri.parse((String) aoVar.e()).getPath()));
                file = (File) aoVar.a();
                return file;
            } catch (Throwable th) {
                a.c().a(LogLevel.ERROR, "shelf", "an exception occurs", th);
                aoVar.c(null);
            } finally {
                amVar = aT();
                aoVar = aF();
                amVar.b(aoVar);
            }
        }
        return aoVar.b() ? (File) aoVar.a() : amVar;
    }

    public final String e() {
        File d = d();
        return d != null ? d.getPath() : "";
    }

    public final String f() {
        File d = d();
        return d != null ? Uri.fromFile(d).toString() : "";
    }

    public final void a(String str) {
        try {
            aT().a(aF());
            aO();
            this.G.a(new File(Uri.parse(str).getPath()));
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public final String g() {
        return this.E;
    }

    public final void b(String str) {
        try {
            aT().a(aF());
            aO();
            this.E = str;
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public final String h() {
        if (TextUtils.isEmpty(this.F)) {
            Object H = H();
            if (TextUtils.isEmpty(H)) {
                this.F = "";
            } else {
                this.F = Uri.fromFile(new File(aQ(), H + ".cover")).toString();
            }
        }
        return this.F;
    }

    public final BookState i() {
        return this.d;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        switch (f.a[r().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public float m() {
        return ((float) this.t) / 100.0f;
    }

    public final DownloadFailCode n() {
        if (this.b == BookPackageType.EPUB_OPF) {
            return DownloadFailCode.NONE;
        }
        if (!Y()) {
            return DownloadFailCode.NONE;
        }
        try {
            aT().a(aF());
            aO();
            DownloadFailCode n;
            if (this.y != null) {
                n = this.y.n();
                return n;
            }
            n = DownloadFailCode.NONE;
            aT().b(aF());
            return n;
        } finally {
            aT().b(aF());
        }
    }

    public final BookType o() {
        try {
            BookType bookType;
            aT().a(aF());
            if (BookType.TRIAL == this.e) {
                aO();
                bookType = TextUtils.isEmpty(this.q) ? BookType.NORMAL : BookType.TRIAL;
                aT().b(aF());
            } else {
                bookType = this.e;
                aT().b(aF());
            }
            return bookType;
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final void a(BookType bookType) {
        try {
            aT().a(aF());
            aO();
            if (bookType != this.e) {
                this.e = bookType;
                b(4);
            }
            aT().b(aF());
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final BookLimitType p() {
        try {
            aT().a(aF());
            BookLimitType bookLimitType = this.f;
            return bookLimitType;
        } finally {
            aT().b(aF());
        }
    }

    public final void a(BookLimitType bookLimitType) {
        try {
            aT().a(aF());
            aO();
            if (bookLimitType != this.f) {
                this.f = bookLimitType;
                b(32);
            }
            aT().b(aF());
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public BookFormat q() {
        return BookFormat.UNKNOWN;
    }

    public final BookContent r() {
        ao aoVar = this.H;
        if (aoVar.d()) {
            try {
                aT().a(aF());
                BookContent bookContent;
                if (aoVar.b()) {
                    bookContent = (BookContent) aoVar.a();
                    return bookContent;
                }
                aoVar.a(r((String) aoVar.e()));
                bookContent = (BookContent) aoVar.a();
                return bookContent;
            } catch (Throwable th) {
                a.c().a(LogLevel.ERROR, "shelf", "an exception occurs", th);
                aoVar.c(null);
            } finally {
                aoVar = aT();
                aoVar.b(aF());
            }
        }
        if (aoVar.b()) {
            return (BookContent) aoVar.a();
        }
        return BookContent.UNKNOWN;
    }

    public final void a(BookContent bookContent) {
        try {
            aT().a(aF());
            if (!this.H.b(bookContent)) {
                this.H.a(bookContent);
                b(2);
            }
            aT().b(aF());
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final BookPackageType s() {
        try {
            aT().a(aF());
            BookPackageType bookPackageType = this.b;
            return bookPackageType;
        } finally {
            aT().b(aF());
        }
    }

    public final ab t() {
        try {
            aT().a(aF());
            aO();
            if (this.h == null) {
                this.h = new ab(this.g);
                this.g = null;
            }
            ab abVar = this.h;
            return abVar;
        } finally {
            aT().b(aF());
        }
    }

    public final void a(ab abVar) {
        try {
            aT().a(aF());
            aO();
            this.h = abVar;
            this.g = null;
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public boolean u() {
        return false;
    }

    public boolean v() {
        return true;
    }

    public boolean w() {
        return A().equals("newbie");
    }

    public boolean a(boolean z) {
        return false;
    }

    public void a(af afVar) {
    }

    public final void x() {
        Object obj = null;
        try {
            aT().a(aF());
            aO();
            if (q() == BookFormat.EPUB) {
                Object obj2 = !ai() ? 1 : null;
                boolean isEmpty = TextUtils.isEmpty(B());
                if (r() == BookContent.UNKNOWN) {
                    obj = 1;
                }
                if (!(obj2 == null && !isEmpty && obj == null)) {
                    aq a = ai.a(f(), (ap) b());
                    DkeBook dkeBook = a.b;
                    if (dkeBook.isValid()) {
                        DKEBookInfo dKEBookInfo = new DKEBookInfo();
                        dkeBook.getBookInfo(dKEBookInfo);
                        if (!(obj2 == null || TextUtils.isEmpty(dKEBookInfo.mTitle))) {
                            o(dKEBookInfo.mTitle);
                        }
                        if (isEmpty && !TextUtils.isEmpty(dKEBookInfo.mAuthor)) {
                            d(dKEBookInfo.mAuthor);
                        }
                        if (obj != null) {
                            if (dkeBook.getComicsFrameCount() > 0) {
                                a(BookContent.FRAME_COMIC);
                            } else if (dkeBook.getLayoutType() == 3) {
                                a(BookContent.PAGE_COMIC);
                            } else if (dkeBook.getLayoutType() == 4) {
                                a(BookContent.VERTICAL_COMIC);
                            } else if (dkeBook.hasAudioText()) {
                                a(BookContent.AUDIO_TEXT);
                            } else {
                                a(BookContent.NORMAL);
                            }
                        }
                    }
                    ai.a(a);
                }
            } else {
                a(BookContent.NORMAL);
            }
            aT().b(aF());
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public ad y() {
        return null;
    }

    public void a(ad adVar) {
    }

    public final long z() {
        try {
            aT().a(aF());
            aO();
            long j = this.i;
            return j;
        } finally {
            aT().b(aF());
        }
    }

    public final void a(long j) {
        try {
            aT().a(aF());
            aO();
            this.i = j;
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public final String A() {
        try {
            aT().a(aF());
            aO();
            String str = this.j;
            return str;
        } finally {
            aT().b(aF());
        }
    }

    public final void c(String str) {
        try {
            aT().a(aF());
            aO();
            this.j = str;
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public final String B() {
        try {
            aT().a(aF());
            aO();
            String str = this.k;
            return str;
        } finally {
            aT().b(aF());
        }
    }

    public final void d(String str) {
        try {
            aT().a(aF());
            aO();
            this.k = str;
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public final long C() {
        try {
            aT().a(aF());
            aO();
            long j = this.m;
            return j;
        } finally {
            aT().b(aF());
        }
    }

    public final void b(long j) {
        try {
            aT().a(aF());
            aO();
            this.m = j;
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public final js D() {
        js jsVar;
        ao aoVar = this.J;
        if (aoVar.d()) {
            try {
                aT().a(aF());
                if (aoVar.b()) {
                    jsVar = (js) aoVar.a();
                    return jsVar;
                }
                aoVar.a(new js(q(), (String) aoVar.e()));
                jsVar = (js) aoVar.a();
                return jsVar;
            } catch (Throwable th) {
                a.c().a(LogLevel.ERROR, "shelf", "an exception occurs", th);
                aoVar.c(null);
            } finally {
                aoVar = aT();
                aoVar.b(aF());
            }
        }
        if (aoVar.b()) {
            return (js) aoVar.a();
        }
        try {
            aT().a(aF());
            if (aoVar.b()) {
                jsVar = (js) aoVar.a();
                return jsVar;
            }
            aoVar.a(new js(q(), ""));
            jsVar = (js) aoVar.a();
            aT().b(aF());
            return jsVar;
        } finally {
            aT().b(aF());
        }
    }

    public final void a(js jsVar) {
        try {
            aT().a(aF());
            aO();
            this.J.a(jsVar);
            b((int) j.e);
        } finally {
            aT().b(aF());
        }
    }

    public final long E() {
        try {
            aT().a(aF());
            aO();
            long j = t().n;
            return j;
        } finally {
            aT().b(aF());
        }
    }

    public final void c(long j) {
        try {
            aT().a(aF());
            aO();
            t().n = Math.max(j, t().n);
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public final void d(long j) {
        try {
            aT().a(aF());
            aO();
            this.n = j;
            b((int) j.e);
        } finally {
            aT().b(aF());
        }
    }

    public final long F() {
        try {
            aT().a(aF());
            aO();
            long j = this.o;
            return j;
        } finally {
            aT().b(aF());
        }
    }

    public final void e(long j) {
        try {
            aT().a(aF());
            aO();
            this.o = j;
            b((int) j.e);
        } finally {
            aT().b(aF());
        }
    }

    public final ju G() {
        try {
            aT().a(aF());
            aO();
            if (this.p == null) {
                this.p = new ju();
            }
            ju juVar = this.p;
            return juVar;
        } finally {
            aT().b(aF());
        }
    }

    public final void a(ju juVar) {
        try {
            aT().a(aF());
            aO();
            this.p = juVar;
            b((int) j.e);
        } finally {
            aT().b(aF());
        }
    }

    public final String H() {
        try {
            aT().a(aF());
            if (TextUtils.isEmpty(this.q)) {
                if (R()) {
                    this.q = DkUtils.calcUniversalBookId(e());
                } else {
                    this.q = "";
                }
            }
            String str = this.q;
            return str;
        } finally {
            aT().b(aF());
        }
    }

    public final void e(String str) {
        try {
            aT().a(aF());
            aO();
            this.q = str;
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public final String I() {
        try {
            aT().a(aF());
            String str = this.r;
            return str;
        } finally {
            aT().b(aF());
        }
    }

    public final void f(String str) {
        try {
            aT().a(aF());
            aO();
            this.r = str;
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public final String J() {
        try {
            aT().a(aF());
            String str = this.s;
            return str;
        } finally {
            aT().b(aF());
        }
    }

    public final void g(String str) {
        try {
            aT().a(aF());
            if (!TextUtils.equals(this.s, str)) {
                this.s = str;
                b(2);
            }
            aT().b(aF());
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final int K() {
        try {
            aT().a(aF());
            aO();
            int i = this.u;
            return i;
        } finally {
            aT().b(aF());
        }
    }

    public final void a(int i) {
        try {
            aT().a(aF());
            aO();
            this.u = i;
            b(16);
        } finally {
            aT().b(aF());
        }
    }

    public final long L() {
        try {
            aT().a(aF());
            aO();
            this.v.a();
            long a = this.v.c;
            return a;
        } finally {
            aT().b(aF());
        }
    }

    public final void f(long j) {
        try {
            aT().a(aF());
            aO();
            this.v.a();
            this.v.c = j;
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public final String M() {
        try {
            aT().a(aF());
            aO();
            this.v.a();
            String b = this.v.d;
            return b;
        } finally {
            aT().b(aF());
        }
    }

    public final void h(String str) {
        try {
            aT().a(aF());
            aO();
            this.v.a();
            this.v.d = str;
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public final String N() {
        try {
            aT().a(aF());
            aO();
            this.v.a();
            String c = this.v.e;
            return c;
        } finally {
            aT().b(aF());
        }
    }

    public final void i(String str) {
        try {
            aT().a(aF());
            aO();
            this.v.a();
            this.v.e = str;
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public final long O() {
        try {
            aT().a(aF());
            aO();
            long j = this.w;
            return j;
        } finally {
            aT().b(aF());
        }
    }

    public final void g(long j) {
        if (this.w != j) {
            try {
                aT().a(aF());
                aO();
                this.w = j;
                b(536870912);
            } finally {
                aT().b(aF());
            }
        }
    }

    public final void j(String str) {
        ju G = G();
        G.c = str;
        a(G);
    }

    public void a(String str, String str2, String str3, String str4, boolean z, af afVar) {
        try {
            String H;
            aT().a(aF());
            aO();
            if (this.d == BookState.PULLING || this.d == BookState.UPDATING) {
                this.x.d(128);
                aC();
            }
            if (TextUtils.equals(this.r, str3) && TextUtils.equals(f(), str)) {
                this.d = BookState.PULLING;
            } else {
                this.d = BookState.UPDATING;
            }
            ac acVar = new ac(str, str2, str3, str4);
            acVar.a(z, afVar);
            this.x = acVar;
            this.x.c(240);
            this.t = 0;
            b(268435528);
            aL();
            aB();
            if (ai()) {
                H = H();
            } else {
                H = aw();
            }
            com.duokan.reader.domain.statistics.dailystats.a.d().c(H, G().c);
        } finally {
            aT().b(aF());
        }
    }

    public final boolean P() {
        return o() == BookType.TRIAL;
    }

    public final boolean Q() {
        return p() == BookLimitType.TIME;
    }

    public final boolean R() {
        if (i() == BookState.CLOUD_ONLY) {
            return false;
        }
        File d = d();
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
        if (ai()) {
            b = com.duokan.core.io.a.b(ManagedApp.get());
        } else {
            b = com.duokan.core.io.a.a(ManagedApp.get());
        }
        for (File d2 : r0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                File file = new File(d2, (String) it.next());
                if (file.exists()) {
                    a(Uri.fromFile(file).toString());
                    aL();
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean S() {
        switch (f.b[this.d.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public final boolean T() {
        try {
            aT().a(aF());
            if (ai()) {
                return false;
            }
            if (ak() != null) {
                aT().b(aF());
                return false;
            }
            aT().b(aF());
            return true;
        } finally {
            aT().b(aF());
        }
    }

    public final boolean U() {
        try {
            aT().a(aF());
            boolean z = (!V() || W() || X() || Y()) ? false : true;
            aT().b(aF());
            return z;
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final boolean V() {
        try {
            aT().a(aF());
            if (this.d == BookState.NORMAL || this.d == BookState.CLOUD_ONLY) {
                aT().b(aF());
                return false;
            }
            aO();
            if (this.x.a()) {
                aT().b(aF());
                return false;
            } else if (this.x.b(195)) {
                aT().b(aF());
                return false;
            } else {
                aT().b(aF());
                return true;
            }
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final boolean W() {
        try {
            aT().a(aF());
            aO();
            if (!V()) {
                return false;
            }
            if (this.x.a()) {
                aT().b(aF());
                return false;
            } else if (this.x.b(32)) {
                aT().b(aF());
                return true;
            } else if (this.y == null || !this.y.c()) {
                aT().b(aF());
                return false;
            } else {
                aT().b(aF());
                return true;
            }
        } finally {
            aT().b(aF());
        }
    }

    public final boolean X() {
        try {
            aT().a(aF());
            aO();
            if (!V()) {
                return false;
            }
            if (this.x.a()) {
                aT().b(aF());
                return false;
            } else if (this.x.b(16)) {
                aT().b(aF());
                return true;
            } else if (this.y == null || !this.y.c()) {
                aT().b(aF());
                return false;
            } else {
                aT().b(aF());
                return true;
            }
        } finally {
            aT().b(aF());
        }
    }

    public final boolean Y() {
        try {
            aT().a(aF());
            aO();
            if (this.d == BookState.NORMAL || this.d == BookState.CLOUD_ONLY) {
                aT().b(aF());
                return false;
            } else if (this.x.a()) {
                aT().b(aF());
                return false;
            } else if (this.x.a(2)) {
                aT().b(aF());
                return true;
            } else if (this.y == null || !this.y.h()) {
                aT().b(aF());
                return false;
            } else {
                aT().b(aF());
                return true;
            }
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final void Z() {
        try {
            aT().a(aF());
            aO();
            this.x.c(240);
            this.x.c(2);
            b(64);
            aL();
            aB();
        } finally {
            aT().b(aF());
        }
    }

    public final void b(af afVar) {
        try {
            aT().a(aF());
            aO();
            this.x.a(this.x.a(j.g), afVar);
            Z();
        } finally {
            aT().b(aF());
        }
    }

    public final void a(boolean z, af afVar) {
        try {
            aT().a(aF());
            aO();
            this.x.a(z, afVar);
            Z();
        } finally {
            aT().b(aF());
        }
    }

    public final void aa() {
        try {
            aT().a(aF());
            aO();
            this.x.c(240);
            this.x.d(16);
            b(64);
            aL();
            aC();
        } finally {
            aT().b(aF());
        }
    }

    public final void ab() {
        try {
            aT().a(aF());
            aO();
            if (V()) {
                this.d = BookState.CLOUD_ONLY;
                this.x.c(240);
                this.x.d(128);
                b(72);
                aL();
                aC();
            }
            aT().b(aF());
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final boolean ac() {
        try {
            aT().a(aF());
            aO();
            if (ae()) {
                return true;
            }
            if (am() && ad()) {
                aT().b(aF());
                return true;
            }
            aT().b(aF());
            return false;
        } finally {
            aT().b(aF());
        }
    }

    public final boolean ad() {
        boolean z = false;
        try {
            aT().a(aF());
            aO();
            if (R()) {
                if (!ae()) {
                    z = true;
                }
                aT().b(aF());
            }
            return z;
        } finally {
            aT().b(aF());
        }
    }

    public final boolean ae() {
        try {
            aT().a(aF());
            aO();
            if (!R()) {
                return false;
            }
            if (j()) {
                aT().b(aF());
                return true;
            } else if (ai()) {
                aT().b(aF());
                return true;
            } else {
                if (am()) {
                    if (d().getAbsolutePath().endsWith(hi.a("", ak()))) {
                        aT().b(aF());
                        return true;
                    }
                }
                aT().b(aF());
                return false;
            }
        } finally {
            aT().b(aF());
        }
    }

    public void af() {
        try {
            aT().a(aF());
            aO();
            ab();
            if (ac()) {
                ah();
                com.duokan.core.io.a.d(d());
                if (this.d != BookState.CLOUD_ONLY) {
                    this.d = BookState.CLOUD_ONLY;
                    b(8);
                }
                aL();
                aT().b(aF());
            }
        } finally {
            aT().b(aF());
        }
    }

    public long ag() {
        long j = 0;
        try {
            aT().a(aF());
            aO();
            if (ac()) {
                File d = d();
                if (j()) {
                    d = d.getParentFile();
                }
                if (d.isDirectory()) {
                    long j2 = 0;
                    for (File length : com.duokan.core.io.a.a(d, new FileFilter[0])) {
                        j2 += length.length();
                    }
                    j = j2;
                } else {
                    j = d.length();
                }
                aT().b(aF());
            }
            return j;
        } finally {
            aT().b(aF());
        }
    }

    public void ah() {
        try {
            aT().a(aF());
            aO();
            ab();
            if (ae()) {
                File d = d();
                if (j()) {
                    com.duokan.core.io.a.d(d.getParentFile());
                } else if (ai()) {
                    com.duokan.core.io.a.d(d);
                } else if (am()) {
                    if (d.getAbsolutePath().endsWith(hi.a("", ak()))) {
                        com.duokan.core.io.a.d(d.getParentFile());
                    }
                }
                if (this.d != BookState.CLOUD_ONLY) {
                    this.d = BookState.CLOUD_ONLY;
                    b(8);
                }
                this.x.c(240);
                this.x.c(3);
                this.x.d(64);
                this.t = 0;
                b(268435520);
                aL();
                aT().b(aF());
            }
        } finally {
            aT().b(aF());
        }
    }

    public boolean ai() {
        return false;
    }

    public boolean aj() {
        return false;
    }

    public static boolean k(String str) {
        return new y(str).a().length() == 32;
    }

    public static boolean l(String str) {
        if (TextUtils.isDigitsOnly(new y(str).a())) {
            return true;
        }
        return false;
    }

    public static boolean m(String str) {
        y yVar = new y(str);
        if (TextUtils.isDigitsOnly(yVar.a()) && Long.parseLong(yVar.a()) < 10000000) {
            return true;
        }
        return false;
    }

    public static boolean n(String str) {
        y yVar = new y(str);
        if (!TextUtils.isDigitsOnly(yVar.a())) {
            return false;
        }
        long parseLong = Long.parseLong(yVar.a());
        if (parseLong < 10000000 || parseLong >= 50000000) {
            return false;
        }
        return true;
    }

    public static boolean a(boolean z, String str) {
        if (z) {
            return true;
        }
        if (TextUtils.isEmpty(str) || (str.charAt(0) >= 'g' && str.charAt(0) <= 'w' && str.charAt(0) != 'q')) {
            return false;
        }
        return true;
    }

    public final iy ak() {
        am amVar = null;
        ao aoVar = this.I;
        if (aoVar.d()) {
            try {
                aT().a(aF());
                iy iyVar;
                if (aoVar.b()) {
                    iyVar = (iy) aoVar.a();
                    return iyVar;
                }
                aoVar.a(new iy(new bi(new JSONObject((String) aoVar.e()))));
                iyVar = (iy) aoVar.a();
                return iyVar;
            } catch (Throwable th) {
                a.c().a(LogLevel.ERROR, "shelf", "an exception occurs", th);
                aoVar.c(null);
            } finally {
                amVar = aT();
                aoVar = aF();
                amVar.b(aoVar);
            }
        }
        return aoVar.b() ? (iy) aoVar.a() : amVar;
    }

    public final void a(iy iyVar) {
        try {
            aT().a(aF());
            this.I.a(iyVar);
            b(1024);
        } finally {
            aT().b(aF());
        }
    }

    public final void al() {
        try {
            aT().a(aF());
            this.I.a(null);
            b(1024);
        } finally {
            aT().b(aF());
        }
    }

    public final boolean am() {
        if (!this.I.d() && this.I.a() == null) {
            return false;
        }
        return true;
    }

    public final boolean an() {
        try {
            aT().a(aF());
            aO();
            boolean z = ak() != null && ReaderEnv.get().isMiCloudBookPath(e());
            aT().b(aF());
            return z;
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final int ao() {
        try {
            aT().a(aF());
            aO();
            if (ak() != null) {
                return 3;
            }
            if (!ai()) {
                aT().b(aF());
                return -1;
            } else if (o() == BookType.SERIAL) {
                aT().b(aF());
                return 1;
            } else {
                aT().b(aF());
                return 0;
            }
        } finally {
            aT().b(aF());
        }
    }

    public final String ap() {
        try {
            String f;
            aT().a(aF());
            aO();
            if (ao() == 3) {
                f = ak().f();
            } else {
                f = H();
                aT().b(aF());
            }
            return f;
        } finally {
            aT().b(aF());
        }
    }

    public final a[] aq() {
        return aV().a();
    }

    public final void a(a aVar) {
        aV().a(aVar);
        a(L(), UUID.randomUUID().toString());
        aW();
    }

    public final void a(List list, boolean z) {
        for (a b : list) {
            aV().b(b);
        }
        a(L(), UUID.randomUUID().toString());
        if (z) {
            aW();
        }
    }

    public final void b(a aVar) {
        aV().b(aVar);
        a(L(), UUID.randomUUID().toString());
        aW();
    }

    public final void c(a aVar) {
        aV().c(aVar);
        a(L(), UUID.randomUUID().toString());
        aW();
    }

    public final void a(List list) {
        com.duokan.core.a.n aR;
        try {
            aT().a(aF());
            aR = aR();
            aR.b();
            for (a c : list) {
                aV().c(c);
            }
            a(L(), UUID.randomUUID().toString());
            aR.f();
            aR.c();
            aW();
            aT().b(aF());
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final void a(DkCloudAnnotation[] dkCloudAnnotationArr) {
        aV().a(dkCloudAnnotationArr);
        aW();
    }

    public void a(long j, String str) {
        com.duokan.core.a.n aR;
        try {
            aT().a(aF());
            f(j);
            i(str);
            aR = aR();
            aR.b();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("local_reading_info_version", L());
            jSONObject.put("local_reading_info_revision", M());
            jSONObject.put("local_annotation_change_id", N());
            aR.a("UPDATE books SET cloud = ? WHERE _id = ?", new String[]{jSONObject.toString(), "" + aF()});
            aR.f();
            aR.c();
        } catch (Exception e) {
            e.printStackTrace();
            aR.c();
        } catch (Throwable th) {
            aT().b(aF());
        }
        aT().b(aF());
    }

    public void ar() {
        aV().b();
        aW();
    }

    public void a(w wVar) {
        if (this.A == null) {
            this.A = new LinkedList();
        }
        this.A.add(wVar);
    }

    public void b(w wVar) {
        if (this.A == null) {
            this.A = new LinkedList();
        }
        this.A.remove(wVar);
    }

    public void b(boolean z) {
        this.B = z;
    }

    public boolean as() {
        return this.B;
    }

    public void a(av avVar) {
        a(true, new d(this, avVar));
    }

    public void a(y yVar) {
        a(false, yVar);
    }

    public void a(boolean z, y yVar) {
        a(this, new g(this, yVar), true);
        if (i.f().b() && PersonalPrefs.a().x()) {
            DkCloudReadingProgress dkCloudReadingProgress;
            if (!D().a.d() || D().a()) {
                dkCloudReadingProgress = null;
            } else {
                dkCloudReadingProgress = new DkCloudReadingProgress(c(D().a));
            }
            DkCloudAnnotation[] dkCloudAnnotationArr = new DkCloudAnnotation[0];
            a[] aq = aq();
            if (aq != null) {
                LinkedList linkedList = new LinkedList();
                String a = ah.e().a();
                for (a a2 : aq) {
                    linkedList.add(a(I(), a, a2, L()));
                }
                dkCloudAnnotationArr = (DkCloudAnnotation[]) linkedList.toArray(new DkCloudAnnotation[0]);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(aw()).append(".").append(q().name());
            DkCloudStorage.a().a(new DkCloudReadingInfo(H(), stringBuffer.toString(), ai(), L(), ReaderEnv.get().getDeviceId(), I(), ah.e().a(), dkCloudReadingProgress, dkCloudAnnotationArr), TextUtils.isEmpty(N()) ? ConflictStrategy.TAKE_SERVER_VERSION : ConflictStrategy.MERGE, N(), z, new h(this, yVar, z));
            return;
        }
        yVar.a(this, false);
        yVar.b(this, false);
    }

    public final void at() {
        try {
            aT().a(aF());
            aO();
            aU();
        } finally {
            aT().b(aF());
        }
    }

    public final boolean au() {
        try {
            aT().a(aF());
            boolean z = (TextUtils.isEmpty(this.s) || TextUtils.isEmpty(this.r) || this.s.compareTo(this.r) <= 0) ? false : true;
            aT().b(aF());
            return z;
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    protected void av() {
        super.av();
        if (this.w > 0) {
            aT().a(this, this.w);
        }
        aB();
    }

    public void onConnectivityChanged(f fVar) {
        if (aP()) {
            if (((fVar.e() && ManagedApp.get().getOldRunningState() == RunningState.FOREGROUND) || fVar.d()) && PersonalPrefs.a().x() && i.f().b()) {
                ju G = G();
                if (G.a > 0 || G.b > 0) {
                    a(D().a);
                }
            }
            try {
                aT().a(aF());
                aB();
            } finally {
                aT().b(aF());
            }
        }
    }

    protected void a(DownloadCenterTask downloadCenterTask) {
        try {
            aT().a(aF());
            aO();
            this.t = (int) (downloadCenterTask.j() * 100.0f);
            b(268435456);
        } finally {
            aT().b(aF());
        }
    }

    protected void b(DownloadCenterTask downloadCenterTask) {
        try {
            aT().a(aF());
            aO();
            if (this.d == BookState.PULLING) {
                x();
                this.m = downloadCenterTask.l();
                if (this.m < 0) {
                    this.m = d().length();
                }
                this.d = BookState.NORMAL;
                this.x.c(240);
                this.x.d(64);
                this.x.d(1);
                b(74);
                aL();
                aC();
            } else if (this.d == BookState.UPDATING) {
                File d = d();
                this.m = downloadCenterTask.l();
                if (this.m < 0) {
                    this.m = d.length();
                }
                a(this.x.a);
                a(BookType.NORMAL);
                this.r = this.x.c;
                this.s = "";
                this.d = BookState.NORMAL;
                this.x.c(240);
                this.x.d(64);
                this.x.d(2);
                b(74);
                aL();
                aC();
                if (!d.equals(d())) {
                    d.delete();
                }
            }
            aT().b(aF());
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    protected void c(DownloadCenterTask downloadCenterTask) {
        try {
            aT().a(aF());
            aO();
            if (this.d == BookState.PULLING || this.d == BookState.UPDATING) {
                this.x.d(2);
                b(64);
                aL();
            }
            aT().b(aF());
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final String aw() {
        try {
            aT().a(aF());
            if (TextUtils.isEmpty(this.c)) {
                aO();
                if (am() && new File(e()).exists()) {
                    x();
                    aL();
                }
            }
            String str = this.c;
            return str;
        } finally {
            aT().b(aF());
        }
    }

    protected final void o(String str) {
        try {
            aT().a(aF());
            aO();
            this.c = str;
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public final long ax() {
        try {
            aT().a(aF());
            aO();
            long j = this.n;
            return j;
        } finally {
            aT().b(aF());
        }
    }

    public final boolean ay() {
        return true;
    }

    public boolean az() {
        return this.d == BookState.CLOUD_ONLY;
    }

    protected void a(Cursor cursor) {
        this.g = u.c(cursor, Column.BOOK_DETAIL.ordinal());
        this.i = u.b(cursor, Column.ADDED_DATE.ordinal());
        this.j = u.c(cursor, Column.ADDED_FROM.ordinal());
        this.k = u.c(cursor, Column.AUTHOR.ordinal());
        this.l = u.c(cursor, Column.CONTENT_ENCODING.ordinal());
        this.m = u.b(cursor, Column.FILE_SIZE.ordinal());
        this.n = u.b(cursor, Column.LAST_READING_DATE.ordinal());
        this.p = new ju(u.c(cursor, Column.READING_STATISTICS.ordinal()));
        String c = u.c(cursor, Column.CLOUD.ordinal());
        this.t = u.a(cursor, Column.TRANSFER_PROGRESS.ordinal());
        this.u = u.a(cursor, Column.BOOK_PRICE.ordinal());
        this.w = u.b(cursor, Column.TASK_PRIORITY.ordinal());
        this.o = u.b(cursor, Column.FINISH_READING_DATE.ordinal());
        this.v = new x(this, c);
        this.x = new ac(u.c(cursor, Column.DOWNLOAD_INFO.ordinal()));
    }

    protected void a(ContentValues contentValues) {
        if (c(2)) {
            contentValues.put(Column.ADDED_DATE.toString(), Long.valueOf(z()));
            contentValues.put(Column.ADDED_FROM.toString(), A());
            contentValues.put(Column.BOOK_NAME.toString(), aw());
            contentValues.put(Column.BOOK_UUID.toString(), H());
            contentValues.put(Column.BOOK_URI.toString(), f());
            contentValues.put(Column.ONLINE_COVER_URI.toString(), g());
            contentValues.put(Column.BOOK_FORMAT.toString(), q().toString());
            contentValues.put(Column.FILE_SIZE.toString(), Long.valueOf(C()));
            contentValues.put(Column.AUTHOR.toString(), B());
            contentValues.put(Column.BOOK_DETAIL.toString(), t().toString());
            contentValues.put(Column.BOOK_UUID.toString(), H());
            contentValues.put(Column.BOOK_REVISION.toString(), I());
            contentValues.put(Column.LAST_REVISION.toString(), J());
            contentValues.put(Column.BOOK_CONTENT.toString(), r().toString());
            contentValues.put(Column.PACKAGE_TYPE.toString(), s().toString());
            if (!TextUtils.isEmpty(H())) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("local_reading_info_version", L());
                    jSONObject.put("local_reading_info_revision", M());
                    jSONObject.put("local_annotation_change_id", N());
                    contentValues.put(Column.CLOUD.toString(), jSONObject.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (c(16)) {
            contentValues.put(Column.BOOK_PRICE.toString(), Integer.valueOf(K()));
        }
        if (c(36)) {
            contentValues.put(Column.BOOK_TYPE.toString(), o().toString());
            contentValues.put(Column.LIMIT_TYPE.toString(), p().toString());
        }
        if (c(8)) {
            contentValues.put(Column.BOOK_STATE.toString(), this.d.toString());
        }
        if (c(536870912)) {
            contentValues.put(Column.TASK_PRIORITY.toString(), Long.valueOf(this.w));
        }
        if (c(j.e)) {
            contentValues.put(Column.LAST_READING_DATE.toString(), Long.valueOf(this.n));
            contentValues.put(Column.FINISH_READING_DATE.toString(), Long.valueOf(this.o));
            js jsVar = (js) this.J.a();
            if (jsVar != null) {
                contentValues.put(Column.LAST_READING_POSITION.toString(), jsVar.toString());
            }
            if (this.p != null) {
                contentValues.put(Column.READING_STATISTICS.toString(), this.p.toString());
            }
        }
        if (c(64) && this.x != null) {
            contentValues.put(Column.DOWNLOAD_INFO.toString(), this.x.a() ? "" : this.x.toString());
        }
        if (c(268435456)) {
            contentValues.put(Column.TRANSFER_PROGRESS.toString(), Integer.valueOf(this.t));
        }
        if (c(1024)) {
            iy iyVar = (iy) this.I.a();
            if (iyVar != null) {
                contentValues.put(Column.MICLOUD.toString(), iyVar.a().a().toString());
            }
        }
    }

    protected String aA() {
        return "books";
    }

    private void b(av avVar) {
        DkCloudReadingProgress dkCloudReadingProgress;
        DkCloudAnnotation[] dkCloudAnnotationArr;
        if (D().a.d()) {
            dkCloudReadingProgress = new DkCloudReadingProgress(c(D().a));
        } else {
            dkCloudReadingProgress = null;
        }
        if (TextUtils.isEmpty(N())) {
            dkCloudAnnotationArr = null;
        } else {
            Object linkedList = new LinkedList();
            a[] aq = aq();
            String a = ah.e().a();
            for (a a2 : aq) {
                linkedList.add(a(I(), a, a2, L()));
            }
            Collections.sort(linkedList, new j(this));
            dkCloudAnnotationArr = (DkCloudAnnotation[]) linkedList.toArray(new DkCloudAnnotation[0]);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(aw()).append(".").append(q().name());
        DkCloudStorage.a().a((int) (D().e * 100.0f), G(), new DkCloudReadingInfo(H(), stringBuffer.toString(), ai(), L(), ReaderEnv.get().getDeviceId(), I(), ah.e().a(), dkCloudReadingProgress, dkCloudAnnotationArr), ConflictStrategy.MERGE, N(), new k(this, avVar));
    }

    private a a(BookFormat bookFormat, DkCloudAnnotation dkCloudAnnotation) {
        av a;
        if (dkCloudAnnotation instanceof DkCloudComment) {
            a = a(bookFormat, dkCloudAnnotation.getStartPos(), dkCloudAnnotation.getBookRevision(), dkCloudAnnotation.getKernelVersion());
            av a2 = a(bookFormat, dkCloudAnnotation.getEndPos(), dkCloudAnnotation.getBookRevision(), dkCloudAnnotation.getKernelVersion());
            ef efVar = (ef) a.d(dkCloudAnnotation.getCloudId());
            efVar.c(dkCloudAnnotation.getCreationDate().getTime());
            efVar.d(dkCloudAnnotation.getModifiedDate().getTime());
            efVar.a(a);
            efVar.b(a2);
            efVar.a(dkCloudAnnotation.getSample());
            efVar.e(((DkCloudComment) dkCloudAnnotation).getNoteText());
            efVar.a(((DkCloudComment) dkCloudAnnotation).getHighlightColor());
            return efVar;
        } else if (!(dkCloudAnnotation instanceof DkCloudBookmark)) {
            return null;
        } else {
            a = a(bookFormat, dkCloudAnnotation.getStartPos(), dkCloudAnnotation.getBookRevision(), dkCloudAnnotation.getKernelVersion());
            ah ahVar = (ah) a.c(dkCloudAnnotation.getCloudId());
            ahVar.c(dkCloudAnnotation.getCreationDate().getTime());
            ahVar.d(dkCloudAnnotation.getModifiedDate().getTime());
            ahVar.a(a);
            ahVar.b(a);
            ahVar.a(dkCloudAnnotation.getSample());
            return ahVar;
        }
    }

    private DkCloudAnnotation a(String str, String str2, a aVar, long j) {
        if (aVar instanceof ef) {
            return new DkCloudComment(str, str2, aVar.i(), j, new Date(aVar.g()), new Date(aVar.h()), c(aVar.d()), c(aVar.e()), aVar.f(), ((ef) aVar).m(), ((ef) aVar).n());
        } else if (!(aVar instanceof ah)) {
            return null;
        } else {
            return new DkCloudBookmark(str, str2, aVar.i(), j, new Date(aVar.g()), new Date(aVar.h()), c(aVar.d()), aVar.f());
        }
    }

    private g c(av avVar) {
        if (avVar instanceof com.duokan.reader.domain.document.epub.c) {
            com.duokan.reader.domain.document.epub.c cVar = (com.duokan.reader.domain.document.epub.c) avVar;
            return new g(cVar.g(), cVar.h(), cVar.i(), cVar.k(), cVar.l());
        } else if (avVar instanceof b) {
            b bVar = (b) avVar;
            return new g(1, 0, bVar.g(), "", bVar.g());
        } else if (avVar instanceof Document_a.a) {
            Document_a.a aVar = (Document_a.a) avVar;
            return new g(1 + aVar.g(), aVar.h(), aVar.i(), "", -1);
        } else if (avVar instanceof com.duokan.reader.domain.document.sbk.b) {
            com.duokan.reader.domain.document.sbk.b bVar2 = (com.duokan.reader.domain.document.sbk.b) avVar;
            return new g(bVar2.g(), bVar2.h(), bVar2.i(), "", -1);
        } else if (C) {
            return null;
        } else {
            throw new AssertionError();
        }
    }

    private av a(BookFormat bookFormat, g gVar, String str, String str2) {
        if (bookFormat == BookFormat.EPUB) {
            return s.a(gVar.b(), gVar.c(), gVar.d(), str, gVar.a(), gVar.e(), str2);
        } else if (bookFormat == BookFormat.TXT) {
            return p.b(gVar.d());
        } else {
            if (bookFormat == BookFormat.PDF) {
                return d.a(gVar.b() - 1, gVar.c(), gVar.d());
            }
            if (bookFormat == BookFormat.SBK) {
                return com.duokan.reader.domain.document.sbk.f.a(gVar.b(), gVar.c(), gVar.d());
            }
            if (C) {
                return null;
            }
            throw new AssertionError();
        }
    }

    private void a(c cVar, u uVar, boolean z) {
        if (cVar.q() != BookFormat.EPUB || cVar.s() == BookPackageType.EPUB_OPF || cVar.Q()) {
            uVar.c();
            return;
        }
        int ao = cVar.ao();
        if (ao == 0 || ao == 2) {
            v vVar;
            if (z) {
                for (int size = this.K.size() - 1; size >= 0; size--) {
                    vVar = (v) this.K.get(size);
                    if (vVar.a.aF() == cVar.aF()) {
                        break;
                    }
                }
            }
            vVar = null;
            if (vVar == null) {
                vVar = new v(this, cVar);
                this.K.add(vVar);
            }
            vVar.b.add(uVar);
            c(vVar.a);
            return;
        }
        uVar.c();
    }

    private void c(c cVar) {
        if (!this.L.contains(Long.valueOf(cVar.aF()))) {
            v vVar;
            Iterator it = this.K.iterator();
            while (it.hasNext()) {
                vVar = (v) it.next();
                if (vVar.a.aF() == cVar.aF()) {
                    break;
                }
            }
            vVar = null;
            if (vVar != null) {
                this.L.add(Long.valueOf(cVar.aF()));
                a(vVar, new m(this, vVar, cVar));
            }
        }
    }

    private void a(v vVar, u uVar) {
        c cVar = vVar.a;
        a[] aq = cVar.aq();
        a[] aVarArr = new a[aq.length];
        for (int i = 0; i < aq.length; i++) {
            aVarArr[i] = aq[i].l();
        }
        com.duokan.common.a.a(new n(this, cVar, aVarArr, uVar), new Void[0]);
    }

    private void a(c cVar, a[] aVarArr, u uVar) {
        List arrayList = new ArrayList(aVarArr.length);
        HashMap hashMap = new HashMap();
        for (a aVar : aVarArr) {
            x xVar = new x(ai.a((com.duokan.reader.domain.document.epub.c) aVar.d(), (com.duokan.reader.domain.document.epub.c) aVar.e()), aVar.f());
            arrayList.add(xVar);
            hashMap.put(xVar, aVar);
        }
        aq a = ai.a(cVar.f(), (ap) cVar.b());
        try {
            DkeBook dkeBook = a.b;
            if (dkeBook == null) {
                uVar.b();
            } else if (ai.a(dkeBook, arrayList)) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    x xVar2 = (x) it.next();
                    a aVar2 = (a) hashMap.get(xVar2);
                    aVar2.a(((ce) xVar2.a()).j());
                    aVar2.b(((ce) xVar2.a()).k());
                    aVar2.a(xVar2.b());
                }
                uVar.a();
            } else {
                uVar.c();
            }
            ai.a(a);
        } catch (Throwable th) {
            ai.a(a);
        }
    }

    protected final void aB() {
        if (this.d == BookState.PULLING || this.d == BookState.UPDATING) {
            if ((o() == BookType.SERIAL || !this.x.a()) && !this.x.b(211)) {
                ac acVar = new ac(this.x);
                if (acVar.b(2048)) {
                    acVar.c(32);
                } else if (acVar.b(1024)) {
                    if (f.b().d()) {
                        acVar.c(32);
                    } else {
                        acVar.d(32);
                    }
                } else if (!ReaderEnv.get().getIsOnlyWifiUploadDownload()) {
                    acVar.c(32);
                } else if (f.b().d()) {
                    acVar.c(32);
                } else {
                    acVar.d(32);
                }
                if (acVar.e != this.x.e) {
                    this.x = acVar;
                    b(64);
                    aL();
                }
            }
            aC();
        }
    }

    protected final void aC() {
        a(new ac(this.x));
    }

    protected void a(ac acVar) {
        t.a(new s(this, acVar));
    }

    protected FutureTask aD() {
        return null;
    }

    protected final void a(String str, String str2) {
        File file = new File(str);
        String name = file.getName();
        if (!am() || !name.equals(ak().b())) {
            return;
        }
        if (this.d != BookState.NORMAL || !R()) {
            ab();
            e(str2);
            a(Uri.fromFile(file).toString());
            x();
            this.d = BookState.NORMAL;
            b(10);
            aL();
        }
    }

    protected final void aE() {
        if (ao() != -1) {
            ab();
            this.d = BookState.CLOUD_ONLY;
            b(8);
            aL();
        }
    }

    private final void aU() {
        aS().b();
        try {
            aS().a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"typesetting", "book_id", "" + aF()}));
            aS().a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"toc", "book_id", "" + aF()}));
            aS().f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            aS().c();
        }
    }

    protected static final BookType p(String str) {
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

    protected static final BookLimitType b(String str, String str2) {
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

    protected static final BookFormat q(String str) {
        try {
            return TextUtils.isEmpty(str) ? BookFormat.TXT : BookFormat.valueOf(str);
        } catch (Exception e) {
            return BookFormat.UNKNOWN;
        }
    }

    private static final BookContent r(String str) {
        try {
            return TextUtils.isEmpty(str) ? BookContent.NORMAL : BookContent.valueOf(str);
        } catch (Throwable th) {
            return BookContent.NORMAL;
        }
    }

    private static final BookState s(String str) {
        try {
            return TextUtils.isEmpty(str) ? BookState.NORMAL : BookState.valueOf(str);
        } catch (Exception e) {
            return BookState.NORMAL;
        }
    }

    private static BookPackageType a(String str, BookFormat bookFormat, BookType bookType) {
        try {
            if (TextUtils.isEmpty(str)) {
                switch (f.c[bookFormat.ordinal()]) {
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

    private z aV() {
        try {
            aT().a(aF());
            aO();
            if (this.z == null) {
                this.z = new z(aT(), aF(), q());
            }
            z zVar = this.z;
            return zVar;
        } finally {
            aT().b(aF());
        }
    }

    private void aW() {
        t.a(new TaskHandler(this));
    }
}
