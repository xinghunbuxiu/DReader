package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.ViewGroup;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.hu;
import java.util.LinkedList;
import java.util.List;

class lh implements hu {
    /* renamed from: a */
    final /* synthetic */ lc f8884a;

    lh(lc lcVar) {
        this.f8884a = lcVar;
    }

    /* renamed from: a */
    public int mo1716a() {
        return 0;
    }

    /* renamed from: a */
    public void mo1719a(String str) {
        if (str == null || str.length() == 0) {
            this.f8884a.mo1941f();
            return;
        }
        List<DkCloudStoreBook> r = this.f8884a.mo1903d().mo1955r();
        List linkedList = new LinkedList();
        if (str != null && str.length() > 0) {
            for (DkCloudStoreBook dkCloudStoreBook : r) {
                if (this.f8884a.m12145a(dkCloudStoreBook, str)) {
                    linkedList.add(dkCloudStoreBook);
                }
            }
        }
        this.f8884a.f8858l.m12170a(linkedList, str);
        this.f8884a.mo1940e();
    }

    /* renamed from: a */
    public View mo1717a(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    /* renamed from: a */
    public void mo1718a(int i, View view) {
    }

    /* renamed from: b */
    public boolean mo1720b(int i, View view) {
        return false;
    }
}
