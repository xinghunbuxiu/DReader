package com.duokan.reader.ui.general.web;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.widget.TextView;

import com.duokan.common.tools;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IActivityRunStatusChanged;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.TansFormUtils;
import com.duokan.core.b.UrlTools;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.af;
import com.duokan.core.sys.z;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.OnScrollListener;
import com.duokan.core.ui.PullDownRefreshView.RefreshStyle;
import com.duokan.core.ui.Scrollable.OverScrollMode;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.classc;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.common.webservices.duokan.DkSignInReward;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.ad.AdLifecycleManager;
import com.duokan.reader.domain.ad.r;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.payment.d;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreFiction;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.ITheme;
import com.duokan.reader.ui.account.ay;
import com.duokan.reader.ui.general.LoadingCircleView;
import com.duokan.reader.ui.general.LoadingCircleView.LoadingStyle;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.cg;
import com.duokan.reader.ui.general.cj;
import com.duokan.reader.ui.general.ia;
import com.duokan.reader.ui.general.jf;
import com.duokan.reader.ui.general.jq;
import com.duokan.reader.ui.store.ao;
import com.duokan.reader.ui.store.comment.f;
import com.duokan.reader.ui.store.o;
import com.mipay.sdk.Mipay;

import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class StorePageController extends StoreWebController implements SystemUiConditioner {
    public static final int LATEST_VERSION_CODE = 2;
    public static final String PAY_CONTINUE = "PAY_CONTINUE";
    public static final int SERIAL_CHAPTER_STATE_DOWNLOADED = 2;
    public static final int SERIAL_CHAPTER_STATE_PURCHASED = 1;
    protected static final int VERSION_CODE_2 = 2;
    private static String mBackParam = null;
    private static h sAccountListener = null;
    private static boolean sCookieSet = false;
    private static StorePageController sPreloadedController = null;
    private static IActivityRunStatusChanged sRunningStateListener = null;
    private AdLifecycleManager mAdLifecycleManager;
    private r mAdSdkService;
    private cf mBannerInfo;
    protected DkStoreBookDetail mBookCache;
    protected final ao mDetailFeature;
    private f mEditCommentDialog;
    private com.duokan.reader.ui.a.a mEditFeedController;
    protected j mErrorDialog;
    protected final View mErrorView;
    private final ConcurrentHashMap mEventListMap;
    protected DkStoreFictionDetail mFictionCache;
    protected boolean mFullscreen;
    private Boolean mHasBar;
    private boolean mHasTabsTitleChange;
    private boolean mHasTitle;
    private final HashMap mHeaderViewRightButtonConditionMap;
    private boolean mImmersive;
    private BoxView mInputBoxView;
    private JSONObject mInputFlag;
    private boolean mJsPageLoading;
    private int mJsPageStatusCode;
    protected final HashMap mListeners;
    private String mOriginUrl;
    private PageHeaderView mPageHeaderView;
    private int mPageHeight;
    protected final jq mPageLoadingDlg;
    protected final View mPageLoadingView;
    private String mPageTitle;
    private boolean mPageTitleLeft;
    private jq mProgressDialog;
    private boolean mRequestBack;
    private int mScreenOrientation;
    private boolean mScrollSmoothly;
    private ActivatedController mShareController;
    protected ay mShareEntranceContext;
    private int mSurfingBarOffset;
    private final LinkedHashMap mTabsTitle;
    protected boolean mTransparent;
    protected final View mWebRootView;

    enum TabState {
        DEFAULT,
        OVER_SURFING_BAR_HEAD,
        OVER_HALF_SURFING_BAR,
        OVER_SURFING_BAR
    }

    public void refresh() {
        super.refresh();
    }

    public void updateStoreMirror(boolean z) {
        super.updateStoreMirror(z);
    }

    public static StorePageController createWebPage(IFeature featrue) {
        StorePageController storePageController;
        WebLog.c().WebLog();
        StorePageController storePageController2 = sPreloadedController;
        if (storePageController2 == null || storePageController2.getActivity() != TansFormUtils.getContext((Context) featrue)) {
            storePageController = new StorePageController(featrue);
            storePageController.loadUrl(p.i().a());
        } else {
            storePageController = storePageController2;
        }
        sPreloadedController = null;
        return storePageController;
    }

    public StorePageController(IFeature featrue) {
        super(featrue);
        this.mEventListMap = new ConcurrentHashMap();
        this.mTabsTitle = new LinkedHashMap();
        this.mScreenOrientation = 0;
        this.mJsPageLoading = false;
        this.mJsPageStatusCode = 0;
        this.mListeners = new HashMap();
        this.mRequestBack = false;
        this.mDetailFeature = new aq(this);
        this.mFictionCache = null;
        this.mBookCache = null;
        this.mShareEntranceContext = null;
        this.mProgressDialog = null;
        this.mPageHeaderView = null;
        this.mPageTitle = "";
        this.mPageTitleLeft = false;
        this.mInputBoxView = null;
        this.mInputFlag = null;
        this.mOriginUrl = "";
        this.mHasBar = null;
        this.mTransparent = false;
        this.mFullscreen = false;
        this.mImmersive = false;
        this.mHasTitle = true;
        this.mScrollSmoothly = true;
        this.mHasTabsTitleChange = true;
        this.mSurfingBarOffset = 3000;
        this.mBannerInfo = new cf(this);
        this.mErrorDialog = null;
        this.mEditFeedController = null;
        this.mShareController = null;
        this.mPageHeight = 0;
        this.mAdLifecycleManager = new AdLifecycleManager();
        this.mAdSdkService = null;
        this.mEditCommentDialog = null;
        this.mScreenOrientation = getContext().getResources().getConfiguration().orientation;
        this.mWebRootView = findViewById(R.id.general__web_core_view__root);
        setCookie();
        this.mPageLoadingView = findViewById(R.id.general__web_core_view__first_load);
        this.mPageLoadingDlg = initWaitingDialog();
        this.mErrorView = findViewById(R.id.general__web_core_view__error);
        ((TextView) this.mErrorView.findViewById(R.id.general__emtpy_view__line_1)).setText(com.duokan.c.j.general__shared__web_error);
        TextView textView = (TextView) this.mErrorView.findViewById(g.general__emtpy_view__line_3);
        textView.setText(R.String.general__shared__web_refresh);
        textView.setVisibility(View.VISIBLE);
        textView.setOnClickListener(new bg(this));
        getContext().addFirstLocalFeature(this.mDetailFeature);
        this.mHeaderViewRightButtonConditionMap = new HashMap();
        js_addHeaderViewRightButtonCondition("PUBLISH_FEED", new kj(this, R.drawable.store__header_view_button__edit, null));
        js_addHeaderViewRightButtonCondition("CART_ADD", new kj(this, R.drawable.store__header_view_button__cart_add, null));
        js_addHeaderViewRightButtonCondition("CART_REMOVE", new kj(this, R.drawable.store__header_view_button__cart_remove, null));
        js_addHeaderViewRightButtonCondition("SEARCH", new kj(this, R.drawable.surfing__surfing_tab_view__search, new bv(this)));
        this.mPageHeaderView = (PageHeaderView) findViewById(R.id.general__web_view__header);
        this.mInputBoxView = (BoxView) findViewById(R.id.general__web_view__input_box);
        if (this.mPageHeaderView != null) {
            this.mPageHeaderView.setClickable(true);
        }
    }

    public void setTransparent(boolean z) {
        this.mTransparent = z;
        if (this.mTransparent) {
            getContentView().setBackgroundColor(0);
            this.mWebView.setBackgroundColor(0);
            this.mWebRootView.setBackgroundColor(0);
            setHasTitle(false);
            this.mWebView.setVerticalOverScrollMode(OverScrollMode.STRETCH);
            return;
        }
        this.mWebView.setVerticalOverScrollMode(OverScrollMode.NEVER);
    }

    public boolean getTransparent() {
        return this.mTransparent;
    }

    public void setFullscreen(boolean z) {
        this.mFullscreen = z;
        if (this.mFullscreen) {
            setHasTitle(false);
        } else {
            setHasTitle(true);
        }
    }

    public void setDarkBackground() {
        this.mWebView.setBackgroundColor(Color.parseColor("#dddddd"));
        this.mWebRootView.setBackgroundColor(0);
    }

    public void setRefreshStyle(RefreshStyle refreshStyle) {
        this.mWebView.setRefreshStyle(refreshStyle);
    }

    public void setLoadingStyle(LoadingStyle loadingStyle) {
        if (this.mPageLoadingView instanceof LoadingCircleView) {
            ((LoadingCircleView) this.mPageLoadingView).setLoadingStyle(loadingStyle);
        }
    }

    private LoadingStyle getLoadingStyle() {
        if (this.mPageLoadingView instanceof LoadingCircleView) {
            return ((LoadingCircleView) this.mPageLoadingView).getLoadingStyle();
        }
        return LoadingStyle.NORMAL;
    }

    public void onPageHeightChange(int i) {
    }

    protected jq initWaitingDialog() {
        return new jq(getContext());
    }

    public void chooseStatusBarStyle(af afVar) {
        if (isActive()) {
            afVar.a(Boolean.valueOf(this.mPageHeaderView != null ? this.mPageHeaderView.getDarkTitle() : true));
        }
    }

    public void chooseNavigationBarMode(af afVar) {
    }

    public void chooseNavigationBarColor(af afVar) {
    }

    public void setPageTitleLeft(boolean z) {
        this.mPageTitleLeft = z;
    }

    public void setPageTitle(String str) {
        this.mPageTitle = str;
        if (this.mPageHeaderView == null) {
            return;
        }
        if (this.mPageTitleLeft) {
            this.mPageHeaderView.setLeftTitle(this.mPageTitle);
        } else {
            this.mPageHeaderView.setCenterTitle(this.mPageTitle);
        }
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        if (this.mWebView.getLoadingError() != 0) {
            UmengManager.get().onEvent("STORE_LOADING_RESULT_V1", "fail");
        } else if (isLoading()) {
            UmengManager.get().onEvent("STORE_LOADING_RESULT_V1", "cancel");
        } else {
            UmengManager.get().onEvent("STORE_LOADING_RESULT_V1", "ok");
        }
        if (this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
        }
        if (this.mPageLoadingDlg != null) {
            this.mPageLoadingDlg.dismiss();
        }
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).removeSystemUiConditioner(this);
    }

    public void onStoreMirrorUpdated() {
        WebLog.c().WebLog();
        if (sPreloadedController != null) {
            sPreloadedController.mWebView.f();
            sPreloadedController = null;
        }
        triggerEventOnCurrentUrl("mirrorUpdated", null);
    }

    protected final void js_addHeaderViewRightButtonCondition(String str, kj kjVar) {
        this.mHeaderViewRightButtonConditionMap.put(str, kjVar);
    }

    protected void webPageLoading(boolean z) {
        if (z || !this.mJsPageLoading) {
            boolean z2 = webPageLoading() != z;
            super.webPageLoading(z);
            if (!z2) {
                return;
            }
            if (this.mTransparent) {
                this.mPageLoadingView.setVisibility(4);
                this.mPageLoadingView.clearAnimation();
                if (z) {
                    this.mPageLoadingDlg.open(new bx(this));
                    return;
                } else {
                    this.mPageLoadingDlg.dismiss();
                    return;
                }
            }
            Runnable byVar = new by(this);
            if (z) {
                TaskHandler.postDelayed(byVar, 300);
            } else {
                TaskHandler.postTask(byVar);
            }
            if (!webPageLoading()) {
                if (classc.f.b().e()) {
                    updateStoreMirror(false);
                }
                if (sPreloadedController == null) {
                    if (sRunningStateListener == null) {
                        sRunningStateListener = new cb(this);
                        ManagedApp.get().addOnRunningStateChangedListener(sRunningStateListener);
                    }
                    if (sAccountListener == null) {
                        sAccountListener = new cc(this);
                        i.f().add(sAccountListener);
                    }
                    TaskHandler.requstIdleStatusListening(new cd(this));
                }
            }
        }
    }

    protected void resetPageStatus() {
        super.resetPageStatus();
        this.mEventListMap.remove(getCurrentUrl());
        this.mJsPageStatusCode = 0;
        this.mJsPageLoading = false;
    }

    public void loadUrl(String str) {
        Uri uri = null;
        if (!TextUtils.isEmpty(str)) {
            Uri uri2;
            Uri parse = Uri.parse(str);
            if (TextUtils.equals(parse.getScheme(), "file")) {
                this.mOriginUrl = str;
            } else if (TextUtils.isEmpty(parse.getHost())) {
                this.mOriginUrl = p.i().z() + str;
            } else if (TextUtils.isEmpty(parse.getScheme())) {
                this.mOriginUrl = "http://" + str;
            } else {
                this.mOriginUrl = str;
            }
            Object encodedQuery = parse.getEncodedQuery();
            if (TextUtils.isEmpty(encodedQuery)) {
                uri2 = null;
            } else {
                uri2 = Uri.parse("?" + encodedQuery);
            }
            Object encodedFragment = parse.getEncodedFragment();
            if (!TextUtils.isEmpty(encodedFragment)) {
                String[] split = encodedFragment.split("\\?");
                uri = Uri.parse("?" + split[0]);
                if (split.length > 1) {
                    uri2 = Uri.parse("?" + split[1]);
                }
            }
            if (TextUtils.equals(getQueryOrFragmentParameter(uri2, uri, "native_transparent"), "1")) {
                setTransparent(true);
            }
            if (TextUtils.equals(getQueryOrFragmentParameter(uri2, uri, "native_fullscreen"), "1")) {
                setFullscreen(true);
            }
            if (this.mPageHeaderView != null) {
                if (TextUtils.equals(getQueryOrFragmentParameter(uri2, uri, "native_darktitle"), "0")) {
                    this.mPageHeaderView.setDarkTitle(false);
                } else {
                    this.mPageHeaderView.setDarkTitle(true);
                }
            }
            if (TextUtils.equals(getQueryOrFragmentParameter(uri2, uri, "native_pullrefresh"), "0")) {
                this.mWebView.setPullDownRefreshEnabled(false);
            } else {
                this.mWebView.setPullDownRefreshEnabled(true);
            }
            if (TextUtils.equals(getQueryOrFragmentParameter(uri2, uri, "native_immersive"), "1")) {
                setImmersive(true);
            }
        }
        resetPageStatus();
        this.mWebView.a(this.mOriginUrl);
    }

    private String getQueryOrFragmentParameter(Uri uri, Uri uri2, String str) {
        String str2 = null;
        try {
            str2 = uri.getQueryParameter(str);
        } catch (Throwable th) {
        }
        if (TextUtils.isEmpty(str2)) {
            try {
                str2 = uri2.getQueryParameter(str);
            } catch (Throwable th2) {
            }
        }
        return str2;
    }

    public void wakeUp() {
        reActive();
    }

    public void backToTopSmoothly() {
        this.mWebView.a(0, 0, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
    }

    public boolean transparent() {
        return this.mTransparent;
    }

    private void updateFeedReplyInputCache(cg cgVar, String str) {
        if (TextUtils.isEmpty(str)) {
            cgVar.a();
            return;
        }
        cj cjVar = new cj();
        cjVar.a = str;
        cgVar.a(cjVar);
    }

    private void setWebViewPadding() {
        int b = UTools.getMinimumHeight(getContext(), 65.0f);
        if (this.mHasTitle && this.mImmersive) {
            b = 0;
        } else if (!this.mHasTitle) {
            b = 0;
        }
        this.mWebRootView.setPadding(0, b, 0, 0);
    }

    protected DkSignInInfo jsonToDkSignInInfo(String str) {
        int i = 7;
        int i2 = 0;
        boolean z = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject == null) {
                return null;
            }
            int i3;
            DkSignInInfo dkSignInInfo = new DkSignInInfo();
            JSONArray optJSONArray = jSONObject.optJSONArray("status");
            boolean[] zArr = new boolean[optJSONArray.length()];
            for (i3 = 0; i3 < optJSONArray.length(); i3++) {
                zArr[i3] = optJSONArray.getString(i3).equals("1");
            }
            dkSignInInfo.mSignStatus = zArr;
            i3 = jSONObject.optInt("today");
            if (i3 < 1) {
                i3 = 1;
            }
            if (i3 <= 7) {
                i = i3;
            }
            dkSignInInfo.mToday = i;
            if (jSONObject.optInt("lottery") != 1) {
                z = false;
            }
            dkSignInInfo.mLottery = z;
            JSONArray optJSONArray2 = jSONObject.optJSONArray("gift");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                return dkSignInInfo;
            }
            while (i2 < optJSONArray2.length()) {
                JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                DkSignInReward dkSignInReward = new DkSignInReward();
                dkSignInReward.mName = jSONObject2.optString("name");
                dkSignInReward.mValue = jSONObject2.optString("value");
                dkSignInInfo.mReward.add(dkSignInReward);
                i2++;
            }
            return dkSignInInfo;
        } catch (Throwable th) {
            return null;
        }
    }

    @Deprecated
    protected void queryFictionDetail(String str, com.duokan.reader.domain.store.h hVar, boolean z) {
        if (this.mFictionCache == null || !TextUtils.equals(this.mFictionCache.getFiction().getBookUuid(), str)) {
            jq a;
            if (z) {
                a = jq.a(getContext(), "", getContext().getString(com.duokan.c.j.bookcity_store__shared__creating_order), true);
            } else {
                a = null;
            }
            o.a().a(str, false, false, -1, -1, -1, new ce(this, a, hVar));
            return;
        }
        hVar.onFetchBookDetailOk(this.mFictionCache);
    }

    protected void showFictionToc(String str, boolean z) {
        TaskHandler.postTask(new ar(this, str, z));
    }

    private JSONObject jsonSerialDetail(DkStoreFictionDetail dkStoreFictionDetail) {
        try {
            boolean z;
            int i;
            DkStoreFiction fiction = dkStoreFictionDetail.getFiction();
            String bookUuid = fiction.getBookUuid();
            ej ejVar = (ej) ai.a().b(bookUuid);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bookUuid", bookUuid);
            jSONObject.put("price", fiction.getPrice());
            int specialPrice = (int) (fiction.getSpecialPrice() * 100.0f);
            if (specialPrice > 0) {
                jSONObject.put("special", specialPrice);
            }
            DkCloudPurchasedFiction b = DkUserPurchasedFictionsManager.a().b(bookUuid);
            HashSet hashSet = new HashSet();
            if (b != null) {
                boolean isEntirePaid = b.isEntirePaid();
                if (isEntirePaid) {
                    z = isEntirePaid;
                } else {
                    String[] paidChaptersId = b.getPaidChaptersId();
                    for (Object add : paidChaptersId) {
                        hashSet.add(add);
                    }
                    z = isEntirePaid;
                }
            } else {
                z = false;
            }
            JSONArray jSONArray = new JSONArray();
            DkCloudFictionChapter[] toc = dkStoreFictionDetail.getToc();
            for (int i2 = 0; i2 < toc.length; i2++) {
                String cloudId = toc[i2].getCloudId();
                String title = toc[i2].getTitle();
                short basePrice = (short) toc[i2].getBasePrice();
                if (z) {
                    i = (short) 1;
                } else {
                    specialPrice = (basePrice == (short) 0 || hashSet.contains(cloudId)) ? 1 : 0;
                    i = (short) (specialPrice | 0);
                }
                if (ejVar != null) {
                    specialPrice = (short) ((ejVar.u(cloudId) ? 2 : 0) | i);
                } else {
                    specialPrice = i;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", cloudId);
                jSONObject2.put("title", title);
                jSONObject2.put("price", basePrice);
                jSONObject2.put("state", specialPrice);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("chapters", jSONArray);
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    protected void downloadChapter(fv fvVar, String str, DkStoreBookDetail dkStoreBookDetail) {
        if (!classc.f.b().e()) {
            be.a(getContext(), getContext().getString(com.duokan.c.j.general__shared__network_error), 1).show();
            web_notifyWeb(str, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, r0);
        } else if (classc.f.b().d()) {
            fvVar.a(true, new af(Boolean.valueOf(false)));
            web_notifyWeb(str, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
        } else if (dkStoreBookDetail.getHighSize() == 0 && dkStoreBookDetail.getLowSize() == 0) {
            fvVar.a(false, new af(Boolean.valueOf(false)));
            web_notifyWeb(str, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
        } else if (((double) dkStoreBookDetail.getHighSize()) * 0.8d <= ((double) dkStoreBookDetail.getLowSize()) || dkStoreBookDetail.getLowSize() <= 0) {
            ap apVar = new ap(getContext());
            apVar.setPrompt(String.format(getContext().getResources().getString(com.duokan.c.j.reading__shared__download_prompt), new Object[]{tools.getByteSize(dkStoreBookDetail.getHighSize())}));
            apVar.setCancelLabel(com.duokan.c.j.general__shared__cancel);
            apVar.setOkLabel(com.duokan.c.j.general__shared__ok);
            apVar.open(new av(this, fvVar, str));
        } else {
            ia iaVar = new ia(getContext());
            iaVar.a(getContext().getResources().getString(com.duokan.c.j.reading__shared__download_prompt1));
            iaVar.b(String.format(getContext().getResources().getString(com.duokan.c.j.reading__shared__low_quality), new Object[]{tools.getByteSize(dkStoreBookDetail.getLowSize())}));
            iaVar.b(String.format(getContext().getResources().getString(com.duokan.c.j.reading__shared__high_quality), new Object[]{tools.getByteSize(dkStoreBookDetail.getHighSize())}));
            iaVar.a(new at(this, fvVar, str));
            iaVar.open(new au(this, str));
        }
    }

    private void downloadLinearBook(String str, String str2, String str3, DkStoreBookDetail dkStoreBookDetail, String str4) {
        fv fvVar = (fv) ai.a().b(str3);
        if (fvVar == null) {
            c a = ai.a().a(dkStoreBookDetail);
            a.j(str4);
            ((fv) a).a(new ax(this, jq.a(getContext(), "", getContext().getString(com.duokan.c.j.bookcity_store__shared__creating_order), true), str, dkStoreBookDetail));
        } else if (TextUtils.equals(str2, "NORMAL")) {
            downloadChapter(fvVar, str, dkStoreBookDetail);
        } else if (TextUtils.equals(str2, "UPDATING")) {
            DkCloudStorage.a().a(fvVar.H(), new aw(this, fvVar, str));
        }
    }

    protected void queryBookDetail(String str, boolean z, com.duokan.reader.domain.store.h hVar, boolean z2) {
        jq a;
        DkStoreItem dkStoreItem = this.mBookCache;
        if (dkStoreItem != null && TextUtils.equals(this.mBookCache.getBook().getBookUuid(), str)) {
            if (!z) {
                hVar.onFetchBookDetailOk(dkStoreItem);
                return;
            } else if (dkStoreItem.getToc().length > 0) {
                hVar.onFetchBookDetailOk(dkStoreItem);
                return;
            }
        }
        if (z2) {
            a = jq.a(getContext(), "", getContext().getString(com.duokan.c.j.bookcity_store__shared__creating_order), true);
        } else {
            a = null;
        }
        com.duokan.reader.domain.store.a.a().a(str, z, new az(this, a, hVar));
    }

    protected void queryBookDetail(String str, com.duokan.reader.domain.store.h hVar, boolean z) {
        queryBookDetail(str, false, hVar, z);
    }

    protected void giving(String str) {
        TaskHandler.postTask(new ba(this, str));
    }

    private void showBookToc(String str) {
        TaskHandler.postTask(new bd(this, str));
    }

    protected void showBookChangeLog(String str) {
        TaskHandler.postTask(new bf(this, str));
    }

    protected void registerEventOnCurrentUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri a = UrlTools.parse(getCurrentUrl());
            if (a != null && a.getPath() != null) {
                String path = a.getPath();
                if (!this.mEventListMap.containsKey(path)) {
                    this.mEventListMap.putIfAbsent(path, new CopyOnWriteArrayList());
                }
                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.mEventListMap.get(path);
                WebLog.c().b(copyOnWriteArrayList != null);
                copyOnWriteArrayList.add(str);
            }
        }
    }

    protected void unregisterEventOnCurrentUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri a = UrlTools.parse(getCurrentUrl());
            if (a != null && a.getPath() != null) {
                String path = a.getPath();
                if (this.mEventListMap.containsKey(path)) {
                    CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.mEventListMap.get(path);
                    WebLog.c().b(copyOnWriteArrayList != null);
                    copyOnWriteArrayList.remove(str);
                    if (TextUtils.equals(str, "adAppInstallStatus")) {
                        this.mAdLifecycleManager.g(path);
                    }
                }
            }
        }
    }

    protected boolean triggerEventOnCurrentUrl(String str, Object obj) {
        Uri a = UrlTools.parse(getCurrentUrl());
        if (a == null || a.getPath() == null) {
            return false;
        }
        String path = a.getPath();
        if (!this.mEventListMap.containsKey(path)) {
            return false;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.mEventListMap.get(path);
        WebLog.c().b(copyOnWriteArrayList != null);
        if (!copyOnWriteArrayList.contains(str)) {
            return false;
        }
        TaskHandler.postTask(new bh(this, kl.a(str, "event", 0, obj)));
        return true;
    }

    protected boolean broadcastEvent(String str, String str2) {
        Uri a = UrlTools.parse(getCurrentUrl());
        if (a == null || a.getPath() == null) {
            return false;
        }
        TaskHandler.postTask(new bi(this, kl.a(str, "event", 0, (Object) str2)));
        return true;
    }

    protected void web_notifyWeb(String str, int i, Object... objArr) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 0;
        while (i2 < objArr.length) {
            try {
                jSONObject.put((String) objArr[i2], objArr[i2 + 1]);
                i2 += 2;
            } catch (JSONException e) {
            }
        }
        web_notifyWeb(str, i, jSONObject);
    }

    protected void web_notifyWeb(String str, int i, JSONObject jSONObject) {
        String str2 = "callback." + str;
        sParcelMap.put(str2, jSONObject.toString());
        TaskHandler.postTask(new bj(this, kl.a(str, "callback", i, str2)));
    }

    protected boolean checkPageError() {
        return super.checkPageError() || this.mJsPageStatusCode < 0;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).addSystemUiConditioner(this);
        } else {
            reActive();
        }
        addScrollListener();
        updateBarStatus();
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).updateSystemUi(true);
    }

    private void addScrollListener() {
        if (this.mWebView.getOnScrollerListener() == null && this.mHasTitle) {
            setOnScrollListener(new bk(this));
        }
    }

    protected void onDeactive() {
        showSurfingBar();
        super.onDeactive();
    }

    protected boolean onBack() {
        if (this.mErrorView.getVisibility() == 0) {
            return false;
        }
        if (!this.mRequestBack && triggerEventOnCurrentUrl("backPressed", null)) {
            return true;
        }
        this.mRequestBack = false;
        if (!super.onBack()) {
            return false;
        }
        this.mEventListMap.remove(getCurrentUrl());
        return true;
    }

    protected void onActivityConfigurationChanged(Configuration configuration) {
        super.onActivityConfigurationChanged(configuration);
        if (this.mScreenOrientation != configuration.orientation) {
            this.mScreenOrientation = configuration.orientation;
            triggerEventOnCurrentUrl("screenChanged", Integer.valueOf(configuration.orientation));
        }
    }

    protected boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!p.i().k()) {
            if (keyEvent.getKeyCode() == 25) {
                refresh();
                return true;
            } else if (keyEvent.getKeyCode() == 24) {
                new jf(getContext(), "请输入测试网址", getCurrentUrl(), new bm(this)).show();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void reActive() {
        if (TextUtils.isEmpty(mBackParam)) {
            triggerEventOnCurrentUrl("wakeUp", null);
            return;
        }
        triggerEventOnCurrentUrl("wakeUp", mBackParam);
        mBackParam = null;
    }

    private void updateBarStatus() {
        if (isActive()) {
            com.duokan.reader.ui.surfing.af afVar = (com.duokan.reader.ui.surfing.af) getContext().queryFeature(com.duokan.reader.ui.surfing.af.class);
            if (afVar != null && this.mHasBar != null) {
                if (this.mHasBar.booleanValue()) {
                    afVar.m();
                } else if (!this.mHasBar.booleanValue()) {
                    afVar.n();
                }
            }
        }
    }

    private void showSurfingBar() {
        com.duokan.reader.ui.surfing.af afVar = (com.duokan.reader.ui.surfing.af) getContext().queryFeature(com.duokan.reader.ui.surfing.af.class);
        if (this.mHasBar != null && !this.mHasBar.booleanValue() && afVar != null) {
            afVar.m();
        }
    }

    private void scrollPosToTop(int i, int i2, boolean z) {
        int max = Math.max(Math.min(i2 - getHeaderViewOffset(), this.mWebView.getContentHeight() - this.mWebView.getViewportBounds().height()), 0);
        if (z) {
            this.mWebView.a(i, max, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
        } else {
            this.mWebView.scrollTo(i, max);
        }
    }

    private int getHeaderViewOffset() {
        return (this.mHasTitle && this.mImmersive) ? UTools.getMinimumHeight(getContext(), 65.0f) : 0;
    }

    protected void onPageCreated(int i, String str) {
    }

    protected View js_getContentView() {
        return getContentView();
    }

    protected boolean js_isActive() {
        return isActive();
    }

    protected boolean onRequestDetach(ActivatedController activatedControllerVar) {
        if (this.mShareEntranceContext == null || !this.mShareEntranceContext.a(activatedControllerVar) || !containsDirectly(activatedControllerVar)) {
            return false;
        }
        removeSubController(activatedControllerVar);
        deactivate(activatedControllerVar);
        return true;
    }

    protected void webPageError(boolean z) {
        if (!this.mTransparent) {
            this.mErrorView.setVisibility(z ? 0 : 4);
        } else if (z) {
            this.mErrorDialog = js_showDialog(null, getString(com.duokan.c.j.general__shared__network_error), getString(com.duokan.c.j.general__shared__retry), getString(com.duokan.c.j.general__shared__close), new bn(this), new bo(this));
        } else if (this.mErrorDialog != null && this.mErrorDialog.isShowing()) {
            this.mErrorDialog.dismiss();
            this.mErrorDialog = null;
        }
        if (z && !this.mWebView.k()) {
            this.mWebView.setVisibility(4);
        }
    }

    protected void js_showWeb(String str, String str2, boolean z) {
        ActivatedController createWebPage = createWebPage(getContext());
        createWebPage.setLoadingStyle(getLoadingStyle());
        createWebPage.setPageTitle(str);
        createWebPage.loadUrl(str2);
        ReaderFeature readerFeature = (ReaderFeature) getContext().queryFeature(ReaderFeature.class);
        if (createWebPage.getTransparent()) {
            readerFeature.showPopup(createWebPage);
        } else if (z) {
            readerFeature.pushHalfPageSmoothly(createWebPage, null);
        } else {
            readerFeature.pushPageSmoothly(createWebPage, null);
        }
    }

    protected cg newJavascriptImpl() {
        return new cg(this);
    }

    public void setHasTitle(boolean z) {
        this.mHasTitle = z;
        if (this.mPageHeaderView != null) {
            this.mPageHeaderView.setVisibility(z ? 0 : 8);
        }
        setWebViewPadding();
    }

    public void setImmersive(boolean z) {
        int i = 0;
        this.mImmersive = z;
        setWebViewPadding();
        if (this.mPageHeaderView != null) {
            int i2;
            this.mPageHeaderView.setBackgroundColor(z ? 0 : Color.parseColor("#f8f8f8"));
            TextView centerTitleView = this.mPageHeaderView.getCenterTitleView();
            if (z) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            centerTitleView.setVisibility(i2);
            PageHeaderView pageHeaderView = this.mPageHeaderView;
            if (!z) {
                i = Color.parseColor("#cccccc");
            }
            pageHeaderView.setBottomLineColor(i);
        }
    }

    protected String currentUrl() {
        if (TaskHandler.isCurrentThread()) {
            return this.mWebView.getCurrentUrl();
        }
        return (String) TaskHandler.getTaskHandler(new bp(this));
    }

    protected String handleUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(Uri.parse(str).getHost())) {
            return p.i().z() + str;
        }
        return str;
    }

    public void js_button(boolean z, String str) {
        TaskHandler.postTask(new bq(this, z, str));
    }

    public void js_pay(String str, String str2, d dVar, JSONObject jSONObject) {
        TaskHandler.postTask(new bs(this, jSONObject, str2, dVar, str));
    }

    protected int js_getPagePaddingBottom() {
        ITheme sVar = (ITheme) getContext().queryFeature(ITheme.class);
        if (sVar == null) {
            return 0;
        }
        return Math.max(0, ((int) UTools.closeAnimation(getContext(), sVar.getTheme().getPagePaddingBottom())) - 10);
    }

    public void setOnScrollListener(OnScrollListener cgVar) {
        this.mWebView.setOnScrollListener(cgVar);
    }

    private static void setCookie() {
        if (!sCookieSet) {
            CookieManager instance = CookieManager.getInstance();
            if (instance != null) {
                instance.setAcceptCookie(true);
                Map parseCookie = parseCookie(instance.getCookie(".duokan.com"));
                setCookie(instance, parseCookie, "app_id", "" + ReaderEnv.get().getAppId(), false);
                setCookie(instance, parseCookie, "device_id", "" + ReaderEnv.get().getDeviceId(), false);
                setCookie(instance, parseCookie, "build", "" + ReaderEnv.get().getVersionCode(), false);
                setCookie(instance, parseCookie, "channel", "" + ReaderEnv.get().getDistChannel(), false);
                setCookie(instance, parseCookie, "api", "2", false);
                setCookie(instance, parseCookie, "user_type", "" + PersonalPrefs.a().b(), false);
                setCookie(instance, parseCookie, "user_gender", "" + PersonalPrefs.a().g(), false);
                if (!TextUtils.isEmpty(i.f().i())) {
                    setCookie(instance, parseCookie, "device_hash", i.f().i(), false);
                }
                Iterable j = i.f().j();
                if (j != null && j.size() > 0) {
                    setCookie(instance, parseCookie, "device_hash_set", TextUtils.join(",", j), false);
                }
                if (ReaderEnv.get().getBuildName().equals("Reader")) {
                    setCookie(instance, parseCookie, "_n", "1", false);
                }
                if (z.a()) {
                    setCookie(instance, parseCookie, "_m", "1", false);
                }
                sCookieSet = true;
            }
        }
    }

    private static void setCookie(CookieManager cookieManager, Map map, String str, String str2, boolean z) {
        if (!map.containsKey(str) || !TextUtils.equals((CharSequence) map.get(str), str2)) {
            cookieManager.setCookie(".duokan.com", str + "=" + str2 + "; domain=" + ".duokan.com" + (z ? "; secure" : ""));
        }
    }

    private static Map parseCookie(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (String str2 : str.split(";")) {
            int indexOf = str2.indexOf("=");
            String trim = str2.substring(0, indexOf).trim();
            Object trim2 = str2.substring(indexOf + 1, str2.length()).trim();
            if (trim2.startsWith("\"") && trim2.endsWith("\"")) {
                trim2 = trim2.substring(1, trim2.length() - 1);
            }
            hashMap.put(trim, trim2);
        }
        return hashMap;
    }
}
