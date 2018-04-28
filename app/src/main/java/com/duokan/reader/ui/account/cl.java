package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.UpdateHandler;
import com.duokan.reader.ui.general.be;

class cl implements UpdateHandler {
    /* renamed from: a */
    final /* synthetic */ Bitmap f5928a;
    /* renamed from: b */
    final /* synthetic */ boolean f5929b;
    /* renamed from: c */
    final /* synthetic */ ck f5930c;

    cl(ck ckVar, Bitmap bitmap, boolean z) {
        this.f5930c = ckVar;
        this.f5928a = bitmap;
        this.f5929b = z;
    }

    public void onUpdateOk() {
        this.f5930c.f5927b.f5900l.dismiss();
        be.m10286a(this.f5930c.f5927b.getActivity(), C0258j.sina_send_sucess, 1).show();
        this.f5930c.f5927b.dismiss();
        this.f5930c.f5927b.m8953a(this.f5930c.f5927b.f5892d);
        if (this.f5928a != null && !this.f5928a.isRecycled() && this.f5929b) {
            this.f5928a.recycle();
        }
    }

    public void onUpdateError() {
        this.f5930c.f5927b.f5900l.dismiss();
        be.m10287a(this.f5930c.f5927b.getActivity(), this.f5930c.f5927b.getActivity().getString(C0258j.sina_send_failed), 1).show();
        this.f5930c.f5927b.f5897i.setEnabled(true);
        if (this.f5928a != null && !this.f5928a.isRecycled() && this.f5929b) {
            this.f5928a.recycle();
        }
    }

    public void onUpdateCancel() {
    }
}
