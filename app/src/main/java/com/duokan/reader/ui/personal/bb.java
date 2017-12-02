package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.bookshelf.iv;

import java.util.Iterator;

class bb implements it, iv {
    private bb() {
    }

    public void onItemChanged(an anVar, int i) {
        if ((anVar instanceof c) && (i & 72) != 0) {
            c cVar = (c) anVar;
            Iterator it = CustomCloudItemView.a.iterator();
            while (it.hasNext()) {
                CustomCloudItemView customCloudItemView = (CustomCloudItemView) it.next();
                if ((customCloudItemView.getTag() instanceof CustomCloudItem) && ((CustomCloudItem) customCloudItemView.getTag()).b() == cVar) {
                    customCloudItemView.b();
                    return;
                }
            }
        }
    }

    public void a(c cVar) {
        Iterator it = CustomCloudItemView.a.iterator();
        while (it.hasNext()) {
            CustomCloudItemView customCloudItemView = (CustomCloudItemView) it.next();
            if ((customCloudItemView.getTag() instanceof CustomCloudItem) && ((CustomCloudItem) customCloudItemView.getTag()).b() == cVar) {
                customCloudItemView.b();
                return;
            }
        }
    }
}
