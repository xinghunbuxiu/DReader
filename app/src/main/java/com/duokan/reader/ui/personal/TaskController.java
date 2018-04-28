package com.duokan.reader.ui.personal;

import com.duokan.core.app.IFeature;
import com.duokan.core.sys.af;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.ft;
import com.duokan.reader.ui.general.web.StorePageController;

public class TaskController extends StorePageController {
    public TaskController(IFeature mFeature) {
        super(mFeature);
        setPageTitle(getString(C0258j.personal__task_view__title));
        this.mPageLoadingView.setAlpha(0.0f);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            loadUrl(C0641o.m2934i().m2957a(true, ""));
        }
        PersonalPrefs.m5175a().m5224d(true);
        ft.m5575a().m5580a(0);
        ReaderEnv.get().setPrefBoolean(PrivatePref.PERSONAL, "is_in_task_page", true);
        ReaderEnv.get().commitPrefs();
    }

    protected void onDeactive() {
        super.onDeactive();
        ReaderEnv.get().setPrefBoolean(PrivatePref.PERSONAL, "is_in_task_page", false);
        ReaderEnv.get().commitPrefs();
    }

    public void chooseStatusBarStyle(af<Boolean> afVar) {
    }
}
