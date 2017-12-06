package com.duokan.reader.ui.personal;

import android.view.ViewGroup.LayoutParams;

import com.duokan.core.app.IFeature;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.fr;

class PersonalController$1 extends TaskController {
    final /* synthetic */ fl this$0;

    PersonalController$1(fl flVar, IFeature featrue) {
        this.this$0 = flVar;
        super(featrue);
    }

    public void onPageFinished(fr frVar, String str) {
        super.onPageFinished(frVar, str);
        if (checkPageError()) {
            this.this$0.q.setVisibility(8);
        }
    }

    public void onPageHeightChange(int i) {
        if (i <= 0) {
            this.this$0.q.setVisibility(8);
            return;
        }
        this.this$0.q.setVisibility(0);
        LayoutParams layoutParams = this.this$0.q.getLayoutParams();
        int b = UTools.getMinimumHeight(getContext(), (float) (i + 10));
        if (layoutParams.height != b) {
            layoutParams.height = b;
            this.this$0.q.setLayoutParams(layoutParams);
        }
    }

    protected boolean broadcastEvent(String str, String str2) {
        if (str.equals("taskUpdated")) {
            TaskHandler.postTask(new fm(this));
        }
        return super.broadcastEvent(str, str2);
    }
}
