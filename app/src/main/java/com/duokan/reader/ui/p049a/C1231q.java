package com.duokan.reader.ui.p049a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.bo;

/* renamed from: com.duokan.reader.ui.a.q */
class C1231q extends bo {
    /* renamed from: a */
    final /* synthetic */ C1228n f5733a;

    C1231q(C1228n c1228n) {
        this.f5733a = c1228n;
    }

    /* renamed from: d */
    public /* synthetic */ Object mo509d(int i) {
        return mo1556c(i);
    }

    /* renamed from: b */
    protected void mo1555b() {
        this.f5733a.f5728c.clear();
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
        this.f5733a.m8776a(this.f5733a.f5727b.getText().toString(), this.f5733a.f5728c.size(), i);
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f5733a.f5728c.size();
    }

    /* renamed from: c */
    public DkStoreAbsBook mo1556c(int i) {
        return (DkStoreAbsBook) this.f5733a.f5728c.get(i);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f5733a.getContext()).inflate(C0256h.store__list_item_view, viewGroup, false);
        }
        DkStoreAbsBook c = mo1556c(i);
        ((BookCoverView) view.findViewById(C0255g.store__list_item_view__cover)).setCoverUri(c.getCoverUri());
        ((TextView) view.findViewById(C0255g.store__list_item_view__first_line)).setText(c.getTitle());
        ((TextView) view.findViewById(C0255g.store__list_item_view__second_line)).setText(c.getNameLine());
        ((TextView) view.findViewById(C0255g.store__list_item_view__third_line)).setText(c.getDescription());
        return view;
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        CharSequence obj = this.f5733a.f5727b.getText().toString();
        if (view == null) {
            view = LayoutInflater.from(this.f5733a.getContext()).inflate(C0256h.store__list_item_view, viewGroup, false);
        }
        if (TextUtils.isEmpty(obj)) {
            view.findViewById(C0255g.store__list_item_view__no_result_prompt).setVisibility(8);
        } else {
            view.findViewById(C0255g.store__list_item_view__no_result_prompt).setVisibility(0);
        }
        view.findViewById(C0255g.store__list_item_view__content).setVisibility(8);
        return view;
    }
}
