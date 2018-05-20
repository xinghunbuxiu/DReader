package com.duokan.reader.common.cache;

import com.duokan.core.p029c.IRunTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

public class ListCache<TInfo, TItem, TJson, TFilter extends IRunTask<TItem>, TComparator extends Comparator<TItem>> {
    /* renamed from: a */
    private static final HashMap<String, C0580n<?, ?, ?, ?, ?>> f1460a = new HashMap();
    /* renamed from: b */
    private static final HashMap<String, Object> f1461b = new HashMap();
    /* renamed from: c */
    private final String f1462c;
    /* renamed from: d */
    private final C0575q<TJson> f1463d;
    /* renamed from: e */
    private final C0447u<TInfo, TItem, TJson> f1464e;
    /* renamed from: f */
    private final TComparator f1465f;
    /* renamed from: g */
    private final C0569y<TItem, TFilter, TComparator> f1466g;
    /* renamed from: h */
    private final int f1467h;
    /* renamed from: i */
    private final Object f1468i;
    /* renamed from: j */
    private C0580n<TInfo, TItem, TJson, TFilter, TComparator> f1469j;
    /* renamed from: k */
    private boolean f1470k = false;

    public enum ListCacheStoreChangeType {
        SaveItem,
        DeleteItem,
        ClearItems,
        UpdateInfo,
        UpdateVersion
    }

    public ListCache(String str, C0575q<TJson> c0575q, C0447u<TInfo, TItem, TJson> c0447u, TComparator tComparator, C0569y<TItem, TFilter, TComparator> c0569y, int i) {
        this.f1462c = str;
        this.f1463d = c0575q;
        this.f1464e = c0447u;
        this.f1465f = tComparator;
        this.f1466g = c0569y;
        this.f1467h = i;
        synchronized (f1461b) {
            if (!f1461b.containsKey(this.f1462c)) {
                f1461b.put(this.f1462c, new Object());
            }
            this.f1468i = f1461b.get(this.f1462c);
        }
        this.f1470k = false;
    }

    public C0447u<TInfo, TItem, TJson> getListCacheHelper() {
        return this.f1464e;
    }

    public void destroy() {
        synchronized (this.f1468i) {
            if (!this.f1470k) {
                fetchStore();
                destroyStore();
                this.f1470k = true;
            }
        }
    }

    public void recover() {
        synchronized (this.f1468i) {
            synchronized (f1460a) {
                C0580n c0580n = (C0580n) f1460a.get(this.f1462c);
                if (c0580n != null && c0580n.f1890b) {
                    f1460a.remove(this.f1462c);
                }
            }
            if (this.f1470k) {
                this.f1470k = false;
                this.f1469j = null;
            } else if (this.f1469j != null && this.f1469j.f1890b) {
                this.f1469j = null;
            }
        }
    }

    public int queryVersion() {
        int i;
        synchronized (this.f1468i) {
            if (this.f1470k) {
                i = -1;
            } else {
                ensureCacheExisted();
                i = this.f1469j.m2606a();
            }
        }
        return i;
    }

    public void updateVersion(int i) {
        synchronized (this.f1468i) {
            if (this.f1470k) {
                return;
            }
            ensureCacheExisted();
            this.f1469j.m2611a(i);
        }
    }

    public void upgradeVersion(int i) {
        upgradeVersion(i, null);
    }

    public void upgradeVersion(int i, ab abVar) {
        synchronized (this.f1468i) {
            if (this.f1470k) {
                return;
            }
            ensureCacheExisted();
            this.f1469j.m2612a(i, abVar, this.f1464e);
        }
    }

    public TInfo queryInfo() {
        TInfo deserializeInfoFromJson;
        synchronized (this.f1468i) {
            if (this.f1470k) {
                deserializeInfoFromJson = this.f1464e.deserializeInfoFromJson(new JSONObject());
            } else {
                ensureCacheExisted();
                deserializeInfoFromJson = this.f1469j.m2607a(this.f1464e);
            }
        }
        return deserializeInfoFromJson;
    }

    public void updateInfo(TInfo tInfo) {
        synchronized (this.f1468i) {
            if (this.f1470k) {
                return;
            }
            ensureCacheExisted();
            this.f1469j.m2613a((Object) tInfo, this.f1464e);
        }
    }

    public void clearInfo() {
        synchronized (this.f1468i) {
            if (this.f1470k) {
                return;
            }
            ensureCacheExisted();
            this.f1469j.m2613a(null, this.f1464e);
        }
    }

    public final Collection<String> queryItemIds() {
        return queryItemIds(null, null, null);
    }

    public Collection<String> queryItemIds(TFilter tFilter, TComparator tComparator, C0582t c0582t) {
        Collection<String> arrayList;
        synchronized (this.f1468i) {
            if (this.f1470k) {
                arrayList = new ArrayList();
            } else {
                ensureCacheExisted();
                arrayList = this.f1469j.m2609a((IRunTask) tFilter, (Comparator) tComparator, c0582t);
            }
        }
        return arrayList;
    }

    public final Collection<TItem> queryItems() {
        return queryItems(null, null, null);
    }

    public Collection<TItem> queryItems(TFilter tFilter, TComparator tComparator, C0582t c0582t) {
        Collection<TItem> arrayList;
        synchronized (this.f1468i) {
            if (this.f1470k) {
                arrayList = new ArrayList();
            } else {
                ensureCacheExisted();
                arrayList = this.f1469j.m2616b(tFilter, tComparator, c0582t, this.f1463d, this.f1464e);
            }
        }
        return arrayList;
    }

    public final Collection<TItem> queryCorePropertiesOfItems() {
        return queryCorePropertiesOfItems(null, null, null);
    }

    public Collection<TItem> queryCorePropertiesOfItems(TFilter tFilter, TComparator tComparator, C0582t c0582t) {
        Collection<TItem> arrayList;
        synchronized (this.f1468i) {
            if (this.f1470k) {
                arrayList = new ArrayList();
            } else {
                ensureCacheExisted();
                arrayList = this.f1469j.m2610a(tFilter, tComparator, c0582t, this.f1463d, this.f1464e);
            }
        }
        return arrayList;
    }

    public TItem queryItem(String str) {
        TItem tItem = null;
        synchronized (this.f1468i) {
            if (this.f1470k) {
            } else if (str == null) {
            } else {
                ensureCacheExisted();
                tItem = this.f1469j.m2608a(str, this.f1463d, this.f1464e);
            }
        }
        return tItem;
    }

    public final void insertItems(TItem[] tItemArr) {
        insertItems(createItemListFromItemArray(tItemArr));
    }

    public void insertItems(Collection<TItem> collection) {
        synchronized (this.f1468i) {
            if (this.f1470k) {
                return;
            }
            ensureCacheExisted();
            this.f1469j.m2615a(collection, this.f1463d, this.f1464e, this.f1464e);
        }
    }

    public final void insertItem(TItem tItem) {
        insertItems(createItemsFromOneItem(tItem));
    }

    public final void updateItems(TItem[] tItemArr) {
        updateItems(createItemListFromItemArray(tItemArr));
    }

    public synchronized void updateItems(Collection<TItem> collection) {
        synchronized (this.f1468i) {
            if (this.f1470k) {
            } else {
                ensureCacheExisted();
                this.f1469j.m2618b(collection, this.f1463d, this.f1464e, this.f1464e);
            }
        }
    }

    public final void updateItem(TItem tItem) {
        updateItems(createItemsFromOneItem(tItem));
    }

    public final void deleteItems(TItem[] tItemArr) {
        deleteItems(createItemListFromItemArray(tItemArr));
    }

    public final void deleteItems(Collection<TItem> collection) {
        synchronized (this.f1468i) {
            if (this.f1470k) {
                return;
            }
            Collection arrayList = new ArrayList(collection.size());
            for (TItem uniqueId : collection) {
                String uniqueId2 = this.f1464e.getUniqueId(uniqueId);
                if (uniqueId2 != null) {
                    arrayList.add(uniqueId2);
                }
            }
            deleteItemsWithKeys(arrayList);
        }
    }

    public final void deleteItem(TItem tItem) {
        if (tItem != null) {
            deleteItems(createItemsFromOneItem(tItem));
        }
    }

    public void deleteItemsWithKeys(String[] strArr) {
        deleteItemsWithKeys(Arrays.asList(strArr));
    }

    public void deleteItemsWithKeys(Collection<String> collection) {
        synchronized (this.f1468i) {
            if (this.f1470k) {
                return;
            }
            ensureCacheExisted();
            this.f1469j.m2614a((Collection) collection);
        }
    }

    public final void deleteItemWithKey(String str) {
        Collection linkedList = new LinkedList();
        linkedList.add(str);
        deleteItemsWithKeys(linkedList);
    }

    public final void replaceWithItems(TItem[] tItemArr) {
        replaceWithItems(createItemListFromItemArray(tItemArr));
    }

    public synchronized void replaceWithItems(Collection<TItem> collection) {
        synchronized (this.f1468i) {
            if (this.f1470k) {
            } else {
                clearItems();
                insertItems((Collection) collection);
            }
        }
    }

    public void clearItems() {
        synchronized (this.f1468i) {
            if (this.f1470k) {
                return;
            }
            ensureCacheExisted();
            this.f1469j.m2617b();
        }
    }

    private void ensureCacheExisted() {
        if (!this.f1470k) {
            if (this.f1469j == null || this.f1469j.f1890b) {
                createStore();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fetchStore() {
        /*
        r3 = this;
        r1 = f1460a;
        monitor-enter(r1);
        r0 = r3.f1469j;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = f1460a;	 Catch:{ all -> 0x0021 }
        r2 = r3.f1462c;	 Catch:{ all -> 0x0021 }
        r0 = r0.containsKey(r2);	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0024;
    L_0x0013:
        r0 = f1460a;	 Catch:{ all -> 0x0021 }
        r2 = r3.f1462c;	 Catch:{ all -> 0x0021 }
        r0 = r0.get(r2);	 Catch:{ all -> 0x0021 }
        r0 = (com.duokan.reader.common.cache.C0580n) r0;	 Catch:{ all -> 0x0021 }
        r3.f1469j = r0;	 Catch:{ all -> 0x0021 }
    L_0x001f:
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        goto L_0x0008;
    L_0x0021:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        throw r0;
    L_0x0024:
        r0 = 0;
        r3.f1469j = r0;	 Catch:{ all -> 0x0021 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.ListCache.fetchStore():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void createStore() {
        /*
        r6 = this;
        r1 = f1460a;
        monitor-enter(r1);
        r0 = r6.f1469j;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0011;
    L_0x0007:
        r0 = r6.f1469j;	 Catch:{ all -> 0x0029 }
        r0 = r0.f1890b;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x0010:
        return;
    L_0x0011:
        r0 = f1460a;	 Catch:{ all -> 0x0029 }
        r2 = r6.f1462c;	 Catch:{ all -> 0x0029 }
        r0 = r0.containsKey(r2);	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x002c;
    L_0x001b:
        r0 = f1460a;	 Catch:{ all -> 0x0029 }
        r2 = r6.f1462c;	 Catch:{ all -> 0x0029 }
        r0 = r0.get(r2);	 Catch:{ all -> 0x0029 }
        r0 = (com.duokan.reader.common.cache.C0580n) r0;	 Catch:{ all -> 0x0029 }
        r6.f1469j = r0;	 Catch:{ all -> 0x0029 }
    L_0x0027:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        goto L_0x0010;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = new com.duokan.reader.common.cache.n;	 Catch:{ all -> 0x0029 }
        r2 = r6.f1466g;	 Catch:{ all -> 0x0029 }
        r3 = r6.f1462c;	 Catch:{ all -> 0x0029 }
        r4 = r6.f1465f;	 Catch:{ all -> 0x0029 }
        r5 = r6.f1467h;	 Catch:{ all -> 0x0029 }
        r2 = r2.mo767a(r3, r4, r5);	 Catch:{ all -> 0x0029 }
        r0.<init>(r2);	 Catch:{ all -> 0x0029 }
        r6.f1469j = r0;	 Catch:{ all -> 0x0029 }
        r0 = f1460a;	 Catch:{ all -> 0x0029 }
        r2 = r6.f1462c;	 Catch:{ all -> 0x0029 }
        r3 = r6.f1469j;	 Catch:{ all -> 0x0029 }
        r0.put(r2, r3);	 Catch:{ all -> 0x0029 }
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.ListCache.createStore():void");
    }

    private void destroyStore() {
        synchronized (f1460a) {
            if (this.f1469j == null) {
            } else if (this.f1469j.f1890b) {
                this.f1469j = null;
            } else {
                this.f1469j.m2619c();
                this.f1469j = null;
                this.f1466g.mo768a(this.f1462c);
            }
        }
    }

    private Collection<TItem> createItemsFromOneItem(TItem tItem) {
        Collection arrayList = new ArrayList(1);
        arrayList.add(tItem);
        return arrayList;
    }

    private Collection<TItem> createItemListFromItemArray(TItem[] tItemArr) {
        Collection arrayList = new ArrayList(tItemArr.length);
        for (Object add : tItemArr) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
