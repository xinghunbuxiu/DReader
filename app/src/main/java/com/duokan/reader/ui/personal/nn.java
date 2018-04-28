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

public class nn extends fx {
    /* renamed from: a */
    private boolean f9002a = false;
    /* renamed from: f */
    private boolean f9003f = false;
    /* renamed from: g */
    private List<DkCloudStoreBook> f9004g = new ArrayList();
    /* renamed from: h */
    private List<DkCloudStoreBook> f9005h = new ArrayList();

    /* renamed from: a */
    public /* synthetic */ Object mo1873a(int i) {
        return m12362c(i);
    }

    public nn(Context context, C1293a c1293a, ks ksVar, hv hvVar, fy fyVar) {
        super(context, c1293a, ksVar, hvVar, fyVar);
    }

    /* renamed from: a */
    public int mo1871a() {
        return mo1875b() > 0 ? 1 : 0;
    }

    /* renamed from: b */
    public int mo1875b() {
        return this.f9005h.size();
    }

    /* renamed from: c */
    public DkCloudStoreBook m12362c(int i) {
        return (DkCloudStoreBook) this.f9005h.get(i);
    }

    /* renamed from: b */
    public int mo1876b(int i) {
        return this.f9005h.size();
    }

    /* renamed from: a */
    public View mo1872a(int i, View view, ViewGroup viewGroup) {
        View a = this.d.m12091a(m12362c(i), view, viewGroup, this.c, m12354c(), i);
        a.setOnClickListener(new no(this, i));
        a.setOnLongClickListener(new np(this, i));
        return a;
    }

    /* renamed from: b */
    public View mo1877b(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    /* renamed from: a */
    public void mo1874a(List<DkCloudStoreBook> list, List<DkCloudStoreBook> list2, List<DkCloudStoreBook> list3, Runnable runnable) {
        ah.m865a(new nq(this, list, list3, list2, runnable));
    }

    /* renamed from: c */
    private int m12354c() {
        if (this.f9003f && this.f9002a) {
            return 2;
        }
        if (this.f9003f || this.f9002a) {
            return 1;
        }
        return 0;
    }
}
