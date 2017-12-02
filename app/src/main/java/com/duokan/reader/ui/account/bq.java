package com.duokan.reader.ui.account;

import android.graphics.Bitmap;

import com.duokan.c.j;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.UpdateHandler;
import com.duokan.reader.ui.general.be;

class bq implements UpdateHandler {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ boolean b;
    final /* synthetic */ bp c;

    bq(bp bpVar, Bitmap bitmap, boolean z) {
        this.c = bpVar;
        this.a = bitmap;
        this.b = z;
    }

    public void onUpdateOk() {
        this.c.b.c.dismiss();
        this.c.b.a("sina");
        this.c.b.g = 0;
        this.c.b.h = this.c.b.getContext().getString(j.sina_send_sucess);
        this.c.b.dismiss();
        if (this.a != null && !this.a.isRecycled() && this.b) {
            this.a.recycle();
        }
    }

    public void onUpdateError() {
        this.c.b.c.dismiss();
        be.a(this.c.b.getContext(), j.sina_send_failed, 0).show();
        this.c.b.b.setEnabled(true);
        if (this.a != null && !this.a.isRecycled() && this.b) {
            this.a.recycle();
        }
    }

    public void onUpdateCancel() {
        if (this.a != null && !this.a.isRecycled() && this.b) {
            this.a.recycle();
        }
    }
}
