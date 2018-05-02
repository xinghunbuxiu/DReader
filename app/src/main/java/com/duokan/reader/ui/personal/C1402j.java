package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.bookshelf.BookActionView;
import com.duokan.reader.ui.bookshelf.hd;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.expandable.ViewMode;

/* renamed from: com.duokan.reader.ui.personal.j */
class C1402j extends hd {
    /* renamed from: a */
    final /* synthetic */ C1396e f8757a;

    private C1402j(C1396e c1396e) {
        this.f8757a = c1396e;
    }

    /* renamed from: d */
    public /* synthetic */ Object mo509d(int i) {
        return m12035h(i);
    }

    /* renamed from: b */
    protected void mo1555b() {
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f8757a.f8479l.size();
    }

    /* renamed from: h */
    public C0800c m12035h(int i) {
        return (C0800c) this.f8757a.f8479l.get(i);
    }

    /* renamed from: k */
    protected int mo1867k() {
        return 1;
    }

    /* renamed from: f */
    protected int mo1866f(int i) {
        return mo506c();
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        C0800c h = m12035h(i);
        if (view == null || view.findViewById(C0255g.personal__auto_buy_item_view__cover) == null) {
            view = LayoutInflater.from(this.f8757a.getContext()).inflate(C0256h.personal__auto_buy_item_view, viewGroup, false);
        }
        BookCoverView bookCoverView = (BookCoverView) view.findViewById(C0255g.personal__auto_buy_item_view__cover);
        if (h.ak()) {
            bookCoverView.setOnlineCoverUri(h.m4228g());
            bookCoverView.setCoverBackgroundResource(C0254f.general__book_cover_view__duokan_cover);
            bookCoverView.m9919a();
        }
        ((TextView) view.findViewById(C0255g.personal__auto_buy_item_view__title)).setText(h.ay());
        TextView textView = (TextView) view.findViewById(C0255g.personal__auto_buy_item_view__author);
        if (TextUtils.isEmpty(h.m4150C())) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(h.m4150C());
        }
        ((TextView) view.findViewById(C0255g.personal__auto_buy_item_view__last_reading_time)).setVisibility(4);
        BookActionView bookActionView = (BookActionView) view.findViewById(C0255g.personal__auto_buy_item_view__edit);
        if (mo1714f() == ViewMode.Edit) {
            bookActionView.setAction(BookAction.EDIT);
            bookActionView.setSelected(mo1713b(0, i));
            bookActionView.setVisibility(0);
        } else {
            bookActionView.setVisibility(8);
        }
        return view;
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f8757a.getContext()).inflate(C0256h.personal__auto_buy_empty_view, viewGroup, false);
    }
}
