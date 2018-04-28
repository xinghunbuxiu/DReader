package com.duokan.reader.domain.bookshelf;

import android.net.Uri;
import android.util.SparseArray;
import com.duokan.core.p026a.C0272a;
import com.duokan.reader.ReaderEnv;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BookOrderHelper implements Serializable {
    private static final String DB_NAME = "Bookshelf.meta.db";
    private static boolean mInit = false;
    private final HashMap<String, LinkedList<Long>> mItemIdMap = new HashMap();
    private final C0272a mQueueDb = new C0272a(Uri.fromFile(new File(ReaderEnv.get().getDatabaseDirectory(), DB_NAME)).toString(), Uri.fromFile(new File(ReaderEnv.get().getExternalFilesDirectory(), DB_NAME)).toString());

    protected synchronized void init(aa aaVar) {
        if (!mInit) {
            mInit = true;
            loadList(aaVar);
        }
    }

    public List<an> listItemsByReadingOrder(aa aaVar) {
        int indexOfKey;
        an[] e = aaVar.m3764e();
        List linkedList = new LinkedList();
        SparseArray sparseArray = new SparseArray(e.length);
        for (an anVar : e) {
            sparseArray.append((int) anVar.aH(), anVar);
        }
        Iterator it = getOrderList(aaVar).iterator();
        while (it.hasNext()) {
            Object obj;
            indexOfKey = sparseArray.indexOfKey((int) ((Long) it.next()).longValue());
            if (indexOfKey >= 0) {
                obj = (an) sparseArray.valueAt(indexOfKey);
            } else {
                obj = null;
            }
            if (obj != null) {
                linkedList.add(obj);
                sparseArray.setValueAt(indexOfKey, null);
            }
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            an anVar2 = (an) sparseArray.valueAt(i);
            if (anVar2 != null) {
                linkedList.add(0, anVar2);
            }
        }
        return linkedList;
    }

    public void deleteFromCategory(aa aaVar, an anVar) {
        Serializable orderList = getOrderList(aaVar);
        orderList.remove(Long.valueOf(anVar.aH()));
        this.mQueueDb.m634b(String.valueOf(aaVar.aH()), orderList);
    }

    public void deleteFromCategory(aa aaVar, List<an> list) {
        Serializable orderList = getOrderList(aaVar);
        for (int i = 0; i < list.size(); i++) {
            orderList.remove(Long.valueOf(((an) list.get(i)).aH()));
        }
        this.mQueueDb.m634b(String.valueOf(aaVar.aH()), orderList);
    }

    public void addCategory(aa aaVar, an anVar, int i) {
        Serializable orderList = getOrderList(aaVar);
        orderList.remove(Long.valueOf(anVar.aH()));
        orderList.add(i, Long.valueOf(anVar.aH()));
        this.mQueueDb.m634b(String.valueOf(aaVar.aH()), orderList);
    }

    public void addCategory(aa aaVar, List<C0800c> list) {
        Serializable orderList = getOrderList(aaVar);
        for (an anVar : list) {
            orderList.remove(Long.valueOf(anVar.aH()));
            orderList.add(0, Long.valueOf(anVar.aH()));
        }
        this.mQueueDb.m634b(String.valueOf(aaVar.aH()), orderList);
    }

    public void moveItem(aa aaVar, an anVar, int i) {
        Serializable orderList = getOrderList(aaVar);
        orderList.remove(Long.valueOf(anVar.aH()));
        orderList.add(i, Long.valueOf(anVar.aH()));
        this.mQueueDb.m634b(String.valueOf(aaVar.aH()), orderList);
    }

    private LinkedList<Long> getOrderList(aa aaVar) {
        String valueOf = String.valueOf(aaVar.aH());
        if (!this.mItemIdMap.containsKey(valueOf)) {
            loadList(aaVar);
        }
        return (LinkedList) this.mItemIdMap.get(valueOf);
    }

    private void loadList(aa aaVar) {
        String valueOf = String.valueOf(aaVar.aH());
        Object obj = (LinkedList) this.mQueueDb.m630a(valueOf);
        if (obj == null) {
            Serializable linkedList = new LinkedList();
            an[] e = aaVar.m3764e();
            for (an aH : e) {
                linkedList.add(Long.valueOf(aH.aH()));
            }
            this.mQueueDb.m634b(valueOf, linkedList);
            obj = linkedList;
        }
        this.mItemIdMap.put(valueOf, obj);
    }
}
