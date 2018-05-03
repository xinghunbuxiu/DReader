package com.duokan.reader.ui.personal;

import android.view.ViewGroup.LayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.fr;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class PersonalController$1 extends TaskController {
    final /* synthetic */ fz this$0;

    PersonalController$1(fz fzVar, IFeature mFeature) {
        this.this$0 = fzVar;
        super(mFeature);
    }

    public void onPageFinished(fr frVar, String str) {
        super.onPageFinished(frVar, str);
        if (checkPageError()) {
            this.this$0.f8589p.setVisibility(8);
        }
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (this.this$0.f8589p.getHeight() > 0) {
            logTaskShown();
        }
    }

    public void onPageHeightChange(int i) {
        if (i <= 0) {
            this.this$0.f8589p.setVisibility(8);
            return;
        }
        this.this$0.f8589p.setVisibility(0);
        LayoutParams layoutParams = this.this$0.f8589p.getLayoutParams();
        if (layoutParams.height == 0) {
            logTaskShown();
        }
        int b = AnimUtils.m1932b(getContext(), (float) i);
        if (layoutParams.height != b) {
            layoutParams.height = b;
            this.this$0.f8589p.setLayoutParams(layoutParams);
        }
    }

    protected boolean broadcastEvent(String str, String str2) {
        if (str.equals("taskUpdated")) {
            UThread.runOnThread(new ga(this));
        }
        return super.broadcastEvent(str, str2);
    }

    private void logTaskShown() {
        PersonalPrefs a = PersonalPrefs.m5175a();
        if (!a.m5237m() && isActive()) {
            String str;
            if (a.m5235k()[a.m5236l() - 1]) {
                str = "查看签到";
            } else {
                str = "签到";
            }
            if (!this.this$0.f8598y.equals(str)) {
                this.this$0.f8598y = str;
                UmengManager.get().onEvent("PERSONAL_CHECK_IN_EXPOSURE_V2", str);
            }
        }
    }
}
