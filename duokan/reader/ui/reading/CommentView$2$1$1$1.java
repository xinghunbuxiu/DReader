package com.duokan.reader.ui.reading;

import com.duokan.core.app.IFeature;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.ui.general.web.StorePageController;

import org.json.JSONObject;

class CommentView$2$1$1$1 extends StorePageController {
    final /* synthetic */ du this$3;

    CommentView$2$1$1$1(du duVar, IFeature featrue) {
        this.this$3 = duVar;
        super(featrue);
    }

    protected boolean broadcastEvent(String str, String str2) {
        boolean optBoolean;
        try {
            optBoolean = new JSONObject(str2).optBoolean("action");
        } catch (Throwable th) {
            optBoolean = false;
        }
        if (str.equals("rewardFinish") && r0) {
            TaskHandler.postTask(new dv(this));
        }
        return super.broadcastEvent(str, str2);
    }
}
