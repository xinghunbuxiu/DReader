package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.b.h;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.b.a.b;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.a;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ag;
import com.duokan.core.sys.ah;
import com.duokan.core.sys.bb;
import com.duokan.core.sys.o;
import com.duokan.core.sys.r;
import com.duokan.core.sys.t;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.duokan.y;
import com.duokan.reader.common.webservices.duokan.z;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.document.epub.DkFeature;
import com.duokan.reader.domain.document.epub.al;
import com.duokan.reader.domain.document.epub.an;
import com.duokan.reader.domain.document.epub.ap;
import com.duokan.reader.domain.document.epub.av;
import com.duokan.reader.domain.document.epub.aw;
import com.duokan.reader.domain.document.epub.s;
import com.duokan.reader.domain.document.l;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.document.w;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.Column;
import com.duokan.reader.domain.store.DkStoreBookCategory;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreCategory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public class fv extends ej {
    static final /* synthetic */ boolean K = (!fv.class.desiredAssertionStatus());
    private af L = null;
    private final ConcurrentHashMap M = new ConcurrentHashMap();
    private ArrayList N = null;
    private r O = null;
    private int P = 0;
    private Object Q = new Object();
    private hc R = null;

    public /* synthetic */ n a(jn jnVar, w wVar) {
        return b(jnVar, wVar);
    }

    public /* synthetic */ l b() {
        return bo();
    }

    protected fv(am amVar, long j, BookPackageType bookPackageType, BookType bookType, BookState bookState, boolean z, boolean z2) {
        super(amVar, j, bookPackageType, bookType, bookState, z, z2);
    }

    protected fv(am amVar, Cursor cursor) {
        super(amVar, cursor);
    }

    public final Future b(List list, ag agVar) {
        return ah.b(new ga(this, list, agVar));
    }

    public final Future a(av avVar, String str, ag agVar) {
        return ah.a(new gc(this, avVar, agVar), str);
    }

    public final boolean a(an anVar) {
        if ((anVar instanceof gy) && ((gy) anVar).b != this.G) {
            return true;
        }
        return false;
    }

    public final List bn() {
        boolean z;
        short[] paidChaptersId;
        int i = null;
        DkCloudPurchasedFiction b = DkUserPurchasedFictionsManager.a().b(H());
        HashSet hashSet = new HashSet();
        if (b != null) {
            boolean isEntirePaid = b.isEntirePaid();
            if (isEntirePaid) {
                z = isEntirePaid;
            } else {
                paidChaptersId = b.getPaidChaptersId();
                for (Object add : paidChaptersId) {
                    hashSet.add(add);
                }
                z = isEntirePaid;
            }
        } else {
            z = null;
        }
        String[] bk;
        try {
            aT().a(aF());
            bk = bk();
            paidChaptersId = bl();
            int min = Math.min(bk.length / 2, paidChaptersId.length);
            List linkedList = new LinkedList();
            for (i = 
/*
Method generation error in method: com.duokan.reader.domain.bookshelf.fv.bn():java.util.List
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r1_2 'i' int) = (r1_0 'i' int), (r1_1 'i' int) binds: {(r1_1 'i' int)=B:21:0x0071, (r1_0 'i' int)=B:32:0x003d} in method: com.duokan.reader.domain.bookshelf.fv.bn():java.util.List
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:277)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 19 more

*/

            public final void b(List list) {
                for (String x : list) {
                    a.d(x(x));
                }
                bq();
            }

            public final void a(List list, ag agVar) {
                fe feVar = new fe();
                feVar.c = agVar;
                feVar.a.addAll(list);
                if (feVar.a.isEmpty()) {
                    t.b(new ge(this, feVar));
                } else if (!aj()) {
                    b(list, false, new gf(this, feVar));
                }
            }

            public List v(String str) {
                return Collections.emptyList();
            }

            public boolean w(String str) {
                return true;
            }

            public void a(List list, boolean z, ag agVar) {
            }

            public final void a(DkCloudBookManifest dkCloudBookManifest, af afVar) {
                am aT = aT();
                try {
                    aT.a(aF());
                    aO();
                    if (dkCloudBookManifest != null) {
                        z bookCertification = dkCloudBookManifest.getBookCertification();
                        if (bookCertification != null && bookCertification.b.length > 0 && bookCertification.c.length > 0) {
                            a(new ad(ReaderEnv.get().getDeviceIdVersion(), bookCertification.a, o.a(bookCertification.b) + "\n" + o.a(bookCertification.c), 0));
                        }
                        BookType o = o();
                        BookPackageType s = s();
                        String I = I();
                        if (Q()) {
                            d(false);
                            d(-1);
                        }
                        CharSequence bookUri;
                        if (s == BookPackageType.EPUB_OPF) {
                            if (I.compareTo(dkCloudBookManifest.getBookRevision()) < 0) {
                                bookUri = dkCloudBookManifest.getBookUri();
                            } else {
                                bookUri = "";
                            }
                            if (!TextUtils.isEmpty(bookUri)) {
                                a(Uri.fromFile(new File(new File(e()).getParent(), "book." + dkCloudBookManifest.getBookRevision() + ".epub")).toString(), dkCloudBookManifest.getOpfUri(), dkCloudBookManifest.getBookRevision(), dkCloudBookManifest.getOpfMd5(), false, afVar);
                            } else if (i() == BookState.NORMAL && p() == BookLimitType.CONTENT) {
                                this.d = BookState.PULLING;
                                this.x.c(3);
                                this.x.c(64);
                                b(72);
                            }
                            a(BookLimitType.NONE);
                        } else {
                            if (o == BookType.TRIAL) {
                                bookUri = dkCloudBookManifest.getBookUri();
                            } else if (I.compareTo(dkCloudBookManifest.getBookRevision()) < 0) {
                                bookUri = dkCloudBookManifest.getBookUri();
                            } else {
                                bookUri = "";
                            }
                            if (TextUtils.isEmpty(bookUri)) {
                                a(BookType.NORMAL);
                                a(BookLimitType.NONE);
                            } else {
                                a(Uri.fromFile(new File(new File(e()).getParent(), H() + "." + dkCloudBookManifest.getBookRevision() + ".epub")).toString(), dkCloudBookManifest.getBookUri(), dkCloudBookManifest.getBookRevision(), dkCloudBookManifest.getBookMd5(), true, afVar);
                            }
                        }
                    }
                    aL();
                    aB();
                } finally {
                    aT.b(aF());
                }
            }

            private void b(Runnable runnable) {
                if (k()) {
                    t.b(runnable);
                } else if (!ai()) {
                    t.b(runnable);
                } else if (P()) {
                    t.b(runnable);
                } else if (p() == BookLimitType.NONE && aX()) {
                    t.b(runnable);
                } else {
                    com.duokan.reader.domain.account.a b = i.f().b(PersonalAccount.class);
                    if (b.i()) {
                        t.b(runnable);
                    } else {
                        t.a(new gj(this, b, runnable));
                    }
                }
            }

            public final void a(Runnable runnable) {
                if (k()) {
                    t.b(runnable);
                } else if (!ai()) {
                    t.b(runnable);
                } else if (((PersonalAccount) i.f().b(PersonalAccount.class)).i()) {
                    t.b(runnable);
                } else if (p() == BookLimitType.NONE && aX()) {
                    t.b(runnable);
                } else {
                    t.a(new gl(this, runnable));
                }
            }

            public List e(boolean z) {
                List<gz> bs = bs();
                List arrayList = new ArrayList(bs.size());
                boolean aX = aX();
                for (gz gzVar : bs) {
                    if ((aX || !gzVar.k()) && !gzVar.i()) {
                        if (z) {
                            arrayList.add(gzVar);
                        } else {
                            av l = gzVar.l();
                            if (l == null) {
                                arrayList.add(gzVar);
                            } else if (!l.i()) {
                                arrayList.add(l);
                            }
                        }
                    }
                }
                return arrayList;
            }

            public final File x(String str) {
                return new File(Uri.parse(t(str)).getPath());
            }

            public String t(String str) {
                Object s = s(str);
                if (TextUtils.isEmpty(s)) {
                    return new String("file://" + e() + "/" + str);
                }
                return new String("file://" + e() + "/" + str + "." + s);
            }

            public final boolean u(String str) {
                File x = x(str);
                af bp = bp();
                if (bp.b()) {
                    return ((ConcurrentHashMap) bp.a()).containsKey(x.getName());
                }
                return x.exists();
            }

            protected final void b(String[] strArr) {
                super.b(strArr);
                bq();
            }

            public final BookFormat q() {
                return BookFormat.EPUB;
            }

            public ap bo() {
                ap apVar = null;
                boolean z = true;
                if (d().exists()) {
                    ad y = y();
                    ap alVar;
                    ap apVar2;
                    if (o() == BookType.SERIAL) {
                        alVar = new al();
                        alVar.b = new gy(this);
                        if (new y(this.q).b() != 0) {
                            z = false;
                        }
                        alVar.c = z;
                        if (alVar.b.a() > 0) {
                            apVar2 = alVar;
                        } else {
                            apVar2 = null;
                        }
                        apVar = apVar2;
                    } else if (aX()) {
                        String[] split = y.d.split("\n");
                        if (split.length < 2) {
                            apVar2 = new ap();
                        } else {
                            alVar = new com.duokan.reader.domain.document.epub.ag();
                            alVar.b = new byte[3][];
                            alVar.b[0] = new byte[]{(byte) y.c, (byte) y.b};
                            alVar.b[1] = o.a(split[0]);
                            alVar.b[2] = o.a(split[1]);
                            apVar2 = alVar;
                        }
                        apVar = apVar2;
                    } else {
                        apVar = new ap();
                    }
                    if (apVar != null) {
                        apVar.a = f();
                    }
                }
                return apVar;
            }

            public boolean j() {
                return this.b == BookPackageType.EPUB_OPF;
            }

            public boolean k() {
                return this.e == BookType.SERIAL;
            }

            protected void a(ContentValues contentValues) {
                super.a(contentValues);
                if (c(2048) && this.G != null) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    new ObjectOutputStream(byteArrayOutputStream).writeObject(this.G);
                    contentValues.put(Column.SERIAL_CHAPTERS.toString(), byteArrayOutputStream.toByteArray());
                }
                if (c(2048) && this.H != null) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    new ObjectOutputStream(byteArrayOutputStream).writeObject(this.H);
                    contentValues.put(Column.SERIAL_PRICES.toString(), byteArrayOutputStream.toByteArray());
                }
                if (c(2048) && this.I != null) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    new ObjectOutputStream(byteArrayOutputStream).writeObject(this.I);
                    contentValues.put(Column.SERIAL_SHA1S.toString(), byteArrayOutputStream.toByteArray());
                }
            }

            public s b(jn jnVar, w wVar) {
                this.a.incrementAndGet();
                com.duokan.reader.domain.document.epub.af afVar = (com.duokan.reader.domain.document.epub.af) wVar;
                s sVar = new s(new gp(this, jnVar));
                bu();
                sVar.a(new gn(this, afVar));
                a(null);
                sVar.a(null);
                return sVar;
            }

            public void ah() {
                super.ah();
                bq();
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean ai() {
                /*
                r6 = this;
                r1 = 1;
                r0 = 0;
                r2 = r6.aT();	 Catch:{ all -> 0x0035 }
                r4 = r6.aF();	 Catch:{ all -> 0x0035 }
                r2.a(r4);	 Catch:{ all -> 0x0035 }
                r2 = r6.o();	 Catch:{ all -> 0x0035 }
                r3 = com.duokan.reader.domain.bookshelf.BookType.TRIAL;	 Catch:{ all -> 0x0035 }
                if (r2 == r3) goto L_0x0026;
            L_0x0015:
                r2 = r6.o();	 Catch:{ all -> 0x0035 }
                r3 = com.duokan.reader.domain.bookshelf.BookType.SERIAL;	 Catch:{ all -> 0x0035 }
                if (r2 != r3) goto L_0x0033;
            L_0x001d:
                r2 = r1;
            L_0x001e:
                r3 = r6.q;	 Catch:{ all -> 0x0035 }
                r2 = com.duokan.reader.domain.bookshelf.c.a(r2, r3);	 Catch:{ all -> 0x0035 }
                if (r2 == 0) goto L_0x0027;
            L_0x0026:
                r0 = r1;
            L_0x0027:
                r1 = r6.aT();
                r2 = r6.aF();
                r1.b(r2);
                return r0;
            L_0x0033:
                r2 = r0;
                goto L_0x001e;
            L_0x0035:
                r0 = move-exception;
                r1 = r6.aT();
                r2 = r6.aF();
                r1.b(r2);
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.fv.ai():boolean");
            }

            public boolean aj() {
                boolean z = true;
                if (!k()) {
                    return false;
                }
                if (new y(H()).b() != 1) {
                    z = false;
                }
                return z;
            }

            protected void a(ac acVar) {
                if (this.b == BookPackageType.EPUB_OPF) {
                    try {
                        aT().a(aF());
                        aO();
                        if (acVar.a() || acVar.b(128)) {
                            if (this.R != null) {
                                this.R.cancel(true);
                                this.R = null;
                            }
                        } else if (!acVar.a(3)) {
                            if (!acVar.b(112)) {
                                if (this.R == null || this.R.isDone()) {
                                    this.R = new hc(this, acVar);
                                }
                                this.F.add(this.R);
                            } else if (this.R != null) {
                                this.R.cancel(true);
                                this.R = null;
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

            protected final void a(DkStoreBookDetail dkStoreBookDetail, BookLimitType bookLimitType) {
                int i = 0;
                am aT = aT();
                try {
                    aT.a(aF());
                    if (K || dkStoreBookDetail != null) {
                        File file = new File(new File(aT.d(), dkStoreBookDetail.getBook().getBookUuid()), "book." + dkStoreBookDetail.getRevision() + ".epub");
                        String uri = Uri.fromFile(file).toString();
                        e(dkStoreBookDetail.getBook().getBookUuid());
                        f(dkStoreBookDetail.getRevision());
                        a(uri);
                        a(bookLimitType);
                        b(dkStoreBookDetail.getBook().getCoverUri());
                        o(dkStoreBookDetail.getBook().getTitle());
                        d(dkStoreBookDetail.getBook().getNameLine());
                        a(System.currentTimeMillis());
                        if (!dkStoreBookDetail.getBook().isFree()) {
                            i = dkStoreBookDetail.getBook().getNewPrice();
                        }
                        a(i);
                        a(a(dkStoreBookDetail));
                        b(dkStoreBookDetail.getHighSize());
                        if (dkStoreBookDetail.hasAnyFeatures(DkFeature.FRAME_COMIC.ordinal())) {
                            a(BookContent.FRAME_COMIC);
                        } else {
                            if (dkStoreBookDetail.hasAnyFeatures(DkFeature.PAGE_COMIC.ordinal())) {
                                a(BookContent.PAGE_COMIC);
                            } else {
                                if (dkStoreBookDetail.hasAnyFeatures(DkFeature.VERTICAL_COMIC.ordinal())) {
                                    a(BookContent.VERTICAL_COMIC);
                                } else {
                                    a(BookContent.NORMAL);
                                }
                            }
                        }
                        this.x.a = Uri.fromFile(file).toString();
                        this.x.b = dkStoreBookDetail.getOpfUri();
                        this.x.c = dkStoreBookDetail.getRevision();
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

            private af bp() {
                af afVar = this.L;
                return afVar != null ? afVar : br();
            }

            private void bq() {
                this.L = null;
            }

            private af br() {
                af afVar = new af();
                this.L = afVar;
                ah.a(new fw(this, afVar), "rebuildSerialChapterFileMap@" + hashCode());
                return afVar;
            }

            private List bs() {
                if (this.N == null) {
                    try {
                        bi();
                        aw[] b = s.b(f());
                        List arrayList = new ArrayList(b.length);
                        if (b.length < 1) {
                            return arrayList;
                        }
                        for (aw a : b) {
                            gz a2 = a(a, false);
                            if (a2.h()) {
                                arrayList.add(a2);
                            }
                        }
                        this.N = arrayList;
                    } catch (Throwable th) {
                        return Collections.emptyList();
                    }
                }
                return this.N;
            }

            private gz a(aw awVar, boolean z) {
                if (z && TextUtils.isEmpty(awVar.f)) {
                    return null;
                }
                String b = b(awVar, z);
                gz gzVar = (gz) this.M.get(b);
                if (gzVar != null) {
                    return gzVar;
                }
                gz gzVar2 = new gz(this, b, awVar, z);
                gzVar = (gz) this.M.putIfAbsent(b, gzVar2);
                if (gzVar == null) {
                    return gzVar2;
                }
                return gzVar;
            }

            private String b(aw awVar, boolean z) {
                String str = "#md5=" + (z ? awVar.g : awVar.d);
                switch (fz.a[awVar.b.ordinal()]) {
                    case 1:
                    case 2:
                        if (z) {
                            return "file:///media/lq/" + awVar.a + str;
                        }
                        return "file:///media/" + awVar.a + str;
                    default:
                        return "file:///chapters/" + awVar.a + str;
                }
            }

            private r bt() {
                return this.O;
            }

            private r bu() {
                if (this.b != BookPackageType.EPUB_OPF) {
                    return null;
                }
                r rVar;
                synchronized (this.Q) {
                    int i = this.P + 1;
                    this.P = i;
                    if (i == 1) {
                        File parentFile = d().getParentFile();
                        File file = new File(parentFile, "resources.vfs");
                        parentFile.mkdirs();
                        this.O = bb.e(Uri.fromFile(file).toString());
                        try {
                            file = new File(parentFile, "chapters.bin");
                            File file2 = new File(parentFile, "media.bin");
                            String str = "file:///chapters";
                            str = "file:///media";
                            this.O.a(file.getName(), Uri.fromFile(file).toString(), "file:///chapters");
                            this.O.a(file2.getName(), Uri.fromFile(file2).toString(), "file:///media");
                        } catch (Throwable th) {
                        }
                    }
                    rVar = this.O;
                }
                return rVar;
            }

            private void bv() {
                if (this.b == BookPackageType.EPUB_OPF) {
                    synchronized (this.Q) {
                        int i = this.P - 1;
                        this.P = i;
                        if (i == 0) {
                            this.O.c();
                            this.O = null;
                            this.N = null;
                            this.M.clear();
                        }
                    }
                }
            }

            private static final ab a(DkStoreBookDetail dkStoreBookDetail) {
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

            protected void bi() {
                if (this.d == BookState.CLOUD_ONLY) {
                    try {
                        aT().a(aF());
                        aO();
                        if (this.d == BookState.CLOUD_ONLY) {
                            this.d = j() ? BookState.PULLING : BookState.NORMAL;
                            this.x.c(240);
                            this.x.c(3);
                            this.x.d(64);
                            b(72);
                            aL();
                            aC();
                        }
                        aT().b(aF());
                    } catch (Throwable th) {
                        aT().b(aF());
                    }
                }
                if (!R()) {
                    File d = d();
                    try {
                        if (o() == BookType.SERIAL) {
                            d.mkdirs();
                            if (DkPublic.unzipRawResource(ManagedApp.get(), h.raw__shared__serial_book_files, d)) {
                                br();
                            }
                        } else if (j() && !TextUtils.isEmpty(this.x.b)) {
                            d.getParentFile().mkdirs();
                            b.a(this.x.b, d, new com.duokan.core.b.a.a().a(1).b(131072));
                        }
                        if (!d.exists()) {
                            com.duokan.core.diagnostic.a.c().c(LogLevel.ERROR, "epub", "fail to create the book " + d.getAbsolutePath());
                            throw new IOException();
                        }
                    } catch (Throwable th2) {
                        com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "epub", "fail to create the book " + d.getAbsolutePath(), th2);
                        IOException iOException = new IOException();
                    }
                }
            }

            protected Future a(String str, long j, String str2, Map map, ag agVar) {
                if (k()) {
                    return a(str, null, j, str2, map, new fx(this, agVar));
                }
                return a(str, bu(), j, str2, map, new fy(this, agVar));
            }
        }
