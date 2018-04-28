package com.duokan.reader.domain.bookshelf;

import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.C0352r;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.core.sys.bb;
import com.duokan.reader.common.webservices.duokan.C0650x;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.document.C0808w;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0919l;
import com.duokan.reader.domain.document.sbk.C0820o;
import com.duokan.reader.domain.document.sbk.C0823q;
import com.duokan.reader.domain.document.sbk.C0969f;
import com.duokan.reader.domain.document.sbk.C0978s;
import com.duokan.reader.domain.provider.BookshelfHelper.BooksTable.Column;
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

public class kh extends ee {
    /* renamed from: K */
    private final ConcurrentHashMap<String, List<ky>> f3456K = new ConcurrentHashMap();
    /* renamed from: L */
    private final ConcurrentHashMap<String, ky> f3457L = new ConcurrentHashMap();
    /* renamed from: M */
    private final Object f3458M = new Object();
    /* renamed from: N */
    private C0352r f3459N = null;
    /* renamed from: O */
    private int f3460O = 0;

    /* renamed from: a */
    public /* synthetic */ C0903n mo1026a(jz jzVar, C0808w c0808w) {
        return m4832b(jzVar, c0808w);
    }

    /* renamed from: b */
    public /* synthetic */ C0919l mo1033b() {
        return bq();
    }

    protected kh(am amVar, long j, BookPackageType bookPackageType, BookType bookType, BookState bookState, boolean z, boolean z2) {
        super(amVar, j, bookPackageType, bookType, bookState, z, z2);
    }

    protected kh(am amVar, Cursor cursor) {
        super(amVar, cursor);
    }

    /* renamed from: a */
    public final boolean m4830a(C0823q c0823q) {
        if ((c0823q instanceof kw) && ((kw) c0823q).f3491b != this.G) {
            return true;
        }
        return false;
    }

    public final List<String> bp() {
        boolean z;
        short[] paidChaptersId;
        int i = null;
        DkCloudPurchasedFiction b = DkUserPurchasedFictionsManager.m5072a().m5101b(m4156I());
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
Method generation error in method: com.duokan.reader.domain.bookshelf.kh.bp():java.util.List<java.lang.String>, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r1_2 'i' int) = (r1_0 'i' int), (r1_1 'i' int) binds: {(r1_0 'i' int)=B:32:0x003d, (r1_1 'i' int)=B:21:0x0071} in method: com.duokan.reader.domain.bookshelf.kh.bp():java.util.List<java.lang.String>, dex: classes.dex
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

            /* renamed from: a */
            public final void mo1028a(List<String> list, ag<Map<String, Integer>> agVar) {
                ey eyVar = new ey();
                eyVar.f3148c = agVar;
                eyVar.f3146a.addAll(list);
                if (eyVar.f3146a.isEmpty()) {
                    UThread.post(new ki(this, eyVar));
                } else {
                    m4415b(list, false, new kj(this, eyVar));
                }
            }

            /* renamed from: a */
            public void mo1029a(List<String> list, boolean z, ag<Map<String, Integer>> agVar) {
                kz kzVar = new kz();
                kzVar.f3505c = agVar;
                kzVar.f3503a.addAll(list);
                if (!kzVar.f3503a.isEmpty()) {
                    ah.m866a(new kn(this, kzVar, z), "serialPullingQueue");
                } else if (kzVar.f3505c != null) {
                    kzVar.f3505c.run(kzVar.f3504b);
                }
            }

            /* renamed from: b */
            public void mo1034b(List<String> list) {
            }

            /* renamed from: u */
            public String mo1040u(String str) {
                Object t = mo1017t(str);
                if (TextUtils.isEmpty(t)) {
                    return new String("file:///chapters/" + str);
                }
                return new String("file:///chapters/" + str + "." + t);
            }

            /* renamed from: w */
            public List<String> mo1042w(String str) {
                List<ky> y = m4841y(str);
                if (y.isEmpty()) {
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList(y.size());
                for (ky kyVar : y) {
                    arrayList.add(kyVar.f3496a);
                }
                return arrayList;
            }

            /* renamed from: v */
            public boolean mo1041v(String str) {
                try {
                    boolean a = br().mo418a(mo1040u(str));
                    return a;
                } finally {
                    bs();
                }
            }

            /* renamed from: x */
            public boolean mo1043x(String str) {
                ky z = m4842z(str);
                if (z == null) {
                    return false;
                }
                try {
                    boolean a = br().mo418a(z.f3497b);
                    return a;
                } finally {
                    bs();
                }
            }

            /* renamed from: q */
            public final BookFormat mo1039q() {
                return BookFormat.SBK;
            }

            public C0978s bq() {
                if (!m4219d().exists()) {
                    return null;
                }
                C0978s c0978s = new C0978s();
                c0978s.f4841b = new kw(this);
                return c0978s;
            }

            /* renamed from: j */
            public boolean mo1037j() {
                return false;
            }

            /* renamed from: k */
            public boolean mo1038k() {
                return true;
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
            public C0969f m4832b(jz jzVar, C0808w c0808w) {
                this.a.incrementAndGet();
                aV().mo1106i();
                C0820o c0820o = (C0820o) c0808w;
                br();
                C0969f c0969f = new C0969f(new kq(this));
                c0969f.m5910a(new kt(this, c0820o));
                c0969f.mo1219a(null);
                return c0969f;
            }

            public void aj() {
                super.aj();
            }

            public final boolean ak() {
                return true;
            }

            public boolean al() {
                boolean z = true;
                if (!mo1038k()) {
                    return false;
                }
                if (new C0650x(m4156I()).m3047b() != 1) {
                    z = false;
                }
                return z;
            }

            protected void bk() {
                if (this.d == BookState.CLOUD_ONLY) {
                    try {
                        aV().mo1091a(aH());
                        aQ();
                        if (this.d == BookState.CLOUD_ONLY) {
                            this.d = BookState.NORMAL;
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
                    d.mkdirs();
                    if (!d.exists()) {
                        C0328a.m757c().m752c(LogLevel.ERROR, "sbk", "fail to create the book " + d.getAbsolutePath());
                        throw new IOException();
                    }
                }
            }

            /* renamed from: a */
            protected Future<Integer> mo1027a(String str, long j, String str2, Map<String, String> map, ag<Integer> agVar) {
                return m4399a(str, br(), j, str2, map, new ku(this, agVar));
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: y */
            protected java.util.List<com.duokan.reader.domain.bookshelf.ky> m4841y(java.lang.String r19) {
                /*
                r18 = this;
                r0 = r18;
                r2 = r0.f3456K;
                r0 = r19;
                r2 = r2.get(r0);
                r2 = (java.util.List) r2;
                if (r2 == 0) goto L_0x000f;
            L_0x000e:
                return r2;
            L_0x000f:
                r12 = java.util.Collections.emptyList();
                r2 = r18.br();
                r3 = r18.mo1040u(r19);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                r4 = r2.mo418a(r3);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                if (r4 != 0) goto L_0x0026;
            L_0x0021:
                r18.bs();
                r2 = r12;
                goto L_0x000e;
            L_0x0026:
                r13 = r2.mo422c(r3);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                r14 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                r2 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
                r14.<init>(r2);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                com.duokan.core.io.C0339d.m796a(r13, r14);	 Catch:{ all -> 0x00f2 }
                r2 = r14.toByteArray();	 Catch:{ all -> 0x00f2 }
                r2 = com.duokan.kernel.DkUtils.decodeSimpleDrm(r2);	 Catch:{ all -> 0x00f2 }
                r3 = new java.lang.String;	 Catch:{ all -> 0x00f2 }
                r4 = "UTF-8";
                r3.<init>(r2, r4);	 Catch:{ all -> 0x00f2 }
                r2 = new org.json.JSONObject;	 Catch:{ all -> 0x00f2 }
                r2.<init>(r3);	 Catch:{ all -> 0x00f2 }
                if (r2 != 0) goto L_0x0055;
            L_0x004a:
                com.duokan.core.io.C0339d.m795a(r13);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                com.duokan.core.io.C0339d.m795a(r14);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                r18.bs();
                r2 = r12;
                goto L_0x000e;
            L_0x0055:
                r3 = "pictures";
                r15 = com.duokan.reader.common.C0611i.m2787a(r2, r3);	 Catch:{ all -> 0x00f2 }
                r16 = new java.util.ArrayList;	 Catch:{ all -> 0x00f2 }
                r2 = r15.length();	 Catch:{ all -> 0x00f2 }
                r0 = r16;
                r0.<init>(r2);	 Catch:{ all -> 0x00f2 }
                r2 = 0;
            L_0x0067:
                r3 = r15.length();	 Catch:{ all -> 0x00f2 }
                if (r2 >= r3) goto L_0x00d0;
            L_0x006d:
                r3 = r15.getJSONObject(r2);	 Catch:{ all -> 0x00f2 }
                r4 = "sm_md5";
                r7 = r3.getString(r4);	 Catch:{ all -> 0x00f2 }
                r4 = "sm_url";
                r6 = r3.getString(r4);	 Catch:{ all -> 0x00f2 }
                r4 = "sm_size";
                r8 = r3.getLong(r4);	 Catch:{ all -> 0x00f2 }
                r4 = "width";
                r10 = r3.getInt(r4);	 Catch:{ all -> 0x00f2 }
                r4 = "height";
                r11 = r3.getInt(r4);	 Catch:{ all -> 0x00f2 }
                r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f2 }
                r3.<init>();	 Catch:{ all -> 0x00f2 }
                r0 = r19;
                r3 = r3.append(r0);	 Catch:{ all -> 0x00f2 }
                r4 = ".";
                r3 = r3.append(r4);	 Catch:{ all -> 0x00f2 }
                r3 = r3.append(r2);	 Catch:{ all -> 0x00f2 }
                r4 = r3.toString();	 Catch:{ all -> 0x00f2 }
                r5 = new java.lang.String;	 Catch:{ all -> 0x00f2 }
                r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f2 }
                r3.<init>();	 Catch:{ all -> 0x00f2 }
                r17 = "file:///stuffs/";
                r0 = r17;
                r3 = r3.append(r0);	 Catch:{ all -> 0x00f2 }
                r3 = r3.append(r7);	 Catch:{ all -> 0x00f2 }
                r3 = r3.toString();	 Catch:{ all -> 0x00f2 }
                r5.<init>(r3);	 Catch:{ all -> 0x00f2 }
                r3 = r18;
                r3 = r3.m4824a(r4, r5, r6, r7, r8, r10, r11);	 Catch:{ all -> 0x00f2 }
                r0 = r16;
                r0.add(r3);	 Catch:{ all -> 0x00f2 }
                r2 = r2 + 1;
                goto L_0x0067;
            L_0x00d0:
                r0 = r18;
                r2 = r0.f3456K;	 Catch:{ all -> 0x00f2 }
                r0 = r19;
                r1 = r16;
                r2.putIfAbsent(r0, r1);	 Catch:{ all -> 0x00f2 }
                r0 = r18;
                r2 = r0.f3456K;	 Catch:{ all -> 0x00f2 }
                r0 = r19;
                r2 = r2.get(r0);	 Catch:{ all -> 0x00f2 }
                r2 = (java.util.List) r2;	 Catch:{ all -> 0x00f2 }
                com.duokan.core.io.C0339d.m795a(r13);	 Catch:{ Throwable -> 0x0106, all -> 0x0101 }
                com.duokan.core.io.C0339d.m795a(r14);	 Catch:{ Throwable -> 0x0106, all -> 0x0101 }
                r18.bs();
                goto L_0x000e;
            L_0x00f2:
                r2 = move-exception;
                com.duokan.core.io.C0339d.m795a(r13);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                com.duokan.core.io.C0339d.m795a(r14);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                throw r2;	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
            L_0x00fa:
                r2 = move-exception;
                r2 = r12;
            L_0x00fc:
                r18.bs();
                goto L_0x000e;
            L_0x0101:
                r2 = move-exception;
                r18.bs();
                throw r2;
            L_0x0106:
                r3 = move-exception;
                goto L_0x00fc;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.kh.y(java.lang.String):java.util.List<com.duokan.reader.domain.bookshelf.ky>");
            }

            /* renamed from: z */
            protected ky m4842z(String str) {
                return (ky) this.f3457L.get(str);
            }

            /* renamed from: a */
            protected ky m4824a(String str, String str2, String str3, String str4, long j, int i, int i2) {
                this.f3457L.putIfAbsent(str, new ky(str, str2, str3, str4, j, i, i2));
                return (ky) this.f3457L.get(str);
            }

            private C0352r br() {
                C0352r c0352r;
                synchronized (this.f3458M) {
                    int i = this.f3460O + 1;
                    this.f3460O = i;
                    if (i == 1) {
                        File d = m4219d();
                        File file = new File(d, "resources.vfs");
                        d.mkdirs();
                        this.f3459N = bb.m947e(Uri.fromFile(file).toString());
                        try {
                            file = new File(d, "chapters.bin");
                            File file2 = new File(d, "stuffs.bin");
                            String str = "file:///chapters";
                            str = "file:///stuffs";
                            this.f3459N.mo417a(file.getName(), Uri.fromFile(file).toString(), "file:///chapters");
                            this.f3459N.mo417a(file2.getName(), Uri.fromFile(file2).toString(), "file:///stuffs");
                        } catch (Throwable th) {
                        }
                    }
                    c0352r = this.f3459N;
                }
                return c0352r;
            }

            private void bs() {
                synchronized (this.f3458M) {
                    int i = this.f3460O - 1;
                    this.f3460O = i;
                    if (i == 0) {
                        this.f3459N.mo423c();
                        this.f3459N = null;
                    }
                }
            }
        }
