package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.duokan.core.sys.ah;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.hv;
import com.duokan.reader.ui.general.expandable.C1293a;
import java.util.ArrayList;
import java.util.List;

public class fr extends fx {
    /* renamed from: a */
    private boolean f8557a = false;
    /* renamed from: f */
    private boolean f8558f = false;
    /* renamed from: g */
    private List<DkCloudStoreBook> f8559g = new ArrayList();
    /* renamed from: h */
    private List<DkCloudStoreBook> f8560h = new ArrayList();

    /* renamed from: a */
    public /* synthetic */ Object mo1873a(int i) {
        return m11833c(i);
    }

    public fr(Context context, C1293a c1293a, ks ksVar, hv hvVar, fy fyVar) {
        super(context, c1293a, ksVar, hvVar, fyVar);
    }

    /* renamed from: a */
    public int mo1871a() {
        return mo1875b() > 0 ? 1 : 0;
    }

    /* renamed from: b */
    public int mo1875b() {
        return this.f8560h.size();
    }

    /* renamed from: c */
    public DkCloudStoreBook m11833c(int i) {
        return (DkCloudStoreBook) this.f8560h.get(i);
    }

    /* renamed from: b */
    public int mo1876b(int i) {
        return this.f8560h.size();
    }

    /* renamed from: a */
    public View mo1872a(int i, View view, ViewGroup viewGroup) {
        View a = this.d.m12091a(m11833c(i), view, viewGroup, this.c, m11825c(), i);
        a.setOnClickListener(new fs(this, i));
        a.setOnLongClickListener(new ft(this, i));
        return a;
    }

    /* renamed from: b */
    public View mo1877b(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    /* renamed from: a */
    public void mo1874a(List<DkCloudStoreBook> list, List<DkCloudStoreBook> list2, List<DkCloudStoreBook> list3, Runnable runnable) {
        ah.m865a(new fu(this, list, list3, list2, runnable));
    }

    /* renamed from: c */
    private int m11825c() {
        if (this.f8558f && this.f8557a) {
            return 2;
        }
        if (this.f8558f || this.f8557a) {
            return 1;
        }
        return 0;
    }
}
