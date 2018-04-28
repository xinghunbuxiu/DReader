package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.DkFeedbackThreadInfo;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;
import org.json.JSONObject;

class be implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ DkFeedbackThreadInfo f8311a;
    /* renamed from: b */
    final /* synthetic */ int f8312b;
    /* renamed from: c */
    final /* synthetic */ bd f8313c;

    be(bd bdVar, DkFeedbackThreadInfo dkFeedbackThreadInfo, int i) {
        this.f8313c = bdVar;
        this.f8311a = dkFeedbackThreadInfo;
        this.f8312b = i;
    }

    public void onClick(View view) {
        if (this.f8313c.f8310a.f8308d != null) {
            this.f8313c.f8310a.f8306b.put(this.f8311a.mThreadId, Integer.valueOf(this.f8311a.mReplyCount));
            DkSharedStorageManager.m5016a().m5026a("read_threads_" + this.f8313c.f8310a.f8308d.mo832b(), new JSONObject(this.f8313c.f8310a.f8306b).toString(), true);
        }
        this.f8313c.mo1691d();
        ((ReaderFeature) this.f8313c.f8310a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new bh(this.f8313c.f8310a.getContext(), this.f8311a.mThreadId, this.f8312b, this.f8313c.f8310a), null);
    }
}
