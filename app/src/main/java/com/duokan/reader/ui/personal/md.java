package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.ViewGroup;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.hu;
import java.util.LinkedList;
import java.util.List;

class md implements hu {
    /* renamed from: a */
    final /* synthetic */ mc f8928a;

    md(mc mcVar) {
        this.f8928a = mcVar;
    }

    /* renamed from: a */
    public int mo1716a() {
        return 0;
    }

    /* renamed from: a */
    public void mo1719a(String str) {
        if (str == null || str.length() == 0) {
            this.f8928a.mo1941f();
            return;
        }
        List<DkCloudStoreBook> a = this.f8928a.f8927n;
        List linkedList = new LinkedList();
        if (str != null && str.length() > 0) {
            for (DkCloudStoreBook dkCloudStoreBook : a) {
                if (this.f8928a.m12245a(dkCloudStoreBook, str)) {
                    linkedList.add(dkCloudStoreBook);
                }
            }
        }
        this.f8928a.f8925l.m12170a(linkedList, str);
        this.f8928a.mo1940e();
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
