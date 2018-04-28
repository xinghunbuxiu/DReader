package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.common.webservices.duokan.DkFeedbackReply;

class bk implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ DkFeedbackReply f8329a;
    /* renamed from: b */
    final /* synthetic */ bj f8330b;

    bk(bj bjVar, DkFeedbackReply dkFeedbackReply) {
        this.f8330b = bjVar;
        this.f8329a = dkFeedbackReply;
    }

    public void onClick(View view) {
        this.f8330b.f8328a.m11459a(this.f8329a.mPId);
    }
}
