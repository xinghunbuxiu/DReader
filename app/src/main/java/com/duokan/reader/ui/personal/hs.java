package com.duokan.reader.ui.personal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.bookshelf.BookActionView;
import com.duokan.reader.ui.bookshelf.gw;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.DkWebListView.ListState;
import com.duokan.reader.ui.general.expandable.ViewMode;
import com.duokan.reader.ui.store.comment.DkCommentScoreView;

import java.util.Calendar;
import java.util.List;

class hs extends gw {
    final /* synthetic */ hl a;

    private hs(hl hlVar) {
        this.a = hlVar;
    }

    protected void b() {
        this.a.l.clear();
    }

    protected boolean e() {
        this.a.a(0, 30);
        return true;
    }

    protected void e(int i) {
        this.a.a(c(), i);
    }

    public int c() {
        return this.a.l.size();
    }

    public Object d(int i) {
        return this.a.l.get(i);
    }

    public int a() {
        if (this.a.m.size() == 1 && ((ReadBook) ((List) this.a.m.get(0)).get(0)).getReadTime().before(this.a.k)) {
            return 0;
        }
        return this.a.m.size();
    }

    public int a(int i) {
        return ((List) this.a.m.get(i)).size();
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.personal__readed_books_group_view, viewGroup, false);
        }
        Calendar readTime = ((ReadBook) ((List) this.a.m.get(i)).get(0)).getReadTime();
        Calendar j = readTime.before(this.a.k) ? this.a.k : readTime;
        ((TextView) view.findViewById(g.personal__readed_books_item_view__group_year)).setText(String.valueOf(j.get(1)));
        ((TextView) view.findViewById(g.personal__readed_books_item_view__group_month)).setText(String.valueOf(j.get(2) + 1));
        ((TextView) view.findViewById(g.personal__readed_books_item_view__group_size)).setText(String.format(DkApp.get().getString(j.personal__readed_books_group_view__readed_books_monthly), new Object[]{Integer.valueOf(a(i))}));
        if (readTime.before(this.a.k)) {
            view.findViewById(g.personal__readed_books_item_view__group_before).setVisibility(0);
        }
        return view;
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        int i2;
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.personal__readed_books_item_view, viewGroup, false);
        }
        ReadBook readBook = (ReadBook) this.a.l.get(i);
        for (int i3 = 0; i3 < a(); i3++) {
            int a = a(i3);
            if (i >= 0 && i < a) {
                i2 = i3;
                break;
            }
            i -= a;
        }
        i2 = 0;
        BookCoverView bookCoverView = (BookCoverView) view.findViewById(g.personal__readed_books_item_view__cover);
        bookCoverView.setOnlineCoverUri(readBook.getCoverUri());
        bookCoverView.setCoverBackgroundResource(f.general__book_cover_view__duokan_cover);
        bookCoverView.a();
        ((TextView) view.findViewById(g.personal__readed_books_item_view__title)).setText(readBook.getTitle());
        ((TextView) view.findViewById(g.personal__readed_books_item_view__author)).setText(readBook.getNameLine());
        DkCommentScoreView dkCommentScoreView = (DkCommentScoreView) view.findViewById(g.personal__readed_books_item_view__rate);
        DkLabelView dkLabelView = (DkLabelView) view.findViewById(g.personal__readed_books_item_view__comment);
        if (readBook.getRate() == 0) {
            dkCommentScoreView.setVisibility(8);
            dkLabelView.setText(DkApp.get().getString(j.personal__readed_books_view__no_comment));
        } else {
            dkCommentScoreView.setVisibility(0);
            dkCommentScoreView.setScore(readBook.getRate());
            dkLabelView.setText(readBook.getComment());
        }
        view.setOnClickListener(new ht(this, i2, i, readBook));
        view.setOnLongClickListener(new hv(this, i2, i));
        BookActionView bookActionView = (BookActionView) view.findViewById(g.personal__readed_books_item_view__edit);
        if (this.a.s.f() == ViewMode.Edit) {
            bookActionView.setAction(BookAction.EDIT);
            bookActionView.setSelected(this.a.s.b(i2, i));
            bookActionView.setVisibility(0);
        } else {
            bookActionView.setVisibility(8);
        }
        return view;
    }

    public View a(View view, ViewGroup viewGroup) {
        return LayoutInflater.from(this.a.getContext()).inflate(h.personal__readed_books_empty_view, viewGroup, false);
    }

    public View c(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.personal__readed_books_footer_view, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(g.personal__readed_books_footer_view__local_books);
        long b = this.a.q.b() - ((long) this.a.l.size());
        if (this.a.t && l() == ListState.LOADING_COMPLETE && b > 0) {
            textView.setVisibility(0);
            textView.setText(String.format(DkApp.get().getString(j.personal__readed_books_group_view__local_book), new Object[]{Long.valueOf(b)}));
        } else {
            textView.setVisibility(8);
        }
        return view;
    }
}
