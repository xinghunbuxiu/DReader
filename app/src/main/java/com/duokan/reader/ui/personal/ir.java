package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.ui.general.ja;

class ir implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ReadBook f8742a;
    /* renamed from: b */
    final /* synthetic */ ij f8743b;

    ir(ij ijVar, ReadBook readBook) {
        this.f8743b = ijVar;
        this.f8742a = readBook;
    }

    public void onClick(View view) {
        new is(this, C0643q.f2173a, ja.m10832a(this.f8743b.getContext(), "", this.f8743b.getString(C0258j.personal__readed_books_view__opening), true, true)).open();
    }
}
