package com.duokan.reader.ui.store;

import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.aa;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.PullDownRefreshView.RefreshStyle;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.fr;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.DkStoreAdsBookInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreAdsBookInfo.AdsType;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.hi;
import com.duokan.reader.domain.cloud.push.DkCloudPushMessage;
import com.duokan.reader.domain.cloud.push.DkCloudPushMessage.ActionType;
import com.duokan.reader.ui.general.LoadingCircleView.LoadingStyle;
import com.duokan.reader.ui.general.em;
import com.duokan.reader.ui.general.web.StorePageController;

import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

public abstract class bl extends em implements aa, hi {
    static final /* synthetic */ boolean b = (!bl.class.desiredAssertionStatus());
    StorePageController a = null;
    private final FrameLayout c = new FrameLayout(getContext());
    private long d = 0;
    private long e = 0;
    private long f = 0;
    private bq g = null;
    private int h = 0;
    private boolean i = false;

    protected abstract void a();

    public bl(IFeature featrue, bq bqVar) {
        super(featrue);
        a(this.c);
        this.g = bqVar;
    }

    public void c() {
        if (getSubControllerCount() == 1) {
            ((StorePageController) getSubController(0)).wakeUp();
        }
    }

    public void d() {
        if (this.a != null) {
            this.a.backToTopSmoothly();
        }
    }

    public int e() {
        return this.h;
    }

    public boolean navigateSmoothly(String str) {
        return navigate(str, null, true, null);
    }

    public boolean navigate(String str, Object obj, boolean z, Runnable runnable) {
        String str2 = (obj == null || !(obj instanceof String)) ? "external" : (String) obj;
        if (str.equals("debug")) {
            fr.setWebContentsDebuggingEnabled(true);
            return true;
        } else if (str.equals("special/free")) {
            a(str2, z, runnable);
            return true;
        } else if (str.equals("topic/free")) {
            b(str2, z, runnable);
            return true;
        } else {
            String str3 = "author/";
            if (str.startsWith("author/") && str.length() > "author/".length()) {
                a(str.substring("author/".length()), str2, z, runnable);
                return true;
            } else if (str.startsWith("fiction/") && str.length() > "fiction/".length()) {
                a(getContext(), 2, str.substring("fiction/".length()), str2, z, runnable);
                return true;
            } else if (str.startsWith("fiction_list/") && str.length() > "fiction_list/".length()) {
                a(getContext(), str.substring("fiction_list/".length()), str2, z, runnable);
                return true;
            } else if (str.startsWith("book/") && str.length() > "book/".length()) {
                a(getContext(), 1, str.substring("book/".length()), str2, z, runnable);
                return true;
            } else if (str.startsWith("list/") && str.length() > "list/".length()) {
                b(getContext(), str.substring("list/".length()), str2, z, runnable);
                return true;
            } else if (str.startsWith("topic/") && str.length() > "topic".length()) {
                b(getContext(), str.substring("topic/".length()), str2, z, runnable);
                return true;
            } else if (str.startsWith("fiction_topic/") && str.length() > "fiction_topic".length()) {
                a(getContext(), str.substring("fiction_topic/".length()), str2, z, runnable);
                return true;
            } else if (str.startsWith("comic/") && str.length() > "book/".length()) {
                a(getContext(), 6, str.substring("comic/".length()), str2, z, runnable);
                return true;
            } else if (str.equals("action/MyTask") && obj != null && (obj instanceof DkStoreAdsBookInfo)) {
                a(getContext(), (DkStoreAdsBookInfo) obj, runnable);
                return true;
            } else if (!str.equals("action/message") || obj == null || !(obj instanceof DkCloudPushMessage)) {
                return false;
            } else {
                a((DkCloudPushMessage) obj, z, runnable);
                return true;
            }
        }
    }

    public void f() {
        c();
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        PersonalPrefs.a().a((hi) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        PersonalPrefs.a().b((hi) this);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            if (this.a == null) {
                this.a = new StoreController$1(this, getContext());
            }
            this.a.setOnScrollListener(new bm(this));
            this.a.setHasTitle(false);
            b();
            this.c.addView(this.a.getContentView(), new LayoutParams(-1, -1));
            addSubController(this.a);
            activate(this.a);
            a();
            if (this.d == 0) {
                this.d = System.currentTimeMillis();
                a.k().b(this.d);
            }
        }
        m();
    }

    protected void b() {
        if (this.a != null) {
            this.a.setRefreshStyle(RefreshStyle.STORE);
        }
    }

    protected void a(LoadingStyle loadingStyle) {
        if (this.a != null) {
            this.a.setLoadingStyle(loadingStyle);
        }
    }

    private void a(String str, boolean z, Runnable runnable) {
        c(getContext(), "", p.i().f(str), z, runnable);
    }

    private void b(String str, boolean z, Runnable runnable) {
        c(getContext(), "", p.i().e(str), z, runnable);
    }

    private void a(String str, String str2, boolean z, Runnable runnable) {
        ActivatedController a = a(getContext(), "", p.i().e(str, str2));
        if (z) {
            ((com.duokan.reader.ui.e) getContext().queryFeature(com.duokan.reader.ui.e.class)).pushPageSmoothly(a, runnable);
            return;
        }
        ((com.duokan.reader.ui.e) getContext().queryFeature(com.duokan.reader.ui.e.class)).pushPage(a);
        TaskHandler.PostTask(runnable);
    }

    private void a(IFeature featrue, String str, String str2, boolean z, Runnable runnable) {
        ActivatedController a = a(a(featrue), "", p.i().b(str, str2));
        if (z) {
            ((com.duokan.reader.ui.e) getContext().queryFeature(com.duokan.reader.ui.e.class)).pushPageSmoothly(a, runnable);
            return;
        }
        ((com.duokan.reader.ui.e) getContext().queryFeature(com.duokan.reader.ui.e.class)).pushPage(a);
        TaskHandler.PostTask(runnable);
    }

    private void a(IFeature featrue, int i, String str, String str2, boolean z, Runnable runnable) {
        ActivatedController a = a(a(featrue), "", p.i().a("0", i, str, str2));
        if (z) {
            ((com.duokan.reader.ui.e) getContext().queryFeature(com.duokan.reader.ui.e.class)).pushPageSmoothly(a, runnable);
            return;
        }
        ((com.duokan.reader.ui.e) getContext().queryFeature(com.duokan.reader.ui.e.class)).pushPage(a);
        TaskHandler.PostTask(runnable);
    }

    private void b(IFeature featrue, String str, String str2, boolean z, Runnable runnable) {
        ActivatedController a = a(a(featrue), "", p.i().c(str, str2));
        if (z) {
            ((com.duokan.reader.ui.e) getContext().queryFeature(com.duokan.reader.ui.e.class)).pushPageSmoothly(a, runnable);
            return;
        }
        ((com.duokan.reader.ui.e) getContext().queryFeature(com.duokan.reader.ui.e.class)).pushPage(a);
        TaskHandler.PostTask(runnable);
    }

    private void a(IFeature featrue, DkStoreAdsBookInfo dkStoreAdsBookInfo, Runnable runnable) {
        if (dkStoreAdsBookInfo.mType == AdsType.BOOK_INFO) {
            a(a(featrue), 1, dkStoreAdsBookInfo.mBookUuid, "shelf_" + Uri.encode(dkStoreAdsBookInfo.mTitle), true, runnable);
        } else if (dkStoreAdsBookInfo.mType == AdsType.FICTION_INFO) {
            a(a(featrue), 2, dkStoreAdsBookInfo.mBookUuid, "shelf_" + Uri.encode(dkStoreAdsBookInfo.mTitle), true, runnable);
        } else if (dkStoreAdsBookInfo.mType == AdsType.BOOK_TOPIC) {
            b(a(featrue), dkStoreAdsBookInfo.mBookUuid, "shelf_" + Uri.encode(dkStoreAdsBookInfo.mTitle), true, runnable);
        } else if (dkStoreAdsBookInfo.mType == AdsType.WEBSIZE) {
            a(a(featrue), dkStoreAdsBookInfo.mTitle, dkStoreAdsBookInfo.mBookUuid, runnable);
        } else if (dkStoreAdsBookInfo.mType == AdsType.FICTION_TOPIC) {
            a(a(featrue), dkStoreAdsBookInfo.mBookUuid, "shelf_" + Uri.encode(dkStoreAdsBookInfo.mTitle), true, runnable);
        } else if (dkStoreAdsBookInfo.mType == AdsType.PUBLISHER) {
            a(a(featrue), "", p.i().d(dkStoreAdsBookInfo.mBookUuid), runnable);
        }
    }

    private StorePageController a(IFeature featrue, String str, String str2) {
        StorePageController storePageController = new StorePageController(a(featrue));
        storePageController.setPageTitle(str);
        storePageController.loadUrl(str2);
        return storePageController;
    }

    private void a(IFeature featrue, String str, String str2, Runnable runnable) {
        c(featrue, str, str2, true, runnable);
    }

    private void c(IFeature featrue, String str, String str2, boolean z, Runnable runnable) {
        ActivatedController a = a(featrue, str, str2);
        if (z) {
            ((com.duokan.reader.ui.e) getContext().queryFeature(com.duokan.reader.ui.e.class)).pushPageSmoothly(a, runnable);
            return;
        }
        ((com.duokan.reader.ui.e) getContext().queryFeature(com.duokan.reader.ui.e.class)).pushPage(a);
        TaskHandler.PostTask(runnable);
    }

    private void a(DkCloudPushMessage dkCloudPushMessage, boolean z, Runnable runnable) {
        try {
            ActionType messageType = dkCloudPushMessage.getMessageType();
            JSONObject jSONObject = new JSONObject(dkCloudPushMessage.getActionParamString());
            String string;
            String string2;
            switch (bp.a[messageType.ordinal()]) {
                case 1:
                    string = jSONObject.getString("book_id");
                    a(getContext(), 1, string, "push_" + dkCloudPushMessage.getCloudId(), z, runnable);
                    return;
                case 2:
                    string2 = jSONObject.getString("book_topic_id");
                    b(getContext(), string2, "push_" + dkCloudPushMessage.getCloudId(), z, runnable);
                    return;
                case 3:
                    string = jSONObject.getString("fiction_id");
                    a(getContext(), 2, string, "push_" + dkCloudPushMessage.getCloudId(), z, runnable);
                    return;
                case 4:
                    string2 = jSONObject.getString("fiction_topic_id");
                    a(getContext(), string2, "push_" + dkCloudPushMessage.getCloudId(), z, runnable);
                    return;
                default:
                    if (!b) {
                        throw new AssertionError();
                    }
                    return;
            }
        } catch (Exception e) {
        }
    }

    private IFeature a(IFeature featrue) {
        if (featrue == null) {
            return getContext();
        }
        return featrue;
    }

    private void m() {
        if (ReaderEnv.get().getShowAppStoreGuide() && n()) {
            TaskHandler.postDelayed(new bn(this), 2000);
        }
    }

    private boolean n() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ReaderEnv.get().getLastCommentTime() < TimeUnit.DAYS.toMillis(30) || !DkApp.get().activateFromLauncher()) {
            return false;
        }
        if (currentTimeMillis - DkApp.get().getUserFirstActiveTime() >= TimeUnit.DAYS.toMillis(21) && ReaderEnv.get().getUseDays() > 2) {
            return true;
        }
        if (System.currentTimeMillis() - ReaderEnv.get().getAdvancedActionTime() < TimeUnit.DAYS.toMillis(7)) {
            return true;
        }
        return ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).getTotalActiveTime() > TimeUnit.HOURS.toMillis(1);
    }

    private void a(Scrollable scrollable, int i, int i2) {
        if (this.g != null) {
            this.g.a(scrollable, i, i2);
        }
    }

    private void a(ScrollState scrollState, ScrollState scrollState2) {
        if (this.g != null) {
            this.g.a(this.h, scrollState, scrollState2);
        }
    }
}
