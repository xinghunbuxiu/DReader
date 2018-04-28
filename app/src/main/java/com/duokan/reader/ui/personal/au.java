package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.in;
import com.duokan.reader.domain.bookshelf.ip;
import java.util.Iterator;

class au implements in, ip {
    private au() {
    }

    public void onItemChanged(an anVar, int i) {
        if ((anVar instanceof C0800c) && (i & 72) != 0) {
            C0800c c0800c = (C0800c) anVar;
            Iterator it = CustomCloudItemView.f8202a.iterator();
            while (it.hasNext()) {
                CustomCloudItemView customCloudItemView = (CustomCloudItemView) it.next();
                if ((customCloudItemView.getTag() instanceof CustomCloudItem) && ((CustomCloudItem) customCloudItemView.getTag()).m11340b() == c0800c) {
                    customCloudItemView.m11350b();
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo1683a(C0800c c0800c) {
        Iterator it = CustomCloudItemView.f8202a.iterator();
        while (it.hasNext()) {
            CustomCloudItemView customCloudItemView = (CustomCloudItemView) it.next();
            if ((customCloudItemView.getTag() instanceof CustomCloudItem) && ((CustomCloudItem) customCloudItemView.getTag()).m11340b() == c0800c) {
                customCloudItemView.m11350b();
                return;
            }
        }
    }
}
