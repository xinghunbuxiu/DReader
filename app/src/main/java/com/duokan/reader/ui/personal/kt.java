package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.ViewGroup;

import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.hn;

import java.util.LinkedList;
import java.util.List;

class kt implements hn {
    final /* synthetic */ ko a;

    kt(ko koVar) {
        this.a = koVar;
    }

    public int a() {
        return 0;
    }

    public void a(String str) {
        if (str == null || str.length() == 0) {
            this.a.f();
            return;
        }
        List<DkCloudStoreBook> r = this.a.d().r();
        List linkedList = new LinkedList();
        if (str != null && str.length() > 0) {
            for (DkCloudStoreBook dkCloudStoreBook : r) {
                if (this.a.a(dkCloudStoreBook, str)) {
                    linkedList.add(dkCloudStoreBook);
                }
            }
        }
        this.a.k.a(linkedList, str);
        this.a.e();
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public void a(int i, View view) {
    }

    public boolean b(int i, View view) {
        return false;
    }
}
