package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.cloud.DkCloudComment;

class mr implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ DkCloudComment f8961a;
    /* renamed from: b */
    final /* synthetic */ mj f8962b;

    mr(mj mjVar, DkCloudComment dkCloudComment) {
        this.f8962b = mjVar;
        this.f8961a = dkCloudComment;
    }

    public void onClick(View view) {
        this.f8962b.f8951a.f8941c.m8870a(this.f8962b.f8951a.getContext(), this.f8962b.f8951a.f8942d, this.f8961a);
    }
}
