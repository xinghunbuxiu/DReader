package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.p026a.C0293u;
import com.duokan.core.sys.C0352r;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ag;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.Column;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.CommonColumn;
import com.duokan.reader.domain.store.DkStoreFiction;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
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
import org.json.JSONObject;

public abstract class ee extends C0800c {
    /* renamed from: E */
    protected static final Semaphore f3084E = new Semaphore(5);
    /* renamed from: J */
    static final /* synthetic */ boolean f3085J = (!ee.class.desiredAssertionStatus());
    /* renamed from: K */
    private static final HashMap<String, ev> f3086K = new HashMap();
    /* renamed from: F */
    protected final ConcurrentLinkedQueue<FutureTask<Void>> f3087F = new ConcurrentLinkedQueue();
    /* renamed from: G */
    protected String[] f3088G = null;
    /* renamed from: H */
    protected short[] f3089H = null;
    /* renamed from: I */
    protected String[] f3090I = null;
    /* renamed from: L */
    private DkStoreFictionDetail f3091L = null;
    /* renamed from: M */
    private ez f3092M = null;
    /* renamed from: N */
    private la f3093N = null;
    /* renamed from: O */
    private int f3094O = 0;
    /* renamed from: P */
    private final ap<ad, String> f3095P = new ap();

    /* renamed from: a */
    protected abstract Future<Integer> mo1027a(String str, long j, String str2, Map<String, String> map, ag<Integer> agVar);

    /* renamed from: a */
    public abstract void mo1028a(List<String> list, ag<Map<String, Integer>> agVar);

    /* renamed from: a */
    public abstract void mo1029a(List<String> list, boolean z, ag<Map<String, Integer>> agVar);

    /* renamed from: b */
    public abstract void mo1034b(List<String> list);

    protected abstract void bk();

    /* renamed from: u */
    public abstract String mo1040u(String str);

    /* renamed from: v */
    public abstract boolean mo1041v(String str);

    /* renamed from: w */
    public abstract List<String> mo1042w(String str);

    /* renamed from: x */
    public abstract boolean mo1043x(String str);

    protected ee(am amVar, long j, BookPackageType bookPackageType, BookType bookType, BookState bookState, boolean z, boolean z2) {
        super(amVar, j, bookPackageType, bookType, bookState, z, z2);
    }

    protected ee(am amVar, Cursor cursor) {
        super(amVar, cursor);
        this.f3094O = C0293u.m690a(cursor, CommonColumn.SERIAL_UPDATES.ordinal(), 0);
        this.f3095P.m4012c(C0293u.m692a(cursor, CommonColumn.DRM.ordinal(), null));
    }

    /* renamed from: a */
    public final void m4405a(im imVar) {
        aV().mo1095a((C0800c) this, new ef(this, imVar));
    }

    public final DkStoreFictionDetail aW() {
        return this.f3091L;
    }

    /* renamed from: a */
    public final void m4406a(DkStoreFictionDetail dkStoreFictionDetail) {
        this.f3091L = dkStoreFictionDetail;
    }

    public static final boolean aX() {
        return ev.f3130j;
    }

    /* renamed from: d */
    public static final void m4397d(boolean z) {
        ev.f3130j = z;
    }

    /* renamed from: z */
    public final ad mo1020z() {
        ap apVar = this.f3095P;
        if (apVar.m4013d()) {
            try {
                aV().mo1091a(aH());
                ad adVar;
                if (apVar.m861b()) {
                    adVar = (ad) apVar.m858a();
                    return adVar;
                }
                apVar.mo975a(new ad((String) apVar.m4014e()));
                adVar = (ad) apVar.m858a();
                return adVar;
            } catch (Throwable th) {
                WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs", th);
                apVar.m4012c(null);
            } finally {
                apVar = aV();
                apVar.mo1097b(aH());
            }
        }
        if (apVar.m861b()) {
            return (ad) apVar.m858a();
        }
        return ad.f2722a;
    }

    /* renamed from: a */
    public void mo1011a(ad adVar) {
        try {
            aV().mo1091a(aH());
            aQ();
            if (!(mo1020z().m3781b() && adVar.m3781b())) {
                this.f3095P.mo975a(adVar);
                m3744b(128);
            }
            aV().mo1097b(aH());
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    public final boolean aY() {
        if (!this.f3095P.m4013d() && this.f3095P.m858a() == null) {
            return false;
        }
        return true;
    }

    public final boolean aZ() {
        boolean z = true;
        if (!aY() || mo1020z().m3781b()) {
            return false;
        }
        if (!m4166S()) {
            return true;
        }
        if (System.currentTimeMillis() > ba() || (m4153F() != 0 && System.currentTimeMillis() < m4153F() - 300000)) {
            z = false;
        }
        return z;
    }

    public final long ba() {
        if (m4166S()) {
            return mo1020z().f2726e;
        }
        return Long.MAX_VALUE;
    }

    /* renamed from: s */
    public final int mo1016s(String str) {
        long j = 1;
        int i = 0;
        try {
            aV().mo1091a(aH());
            String[] bm = bm();
            int length = bm.length / 2;
            if (length < j) {
                return -1;
            }
            try {
                i = Math.max(0, Math.min(Integer.parseInt(str) - Integer.parseInt(bm[0]), length));
            } catch (Throwable th) {
            }
            if (i >= 0 && i < length && TextUtils.equals(bm[i * 2], str)) {
                return i;
            }
            int max = Math.max(i, (length - 1) - i);
            for (int i2 = j; i2 <= max; i2++) {
                int i3 = i + i2;
                if (i3 >= 0 && i3 < length && TextUtils.equals(bm[i3 * 2], str)) {
                    return i3;
                }
                i3 = i - i2;
                if (i3 >= 0 && i3 < length && TextUtils.equals(bm[i3 * 2], str)) {
                    return i3;
                }
            }
            return -1;
        } finally {
            i = aV();
            j = aH();
            i.mo1097b(j);
        }
    }

    public final int bb() {
        try {
            aV().mo1091a(aH());
            int length = bm().length / 2;
            return length;
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: t */
    public final String mo1017t(String str) {
        try {
            aV().mo1091a(aH());
            int s = mo1016s(str);
            String[] bo = bo();
            String str2;
            if (s < 0 || s >= bo.length) {
                str2 = "";
                return str2;
            }
            str2 = bo[s];
            aV().mo1097b(aH());
            return str2;
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: j */
    public final short m4421j(long j) {
        try {
            aV().mo1091a(aH());
            short[] bn = bn();
            if (j < 0 || j >= ((long) bn.length)) {
                aV().mo1097b(aH());
                return (short) 0;
            }
            short s = bn[(int) j];
            aV().mo1097b(aH());
            return s;
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    public final int bc() {
        return this.f3094O;
    }

    public final void bd() {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f3094O = 0;
            m3744b(8192);
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final la be() {
        try {
            aV().mo1091a(aH());
            aQ();
            la laVar = this.f3093N;
            return laVar;
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final float bf() {
        return be().f3507a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: u */
    public final boolean mo1018u() {
        /*
        r4 = this;
        r0 = r4.aV();	 Catch:{ all -> 0x0049 }
        r2 = r4.aH();	 Catch:{ all -> 0x0049 }
        r0.mo1091a(r2);	 Catch:{ all -> 0x0049 }
        r4.aQ();	 Catch:{ all -> 0x0049 }
        r0 = com.duokan.reader.domain.bookshelf.eu.f3129a;	 Catch:{ all -> 0x0049 }
        r1 = r4.m4242o();	 Catch:{ all -> 0x0049 }
        r1 = r1.ordinal();	 Catch:{ all -> 0x0049 }
        r0 = r0[r1];	 Catch:{ all -> 0x0049 }
        switch(r0) {
            case 1: goto L_0x002a;
            case 2: goto L_0x002a;
            default: goto L_0x001d;
        };
    L_0x001d:
        r0 = 0;
        r1 = r4.aV();
        r2 = r4.aH();
        r1.mo1097b(r2);
    L_0x0029:
        return r0;
    L_0x002a:
        r0 = r4.m4242o();	 Catch:{ all -> 0x0049 }
        r1 = com.duokan.reader.domain.bookshelf.BookType.SERIAL;	 Catch:{ all -> 0x0049 }
        if (r0 != r1) goto L_0x0042;
    L_0x0032:
        r0 = r4.f3093N;	 Catch:{ all -> 0x0049 }
        r0 = r0.f3508b;	 Catch:{ all -> 0x0049 }
    L_0x0036:
        r1 = r4.aV();
        r2 = r4.aH();
        r1.mo1097b(r2);
        goto L_0x0029;
    L_0x0042:
        r0 = r4.m4248t();	 Catch:{ all -> 0x0049 }
        r0 = r0.f2709g;	 Catch:{ all -> 0x0049 }
        goto L_0x0036;
    L_0x0049:
        r0 = move-exception;
        r1 = r4.aV();
        r2 = r4.aH();
        r1.mo1097b(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.ee.u():boolean");
    }

    /* renamed from: e */
    public final void m4420e(boolean z) {
        try {
            aV().mo1091a(aH());
            aQ();
            if (m4242o() == BookType.SERIAL) {
                this.f3093N.f3508b = z;
                m3744b(4096);
            } else {
                m4248t().f2709g = z;
            }
            aV().mo1097b(aH());
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    public final int bg() {
        try {
            aV().mo1091a(aH());
            aQ();
            if (!mo1018u()) {
                return -1;
            }
            int max = Math.max(m4242o() == BookType.SERIAL ? be().f3509c : m4248t().f2710h, 1);
            aV().mo1097b(aH());
            return max;
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: d */
    public final void m4419d(int i) {
        try {
            aV().mo1091a(aH());
            aQ();
            if (m4242o() == BookType.SERIAL) {
                this.f3093N.f3509c = i;
                m3744b(4096);
            } else {
                m4248t().f2710h = i;
            }
            aV().mo1097b(aH());
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: v */
    public boolean mo1019v() {
        try {
            aV().mo1091a(aH());
            aQ();
            boolean z = this.f3093N.f3519m;
            return z;
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: a */
    public boolean mo1012a(boolean z) {
        boolean z2 = true;
        try {
            aV().mo1091a(aH());
            aQ();
            if (this.f3093N == null || this.f3093N.f3520n == null) {
                aV().mo1097b(aH());
                return false;
            } else if (z) {
                boolean z3 = TextUtils.equals((CharSequence) this.f3093N.f3520n.first, ((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)).mo832b()) && ((Boolean) this.f3093N.f3520n.second).booleanValue();
                aV().mo1097b(aH());
                return z3;
            } else {
                if (!TextUtils.equals((CharSequence) this.f3093N.f3520n.first, ((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)).mo832b()) || ((Boolean) this.f3093N.f3520n.second).booleanValue()) {
                    z2 = false;
                }
                aV().mo1097b(aH());
                return z2;
            }
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: a */
    public final void mo1009a(af<Boolean> afVar) {
        try {
            aV().mo1091a(aH());
            aQ();
            if (this.f3093N != null) {
                if (m4242o() == BookType.SERIAL) {
                    if (afVar.m861b()) {
                        this.f3093N.f3520n = new Pair(((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)).mo832b(), afVar.m858a());
                    } else {
                        this.f3093N.f3520n = null;
                    }
                    m3744b(4096);
                }
                aV().mo1097b(aH());
            }
        } finally {
            aV().mo1097b(aH());
        }
    }

    public final String bh() {
        return be().f3517k;
    }

    public final int bi() {
        return be().f3518l;
    }

    /* renamed from: b */
    public final boolean m4417b(DkStoreFictionDetail dkStoreFictionDetail) {
        return (bl() == dkStoreFictionDetail.getFiction().getUpdateDate().getTime() && m4159L() == dkStoreFictionDetail.getFiction().getCent() && Float.compare(bf(), dkStoreFictionDetail.getFiction().getSpecialPrice()) == 0 && mo1018u() == dkStoreFictionDetail.getFiction().getHasAds() && (!dkStoreFictionDetail.hasToc() || bb() == dkStoreFictionDetail.getToc().length)) ? false : true;
    }

    /* renamed from: a */
    public final void m4410a(boolean z, ag<DkStoreFictionDetail> agVar, Runnable runnable) {
        Runnable egVar = new eg(this, agVar, runnable);
        if (z) {
            egVar.run();
            return;
        }
        aV().mo1102e().m8704a(getId(), true, true, -1, -1, -1, new ek(this, egVar, agVar, runnable));
    }

    /* renamed from: c */
    public final void m4418c(DkStoreFictionDetail dkStoreFictionDetail) {
        try {
            aV().mo1091a(aH());
            aQ();
            if (dkStoreFictionDetail == null) {
                m4411a(new String[0]);
                mo1035b(new String[0]);
                m4412a(new short[0]);
                this.u = 0;
                this.f3093N = new la();
                m3744b(4112);
            } else {
                int i;
                int i2;
                DkCloudFictionChapter[] toc = dkStoreFictionDetail.getToc();
                DkStoreFiction fiction = dkStoreFictionDetail.getFiction();
                if (!fiction.isOnSale() && DkUserPurchasedFictionsManager.m5072a().m5093a(fiction.getBookUuid()) == null) {
                    LinkedList linkedList = new LinkedList();
                    for (DkCloudFictionChapter dkCloudFictionChapter : toc) {
                        if (dkCloudFictionChapter.isFree()) {
                            linkedList.add(dkCloudFictionChapter);
                        } else if (mo1041v(dkCloudFictionChapter.getCloudId())) {
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
                String[] bm = bm();
                if (bm.length == 0) {
                    m4411a(strArr);
                    i = 0;
                } else if (bm.length != strArr.length) {
                    if (aI() || bm.length <= 0) {
                        i2 = 0;
                    } else {
                        i2 = Math.max(0, (strArr.length - bm.length) / 2);
                    }
                    m4411a(strArr);
                    i = i2;
                } else {
                    for (i2 = 0; i2 < bm.length; i2++) {
                        if (!TextUtils.equals(bm[i2], strArr[i2])) {
                            m4411a(strArr);
                            i = 0;
                            break;
                        }
                    }
                    i = 0;
                }
                strArr = bo();
                if (strArr.length == 0) {
                    mo1035b(strArr2);
                } else if (strArr.length != strArr2.length) {
                    mo1035b(strArr2);
                } else {
                    for (i2 = 0; i2 < strArr.length; i2++) {
                        if (!TextUtils.equals(strArr[i2], strArr2[i2])) {
                            mo1035b(strArr2);
                            break;
                        }
                    }
                }
                short[] bn = bn();
                if (bn.length == 0) {
                    m4412a(sArr);
                } else if (bn.length != sArr.length) {
                    m4412a(sArr);
                } else {
                    for (i2 = 0; i2 < bn.length; i2++) {
                        if (bn[i2] != sArr[i2]) {
                            m4412a(sArr);
                            break;
                        }
                    }
                }
                i2 = dkStoreFictionDetail.getFiction().getCent();
                if (this.u != i2) {
                    this.u = i2;
                    m3744b(16);
                }
                la laVar = this.f3093N;
                this.f3093N = new la(dkStoreFictionDetail);
                if (laVar != null) {
                    this.f3094O += i;
                    this.f3093N.f3520n = laVar.f3520n;
                } else {
                    this.f3094O = i;
                }
                m3744b(12288);
            }
            aV().mo1097b(aH());
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    protected String[] bj() {
        String[] bm;
        if (m4242o() == BookType.SERIAL) {
            try {
                aV().mo1091a(aH());
                bm = bm();
                if (bm.length <= 0) {
                    if (m4251w()) {
                        try {
                            m4418c(new DkStoreFictionDetail(C0647u.m3013b(new JSONObject(DkPublic.readFile(new File(new File(new File(ReaderEnv.get().getExternalFilesDirectory(), "/Downloads/BookInfos"), getId()), "complete.json"))).getJSONObject("item"))));
                            aV().mo1091a(aH());
                            bm = bm();
                            aV().mo1097b(aH());
                        } catch (Throwable th) {
                        }
                    }
                    Semaphore semaphore = new Semaphore(0);
                    UThread.runOnThread(new en(this, semaphore));
                    semaphore.acquireUninterruptibly();
                }
                return bm;
            } finally {
                aV().mo1097b(aH());
            }
        }
        try {
            aV().mo1091a(aH());
            bm = bm();
            return bm;
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: a */
    protected void mo951a(Cursor cursor) {
        super.mo951a(cursor);
        if (this.e == BookType.SERIAL) {
            this.f3093N = new la(C0293u.m695c(cursor, Column.SERIAL_DETAIL.ordinal()));
        }
    }

    /* renamed from: a */
    protected void mo950a(ContentValues contentValues) {
        super.mo950a(contentValues);
        if (m3747c(4096) && this.f3093N != null) {
            contentValues.put(Column.SERIAL_DETAIL.toString(), this.f3093N.toString());
        }
        if (m3747c(8192)) {
            contentValues.put(Column.SERIAL_UPDATES.toString(), Integer.valueOf(this.f3094O));
        }
        if (m3747c(128)) {
            ad adVar = (ad) this.f3095P.m858a();
            if (adVar != null) {
                try {
                    contentValues.put(Column.DRM.toString(), adVar.m3781b() ? "" : adVar.m3782c().toString());
                } catch (Throwable e) {
                    WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs!", e);
                }
            }
        }
    }

    protected FutureTask<?> aF() {
        return (FutureTask) this.f3087F.poll();
    }

    /* renamed from: a */
    protected void mo1010a(ac acVar) {
        if (this.e == BookType.SERIAL) {
            try {
                aV().mo1091a(aH());
                aQ();
                if (acVar.m3775a() || acVar.m3777b(128)) {
                    if (this.f3092M != null) {
                        this.f3092M.cancel(true);
                        this.f3092M = null;
                    }
                } else if (!acVar.m3776a(3)) {
                    if (!acVar.m3777b(112)) {
                        if (this.f3092M == null || this.f3092M.isDone()) {
                            this.f3092M = new ez(this, acVar);
                        }
                        this.f3087F.add(this.f3092M);
                    } else if (this.f3092M != null) {
                        this.f3092M.cancel(true);
                        this.f3092M = null;
                    }
                }
                aV().mo1097b(aH());
                aV().mo1094a((C0800c) this, System.currentTimeMillis());
            } catch (Throwable th) {
                aV().mo1097b(aH());
            }
        } else {
            super.mo1010a(acVar);
        }
    }

    /* renamed from: b */
    protected final void m4415b(List<String> list, boolean z, ag<Map<String, ex>> agVar) {
        String I = getId();
        Map hashMap = new HashMap();
        DkStoreFictionDetail aW = aW();
        if (aW != null) {
            for (String str : list) {
                DkCloudFictionChapter findChapter = aW.findChapter(str);
                if (findChapter == null || TextUtils.isEmpty(findChapter.getUrl())) {
                    hashMap.clear();
                    break;
                }
                ex exVar = new ex();
                exVar.f3144c = findChapter.getUrl();
                exVar.f3145d = findChapter.getSha1();
                hashMap.put(str, exVar);
            }
            if (!hashMap.isEmpty()) {
                UThread.post(new eq(this, agVar, hashMap));
                return;
            }
        }
        UThread.runOnThread(new er(this, z, I, list, hashMap, agVar));
    }

    /* renamed from: a */
    protected Future<Integer> m4399a(String str, C0352r c0352r, long j, String str2, Map<String, String> map, ag<Integer> agVar) {
        Object obj;
        WebLog.init().m762a(UThread.isCurrentThread());
        String format = String.format("%s;%s", new Object[]{str, c0352r});
        synchronized (f3086K) {
            ev evVar;
            ev evVar2 = (ev) f3086K.get(format);
            if (evVar2 == null) {
                evVar = new ev(str, c0352r, j, str2, map);
                f3086K.put(format, evVar);
                obj = 1;
            } else {
                evVar = evVar2;
                obj = null;
            }
            if (agVar != null) {
                if (evVar != null) {
                    evVar.f3137f.add(agVar);
                } else if (evVar != null) {
                    evVar.f3137f.add(agVar);
                }
            }
        }
        if (obj == null) {
            return evVar.f3138g;
        }
        try {
            evVar.f3138g.run();
            synchronized (f3086K) {
                f3086K.remove(format);
            }
            if (!evVar.f3137f.isEmpty()) {
                UThread.runOnThread(new et(this, evVar));
            }
        } catch (Throwable th) {
            synchronized (f3086K) {
                f3086K.remove(format);
                if (!evVar.f3137f.isEmpty()) {
                    UThread.runOnThread(new et(this, evVar));
                }
            }
        }
        return evVar.f3138g;
    }

    /* renamed from: a */
    protected final void m4407a(DkStoreFictionDetail dkStoreFictionDetail, BookLimitType bookLimitType) {
        am aV = aV();
        try {
            aV.mo1091a(aH());
            if (f3085J || dkStoreFictionDetail != null) {
                File file = new File(aV.mo1101d(), dkStoreFictionDetail.getFiction().getBookUuid());
                m4224e(dkStoreFictionDetail.getFiction().getBookUuid());
                m4196a(Uri.fromFile(file).toString());
                m4183a(bookLimitType);
                m4212b(dkStoreFictionDetail.getFiction().getCoverUri());
                mo955p(dkStoreFictionDetail.getFiction().getTitle());
                m4221d(dkStoreFictionDetail.getFiction().getAuthorLine());
                m4176a(System.currentTimeMillis());
                BookContent bookContent = C0800c.m4143o(getId()) ? dkStoreFictionDetail.getFiction().isVerticalComic() ? BookContent.VERTICAL_COMIC : BookContent.PAGE_COMIC : BookContent.NORMAL;
                m4182a(bookContent);
                m4175a(dkStoreFictionDetail.getFiction().isFree() ? 0 : dkStoreFictionDetail.getFiction().getPrice());
                m4418c(dkStoreFictionDetail);
                this.x.f2717a = "";
                this.x.f2718b = "";
                this.x.f2719c = "";
                this.x.f2720d = "";
                this.x.m3779d(1088);
                m3744b(72);
                aN();
                return;
            }
            throw new AssertionError();
        } finally {
            aV.mo1097b(aH());
        }
    }

    protected final long bl() {
        try {
            aV().mo1091a(aH());
            aQ();
            long j = be().f3510d;
            return j;
        } finally {
            aV().mo1097b(aH());
        }
    }

    protected final String[] bm() {
        WebLog.init().w(this.D.mo1099c(aH()));
        if (this.f3088G != null) {
            return this.f3088G;
        }
        this.f3088G = new String[0];
        if (this.e == BookType.SERIAL) {
            Cursor a = aT().m670a(String.format("SELECT %1$s FROM %2$s WHERE _id IS '%3$s'", new Object[]{Column.SERIAL_CHAPTERS, "books", Long.valueOf(aH())}), null);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        this.f3088G = (String[]) new ObjectInputStream(new ByteArrayInputStream(a.getBlob(0))).readObject();
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
        return this.f3088G;
    }

    /* renamed from: a */
    protected void m4411a(String[] strArr) {
        this.f3088G = strArr;
        m3744b(2048);
    }

    protected short[] bn() {
        WebLog.init().w(this.D.mo1099c(aH()));
        if (this.f3089H != null) {
            return this.f3089H;
        }
        this.f3089H = new short[0];
        if (this.e == BookType.SERIAL) {
            Cursor a = aT().m670a(String.format("SELECT %1$s FROM %2$s WHERE _id IS '%3$s'", new Object[]{Column.SERIAL_PRICES, "books", Long.valueOf(aH())}), null);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        this.f3089H = (short[]) new ObjectInputStream(new ByteArrayInputStream(a.getBlob(0))).readObject();
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
        return this.f3089H;
    }

    /* renamed from: a */
    protected void m4412a(short[] sArr) {
        this.f3089H = sArr;
        m3744b(2048);
    }

    protected String[] bo() {
        WebLog.init().w(this.D.mo1099c(aH()));
        if (this.f3090I != null) {
            return this.f3090I;
        }
        this.f3090I = new String[0];
        if (this.e == BookType.SERIAL) {
            Cursor a = aT().m670a(String.format("SELECT %1$s FROM %2$s WHERE _id IS '%3$s'", new Object[]{Column.SERIAL_SHA1S, "books", Long.valueOf(aH())}), null);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        this.f3090I = (String[]) new ObjectInputStream(new ByteArrayInputStream(a.getBlob(0))).readObject();
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
        return this.f3090I;
    }

    /* renamed from: b */
    protected void mo1035b(String[] strArr) {
        this.f3090I = strArr;
        m3744b(2048);
    }
}
