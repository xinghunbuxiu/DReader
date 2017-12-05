package com.duokan.reader.common.cache;

import android.content.ContentValues;
import android.text.TextUtils;

import com.duokan.core.c.IRunTask;
import com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class n {
    private static ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private boolean b = false;
    private final w c;
    private ArrayList d = null;
    private ArrayList e = null;
    private Runnable f = null;
    private final Object g = new Object();
    private long h = 4611686018427387903L;
    private int i = -1;
    private JSONObject j = null;

    public n(w wVar) {
        this.c = wVar;
    }

    public synchronized int a() {
        int i = -1;
        synchronized (this) {
            if (!this.b) {
                if (this.i == -1) {
                    this.i = this.c.c();
                }
                i = this.i;
            }
        }
        return i;
    }

    public synchronized void a(int i) {
        if (!this.b) {
            a();
            if (i > this.i) {
                this.i = i;
                synchronized (this.g) {
                    if (this.d == null) {
                        this.d = new ArrayList();
                    }
                    x xVar = new x();
                    xVar.a = ListCacheStoreChangeType.UpdateVersion;
                    xVar.b = null;
                    xVar.c = null;
                    xVar.d = this.i;
                    this.d.add(xVar);
                }
                d();
            }
        }
    }

    public synchronized void a(int i, ab abVar, u uVar) {
        if (!this.b) {
            int a = a();
            if (a < i) {
                if (abVar == null) {
                    b();
                    a(null, uVar);
                } else {
                    abVar.a(a);
                }
                a(i);
            }
        }
    }

    public synchronized Object a(u uVar) {
        Object deserializeInfoFromJson;
        if (this.b) {
            deserializeInfoFromJson = uVar.deserializeInfoFromJson(new JSONObject());
        } else {
            if (this.j == null) {
                Object obj;
                Object obj2 = null;
                String str = null;
                synchronized (this.g) {
                    int size;
                    x xVar;
                    if (this.d != null) {
                        for (size = this.d.size() - 1; size >= 0; size--) {
                            xVar = (x) this.d.get(size);
                            if (xVar.a == ListCacheStoreChangeType.UpdateInfo) {
                                str = xVar.c;
                                obj2 = 1;
                                break;
                            }
                        }
                    }
                    if (obj2 == null && this.e != null) {
                        for (size = this.e.size() - 1; size >= 0; size--) {
                            xVar = (x) this.e.get(size);
                            if (xVar.a == ListCacheStoreChangeType.UpdateInfo) {
                                deserializeInfoFromJson = xVar.c;
                                obj = 1;
                                break;
                            }
                        }
                    }
                    String str2 = str;
                    obj = obj2;
                }
                if (obj == null) {
                    deserializeInfoFromJson = this.c.d();
                }
                if (TextUtils.isEmpty(deserializeInfoFromJson)) {
                    this.j = new JSONObject();
                } else {
                    try {
                        this.j = new JSONObject(deserializeInfoFromJson);
                    } catch (JSONException e) {
                        this.j = new JSONObject();
                    }
                }
            }
            try {
                deserializeInfoFromJson = uVar.deserializeInfoFromJson(this.j);
                if (deserializeInfoFromJson == null) {
                    deserializeInfoFromJson = uVar.deserializeInfoFromJson(new JSONObject());
                }
            } catch (Exception e2) {
                deserializeInfoFromJson = uVar.deserializeInfoFromJson(new JSONObject());
            }
        }
        return deserializeInfoFromJson;
    }

    public synchronized void a(Object obj, u uVar) {
        if (!this.b) {
            if (obj == null) {
                this.j = null;
            } else {
                this.j = uVar.serializeInfoToJson(obj);
            }
            synchronized (this.g) {
                if (this.d == null) {
                    this.d = new ArrayList();
                }
                x xVar = new x();
                xVar.a = ListCacheStoreChangeType.UpdateInfo;
                xVar.b = null;
                xVar.c = this.j == null ? "" : this.j.toString();
                this.d.add(xVar);
            }
            d();
        }
    }

    public synchronized Collection a(IRunTask bVar, Comparator comparator, t tVar) {
        Collection arrayList;
        if (this.b) {
            arrayList = new ArrayList();
        } else {
            e();
            w wVar = this.c;
            if (comparator == null) {
                comparator = this.c.a();
            }
            arrayList = wVar.a(bVar, comparator, tVar);
        }
        return arrayList;
    }

    public synchronized Collection a(IRunTask bVar, Comparator comparator, t tVar, q qVar, p pVar) {
        Collection arrayList;
        if (this.b) {
            arrayList = new ArrayList();
        } else {
            Object deserializeCorePropertiesFromJson;
            e();
            w wVar = this.c;
            if (comparator == null) {
                comparator = this.c.a();
            }
            Collection<z> c = wVar.c(bVar, comparator, tVar);
            ArrayList arrayList2 = new ArrayList(c.size());
            for (z zVar : c) {
                try {
                    deserializeCorePropertiesFromJson = pVar.deserializeCorePropertiesFromJson(zVar.a, qVar.d(zVar.c));
                } catch (Exception e) {
                    deserializeCorePropertiesFromJson = null;
                }
                if (deserializeCorePropertiesFromJson != null) {
                    if (bVar != null) {
                        if (!bVar.isRunTask(deserializeCorePropertiesFromJson)) {
                        }
                    }
                    arrayList2.add(deserializeCorePropertiesFromJson);
                }
            }
            deserializeCorePropertiesFromJson = arrayList2;
        }
        return arrayList;
    }

    public synchronized Collection b(IRunTask bVar, Comparator comparator, t tVar, q qVar, p pVar) {
        Collection arrayList;
        if (this.b) {
            arrayList = new ArrayList();
        } else {
            Object deserializeItemFromJson;
            e();
            w wVar = this.c;
            if (comparator == null) {
                comparator = this.c.a();
            }
            Collection<z> b = wVar.b(bVar, comparator, tVar);
            ArrayList arrayList2 = new ArrayList(b.size());
            for (z zVar : b) {
                try {
                    deserializeItemFromJson = pVar.deserializeItemFromJson(zVar.a, qVar.d(zVar.d));
                } catch (Exception e) {
                    deserializeItemFromJson = null;
                }
                if (deserializeItemFromJson != null) {
                    if (bVar != null) {
                        if (!bVar.isRunTask(deserializeItemFromJson)) {
                        }
                    }
                    arrayList2.add(deserializeItemFromJson);
                }
            }
            deserializeItemFromJson = arrayList2;
        }
        return arrayList;
    }

    public synchronized Object a(String str, q qVar, p pVar) {
        Object obj = null;
        synchronized (this) {
            if (!this.b) {
                z a = a(str);
                if (a != null) {
                    try {
                        obj = pVar.deserializeItemFromJson(a.a, qVar.d(a.d));
                    } catch (Exception e) {
                    }
                }
            }
        }
        return obj;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.duokan.reader.common.cache.z a(java.lang.String r7) {
        /*
        r6 = this;
        r1 = 0;
        r3 = r6.SessionTask;
        monitor-enter(r3);
        r0 = r6.getScaledTouchSlop;	 Catch:{ all -> 0x004b }
        if (r0 == 0) goto L_0x004e;
    L_0x0008:
        r0 = r6.getScaledTouchSlop;	 Catch:{ all -> 0x004b }
        r0 = r0.size();	 Catch:{ all -> 0x004b }
        r0 = r0 + -1;
        r2 = r0;
    L_0x0011:
        if (r2 < 0) goto L_0x004e;
    L_0x0013:
        r0 = r6.getScaledTouchSlop;	 Catch:{ all -> 0x004b }
        r0 = r0.getAllSortStackTraces(r2);	 Catch:{ all -> 0x004b }
        r0 = (com.duokan.reader.common.cache.MyContextWrapper) r0;	 Catch:{ all -> 0x004b }
        r4 = r0.setDrawable;	 Catch:{ all -> 0x004b }
        r5 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.UpdateInfo;	 Catch:{ all -> 0x004b }
        if (r4 == r5) goto L_0x0027;
    L_0x0021:
        r4 = r0.setDrawable;	 Catch:{ all -> 0x004b }
        r5 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.UpdateVersion;	 Catch:{ all -> 0x004b }
        if (r4 != r5) goto L_0x002b;
    L_0x0027:
        r0 = r2 + -1;
        r2 = r0;
        goto L_0x0011;
    L_0x002b:
        r4 = r0.setDrawable;	 Catch:{ all -> 0x004b }
        r5 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.ClearItems;	 Catch:{ all -> 0x004b }
        if (r4 != r5) goto L_0x0034;
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        r0 = r1;
    L_0x0033:
        return r0;
    L_0x0034:
        r4 = r0.getVisible;	 Catch:{ all -> 0x004b }
        r4 = r4.setDrawable;	 Catch:{ all -> 0x004b }
        r4 = r4.equals(r7);	 Catch:{ all -> 0x004b }
        if (r4 == 0) goto L_0x0027;
    L_0x003e:
        r2 = r0.setDrawable;	 Catch:{ all -> 0x004b }
        r4 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.DeleteItem;	 Catch:{ all -> 0x004b }
        if (r2 != r4) goto L_0x0047;
    L_0x0044:
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        r0 = r1;
        goto L_0x0033;
    L_0x0047:
        r0 = r0.getVisible;	 Catch:{ all -> 0x004b }
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        goto L_0x0033;
    L_0x004b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        throw r0;
    L_0x004e:
        r0 = r6.getScaledPagingTouchSlop;	 Catch:{ all -> 0x004b }
        if (r0 == 0) goto L_0x0095;
    L_0x0052:
        r0 = r6.getScaledPagingTouchSlop;	 Catch:{ all -> 0x004b }
        r0 = r0.size();	 Catch:{ all -> 0x004b }
        r0 = r0 + -1;
        r2 = r0;
    L_0x005b:
        if (r2 < 0) goto L_0x0095;
    L_0x005d:
        r0 = r6.getScaledPagingTouchSlop;	 Catch:{ all -> 0x004b }
        r0 = r0.getAllSortStackTraces(r2);	 Catch:{ all -> 0x004b }
        r0 = (com.duokan.reader.common.cache.MyContextWrapper) r0;	 Catch:{ all -> 0x004b }
        r4 = r0.setDrawable;	 Catch:{ all -> 0x004b }
        r5 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.UpdateInfo;	 Catch:{ all -> 0x004b }
        if (r4 == r5) goto L_0x0071;
    L_0x006b:
        r4 = r0.setDrawable;	 Catch:{ all -> 0x004b }
        r5 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.UpdateVersion;	 Catch:{ all -> 0x004b }
        if (r4 != r5) goto L_0x0075;
    L_0x0071:
        r0 = r2 + -1;
        r2 = r0;
        goto L_0x005b;
    L_0x0075:
        r4 = r0.setDrawable;	 Catch:{ all -> 0x004b }
        r5 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.ClearItems;	 Catch:{ all -> 0x004b }
        if (r4 != r5) goto L_0x007e;
    L_0x007b:
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        r0 = r1;
        goto L_0x0033;
    L_0x007e:
        r4 = r0.getVisible;	 Catch:{ all -> 0x004b }
        r4 = r4.setDrawable;	 Catch:{ all -> 0x004b }
        r4 = r4.equals(r7);	 Catch:{ all -> 0x004b }
        if (r4 == 0) goto L_0x0071;
    L_0x0088:
        r2 = r0.setDrawable;	 Catch:{ all -> 0x004b }
        r4 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.DeleteItem;	 Catch:{ all -> 0x004b }
        if (r2 != r4) goto L_0x0091;
    L_0x008e:
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        r0 = r1;
        goto L_0x0033;
    L_0x0091:
        r0 = r0.getVisible;	 Catch:{ all -> 0x004b }
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        goto L_0x0033;
    L_0x0095:
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        r0 = r6.showAnimation;
        r0 = r0.setDrawable(r7);
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.n.setDrawable(java.lang.String):com.duokan.reader.common.cache.QueryFeatureWrapper");
    }

    public synchronized void a(Collection collection, q qVar, r rVar, p pVar) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object next : collection) {
            String uniqueId = rVar.getUniqueId(next);
            if (uniqueId != null) {
                Object serializeItemToJson = rVar.serializeItemToJson(next, null);
                Object serializeItemCorePropertiesToJson = rVar.serializeItemCorePropertiesToJson(next);
                z zVar = new z();
                zVar.a = uniqueId;
                zVar.b = a(next, rVar);
                zVar.d = qVar.a(serializeItemToJson);
                zVar.c = qVar.a(serializeItemCorePropertiesToJson);
                zVar.e = -1;
                arrayList.add(zVar);
            }
        }
        a(arrayList);
    }

    public synchronized void b(Collection collection, q qVar, r rVar, p pVar) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object next : collection) {
            try {
                String uniqueId = rVar.getUniqueId(next);
                if (uniqueId != null) {
                    Object serializeItemToJson = rVar.serializeItemToJson(next, null);
                    if (qVar.b(serializeItemToJson)) {
                        serializeItemToJson = rVar.serializeItemToJson(next, qVar.d(a(uniqueId).d));
                    }
                    Object serializeItemCorePropertiesToJson = rVar.serializeItemCorePropertiesToJson(next);
                    if (serializeItemToJson != null) {
                        z zVar = new z();
                        zVar.a = uniqueId;
                        zVar.b = a(next, rVar);
                        zVar.d = qVar.a(serializeItemToJson);
                        zVar.c = qVar.a(serializeItemCorePropertiesToJson);
                        zVar.e = -1;
                        arrayList.add(zVar);
                    }
                }
            } catch (Exception e) {
            }
        }
        a(arrayList);
    }

    private ContentValues a(Object obj, r rVar) {
        int i = 0;
        ContentValues propertyValues = rVar.getPropertyValues(obj);
        if (propertyValues == null) {
            propertyValues = new ContentValues();
        }
        aa[] propertyDefinitions = rVar.getPropertyDefinitions();
        if (propertyDefinitions == null) {
            propertyDefinitions = new aa[0];
        }
        if (propertyDefinitions.length != propertyValues.size()) {
            throw new IllegalStateException();
        }
        int length = propertyDefinitions.length;
        while (i < length) {
            if (propertyValues.containsKey(propertyDefinitions[i].a)) {
                i++;
            } else {
                throw new IllegalStateException();
            }
        }
        return propertyValues;
    }

    private void a(ArrayList arrayList) {
        if (!this.b) {
            synchronized (this.g) {
                if (this.d == null) {
                    this.d = new ArrayList();
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    x xVar = new x();
                    xVar.b = (z) arrayList.get(i);
                    xVar.a = ListCacheStoreChangeType.SaveItem;
                    if (((z) arrayList.get(i)).e < 0) {
                        z zVar = (z) arrayList.get(i);
                        long j = this.h;
                        this.h = 1 + j;
                        zVar.e = j;
                    }
                    this.d.add(xVar);
                }
            }
            d();
        }
    }

    public synchronized void a(Collection collection) {
        if (!this.b) {
            synchronized (this.g) {
                if (this.d == null) {
                    this.d = new ArrayList();
                }
                for (String str : collection) {
                    if (str != null) {
                        x xVar = new x();
                        xVar.b = new z();
                        xVar.b.a = str;
                        xVar.a = ListCacheStoreChangeType.DeleteItem;
                        this.d.add(xVar);
                    }
                }
            }
            d();
        }
    }

    public synchronized void b() {
        if (!this.b) {
            synchronized (this.g) {
                if (this.d == null) {
                    this.d = new ArrayList();
                }
                x xVar = new x();
                xVar.a = ListCacheStoreChangeType.ClearItems;
                this.d.add(xVar);
            }
            d();
        }
    }

    public synchronized void c() {
        if (!this.b) {
            this.b = true;
            synchronized (this.g) {
                while (this.f != null) {
                    try {
                        this.g.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    private void d() {
        synchronized (this.g) {
            if (this.d != null && this.f == null) {
                this.e = this.d;
                this.d = null;
                this.f = new o(this);
                a.execute(this.f);
            }
        }
    }

    private void e() {
        synchronized (this.g) {
            while (this.f != null) {
                try {
                    this.g.wait();
                } catch (InterruptedException e) {
                }
            }
            this.e = this.d;
            this.d = null;
        }
        if (this.e != null) {
            b(new ArrayList(this.e));
            synchronized (this.g) {
                this.e = null;
            }
        }
    }

    private void b(ArrayList arrayList) {
        if (!this.b) {
            this.c.a(arrayList);
            if (!this.b && this.c.b() > 0) {
                Collection a = this.c.a(this.c.b());
                if (a.size() > 0) {
                    this.c.a(a);
                }
            }
        }
    }
}
