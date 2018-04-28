package com.duokan.reader.ui.general;

import android.content.Context;
import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.C0613k;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.store.C1176a;
import com.duokan.reader.ui.bookshelf.be;

public class hh {
    /* renamed from: a */
    private final AppContext f7331a;
    /* renamed from: b */
    private final String f7332b;
    /* renamed from: c */
    private final String f7333c;
    /* renamed from: d */
    private final boolean f7334d;

    public hh(AppContext appContext, String str, String str2, boolean z) {
        this.f7331a = appContext;
        this.f7332b = str;
        this.f7333c = str2;
        this.f7334d = z;
    }

    /* renamed from: a */
    public void m10750a(DkLabelView dkLabelView) {
        Context context = dkLabelView.getContext();
        dkLabelView.setOnClickListener(new hi(this));
        dkLabelView.setTextColor(context.getResources().getColor(C0252d.general__shared__555555));
        if (this.f7334d) {
            dkLabelView.setText(C0258j.personal__feed__read_book);
            return;
        }
        C0800c b = ai.m3980a().m3906b(this.f7332b);
        if (b == null || b.m4233i() == BookState.CLOUD_ONLY) {
            dkLabelView.setText(C0258j.personal__feed__download_book);
        } else if (!b.m4171X()) {
            dkLabelView.setText(C0258j.personal__feed__read_book);
        } else if (b.aa()) {
            dkLabelView.setText(C0258j.personal__feed__download_book);
        } else if (b.m4173Z()) {
            dkLabelView.setTextColor(context.getResources().getColor(C0252d.general__shared__999999));
            dkLabelView.setText(C0258j.personal__feed__downloading_paused);
        } else {
            dkLabelView.setTextColor(context.getResources().getColor(C0252d.general__shared__999999));
            dkLabelView.setText(C0258j.personal__feed__downloading_book);
        }
    }

    /* renamed from: a */
    private void m10742a() {
        au.m10239a(this.f7331a, this.f7332b);
    }

    /* renamed from: b */
    private void m10744b() {
        DkCloudPurchasedBook a = DkUserPurchasedBooksManager.m5029a().m5052a(this.f7332b);
        if (a != null) {
            C0800c b = ai.m3980a().m3906b(this.f7332b);
            if (b == null || b.m4233i() == BookState.CLOUD_ONLY) {
                C0613k c0613k = new C0613k(Boolean.valueOf(false));
                C1176a.m8695a().m8703a(this.f7332b, false, new hl(this, c0613k, ja.m10833a(DkApp.get().getTopActivity(), "", this.f7331a.getString(C0258j.personal__feed__obtaining_book_info), true, true, new hk(this, c0613k)), a));
            } else if (b.m4171X() && b.aa()) {
                be.m9188a(DkApp.get().getTopActivity(), b.m4151D(), new hj(this, b));
            }
        }
    }

    /* renamed from: c */
    private void m10747c() {
        C0800c b = ai.m3980a().m3906b(this.f7332b);
        if (b != null) {
            ((ReaderFeature) this.f7331a.queryFeature(ReaderFeature.class)).openBook(b);
        }
    }
}
