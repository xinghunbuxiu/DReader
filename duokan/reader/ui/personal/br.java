package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.common.webservices.duokan.DkFeedbackReply;

class br implements OnClickListener {
    final /* synthetic */ DkFeedbackReply a;
    final /* synthetic */ bq b;

    br(bq bqVar, DkFeedbackReply dkFeedbackReply) {
        this.b = bqVar;
        this.a = dkFeedbackReply;
    }

    public void onClick(View view) {
        this.b.a.a(this.a.mPId);
    }
}
