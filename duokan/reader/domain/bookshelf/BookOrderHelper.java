package com.duokan.reader.domain.bookshelf;

import android.net.Uri;
import android.util.SparseArray;

import com.duokan.core.a.a;
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
    private final HashMap mItemIdMap = new HashMap();
    private final a mQueueDb = new a(Uri.fromFile(new File(ReaderEnv.get().getDatabaseDirectory(), DB_NAME)).toString(), Uri.fromFile(new File(ReaderEnv.get().getExternalFilesDirectory(), DB_NAME)).toString());

    protected synchronized void init(aa aaVar) {
        if (!mInit) {
            mInit = true;
            loadList(aaVar);
        }
    }

    public List listItemsByReadingOrder(aa aaVar) {
        int indexOfKey;
        an[] e = aaVar.e();
        List linkedList = new LinkedList();
        SparseArray sparseArray = new SparseArray(e.length);
        for (an anVar : e) {
            sparseArray.append((int) anVar.aF(), anVar);
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
        orderList.remove(Long.valueOf(anVar.aF()));
        this.mQueueDb.b(String.valueOf(aaVar.aF()), orderList);
    }

    public void deleteFromCategory(aa aaVar, List list) {
        Serializable orderList = getOrderList(aaVar);
        for (int i = 0; i < list.size(); i++) {
            orderList.remove(Long.valueOf(((an) list.get(i)).aF()));
        }
        this.mQueueDb.b(String.valueOf(aaVar.aF()), orderList);
    }

    public void addCategory(aa aaVar, an anVar, int i) {
        Serializable orderList = getOrderList(aaVar);
        orderList.remove(Long.valueOf(anVar.aF()));
        orderList.add(i, Long.valueOf(anVar.aF()));
        this.mQueueDb.b(String.valueOf(aaVar.aF()), orderList);
    }

    public void addCategory(aa aaVar, List list) {
        Serializable orderList = getOrderList(aaVar);
        for (an anVar : list) {
            orderList.remove(Long.valueOf(anVar.aF()));
            orderList.add(0, Long.valueOf(anVar.aF()));
        }
        this.mQueueDb.b(String.valueOf(aaVar.aF()), orderList);
    }

    public void moveItem(aa aaVar, an anVar, int i) {
        Serializable orderList = getOrderList(aaVar);
        orderList.remove(Long.valueOf(anVar.aF()));
        orderList.add(i, Long.valueOf(anVar.aF()));
        this.mQueueDb.b(String.valueOf(aaVar.aF()), orderList);
    }

    private LinkedList getOrderList(aa aaVar) {
        String valueOf = String.valueOf(aaVar.aF());
        if (!this.mItemIdMap.containsKey(valueOf)) {
            loadList(aaVar);
        }
        return (LinkedList) this.mItemIdMap.get(valueOf);
    }

    private void loadList(aa aaVar) {
        String valueOf = String.valueOf(aaVar.aF());
        Object obj = (LinkedList) this.mQueueDb.a(valueOf);
        if (obj == null) {
            Serializable linkedList = new LinkedList();
            an[] e = aaVar.e();
            for (an aF : e) {
                linkedList.add(Long.valueOf(aF.aF()));
            }
            this.mQueueDb.b(valueOf, linkedList);
            obj = linkedList;
        }
        this.mItemIdMap.put(valueOf, obj);
    }
}
