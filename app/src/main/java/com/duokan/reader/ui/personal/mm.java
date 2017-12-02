package com.duokan.reader.ui.personal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.c.h;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.ui.general.bo;

class mm extends bo {
    final /* synthetic */ ml a;

    mm(ml mlVar) {
        this.a = mlVar;
    }

    public /* synthetic */ Object d(int i) {
        return c(i);
    }

    public int c() {
        return this.a.e.size();
    }

    protected void b() {
        this.a.e.clear();
    }

    public DkCloudComment c(int i) {
        return (DkCloudComment) this.a.e.get(i);
    }

    protected void e(int i) {
        this.a.a(i);
    }

    protected boolean e() {
        this.a.a(this.a.e.size() + 1);
        return true;
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.personal__notes_info_item_view, null);
        }
        this.a.a(view, i);
        return view;
    }
}
