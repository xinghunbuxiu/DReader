package com.duokan.reader.ui.personal;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.j;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.cloud.DkCloudReadingInfo;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.eo;
import com.duokan.reader.ui.general.hs;

import java.util.Collections;

class lv extends ml {
    final /* synthetic */ lt a;

    public lv(lt ltVar, Context context) {
        this.a = ltVar;
        super(context);
    }

    protected void a(View view) {
        int i;
        int i2 = 4;
        BookCoverView bookCoverView = (BookCoverView) view.findViewById(g.personal__notes_info_header_view__cover);
        TextView textView = (TextView) view.findViewById(g.personal__notes_info_header_view__title);
        TextView textView2 = (TextView) view.findViewById(g.personal__notes_info_header_view__author);
        DkLabelView dkLabelView = (DkLabelView) view.findViewById(g.personal__notes_info_header_view__read);
        if (this.a.e != null) {
            bookCoverView.setOnlineCoverUri(this.a.e.getCoverUri());
            bookCoverView.setCoverBackgroundResource(f.general__book_cover_view__duokan_cover);
            bookCoverView.a();
            textView.setText(this.a.e.getTitle());
            if (!TextUtils.isEmpty(this.a.e.getAuthorLine())) {
                textView2.setText(String.format(getContext().getString(j.personal__reading_notes_header_view__author), new Object[]{this.a.e.getAuthorLine()}));
            } else if (TextUtils.isEmpty(this.a.e.getEditorLine())) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(String.format(getContext().getString(j.personal__reading_notes_header_view__editor), new Object[]{this.a.e.getEditorLine()}));
            }
        } else {
            bookCoverView.setVisibility(8);
            textView.setText(this.a.d.getTitle());
            if (TextUtils.isEmpty(this.a.d.getBookFormat())) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(String.format(getContext().getString(j.general__shared__file_format), new Object[]{this.a.d.getBookFormat()}));
            }
        }
        ((TextView) view.findViewById(g.personal__notes_info_header_view__count)).setText(String.format(getContext().getString(j.personal__reading_notes_header_view__count), new Object[]{Integer.valueOf(this.a.d.getNoteCount())}));
        View findViewById = view.findViewById(g.personal__notes_info_header_view__output);
        if (this.a.d.getNoteCount() > 0) {
            i = 0;
        } else {
            i = 4;
        }
        findViewById.setVisibility(i);
        findViewById.setOnClickListener(new lw(this));
        View findViewById2 = view.findViewById(g.personal__notes_info_header_view__delete_notes);
        if (this.a.d.getNoteCount() > 0) {
            i2 = 0;
        }
        findViewById2.setVisibility(i2);
        findViewById2.setOnClickListener(new lx(this));
        if (this.a.e != null) {
            dkLabelView.setVisibility(0);
            new hs(this.a.getContext(), this.a.e.getBookUuid(), this.a.e.getTitle(), this.a.d.isSerial()).a(dkLabelView);
            return;
        }
        dkLabelView.setVisibility(8);
        dkLabelView.setOnClickListener(null);
    }

    protected void a(int i) {
        if (this.a.g != null) {
            a(this.a.g);
            this.a.g = null;
            a();
            this.c.getAdapter().a(false);
            return;
        }
        DkCloudStorage.a().a(this.a.d.getBookUuid(), this.a.d.getBookName(), this.a.d.isDuokanBookNote(), new lz(this));
    }

    protected String getHeaderViewTitle() {
        if (!ReaderEnv.get().forHd()) {
            return super.getHeaderViewTitle();
        }
        return getResources().getString(j.personal__reading_note_info_view__title) + " (" + getContext().getString(j.personal__reading_notes_header_view__count, new Object[]{Integer.valueOf(this.a.d.getNoteCount())}) + ")";
    }

    protected void a(View view, int i) {
        super.a(view, i);
        DkCloudComment dkCloudComment = (DkCloudComment) this.e.get(i);
        View findViewById = view.findViewById(g.personal__notes_info_item_view__share);
        View findViewById2 = view.findViewById(g.personal__notes_info_item_view__delete);
        View findViewById3 = view.findViewById(g.personal__notes_info_item_view__read);
        if (this.a.e == null) {
            findViewById3.setVisibility(8);
        } else if (this.a.d.isSerial()) {
            findViewById3.setVisibility(0);
        } else {
            c b = ai.a().b(this.a.d.getBookUuid());
            if (b == null || b.i() != BookState.NORMAL) {
                findViewById3.setVisibility(8);
            } else {
                findViewById3.setVisibility(0);
            }
        }
        a(findViewById3, dkCloudComment);
        b(findViewById, dkCloudComment);
        c(findViewById2, dkCloudComment);
    }

    protected void a() {
        int i;
        int i2 = 0;
        super.a();
        int c = this.c.getAdapter().c();
        View findViewById = this.c.findViewById(g.personal__notes_info_header_view__output);
        if (c > 0) {
            i = 0;
        } else {
            i = 4;
        }
        findViewById.setVisibility(i);
        View findViewById2 = this.c.findViewById(g.personal__notes_info_header_view__delete_notes);
        if (c <= 0) {
            i2 = 4;
        }
        findViewById2.setVisibility(i2);
    }

    private void a(DkCloudReadingInfo dkCloudReadingInfo) {
        this.a.f = dkCloudReadingInfo;
        this.e.clear();
        for (DkCloudAnnotation dkCloudAnnotation : dkCloudReadingInfo.getAnnotations()) {
            if (dkCloudAnnotation instanceof DkCloudComment) {
                this.e.add((DkCloudComment) dkCloudAnnotation);
            }
        }
        Collections.sort(this.e, new ma(this));
        this.a.d.setNoteCount(this.e.size());
    }

    private void a(DkCloudAnnotation dkCloudAnnotation) {
        ap mbVar = new mb(this, DkApp.get().getTopActivity(), dkCloudAnnotation);
        mbVar.setCancelLabel(j.general__shared__cancel);
        mbVar.setOkLabel(j.general__shared__confirm);
        mbVar.setPrompt(j.personal__reading_note_info_header_view__delete_one_note);
        mbVar.show();
    }

    private void a(View view, DkCloudComment dkCloudComment) {
        view.setOnClickListener(new mc(this, dkCloudComment));
    }

    private void b(View view, DkCloudComment dkCloudComment) {
        view.setOnClickListener(new md(this, dkCloudComment));
    }

    private void c(View view, DkCloudComment dkCloudComment) {
        view.setOnClickListener(new me(this, dkCloudComment));
    }

    private void a(DkCloudAnnotation[] dkCloudAnnotationArr, int i, int i2) {
        if (this.a.f != null) {
            eo eoVar = new eo(getContext());
            eoVar.show();
            DkCloudStorage.a().a(this.a.f, dkCloudAnnotationArr, "", new mf(this, eoVar, i2));
        }
    }
}
