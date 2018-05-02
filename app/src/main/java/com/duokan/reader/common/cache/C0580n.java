package com.duokan.reader.common.cache;

import android.content.ContentValues;
import android.text.TextUtils;
import com.duokan.core.p029c.C0326b;
import com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.cache.n */
class C0580n<TInfo, TItem, TJson, TFilter extends C0326b<TItem>, TComparator extends Comparator<TItem>> {
    /* renamed from: a */
    private static ThreadPoolExecutor f1889a = new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
    /* renamed from: b */
    private boolean f1890b = false;
    /* renamed from: c */
    private final C0568w<TItem, TFilter, TComparator> f1891c;
    /* renamed from: d */
    private ArrayList<C0583x> f1892d = null;
    /* renamed from: e */
    private ArrayList<C0583x> f1893e = null;
    /* renamed from: f */
    private Runnable f1894f = null;
    /* renamed from: g */
    private final Object f1895g = new Object();
    /* renamed from: h */
    private long f1896h = 4611686018427387903L;
    /* renamed from: i */
    private int f1897i = -1;
    /* renamed from: j */
    private JSONObject f1898j = null;

    public C0580n(C0568w<TItem, TFilter, TComparator> c0568w) {
        this.f1891c = c0568w;
    }

    /* renamed from: a */
    public synchronized int m2606a() {
        int i = -1;
        synchronized (this) {
            if (!this.f1890b) {
                if (this.f1897i == -1) {
                    this.f1897i = this.f1891c.mo764c();
                }
                i = this.f1897i;
            }
        }
        return i;
    }

    /* renamed from: a */
    public synchronized void m2611a(int i) {
        if (!this.f1890b) {
            m2606a();
            if (i > this.f1897i) {
                this.f1897i = i;
                synchronized (this.f1895g) {
                    if (this.f1892d == null) {
                        this.f1892d = new ArrayList();
                    }
                    C0583x c0583x = new C0583x();
                    c0583x.f1902a = ListCacheStoreChangeType.UpdateVersion;
                    c0583x.f1903b = null;
                    c0583x.f1904c = null;
                    c0583x.f1905d = this.f1897i;
                    this.f1892d.add(c0583x);
                }
                m2603d();
            }
        }
    }

    /* renamed from: a */
    public synchronized void m2612a(int i, ab abVar, C0447u<TInfo, TItem, TJson> c0447u) {
        if (!this.f1890b) {
            int a = m2606a();
            if (a < i) {
                if (abVar == null) {
                    m2617b();
                    m2613a(null, (C0447u) c0447u);
                } else {
                    abVar.mo1155a(a);
                }
                m2611a(i);
            }
        }
    }

    /* renamed from: a */
    public synchronized TInfo m2607a(C0447u<TInfo, TItem, TJson> c0447u) {
        TInfo deserializeInfoFromJson;
        if (this.f1890b) {
            deserializeInfoFromJson = c0447u.deserializeInfoFromJson(new JSONObject());
        } else {
            if (this.f1898j == null) {
                Object obj;
                Object obj2;
                Object obj3 = null;
                String str = null;
                synchronized (this.f1895g) {
                    int size;
                    C0583x c0583x;
                    if (this.f1892d != null) {
                        for (size = this.f1892d.size() - 1; size >= 0; size--) {
                            c0583x = (C0583x) this.f1892d.get(size);
                            if (c0583x.f1902a == ListCacheStoreChangeType.UpdateInfo) {
                                str = c0583x.f1904c;
                                obj3 = 1;
                                break;
                            }
                        }
                    }
                    if (obj3 == null && this.f1893e != null) {
                        for (size = this.f1893e.size() - 1; size >= 0; size--) {
                            c0583x = (C0583x) this.f1893e.get(size);
                            if (c0583x.f1902a == ListCacheStoreChangeType.UpdateInfo) {
                                obj = c0583x.f1904c;
                                obj2 = 1;
                                break;
                            }
                        }
                    }
                    String obj4 = str;
                    obj2 = obj3;
                }
                if (obj2 == null) {
                    obj4 = this.f1891c.mo766d();
                }
                if (TextUtils.isEmpty(obj4)) {
                    this.f1898j = new JSONObject();
                } else {
                    try {
                        this.f1898j = new JSONObject(obj4);
                    } catch (JSONException e) {
                        this.f1898j = new JSONObject();
                    }
                }
            }
            try {
                deserializeInfoFromJson = c0447u.deserializeInfoFromJson(this.f1898j);
                if (deserializeInfoFromJson == null) {
                    deserializeInfoFromJson = c0447u.deserializeInfoFromJson(new JSONObject());
                }
            } catch (Exception e2) {
                deserializeInfoFromJson = c0447u.deserializeInfoFromJson(new JSONObject());
            }
        }
        return deserializeInfoFromJson;
    }

    /* renamed from: a */
    public synchronized void m2613a(TInfo tInfo, C0447u<TInfo, TItem, TJson> c0447u) {
        if (!this.f1890b) {
            if (tInfo == null) {
                this.f1898j = null;
            } else {
                this.f1898j = c0447u.serializeInfoToJson(tInfo);
            }
            synchronized (this.f1895g) {
                if (this.f1892d == null) {
                    this.f1892d = new ArrayList();
                }
                C0583x c0583x = new C0583x();
                c0583x.f1902a = ListCacheStoreChangeType.UpdateInfo;
                c0583x.f1903b = null;
                c0583x.f1904c = this.f1898j == null ? "" : this.f1898j.toString();
                this.f1892d.add(c0583x);
            }
            m2603d();
        }
    }

    /* renamed from: a */
    public synchronized Collection<String> m2609a(TFilter tFilter, TComparator tComparator, C0582t c0582t) {
        Collection<String> arrayList;
        if (this.f1890b) {
            arrayList = new ArrayList();
        } else {
            Comparator tComparator2;
            m2605e();
            C0568w c0568w = this.f1891c;
            if (tComparator2 == null) {
                tComparator2 = this.f1891c.mo759a();
            }
            arrayList = c0568w.mo758a(tFilter, tComparator2, c0582t);
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized Collection<TItem> m2610a(TFilter tFilter, TComparator tComparator, C0582t c0582t, C0575q<TJson> c0575q, C0446p<TItem, TJson> c0446p) {
        Collection<TItem> arrayList;
        if (this.f1890b) {
            arrayList = new ArrayList();
        } else {
            Comparator tComparator2;
            Object deserializeCorePropertiesFromJson;
            m2605e();
            C0568w c0568w = this.f1891c;
            if (tComparator2 == null) {
                tComparator2 = this.f1891c.mo759a();
            }
            Collection<C0584z> c = c0568w.mo765c(tFilter, tComparator2, c0582t);
            ArrayList arrayList2 = new ArrayList(c.size());
            for (C0584z c0584z : c) {
                try {
                    deserializeCorePropertiesFromJson = c0446p.deserializeCorePropertiesFromJson(c0584z.f1906a, c0575q.mo778d(c0584z.f1908c));
                } catch (Exception e) {
                    deserializeCorePropertiesFromJson = null;
                }
                if (deserializeCorePropertiesFromJson != null) {
                    if (tFilter != null) {
                        if (!tFilter.mo411a(deserializeCorePropertiesFromJson)) {
                        }
                    }
                    arrayList2.add(deserializeCorePropertiesFromJson);
                }
            }
            deserializeCorePropertiesFromJson = arrayList2;
        }
        return arrayList;
    }

    /* renamed from: b */
    public synchronized Collection<TItem> m2616b(TFilter tFilter, TComparator tComparator, C0582t c0582t, C0575q<TJson> c0575q, C0446p<TItem, TJson> c0446p) {
        Collection<TItem> arrayList;
        if (this.f1890b) {
            arrayList = new ArrayList();
        } else {
            Comparator tComparator2;
            Object deserializeItemFromJson;
            m2605e();
            C0568w c0568w = this.f1891c;
            if (tComparator2 == null) {
                tComparator2 = this.f1891c.mo759a();
            }
            Collection<C0584z> b = c0568w.mo763b(tFilter, tComparator2, c0582t);
            ArrayList arrayList2 = new ArrayList(b.size());
            for (C0584z c0584z : b) {
                try {
                    deserializeItemFromJson = c0446p.deserializeItemFromJson(c0584z.f1906a, c0575q.mo778d(c0584z.f1909d));
                } catch (Exception e) {
                    deserializeItemFromJson = null;
                }
                if (deserializeItemFromJson != null) {
                    if (tFilter != null) {
                        if (!tFilter.mo411a(deserializeItemFromJson)) {
                        }
                    }
                    arrayList2.add(deserializeItemFromJson);
                }
            }
            deserializeItemFromJson = arrayList2;
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized TItem m2608a(String str, C0575q<TJson> c0575q, C0446p<TItem, TJson> c0446p) {
        TItem tItem = null;
        synchronized (this) {
            if (!this.f1890b) {
                C0584z a = m2594a(str);
                if (a != null) {
                    try {
                        tItem = c0446p.deserializeItemFromJson(a.f1906a, c0575q.mo778d(a.f1909d));
                    } catch (Exception e) {
                    }
                }
            }
        }
        return tItem;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private com.duokan.reader.common.cache.C0584z m2594a(java.lang.String r7) {
        /*
        r6 = this;
        r1 = 0;
        r3 = r6.f1895g;
        monitor-enter(r3);
        r0 = r6.f1892d;	 Catch:{ all -> 0x004b }
        if (r0 == 0) goto L_0x004e;
    L_0x0008:
        r0 = r6.f1892d;	 Catch:{ all -> 0x004b }
        r0 = r0.size();	 Catch:{ all -> 0x004b }
        r0 = r0 + -1;
        r2 = r0;
    L_0x0011:
        if (r2 < 0) goto L_0x004e;
    L_0x0013:
        r0 = r6.f1892d;	 Catch:{ all -> 0x004b }
        r0 = r0.get(r2);	 Catch:{ all -> 0x004b }
        r0 = (com.duokan.reader.common.cache.C0583x) r0;	 Catch:{ all -> 0x004b }
        r4 = r0.f1902a;	 Catch:{ all -> 0x004b }
        r5 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.UpdateInfo;	 Catch:{ all -> 0x004b }
        if (r4 == r5) goto L_0x0027;
    L_0x0021:
        r4 = r0.f1902a;	 Catch:{ all -> 0x004b }
        r5 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.UpdateVersion;	 Catch:{ all -> 0x004b }
        if (r4 != r5) goto L_0x002b;
    L_0x0027:
        r0 = r2 + -1;
        r2 = r0;
        goto L_0x0011;
    L_0x002b:
        r4 = r0.f1902a;	 Catch:{ all -> 0x004b }
        r5 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.ClearItems;	 Catch:{ all -> 0x004b }
        if (r4 != r5) goto L_0x0034;
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        r0 = r1;
    L_0x0033:
        return r0;
    L_0x0034:
        r4 = r0.f1903b;	 Catch:{ all -> 0x004b }
        r4 = r4.f1906a;	 Catch:{ all -> 0x004b }
        r4 = r4.equals(r7);	 Catch:{ all -> 0x004b }
        if (r4 == 0) goto L_0x0027;
    L_0x003e:
        r2 = r0.f1902a;	 Catch:{ all -> 0x004b }
        r4 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.DeleteItem;	 Catch:{ all -> 0x004b }
        if (r2 != r4) goto L_0x0047;
    L_0x0044:
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        r0 = r1;
        goto L_0x0033;
    L_0x0047:
        r0 = r0.f1903b;	 Catch:{ all -> 0x004b }
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        goto L_0x0033;
    L_0x004b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        throw r0;
    L_0x004e:
        r0 = r6.f1893e;	 Catch:{ all -> 0x004b }
        if (r0 == 0) goto L_0x0095;
    L_0x0052:
        r0 = r6.f1893e;	 Catch:{ all -> 0x004b }
        r0 = r0.size();	 Catch:{ all -> 0x004b }
        r0 = r0 + -1;
        r2 = r0;
    L_0x005b:
        if (r2 < 0) goto L_0x0095;
    L_0x005d:
        r0 = r6.f1893e;	 Catch:{ all -> 0x004b }
        r0 = r0.get(r2);	 Catch:{ all -> 0x004b }
        r0 = (com.duokan.reader.common.cache.C0583x) r0;	 Catch:{ all -> 0x004b }
        r4 = r0.f1902a;	 Catch:{ all -> 0x004b }
        r5 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.UpdateInfo;	 Catch:{ all -> 0x004b }
        if (r4 == r5) goto L_0x0071;
    L_0x006b:
        r4 = r0.f1902a;	 Catch:{ all -> 0x004b }
        r5 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.UpdateVersion;	 Catch:{ all -> 0x004b }
        if (r4 != r5) goto L_0x0075;
    L_0x0071:
        r0 = r2 + -1;
        r2 = r0;
        goto L_0x005b;
    L_0x0075:
        r4 = r0.f1902a;	 Catch:{ all -> 0x004b }
        r5 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.ClearItems;	 Catch:{ all -> 0x004b }
        if (r4 != r5) goto L_0x007e;
    L_0x007b:
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        r0 = r1;
        goto L_0x0033;
    L_0x007e:
        r4 = r0.f1903b;	 Catch:{ all -> 0x004b }
        r4 = r4.f1906a;	 Catch:{ all -> 0x004b }
        r4 = r4.equals(r7);	 Catch:{ all -> 0x004b }
        if (r4 == 0) goto L_0x0071;
    L_0x0088:
        r2 = r0.f1902a;	 Catch:{ all -> 0x004b }
        r4 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.DeleteItem;	 Catch:{ all -> 0x004b }
        if (r2 != r4) goto L_0x0091;
    L_0x008e:
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        r0 = r1;
        goto L_0x0033;
    L_0x0091:
        r0 = r0.f1903b;	 Catch:{ all -> 0x004b }
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        goto L_0x0033;
    L_0x0095:
        monitor-exit(r3);	 Catch:{ all -> 0x004b }
        r0 = r6.f1891c;
        r0 = r0.mo756a(r7);
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.n.a(java.lang.String):com.duokan.reader.common.cache.z");
    }

    /* renamed from: a */
    public synchronized void m2615a(Collection<TItem> collection, C0575q<TJson> c0575q, C0444r<TItem, TJson> c0444r, C0446p<TItem, TJson> c0446p) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object next : collection) {
            String uniqueId = c0444r.getUniqueId(next);
            if (uniqueId != null) {
                Object serializeItemToJson = c0444r.serializeItemToJson(next, null);
                Object serializeItemCorePropertiesToJson = c0444r.serializeItemCorePropertiesToJson(next);
                C0584z c0584z = new C0584z();
                c0584z.f1906a = uniqueId;
                c0584z.f1907b = m2593a(next, (C0444r) c0444r);
                c0584z.f1909d = c0575q.mo776a(serializeItemToJson);
                c0584z.f1908c = c0575q.mo776a(serializeItemCorePropertiesToJson);
                c0584z.f1910e = -1;
                arrayList.add(c0584z);
            }
        }
        m2597a(arrayList);
    }

    /* renamed from: b */
    public synchronized void m2618b(Collection<TItem> collection, C0575q<TJson> c0575q, C0444r<TItem, TJson> c0444r, C0446p<TItem, TJson> c0446p) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object next : collection) {
            try {
                String uniqueId = c0444r.getUniqueId(next);
                if (uniqueId != null) {
                    Object serializeItemToJson = c0444r.serializeItemToJson(next, null);
                    if (c0575q.mo777b(serializeItemToJson)) {
                        serializeItemToJson = c0444r.serializeItemToJson(next, c0575q.mo778d(m2594a(uniqueId).f1909d));
                    }
                    Object serializeItemCorePropertiesToJson = c0444r.serializeItemCorePropertiesToJson(next);
                    if (serializeItemToJson != null) {
                        C0584z c0584z = new C0584z();
                        c0584z.f1906a = uniqueId;
                        c0584z.f1907b = m2593a(next, (C0444r) c0444r);
                        c0584z.f1909d = c0575q.mo776a(serializeItemToJson);
                        c0584z.f1908c = c0575q.mo776a(serializeItemCorePropertiesToJson);
                        c0584z.f1910e = -1;
                        arrayList.add(c0584z);
                    }
                }
            } catch (Exception e) {
            }
        }
        m2597a(arrayList);
    }

    /* renamed from: a */
    private ContentValues m2593a(TItem tItem, C0444r<TItem, TJson> c0444r) {
        int i = 0;
        ContentValues propertyValues = c0444r.getPropertyValues(tItem);
        if (propertyValues == null) {
            propertyValues = new ContentValues();
        }
        aa[] propertyDefinitions = c0444r.getPropertyDefinitions();
        if (propertyDefinitions == null) {
            propertyDefinitions = new aa[0];
        }
        if (propertyDefinitions.length != propertyValues.size()) {
            throw new IllegalStateException();
        }
        int length = propertyDefinitions.length;
        while (i < length) {
            if (propertyValues.containsKey(propertyDefinitions[i].f1854a)) {
                i++;
            } else {
                throw new IllegalStateException();
            }
        }
        return propertyValues;
    }

    /* renamed from: a */
    private void m2597a(ArrayList<C0584z> arrayList) {
        if (!this.f1890b) {
            synchronized (this.f1895g) {
                if (this.f1892d == null) {
                    this.f1892d = new ArrayList();
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    C0583x c0583x = new C0583x();
                    c0583x.f1903b = (C0584z) arrayList.get(i);
                    c0583x.f1902a = ListCacheStoreChangeType.SaveItem;
                    if (((C0584z) arrayList.get(i)).f1910e < 0) {
                        C0584z c0584z = (C0584z) arrayList.get(i);
                        long j = this.f1896h;
                        this.f1896h = 1 + j;
                        c0584z.f1910e = j;
                    }
                    this.f1892d.add(c0583x);
                }
            }
            m2603d();
        }
    }

    /* renamed from: a */
    public synchronized void m2614a(Collection<String> collection) {
        if (!this.f1890b) {
            synchronized (this.f1895g) {
                if (this.f1892d == null) {
                    this.f1892d = new ArrayList();
                }
                for (String str : collection) {
                    if (str != null) {
                        C0583x c0583x = new C0583x();
                        c0583x.f1903b = new C0584z();
                        c0583x.f1903b.f1906a = str;
                        c0583x.f1902a = ListCacheStoreChangeType.DeleteItem;
                        this.f1892d.add(c0583x);
                    }
                }
            }
            m2603d();
        }
    }

    /* renamed from: b */
    public synchronized void m2617b() {
        if (!this.f1890b) {
            synchronized (this.f1895g) {
                if (this.f1892d == null) {
                    this.f1892d = new ArrayList();
                }
                C0583x c0583x = new C0583x();
                c0583x.f1902a = ListCacheStoreChangeType.ClearItems;
                this.f1892d.add(c0583x);
            }
            m2603d();
        }
    }

    /* renamed from: c */
    public synchronized void m2619c() {
        if (!this.f1890b) {
            this.f1890b = true;
            synchronized (this.f1895g) {
                while (this.f1894f != null) {
                    try {
                        this.f1895g.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    /* renamed from: d */
    private void m2603d() {
        synchronized (this.f1895g) {
            if (this.f1892d != null && this.f1894f == null) {
                this.f1893e = this.f1892d;
                this.f1892d = null;
                this.f1894f = new C0581o(this);
                f1889a.execute(this.f1894f);
            }
        }
    }

    /* renamed from: e */
    private void m2605e() {
        synchronized (this.f1895g) {
            while (this.f1894f != null) {
                try {
                    this.f1895g.wait();
                } catch (InterruptedException e) {
                }
            }
            this.f1893e = this.f1892d;
            this.f1892d = null;
        }
        if (this.f1893e != null) {
            m2601b(new ArrayList(this.f1893e));
            synchronized (this.f1895g) {
                this.f1893e = null;
            }
        }
    }

    /* renamed from: b */
    private void m2601b(ArrayList<C0583x> arrayList) {
        if (!this.f1890b) {
            this.f1891c.mo760a((ArrayList) arrayList);
            if (!this.f1890b && this.f1891c.mo762b() > 0) {
                Collection a = this.f1891c.mo757a(this.f1891c.mo762b());
                if (a.size() > 0) {
                    this.f1891c.mo761a(a);
                }
            }
        }
    }
}
