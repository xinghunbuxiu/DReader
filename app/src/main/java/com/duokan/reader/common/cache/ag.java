package com.duokan.reader.common.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.duokan.core.p026a.C0285n;
import com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class ag {
    /* renamed from: a */
    private static String f1862a = "__ITEM_TABLE_";
    /* renamed from: b */
    private static String f1863b = "__INFO_TABLE__";
    /* renamed from: c */
    private static String f1864c = "__LISTCACHES__META__TABLE__";
    /* renamed from: d */
    private final C0285n f1865d;
    /* renamed from: e */
    private HashMap<String, String> f1866e = null;

    /* renamed from: a */
    private void m2531a(java.lang.String r6, java.util.Collection<com.duokan.reader.common.cache.C0584z> r7, boolean r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x005b in list [B:19:0x0056]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:60)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        if (r8 == 0) goto L_0x0007;
    L_0x0002:
        r0 = r5.f1865d;
        r0.m677b();
    L_0x0007:
        r1 = r7.iterator();	 Catch:{ all -> 0x0044 }
    L_0x000b:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x004d;	 Catch:{ all -> 0x0044 }
    L_0x0011:
        r0 = r1.next();	 Catch:{ all -> 0x0044 }
        r0 = (com.duokan.reader.common.cache.C0584z) r0;	 Catch:{ all -> 0x0044 }
        r2 = new android.content.ContentValues;	 Catch:{ all -> 0x0044 }
        r2.<init>();	 Catch:{ all -> 0x0044 }
        r3 = r0.f1907b;	 Catch:{ all -> 0x0044 }
        if (r3 == 0) goto L_0x0025;	 Catch:{ all -> 0x0044 }
    L_0x0020:
        r3 = r0.f1907b;	 Catch:{ all -> 0x0044 }
        r2.putAll(r3);	 Catch:{ all -> 0x0044 }
    L_0x0025:
        r3 = "__ITEM__KEY__";	 Catch:{ all -> 0x0044 }
        r4 = r0.f1906a;	 Catch:{ all -> 0x0044 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0044 }
        r3 = "__ITEM__VALUE__";	 Catch:{ all -> 0x0044 }
        r4 = r0.f1909d;	 Catch:{ all -> 0x0044 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0044 }
        r3 = "__ITEM__CORE__PROPERTIES__";	 Catch:{ all -> 0x0044 }
        r4 = r0.f1908c;	 Catch:{ all -> 0x0044 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0044 }
        r3 = r5.f1865d;	 Catch:{ all -> 0x0044 }
        r4 = 0;	 Catch:{ all -> 0x0044 }
        r2 = r3.m668a(r6, r4, r2);	 Catch:{ all -> 0x0044 }
        r0.f1910e = r2;	 Catch:{ all -> 0x0044 }
        goto L_0x000b;
    L_0x0044:
        r0 = move-exception;
        if (r8 == 0) goto L_0x004c;
    L_0x0047:
        r1 = r5.f1865d;
        r1.m678c();
    L_0x004c:
        throw r0;
    L_0x004d:
        if (r8 == 0) goto L_0x0054;
    L_0x004f:
        r0 = r5.f1865d;	 Catch:{ all -> 0x0044 }
        r0.m681f();	 Catch:{ all -> 0x0044 }
    L_0x0054:
        if (r8 == 0) goto L_0x005b;
    L_0x0056:
        r0 = r5.f1865d;
        r0.m678c();
    L_0x005b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.ag.a(java.lang.String, java.util.Collection, boolean):void");
    }

    /* renamed from: a */
    private void m2532a(java.lang.String r4, boolean r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x001c in list [B:7:0x0017]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:60)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        if (r5 == 0) goto L_0x0007;
    L_0x0002:
        r0 = r3.f1865d;
        r0.m677b();
    L_0x0007:
        r0 = r3.f1865d;	 Catch:{ all -> 0x001d }
        r1 = 0;	 Catch:{ all -> 0x001d }
        r2 = 0;	 Catch:{ all -> 0x001d }
        r0.m667a(r4, r1, r2);	 Catch:{ all -> 0x001d }
        if (r5 == 0) goto L_0x0015;	 Catch:{ all -> 0x001d }
    L_0x0010:
        r0 = r3.f1865d;	 Catch:{ all -> 0x001d }
        r0.m681f();	 Catch:{ all -> 0x001d }
    L_0x0015:
        if (r5 == 0) goto L_0x001c;
    L_0x0017:
        r0 = r3.f1865d;
        r0.m678c();
    L_0x001c:
        return;
    L_0x001d:
        r0 = move-exception;
        if (r5 == 0) goto L_0x0025;
    L_0x0020:
        r1 = r3.f1865d;
        r1.m678c();
    L_0x0025:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.ag.a(java.lang.String, boolean):void");
    }

    /* renamed from: b */
    private void m2535b(java.lang.String r8, java.util.Collection<com.duokan.reader.common.cache.C0584z> r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x005a in list [B:19:0x0055]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:60)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r7 = this;
        if (r10 == 0) goto L_0x0007;
    L_0x0002:
        r0 = r7.f1865d;
        r0.m677b();
    L_0x0007:
        r1 = r9.iterator();	 Catch:{ all -> 0x0043 }
    L_0x000b:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x004c;	 Catch:{ all -> 0x0043 }
    L_0x0011:
        r0 = r1.next();	 Catch:{ all -> 0x0043 }
        r0 = (com.duokan.reader.common.cache.C0584z) r0;	 Catch:{ all -> 0x0043 }
        r2 = new android.content.ContentValues;	 Catch:{ all -> 0x0043 }
        r2.<init>();	 Catch:{ all -> 0x0043 }
        r3 = r0.f1907b;	 Catch:{ all -> 0x0043 }
        if (r3 == 0) goto L_0x0025;	 Catch:{ all -> 0x0043 }
    L_0x0020:
        r3 = r0.f1907b;	 Catch:{ all -> 0x0043 }
        r2.putAll(r3);	 Catch:{ all -> 0x0043 }
    L_0x0025:
        r3 = "__ITEM__VALUE__";	 Catch:{ all -> 0x0043 }
        r4 = r0.f1909d;	 Catch:{ all -> 0x0043 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0043 }
        r3 = "__ITEM__CORE__PROPERTIES__";	 Catch:{ all -> 0x0043 }
        r4 = r0.f1908c;	 Catch:{ all -> 0x0043 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0043 }
        r3 = r7.f1865d;	 Catch:{ all -> 0x0043 }
        r4 = "__ITEM__KEY__=?";	 Catch:{ all -> 0x0043 }
        r5 = 1;	 Catch:{ all -> 0x0043 }
        r5 = new java.lang.String[r5];	 Catch:{ all -> 0x0043 }
        r6 = 0;	 Catch:{ all -> 0x0043 }
        r0 = r0.f1906a;	 Catch:{ all -> 0x0043 }
        r5[r6] = r0;	 Catch:{ all -> 0x0043 }
        r3.m666a(r8, r2, r4, r5);	 Catch:{ all -> 0x0043 }
        goto L_0x000b;
    L_0x0043:
        r0 = move-exception;
        if (r10 == 0) goto L_0x004b;
    L_0x0046:
        r1 = r7.f1865d;
        r1.m678c();
    L_0x004b:
        throw r0;
    L_0x004c:
        if (r10 == 0) goto L_0x0053;
    L_0x004e:
        r0 = r7.f1865d;	 Catch:{ all -> 0x0043 }
        r0.m681f();	 Catch:{ all -> 0x0043 }
    L_0x0053:
        if (r10 == 0) goto L_0x005a;
    L_0x0055:
        r0 = r7.f1865d;
        r0.m678c();
    L_0x005a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.ag.b(java.lang.String, java.util.Collection, boolean):void");
    }

    /* renamed from: c */
    private void m2539c(java.lang.String r7, java.util.Collection<java.lang.String> r8, boolean r9) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x003c in list [B:16:0x0037]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:60)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        if (r9 == 0) goto L_0x0007;
    L_0x0002:
        r0 = r6.f1865d;
        r0.m677b();
    L_0x0007:
        r1 = r8.iterator();	 Catch:{ all -> 0x0025 }
    L_0x000b:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x002e;	 Catch:{ all -> 0x0025 }
    L_0x0011:
        r0 = r1.next();	 Catch:{ all -> 0x0025 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0025 }
        r2 = r6.f1865d;	 Catch:{ all -> 0x0025 }
        r3 = "__ITEM__KEY__=?";	 Catch:{ all -> 0x0025 }
        r4 = 1;	 Catch:{ all -> 0x0025 }
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x0025 }
        r5 = 0;	 Catch:{ all -> 0x0025 }
        r4[r5] = r0;	 Catch:{ all -> 0x0025 }
        r2.m667a(r7, r3, r4);	 Catch:{ all -> 0x0025 }
        goto L_0x000b;
    L_0x0025:
        r0 = move-exception;
        if (r9 == 0) goto L_0x002d;
    L_0x0028:
        r1 = r6.f1865d;
        r1.m678c();
    L_0x002d:
        throw r0;
    L_0x002e:
        if (r9 == 0) goto L_0x0035;
    L_0x0030:
        r0 = r6.f1865d;	 Catch:{ all -> 0x0025 }
        r0.m681f();	 Catch:{ all -> 0x0025 }
    L_0x0035:
        if (r9 == 0) goto L_0x003c;
    L_0x0037:
        r0 = r6.f1865d;
        r0.m678c();
    L_0x003c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.ag.c(java.lang.String, java.util.Collection, boolean):void");
    }

    public ag(C0285n c0285n) {
        this.f1865d = c0285n;
    }

    /* renamed from: a */
    public synchronized void m2556a(String str, aa[] aaVarArr, ai[] aiVarArr) {
        m2528a();
        if (!this.f1866e.containsKey(str)) {
            m2546f(str);
            m2536b((String) this.f1866e.get(str), aaVarArr, aiVarArr);
        }
    }

    /* renamed from: a */
    public synchronized void m2553a(String str) {
        m2528a();
        m2549i(m2543e(str));
        m2548h(str);
        this.f1866e.remove(str);
    }

    /* renamed from: b */
    public synchronized int m2557b(String str) {
        int i;
        Object obj = null;
        synchronized (this) {
            m2528a();
            i = -1;
            Cursor g = m2547g(str);
            if (g != null) {
                try {
                    if (g.moveToFirst()) {
                        if (g.getColumnIndex("__INFO__VERSION__") >= 0) {
                            i = g.getInt(g.getColumnIndex("__INFO__VERSION__"));
                        } else {
                            i = 0;
                            int obj2 = 1;
                        }
                    }
                    g.close();
                    if (obj2 != null) {
                        m2545f();
                    }
                } catch (Throwable th) {
                    g.close();
                }
            }
        }
        return i;
    }

    /* renamed from: c */
    public synchronized String m2559c(String str) {
        String str2;
        m2528a();
        str2 = null;
        Cursor g = m2547g(str);
        if (g != null) {
            try {
                if (g.moveToFirst()) {
                    str2 = g.getString(g.getColumnIndex("__INFO__VALUE__"));
                }
                g.close();
            } catch (Throwable th) {
                g.close();
            }
        }
        return str2;
    }

    /* renamed from: a */
    public synchronized Collection<String> m2551a(String str, ah ahVar, ai[] aiVarArr, C0582t c0582t) {
        Collection linkedList;
        m2528a();
        linkedList = new LinkedList();
        Cursor a = m2526a(m2543e(str), aiVarArr, ahVar, c0582t, "__ITEM__KEY__");
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    do {
                        linkedList.add(a.getString(0));
                    } while (a.moveToNext());
                }
                a.close();
            } catch (Throwable th) {
                a.close();
            }
        }
        return linkedList;
    }

    /* renamed from: b */
    public synchronized Collection<C0584z> m2558b(String str, ah ahVar, ai[] aiVarArr, C0582t c0582t) {
        Collection linkedList;
        m2528a();
        linkedList = new LinkedList();
        Cursor a = m2526a(m2543e(str), aiVarArr, ahVar, c0582t, "__ITEM__KEY__, __ITEM__VALUE__, rowid");
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    do {
                        C0584z c0584z = new C0584z();
                        c0584z.f1906a = a.getString(0);
                        c0584z.f1909d = a.getString(1);
                        c0584z.f1910e = a.getLong(2);
                        linkedList.add(c0584z);
                    } while (a.moveToNext());
                }
                a.close();
            } catch (Throwable th) {
                a.close();
            }
        }
        return linkedList;
    }

    /* renamed from: c */
    public synchronized Collection<C0584z> m2560c(String str, ah ahVar, ai[] aiVarArr, C0582t c0582t) {
        Collection linkedList;
        m2528a();
        linkedList = new LinkedList();
        Cursor a = m2526a(m2543e(str), aiVarArr, ahVar, c0582t, "__ITEM__KEY__, __ITEM__CORE__PROPERTIES__, rowid");
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    do {
                        C0584z c0584z = new C0584z();
                        c0584z.f1906a = a.getString(0);
                        c0584z.f1908c = a.getString(1);
                        c0584z.f1910e = a.getLong(2);
                        linkedList.add(c0584z);
                    } while (a.moveToNext());
                }
                a.close();
            } catch (Throwable th) {
                a.close();
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    public synchronized Collection<String> m2552a(String str, ai[] aiVarArr, int i) {
        Collection linkedList;
        m2528a();
        ai[] aiVarArr2 = (aiVarArr == null || aiVarArr.length == 0) ? new ai[]{new ai("rowid", false)} : aiVarArr;
        linkedList = new LinkedList();
        Cursor a = m2527a(m2543e(str), aiVarArr2, null, new C0582t(i, 0), true);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    do {
                        linkedList.add(a.getString(a.getColumnIndex("__ITEM__KEY__")));
                    } while (a.moveToNext());
                }
                a.close();
            } catch (Throwable th) {
                a.close();
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    public synchronized C0584z m2550a(String str, String str2) {
        C0584z c0584z;
        m2528a();
        c0584z = null;
        Cursor c = m2537c(m2543e(str), str2);
        if (c != null) {
            try {
                if (c.moveToFirst()) {
                    c0584z = new C0584z();
                    c0584z.f1906a = c.getString(c.getColumnIndex("__ITEM__KEY__"));
                    c0584z.f1909d = c.getString(c.getColumnIndex("__ITEM__VALUE__"));
                    c0584z.f1910e = c.getLong(c.getColumnIndex("rowid"));
                }
                c.close();
            } catch (Throwable th) {
                c.close();
            }
        }
        return c0584z;
    }

    /* renamed from: a */
    public synchronized void m2555a(String str, Collection<String> collection) {
        m2528a();
        m2539c(m2543e(str), collection, true);
    }

    /* renamed from: a */
    public synchronized void m2554a(String str, ArrayList<C0583x> arrayList) {
        m2528a();
        String e = m2543e(str);
        this.f1865d.m677b();
        try {
            Collection arrayList2 = new ArrayList(1);
            Collection arrayList3 = new ArrayList(1);
            for (int i = 0; i < arrayList.size(); i++) {
                C0583x c0583x = (C0583x) arrayList.get(i);
                if (c0583x.f1902a == ListCacheStoreChangeType.UpdateVersion) {
                    int b = m2557b(str);
                    if (b >= 0 && b < c0583x.f1905d) {
                        m2530a(str, c0583x.f1905d);
                    }
                } else if (c0583x.f1902a == ListCacheStoreChangeType.UpdateInfo) {
                    m2534b(str, c0583x.f1904c);
                } else if (c0583x.f1902a == ListCacheStoreChangeType.ClearItems) {
                    m2532a(e, false);
                } else if (c0583x.f1902a == ListCacheStoreChangeType.DeleteItem) {
                    arrayList3.add(c0583x.f1903b.f1906a);
                    m2539c(e, arrayList3, false);
                } else if (c0583x.f1902a == ListCacheStoreChangeType.SaveItem) {
                    arrayList2.add(c0583x.f1903b);
                    if (m2542d(e, c0583x.f1903b.f1906a)) {
                        m2535b(e, arrayList2, false);
                    } else {
                        m2531a(e, arrayList2, false);
                    }
                }
                arrayList2.clear();
                arrayList3.clear();
            }
            this.f1865d.m681f();
            this.f1865d.m678c();
        } catch (Throwable th) {
            this.f1865d.m678c();
        }
    }

    /* renamed from: a */
    private void m2528a() {
        int i = 0;
        if (this.f1866e == null) {
            String str;
            HashSet b = m2533b();
            if (!b.contains(f1864c)) {
                m2538c();
            }
            if (!b.contains(f1863b)) {
                m2544e();
            }
            HashMap hashMap = new HashMap();
            Cursor a = this.f1865d.m670a("SELECT * FROM " + f1863b, new String[0]);
            if (a != null) {
                if (a.getColumnIndex("__INFO__VERSION__") < 0) {
                    i = 1;
                }
                try {
                    if (a.moveToFirst()) {
                        do {
                            hashMap.put(a.getString(a.getColumnIndex("__INFO__KEY__")), a.getString(a.getColumnIndex("__INFO_ITEM_TABLE_NAME__")));
                        } while (a.moveToNext());
                    }
                    a.close();
                    if (i != 0) {
                        m2545f();
                    }
                } catch (Throwable th) {
                    a.close();
                }
            }
            ArrayList arrayList = new ArrayList();
            for (String str2 : hashMap.keySet()) {
                if (!b.contains((String) hashMap.get(str2))) {
                    arrayList.add(str2);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                hashMap.remove(str2);
                m2548h(str2);
            }
            this.f1866e = hashMap;
            if (m2540d() < 2) {
                for (String str22 : this.f1866e.values()) {
                    m2541d(str22);
                }
                m2529a(2);
            }
        }
    }

    /* renamed from: d */
    private void m2541d(String str) {
        this.f1865d.m677b();
        try {
            this.f1865d.m673a(String.format("ALTER TABLE %s ADD COLUMN %s TEXT", new Object[]{str, "__ITEM__CORE__PROPERTIES__"}));
            this.f1865d.m681f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.f1865d.m678c();
        }
    }

    /* renamed from: b */
    private HashSet<String> m2533b() {
        HashSet<String> hashSet = new HashSet();
        Cursor a = this.f1865d.m670a("SELECT name FROM sqlite_master WHERE type='table'", new String[0]);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    do {
                        hashSet.add(a.getString(0));
                    } while (a.moveToNext());
                }
                a.close();
            } catch (Throwable th) {
                a.close();
            }
        }
        return hashSet;
    }

    /* renamed from: e */
    private String m2543e(String str) {
        m2528a();
        String str2 = (String) this.f1866e.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = f1862a + currentTimeMillis;
        long j = currentTimeMillis;
        while (true) {
            Object obj;
            for (String str22 : this.f1866e.values()) {
                if (str22.equals(str3)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                currentTimeMillis = 7 + j;
                str3 = f1862a + currentTimeMillis;
                j = currentTimeMillis;
            } else {
                this.f1866e.put(str, str3);
                return str3;
            }
        }
    }

    /* renamed from: c */
    private void m2538c() {
        this.f1865d.m677b();
        try {
            this.f1865d.m673a(String.format("CREATE TABLE IF NOT EXISTS %s( %s INTEGER DEFAULT 0);", new Object[]{f1864c, "__LIST__CACHES__VERSION__"}));
            this.f1865d.m681f();
        } finally {
            this.f1865d.m678c();
        }
    }

    /* renamed from: d */
    private int m2540d() {
        int i = 0;
        Cursor a = this.f1865d.m670a("SELECT __LIST__CACHES__VERSION__ FROM " + f1864c, new String[0]);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    i = a.getInt(0);
                } else {
                    a.close();
                }
            } finally {
                a.close();
            }
        }
        return i;
    }

    /* renamed from: a */
    private void m2529a(int i) {
        this.f1865d.m677b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("__LIST__CACHES__VERSION__", Integer.valueOf(i));
            if (this.f1865d.m666a(f1864c, contentValues, null, null) <= 0) {
                this.f1865d.m668a(f1864c, null, contentValues);
            }
            this.f1865d.m681f();
        } finally {
            this.f1865d.m678c();
        }
    }

    /* renamed from: e */
    private void m2544e() {
        this.f1865d.m677b();
        try {
            this.f1865d.m673a(String.format("CREATE TABLE IF NOT EXISTS %s( %s TEXT PRIMARY KEY,  %s TEXT,  %s TEXT,  %s INTEGER DEFAULT 0);", new Object[]{f1863b, "__INFO__KEY__", "__INFO_ITEM_TABLE_NAME__", "__INFO__VALUE__", "__INFO__VERSION__"}));
            this.f1865d.m681f();
        } finally {
            this.f1865d.m678c();
        }
    }

    /* renamed from: f */
    private void m2546f(String str) {
        String e = m2543e(str);
        this.f1865d.m677b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("__INFO__KEY__", str);
            contentValues.put("__INFO_ITEM_TABLE_NAME__", e);
            contentValues.put("__INFO__VALUE__", "");
            contentValues.put("__INFO__VERSION__", Integer.valueOf(0));
            this.f1865d.m668a(f1863b, null, contentValues);
            this.f1865d.m681f();
        } finally {
            this.f1865d.m678c();
        }
    }

    /* renamed from: f */
    private void m2545f() {
        this.f1865d.m677b();
        try {
            this.f1865d.m673a(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT 0", new Object[]{f1863b, "__INFO__VERSION__"}));
            this.f1865d.m681f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.f1865d.m678c();
        }
    }

    /* renamed from: g */
    private Cursor m2547g(String str) {
        String str2 = "SELECT * FROM " + f1863b + " WHERE " + "__INFO__KEY__" + "=?";
        return this.f1865d.m670a(str2, new String[]{str});
    }

    /* renamed from: a */
    private void m2530a(String str, int i) {
        this.f1865d.m677b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("__INFO__VERSION__", Integer.valueOf(i));
            this.f1865d.m666a(f1863b, contentValues, "__INFO__KEY__=?", new String[]{str});
            this.f1865d.m681f();
        } finally {
            this.f1865d.m678c();
        }
    }

    /* renamed from: b */
    private void m2534b(String str, String str2) {
        this.f1865d.m677b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("__INFO__VALUE__", str2);
            this.f1865d.m666a(f1863b, contentValues, "__INFO__KEY__=?", new String[]{str});
            this.f1865d.m681f();
        } finally {
            this.f1865d.m678c();
        }
    }

    /* renamed from: h */
    private void m2548h(String str) {
        this.f1865d.m677b();
        try {
            this.f1865d.m667a(f1863b, "__INFO__KEY__=?", new String[]{str});
            this.f1865d.m681f();
        } finally {
            this.f1865d.m678c();
        }
    }

    /* renamed from: b */
    private void m2536b(String str, aa[] aaVarArr, ai[] aiVarArr) {
        this.f1865d.m677b();
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("__ITEM__KEY__ TEXT PRIMARY KEY, ");
            stringBuilder.append("__ITEM__VALUE__ TEXT, ");
            stringBuilder.append("__ITEM__CORE__PROPERTIES__ TEXT");
            if (aaVarArr != null && aaVarArr.length > 0) {
                for (aa aaVar : aaVarArr) {
                    if (!aaVar.f1854a.equalsIgnoreCase("rowid")) {
                        stringBuilder.append(", ");
                        stringBuilder.append(aaVar.f1854a);
                        stringBuilder.append(" ");
                        stringBuilder.append(aaVar.f1855b);
                    }
                }
            }
            this.f1865d.m673a(String.format("CREATE TABLE IF NOT EXISTS %s(%s);", new Object[]{str, stringBuilder.toString()}));
            if (aiVarArr != null && aiVarArr.length > 0) {
                for (ai aiVar : aiVarArr) {
                    if (!(aiVar == null || aiVar.f1869a.equalsIgnoreCase("rowid"))) {
                        String str2 = "CREATE INDEX IF NOT EXISTS %s ON %s (%s);";
                        Object[] objArr = new Object[3];
                        objArr[0] = str + "_index_on_" + aiVar.f1869a;
                        objArr[1] = str;
                        objArr[2] = aiVar.f1869a + (aiVar.f1870b ? " ASC" : " DESC");
                        this.f1865d.m673a(String.format(str2, objArr));
                    }
                }
            }
            this.f1865d.m681f();
        } finally {
            this.f1865d.m678c();
        }
    }

    /* renamed from: i */
    private void m2549i(String str) {
        this.f1865d.m677b();
        try {
            this.f1865d.m673a(String.format("DROP TABLE IF EXISTS %s", new Object[]{str}));
            this.f1865d.m681f();
        } finally {
            this.f1865d.m678c();
        }
    }

    /* renamed from: a */
    private Cursor m2527a(String str, ai[] aiVarArr, ah ahVar, C0582t c0582t, boolean z) {
        return m2526a(str, aiVarArr, ahVar, c0582t, z ? "__ITEM__KEY__" : "*, rowid");
    }

    /* renamed from: a */
    private Cursor m2526a(String str, ai[] aiVarArr, ah ahVar, C0582t c0582t, String str2) {
        String[] strArr;
        Object obj;
        String str3;
        Object obj2;
        Object valueOf;
        if (ahVar == null) {
            Object obj3 = null;
        } else {
            String obj32 = ahVar.f1867a;
        }
        String[] strArr2 = ahVar == null ? null : ahVar.f1868b;
        if (strArr2 == null) {
            strArr = new String[0];
        } else {
            strArr = strArr2;
        }
        if (aiVarArr == null || aiVarArr.length <= 0) {
            obj = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < aiVarArr.length; i++) {
                if (i > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(aiVarArr[i].f1869a);
                stringBuilder.append(" ");
                if (aiVarArr[i].f1870b) {
                    str3 = "ASC";
                } else {
                    str3 = "DESC";
                }
                stringBuilder.append(str3);
            }
            obj = stringBuilder.toString();
        }
        if (c0582t != null) {
            String valueOf2;
            if (c0582t.f1901b > 0) {
                valueOf2 = String.valueOf(c0582t.f1901b);
            } else {
                valueOf2 = String.valueOf(Integer.MAX_VALUE);
            }
            if (c0582t.f1900a >= 0) {
                obj2 = valueOf2;
                valueOf = String.valueOf(c0582t.f1900a);
            } else {
                str3 = valueOf2;
                valueOf = null;
            }
        } else {
            obj2 = null;
            valueOf = null;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("SELECT %s FROM ", new Object[]{str2}) + str);
        if (!TextUtils.isEmpty(obj32)) {
            stringBuilder2.append(" WHERE " + obj32);
        }
        if (!TextUtils.isEmpty(obj)) {
            stringBuilder2.append(" ORDER BY " + obj);
        }
        if (!TextUtils.isEmpty(obj2)) {
            stringBuilder2.append(" LIMIT " + obj2);
        }
        if (!TextUtils.isEmpty(valueOf)) {
            stringBuilder2.append(" OFFSET " + valueOf);
        }
        return this.f1865d.m670a(stringBuilder2.toString(), strArr);
    }

    /* renamed from: c */
    private Cursor m2537c(String str, String str2) {
        String str3 = "SELECT *, rowid FROM " + str + " WHERE " + "__ITEM__KEY__" + "=?";
        return this.f1865d.m670a(str3, new String[]{str2});
    }

    /* renamed from: d */
    private boolean m2542d(String str, String str2) {
        boolean z = true;
        String str3 = "SELECT rowid FROM " + str + " WHERE " + "__ITEM__KEY__" + "=?";
        Cursor a = this.f1865d.m670a(str3, new String[]{str2});
        if (a == null) {
            return false;
        }
        try {
            if (a.getCount() <= 0) {
                z = false;
            }
            a.close();
            return z;
        } catch (Throwable th) {
            a.close();
        }
    }
}
