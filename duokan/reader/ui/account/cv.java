package com.duokan.reader.ui.account;

import android.graphics.Bitmap;

import com.duokan.c.j;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.UpdateHandler;
import com.duokan.reader.ui.general.be;

class cv implements UpdateHandler {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ boolean b;
    final /* synthetic */ cu c;

    cv(cu cuVar, Bitmap bitmap, boolean z) {
        this.c = cuVar;
        this.a = bitmap;
        this.b = z;
    }

    public void onUpdateOk() {
        this.c.b.l.dismiss();
        be.a(this.c.b.getActivity(), j.sina_send_sucess, 1).show();
        this.c.b.dismiss();
        this.c.b.a(this.c.b.d);
        if (this.a != null && !this.a.isRecycled() && this.b) {
            this.a.recycle();
        }
    }

    public void onUpdateError() {
        this.c.b.l.dismiss();
        be.a(this.c.b.getActivity(), this.c.b.getActivity().getString(j.sina_send_failed), 1).show();
        this.c.b.i.setEnabled(true);
        if (this.a != null && !this.a.isRecycled() && this.b) {
            this.a.recycle();
        }
    }

    public void onUpdateCancel() {
    }
}
