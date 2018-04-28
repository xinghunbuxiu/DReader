package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import android.view.View;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.cloud.push.C0857b;
import com.duokan.reader.domain.cloud.push.C0876u;
import com.duokan.reader.domain.cloud.push.DkCloudPushMessage;
import com.duokan.reader.domain.cloud.push.DkCloudPushMessage.ActionType;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.expandable.ViewMode;

class cn implements an {
    /* renamed from: a */
    final /* synthetic */ ck f8409a;
    /* renamed from: b */
    final /* synthetic */ cm f8410b;

    cn(cm cmVar, ck ckVar) {
        this.f8410b = cmVar;
        this.f8409a = ckVar;
    }

    /* renamed from: a */
    public void mo1558a(HatGridView hatGridView, View view, int i) {
        if (this.f8410b.getViewMode() == ViewMode.Edit) {
            this.f8410b.m11522b(0, i);
            return;
        }
        C0876u c0876u = (C0876u) this.f8410b.getAdapter().mo509d(i);
        if (c0876u.f4158b != null) {
            DkCloudPushMessage dkCloudPushMessage = c0876u.f4158b;
            if ((dkCloudPushMessage.getEndTime() == 0 || dkCloudPushMessage.getEndTime() > System.currentTimeMillis()) && !TextUtils.isEmpty(dkCloudPushMessage.getActionParamString())) {
                C0857b.m5649a().m5679a(dkCloudPushMessage);
                ReaderFeature readerFeature = (ReaderFeature) AppContext.getAppContext(this.f8410b.getContext()).queryFeature(ReaderFeature.class);
                if (dkCloudPushMessage.getMessageType() == ActionType.URL) {
                    readerFeature.navigate(dkCloudPushMessage.getActionUrl(), null, true, null);
                    return;
                } else {
                    readerFeature.navigate("duokan-reader://store/action/message", dkCloudPushMessage, true, null);
                    return;
                }
            }
            be.m10286a(this.f8410b.getContext(), C0258j.personal__message_push_view__expired, 0).show();
        }
    }
}
