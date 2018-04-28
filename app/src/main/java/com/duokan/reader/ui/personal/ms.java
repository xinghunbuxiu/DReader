package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.cloud.DkCloudComment;

class ms implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ DkCloudComment f8963a;
    /* renamed from: b */
    final /* synthetic */ mj f8964b;

    ms(mj mjVar, DkCloudComment dkCloudComment) {
        this.f8964b = mjVar;
        this.f8963a = dkCloudComment;
    }

    public void onClick(View view) {
        this.f8964b.m12293a(this.f8963a);
    }
}
