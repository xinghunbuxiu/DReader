package com.duokan.reader.ui.personal;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.cloud.DkCloudReadingInfo;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.em;
import com.duokan.reader.ui.general.hh;
import java.util.Collections;

class mj extends mz {
    /* renamed from: a */
    final /* synthetic */ mh f8951a;

    public mj(mh mhVar, Context context) {
        this.f8951a = mhVar;
        super(context);
    }

    /* renamed from: a */
    protected void mo1966a(View view) {
        BookCoverView bookCoverView = (BookCoverView) view.findViewById(C0255g.personal__notes_info_header_view__cover);
        TextView textView = (TextView) view.findViewById(C0255g.personal__notes_info_header_view__title);
        TextView textView2 = (TextView) view.findViewById(C0255g.personal__notes_info_header_view__author);
        DkLabelView dkLabelView = (DkLabelView) view.findViewById(C0255g.personal__notes_info_header_view__read);
        if (this.f8951a.f8943e != null) {
            bookCoverView.setOnlineCoverUri(this.f8951a.f8943e.getCoverUri());
            bookCoverView.setCoverBackgroundResource(C0254f.general__book_cover_view__duokan_cover);
            bookCoverView.m9919a();
            textView.setText(this.f8951a.f8943e.getTitle());
            if (!TextUtils.isEmpty(this.f8951a.f8943e.getAuthorLine())) {
                textView2.setText(String.format(getContext().getString(C0258j.personal__reading_notes_header_view__author), new Object[]{this.f8951a.f8943e.getAuthorLine()}));
            } else if (TextUtils.isEmpty(this.f8951a.f8943e.getEditorLine())) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(String.format(getContext().getString(C0258j.personal__reading_notes_header_view__editor), new Object[]{this.f8951a.f8943e.getEditorLine()}));
            }
        } else {
            bookCoverView.setVisibility(8);
            textView.setText(this.f8951a.f8942d.getTitle());
            if (TextUtils.isEmpty(this.f8951a.f8942d.getBookFormat())) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(String.format(getContext().getString(C0258j.general__shared__file_format), new Object[]{this.f8951a.f8942d.getBookFormat()}));
            }
        }
        ((TextView) view.findViewById(C0255g.personal__notes_info_header_view__count)).setText(String.format(getContext().getString(C0258j.personal__reading_notes_header_view__count), new Object[]{Integer.valueOf(this.f8951a.f8942d.getNoteCount())}));
        View findViewById = view.findViewById(C0255g.personal__notes_info_header_view__output);
        findViewById.setVisibility(4);
        findViewById.setOnClickListener(new mk(this));
        findViewById = view.findViewById(C0255g.personal__notes_info_header_view__delete_notes);
        findViewById.setVisibility(4);
        findViewById.setOnClickListener(new ml(this));
        if (this.f8951a.f8943e != null) {
            dkLabelView.setVisibility(0);
            new hh(this.f8951a.getContext(), this.f8951a.f8943e.getBookUuid(), this.f8951a.f8943e.getTitle(), this.f8951a.f8942d.isSerial()).m10750a(dkLabelView);
            return;
        }
        dkLabelView.setVisibility(8);
        dkLabelView.setOnClickListener(null);
    }

    /* renamed from: a */
    protected void mo1965a(int i) {
        if (this.f8951a.f8945g != null) {
            m12294a(this.f8951a.f8945g);
            this.f8951a.f8945g = null;
            mo1964a();
            this.c.getAdapter().m8785a(false);
            return;
        }
        DkCloudStorage.m4994a().m5015a(this.f8951a.f8942d.getBookUuid(), this.f8951a.f8942d.getBookName(), this.f8951a.f8942d.isDuokanBookNote(), new mn(this));
    }

    protected String getHeaderViewTitle() {
        if (!ReaderEnv.get().forHd()) {
            return super.getHeaderViewTitle();
        }
        return getResources().getString(C0258j.personal__reading_note_info_view__title) + " (" + getContext().getString(C0258j.personal__reading_notes_header_view__count, new Object[]{Integer.valueOf(this.f8951a.f8942d.getNoteCount())}) + ")";
    }

    /* renamed from: a */
    protected void mo1967a(View view, int i) {
        super.mo1967a(view, i);
        DkCloudComment dkCloudComment = (DkCloudComment) this.e.get(i);
        View findViewById = view.findViewById(C0255g.personal__notes_info_item_view__share);
        View findViewById2 = view.findViewById(C0255g.personal__notes_info_item_view__delete);
        View findViewById3 = view.findViewById(C0255g.personal__notes_info_item_view__read);
        if (this.f8951a.f8943e == null) {
            findViewById3.setVisibility(8);
        } else if (this.f8951a.f8942d.isSerial()) {
            findViewById3.setVisibility(0);
        } else {
            C0800c b = ai.m3980a().m3906b(this.f8951a.f8942d.getBookUuid());
            if (b == null || b.m4233i() != BookState.NORMAL) {
                findViewById3.setVisibility(8);
            } else {
                findViewById3.setVisibility(0);
            }
        }
        m12292a(findViewById3, dkCloudComment);
        m12299b(findViewById, dkCloudComment);
        m12300c(findViewById2, dkCloudComment);
    }

    /* renamed from: a */
    protected void mo1964a() {
        int i;
        int i2 = 0;
        super.mo1964a();
        int c = this.c.getAdapter().mo506c();
        View findViewById = this.c.findViewById(C0255g.personal__notes_info_header_view__output);
        if (c > 0) {
            i = 0;
        } else {
            i = 4;
        }
        findViewById.setVisibility(i);
        View findViewById2 = this.c.findViewById(C0255g.personal__notes_info_header_view__delete_notes);
        if (c <= 0) {
            i2 = 4;
        }
        findViewById2.setVisibility(i2);
    }

    /* renamed from: a */
    private void m12294a(DkCloudReadingInfo dkCloudReadingInfo) {
        this.f8951a.f8944f = dkCloudReadingInfo;
        this.e.clear();
        for (DkCloudAnnotation dkCloudAnnotation : dkCloudReadingInfo.getAnnotations()) {
            if (dkCloudAnnotation instanceof DkCloudComment) {
                this.e.add((DkCloudComment) dkCloudAnnotation);
            }
        }
        Collections.sort(this.e, new mo(this));
        this.f8951a.f8942d.setNoteCount(this.e.size());
    }

    /* renamed from: a */
    private void m12293a(DkCloudAnnotation dkCloudAnnotation) {
        ap mpVar = new mp(this, DkApp.get().getTopActivity(), dkCloudAnnotation);
        mpVar.setCancelLabel(C0258j.general__shared__cancel);
        mpVar.setOkLabelResid(C0258j.general__shared__confirm);
        mpVar.setPrompt(C0258j.personal__reading_note_info_header_view__delete_one_note);
        mpVar.show();
    }

    /* renamed from: a */
    private void m12292a(View view, DkCloudComment dkCloudComment) {
        view.setOnClickListener(new mq(this, dkCloudComment));
    }

    /* renamed from: b */
    private void m12299b(View view, DkCloudComment dkCloudComment) {
        view.setOnClickListener(new mr(this, dkCloudComment));
    }

    /* renamed from: c */
    private void m12300c(View view, DkCloudComment dkCloudComment) {
        view.setOnClickListener(new ms(this, dkCloudComment));
    }

    /* renamed from: a */
    private void m12298a(DkCloudAnnotation[] dkCloudAnnotationArr, int i, int i2) {
        if (this.f8951a.f8944f != null) {
            em emVar = new em(getContext());
            emVar.show();
            DkCloudStorage.m4994a().m5013a(this.f8951a.f8944f, dkCloudAnnotationArr, "", new mt(this, emVar, i2));
        }
    }
}
