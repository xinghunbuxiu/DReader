package com.duokan.reader.ui.reading;

import com.duokan.core.app.IFeature;
import com.duokan.core.sys.UThread;
import com.duokan.reader.ui.general.web.StorePageController;
import org.json.JSONObject;

class CommentView$2$1$1$1 extends StorePageController {
    final /* synthetic */ dw this$3;

    CommentView$2$1$1$1(dw dwVar, IFeature mFeature) {
        this.this$3 = dwVar;
        super(mFeature);
    }

    protected boolean broadcastEvent(String str, String str2) {
        boolean optBoolean;
        try {
            optBoolean = new JSONObject(str2).optBoolean("action");
        } catch (Throwable th) {
            optBoolean = false;
        }
        if (str.equals("rewardFinish") && optBoolean) {
            UThread.runOnThread(new dx(this));
        }
        return super.broadcastEvent(str, str2);
    }
}
