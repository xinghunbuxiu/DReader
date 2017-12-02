package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.core.app.y;
import com.duokan.core.sys.af;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.gn;
import com.duokan.reader.ui.general.web.StorePageController;

public class TaskController extends StorePageController {
    public TaskController(y yVar) {
        super(yVar);
        setPageTitle(getString(j.personal__task_view__title));
        this.mPageLoadingView.setAlpha(0.0f);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            loadUrl(p.i().a(""));
        }
        PersonalPrefs.a().d(true);
        gn.a().a(0);
        ReaderEnv.get().setPrefBoolean(PrivatePref.PERSONAL, "is_in_task_page", true);
        ReaderEnv.get().commitPrefs();
    }

    protected void onDeactive() {
        super.onDeactive();
        ReaderEnv.get().setPrefBoolean(PrivatePref.PERSONAL, "is_in_task_page", false);
        ReaderEnv.get().commitPrefs();
    }

    public void chooseStatusBarStyle(af afVar) {
    }
}
