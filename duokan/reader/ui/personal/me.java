package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.cloud.DkCloudComment;

class me implements OnClickListener {
    final /* synthetic */ DkCloudComment a;
    final /* synthetic */ lv b;

    me(lv lvVar, DkCloudComment dkCloudComment) {
        this.b = lvVar;
        this.a = dkCloudComment;
    }

    public void onClick(View view) {
        this.b.a(this.a);
    }
}
