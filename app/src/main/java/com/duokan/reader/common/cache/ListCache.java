package com.duokan.reader.common.cache;

import com.duokan.core.c.IRunTask;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class ListCache {
    private static final HashMap a = new HashMap();
    private static final HashMap b = new HashMap();
    private final String c;
    private final q d;
    private final u e;
    private final Comparator f;
    private final y g;
    private final int h;
    private final Object i;
    private n j;
    private boolean k = false;

    public enum ListCacheStoreChangeType {
        SaveItem,
        DeleteItem,
        ClearItems,
        UpdateInfo,
        UpdateVersion
    }

    public ListCache(String str, q qVar, u uVar, Comparator comparator, y yVar, int i) {
        this.c = str;
        this.d = qVar;
        this.e = uVar;
        this.f = comparator;
        this.g = yVar;
        this.h = i;
        synchronized (b) {
            if (!b.containsKey(this.c)) {
                b.put(this.c, new Object());
            }
            this.i = b.get(this.c);
        }
        this.k = false;
    }

    public u getListCacheHelper() {
        return this.e;
    }

    public void destroy() {
        synchronized (this.i) {
            if (!this.k) {
                fetchStore();
                destroyStore();
                this.k = true;
            }
        }
    }

    public void recover() {
        synchronized (this.i) {
            synchronized (a) {
                n nVar = (n) a.get(this.c);
                if (nVar != null && nVar.b) {
                    a.remove(this.c);
                }
            }
            if (this.k) {
                this.k = false;
                this.j = null;
            } else if (this.j != null && this.j.b) {
                this.j = null;
            }
        }
    }

    public int queryVersion() {
        int i;
        synchronized (this.i) {
            if (this.k) {
                i = -1;
            } else {
                ensureCacheExisted();
                i = this.j.a();
            }
        }
        return i;
    }

    public void updateVersion(int i) {
        synchronized (this.i) {
            if (this.k) {
                return;
            }
            ensureCacheExisted();
            this.j.a(i);
        }
    }

    public void upgradeVersion(int i) {
        upgradeVersion(i, null);
    }

    public void upgradeVersion(int i, ab abVar) {
        synchronized (this.i) {
            if (this.k) {
                return;
            }
            ensureCacheExisted();
            this.j.a(i, abVar, this.e);
        }
    }

    public Object queryInfo() {
        Object deserializeInfoFromJson;
        synchronized (this.i) {
            if (this.k) {
                deserializeInfoFromJson = this.e.deserializeInfoFromJson(new JSONObject());
            } else {
                ensureCacheExisted();
                deserializeInfoFromJson = this.j.a(this.e);
            }
        }
        return deserializeInfoFromJson;
    }

    public void updateInfo(Object obj) {
        synchronized (this.i) {
            if (this.k) {
                return;
            }
            ensureCacheExisted();
            this.j.a(obj, this.e);
        }
    }

    public void clearInfo() {
        synchronized (this.i) {
            if (this.k) {
                return;
            }
            ensureCacheExisted();
            this.j.a(null, this.e);
        }
    }

    public final Collection queryItemIds() {
        return queryItemIds(null, null, null);
    }

    public Collection queryItemIds(IRunTask bVar, Comparator comparator, t tVar) {
        Collection arrayList;
        synchronized (this.i) {
            if (this.k) {
                arrayList = new ArrayList();
            } else {
                ensureCacheExisted();
                arrayList = this.j.a(bVar, comparator, tVar);
            }
        }
        return arrayList;
    }

    public final Collection queryItems() {
        return queryItems(null, null, null);
    }

    public Collection queryItems(IRunTask bVar, Comparator comparator, t tVar) {
        Collection arrayList;
        synchronized (this.i) {
            if (this.k) {
                arrayList = new ArrayList();
            } else {
                ensureCacheExisted();
                arrayList = this.j.b(bVar, comparator, tVar, this.d, this.e);
            }
        }
        return arrayList;
    }

    public final Collection queryCorePropertiesOfItems() {
        return queryCorePropertiesOfItems(null, null, null);
    }

    public Collection queryCorePropertiesOfItems(IRunTask bVar, Comparator comparator, t tVar) {
        Collection arrayList;
        synchronized (this.i) {
            if (this.k) {
                arrayList = new ArrayList();
            } else {
                ensureCacheExisted();
                arrayList = this.j.a(bVar, comparator, tVar, this.d, this.e);
            }
        }
        return arrayList;
    }

    public Object queryItem(String str) {
        Object obj = null;
        synchronized (this.i) {
            if (this.k) {
            } else if (str == null) {
            } else {
                ensureCacheExisted();
                obj = this.j.a(str, this.d, this.e);
            }
        }
        return obj;
    }

    public final void insertItems(Object[] objArr) {
        insertItems(createItemListFromItemArray(objArr));
    }

    public void insertItems(Collection collection) {
        synchronized (this.i) {
            if (this.k) {
                return;
            }
            ensureCacheExisted();
            this.j.a(collection, this.d, this.e, this.e);
        }
    }

    public final void insertItem(Object obj) {
        insertItems(createItemsFromOneItem(obj));
    }

    public final void updateItems(Object[] objArr) {
        updateItems(createItemListFromItemArray(objArr));
    }

    public synchronized void updateItems(Collection collection) {
        synchronized (this.i) {
            if (this.k) {
            } else {
                ensureCacheExisted();
                this.j.b(collection, this.d, this.e, this.e);
            }
        }
    }

    public final void updateItem(Object obj) {
        updateItems(createItemsFromOneItem(obj));
    }

    public final void deleteItems(Object[] objArr) {
        deleteItems(createItemListFromItemArray(objArr));
    }

    public final void deleteItems(Collection collection) {
        synchronized (this.i) {
            if (this.k) {
                return;
            }
            Collection arrayList = new ArrayList(collection.size());
            for (Object uniqueId : collection) {
                String uniqueId2 = this.e.getUniqueId(uniqueId);
                if (uniqueId2 != null) {
                    arrayList.add(uniqueId2);
                }
            }
            deleteItemsWithKeys(arrayList);
        }
    }

    public final void deleteItem(Object obj) {
        if (obj != null) {
            deleteItems(createItemsFromOneItem(obj));
        }
    }

    public void deleteItemsWithKeys(String[] strArr) {
        deleteItemsWithKeys(Arrays.asList(strArr));
    }

    public void deleteItemsWithKeys(Collection collection) {
        synchronized (this.i) {
            if (this.k) {
                return;
            }
            ensureCacheExisted();
            this.j.a(collection);
        }
    }

    public final void deleteItemWithKey(String str) {
        Collection linkedList = new LinkedList();
        linkedList.add(str);
        deleteItemsWithKeys(linkedList);
    }

    public final void replaceWithItems(Object[] objArr) {
        replaceWithItems(createItemListFromItemArray(objArr));
    }

    public synchronized void replaceWithItems(Collection collection) {
        synchronized (this.i) {
            if (this.k) {
            } else {
                clearItems();
                insertItems(collection);
            }
        }
    }

    public void clearItems() {
        synchronized (this.i) {
            if (this.k) {
                return;
            }
            ensureCacheExisted();
            this.j.b();
        }
    }

    private void ensureCacheExisted() {
        if (!this.k) {
            if (this.j == null || this.j.b) {
                createStore();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fetchStore() {
        /*
        r3 = this;
        r1 = setDrawable;
        monitor-enter(r1);
        r0 = r3.getWidthPixels;	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = setDrawable;	 Catch:{ all -> 0x0021 }
        r2 = r3.showAnimation;	 Catch:{ all -> 0x0021 }
        r0 = r0.containsKey(r2);	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0024;
    L_0x0013:
        r0 = setDrawable;	 Catch:{ all -> 0x0021 }
        r2 = r3.showAnimation;	 Catch:{ all -> 0x0021 }
        r0 = r0.getAllSortStackTraces(r2);	 Catch:{ all -> 0x0021 }
        r0 = (com.duokan.reader.common.cache.n) r0;	 Catch:{ all -> 0x0021 }
        r3.getWidthPixels = r0;	 Catch:{ all -> 0x0021 }
    L_0x001f:
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        goto L_0x0008;
    L_0x0021:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        throw r0;
    L_0x0024:
        r0 = 0;
        r3.getWidthPixels = r0;	 Catch:{ all -> 0x0021 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.ListCache.fetchStore():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void createStore() {
        /*
        r6 = this;
        r1 = setDrawable;
        monitor-enter(r1);
        r0 = r6.getWidthPixels;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0011;
    L_0x0007:
        r0 = r6.getWidthPixels;	 Catch:{ all -> 0x0029 }
        r0 = r0.getVisible;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x0010:
        return;
    L_0x0011:
        r0 = setDrawable;	 Catch:{ all -> 0x0029 }
        r2 = r6.showAnimation;	 Catch:{ all -> 0x0029 }
        r0 = r0.containsKey(r2);	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x002c;
    L_0x001b:
        r0 = setDrawable;	 Catch:{ all -> 0x0029 }
        r2 = r6.showAnimation;	 Catch:{ all -> 0x0029 }
        r0 = r0.getAllSortStackTraces(r2);	 Catch:{ all -> 0x0029 }
        r0 = (com.duokan.reader.common.cache.n) r0;	 Catch:{ all -> 0x0029 }
        r6.getWidthPixels = r0;	 Catch:{ all -> 0x0029 }
    L_0x0027:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        goto L_0x0010;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = new com.duokan.reader.common.cache.n;	 Catch:{ all -> 0x0029 }
        r2 = r6.SessionTask;	 Catch:{ all -> 0x0029 }
        r3 = r6.showAnimation;	 Catch:{ all -> 0x0029 }
        r4 = r6.HttpLogger;	 Catch:{ all -> 0x0029 }
        r5 = r6.getPhysicalXPixels;	 Catch:{ all -> 0x0029 }
        r2 = r2.setDrawable(r3, r4, r5);	 Catch:{ all -> 0x0029 }
        r0.<init>(r2);	 Catch:{ all -> 0x0029 }
        r6.getWidthPixels = r0;	 Catch:{ all -> 0x0029 }
        r0 = setDrawable;	 Catch:{ all -> 0x0029 }
        r2 = r6.showAnimation;	 Catch:{ all -> 0x0029 }
        r3 = r6.getWidthPixels;	 Catch:{ all -> 0x0029 }
        r0.put(r2, r3);	 Catch:{ all -> 0x0029 }
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.ListCache.createStore():void");
    }

    private void destroyStore() {
        synchronized (a) {
            if (this.j == null) {
            } else if (this.j.b) {
                this.j = null;
            } else {
                this.j.c();
                this.j = null;
                this.g.a(this.c);
            }
        }
    }

    private Collection createItemsFromOneItem(Object obj) {
        Collection arrayList = new ArrayList(1);
        arrayList.add(obj);
        return arrayList;
    }

    private Collection createItemListFromItemArray(Object[] objArr) {
        Collection arrayList = new ArrayList(objArr.length);
        for (Object add : objArr) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
