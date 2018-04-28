package com.duokan.reader.ui.personal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.duokan.p024c.C0256h;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.ui.general.bo;

class na extends bo {
    /* renamed from: a */
    final /* synthetic */ mz f8976a;

    na(mz mzVar) {
        this.f8976a = mzVar;
    }

    /* renamed from: d */
    public /* synthetic */ Object mo509d(int i) {
        return mo1556c(i);
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f8976a.f8950e.size();
    }

    /* renamed from: b */
    protected void mo1555b() {
        this.f8976a.f8950e.clear();
    }

    /* renamed from: c */
    public DkCloudComment mo1556c(int i) {
        return (DkCloudComment) this.f8976a.f8950e.get(i);
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
        this.f8976a.mo1965a(i);
    }

    /* renamed from: e */
    protected boolean mo1712e() {
        this.f8976a.mo1965a(this.f8976a.f8950e.size() + 1);
        return true;
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f8976a.getContext()).inflate(C0256h.personal__notes_info_item_view, null);
        }
        this.f8976a.mo1967a(view, i);
        return view;
    }
}
