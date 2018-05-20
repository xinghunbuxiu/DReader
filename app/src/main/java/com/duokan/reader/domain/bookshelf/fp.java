package com.duokan.reader.domain.bookshelf;

import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.FileUtil;
import com.duokan.core.p027b.p028a.HttpConfig;
import com.duokan.core.p027b.p028a.C0321b;
import com.duokan.core.sys.C0352r;
import com.duokan.core.sys.C0366o;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ag;
import com.duokan.core.sys.ah;
import com.duokan.core.sys.bb;
import com.duokan.p023b.C0246h;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.duokan.C0650x;
import com.duokan.reader.common.webservices.duokan.C0651y;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.document.C0808w;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0919l;
import com.duokan.reader.domain.document.epub.C0952s;
import com.duokan.reader.domain.document.epub.DkFeature;
import com.duokan.reader.domain.document.epub.al;
import com.duokan.reader.domain.document.epub.an;
import com.duokan.reader.domain.document.epub.ap;
import com.duokan.reader.domain.document.epub.av;
import com.duokan.reader.domain.document.epub.aw;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.Column;
import com.duokan.reader.domain.store.DkStoreBookCategory;
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

public class fp extends ee {
    /* renamed from: K */
    static final /* synthetic */ boolean f3185K = (!fp.class.desiredAssertionStatus());
    /* renamed from: L */
    private af<ConcurrentHashMap<String, String>> f3186L = null;
    /* renamed from: M */
    private final ConcurrentHashMap<String, gt> f3187M = new ConcurrentHashMap();
    /* renamed from: N */
    private ArrayList<gt> f3188N = null;
    /* renamed from: O */
    private C0352r f3189O = null;
    /* renamed from: P */
    private int f3190P = 0;
    /* renamed from: Q */
    private Object f3191Q = new Object();
    /* renamed from: R */
    private gw f3192R = null;

    /* renamed from: a */
    public /* synthetic */ C0903n mo1026a(jz jzVar, C0808w c0808w) {
        return m4487b(jzVar, c0808w);
    }

    /* renamed from: b */
    public /* synthetic */ C0919l mo1033b() {
        return bq();
    }

    protected fp(am amVar, long j, BookPackageType bookPackageType, BookType bookType, BookState bookState, boolean z, boolean z2) {
        super(amVar, j, bookPackageType, bookType, bookState, z, z2);
    }

    protected fp(am amVar, Cursor cursor) {
        super(amVar, cursor);
    }

    /* renamed from: a */
    public static final boolean m4468a(int... iArr) {
        if (iArr.length < 1) {
            return true;
        }
        int length = iArr.length;
        int i = 0;
        while (i < length) {
            try {
                if (!DkFeature.values()[iArr[i]].isLinearizable()) {
                    return false;
                }
                i++;
            } catch (Throwable th) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public final Future<?> m4489b(List<av> list, ag<Map<av, Integer>> agVar) {
        return ah.m871b(new fu(this, list, agVar));
    }

    /* renamed from: a */
    public final Future<?> m4477a(av avVar, String str, ag<Map<av, Integer>> agVar) {
        return ah.m866a(new fw(this, avVar, agVar), str);
    }

    /* renamed from: a */
    public final boolean m4486a(an anVar) {
        if ((anVar instanceof gs) && ((gs) anVar).f3254b != this.G) {
            return true;
        }
        return false;
    }

    public final List<String> bp() {
        boolean z;
        short[] paidChaptersId;
        int i = null;
        DkCloudPurchasedFiction b = DkUserPurchasedFictionsManager.m5072a().m5101b(getId());
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
        String[] bm;
        try {
            aV().mo1091a(aH());
            bm = bm();
            paidChaptersId = bn();
            int min = Math.min(bm.length / 2, paidChaptersId.length);
            List linkedList = new LinkedList();
            for (i = 
/*
Method generation error in method: com.duokan.reader.domain.bookshelf.fp.bp():java.util.List<java.lang.String>, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r1_2 'i' int) = (r1_0 'i' int), (r1_1 'i' int) binds: {(r1_0 'i' int)=B:32:0x003d, (r1_1 'i' int)=B:21:0x0071} in method: com.duokan.reader.domain.bookshelf.fp.bp():java.util.List<java.lang.String>, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:279)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:187)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:320)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:257)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:12)
	at jadx.core.ProcessClass.process(ProcessClass.java:40)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:537)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:509)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 19 more

*/

            /* renamed from: b */
            public final void mo1034b(List<String> list) {
                for (String y : list) {
                    FileUtil.deleteFile(m4500y(y));
                }
                bs();
            }

            /* renamed from: a */
            public final void mo1028a(List<String> list, ag<Map<String, Integer>> agVar) {
                ey eyVar = new ey();
                eyVar.f3148c = agVar;
                eyVar.f3146a.addAll(list);
                if (eyVar.f3146a.isEmpty()) {
                    UThread.post(new fy(this, eyVar));
                } else if (!al()) {
                    m4415b(list, false, new fz(this, eyVar));
                }
            }

            /* renamed from: w */
            public List<String> mo1042w(String str) {
                return Collections.emptyList();
            }

            /* renamed from: x */
            public boolean mo1043x(String str) {
                return true;
            }

            /* renamed from: a */
            public void mo1029a(List<String> list, boolean z, ag<Map<String, Integer>> agVar) {
            }

            /* renamed from: a */
            public final void m4481a(DkCloudBookManifest dkCloudBookManifest, af<Boolean> afVar) {
                am aV = aV();
                try {
                    aV.mo1091a(aH());
                    aQ();
                    if (dkCloudBookManifest != null) {
                        C0651y bookCertification = dkCloudBookManifest.getBookCertification();
                        if (bookCertification != null && bookCertification.f2184b.length > 0 && bookCertification.f2185c.length > 0) {
                            mo1011a(new ad(ReaderEnv.get().getDeviceIdVersion(), bookCertification.f2183a, C0366o.m1031a(bookCertification.f2184b) + "\n" + C0366o.m1031a(bookCertification.f2185c), 0));
                        }
                        BookType o = m4242o();
                        BookPackageType s = m4247s();
                        String J = m4157J();
                        if (m4166S()) {
                            m4420e(false);
                            m4419d(-1);
                        }
                        CharSequence bookUri;
                        if (s == BookPackageType.EPUB_OPF) {
                            if (J.compareTo(dkCloudBookManifest.getBookRevision()) < 0) {
                                bookUri = dkCloudBookManifest.getBookUri();
                            } else {
                                bookUri = "";
                            }
                            if (!TextUtils.isEmpty(bookUri)) {
                                m4198a(Uri.fromFile(new File(new File(m4222e()).getParent(), "book." + dkCloudBookManifest.getBookRevision() + ".epub")).toString(), dkCloudBookManifest.getOpfUri(), dkCloudBookManifest.getBookRevision(), dkCloudBookManifest.getOpfMd5(), false, afVar);
                            } else if (m4233i() == BookState.NORMAL && m4243p() == BookLimitType.CONTENT) {
                                this.d = BookState.PULLING;
                                this.x.m3778c(3);
                                this.x.m3778c(64);
                                m3744b(72);
                            }
                            m4183a(BookLimitType.NONE);
                        } else {
                            if (o == BookType.TRIAL) {
                                bookUri = dkCloudBookManifest.getBookUri();
                            } else if (J.compareTo(dkCloudBookManifest.getBookRevision()) < 0) {
                                bookUri = dkCloudBookManifest.getBookUri();
                            } else {
                                bookUri = "";
                            }
                            if (TextUtils.isEmpty(bookUri)) {
                                m4184a(BookType.NORMAL);
                                m4183a(BookLimitType.NONE);
                            } else {
                                m4198a(Uri.fromFile(new File(new File(m4222e()).getParent(), getId() + "." + dkCloudBookManifest.getBookRevision() + ".epub")).toString(), dkCloudBookManifest.getBookUri(), dkCloudBookManifest.getBookRevision(), dkCloudBookManifest.getBookMd5(), true, afVar);
                            }
                        }
                    }
                    aN();
                    aD();
                } finally {
                    aV.mo1097b(aH());
                }
            }

            /* renamed from: b */
            private void m4471b(Runnable runnable) {
                if (mo1038k()) {
                    UThread.post(runnable);
                } else if (!ak()) {
                    UThread.post(runnable);
                } else if (m4165R()) {
                    UThread.post(runnable);
                } else if (m4243p() == BookLimitType.NONE && aZ()) {
                    UThread.post(runnable);
                } else {
                    C0672a b = C0709k.m3476a().m3502b(PersonalAccount.class);
                    if (b.mo839i()) {
                        UThread.post(runnable);
                    } else {
                        UThread.runOnThread(new gd(this, b, runnable));
                    }
                }
            }

            /* renamed from: a */
            public final void m4483a(Runnable runnable) {
                if (mo1038k()) {
                    UThread.post(runnable);
                } else if (!ak()) {
                    UThread.post(runnable);
                } else if (((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)).mo839i()) {
                    UThread.post(runnable);
                } else if (m4243p() == BookLimitType.NONE && aZ()) {
                    UThread.post(runnable);
                } else {
                    UThread.runOnThread(new gf(this, runnable));
                }
            }

            /* renamed from: f */
            public List<av> m4492f(boolean z) {
                List<gt> bu = bu();
                List arrayList = new ArrayList(bu.size());
                boolean aZ = aZ();
                for (gt gtVar : bu) {
                    if ((aZ || !gtVar.mo1075k()) && !gtVar.mo1073i()) {
                        if (z) {
                            arrayList.add(gtVar);
                        } else {
                            av l = gtVar.mo1076l();
                            if (l == null) {
                                arrayList.add(gtVar);
                            } else if (!l.mo1073i()) {
                                arrayList.add(l);
                            }
                        }
                    }
                }
                return arrayList;
            }

            /* renamed from: y */
            public final File m4500y(String str) {
                return new File(Uri.parse(mo1040u(str)).getPath());
            }

            /* renamed from: u */
            public String mo1040u(String str) {
                Object t = mo1017t(str);
                if (TextUtils.isEmpty(t)) {
                    return new String("file://" + m4222e() + "/" + str);
                }
                return new String("file://" + m4222e() + "/" + str + "." + t);
            }

            /* renamed from: v */
            public final boolean mo1041v(String str) {
                File y = m4500y(str);
                af br = br();
                if (br.m861b()) {
                    return ((ConcurrentHashMap) br.m858a()).containsKey(y.getName());
                }
                return y.exists();
            }

            /* renamed from: b */
            protected final void mo1035b(String[] strArr) {
                super.mo1035b(strArr);
                bs();
            }

            /* renamed from: q */
            public final BookFormat mo1039q() {
                return BookFormat.EPUB;
            }

            public ap bq() {
                ap apVar = null;
                boolean z = true;
                if (m4219d().exists()) {
                    ad z2 = mo1020z();
                    ap alVar;
                    ap apVar2;
                    if (m4242o() == BookType.SERIAL) {
                        alVar = new al();
                        alVar.f4485b = new gs(this);
                        if (new C0650x(this.q).m3047b() != 0) {
                            z = false;
                        }
                        alVar.f4486c = z;
                        if (alVar.f4485b.mo1067a() > 0) {
                            apVar2 = alVar;
                        } else {
                            apVar2 = null;
                        }
                        apVar = apVar2;
                    } else if (aZ()) {
                        String[] split = z2.f2725d.split("\n");
                        if (split.length < 2) {
                            apVar2 = new ap();
                        } else {
                            alVar = new com.duokan.reader.domain.document.epub.ag();
                            alVar.f4477b = new byte[3][];
                            alVar.f4477b[0] = new byte[]{(byte) z2.f2724c, (byte) z2.f2723b};
                            alVar.f4477b[1] = C0366o.m1033a(split[0]);
                            alVar.f4477b[2] = C0366o.m1033a(split[1]);
                            apVar2 = alVar;
                        }
                        apVar = apVar2;
                    } else {
                        apVar = new ap();
                    }
                    if (apVar != null) {
                        apVar.a = m4225f();
                    }
                }
                return apVar;
            }

            /* renamed from: j */
            public boolean mo1037j() {
                return this.b == BookPackageType.EPUB_OPF;
            }

            /* renamed from: k */
            public boolean mo1038k() {
                return this.e == BookType.SERIAL;
            }

            /* renamed from: a */
            protected void mo950a(ContentValues contentValues) {
                super.mo950a(contentValues);
                if (m3747c(2048) && this.G != null) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    new ObjectOutputStream(byteArrayOutputStream).writeObject(this.G);
                    contentValues.put(Column.SERIAL_CHAPTERS.toString(), byteArrayOutputStream.toByteArray());
                }
                if (m3747c(2048) && this.H != null) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    new ObjectOutputStream(byteArrayOutputStream).writeObject(this.H);
                    contentValues.put(Column.SERIAL_PRICES.toString(), byteArrayOutputStream.toByteArray());
                }
                if (m3747c(2048) && this.I != null) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    new ObjectOutputStream(byteArrayOutputStream).writeObject(this.I);
                    contentValues.put(Column.SERIAL_SHA1S.toString(), byteArrayOutputStream.toByteArray());
                }
            }

            /* renamed from: b */
            public C0952s m4487b(jz jzVar, C0808w c0808w) {
                this.a.incrementAndGet();
                com.duokan.reader.domain.document.epub.af afVar = (com.duokan.reader.domain.document.epub.af) c0808w;
                C0952s c0952s = new C0952s(new gj(this, jzVar));
                bw();
                c0952s.m5910a(new gh(this, afVar));
                m4483a(null);
                c0952s.mo1219a(null);
                return c0952s;
            }

            public void aj() {
                super.aj();
                bs();
            }

            public final boolean ak() {
                if (m4242o() != BookType.TRIAL) {
                    if (!C0800c.m4134a(m4242o() == BookType.SERIAL, this.q)) {
                        return false;
                    }
                }
                return true;
            }

            public boolean al() {
                boolean z = true;
                if (!mo1038k()) {
                    return false;
                }
                if (new C0650x(getId()).m3047b() != 1) {
                    z = false;
                }
                return z;
            }

            /* renamed from: a */
            protected void mo1010a(ac acVar) {
                if (this.b == BookPackageType.EPUB_OPF) {
                    try {
                        aV().mo1091a(aH());
                        aQ();
                        if (acVar.m3775a() || acVar.m3777b(128)) {
                            if (this.f3192R != null) {
                                this.f3192R.cancel(true);
                                this.f3192R = null;
                            }
                        } else if (!acVar.m3776a(3)) {
                            if (!acVar.m3777b(112)) {
                                if (this.f3192R == null || this.f3192R.isDone()) {
                                    this.f3192R = new gw(this, acVar);
                                }
                                this.F.add(this.f3192R);
                            } else if (this.f3192R != null) {
                                this.f3192R.cancel(true);
                                this.f3192R = null;
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

            /* renamed from: a */
            protected final void m4482a(DkStoreBookDetail dkStoreBookDetail, BookLimitType bookLimitType) {
                int i = 0;
                am aV = aV();
                try {
                    aV.mo1091a(aH());
                    if (f3185K || dkStoreBookDetail != null) {
                        File file = new File(new File(aV.mo1101d(), dkStoreBookDetail.getBook().getBookUuid()), "book." + dkStoreBookDetail.getRevision() + ".epub");
                        String uri = Uri.fromFile(file).toString();
                        m4224e(dkStoreBookDetail.getBook().getBookUuid());
                        m4227f(dkStoreBookDetail.getRevision());
                        m4196a(uri);
                        m4183a(bookLimitType);
                        m4212b(dkStoreBookDetail.getBook().getCoverUri());
                        mo955p(dkStoreBookDetail.getBook().getTitle());
                        m4221d(dkStoreBookDetail.getBook().getNameLine());
                        m4176a(System.currentTimeMillis());
                        if (!dkStoreBookDetail.getBook().isFree()) {
                            i = dkStoreBookDetail.getBook().getNewPrice();
                        }
                        m4175a(i);
                        m4186a(m4463a(dkStoreBookDetail));
                        m4207b(dkStoreBookDetail.getHighSize());
                        if (dkStoreBookDetail.hasAnyFeatures(DkFeature.FRAME_COMIC.ordinal())) {
                            m4182a(BookContent.FRAME_COMIC);
                        } else {
                            if (dkStoreBookDetail.hasAnyFeatures(DkFeature.PAGE_COMIC.ordinal())) {
                                m4182a(BookContent.PAGE_COMIC);
                            } else {
                                if (dkStoreBookDetail.hasAnyFeatures(DkFeature.VERTICAL_COMIC.ordinal())) {
                                    m4182a(BookContent.VERTICAL_COMIC);
                                } else {
                                    m4182a(BookContent.NORMAL);
                                }
                            }
                        }
                        this.x.f2717a = Uri.fromFile(file).toString();
                        this.x.f2718b = dkStoreBookDetail.getOpfUri();
                        this.x.f2719c = dkStoreBookDetail.getRevision();
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

            private af<ConcurrentHashMap<String, String>> br() {
                af<ConcurrentHashMap<String, String>> afVar = this.f3186L;
                return afVar != null ? afVar : bt();
            }

            private void bs() {
                this.f3186L = null;
            }

            private af<ConcurrentHashMap<String, String>> bt() {
                af<ConcurrentHashMap<String, String>> afVar = new af();
                this.f3186L = afVar;
                ah.m866a(new fq(this, afVar), "rebuildSerialChapterFileMap@" + hashCode());
                return afVar;
            }

            private List<gt> bu() {
                if (this.f3188N == null) {
                    try {
                        bk();
                        aw[] b = C0952s.m7006b(m4225f());
                        List arrayList = new ArrayList(b.length);
                        if (b.length < 1) {
                            return arrayList;
                        }
                        for (aw a : b) {
                            gt a2 = m4465a(a, false);
                            if (a2.mo1072h()) {
                                arrayList.add(a2);
                            }
                        }
                        this.f3188N = arrayList;
                    } catch (Throwable th) {
                        return Collections.emptyList();
                    }
                }
                return this.f3188N;
            }

            /* renamed from: a */
            private gt m4465a(aw awVar, boolean z) {
                if (z && TextUtils.isEmpty(awVar.f4497f)) {
                    return null;
                }
                String b = m4469b(awVar, z);
                gt gtVar = (gt) this.f3187M.get(b);
                if (gtVar != null) {
                    return gtVar;
                }
                gt gtVar2 = new gt(this, b, awVar, z);
                gtVar = (gt) this.f3187M.putIfAbsent(b, gtVar2);
                if (gtVar == null) {
                    return gtVar2;
                }
                return gtVar;
            }

            /* renamed from: b */
            private String m4469b(aw awVar, boolean z) {
                String str = "#md5=" + (z ? awVar.f4498g : awVar.f4495d);
                switch (ft.f3199a[awVar.f4493b.ordinal()]) {
                    case 1:
                    case 2:
                        if (z) {
                            return "file:///media/lq/" + awVar.f4492a + str;
                        }
                        return "file:///media/" + awVar.f4492a + str;
                    default:
                        return "file:///chapters/" + awVar.f4492a + str;
                }
            }

            private C0352r bv() {
                return this.f3189O;
            }

            private C0352r bw() {
                if (this.b != BookPackageType.EPUB_OPF) {
                    return null;
                }
                C0352r c0352r;
                synchronized (this.f3191Q) {
                    int i = this.f3190P + 1;
                    this.f3190P = i;
                    if (i == 1) {
                        File parentFile = m4219d().getParentFile();
                        File file = new File(parentFile, "resources.vfs");
                        parentFile.mkdirs();
                        this.f3189O = bb.m947e(Uri.fromFile(file).toString());
                        try {
                            file = new File(parentFile, "chapters.bin");
                            File file2 = new File(parentFile, "media.bin");
                            String str = "file:///chapters";
                            str = "file:///media";
                            this.f3189O.mo417a(file.getName(), Uri.fromFile(file).toString(), "file:///chapters");
                            this.f3189O.mo417a(file2.getName(), Uri.fromFile(file2).toString(), "file:///media");
                        } catch (Throwable th) {
                        }
                    }
                    c0352r = this.f3189O;
                }
                return c0352r;
            }

            private void bx() {
                if (this.b == BookPackageType.EPUB_OPF) {
                    synchronized (this.f3191Q) {
                        int i = this.f3190P - 1;
                        this.f3190P = i;
                        if (i == 0) {
                            this.f3189O.mo423c();
                            this.f3189O = null;
                            this.f3188N = null;
                            this.f3187M.clear();
                        }
                    }
                }
            }

            /* renamed from: a */
            private static final ab m4463a(DkStoreBookDetail dkStoreBookDetail) {
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

            protected void bk() {
                if (this.d == BookState.CLOUD_ONLY) {
                    try {
                        aV().mo1091a(aH());
                        aQ();
                        if (this.d == BookState.CLOUD_ONLY) {
                            this.d = mo1037j() ? BookState.PULLING : BookState.NORMAL;
                            this.x.m3778c(240);
                            this.x.m3778c(3);
                            this.x.m3779d(64);
                            m3744b(72);
                            aN();
                            aE();
                        }
                        aV().mo1097b(aH());
                    } catch (Throwable th) {
                        aV().mo1097b(aH());
                    }
                }
                if (!m4167T()) {
                    File d = m4219d();
                    try {
                        if (m4242o() == BookType.SERIAL) {
                            d.mkdirs();
                            if (DkPublic.unzipRawResource(ManagedApp.get(), C0246h.raw__shared__serial_book_files, d)) {
                                bt();
                            }
                        } else if (mo1037j() && !TextUtils.isEmpty(this.x.f2718b)) {
                            d.getParentFile().mkdirs();
                            C0321b.getFileLength(this.x.f2718b, d, new HttpConfig().m721a(1).m724b(131072));
                        }
                        if (!d.exists()) {
                            WebLog.init().c(LogLevel.ERROR, "epub", "fail to create the book " + d.getAbsolutePath());
                            throw new IOException();
                        }
                    } catch (Throwable th2) {
                        WebLog.init().printStackTrace(LogLevel.ERROR, "epub", "fail to create the book " + d.getAbsolutePath(), th2);
                        IOException iOException = new IOException();
                    }
                }
            }

            /* renamed from: a */
            protected Future<Integer> mo1027a(String str, long j, String str2, Map<String, String> map, ag<Integer> agVar) {
                if (mo1038k()) {
                    return m4399a(str, null, j, str2, map, new fr(this, agVar));
                }
                return m4399a(str, bw(), j, str2, map, new fs(this, agVar));
            }
        }
