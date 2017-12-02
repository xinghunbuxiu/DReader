package com.duokan.reader.ui.bookshelf;

import android.content.Context;

import com.duokan.b.i;
import com.duokan.reader.ui.general.ap;

public final class ij {
    private final ap a;

    public ij(Context context) {
        this.a = new ap(context);
        this.a.setTitle(i.bookshelf__auto_upload_books_on_wifi_dlg__title);
        this.a.setPrompt(i.bookshelf__auto_upload_books_on_wifi_dlg__prompt);
        this.a.setOkLabel(i.bookshelf__auto_upload_books_on_wifi_dlg__ok);
        this.a.setNoLabel(i.bookshelf__auto_upload_books_on_wifi_dlg__no);
        this.a.setCancelOnBack(false);
        this.a.setCancelOnTouchOutside(false);
    }

    public void a(Runnable runnable) {
        this.a.open(new ik(this, runnable));
    }
}
