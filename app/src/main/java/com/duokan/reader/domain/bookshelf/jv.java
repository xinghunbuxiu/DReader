package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.ag;
import com.duokan.core.sys.ah;
import com.duokan.core.sys.bb;
import com.duokan.core.sys.r;
import com.duokan.core.sys.t;
import com.duokan.reader.common.webservices.duokan.y;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.document.l;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.document.sbk.f;
import com.duokan.reader.domain.document.sbk.o;
import com.duokan.reader.domain.document.sbk.q;
import com.duokan.reader.domain.document.sbk.s;
import com.duokan.reader.domain.document.w;
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

public class jv extends ej {
    private final ConcurrentHashMap K = new ConcurrentHashMap();
    private final ConcurrentHashMap L = new ConcurrentHashMap();
    private final Object M = new Object();
    private r N = null;
    private int O = 0;

    public /* synthetic */ n a(jn jnVar, w wVar) {
        return b(jnVar, wVar);
    }

    public /* synthetic */ l b() {
        return bo();
    }

    protected jv(am amVar, long j, BookPackageType bookPackageType, BookType bookType, BookState bookState, boolean z, boolean z2) {
        super(amVar, j, bookPackageType, bookType, bookState, z, z2);
    }

    protected jv(am amVar, Cursor cursor) {
        super(amVar, cursor);
    }

    public final boolean a(q qVar) {
        if ((qVar instanceof kk) && ((kk) qVar).b != this.G) {
            return true;
        }
        return false;
    }

    public final List bn() {
        boolean z;
        short[] paidChaptersId;
        String[] bk;
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
        try {
            aT().a(aF());
            bk = bk();
            paidChaptersId = bl();
            int min = Math.min(bk.length / 2, paidChaptersId.length);
            List linkedList = new LinkedList();
            for (i = 
/*
Method generation error in method: com.duokan.reader.domain.bookshelf.jv.bn():java.util.List
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r1_2 'i' int) = (r1_0 'i' int), (r1_1 'i' int) binds: {(r1_1 'i' int)=B:21:0x0071, (r1_0 'i' int)=B:32:0x003d} in method: com.duokan.reader.domain.bookshelf.jv.bn():java.util.List
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

            public final void a(List list, ag agVar) {
                fe feVar = new fe();
                feVar.c = agVar;
                feVar.a.addAll(list);
                if (feVar.a.isEmpty()) {
                    t.b(new jw(this, feVar));
                } else {
                    b(list, false, new jx(this, feVar));
                }
            }

            public void a(List list, boolean z, ag agVar) {
                kn knVar = new kn();
                knVar.c = agVar;
                knVar.a.addAll(list);
                if (!knVar.a.isEmpty()) {
                    ah.a(new kb(this, knVar, z), "serialPullingQueue");
                } else if (knVar.c != null) {
                    knVar.c.a(knVar.b);
                }
            }

            public void b(List list) {
            }

            public String t(String str) {
                Object s = s(str);
                if (TextUtils.isEmpty(s)) {
                    return new String("file:///chapters/" + str);
                }
                return new String("file:///chapters/" + str + "." + s);
            }

            public List v(String str) {
                List<km> x = x(str);
                if (x.isEmpty()) {
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList(x.size());
                for (km kmVar : x) {
                    arrayList.add(kmVar.a);
                }
                return arrayList;
            }

            public boolean u(String str) {
                try {
                    boolean a = bp().a(t(str));
                    return a;
                } finally {
                    bq();
                }
            }

            public boolean w(String str) {
                km y = y(str);
                if (y == null) {
                    return false;
                }
                try {
                    boolean a = bp().a(y.b);
                    return a;
                } finally {
                    bq();
                }
            }

            public final BookFormat q() {
                return BookFormat.SBK;
            }

            public s bo() {
                if (!d().exists()) {
                    return null;
                }
                s sVar = new s();
                sVar.b = new kk(this);
                return sVar;
            }

            public boolean j() {
                return false;
            }

            public boolean k() {
                return true;
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

            public f b(jn jnVar, w wVar) {
                this.a.incrementAndGet();
                aT().i();
                o oVar = (o) wVar;
                bp();
                f fVar = new f(new ke(this));
                fVar.a(new kh(this, oVar));
                fVar.a(null);
                return fVar;
            }

            public void ah() {
                super.ah();
            }

            public final boolean ai() {
                return true;
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

            protected void bi() {
                if (this.d == BookState.CLOUD_ONLY) {
                    try {
                        aT().a(aF());
                        aO();
                        if (this.d == BookState.CLOUD_ONLY) {
                            this.d = BookState.NORMAL;
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
                    d.mkdirs();
                    if (!d.exists()) {
                        a.c().c(LogLevel.ERROR, "sbk", "fail to create the book " + d.getAbsolutePath());
                        throw new IOException();
                    }
                }
            }

            protected Future a(String str, long j, String str2, Map map, ag agVar) {
                return a(str, bp(), j, str2, map, new ki(this, agVar));
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected java.util.List x(java.lang.String r19) {
                /*
                r18 = this;
                r0 = r18;
                r2 = r0.K;
                r0 = r19;
                r2 = r2.get(r0);
                r2 = (java.util.List) r2;
                if (r2 == 0) goto L_0x000f;
            L_0x000e:
                return r2;
            L_0x000f:
                r12 = java.util.Collections.emptyList();
                r2 = r18.bp();
                r3 = r18.t(r19);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                r4 = r2.a(r3);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                if (r4 != 0) goto L_0x0026;
            L_0x0021:
                r18.bq();
                r2 = r12;
                goto L_0x000e;
            L_0x0026:
                r13 = r2.c(r3);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                r14 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                r2 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
                r14.<init>(r2);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                com.duokan.core.io.d.a(r13, r14);	 Catch:{ all -> 0x00f2 }
                r2 = r14.toByteArray();	 Catch:{ all -> 0x00f2 }
                r2 = com.duokan.kernel.DkUtils.decodeSimpleDrm(r2);	 Catch:{ all -> 0x00f2 }
                r3 = new java.lang.String;	 Catch:{ all -> 0x00f2 }
                r4 = "UTF-8";
                r3.<init>(r2, r4);	 Catch:{ all -> 0x00f2 }
                r2 = new org.json.JSONObject;	 Catch:{ all -> 0x00f2 }
                r2.<init>(r3);	 Catch:{ all -> 0x00f2 }
                if (r2 != 0) goto L_0x0055;
            L_0x004a:
                com.duokan.core.io.d.a(r13);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                com.duokan.core.io.d.a(r14);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                r18.bq();
                r2 = r12;
                goto L_0x000e;
            L_0x0055:
                r3 = "pictures";
                r15 = com.duokan.reader.common.i.a(r2, r3);	 Catch:{ all -> 0x00f2 }
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
                r3 = r3.a(r4, r5, r6, r7, r8, r10, r11);	 Catch:{ all -> 0x00f2 }
                r0 = r16;
                r0.add(r3);	 Catch:{ all -> 0x00f2 }
                r2 = r2 + 1;
                goto L_0x0067;
            L_0x00d0:
                r0 = r18;
                r2 = r0.K;	 Catch:{ all -> 0x00f2 }
                r0 = r19;
                r1 = r16;
                r2.putIfAbsent(r0, r1);	 Catch:{ all -> 0x00f2 }
                r0 = r18;
                r2 = r0.K;	 Catch:{ all -> 0x00f2 }
                r0 = r19;
                r2 = r2.get(r0);	 Catch:{ all -> 0x00f2 }
                r2 = (java.util.List) r2;	 Catch:{ all -> 0x00f2 }
                com.duokan.core.io.d.a(r13);	 Catch:{ Throwable -> 0x0106, all -> 0x0101 }
                com.duokan.core.io.d.a(r14);	 Catch:{ Throwable -> 0x0106, all -> 0x0101 }
                r18.bq();
                goto L_0x000e;
            L_0x00f2:
                r2 = move-exception;
                com.duokan.core.io.d.a(r13);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                com.duokan.core.io.d.a(r14);	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
                throw r2;	 Catch:{ Throwable -> 0x00fa, all -> 0x0101 }
            L_0x00fa:
                r2 = move-exception;
                r2 = r12;
            L_0x00fc:
                r18.bq();
                goto L_0x000e;
            L_0x0101:
                r2 = move-exception;
                r18.bq();
                throw r2;
            L_0x0106:
                r3 = move-exception;
                goto L_0x00fc;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.jv.x(java.lang.String):java.util.List");
            }

            protected km y(String str) {
                return (km) this.L.get(str);
            }

            protected km a(String str, String str2, String str3, String str4, long j, int i, int i2) {
                this.L.putIfAbsent(str, new km(str, str2, str3, str4, j, i, i2));
                return (km) this.L.get(str);
            }

            private r bp() {
                r rVar;
                synchronized (this.M) {
                    int i = this.O + 1;
                    this.O = i;
                    if (i == 1) {
                        File d = d();
                        File file = new File(d, "resources.vfs");
                        d.mkdirs();
                        this.N = bb.e(Uri.fromFile(file).toString());
                        try {
                            file = new File(d, "chapters.bin");
                            File file2 = new File(d, "stuffs.bin");
                            String str = "file:///chapters";
                            str = "file:///stuffs";
                            this.N.a(file.getName(), Uri.fromFile(file).toString(), "file:///chapters");
                            this.N.a(file2.getName(), Uri.fromFile(file2).toString(), "file:///stuffs");
                        } catch (Throwable th) {
                        }
                    }
                    rVar = this.N;
                }
                return rVar;
            }

            private void bq() {
                synchronized (this.M) {
                    int i = this.O - 1;
                    this.O = i;
                    if (i == 0) {
                        this.N.c();
                        this.N = null;
                    }
                }
            }
        }
