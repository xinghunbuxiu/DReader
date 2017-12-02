package com.duokan.reader.common.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;

import com.duokan.core.a.n;
import com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class ag {
    private static String a = "__ITEM_TABLE_";
    private static String b = "__INFO_TABLE__";
    private static String c = "__LISTCACHES__META__TABLE__";
    private final n d;
    private HashMap e = null;

    private void a(java.lang.String r6, java.util.Collection r7, boolean r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x005b in list [B:19:0x0056]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        if (r8 == 0) goto L_0x0007;
    L_0x0002:
        r0 = r5.d;
        r0.b();
    L_0x0007:
        r1 = r7.iterator();	 Catch:{ all -> 0x0044 }
    L_0x000b:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x004d;	 Catch:{ all -> 0x0044 }
    L_0x0011:
        r0 = r1.next();	 Catch:{ all -> 0x0044 }
        r0 = (com.duokan.reader.common.cache.z) r0;	 Catch:{ all -> 0x0044 }
        r2 = new android.content.ContentValues;	 Catch:{ all -> 0x0044 }
        r2.<init>();	 Catch:{ all -> 0x0044 }
        r3 = r0.b;	 Catch:{ all -> 0x0044 }
        if (r3 == 0) goto L_0x0025;	 Catch:{ all -> 0x0044 }
    L_0x0020:
        r3 = r0.b;	 Catch:{ all -> 0x0044 }
        r2.putAll(r3);	 Catch:{ all -> 0x0044 }
    L_0x0025:
        r3 = "__ITEM__KEY__";	 Catch:{ all -> 0x0044 }
        r4 = r0.a;	 Catch:{ all -> 0x0044 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0044 }
        r3 = "__ITEM__VALUE__";	 Catch:{ all -> 0x0044 }
        r4 = r0.d;	 Catch:{ all -> 0x0044 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0044 }
        r3 = "__ITEM__CORE__PROPERTIES__";	 Catch:{ all -> 0x0044 }
        r4 = r0.c;	 Catch:{ all -> 0x0044 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0044 }
        r3 = r5.d;	 Catch:{ all -> 0x0044 }
        r4 = 0;	 Catch:{ all -> 0x0044 }
        r2 = r3.a(r6, r4, r2);	 Catch:{ all -> 0x0044 }
        r0.e = r2;	 Catch:{ all -> 0x0044 }
        goto L_0x000b;
    L_0x0044:
        r0 = move-exception;
        if (r8 == 0) goto L_0x004c;
    L_0x0047:
        r1 = r5.d;
        r1.c();
    L_0x004c:
        throw r0;
    L_0x004d:
        if (r8 == 0) goto L_0x0054;
    L_0x004f:
        r0 = r5.d;	 Catch:{ all -> 0x0044 }
        r0.f();	 Catch:{ all -> 0x0044 }
    L_0x0054:
        if (r8 == 0) goto L_0x005b;
    L_0x0056:
        r0 = r5.d;
        r0.c();
    L_0x005b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.ag.a(java.lang.String, java.util.Collection, boolean):void");
    }

    private void a(java.lang.String r4, boolean r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x001c in list [B:7:0x0017]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        if (r5 == 0) goto L_0x0007;
    L_0x0002:
        r0 = r3.d;
        r0.b();
    L_0x0007:
        r0 = r3.d;	 Catch:{ all -> 0x001d }
        r1 = 0;	 Catch:{ all -> 0x001d }
        r2 = 0;	 Catch:{ all -> 0x001d }
        r0.a(r4, r1, r2);	 Catch:{ all -> 0x001d }
        if (r5 == 0) goto L_0x0015;	 Catch:{ all -> 0x001d }
    L_0x0010:
        r0 = r3.d;	 Catch:{ all -> 0x001d }
        r0.f();	 Catch:{ all -> 0x001d }
    L_0x0015:
        if (r5 == 0) goto L_0x001c;
    L_0x0017:
        r0 = r3.d;
        r0.c();
    L_0x001c:
        return;
    L_0x001d:
        r0 = move-exception;
        if (r5 == 0) goto L_0x0025;
    L_0x0020:
        r1 = r3.d;
        r1.c();
    L_0x0025:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.ag.a(java.lang.String, boolean):void");
    }

    private void b(java.lang.String r8, java.util.Collection r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x005a in list [B:19:0x0055]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r7 = this;
        if (r10 == 0) goto L_0x0007;
    L_0x0002:
        r0 = r7.d;
        r0.b();
    L_0x0007:
        r1 = r9.iterator();	 Catch:{ all -> 0x0043 }
    L_0x000b:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x004c;	 Catch:{ all -> 0x0043 }
    L_0x0011:
        r0 = r1.next();	 Catch:{ all -> 0x0043 }
        r0 = (com.duokan.reader.common.cache.z) r0;	 Catch:{ all -> 0x0043 }
        r2 = new android.content.ContentValues;	 Catch:{ all -> 0x0043 }
        r2.<init>();	 Catch:{ all -> 0x0043 }
        r3 = r0.b;	 Catch:{ all -> 0x0043 }
        if (r3 == 0) goto L_0x0025;	 Catch:{ all -> 0x0043 }
    L_0x0020:
        r3 = r0.b;	 Catch:{ all -> 0x0043 }
        r2.putAll(r3);	 Catch:{ all -> 0x0043 }
    L_0x0025:
        r3 = "__ITEM__VALUE__";	 Catch:{ all -> 0x0043 }
        r4 = r0.d;	 Catch:{ all -> 0x0043 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0043 }
        r3 = "__ITEM__CORE__PROPERTIES__";	 Catch:{ all -> 0x0043 }
        r4 = r0.c;	 Catch:{ all -> 0x0043 }
        r2.put(r3, r4);	 Catch:{ all -> 0x0043 }
        r3 = r7.d;	 Catch:{ all -> 0x0043 }
        r4 = "__ITEM__KEY__=?";	 Catch:{ all -> 0x0043 }
        r5 = 1;	 Catch:{ all -> 0x0043 }
        r5 = new java.lang.String[r5];	 Catch:{ all -> 0x0043 }
        r6 = 0;	 Catch:{ all -> 0x0043 }
        r0 = r0.a;	 Catch:{ all -> 0x0043 }
        r5[r6] = r0;	 Catch:{ all -> 0x0043 }
        r3.a(r8, r2, r4, r5);	 Catch:{ all -> 0x0043 }
        goto L_0x000b;
    L_0x0043:
        r0 = move-exception;
        if (r10 == 0) goto L_0x004b;
    L_0x0046:
        r1 = r7.d;
        r1.c();
    L_0x004b:
        throw r0;
    L_0x004c:
        if (r10 == 0) goto L_0x0053;
    L_0x004e:
        r0 = r7.d;	 Catch:{ all -> 0x0043 }
        r0.f();	 Catch:{ all -> 0x0043 }
    L_0x0053:
        if (r10 == 0) goto L_0x005a;
    L_0x0055:
        r0 = r7.d;
        r0.c();
    L_0x005a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.ag.b(java.lang.String, java.util.Collection, boolean):void");
    }

    private void c(java.lang.String r7, java.util.Collection r8, boolean r9) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x003c in list [B:16:0x0037]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        if (r9 == 0) goto L_0x0007;
    L_0x0002:
        r0 = r6.d;
        r0.b();
    L_0x0007:
        r1 = r8.iterator();	 Catch:{ all -> 0x0025 }
    L_0x000b:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x002e;	 Catch:{ all -> 0x0025 }
    L_0x0011:
        r0 = r1.next();	 Catch:{ all -> 0x0025 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0025 }
        r2 = r6.d;	 Catch:{ all -> 0x0025 }
        r3 = "__ITEM__KEY__=?";	 Catch:{ all -> 0x0025 }
        r4 = 1;	 Catch:{ all -> 0x0025 }
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x0025 }
        r5 = 0;	 Catch:{ all -> 0x0025 }
        r4[r5] = r0;	 Catch:{ all -> 0x0025 }
        r2.a(r7, r3, r4);	 Catch:{ all -> 0x0025 }
        goto L_0x000b;
    L_0x0025:
        r0 = move-exception;
        if (r9 == 0) goto L_0x002d;
    L_0x0028:
        r1 = r6.d;
        r1.c();
    L_0x002d:
        throw r0;
    L_0x002e:
        if (r9 == 0) goto L_0x0035;
    L_0x0030:
        r0 = r6.d;	 Catch:{ all -> 0x0025 }
        r0.f();	 Catch:{ all -> 0x0025 }
    L_0x0035:
        if (r9 == 0) goto L_0x003c;
    L_0x0037:
        r0 = r6.d;
        r0.c();
    L_0x003c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.ag.c(java.lang.String, java.util.Collection, boolean):void");
    }

    public ag(n nVar) {
        this.d = nVar;
    }

    public synchronized void a(String str, aa[] aaVarArr, ai[] aiVarArr) {
        a();
        if (!this.e.containsKey(str)) {
            f(str);
            b((String) this.e.get(str), aaVarArr, aiVarArr);
        }
    }

    public synchronized void a(String str) {
        a();
        i(e(str));
        h(str);
        this.e.remove(str);
    }

    public synchronized int b(String str) {
        int i;
        Object obj = null;
        synchronized (this) {
            a();
            i = -1;
            Cursor g = g(str);
            if (g != null) {
                try {
                    if (g.moveToFirst()) {
                        if (g.getColumnIndex("__INFO__VERSION__") >= 0) {
                            i = g.getInt(g.getColumnIndex("__INFO__VERSION__"));
                        } else {
                            i = 0;
                            int i2 = 1;
                        }
                    }
                    g.close();
                    if (obj != null) {
                        f();
                    }
                } catch (Throwable th) {
                    g.close();
                }
            }
        }
        return i;
    }

    public synchronized String c(String str) {
        String str2;
        a();
        str2 = null;
        Cursor g = g(str);
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

    public synchronized Collection a(String str, ah ahVar, ai[] aiVarArr, t tVar) {
        Collection linkedList;
        a();
        linkedList = new LinkedList();
        Cursor a = a(e(str), aiVarArr, ahVar, tVar, "__ITEM__KEY__");
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

    public synchronized Collection b(String str, ah ahVar, ai[] aiVarArr, t tVar) {
        Collection linkedList;
        a();
        linkedList = new LinkedList();
        Cursor a = a(e(str), aiVarArr, ahVar, tVar, "__ITEM__KEY__, __ITEM__VALUE__, rowid");
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    do {
                        z zVar = new z();
                        zVar.a = a.getString(0);
                        zVar.d = a.getString(1);
                        zVar.e = a.getLong(2);
                        linkedList.add(zVar);
                    } while (a.moveToNext());
                }
                a.close();
            } catch (Throwable th) {
                a.close();
            }
        }
        return linkedList;
    }

    public synchronized Collection c(String str, ah ahVar, ai[] aiVarArr, t tVar) {
        Collection linkedList;
        a();
        linkedList = new LinkedList();
        Cursor a = a(e(str), aiVarArr, ahVar, tVar, "__ITEM__KEY__, __ITEM__CORE__PROPERTIES__, rowid");
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    do {
                        z zVar = new z();
                        zVar.a = a.getString(0);
                        zVar.c = a.getString(1);
                        zVar.e = a.getLong(2);
                        linkedList.add(zVar);
                    } while (a.moveToNext());
                }
                a.close();
            } catch (Throwable th) {
                a.close();
            }
        }
        return linkedList;
    }

    public synchronized Collection a(String str, ai[] aiVarArr, int i) {
        Collection linkedList;
        a();
        ai[] aiVarArr2 = (aiVarArr == null || aiVarArr.length == 0) ? new ai[]{new ai("rowid", false)} : aiVarArr;
        linkedList = new LinkedList();
        Cursor a = a(e(str), aiVarArr2, null, new t(i, 0), true);
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

    public synchronized z a(String str, String str2) {
        z zVar;
        a();
        zVar = null;
        Cursor c = c(e(str), str2);
        if (c != null) {
            try {
                if (c.moveToFirst()) {
                    zVar = new z();
                    zVar.a = c.getString(c.getColumnIndex("__ITEM__KEY__"));
                    zVar.d = c.getString(c.getColumnIndex("__ITEM__VALUE__"));
                    zVar.e = c.getLong(c.getColumnIndex("rowid"));
                }
                c.close();
            } catch (Throwable th) {
                c.close();
            }
        }
        return zVar;
    }

    public synchronized void a(String str, Collection collection) {
        a();
        c(e(str), collection, true);
    }

    public synchronized void a(String str, ArrayList arrayList) {
        a();
        String e = e(str);
        this.d.b();
        try {
            Collection arrayList2 = new ArrayList(1);
            Collection arrayList3 = new ArrayList(1);
            for (int i = 0; i < arrayList.size(); i++) {
                x xVar = (x) arrayList.get(i);
                if (xVar.a == ListCacheStoreChangeType.UpdateVersion) {
                    int b = b(str);
                    if (b >= 0 && b < xVar.d) {
                        a(str, xVar.d);
                    }
                } else if (xVar.a == ListCacheStoreChangeType.UpdateInfo) {
                    b(str, xVar.c);
                } else if (xVar.a == ListCacheStoreChangeType.ClearItems) {
                    a(e, false);
                } else if (xVar.a == ListCacheStoreChangeType.DeleteItem) {
                    arrayList3.add(xVar.b.a);
                    c(e, arrayList3, false);
                } else if (xVar.a == ListCacheStoreChangeType.SaveItem) {
                    arrayList2.add(xVar.b);
                    if (d(e, xVar.b.a)) {
                        b(e, arrayList2, false);
                    } else {
                        a(e, arrayList2, false);
                    }
                }
                arrayList2.clear();
                arrayList3.clear();
            }
            this.d.f();
            this.d.c();
        } catch (Throwable th) {
            this.d.c();
        }
    }

    private void a() {
        int i = 0;
        if (this.e == null) {
            String str;
            HashSet b = b();
            if (!b.contains(c)) {
                c();
            }
            if (!b.contains(b)) {
                e();
            }
            HashMap hashMap = new HashMap();
            Cursor a = this.d.a("SELECT * FROM " + b, new String[0]);
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
                        f();
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
                h(str2);
            }
            this.e = hashMap;
            if (d() < 2) {
                for (String str22 : this.e.values()) {
                    d(str22);
                }
                a(2);
            }
        }
    }

    private void d(String str) {
        this.d.b();
        try {
            this.d.a(String.format("ALTER TABLE %s ADD COLUMN %s TEXT", new Object[]{str, "__ITEM__CORE__PROPERTIES__"}));
            this.d.f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.d.c();
        }
    }

    private HashSet b() {
        HashSet hashSet = new HashSet();
        Cursor a = this.d.a("SELECT name FROM sqlite_master WHERE type='table'", new String[0]);
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

    private String e(String str) {
        a();
        String str2 = (String) this.e.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = a + currentTimeMillis;
        long j = currentTimeMillis;
        while (true) {
            Object obj;
            for (String str22 : this.e.values()) {
                if (str22.equals(str3)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                currentTimeMillis = 7 + j;
                str3 = a + currentTimeMillis;
                j = currentTimeMillis;
            } else {
                this.e.put(str, str3);
                return str3;
            }
        }
    }

    private void c() {
        this.d.b();
        try {
            this.d.a(String.format("CREATE TABLE IF NOT EXISTS %s( %s INTEGER DEFAULT 0);", new Object[]{c, "__LIST__CACHES__VERSION__"}));
            this.d.f();
        } finally {
            this.d.c();
        }
    }

    private int d() {
        int i = 0;
        Cursor a = this.d.a("SELECT __LIST__CACHES__VERSION__ FROM " + c, new String[0]);
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

    private void a(int i) {
        this.d.b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("__LIST__CACHES__VERSION__", Integer.valueOf(i));
            if (this.d.a(c, contentValues, null, null) <= 0) {
                this.d.a(c, null, contentValues);
            }
            this.d.f();
        } finally {
            this.d.c();
        }
    }

    private void e() {
        this.d.b();
        try {
            this.d.a(String.format("CREATE TABLE IF NOT EXISTS %s( %s TEXT PRIMARY KEY,  %s TEXT,  %s TEXT,  %s INTEGER DEFAULT 0);", new Object[]{b, "__INFO__KEY__", "__INFO_ITEM_TABLE_NAME__", "__INFO__VALUE__", "__INFO__VERSION__"}));
            this.d.f();
        } finally {
            this.d.c();
        }
    }

    private void f(String str) {
        String e = e(str);
        this.d.b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("__INFO__KEY__", str);
            contentValues.put("__INFO_ITEM_TABLE_NAME__", e);
            contentValues.put("__INFO__VALUE__", "");
            contentValues.put("__INFO__VERSION__", Integer.valueOf(0));
            this.d.a(b, null, contentValues);
            this.d.f();
        } finally {
            this.d.c();
        }
    }

    private void f() {
        this.d.b();
        try {
            this.d.a(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT 0", new Object[]{b, "__INFO__VERSION__"}));
            this.d.f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.d.c();
        }
    }

    private Cursor g(String str) {
        String str2 = "SELECT * FROM " + b + " WHERE " + "__INFO__KEY__" + "=?";
        return this.d.a(str2, new String[]{str});
    }

    private void a(String str, int i) {
        this.d.b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("__INFO__VERSION__", Integer.valueOf(i));
            this.d.a(b, contentValues, "__INFO__KEY__=?", new String[]{str});
            this.d.f();
        } finally {
            this.d.c();
        }
    }

    private void b(String str, String str2) {
        this.d.b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("__INFO__VALUE__", str2);
            this.d.a(b, contentValues, "__INFO__KEY__=?", new String[]{str});
            this.d.f();
        } finally {
            this.d.c();
        }
    }

    private void h(String str) {
        this.d.b();
        try {
            this.d.a(b, "__INFO__KEY__=?", new String[]{str});
            this.d.f();
        } finally {
            this.d.c();
        }
    }

    private void b(String str, aa[] aaVarArr, ai[] aiVarArr) {
        this.d.b();
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("__ITEM__KEY__ TEXT PRIMARY KEY, ");
            stringBuilder.append("__ITEM__VALUE__ TEXT, ");
            stringBuilder.append("__ITEM__CORE__PROPERTIES__ TEXT");
            if (aaVarArr != null && aaVarArr.length > 0) {
                for (aa aaVar : aaVarArr) {
                    if (!aaVar.a.equalsIgnoreCase("rowid")) {
                        stringBuilder.append(", ");
                        stringBuilder.append(aaVar.a);
                        stringBuilder.append(" ");
                        stringBuilder.append(aaVar.b);
                    }
                }
            }
            this.d.a(String.format("CREATE TABLE IF NOT EXISTS %s(%s);", new Object[]{str, stringBuilder.toString()}));
            if (aiVarArr != null && aiVarArr.length > 0) {
                for (ai aiVar : aiVarArr) {
                    if (!(aiVar == null || aiVar.a.equalsIgnoreCase("rowid"))) {
                        String str2 = "CREATE INDEX IF NOT EXISTS %s ON %s (%s);";
                        Object[] objArr = new Object[3];
                        objArr[0] = str + "_index_on_" + aiVar.a;
                        objArr[1] = str;
                        objArr[2] = aiVar.a + (aiVar.b ? " ASC" : " DESC");
                        this.d.a(String.format(str2, objArr));
                    }
                }
            }
            this.d.f();
        } finally {
            this.d.c();
        }
    }

    private void i(String str) {
        this.d.b();
        try {
            this.d.a(String.format("DROP TABLE IF EXISTS %s", new Object[]{str}));
            this.d.f();
        } finally {
            this.d.c();
        }
    }

    private Cursor a(String str, ai[] aiVarArr, ah ahVar, t tVar, boolean z) {
        return a(str, aiVarArr, ahVar, tVar, z ? "__ITEM__KEY__" : "*, rowid");
    }

    private Cursor a(String str, ai[] aiVarArr, ah ahVar, t tVar, String str2) {
        String[] strArr;
        Object obj;
        String str3;
        Object obj2;
        Object valueOf;
        if (ahVar == null) {
            Object obj3 = null;
        } else {
            String str4 = ahVar.a;
        }
        String[] strArr2 = ahVar == null ? null : ahVar.b;
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
                stringBuilder.append(aiVarArr[i].a);
                stringBuilder.append(" ");
                if (aiVarArr[i].b) {
                    str3 = "ASC";
                } else {
                    str3 = "DESC";
                }
                stringBuilder.append(str3);
            }
            obj = stringBuilder.toString();
        }
        if (tVar != null) {
            String valueOf2;
            if (tVar.b > 0) {
                valueOf2 = String.valueOf(tVar.b);
            } else {
                valueOf2 = String.valueOf(Integer.MAX_VALUE);
            }
            if (tVar.a >= 0) {
                obj2 = valueOf2;
                valueOf = String.valueOf(tVar.a);
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
        if (!TextUtils.isEmpty(obj3)) {
            stringBuilder2.append(" WHERE " + obj3);
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
        return this.d.a(stringBuilder2.toString(), strArr);
    }

    private Cursor c(String str, String str2) {
        String str3 = "SELECT *, rowid FROM " + str + " WHERE " + "__ITEM__KEY__" + "=?";
        return this.d.a(str3, new String[]{str2});
    }

    private boolean d(String str, String str2) {
        boolean z = true;
        String str3 = "SELECT rowid FROM " + str + " WHERE " + "__ITEM__KEY__" + "=?";
        Cursor a = this.d.a(str3, new String[]{str2});
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
