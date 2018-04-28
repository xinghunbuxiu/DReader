package com.duokan.reader.ui.account;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ImageView;

class at extends bi {
    /* renamed from: a */
    final /* synthetic */ Bitmap f5834a;
    /* renamed from: b */
    final /* synthetic */ ar f5835b;

    at(ar arVar, Activity activity, String str, String str2, String str3, bu buVar, Bitmap bitmap) {
        this.f5835b = arVar;
        this.f5834a = bitmap;
        super(activity, str, str2, str3, buVar);
    }

    /* renamed from: a */
    protected void mo1577a(ImageView imageView) {
        imageView.setImageBitmap(this.f5834a);
    }

    /* renamed from: a */
    protected void mo1575a(bt btVar) {
        if (!this.e.isShowing()) {
            this.e.open(new au(this));
        }
        btVar.mo1573a(this.f5834a, true);
    }
}
