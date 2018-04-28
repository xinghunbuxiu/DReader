package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.ui.general.expandable.ViewMode;
import com.duokan.reader.ui.general.ja;

class ig implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ int f8708a;
    /* renamed from: b */
    final /* synthetic */ int f8709b;
    /* renamed from: c */
    final /* synthetic */ ReadBook f8710c;
    /* renamed from: d */
    final /* synthetic */ C1401if f8711d;

    ig(C1401if c1401if, int i, int i2, ReadBook readBook) {
        this.f8711d = c1401if;
        this.f8708a = i;
        this.f8709b = i2;
        this.f8710c = readBook;
    }

    public void onClick(View view) {
        if (this.f8711d.f8707a.f8692t.mo1714f() == ViewMode.Edit) {
            this.f8711d.f8707a.m11522b(this.f8708a, this.f8709b);
            return;
        }
        new ih(this, C0643q.f2173a, ja.m10832a(this.f8711d.f8707a.getContext(), "", this.f8711d.f8707a.f8683a.getString(C0258j.personal__readed_books_view__opening), true, true)).open();
    }
}
