package com.duokan.reader.ui.bookshelf;

import android.view.View;
import com.duokan.core.ui.ay;
import com.duokan.core.ui.OnItemClickListener;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.aa;
import java.util.ArrayList;
import java.util.List;

class hr implements OnItemClickListener {
    /* renamed from: a */
    final /* synthetic */ hk f6567a;
    /* renamed from: b */
    final /* synthetic */ List f6568b;
    /* renamed from: c */
    final /* synthetic */ ho f6569c;

    hr(ho hoVar, hk hkVar, List list) {
        this.f6569c = hoVar;
        this.f6567a = hkVar;
        this.f6568b = list;
    }

    /* renamed from: a */
    public void onItemClick(ay ayVar, View view, int i) {
        if (this.f6569c.f6562b.f6555b.m9446g()) {
            List arrayList = new ArrayList();
            arrayList.add((C0800c) this.f6569c.f6562b.f6554a);
            this.f6569c.f6562b.f6555b.m9439a(arrayList, (aa) this.f6568b.get(i));
            this.f6569c.f6562b.dismiss();
            this.f6569c.f6562b.f6555b.m9447h();
        }
    }
}
