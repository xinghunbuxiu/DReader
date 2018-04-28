package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.UpdateHandler;
import com.duokan.reader.ui.general.be;

class bg implements UpdateHandler {
    /* renamed from: a */
    final /* synthetic */ Bitmap f5866a;
    /* renamed from: b */
    final /* synthetic */ boolean f5867b;
    /* renamed from: c */
    final /* synthetic */ bf f5868c;

    bg(bf bfVar, Bitmap bitmap, boolean z) {
        this.f5868c = bfVar;
        this.f5866a = bitmap;
        this.f5867b = z;
    }

    public void onUpdateOk() {
        this.f5868c.f5865b.f5824e.dismiss();
        this.f5868c.f5865b.mo1576a("weibo");
        this.f5868c.f5865b.f5828i = 0;
        this.f5868c.f5865b.f5829j = this.f5868c.f5865b.getContext().getString(C0258j.sina_send_sucess);
        this.f5868c.f5865b.dismiss();
        if (this.f5866a != null && !this.f5866a.isRecycled() && this.f5867b) {
            this.f5866a.recycle();
        }
    }

    public void onUpdateError() {
        this.f5868c.f5865b.f5824e.dismiss();
        be.m10286a(this.f5868c.f5865b.getContext(), C0258j.sina_send_failed, 0).show();
        this.f5868c.f5865b.f5823d.setEnabled(true);
        if (this.f5866a != null && !this.f5866a.isRecycled() && this.f5867b) {
            this.f5866a.recycle();
        }
    }

    public void onUpdateCancel() {
        if (this.f5866a != null && !this.f5866a.isRecycled() && this.f5867b) {
            this.f5866a.recycle();
        }
    }
}
