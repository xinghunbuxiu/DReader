package com.duokan.reader.ui.store;

import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.ab;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.PullDownRefreshView.RefreshStyle;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.fr;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.DkStoreAdsBookInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreAdsBookInfo.AdsType;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.gm;
import com.duokan.reader.domain.cloud.push.DkCloudPushMessage;
import com.duokan.reader.domain.cloud.push.DkCloudPushMessage.ActionType;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.C0436e;
import com.duokan.reader.ui.general.LoadingCircleView.LoadingStyle;
import com.duokan.reader.ui.general.ek;
import com.duokan.reader.ui.general.web.StorePageController;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public abstract class bl extends ek implements ab, gm {
    /* renamed from: b */
    static final /* synthetic */ boolean f11343b = (!bl.class.desiredAssertionStatus());
    /* renamed from: a */
    StorePageController f11344a = null;
    /* renamed from: c */
    private final FrameLayout f11345c = new FrameLayout(getContext());
    /* renamed from: d */
    private long f11346d = 0;
    /* renamed from: e */
    private long f11347e = 0;
    /* renamed from: f */
    private long f11348f = 0;
    /* renamed from: g */
    private bq f11349g = null;
    /* renamed from: h */
    private int f11350h = 0;
    /* renamed from: i */
    private boolean f11351i = false;
    /* renamed from: j */
    private String f11352j = "";
    /* renamed from: k */
    private int f11353k = 555;

    /* renamed from: a */
    protected abstract void mo1641a();

    public bl(IFeature mFeature, bq bqVar) {
        super(mFeature);
        m9216a(this.f11345c);
        this.f11349g = bqVar;
    }

    /* renamed from: c */
    public void m15300c() {
        if (getSubControllerCount() == 1) {
            ((StorePageController) getSubController(0)).wakeUp();
        }
    }

    /* renamed from: e */
    public void m15302e() {
        if (this.f11344a != null) {
            this.f11344a.backToTopSmoothly();
        }
    }

    /* renamed from: l */
    public int m15304l() {
        return this.f11350h;
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
            m15285a(str2, z, runnable);
            return true;
        } else if (str.equals("topic/free")) {
            m15290b(str2, z, runnable);
            return true;
        } else {
            String str3 = "author/";
            if (str.startsWith("author/") && str.length() > "author/".length()) {
                m15284a(str.substring("author/".length()), str2, z, runnable);
                return true;
            } else if (str.startsWith("fiction/") && str.length() > "fiction/".length()) {
                m15273a(getContext(), 2, str.substring("fiction/".length()), str2, z, runnable);
                return true;
            } else if (str.startsWith("fiction_list/") && str.length() > "fiction_list/".length()) {
                m15276a(getContext(), str.substring("fiction_list/".length()), str2, z, runnable);
                return true;
            } else if (str.startsWith("book/") && str.length() > "book/".length()) {
                m15273a(getContext(), 1, str.substring("book/".length()), str2, z, runnable);
                return true;
            } else if (str.startsWith("list/") && str.length() > "list/".length()) {
                m15289b(getContext(), str.substring("list/".length()), str2, z, runnable);
                return true;
            } else if (str.startsWith("topic/") && str.length() > "topic".length()) {
                m15289b(getContext(), str.substring("topic/".length()), str2, z, runnable);
                return true;
            } else if (str.startsWith("fiction_topic/") && str.length() > "fiction_topic".length()) {
                m15276a(getContext(), str.substring("fiction_topic/".length()), str2, z, runnable);
                return true;
            } else if (str.startsWith("comic/") && str.length() > "book/".length()) {
                m15273a(getContext(), 6, str.substring("comic/".length()), str2, z, runnable);
                return true;
            } else if (str.equals("action/ad") && obj != null && (obj instanceof DkStoreAdsBookInfo)) {
                m15274a(getContext(), (DkStoreAdsBookInfo) obj, runnable);
                return true;
            } else if (!str.equals("action/message") || obj == null || !(obj instanceof DkCloudPushMessage)) {
                return false;
            } else {
                m15279a((DkCloudPushMessage) obj, z, runnable);
                return true;
            }
        }
    }

    /* renamed from: d */
    public void mo2527d() {
        m15300c();
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        PersonalPrefs.m5175a().m5202a((gm) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        PersonalPrefs.m5175a().m5213b((gm) this);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            if (this.f11344a == null) {
                this.f11344a = new StoreController$1(this, getContext());
            }
            this.f11344a.setOnScrollListener(new bm(this));
            this.f11344a.setHasTitle(false);
            mo2539b();
            this.f11345c.addView(this.f11344a.getContentView(), new LayoutParams(-1, -1));
            addSubController(this.f11344a);
            activate(this.f11344a);
            mo1641a();
            if (this.f11346d == 0) {
                this.f11346d = System.currentTimeMillis();
                C1163a.m8627k().m8630a(this.f11346d);
            }
        }
        m15295o();
    }

    /* renamed from: g */
    protected void mo2544g(int i) {
        this.f11353k = i;
    }

    /* renamed from: m */
    protected int m15305m() {
        return this.f11353k;
    }

    /* renamed from: a */
    private void m15283a(String str) {
        this.f11352j = str;
    }

    /* renamed from: n */
    protected String m15306n() {
        return this.f11352j;
    }

    /* renamed from: b */
    protected void mo2539b() {
        if (this.f11344a != null) {
            this.f11344a.setRefreshStyle(RefreshStyle.STORE);
        }
    }

    /* renamed from: a */
    protected void m15298a(LoadingStyle loadingStyle) {
        if (this.f11344a != null) {
            this.f11344a.setLoadingStyle(loadingStyle);
        }
    }

    /* renamed from: a */
    private void m15285a(String str, boolean z, Runnable runnable) {
        m15292c(getContext(), "", C0641o.m2934i().m2974f(str), z, runnable);
    }

    /* renamed from: b */
    private void m15290b(String str, boolean z, Runnable runnable) {
        m15292c(getContext(), "", C0641o.m2934i().m2971e(str), z, runnable);
    }

    /* renamed from: a */
    private void m15284a(String str, String str2, boolean z, Runnable runnable) {
        ActivatedController a = m15272a(getContext(), "", C0641o.m2934i().m2972e(str, str2));
        if (z) {
            ((C0436e) getContext().queryFeature(C0436e.class)).pushPageSmoothly(a, runnable);
            return;
        }
        ((C0436e) getContext().queryFeature(C0436e.class)).pushPage(a);
        UThread.post(runnable);
    }

    /* renamed from: a */
    private void m15276a(IFeature mFeature, String str, String str2, boolean z, Runnable runnable) {
        ActivatedController a = m15272a(m15271a(mFeature), "", C0641o.m2934i().m2963b(str, str2));
        if (z) {
            ((C0436e) getContext().queryFeature(C0436e.class)).pushPageSmoothly(a, runnable);
            return;
        }
        ((C0436e) getContext().queryFeature(C0436e.class)).pushPage(a);
        UThread.post(runnable);
    }

    /* renamed from: a */
    private void m15273a(IFeature mFeature, int i, String str, String str2, boolean z, Runnable runnable) {
        ActivatedController a = m15272a(m15271a(mFeature), "", C0641o.m2934i().m2954a("0", i, str, str2));
        if (z) {
            ((C0436e) getContext().queryFeature(C0436e.class)).pushPageSmoothly(a, runnable);
            return;
        }
        ((C0436e) getContext().queryFeature(C0436e.class)).pushPage(a);
        UThread.post(runnable);
    }

    /* renamed from: b */
    private void m15289b(IFeature mFeature, String str, String str2, boolean z, Runnable runnable) {
        ActivatedController a = m15272a(m15271a(mFeature), "", C0641o.m2934i().m2966c(str, str2));
        if (z) {
            ((C0436e) getContext().queryFeature(C0436e.class)).pushPageSmoothly(a, runnable);
            return;
        }
        ((C0436e) getContext().queryFeature(C0436e.class)).pushPage(a);
        UThread.post(runnable);
    }

    /* renamed from: a */
    private void m15274a(IFeature mFeature, DkStoreAdsBookInfo dkStoreAdsBookInfo, Runnable runnable) {
        if (dkStoreAdsBookInfo.mType == AdsType.BOOK_INFO) {
            m15273a(m15271a(mFeature), 1, dkStoreAdsBookInfo.mBookUuid, "shelf_" + Uri.encode(dkStoreAdsBookInfo.mTitle), true, runnable);
        } else if (dkStoreAdsBookInfo.mType == AdsType.FICTION_INFO) {
            m15273a(m15271a(mFeature), 2, dkStoreAdsBookInfo.mBookUuid, "shelf_" + Uri.encode(dkStoreAdsBookInfo.mTitle), true, runnable);
        } else if (dkStoreAdsBookInfo.mType == AdsType.BOOK_TOPIC) {
            m15289b(m15271a(mFeature), dkStoreAdsBookInfo.mBookUuid, "shelf_" + Uri.encode(dkStoreAdsBookInfo.mTitle), true, runnable);
        } else if (dkStoreAdsBookInfo.mType == AdsType.WEBSIZE) {
            m15275a(m15271a(mFeature), dkStoreAdsBookInfo.mTitle, dkStoreAdsBookInfo.mBookUuid, runnable);
        } else if (dkStoreAdsBookInfo.mType == AdsType.FICTION_TOPIC) {
            m15276a(m15271a(mFeature), dkStoreAdsBookInfo.mBookUuid, "shelf_" + Uri.encode(dkStoreAdsBookInfo.mTitle), true, runnable);
        } else if (dkStoreAdsBookInfo.mType == AdsType.PUBLISHER) {
            m15275a(m15271a(mFeature), "", C0641o.m2934i().m2968d(dkStoreAdsBookInfo.mBookUuid), runnable);
        }
    }

    /* renamed from: a */
    private StorePageController m15272a(IFeature mFeature, String str, String str2) {
        StorePageController storePageController = new StorePageController(m15271a(mFeature));
        storePageController.setPageTitle(str);
        storePageController.loadUrl(str2);
        return storePageController;
    }

    /* renamed from: a */
    private void m15275a(IFeature mFeature, String str, String str2, Runnable runnable) {
        m15292c(mFeature, str, str2, true, runnable);
    }

    /* renamed from: c */
    private void m15292c(IFeature mFeature, String str, String str2, boolean z, Runnable runnable) {
        ActivatedController a = m15272a(mFeature, str, str2);
        if (z) {
            ((C0436e) getContext().queryFeature(C0436e.class)).pushPageSmoothly(a, runnable);
            return;
        }
        ((C0436e) getContext().queryFeature(C0436e.class)).pushPage(a);
        UThread.post(runnable);
    }

    /* renamed from: a */
    private void m15279a(DkCloudPushMessage dkCloudPushMessage, boolean z, Runnable runnable) {
        try {
            ActionType messageType = dkCloudPushMessage.getMessageType();
            JSONObject jSONObject = new JSONObject(dkCloudPushMessage.getActionParamString());
            String string;
            String string2;
            switch (bp.f11379a[messageType.ordinal()]) {
                case 1:
                    string = jSONObject.getString("book_id");
                    m15273a(getContext(), 1, string, "push_" + dkCloudPushMessage.getCloudId(), z, runnable);
                    return;
                case 2:
                    string2 = jSONObject.getString("book_topic_id");
                    m15289b(getContext(), string2, "push_" + dkCloudPushMessage.getCloudId(), z, runnable);
                    return;
                case 3:
                    string = jSONObject.getString("fiction_id");
                    m15273a(getContext(), 2, string, "push_" + dkCloudPushMessage.getCloudId(), z, runnable);
                    return;
                case 4:
                    string2 = jSONObject.getString("fiction_topic_id");
                    m15276a(getContext(), string2, "push_" + dkCloudPushMessage.getCloudId(), z, runnable);
                    return;
                default:
                    if (!f11343b) {
                        throw new AssertionError();
                    }
                    return;
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private IFeature m15271a(IFeature mFeature) {
        if (mFeature == null) {
            return getContext();
        }
        return mFeature;
    }

    /* renamed from: o */
    private void m15295o() {
        if (ReaderEnv.get().getShowAppStoreGuide() && m15296p()) {
            UThread.postDelayed(new bn(this), 2000);
        }
    }

    /* renamed from: p */
    private boolean m15296p() {
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

    /* renamed from: a */
    private void m15278a(Scrollable scrollable, int i, int i2) {
        if (this.f11349g != null) {
            this.f11349g.mo2543a(scrollable, i, i2);
        }
    }

    /* renamed from: a */
    private void m15277a(ScrollState scrollState, ScrollState scrollState2) {
        if (this.f11349g != null) {
            this.f11349g.mo2542a(this.f11350h, scrollState, scrollState2);
        }
    }
}
