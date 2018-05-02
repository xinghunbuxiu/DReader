package com.duokan.reader.ui.personal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.bookshelf.BookActionView;
import com.duokan.reader.ui.bookshelf.hd;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.DkWebListView.ListState;
import com.duokan.reader.ui.general.expandable.ViewMode;
import com.duokan.reader.ui.store.comment.DkCommentScoreView;
import java.util.Calendar;
import java.util.List;

/* renamed from: com.duokan.reader.ui.personal.if */
class C1401if extends hd {
    /* renamed from: a */
    final /* synthetic */ hy f8707a;

    private C1401if(hy hyVar) {
        this.f8707a = hyVar;
    }

    /* renamed from: b */
    protected void mo1555b() {
        this.f8707a.f8685m.clear();
    }

    /* renamed from: e */
    protected boolean mo1712e() {
        this.f8707a.mo1924a(0, 30);
        return true;
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
        this.f8707a.mo1924a(mo506c(), i);
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f8707a.f8685m.size();
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return this.f8707a.f8685m.get(i);
    }

    /* renamed from: a */
    public int mo486a() {
        if (this.f8707a.f8686n.size() == 1 && ((ReadBook) ((List) this.f8707a.f8686n.get(0)).get(0)).getReadTime().before(this.f8707a.f8684l)) {
            return 0;
        }
        return this.f8707a.f8686n.size();
    }

    /* renamed from: a */
    public int mo487a(int i) {
        return ((List) this.f8707a.f8686n.get(i)).size();
    }

    /* renamed from: a */
    public View mo488a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f8707a.getContext()).inflate(C0256h.personal__readed_books_group_view, viewGroup, false);
        }
        Calendar readTime = ((ReadBook) ((List) this.f8707a.f8686n.get(i)).get(0)).getReadTime();
        Calendar j = readTime.before(this.f8707a.f8684l) ? this.f8707a.f8684l : readTime;
        ((TextView) view.findViewById(C0255g.personal__readed_books_item_view__group_year)).setText(String.valueOf(j.get(1)));
        ((TextView) view.findViewById(C0255g.personal__readed_books_item_view__group_month)).setText(String.valueOf(j.get(2) + 1));
        ((TextView) view.findViewById(C0255g.personal__readed_books_item_view__group_size)).setText(String.format(DkApp.get().getString(C0258j.personal__readed_books_group_view__readed_books_monthly), new Object[]{Integer.valueOf(mo487a(i))}));
        if (readTime.before(this.f8707a.f8684l)) {
            view.findViewById(C0255g.personal__readed_books_item_view__group_before).setVisibility(0);
        }
        return view;
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        int i2;
        if (view == null) {
            view = LayoutInflater.from(this.f8707a.getContext()).inflate(C0256h.personal__readed_books_item_view, viewGroup, false);
        }
        ReadBook readBook = (ReadBook) this.f8707a.f8685m.get(i);
        for (int i3 = 0; i3 < mo486a(); i3++) {
            int a = mo487a(i3);
            if (i >= 0 && i < a) {
                i2 = i3;
                break;
            }
            i -= a;
        }
        i2 = 0;
        BookCoverView bookCoverView = (BookCoverView) view.findViewById(C0255g.personal__readed_books_item_view__cover);
        bookCoverView.setOnlineCoverUri(readBook.getCoverUri());
        bookCoverView.setCoverBackgroundResource(C0254f.general__book_cover_view__duokan_cover);
        bookCoverView.m9919a();
        ((TextView) view.findViewById(C0255g.personal__readed_books_item_view__title)).setText(readBook.getTitle());
        ((TextView) view.findViewById(C0255g.personal__readed_books_item_view__author)).setText(readBook.getNameLine());
        DkCommentScoreView dkCommentScoreView = (DkCommentScoreView) view.findViewById(C0255g.personal__readed_books_item_view__rate);
        DkLabelView dkLabelView = (DkLabelView) view.findViewById(C0255g.personal__readed_books_item_view__comment);
        if (readBook.getRate() == 0) {
            dkCommentScoreView.setVisibility(8);
            dkLabelView.setText(DkApp.get().getString(C0258j.personal__readed_books_view__no_comment));
        } else {
            dkCommentScoreView.setVisibility(0);
            dkCommentScoreView.setScore(readBook.getRate());
            dkLabelView.setText(readBook.getComment());
        }
        view.setOnClickListener(new ig(this, i2, i, readBook));
        view.setOnLongClickListener(new ii(this, i2, i));
        BookActionView bookActionView = (BookActionView) view.findViewById(C0255g.personal__readed_books_item_view__edit);
        if (this.f8707a.f8692t.mo1714f() == ViewMode.Edit) {
            bookActionView.setAction(BookAction.EDIT);
            bookActionView.setSelected(this.f8707a.f8692t.mo1713b(i2, i));
            bookActionView.setVisibility(0);
        } else {
            bookActionView.setVisibility(8);
        }
        return view;
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f8707a.getContext()).inflate(C0256h.personal__readed_books_empty_view, viewGroup, false);
    }

    /* renamed from: c */
    public View mo507c(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f8707a.getContext()).inflate(C0256h.personal__readed_books_footer_view, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(C0255g.personal__readed_books_footer_view__local_books);
        long b = this.f8707a.f8690r.mo1906b() - ((long) this.f8707a.f8685m.size());
        if (this.f8707a.f8693u && m8789l() == ListState.LOADING_COMPLETE && b > 0) {
            textView.setVisibility(0);
            textView.setText(String.format(DkApp.get().getString(C0258j.personal__readed_books_group_view__local_book), new Object[]{Long.valueOf(b)}));
        } else {
            textView.setVisibility(8);
        }
        return view;
    }
}
