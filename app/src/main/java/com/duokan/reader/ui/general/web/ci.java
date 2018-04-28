package com.duokan.reader.ui.general.web;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.p027b.C0324a;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.as;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.UserAccount;
import com.duokan.reader.domain.account.bd;
import com.duokan.reader.ui.general.be;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;
import miui.webkit.UrlResolverHelper;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;

public class ci {
    /* renamed from: a */
    private final Pattern f7580a = Pattern.compile("www\\.(.+\\.)*duokan\\.com", 2);
    /* renamed from: b */
    final /* synthetic */ StorePageController f7581b;

    public ci(StorePageController storePageController) {
        this.f7581b = storePageController;
    }

    @JavascriptInterface
    public void log(String str) {
        m11020b(new cj(this, str));
    }

    @JavascriptInterface
    public void logMessage(String str) {
        m11020b(new cz(this, str));
    }

    @JavascriptInterface
    public void showToast(String str) {
        m11016a(new dk(this, str));
    }

    @JavascriptInterface
    public void pageCreated(int i, String str) {
        m11016a(new ei(this, i, str));
    }

    @JavascriptInterface
    public boolean isNetworkConnected() {
        return ((Boolean) m11015a(new ft(this), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public boolean isWifiConnected() {
        return ((Boolean) m11015a(new go(this), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public int getServerConfig() {
        return ((Integer) m11015a(new hj(this), Integer.valueOf(0))).intValue();
    }

    @JavascriptInterface
    public boolean isMiui() {
        return ((Boolean) m11015a(new iq(this), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public int getPagePaddingBottom() {
        return ((Integer) m11015a(new ka(this), Integer.valueOf(0))).intValue();
    }

    @JavascriptInterface
    public void showProgress(String str) {
        m11020b(new ck(this, str));
    }

    @JavascriptInterface
    public void pageLoading(boolean z) {
        m11020b(new cn(this, z));
    }

    @JavascriptInterface
    public void lsSetItem(String str, String str2) {
        lsSetItem(str, str2, true);
    }

    @JavascriptInterface
    public void lsSetItem(String str, String str2, boolean z) {
        m11020b(new cp(this, str, str2, z));
    }

    @JavascriptInterface
    public String lsGetItem(String str) {
        return (String) m11015a(new cq(this, str), (Object) "");
    }

    @JavascriptInterface
    public void lsRemoveItem(String str) {
        m11020b(new cr(this, str));
    }

    @JavascriptInterface
    public void ajax(String str) {
        m11020b(new cs(this, str));
    }

    @JavascriptInterface
    public void button(String str) {
        m11020b(new cu(this, str));
    }

    @JavascriptInterface
    public int getScreenOrientation() {
        return this.f7581b.mScreenOrientation;
    }

    @JavascriptInterface
    public String listPaymentMethods() {
        return (String) m11015a(new cw(this), new JSONArray().toString());
    }

    @JavascriptInterface
    public String listLoginMethods() {
        return (String) m11015a(new cx(this), new JSONArray().put("MI_LOCAL").toString());
    }

    @JavascriptInterface
    public String getSafeAreaInsets() {
        return (String) m11015a(new cy(this), (Object) "");
    }

    @JavascriptInterface
    public String getSystemMiId() {
        return (String) m11015a(new da(this), (Object) "");
    }

    @JavascriptInterface
    public void pay(String str) {
        m11020b(new db(this, str));
    }

    @JavascriptInterface
    public void goBack() {
        m11016a(new dc(this));
    }

    @JavascriptInterface
    public void requestFinish() {
        requestFinish(null);
    }

    @JavascriptInterface
    public void requestFinish(String str) {
        m11016a(new dd(this, str));
    }

    @JavascriptInterface
    public void setTitle(String str) {
        m11016a(new de(this, str));
    }

    @JavascriptInterface
    public void setListener(String str) {
        m11020b(new df(this, str));
    }

    @JavascriptInterface
    public void removeListener(String str) {
        m11020b(new dg(this, str));
    }

    @JavascriptInterface
    public void sendBroadcast(String str, String str2) {
        m11020b(new dh(this, str, str2));
    }

    @JavascriptInterface
    public String getMiAccountProfile() {
        return (String) m11015a(new di(this), new JSONObject().toString());
    }

    @JavascriptInterface
    public String getClientInfo() {
        return (String) m11015a(new dj(this), new JSONObject().toString());
    }

    @JavascriptInterface
    public void login(String str) {
        m11020b(new dl(this, str));
    }

    @JavascriptInterface
    public void relogin(String str) {
        m11020b(new dp(this, str));
    }

    @JavascriptInterface
    public boolean isMiGuestAccount() {
        return ((Boolean) m11015a(new ds(this), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public void loginAccount(String str) {
        m11020b(new dt(this, str));
    }

    @JavascriptInterface
    public boolean isAccessibilityEnabled() {
        return ((Boolean) m11015a(new du(this), Boolean.valueOf(false))).booleanValue();
    }

    /* renamed from: a */
    private void m11007a(String str) {
        m11020b(new dv(this, str));
    }

    /* renamed from: b */
    private void m11010b(String str) {
        m11020b(new dy(this, str));
    }

    /* renamed from: c */
    private void m11012c(String str) {
        m11020b(new eb(this, str));
    }

    /* renamed from: d */
    private void m11014d(String str) {
        m11020b(new ee(this, str));
    }

    /* renamed from: a */
    private void m11008a(String str, C0672a c0672a) {
        ArrayList arrayList = new ArrayList();
        if ((c0672a instanceof PersonalAccount) && ((PersonalAccount) c0672a).mo843n()) {
            c0672a = C0709k.m3476a().m3508d();
        }
        if (c0672a instanceof UserAccount) {
            Map h = c0672a.mo838h();
            for (String str2 : h.keySet()) {
                arrayList.add(str2);
                arrayList.add(h.get(str2));
            }
        } else {
            arrayList.add("token");
            arrayList.add(c0672a.mo834d());
        }
        if (c0672a.mo836f() instanceof bd) {
            arrayList.add("serviceToken");
            arrayList.add(((bd) c0672a.mo836f()).f2402b);
        }
        this.f7581b.web_notifyWeb(str, 0, arrayList.toArray(new Object[0]));
    }

    @JavascriptInterface
    public boolean isLogin() {
        return ((Boolean) m11015a(new eh(this), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public void scrollPosToTop(int i, int i2, boolean z) {
        m11016a(new ej(this, i, i2, z));
    }

    @JavascriptInterface
    public void setPageAttributes(String str) {
        m11020b(new ek(this, str));
    }

    @JavascriptInterface
    @Deprecated
    public void openInputView(String str) {
        m11020b(new eq(this, str));
    }

    @JavascriptInterface
    public void requestBarVisible(boolean z) {
        m11016a(new ez(this, z));
    }

    @JavascriptInterface
    public void openBrowser(String str) {
        m11016a(new fa(this, str));
    }

    @JavascriptInterface
    public void openMibiCenter() {
        m11016a(new fb(this));
    }

    @JavascriptInterface
    public void showMenu(String str) {
        m11020b(new fc(this, str));
    }

    @JavascriptInterface
    public void dropdownButton(String str) {
        m11020b(new fg(this, str));
    }

    @JavascriptInterface
    public void floatingMenu(String str) {
        m11020b(new fk(this, str));
    }

    @JavascriptInterface
    public void requestInputVisible(String str) {
        m11020b(new fo(this, str));
    }

    @JavascriptInterface
    public void confirm(String str) {
        m11020b(new fu(this, str));
    }

    @JavascriptInterface
    public void pullRefreshEnable(boolean z) {
        m11016a(new fy(this, z));
    }

    @JavascriptInterface
    public void setOverScrollEnabled(boolean z) {
    }

    @JavascriptInterface
    public String receiveParcel(String str) {
        return (String) m11015a(new fz(this, str), (Object) "");
    }

    @JavascriptInterface
    public void takeOverTouchEvents(boolean z) {
        m11016a(new ga(this, z));
    }

    @JavascriptInterface
    public void publishComment(String str) {
        m11020b(new gb(this, str));
    }

    @JavascriptInterface
    public void beginComment(String str) {
        m11020b(new ge(this, str));
    }

    @JavascriptInterface
    public void endComment() {
        m11016a(new gi(this));
    }

    @JavascriptInterface
    public void beginEditFeed(String str) {
        m11016a(new gj(this, str));
    }

    @JavascriptInterface
    public void endEditFeed() {
        m11016a(new gm(this));
    }

    @JavascriptInterface
    public void retryEditFeed() {
        m11016a(new gn(this));
    }

    @JavascriptInterface
    public boolean supportLimitedRead() {
        return true;
    }

    @JavascriptInterface
    public void reloadReadingPages() {
        m11020b(new gp(this));
    }

    @JavascriptInterface
    public void downloadSerialChapters(String str) {
        m11020b(new gr(this, str));
    }

    @JavascriptInterface
    public void querySerialDetail(String str) {
        m11020b(new gu(this, str));
    }

    @JavascriptInterface
    public void confirmAutoPay(String str) {
        m11020b(new gx(this, str));
    }

    @JavascriptInterface
    public String getPackageType(String str, String str2) {
        return (String) m11015a(new gz(this, str, str2), (Object) "");
    }

    @JavascriptInterface
    public int getBookshelfBookCount() {
        return ((Integer) m11015a(new ha(this), Integer.valueOf(0))).intValue();
    }

    @JavascriptInterface
    public void setSyncReadingData() {
        m11020b(new hb(this));
    }

    @JavascriptInterface
    public boolean getSyncReadingData() {
        return ((Boolean) m11015a(new he(this), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public void setRetroactiveCancel() {
    }

    @JavascriptInterface
    public void setRetroactiveSucceed(String str) {
        m11020b(new hf(this, str));
    }

    @JavascriptInterface
    public void setRetroactiveSucceed() {
        m11020b(new hi(this));
    }

    @JavascriptInterface
    public void setCheckinSucceed(String str) {
        m11020b(new hk(this, str));
    }

    @JavascriptInterface
    public void showSearchHome(String str) {
        m11016a(new hm(this, str));
    }

    @JavascriptInterface
    public void downloadBook(String str) {
        m11020b(new hn(this, str));
    }

    @JavascriptInterface
    public String getPurchasedBooks(String str) {
        return (String) m11015a(new hy(this, str), new JSONArray().toString());
    }

    @JavascriptInterface
    public String queryBook(String str) {
        return (String) m11015a(new hz(this, str), new JSONObject().toString());
    }

    @JavascriptInterface
    public void share(String str) {
        m11017a(new ia(this, str), this.f7581b.getContext().getString(C0258j.share_failed));
    }

    @JavascriptInterface
    public void shareBook(String str) {
        m11017a(new ie(this, str), this.f7581b.getContext().getString(C0258j.share_failed));
    }

    @JavascriptInterface
    public void shareSNS(String str) {
        m11020b(new ih(this, str));
    }

    @JavascriptInterface
    public void shareImage(String str) {
        m11017a(new ik(this, str), this.f7581b.getContext().getString(C0258j.share_failed));
    }

    @JavascriptInterface
    public void openMultiPages(String str) {
        m11020b(new io(this, str));
    }

    @JavascriptInterface
    public void setUserType(int i) {
        m11020b(new ir(this, i));
    }

    @JavascriptInterface
    public void updateSerialDetail(String str) {
        m11020b(new it(this, str));
    }

    @JavascriptInterface
    public boolean addBookToBookshelf(String str) {
        return ((Boolean) m11015a(new iw(this, str), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public void readBook(String str) {
        m11020b(new ix(this, str));
    }

    @JavascriptInterface
    public void open(String str) {
        m11020b(new jc(this, str));
    }

    @JavascriptInterface
    public int getPageHeaderHeight() {
        return ((Integer) m11019b(new jf(this), Integer.valueOf(0))).intValue();
    }

    @JavascriptInterface
    public int getPageHeaderPaddingTop() {
        return ((Integer) m11019b(new jg(this), Integer.valueOf(0))).intValue();
    }

    @JavascriptInterface
    public String getSerialPurchaseStatus(String str) {
        return (String) m11015a(new jh(this, str), new JSONObject().toString());
    }

    @JavascriptInterface
    public void updatePurchaseInfo(String str) {
        m11020b(new ji(this, str));
    }

    @JavascriptInterface
    public String getPackageInfo(String str) {
        return (String) m11015a(new jz(this, str), (Object) "");
    }

    @JavascriptInterface
    public void trackAdViewed(String str) {
        m11020b(new kb(this, str));
    }

    @JavascriptInterface
    public void trackAdClicked(String str) {
        m11020b(new kc(this, str));
    }

    @JavascriptInterface
    public void queryAds(String str) {
        m11020b(new kd(this, str));
    }

    @JavascriptInterface
    public boolean supportAutoInstall() {
        return ((Boolean) m11015a(new kf(this), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public boolean downloadAdApp(String str) {
        C0328a.m757c().m752c(LogLevel.INFO, "task_wall", "download called");
        return ((Boolean) m11015a(new kg(this, str), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public boolean openOutUrl(String str) {
        return ((Boolean) m11015a(new ki(this, str), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public boolean openAdApp(String str) {
        return ((Boolean) m11015a(new kj(this, str), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public void sysNotify(String str) {
        m11016a(new kk(this, str));
    }

    @JavascriptInterface
    public void insertMiuiFavorItem(String str) {
        m11016a(new kl(this, str));
    }

    @JavascriptInterface
    public void openContest() {
        m11016a(new km(this));
    }

    /* renamed from: a */
    protected final <T> T m11015a(Callable<T> callable, T t) {
        try {
            if (m11018a()) {
                t = callable.call();
            }
        } catch (Throwable th) {
            C0328a.m757c().m748a(LogLevel.ERROR, "jscall", "unexpected exception!", th);
        }
        return t;
    }

    /* renamed from: b */
    protected final <T> T m11019b(Callable<T> callable, T t) {
        try {
            if (m11018a()) {
                t = UThread.m1035a((Callable) callable);
            }
        } catch (Throwable th) {
            C0328a.m757c().m748a(LogLevel.ERROR, "jscall", "unexpected exception!", th);
        }
        return t;
    }

    /* renamed from: a */
    protected void m11016a(as asVar) {
        UThread.runOnThread(new cm(this, asVar));
    }

    /* renamed from: b */
    protected void m11020b(as asVar) {
        try {
            if (m11018a()) {
                asVar.mo1831a();
            }
        } catch (Throwable th) {
            C0328a.m757c().m748a(LogLevel.ERROR, "jscall", "unexpected exception!", th);
        }
    }

    /* renamed from: a */
    protected void m11017a(as asVar, String str) {
        try {
            if (m11018a()) {
                asVar.mo1831a();
            }
        } catch (Throwable th) {
            C0328a.m757c().m748a(LogLevel.ERROR, "jscall", "unexpected exception!", th);
            if (!TextUtils.isEmpty(str)) {
                be.m10287a(this.f7581b.getContext(), (CharSequence) str, 1).show();
            }
        }
    }

    /* renamed from: a */
    protected boolean m11018a() {
        Uri a = C0324a.m734a(this.f7581b.currentUrl());
        String scheme = (a == null || a.getScheme() == null) ? "" : a.getScheme();
        if (scheme.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) || scheme.equalsIgnoreCase("https")) {
            Object host = a.getHost() != null ? a.getHost() : "";
            if (this.f7580a.matcher(host).matches()) {
                return true;
            }
            if (UrlResolverHelper.isMiHost(host)) {
                return true;
            }
        } else if (scheme.equalsIgnoreCase("file")) {
            scheme = a.getPath() != null ? a.getPath() : "";
            if (scheme.startsWith(DkApp.get().getFilesDir().getPath())) {
                return true;
            }
            if (scheme.startsWith(DkApp.get().getCacheDir().getPath())) {
                return true;
            }
        }
        if (C0641o.m2934i().m2984k()) {
            return false;
        }
        return true;
    }
}
