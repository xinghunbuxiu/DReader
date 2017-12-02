package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.ui.bookshelf.gn;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.general.cc;

class mk extends bo {
    final /* synthetic */ mh a;

    private mk(mh mhVar) {
        this.a = mhVar;
    }

    public /* synthetic */ Object d(int i) {
        return c(i);
    }

    public int c() {
        return this.a.c == null ? 0 : this.a.c.size();
    }

    protected void b() {
        this.a.c = null;
    }

    protected boolean e() {
        this.a.a(false);
        return true;
    }

    public DkCloudNoteBookInfo c(int i) {
        if (this.a.c == null || this.a.c.size() <= i) {
            return null;
        }
        return (DkCloudNoteBookInfo) this.a.c.get(i);
    }

    protected void e(int i) {
        this.a.a(false);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.personal__book_reading_note_summary_view, viewGroup, false);
        }
        DkCloudNoteBookInfo c = c(i);
        BookCoverView bookCoverView = (BookCoverView) view.findViewById(g.personal__reading_note_item_view__cover);
        TextView textView = (TextView) view.findViewById(g.personal__reading_note_item_view__title);
        TextView textView2 = (TextView) view.findViewById(g.personal__reading_note_item_view__info);
        if (c.isDuokanBookNote()) {
            bookCoverView.setOnlineCoverUri(c.getBookCoverUrl());
            bookCoverView.setBookName("");
            textView.setText(c.getTitle());
            if (TextUtils.isEmpty(c.getBookAuthor())) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(c.getBookAuthor());
            }
            bookCoverView.a();
        } else {
            bookCoverView.setCoverForegroundDrawable(this.a.getResources().getDrawable(gn.b(this.a.a(c.getBookFormat()))));
            textView.setText(c.getTitle());
            textView2.setVisibility(0);
            textView2.setText(String.format(this.a.getContext().getString(j.general__shared__file_format), new Object[]{c.getBookFormat()}));
        }
        ((TextView) view.findViewById(g.personal__reading_note_item_view__count)).setText(String.valueOf(c.getNoteCount()));
        ((TextView) view.findViewById(g.personal__reading_note_item_view__date)).setText(String.format(this.a.getContext().getString(j.personal__reading_note_item_view__date), new Object[]{ReaderUi.a(this.a.getContext(), c.getLastDate().getTime())}));
        return view;
    }

    public View a(View view, ViewGroup viewGroup) {
        cc ccVar = new cc(this.a.getContext());
        ccVar.a(f.personal__no_note_icon);
        ccVar.b(j.personal__reading_notes_view__empty);
        ccVar.c(j.personal__reading_notes_view__description);
        ccVar.a().setBackgroundColor(-1);
        return ccVar.a();
    }
}
