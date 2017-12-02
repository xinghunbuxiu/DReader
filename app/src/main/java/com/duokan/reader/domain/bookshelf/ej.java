package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;

import com.duokan.core.a.u;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ag;
import com.duokan.core.sys.r;
import com.duokan.core.sys.t;
import com.duokan.reader.DkPublic;
import com.duokan.reader.MiuiAssistContent;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.Column;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.CommonColumn;
import com.duokan.reader.domain.store.DkStoreFiction;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.google.android.collect.Lists;

import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

public abstract class ej extends c {
    protected static final Semaphore E = new Semaphore(5);
    static final /* synthetic */ boolean J = (!ej.class.desiredAssertionStatus());
    private static final HashMap K = new HashMap();
    protected final ConcurrentLinkedQueue F = new ConcurrentLinkedQueue();
    protected String[] G = null;
    protected short[] H = null;
    protected String[] I = null;
    private DkStoreFictionDetail L = null;
    private ff M = null;
    private ko N = null;
    private int O = 0;
    private final ao P = new ao();

    protected abstract Future a(String str, long j, String str2, Map map, ag agVar);

    public abstract void a(List list, ag agVar);

    public abstract void a(List list, boolean z, ag agVar);

    public abstract void b(List list);

    protected abstract void bi();

    public abstract String t(String str);

    public abstract boolean u(String str);

    public abstract List v(String str);

    public abstract boolean w(String str);

    protected ej(am amVar, long j, BookPackageType bookPackageType, BookType bookType, BookState bookState, boolean z, boolean z2) {
        super(amVar, j, bookPackageType, bookType, bookState, z, z2);
    }

    protected ej(am amVar, Cursor cursor) {
        super(amVar, cursor);
        this.O = u.a(cursor, CommonColumn.SERIAL_UPDATES.ordinal(), 0);
        this.P.c(u.a(cursor, CommonColumn.DRM.ordinal(), null));
    }

    public final void a(is isVar) {
        aT().a((c) this, new ek(this, isVar));
    }

    public final DkStoreFictionDetail aU() {
        return this.L;
    }

    public final void a(DkStoreFictionDetail dkStoreFictionDetail) {
        this.L = dkStoreFictionDetail;
    }

    public static final boolean aV() {
        return fb.j;
    }

    public static final void c(boolean z) {
        fb.j = z;
    }

    public final ad y() {
        ao aoVar = this.P;
        if (aoVar.d()) {
            try {
                aT().a(aF());
                ad adVar;
                if (aoVar.b()) {
                    adVar = (ad) aoVar.a();
                    return adVar;
                }
                aoVar.a(new ad((String) aoVar.e()));
                adVar = (ad) aoVar.a();
                return adVar;
            } catch (Throwable th) {
                a.c().a(LogLevel.ERROR, "shelf", "an exception occurs", th);
                aoVar.c(null);
            } finally {
                aoVar = aT();
                aoVar.b(aF());
            }
        }
        if (aoVar.b()) {
            return (ad) aoVar.a();
        }
        return ad.a;
    }

    public void a(ad adVar) {
        try {
            aT().a(aF());
            aO();
            if (!(y().b() && adVar.b())) {
                this.P.a(adVar);
                b(128);
            }
            aT().b(aF());
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final boolean aW() {
        if (!this.P.d() && this.P.a() == null) {
            return false;
        }
        return true;
    }

    public final boolean aX() {
        boolean z = true;
        if (!aW() || y().b()) {
            return false;
        }
        if (!Q()) {
            return true;
        }
        if (System.currentTimeMillis() > aY() || (E() != 0 && System.currentTimeMillis() < E() - 300000)) {
            z = false;
        }
        return z;
    }

    public final long aY() {
        if (Q()) {
            return y().e;
        }
        return Long.MAX_VALUE;
    }

    public final int r(String str) {
        long j = 1;
        int i = 0;
        try {
            aT().a(aF());
            String[] bk = bk();
            int length = bk.length / 2;
            if (length < j) {
                return -1;
            }
            try {
                i = Math.max(0, Math.min(Integer.parseInt(str) - Integer.parseInt(bk[0]), length));
            } catch (Throwable th) {
            }
            if (i >= 0 && i < length && TextUtils.equals(bk[i * 2], str)) {
                return i;
            }
            int max = Math.max(i, (length - 1) - i);
            for (int i2 = j; i2 <= max; i2++) {
                int i3 = i + i2;
                if (i3 >= 0 && i3 < length && TextUtils.equals(bk[i3 * 2], str)) {
                    return i3;
                }
                i3 = i - i2;
                if (i3 >= 0 && i3 < length && TextUtils.equals(bk[i3 * 2], str)) {
                    return i3;
                }
            }
            return -1;
        } finally {
            i = aT();
            j = aF();
            i.b(j);
        }
    }

    public final int aZ() {
        try {
            aT().a(aF());
            int length = bk().length / 2;
            return length;
        } finally {
            aT().b(aF());
        }
    }

    public final String s(String str) {
        try {
            aT().a(aF());
            int r = r(str);
            String[] bm = bm();
            String str2;
            if (r < 0 || r >= bm.length) {
                str2 = "";
                return str2;
            }
            str2 = bm[r];
            aT().b(aF());
            return str2;
        } finally {
            aT().b(aF());
        }
    }

    public final short j(long j) {
        try {
            aT().a(aF());
            short[] bl = bl();
            if (j < 0 || j >= ((long) bl.length)) {
                aT().b(aF());
                return (short) 0;
            }
            short s = bl[(int) j];
            aT().b(aF());
            return s;
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final int ba() {
        return this.O;
    }

    public final void bb() {
        try {
            aT().a(aF());
            aO();
            this.O = 0;
            b(8192);
        } finally {
            aT().b(aF());
        }
    }

    public final ko bc() {
        try {
            aT().a(aF());
            aO();
            ko koVar = this.N;
            return koVar;
        } finally {
            aT().b(aF());
        }
    }

    public final float bd() {
        return bc().a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean u() {
        /*
        r4 = this;
        r0 = r4.aT();	 Catch:{ all -> 0x0049 }
        r2 = r4.aF();	 Catch:{ all -> 0x0049 }
        r0.a(r2);	 Catch:{ all -> 0x0049 }
        r4.aO();	 Catch:{ all -> 0x0049 }
        r0 = com.duokan.reader.domain.bookshelf.fa.a;	 Catch:{ all -> 0x0049 }
        r1 = r4.o();	 Catch:{ all -> 0x0049 }
        r1 = r1.ordinal();	 Catch:{ all -> 0x0049 }
        r0 = r0[r1];	 Catch:{ all -> 0x0049 }
        switch(r0) {
            case 1: goto L_0x002a;
            case 2: goto L_0x002a;
            default: goto L_0x001d;
        };
    L_0x001d:
        r0 = 0;
        r1 = r4.aT();
        r2 = r4.aF();
        r1.b(r2);
    L_0x0029:
        return r0;
    L_0x002a:
        r0 = r4.o();	 Catch:{ all -> 0x0049 }
        r1 = com.duokan.reader.domain.bookshelf.BookType.SERIAL;	 Catch:{ all -> 0x0049 }
        if (r0 != r1) goto L_0x0042;
    L_0x0032:
        r0 = r4.N;	 Catch:{ all -> 0x0049 }
        r0 = r0.b;	 Catch:{ all -> 0x0049 }
    L_0x0036:
        r1 = r4.aT();
        r2 = r4.aF();
        r1.b(r2);
        goto L_0x0029;
    L_0x0042:
        r0 = r4.t();	 Catch:{ all -> 0x0049 }
        r0 = r0.g;	 Catch:{ all -> 0x0049 }
        goto L_0x0036;
    L_0x0049:
        r0 = move-exception;
        r1 = r4.aT();
        r2 = r4.aF();
        r1.b(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.ej.u():boolean");
    }

    public final void d(boolean z) {
        try {
            aT().a(aF());
            aO();
            if (o() == BookType.SERIAL) {
                this.N.b = z;
                b(4096);
            } else {
                t().g = z;
            }
            aT().b(aF());
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final int be() {
        try {
            aT().a(aF());
            aO();
            if (!u()) {
                return -1;
            }
            int max = Math.max(o() == BookType.SERIAL ? bc().c : t().h, 1);
            aT().b(aF());
            return max;
        } finally {
            aT().b(aF());
        }
    }

    public final void d(int i) {
        try {
            aT().a(aF());
            aO();
            if (o() == BookType.SERIAL) {
                this.N.c = i;
                b(4096);
            } else {
                t().h = i;
            }
            aT().b(aF());
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public boolean v() {
        try {
            aT().a(aF());
            aO();
            boolean z = this.N.m;
            return z;
        } finally {
            aT().b(aF());
        }
    }

    public boolean a(boolean z) {
        boolean z2 = true;
        try {
            aT().a(aF());
            aO();
            if (this.N == null || this.N.n == null) {
                aT().b(aF());
                return false;
            } else if (z) {
                boolean z3 = TextUtils.equals((CharSequence) this.N.n.first, ((PersonalAccount) i.f().b(PersonalAccount.class)).b()) && ((Boolean) this.N.n.second).booleanValue();
                aT().b(aF());
                return z3;
            } else {
                if (!TextUtils.equals((CharSequence) this.N.n.first, ((PersonalAccount) i.f().b(PersonalAccount.class)).b()) || ((Boolean) this.N.n.second).booleanValue()) {
                    z2 = false;
                }
                aT().b(aF());
                return z2;
            }
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public final void a(af afVar) {
        try {
            aT().a(aF());
            aO();
            if (this.N != null) {
                if (o() == BookType.SERIAL) {
                    if (afVar.b()) {
                        this.N.n = new Pair(((PersonalAccount) i.f().b(PersonalAccount.class)).b(), afVar.a());
                    } else {
                        this.N.n = null;
                    }
                    b(4096);
                }
                aT().b(aF());
            }
        } finally {
            aT().b(aF());
        }
    }

    public final String bf() {
        return bc().k;
    }

    public final int bg() {
        return bc().l;
    }

    public final boolean b(DkStoreFictionDetail dkStoreFictionDetail) {
        return (bj() == dkStoreFictionDetail.getFiction().getUpdateDate().getTime() && Float.compare(bd(), dkStoreFictionDetail.getFiction().getSpecialPrice()) == 0 && u() == dkStoreFictionDetail.getFiction().getHasAds() && (!dkStoreFictionDetail.hasToc() || aZ() == dkStoreFictionDetail.getToc().length)) ? false : true;
    }

    public final void a(boolean z, ag agVar, Runnable runnable) {
        Runnable elVar = new el(this, agVar, runnable);
        if (z) {
            elVar.run();
            return;
        }
        aT().e().a(H(), true, true, -1, -1, -1, new ep(this, elVar, agVar, runnable));
    }

    public final void c(DkStoreFictionDetail dkStoreFictionDetail) {
        try {
            aT().a(aF());
            aO();
            if (dkStoreFictionDetail == null) {
                a(new String[0]);
                b(new String[0]);
                a(new short[0]);
                this.u = 0;
                this.N = new ko();
                b(4112);
            } else {
                int i;
                int i2;
                DkCloudFictionChapter[] toc = dkStoreFictionDetail.getToc();
                DkStoreFiction fiction = dkStoreFictionDetail.getFiction();
                if (!fiction.isOnSale() && DkUserPurchasedFictionsManager.a().a(fiction.getBookUuid()) == null) {
                    LinkedList linkedList = new LinkedList();
                    for (DkCloudFictionChapter dkCloudFictionChapter : toc) {
                        if (dkCloudFictionChapter.isFree()) {
                            linkedList.add(dkCloudFictionChapter);
                        } else if (u(dkCloudFictionChapter.getCloudId())) {
                            linkedList.add(dkCloudFictionChapter);
                        }
                    }
                    toc = (DkCloudFictionChapter[]) linkedList.toArray(new DkCloudFictionChapter[0]);
                    dkStoreFictionDetail.setToc(toc);
                }
                DkCloudFictionChapter[] dkCloudFictionChapterArr = toc;
                String[] strArr = new String[(dkCloudFictionChapterArr.length * 2)];
                String[] strArr2 = new String[dkCloudFictionChapterArr.length];
                short[] sArr = new short[dkCloudFictionChapterArr.length];
                for (i2 = 0; i2 < dkCloudFictionChapterArr.length; i2++) {
                    strArr[i2 * 2] = dkCloudFictionChapterArr[i2].getCloudId();
                    strArr[(i2 * 2) + 1] = dkCloudFictionChapterArr[i2].getTitle();
                    strArr2[i2] = dkCloudFictionChapterArr[i2].getSha1();
                    sArr[i2] = (short) dkCloudFictionChapterArr[i2].getPrice();
                }
                String[] bk = bk();
                if (bk.length == 0) {
                    a(strArr);
                    i = 0;
                } else if (bk.length != strArr.length) {
                    if (aG() || bk.length <= 0) {
                        i2 = 0;
                    } else {
                        i2 = Math.max(0, (strArr.length - bk.length) / 2);
                    }
                    a(strArr);
                    i = i2;
                } else {
                    for (i2 = 0; i2 < bk.length; i2++) {
                        if (!TextUtils.equals(bk[i2], strArr[i2])) {
                            a(strArr);
                            i = 0;
                            break;
                        }
                    }
                    i = 0;
                }
                strArr = bm();
                if (strArr.length == 0) {
                    b(strArr2);
                } else if (strArr.length != strArr2.length) {
                    b(strArr2);
                } else {
                    for (i2 = 0; i2 < strArr.length; i2++) {
                        if (!TextUtils.equals(strArr[i2], strArr2[i2])) {
                            b(strArr2);
                            break;
                        }
                    }
                }
                short[] bl = bl();
                if (bl.length == 0) {
                    a(sArr);
                } else if (bl.length != sArr.length) {
                    a(sArr);
                } else {
                    for (i2 = 0; i2 < bl.length; i2++) {
                        if (bl[i2] != sArr[i2]) {
                            a(sArr);
                            break;
                        }
                    }
                }
                i2 = dkStoreFictionDetail.getFiction().getCent();
                if (this.u != i2) {
                    this.u = i2;
                    b(16);
                }
                ko koVar = this.N;
                this.N = new ko(dkStoreFictionDetail);
                if (koVar != null) {
                    this.O += i;
                    this.N.n = koVar.n;
                } else {
                    this.O = i;
                }
                b(12288);
                js D = D();
                if (!(aG() || D == null || D.a())) {
                    MiuiAssistContent.insert(Lists.newArrayList(this));
                }
            }
            aT().b(aF());
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    protected String[] bh() {
        String[] bk;
        if (o() == BookType.SERIAL) {
            try {
                aT().a(aF());
                bk = bk();
                if (bk.length <= 0) {
                    if (w()) {
                        try {
                            c(new DkStoreFictionDetail(v.b(new JSONObject(DkPublic.readFile(new File(new File(new File(ReaderEnv.get().getExternalFilesDirectory(), "/Downloads/BookInfos"), H()), "complete.json"))).getJSONObject("item"))));
                            aT().a(aF());
                            bk = bk();
                            aT().b(aF());
                        } catch (Throwable th) {
                        }
                    }
                    Semaphore semaphore = new Semaphore(0);
                    t.a(new es(this, semaphore));
                    semaphore.acquireUninterruptibly();
                }
                return bk;
            } finally {
                aT().b(aF());
            }
        }
        try {
            aT().a(aF());
            bk = bk();
            return bk;
        } finally {
            aT().b(aF());
        }
    }

    protected void a(Cursor cursor) {
        super.a(cursor);
        if (this.e == BookType.SERIAL) {
            this.N = new ko(u.c(cursor, Column.SERIAL_DETAIL.ordinal()));
        }
    }

    protected void a(ContentValues contentValues) {
        super.a(contentValues);
        if (c(4096) && this.N != null) {
            contentValues.put(Column.SERIAL_DETAIL.toString(), this.N.toString());
        }
        if (c(8192)) {
            contentValues.put(Column.SERIAL_UPDATES.toString(), Integer.valueOf(this.O));
        }
        if (c(128)) {
            ad adVar = (ad) this.P.a();
            if (adVar != null) {
                try {
                    contentValues.put(Column.DRM.toString(), adVar.b() ? "" : adVar.c().toString());
                } catch (Throwable e) {
                    a.c().a(LogLevel.ERROR, "shelf", "an exception occurs!", e);
                }
            }
        }
    }

    protected FutureTask aD() {
        return (FutureTask) this.F.poll();
    }

    protected void a(ac acVar) {
        if (this.e == BookType.SERIAL) {
            try {
                aT().a(aF());
                aO();
                if (acVar.a() || acVar.b(128)) {
                    if (this.M != null) {
                        this.M.cancel(true);
                        this.M = null;
                    }
                } else if (!acVar.a(3)) {
                    if (!acVar.b(112)) {
                        if (this.M == null || this.M.isDone()) {
                            this.M = new ff(this, acVar);
                        }
                        this.F.add(this.M);
                    } else if (this.M != null) {
                        this.M.cancel(true);
                        this.M = null;
                    }
                }
                aT().b(aF());
                aT().a((c) this, System.currentTimeMillis());
            } catch (Throwable th) {
                aT().b(aF());
            }
        } else {
            super.a(acVar);
        }
    }

    protected final void b(List list, boolean z, ag agVar) {
        String H = H();
        Map hashMap = new HashMap();
        DkStoreFictionDetail aU = aU();
        if (aU != null) {
            for (String str : list) {
                DkCloudFictionChapter findChapter = aU.findChapter(str);
                if (findChapter == null || TextUtils.isEmpty(findChapter.getUrl())) {
                    hashMap.clear();
                    break;
                }
                fd fdVar = new fd();
                fdVar.c = findChapter.getUrl();
                fdVar.d = findChapter.getSha1();
                hashMap.put(str, fdVar);
            }
            if (!hashMap.isEmpty()) {
                t.b(new ev(this, agVar, hashMap));
                return;
            }
        }
        t.a(new ew(this, z, H, list, hashMap, agVar));
    }

    protected Future a(String str, r rVar, long j, String str2, Map map, ag agVar) {
        Object obj;
        a.c().a(t.a());
        String format = String.format("%s;%s", new Object[]{str, rVar});
        synchronized (K) {
            fb fbVar;
            fb fbVar2 = (fb) K.get(format);
            if (fbVar2 == null) {
                fbVar = new fb(str, rVar, j, str2, map);
                K.put(format, fbVar);
                obj = 1;
            } else {
                fbVar = fbVar2;
                obj = null;
            }
            if (agVar != null) {
                if (fbVar != null) {
                    fbVar.f.add(agVar);
                } else if (fbVar != null) {
                    fbVar.f.add(agVar);
                }
            }
        }
        if (obj == null) {
            return fbVar.g;
        }
        try {
            fbVar.g.run();
            synchronized (K) {
                K.remove(format);
            }
            if (!fbVar.f.isEmpty()) {
                t.a(new ez(this, fbVar));
            }
        } catch (Throwable th) {
            synchronized (K) {
                K.remove(format);
                if (!fbVar.f.isEmpty()) {
                    t.a(new ez(this, fbVar));
                }
            }
        }
        return fbVar.g;
    }

    protected final void a(DkStoreFictionDetail dkStoreFictionDetail, BookLimitType bookLimitType) {
        am aT = aT();
        try {
            aT.a(aF());
            if (J || dkStoreFictionDetail != null) {
                File file = new File(aT.d(), dkStoreFictionDetail.getFiction().getBookUuid());
                e(dkStoreFictionDetail.getFiction().getBookUuid());
                a(Uri.fromFile(file).toString());
                a(bookLimitType);
                b(dkStoreFictionDetail.getFiction().getCoverUri());
                o(dkStoreFictionDetail.getFiction().getTitle());
                d(dkStoreFictionDetail.getFiction().getAuthorLine());
                a(System.currentTimeMillis());
                BookContent bookContent = c.n(H()) ? dkStoreFictionDetail.getFiction().isVerticalComic() ? BookContent.VERTICAL_COMIC : BookContent.PAGE_COMIC : BookContent.NORMAL;
                a(bookContent);
                a(dkStoreFictionDetail.getFiction().isFree() ? 0 : dkStoreFictionDetail.getFiction().getPrice());
                c(dkStoreFictionDetail);
                this.x.a = "";
                this.x.b = "";
                this.x.c = "";
                this.x.d = "";
                this.x.d(1088);
                b(72);
                aL();
                return;
            }
            throw new AssertionError();
        } finally {
            aT.b(aF());
        }
    }

    protected final long bj() {
        try {
            aT().a(aF());
            aO();
            long j = bc().d;
            return j;
        } finally {
            aT().b(aF());
        }
    }

    protected final String[] bk() {
        a.c().b(this.D.c(aF()));
        if (this.G != null) {
            return this.G;
        }
        this.G = new String[0];
        if (this.e == BookType.SERIAL) {
            Cursor a = aR().a(String.format("SELECT %1$s FROM %2$s WHERE _id IS '%3$s'", new Object[]{Column.SERIAL_CHAPTERS, "books", Long.valueOf(aF())}), null);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        this.G = (String[]) new ObjectInputStream(new ByteArrayInputStream(a.getBlob(0))).readObject();
                    }
                } catch (Throwable th) {
                    if (a != null) {
                        a.close();
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        }
        return this.G;
    }

    protected void a(String[] strArr) {
        this.G = strArr;
        b(2048);
    }

    protected short[] bl() {
        a.c().b(this.D.c(aF()));
        if (this.H != null) {
            return this.H;
        }
        this.H = new short[0];
        if (this.e == BookType.SERIAL) {
            Cursor a = aR().a(String.format("SELECT %1$s FROM %2$s WHERE _id IS '%3$s'", new Object[]{Column.SERIAL_PRICES, "books", Long.valueOf(aF())}), null);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        this.H = (short[]) new ObjectInputStream(new ByteArrayInputStream(a.getBlob(0))).readObject();
                    }
                } catch (Throwable th) {
                    if (a != null) {
                        a.close();
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        }
        return this.H;
    }

    protected void a(short[] sArr) {
        this.H = sArr;
        b(2048);
    }

    protected String[] bm() {
        a.c().b(this.D.c(aF()));
        if (this.I != null) {
            return this.I;
        }
        this.I = new String[0];
        if (this.e == BookType.SERIAL) {
            Cursor a = aR().a(String.format("SELECT %1$s FROM %2$s WHERE _id IS '%3$s'", new Object[]{Column.SERIAL_SHA1S, "books", Long.valueOf(aF())}), null);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        this.I = (String[]) new ObjectInputStream(new ByteArrayInputStream(a.getBlob(0))).readObject();
                    }
                } catch (Throwable th) {
                    if (a != null) {
                        a.close();
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        }
        return this.I;
    }

    protected void b(String[] strArr) {
        this.I = strArr;
        b(2048);
    }
}
