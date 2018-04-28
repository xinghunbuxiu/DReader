package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.ui.bookshelf.gu;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.general.cc;

class my extends bo {
    /* renamed from: a */
    final /* synthetic */ mv f8974a;

    private my(mv mvVar) {
        this.f8974a = mvVar;
    }

    /* renamed from: d */
    public /* synthetic */ Object mo509d(int i) {
        return mo1556c(i);
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f8974a.f8970c == null ? 0 : this.f8974a.f8970c.size();
    }

    /* renamed from: b */
    protected void mo1555b() {
        this.f8974a.f8970c = null;
    }

    /* renamed from: e */
    protected boolean mo1712e() {
        this.f8974a.m12317a(false);
        return true;
    }

    /* renamed from: c */
    public DkCloudNoteBookInfo mo1556c(int i) {
        if (this.f8974a.f8970c == null || this.f8974a.f8970c.size() <= i) {
            return null;
        }
        return (DkCloudNoteBookInfo) this.f8974a.f8970c.get(i);
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
        this.f8974a.m12317a(false);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f8974a.getContext()).inflate(C0256h.personal__book_reading_note_summary_view, viewGroup, false);
        }
        DkCloudNoteBookInfo c = mo1556c(i);
        BookCoverView bookCoverView = (BookCoverView) view.findViewById(C0255g.personal__reading_note_item_view__cover);
        TextView textView = (TextView) view.findViewById(C0255g.personal__reading_note_item_view__title);
        TextView textView2 = (TextView) view.findViewById(C0255g.personal__reading_note_item_view__info);
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
            bookCoverView.m9919a();
        } else {
            bookCoverView.setCoverForegroundDrawable(this.f8974a.getResources().getDrawable(gu.m9743b(this.f8974a.m12313a(c.getBookFormat()))));
            textView.setText(c.getTitle());
            textView2.setVisibility(0);
            textView2.setText(String.format(this.f8974a.getContext().getString(C0258j.general__shared__file_format), new Object[]{c.getBookFormat()}));
        }
        ((TextView) view.findViewById(C0255g.personal__reading_note_item_view__count)).setText(String.valueOf(c.getNoteCount()));
        ((TextView) view.findViewById(C0255g.personal__reading_note_item_view__date)).setText(String.format(this.f8974a.getContext().getString(C0258j.personal__reading_note_item_view__date), new Object[]{ReaderUi.m10158a(this.f8974a.getContext(), c.getLastDate().getTime())}));
        return view;
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        cc ccVar = new cc(this.f8974a.getContext());
        ccVar.m10334a(C0254f.personal__no_note_icon);
        ccVar.m10335b(C0258j.personal__reading_notes_view__empty);
        ccVar.m10336c(C0258j.personal__reading_notes_view__description);
        ccVar.m10333a().setBackgroundColor(-1);
        return ccVar.m10333a();
    }
}
