package com.duokan.reader.ui.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.bo;

class q extends bo {
    final /* synthetic */ n a;

    q(n nVar) {
        this.a = nVar;
    }

    public /* synthetic */ Object d(int i) {
        return c(i);
    }

    protected void b() {
        this.a.c.clear();
    }

    protected void e(int i) {
        this.a.a(this.a.b.getText().toString(), this.a.c.size(), i);
    }

    public int c() {
        return this.a.c.size();
    }

    public DkStoreAbsBook c(int i) {
        return (DkStoreAbsBook) this.a.c.get(i);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.store__list_item_view, viewGroup, false);
        }
        DkStoreAbsBook c = c(i);
        ((BookCoverView) view.findViewById(g.store__list_item_view__cover)).setCoverUri(c.getCoverUri());
        ((TextView) view.findViewById(g.store__list_item_view__first_line)).setText(c.getTitle());
        ((TextView) view.findViewById(g.store__list_item_view__second_line)).setText(c.getNameLine());
        ((TextView) view.findViewById(g.store__list_item_view__third_line)).setText(c.getDescription());
        return view;
    }

    public View a(View view, ViewGroup viewGroup) {
        CharSequence obj = this.a.b.getText().toString();
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.store__list_item_view, viewGroup, false);
        }
        if (TextUtils.isEmpty(obj)) {
            view.findViewById(g.store__list_item_view__no_result_prompt).setVisibility(8);
        } else {
            view.findViewById(g.store__list_item_view__no_result_prompt).setVisibility(0);
        }
        view.findViewById(g.store__list_item_view__content).setVisibility(8);
        return view;
    }
}
