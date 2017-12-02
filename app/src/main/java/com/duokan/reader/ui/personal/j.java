package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.bookshelf.BookActionView;
import com.duokan.reader.ui.bookshelf.gw;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.expandable.ViewMode;

class j extends gw {
    final /* synthetic */ e a;

    private j(e eVar) {
        this.a = eVar;
    }

    public /* synthetic */ Object d(int i) {
        return h(i);
    }

    protected void b() {
    }

    protected void e(int i) {
    }

    public int c() {
        return this.a.k.size();
    }

    public c h(int i) {
        return (c) this.a.k.get(i);
    }

    protected int k() {
        return 1;
    }

    protected int f(int i) {
        return c();
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        c h = h(i);
        if (view == null || view.findViewById(g.personal__auto_buy_item_view__cover) == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.personal__auto_buy_item_view, viewGroup, false);
        }
        BookCoverView bookCoverView = (BookCoverView) view.findViewById(g.personal__auto_buy_item_view__cover);
        if (h.ai()) {
            bookCoverView.setOnlineCoverUri(h.g());
            bookCoverView.setCoverBackgroundResource(f.general__book_cover_view__duokan_cover);
            bookCoverView.a();
        }
        ((TextView) view.findViewById(g.personal__auto_buy_item_view__title)).setText(h.aw());
        TextView textView = (TextView) view.findViewById(g.personal__auto_buy_item_view__author);
        if (TextUtils.isEmpty(h.B())) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(h.B());
        }
        ((TextView) view.findViewById(g.personal__auto_buy_item_view__last_reading_time)).setVisibility(4);
        BookActionView bookActionView = (BookActionView) view.findViewById(g.personal__auto_buy_item_view__edit);
        if (f() == ViewMode.Edit) {
            bookActionView.setAction(BookAction.EDIT);
            bookActionView.setSelected(b(0, i));
            bookActionView.setVisibility(0);
        } else {
            bookActionView.setVisibility(8);
        }
        return view;
    }

    public View a(View view, ViewGroup viewGroup) {
        return LayoutInflater.from(this.a.getContext()).inflate(h.personal__auto_buy_empty_view, viewGroup, false);
    }
}
