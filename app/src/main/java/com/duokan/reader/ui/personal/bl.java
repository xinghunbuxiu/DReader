package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.DkFeedbackThreadInfo;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;

import org.json.JSONObject;

class bl implements OnClickListener {
    final /* synthetic */ DkFeedbackThreadInfo a;
    final /* synthetic */ int b;
    final /* synthetic */ bk c;

    bl(bk bkVar, DkFeedbackThreadInfo dkFeedbackThreadInfo, int i) {
        this.c = bkVar;
        this.a = dkFeedbackThreadInfo;
        this.b = i;
    }

    public void onClick(View view) {
        if (this.c.a.d != null) {
            this.c.a.b.put(this.a.mThreadId, Integer.valueOf(this.a.mReplyCount));
            DkSharedStorageManager.a().a("read_threads_" + this.c.a.d.b(), new JSONObject(this.c.a.b).toString(), true);
        }
        this.c.d();
        ((ReaderFeature) this.c.a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new bo(this.c.a.getContext(), this.a.mThreadId, this.b, this.c.a), null);
    }
}
