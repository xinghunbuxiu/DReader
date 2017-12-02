package com.duokan.reader.ui.general;

import android.content.Context;

import com.duokan.c.j;
import com.duokan.core.app.x;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.k;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.store.a;
import com.duokan.reader.ui.bookshelf.ay;

public class hs {
    private final x a;
    private final String b;
    private final String c;
    private final boolean d;

    public hs(x xVar, String str, String str2, boolean z) {
        this.a = xVar;
        this.b = str;
        this.c = str2;
        this.d = z;
    }

    public void a(DkLabelView dkLabelView) {
        Context context = dkLabelView.getContext();
        dkLabelView.setOnClickListener(new ht(this));
        dkLabelView.setTextColor(context.getResources().getColor(d.general__shared__555555));
        if (this.d) {
            dkLabelView.setText(j.personal__feed__read_book);
            return;
        }
        c b = ai.a().b(this.b);
        if (b == null || b.i() == BookState.CLOUD_ONLY) {
            dkLabelView.setText(j.personal__feed__download_book);
        } else if (!b.V()) {
            dkLabelView.setText(j.personal__feed__read_book);
        } else if (b.Y()) {
            dkLabelView.setText(j.personal__feed__download_book);
        } else if (b.X()) {
            dkLabelView.setTextColor(context.getResources().getColor(d.general__shared__999999));
            dkLabelView.setText(j.personal__feed__downloading_paused);
        } else {
            dkLabelView.setTextColor(context.getResources().getColor(d.general__shared__999999));
            dkLabelView.setText(j.personal__feed__downloading_book);
        }
    }

    private void a() {
        au.a(this.a, this.b);
    }

    private void b() {
        DkCloudPurchasedBook a = DkUserPurchasedBooksManager.a().a(this.b);
        if (a != null) {
            c b = ai.a().b(this.b);
            if (b == null || b.i() == BookState.CLOUD_ONLY) {
                k kVar = new k(Boolean.valueOf(false));
                a.a().a(this.b, false, new hw(this, kVar, jq.a(DkApp.get().getTopActivity(), "", this.a.getString(j.personal__feed__obtaining_book_info), true, true, new hv(this, kVar)), a));
            } else if (b.V() && b.Y()) {
                ay.a(DkApp.get().getTopActivity(), b.C(), new hu(this, b));
            }
        }
    }

    private void c() {
        c b = ai.a().b(this.b);
        if (b != null) {
            ((ReaderFeature) this.a.queryFeature(ReaderFeature.class)).openBook(b);
        }
    }
}
