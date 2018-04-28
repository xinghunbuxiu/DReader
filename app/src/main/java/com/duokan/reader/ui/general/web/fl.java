package com.duokan.reader.ui.general.web;

import android.graphics.Rect;
import com.duokan.core.sys.as;
import com.duokan.reader.ui.general.bx;

class fl implements as {
    /* renamed from: a */
    final /* synthetic */ Rect f7838a;
    /* renamed from: b */
    final /* synthetic */ String[] f7839b;
    /* renamed from: c */
    final /* synthetic */ String f7840c;
    /* renamed from: d */
    final /* synthetic */ fk f7841d;

    fl(fk fkVar, Rect rect, String[] strArr, String str) {
        this.f7841d = fkVar;
        this.f7838a = rect;
        this.f7839b = strArr;
        this.f7840c = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        int i = 0;
        this.f7838a.offset(0, this.f7841d.f7837b.f7581b.mPageHeaderView == null ? 0 : this.f7841d.f7837b.f7581b.mPageHeaderView.getHeight());
        bx bxVar = new bx(this.f7841d.f7837b.f7581b.getContext(), true);
        while (i < this.f7839b.length) {
            bxVar.m10320a(this.f7839b[i]);
            i++;
        }
        bxVar.m10323a(new fm(this));
        bxVar.m10321a(this.f7838a);
        bxVar.open(new fn(this));
    }
}
