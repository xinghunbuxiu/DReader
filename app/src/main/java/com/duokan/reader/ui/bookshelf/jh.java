package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ui.general.ap;

public final class jh {
    /* renamed from: a */
    private final ap f6661a;

    public jh(Context context) {
        this.f6661a = new ap(context);
        this.f6661a.setTitle(C0247i.bookshelf__auto_upload_books_on_wifi_dlg__title);
        this.f6661a.setPrompt(C0247i.bookshelf__auto_upload_books_on_wifi_dlg__prompt);
        this.f6661a.setOkLabelResid(C0247i.bookshelf__auto_upload_books_on_wifi_dlg__ok);
        this.f6661a.setNoLabel(C0247i.bookshelf__auto_upload_books_on_wifi_dlg__no);
        this.f6661a.setCancelOnBack(false);
        this.f6661a.setCancelOnTouchOutside(false);
    }

    /* renamed from: a */
    public void m9862a(Runnable runnable) {
        this.f6661a.open(new ji(this, runnable));
    }
}
