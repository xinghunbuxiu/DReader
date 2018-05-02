package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import android.view.View;

import com.duokan.c.j;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.cloud.push.DkCloudPushMessage;
import com.duokan.reader.domain.cloud.push.DkCloudPushMessage.ActionType;
import com.duokan.reader.domain.cloud.push.q;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.expandable.ViewMode;

class cu implements an {
    final /* synthetic */ cr a;
    final /* synthetic */ ct b;

    cu(ct ctVar, cr crVar) {
        this.b = ctVar;
        this.a = crVar;
    }

    public void a(HatGridView hatGridView, View view, int i) {
        if (this.b.getViewMode() == ViewMode.Edit) {
            this.b.b(0, i);
            return;
        }
        q qVar = (q) this.b.getAdapter().d(i);
        if (qVar.b != null) {
            DkCloudPushMessage dkCloudPushMessage = qVar.b;
            if ((dkCloudPushMessage.getEndTime() == 0 || dkCloudPushMessage.getEndTime() > System.currentTimeMillis()) && !TextUtils.isEmpty(dkCloudPushMessage.getActionParamString())) {
                b.a().a(dkCloudPushMessage);
                ReaderFeature readerFeature = (ReaderFeature) MyContextWrapper.getFeature(this.b.getContext()).queryFeature(ReaderFeature.class);
                if (dkCloudPushMessage.getMessageType() == ActionType.URL) {
                    readerFeature.navigate(dkCloudPushMessage.getActionUrl(), null, true, null);
                    return;
                } else {
                    readerFeature.navigate("duokan-reader://store/action/message", dkCloudPushMessage, true, null);
                    return;
                }
            }
            be.a(this.b.getContext(), j.personal__message_push_view__expired, 0).show();
        }
    }
}
