package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.ViewGroup;
import com.duokan.reader.ui.bookshelf.hu;
import java.util.LinkedList;
import java.util.List;

class en implements hu {
    /* renamed from: a */
    final /* synthetic */ ek f8511a;

    en(ek ekVar) {
        this.f8511a = ekVar;
    }

    /* renamed from: a */
    public int mo1716a() {
        return 0;
    }

    /* renamed from: a */
    public void mo1719a(String str) {
        if (str == null || str.length() == 0) {
            this.f8511a.mo1941f();
            return;
        }
        List<CustomCloudItem> cloudItem = this.f8511a.getCloudItem();
        List linkedList = new LinkedList();
        for (CustomCloudItem customCloudItem : cloudItem) {
            if (customCloudItem.m11345g().toLowerCase().contains(str.toLowerCase())) {
                linkedList.add(customCloudItem);
            }
        }
        this.f8511a.f8502l.m11410a(linkedList, str);
        this.f8511a.mo1940e();
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
