package com.duokan.reader.ui.general.web;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;

import com.duokan.c.j;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.as;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.UserAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.bh;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.ui.general.be;

import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

import miui.webkit.UrlResolverHelper;

public class cg {
    private final Pattern a = Pattern.compile("www\\.(.+\\.)*duokan\\.com", 2);
    final /* synthetic */ StorePageController b;

    public cg(StorePageController storePageController) {
        this.b = storePageController;
    }

    @JavascriptInterface
    public void log(String str) {
        b(new ch(this, str));
    }

    @JavascriptInterface
    public void showToast(String str) {
        a(new cv(this, str));
    }

    @JavascriptInterface
    public void pageCreated(int i, String str) {
        a(new dl(this, i, str));
    }

    @JavascriptInterface
    public boolean isNetworkConnected() {
        return ((Boolean) a(new eo(this), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public boolean isWifiConnected() {
        return ((Boolean) a(new fp(this), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public int getServerConfig() {
        return ((Integer) a(new gm(this), Integer.valueOf(0))).intValue();
    }

    @JavascriptInterface
    public boolean isMiui() {
        return ((Boolean) a(new he(this), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public int getPagePaddingBottom() {
        return ((Integer) a(new ik(this), Integer.valueOf(0))).intValue();
    }

    @JavascriptInterface
    public void showProgress(String str) {
        b(new jr(this, str));
    }

    @JavascriptInterface
    public void pageLoading(boolean z) {
        b(new ci(this, z));
    }

    @JavascriptInterface
    public void lsSetItem(String str, String str2) {
        lsSetItem(str, str2, true);
    }

    @JavascriptInterface
    public void lsSetItem(String str, String str2, boolean z) {
        b(new ck(this, str, str2, z));
    }

    @JavascriptInterface
    public String lsGetItem(String str) {
        return (String) a(new cl(this, str), (Object) "");
    }

    @JavascriptInterface
    public void lsRemoveItem(String str) {
        b(new cm(this, str));
    }

    @JavascriptInterface
    public void ajax(String str) {
        b(new cn(this, str));
    }

    @JavascriptInterface
    public void button(String str) {
        b(new cp(this, str));
    }

    @JavascriptInterface
    public int getScreenOrientation() {
        return this.b.mScreenOrientation;
    }

    @JavascriptInterface
    public String listPaymentMethods() {
        return (String) a(new cr(this), new JSONArray().toString());
    }

    @JavascriptInterface
    public String listLoginMethods() {
        return (String) a(new cs(this), new JSONArray().put("MI_LOCAL").toString());
    }

    @JavascriptInterface
    public String getSystemMiId() {
        return (String) a(new ct(this), (Object) "");
    }

    @JavascriptInterface
    public void pay(String str) {
        b(new cu(this, str));
    }

    @JavascriptInterface
    public void goBack() {
        a(new cw(this));
    }

    @JavascriptInterface
    public void requestFinish() {
        requestFinish(null);
    }

    @JavascriptInterface
    public void requestFinish(String str) {
        a(new cx(this, str));
    }

    @JavascriptInterface
    public void setTitle(String str) {
        a(new cy(this, str));
    }

    @JavascriptInterface
    public void setListener(String str) {
        b(new cz(this, str));
    }

    @JavascriptInterface
    public void removeListener(String str) {
        b(new da(this, str));
    }

    @JavascriptInterface
    public void sendBroadcast(String str, String str2) {
        b(new db(this, str, str2));
    }

    @JavascriptInterface
    public String getMiAccountProfile() {
        return (String) a(new dc(this), new JSONObject().toString());
    }

    @JavascriptInterface
    public String getClientInfo() {
        return (String) a(new dd(this), new JSONObject().toString());
    }

    @JavascriptInterface
    public void login(String str) {
        b(new de(this, str));
    }

    @JavascriptInterface
    public void relogin(String str) {
        b(new di(this, str));
    }

    @JavascriptInterface
    public boolean isMiGuestAccount() {
        return ((Boolean) a(new dm(this), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public void loginAccount(String str) {
        b(new dn(this, str));
    }

    private void a(String str) {
        b(new do (this, str));
    }

    private void b(String str) {
        b(new dr(this, str));
    }

    private void c(String str) {
        b(new du(this, str));
    }

    private void d(String str) {
        b(new dx(this, str));
    }

    private void a(String str, a aVar) {
        ArrayList arrayList = new ArrayList();
        if ((aVar instanceof PersonalAccount) && ((PersonalAccount) aVar).n()) {
            aVar = i.f().c();
        }
        if (aVar instanceof UserAccount) {
            Map h = aVar.h();
            for (String str2 : h.keySet()) {
                arrayList.add(str2);
                arrayList.add(h.get(str2));
            }
        } else {
            arrayList.add("token");
            arrayList.add(aVar.d());
        }
        if (aVar.f() instanceof bh) {
            arrayList.add("serviceToken");
            arrayList.add(((bh) aVar.f()).b);
        }
        this.b.web_notifyWeb(str, 0, arrayList.toArray(new Object[0]));
    }

    @JavascriptInterface
    public boolean isLogin() {
        return ((Boolean) a(new ea(this), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public void scrollPosToTop(int i, int i2, boolean z) {
        a(new eb(this, i, i2, z));
    }

    @JavascriptInterface
    public void setPageAttributes(String str) {
        b(new ec(this, str));
    }

    @JavascriptInterface
    @Deprecated
    public void openInputView(String str) {
        b(new ef(this, str));
    }

    @JavascriptInterface
    public void requestBarVisible(boolean z) {
        a(new ep(this, z));
    }

    @JavascriptInterface
    public void openBrowser(String str) {
        a(new eq(this, str));
    }

    @JavascriptInterface
    public void openMibiCenter() {
        a(new er(this));
    }

    @JavascriptInterface
    public void showMenu(String str) {
        b(new es(this, str));
    }

    @JavascriptInterface
    public void dropdownButton(String str) {
        b(new ew(this, str));
    }

    @JavascriptInterface
    public void floatingMenu(String str) {
        b(new fa(this, str));
    }

    @JavascriptInterface
    public void requestInputVisible(String str) {
        b(new fe(this, str));
    }

    @JavascriptInterface
    public void confirm(String str) {
        b(new fj(this, str));
    }

    @JavascriptInterface
    public void pullRefreshEnable(boolean z) {
        a(new fn(this, z));
    }

    @JavascriptInterface
    public void setOverScrollEnabled(boolean z) {
    }

    @JavascriptInterface
    public String receiveParcel(String str) {
        return (String) a(new fo(this, str), (Object) "");
    }

    @JavascriptInterface
    public void takeOverTouchEvents(boolean z) {
        a(new fq(this, z));
    }

    @JavascriptInterface
    public void publishComment(String str) {
        b(new fr(this, str));
    }

    @JavascriptInterface
    public void beginComment(String str) {
        b(new fu(this, str));
    }

    @JavascriptInterface
    public void endComment() {
        a(new fy(this));
    }

    @JavascriptInterface
    public void beginEditFeed(String str) {
        a(new fz(this, str));
    }

    @JavascriptInterface
    public void endEditFeed() {
        a(new gc(this));
    }

    @JavascriptInterface
    public void retryEditFeed() {
        a(new gd(this));
    }

    @JavascriptInterface
    public boolean supportLimitedRead() {
        return true;
    }

    @JavascriptInterface
    public void reloadReadingPages() {
        b(new ge(this));
    }

    @JavascriptInterface
    public void downloadSerialChapters(String str) {
        b(new gg(this, str));
    }

    @JavascriptInterface
    public void querySerialDetail(String str) {
        b(new gj(this, str));
    }

    @JavascriptInterface
    public void confirmAutoPay(String str) {
        b(new gn(this, str));
    }

    @JavascriptInterface
    public String getPackageType(String str, String str2) {
        return (String) a(new gp(this, str, str2), (Object) "");
    }

    @JavascriptInterface
    public int getBookshelfBookCount() {
        return ((Integer) a(new gq(this), Integer.valueOf(0))).intValue();
    }

    @JavascriptInterface
    public void setSyncReadingData() {
        b(new gr(this));
    }

    @JavascriptInterface
    public boolean getSyncReadingData() {
        return ((Boolean) a(new gu(this), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public void setRetroactiveCancel() {
        b(new gv(this));
    }

    @JavascriptInterface
    public void setRetroactiveSucceed(String str) {
        b(new gx(this, str));
    }

    @JavascriptInterface
    public void setRetroactiveSucceed() {
        b(new ha(this));
    }

    @JavascriptInterface
    public void setCheckinSucceed(String str) {
        b(new hb(this, str));
    }

    @JavascriptInterface
    public void showSearchHome(String str) {
        a(new hd(this, str));
    }

    @JavascriptInterface
    public void downloadBook(String str) {
        b(new hf(this, str));
    }

    @JavascriptInterface
    public String getPurchasedBooks(String str) {
        return (String) a(new hq(this, str), new JSONArray().toString());
    }

    @JavascriptInterface
    public String queryBook(String str) {
        return (String) a(new hr(this, str), new JSONObject().toString());
    }

    @JavascriptInterface
    public void share(String str) {
        a(new hs(this, str), this.b.getContext().getString(j.share_failed));
    }

    @JavascriptInterface
    public void shareBook(String str) {
        a(new hw(this, str), this.b.getContext().getString(j.share_failed));
    }

    @JavascriptInterface
    public void shareSNS(String str) {
        b(new hz(this, str));
    }

    @JavascriptInterface
    public void openMultiPages(String str) {
        b(new ic(this, str));
    }

    @JavascriptInterface
    public void setUserType(int i) {
        b(new ie(this, i));
    }

    @JavascriptInterface
    public void updateSerialDetail(String str) {
        b(new ig(this, str));
    }

    @JavascriptInterface
    public boolean addBookToBookshelf(String str) {
        return ((Boolean) a(new ij(this, str), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public void readBook(String str) {
        b(new il(this, str));
    }

    @JavascriptInterface
    public void open(String str) {
        b(new iq(this, str));
    }

    @JavascriptInterface
    public int getPageHeaderHeight() {
        return ((Integer) b(new is(this), Integer.valueOf(0))).intValue();
    }

    @JavascriptInterface
    public int getPageHeaderPaddingTop() {
        return ((Integer) b(new it(this), Integer.valueOf(0))).intValue();
    }

    @JavascriptInterface
    public String getSerialPurchaseStatus(String str) {
        return (String) a(new iu(this, str), new JSONObject().toString());
    }

    @JavascriptInterface
    public void updatePurchaseInfo(String str) {
        b(new iv(this, str));
    }

    @JavascriptInterface
    public String getPackageInfo(String str) {
        return (String) a(new jm(this, str), (Object) "");
    }

    @JavascriptInterface
    public void trackAdViewed(String str) {
        b(new jn(this, str));
    }

    @JavascriptInterface
    public void queryAds(String str) {
        b(new jo(this, str));
    }

    @JavascriptInterface
    public boolean supportAutoInstall() {
        return ((Boolean) a(new jq(this), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public boolean downloadAdApp(String str) {
        com.duokan.core.diagnostic.a.c().c(LogLevel.INFO, "task_wall", "download called");
        return ((Boolean) a(new jt(this, str), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public boolean openAdApp(String str) {
        return ((Boolean) a(new jv(this, str), Boolean.valueOf(false))).booleanValue();
    }

    @JavascriptInterface
    public void sysNotify(String str) {
        a(new jw(this, str));
    }

    @JavascriptInterface
    public void insertMiuiFavorItem(String str) {
        a(new jx(this, str));
    }

    protected final Object a(Callable callable, Object obj) {
        try {
            if (a()) {
                obj = callable.call();
            }
        } catch (Throwable th) {
            com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "jscall", "unexpected exception!", th);
        }
        return obj;
    }

    protected final Object b(Callable callable, Object obj) {
        try {
            if (a()) {
                obj = TaskHandler.postTask(callable);
            }
        } catch (Throwable th) {
            com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "jscall", "unexpected exception!", th);
        }
        return obj;
    }

    protected void a(as asVar) {
        TaskHandler.postTask(new jy(this, asVar));
    }

    protected void b(as asVar) {
        try {
            if (a()) {
                asVar.a();
            }
        } catch (Throwable th) {
            com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "jscall", "unexpected exception!", th);
        }
    }

    protected void a(as asVar, String str) {
        try {
            if (a()) {
                asVar.a();
            }
        } catch (Throwable th) {
            com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "jscall", "unexpected exception!", th);
            if (!TextUtils.isEmpty(str)) {
                be.a(this.b.getContext(), (CharSequence) str, 1).show();
            }
        }
    }

    protected boolean a() {
        Uri a = com.duokan.core.b.a.a(this.b.currentUrl());
        String scheme = (a == null || a.getScheme() == null) ? "" : a.getScheme();
        if (scheme.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) || scheme.equalsIgnoreCase("https")) {
            Object host = a.getHost() != null ? a.getHost() : "";
            if (this.a.matcher(host).matches()) {
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
        if (p.i().k()) {
            return false;
        }
        return true;
    }
}
