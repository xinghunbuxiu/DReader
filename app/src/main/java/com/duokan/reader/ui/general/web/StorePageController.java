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
import com.duokan.common.C0267i;
import com.duokan.core.app.ApplicationsStateCallbacks;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.AppManage;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.p027b.C0324a;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.C0373z;
import com.duokan.core.sys.af;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.C0342j;
import com.duokan.core.ui.PullDownRefreshView.RefreshStyle;
import com.duokan.core.ui.Scrollable.OverScrollMode;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.SystemUiMode;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.common.webservices.duokan.DkSignInReward;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.ad.C0744a;
import com.duokan.reader.domain.ad.C0761r;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.payment.C1090d;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.C1176a;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreFiction;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.account.ak;
import com.duokan.reader.ui.general.LoadingCircleView;
import com.duokan.reader.ui.general.LoadingCircleView.LoadingStyle;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.cg;
import com.duokan.reader.ui.general.cj;
import com.duokan.reader.ui.general.hp;
import com.duokan.reader.ui.general.ip;
import com.duokan.reader.ui.general.ja;
import com.duokan.reader.ui.p049a.C1214a;
import com.duokan.reader.ui.store.C1502o;
import com.duokan.reader.ui.store.ao;
import com.duokan.reader.ui.store.ap;
import com.duokan.reader.ui.store.comment.C1482f;
import com.duokan.reader.ui.surfing.al;
import com.iflytek.speech.VoiceWakeuperAidl;
import com.mipay.sdk.Mipay;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StorePageController extends StoreWebController implements SystemUiConditioner {
    public static final int LATEST_VERSION_CODE = 2;
    public static final String PAY_CONTINUE = "PAY_CONTINUE";
    public static final int SERIAL_CHAPTER_STATE_DOWNLOADED = 2;
    public static final int SERIAL_CHAPTER_STATE_PURCHASED = 1;
    protected static final int VERSION_CODE_2 = 2;
    private static String mBackParam = null;
    private static C0586j sAccountListener = null;
    private static boolean sCookieSet = false;
    private static StorePageController sPreloadedController = null;
    private static ApplicationsStateCallbacks sRunningStateListener = null;
    private C0744a mAdLifecycleManager;
    private C0761r mAdSdkService;
    private cf mBannerInfo;
    protected DkStoreBookDetail mBookCache;
    protected final ao mDetailFeature;
    private C1482f mEditCommentDialog;
    private C1214a mEditFeedController;
    protected C0342j mErrorDialog;
    protected final View mErrorView;
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<String>> mEventListMap;
    protected DkStoreFictionDetail mFictionCache;
    protected boolean mFullscreen;
    private Boolean mHasBar;
    private boolean mHasTabsTitleChange;
    private boolean mHasTitle;
    private final HashMap<String, lo> mHeaderViewRightButtonConditionMap;
    private boolean mImmersive;
    private BoxView mInputBoxView;
    private JSONObject mInputFlag;
    private boolean mJsPageLoading;
    private int mJsPageStatusCode;
    protected final HashMap<String, LinkedList<ap>> mListeners;
    private String mOriginUrl;
    private PageHeaderView mPageHeaderView;
    protected final ja mPageLoadingDlg;
    protected final View mPageLoadingView;
    private String mPageTitle;
    private boolean mPageTitleLeft;
    private ja mProgressDialog;
    private boolean mRequestBack;
    private int mScreenOrientation;
    private boolean mScrollSmoothly;
    private ActivatedController mShareController;
    protected ak mShareEntranceContext;
    private int mSurfingBarOffset;
    private final LinkedHashMap<String, Integer> mTabsTitle;
    protected boolean mTransparent;
    private Runnable mUpdateMirrorRunnable;
    protected final View mWebRootView;

    enum TabState {
        DEFAULT,
        OVER_SURFING_BAR_HEAD,
        OVER_HALF_SURFING_BAR,
        OVER_SURFING_BAR
    }

    public /* bridge */ /* synthetic */ void refresh() {
        super.refresh();
    }

    public /* bridge */ /* synthetic */ void updateStoreMirror(boolean z) {
        super.updateStoreMirror(z);
    }

    public static StorePageController createWebPage(IFeature mFeature) {
        StorePageController storePageController;
        WebLog.init().w();
        StorePageController storePageController2 = sPreloadedController;
        if (storePageController2 == null || storePageController2.getActivity() != AppManage.getCurrentActivity((Context) mFeature)) {
            storePageController = new StorePageController(mFeature);
            storePageController.loadUrl(C0641o.m2934i().m2952a());
        } else {
            storePageController = storePageController2;
        }
        sPreloadedController = null;
        return storePageController;
    }

    public StorePageController(IFeature mFeature) {
        super(mFeature);
        this.mEventListMap = new ConcurrentHashMap();
        this.mTabsTitle = new LinkedHashMap();
        this.mScreenOrientation = 0;
        this.mJsPageLoading = false;
        this.mJsPageStatusCode = 0;
        this.mListeners = new HashMap();
        this.mRequestBack = false;
        this.mDetailFeature = new as(this);
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
        this.mAdLifecycleManager = new C0744a();
        this.mAdSdkService = null;
        this.mEditCommentDialog = null;
        this.mUpdateMirrorRunnable = null;
        this.mScreenOrientation = getContext().getResources().getConfiguration().orientation;
        this.mWebRootView = findViewById(C0255g.general__web_core_view__root);
        setWebViewPadding();
        setCookie();
        this.mPageLoadingView = findViewById(C0255g.general__web_core_view__first_load);
        this.mPageLoadingDlg = initWaitingDialog();
        this.mErrorView = findViewById(C0255g.general__web_core_view__error);
        ((TextView) this.mErrorView.findViewById(C0255g.general__emtpy_view__line_1)).setText(C0258j.general__shared__web_error);
        TextView textView = (TextView) this.mErrorView.findViewById(C0255g.general__emtpy_view__line_3);
        textView.setText(C0258j.general__shared__web_refresh);
        textView.setVisibility(0);
        textView.setOnClickListener(new bh(this));
        getContext().addFeatureListener(this.mDetailFeature);
        this.mHeaderViewRightButtonConditionMap = new HashMap();
        js_addHeaderViewRightButtonCondition("PUBLISH_FEED", new lo(this, C0254f.store__header_view_button__edit, null));
        js_addHeaderViewRightButtonCondition("CART_ADD", new lo(this, C0254f.store__header_view_button__cart_add, null));
        js_addHeaderViewRightButtonCondition("CART_REMOVE", new lo(this, C0254f.store__header_view_button__cart_remove, null));
        js_addHeaderViewRightButtonCondition("SEARCH", new lo(this, C0254f.surfing__surfing_tab_view__search_dark, new bv(this)));
        this.mPageHeaderView = (PageHeaderView) findViewById(C0255g.general__web_view__header);
        this.mInputBoxView = (BoxView) findViewById(C0255g.general__web_view__input_box);
        if (this.mPageHeaderView != null) {
            this.mPageHeaderView.setClickable(true);
        }
        this.mUpdateMirrorRunnable = new kr(this);
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

    public void onAdWallStatusChange(String str) {
    }

    public void onSearchBarPosChange(int i) {
    }

    public void onSearchWordChange(String str) {
    }

    protected ja initWaitingDialog() {
        return new ja(getContext());
    }

    public void chooseStatusBarStyle(af<Boolean> afVar) {
        if (isActive()) {
            afVar.mo975a(Boolean.valueOf(this.mPageHeaderView != null ? this.mPageHeaderView.getDarkTitle() : true));
        }
    }

    public void chooseNavigationBarMode(af<SystemUiMode> afVar) {
    }

    public void chooseNavigationBarColor(af<Integer> afVar) {
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
        WebLog.init().w();
        if (sPreloadedController != null) {
            sPreloadedController.mWebView.mo1821f();
            sPreloadedController = null;
        }
        triggerEventOnCurrentUrl("mirrorUpdated", null);
    }

    protected final void js_addHeaderViewRightButtonCondition(String str, lo loVar) {
        this.mHeaderViewRightButtonConditionMap.put(str, loVar);
    }

    protected void webPageLoading(boolean z) {
        if (z || !this.mJsPageLoading) {
            Object obj = webPageLoading() != z ? 1 : null;
            super.webPageLoading(z);
            if (obj == null) {
                return;
            }
            if (this.mTransparent) {
                this.mPageLoadingView.setVisibility(4);
                this.mPageLoadingView.clearAnimation();
                if (z) {
                    this.mPageLoadingDlg.open(new bw(this));
                    return;
                } else {
                    this.mPageLoadingDlg.dismiss();
                    return;
                }
            }
            Runnable bxVar = new bx(this);
            if (z) {
                UThread.postDelayed(bxVar, 300);
            } else {
                UThread.runOnThread(bxVar);
            }
            if (!webPageLoading()) {
                UThread.postDelayed(this.mUpdateMirrorRunnable, 3000);
                if (sPreloadedController == null) {
                    if (sRunningStateListener == null) {
                        sRunningStateListener = new ch();
                        ManagedApp.get().addOnRunningStateChangedListener(sRunningStateListener);
                    }
                    if (sAccountListener == null) {
                        sAccountListener = new cg();
                        C0709k.m3476a().m3494a(sAccountListener);
                    }
                    UThread.addIdleHandlerListener(new ca(this));
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
                this.mOriginUrl = C0641o.m2934i().m2999z() + str;
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
        this.mWebView.mo1815a(this.mOriginUrl);
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
        this.mWebView.mo434a(0, 0, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
    }

    public boolean transparent() {
        return this.mTransparent;
    }

    private void updateFeedReplyInputCache(cg cgVar, String str) {
        if (TextUtils.isEmpty(str)) {
            cgVar.m10363a();
            return;
        }
        cj cjVar = new cj();
        cjVar.f7033a = str;
        cgVar.m10364a(cjVar);
    }

    private void setWebViewPadding() {
        int pageHeaderHeight = ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getPageHeaderHeight();
        if (this.mHasTitle && this.mImmersive) {
            pageHeaderHeight = 0;
        } else if (!this.mHasTitle) {
            pageHeaderHeight = 0;
        }
        this.mWebRootView.setPadding(0, pageHeaderHeight, 0, 0);
    }

    protected DkSignInInfo jsonToDkSignInInfo(String str, int i) {
        int i2 = 7;
        int i3 = 0;
        boolean z = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject == null) {
                return null;
            }
            int i4;
            DkSignInInfo dkSignInInfo = new DkSignInInfo();
            JSONArray optJSONArray = jSONObject.optJSONArray("status");
            boolean[] zArr = new boolean[optJSONArray.length()];
            for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                zArr[i4] = optJSONArray.getString(i4).equals("1");
            }
            dkSignInInfo.mSignStatus = zArr;
            i4 = jSONObject.optInt("today");
            if (i4 < 1) {
                i4 = 1;
            }
            if (i4 <= 7) {
                i2 = i4;
            }
            dkSignInInfo.mToday = i2;
            if (jSONObject.optInt("lottery") != 1) {
                z = false;
            }
            dkSignInInfo.mLottery = z;
            JSONArray optJSONArray2 = jSONObject.optJSONArray("gift");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                return dkSignInInfo;
            }
            while (i3 < optJSONArray2.length()) {
                JSONObject jSONObject2 = optJSONArray2.getJSONObject(i3);
                DkSignInReward dkSignInReward = new DkSignInReward();
                dkSignInReward.mName = jSONObject2.optString("name");
                dkSignInReward.mValue = jSONObject2.optString("value");
                dkSignInReward.mType = i;
                dkSignInInfo.mReward.add(dkSignInReward);
                i3++;
            }
            return dkSignInInfo;
        } catch (Throwable th) {
            return null;
        }
    }

    @Deprecated
    protected void queryFictionDetail(String str, C0466h c0466h, boolean z) {
        if (this.mFictionCache == null || !TextUtils.equals(this.mFictionCache.getFiction().getBookUuid(), str)) {
            ja a;
            if (z) {
                a = ja.m10831a(getContext(), "", getContext().getString(C0258j.bookcity_store__shared__creating_order), true);
            } else {
                a = null;
            }
            C1502o.m15410a().m15433a(str, false, false, -1, -1, -1, new cb(this, a, c0466h));
            return;
        }
        c0466h.onFetchBookDetailOk(this.mFictionCache);
    }

    protected void showFictionToc(String str, boolean z) {
        UThread.runOnThread(new cc(this, str, z));
    }

    private JSONObject jsonSerialDetail(DkStoreFictionDetail dkStoreFictionDetail) {
        try {
            boolean z;
            int i;
            DkStoreFiction fiction = dkStoreFictionDetail.getFiction();
            String bookUuid = fiction.getBookUuid();
            ee eeVar = (ee) ai.m3980a().m3906b(bookUuid);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bookUuid", bookUuid);
            jSONObject.put("price", fiction.getPrice());
            int specialPrice = (int) (fiction.getSpecialPrice() * 100.0f);
            if (specialPrice > 0) {
                jSONObject.put("special", specialPrice);
            }
            DkCloudPurchasedFiction b = DkUserPurchasedFictionsManager.m5072a().m5101b(bookUuid);
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
                if (eeVar != null) {
                    specialPrice = (short) ((eeVar.mo1041v(cloudId) ? 2 : 0) | i);
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

    protected void downloadChapter(fp fpVar, String str, DkStoreBookDetail dkStoreBookDetail) {
        if (!C0559f.m2476b().m2486e()) {
            be.m10287a(getContext(), getContext().getString(C0258j.general__shared__network_error), 1).show();
            web_notifyWeb(str, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, r0);
        } else if (C0559f.m2476b().m2485d()) {
            fpVar.m4201a(true, new af(Boolean.valueOf(false)));
            web_notifyWeb(str, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
        } else if (dkStoreBookDetail.getHighSize() == 0 && dkStoreBookDetail.getLowSize() == 0) {
            fpVar.m4201a(false, new af(Boolean.valueOf(false)));
            web_notifyWeb(str, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
        } else if (((double) dkStoreBookDetail.getHighSize()) * 0.8d <= ((double) dkStoreBookDetail.getLowSize()) || dkStoreBookDetail.getLowSize() <= 0) {
            com.duokan.reader.ui.general.ap apVar = new com.duokan.reader.ui.general.ap(getContext());
            apVar.setPrompt(String.format(getContext().getResources().getString(C0258j.reading__shared__download_prompt), new Object[]{C0267i.m599a(dkStoreBookDetail.getHighSize())}));
            apVar.setCancelLabel(C0258j.general__shared__cancel);
            apVar.setOkLabelResid(C0258j.general__shared__ok);
            apVar.open(new au(this, fpVar, str));
        } else {
            hp hpVar = new hp(getContext());
            hpVar.m9768a(getContext().getResources().getString(C0258j.reading__shared__download_prompt1));
            hpVar.m9770b(String.format(getContext().getResources().getString(C0258j.reading__shared__low_quality), new Object[]{C0267i.m599a(dkStoreBookDetail.getLowSize())}));
            hpVar.m9770b(String.format(getContext().getResources().getString(C0258j.reading__shared__high_quality), new Object[]{C0267i.m599a(dkStoreBookDetail.getHighSize())}));
            hpVar.m9767a(new ce(this, fpVar, str));
            hpVar.open(new at(this, str));
        }
    }

    private void downloadLinearBook(String str, String str2, String str3, DkStoreBookDetail dkStoreBookDetail, String str4) {
        fp fpVar = (fp) ai.m3980a().m3906b(str3);
        if (fpVar == null) {
            C0800c a = ai.m3980a().m3869a(dkStoreBookDetail);
            a.m4235j(str4);
            ((fp) a).m4405a(new aw(this, ja.m10831a(getContext(), "", getContext().getString(C0258j.bookcity_store__shared__creating_order), true), str, dkStoreBookDetail));
        } else if (TextUtils.equals(str2, "NORMAL")) {
            downloadChapter(fpVar, str, dkStoreBookDetail);
        } else if (TextUtils.equals(str2, "UPDATING")) {
            DkCloudStorage.m4994a().m5014a(fpVar.m4156I(), new av(this, fpVar, str));
        }
    }

    protected void queryBookDetail(String str, boolean z, C0466h c0466h, boolean z2) {
        ja a;
        DkStoreItem dkStoreItem = this.mBookCache;
        if (dkStoreItem != null && TextUtils.equals(this.mBookCache.getBook().getBookUuid(), str)) {
            if (!z) {
                c0466h.onFetchBookDetailOk(dkStoreItem);
                return;
            } else if (dkStoreItem.getToc().length > 0) {
                c0466h.onFetchBookDetailOk(dkStoreItem);
                return;
            }
        }
        if (z2) {
            a = ja.m10831a(getContext(), "", getContext().getString(C0258j.bookcity_store__shared__creating_order), true);
        } else {
            a = null;
        }
        C1176a.m8695a().m8703a(str, z, new ay(this, a, c0466h));
    }

    protected void queryBookDetail(String str, C0466h c0466h, boolean z) {
        queryBookDetail(str, false, c0466h, z);
    }

    protected void giving(String str) {
        UThread.runOnThread(new az(this, str));
    }

    private void showBookToc(String str) {
        UThread.runOnThread(new bc(this, str));
    }

    protected void showBookChangeLog(String str) {
        UThread.runOnThread(new be(this, str));
    }

    protected void registerEventOnCurrentUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri a = C0324a.m734a(getCurrentUrl());
            if (a != null && a.getPath() != null) {
                String path = a.getPath();
                if (!this.mEventListMap.containsKey(path)) {
                    this.mEventListMap.putIfAbsent(path, new CopyOnWriteArrayList());
                }
                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.mEventListMap.get(path);
                WebLog.init().w(copyOnWriteArrayList != null);
                copyOnWriteArrayList.add(str);
            }
        }
    }

    protected void unregisterEventOnCurrentUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri a = C0324a.m734a(getCurrentUrl());
            if (a != null && a.getPath() != null) {
                String path = a.getPath();
                if (this.mEventListMap.containsKey(path)) {
                    CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.mEventListMap.get(path);
                    WebLog.init().w(copyOnWriteArrayList != null);
                    copyOnWriteArrayList.remove(str);
                    if (TextUtils.equals(str, "adAppInstallStatus")) {
                        this.mAdLifecycleManager.m3539g(path);
                    }
                }
            }
        }
    }

    protected boolean triggerEventOnCurrentUrl(String str, Object obj) {
        Uri a = C0324a.m734a(getCurrentUrl());
        if (a == null || a.getPath() == null) {
            return false;
        }
        String path = a.getPath();
        if (!this.mEventListMap.containsKey(path)) {
            return false;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.mEventListMap.get(path);
        WebLog.init().w(copyOnWriteArrayList != null);
        if (!copyOnWriteArrayList.contains(str)) {
            return false;
        }
        UThread.runOnThread(new bf(this, lq.m11291a(str, "event", 0, obj)));
        return true;
    }

    protected boolean broadcastEvent(String str, String str2) {
        Uri a = C0324a.m734a(getCurrentUrl());
        if (a == null || a.getPath() == null) {
            return false;
        }
        UThread.runOnThread(new bg(this, lq.m11291a(str, "event", 0, (Object) str2)));
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
        UThread.runOnThread(new bi(this, lq.m11293a(str, "callback", i, str2)));
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
            setOnScrollListener(new bj(this));
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
        if (!C0641o.m2934i().m2984k()) {
            if (keyEvent.getKeyCode() == 25) {
                refresh();
                return true;
            } else if (keyEvent.getKeyCode() == 24) {
                new ip(getContext(), "请输入测试网址", getCurrentUrl(), new bl(this)).show();
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
            al alVar = (al) getContext().queryFeature(al.class);
            if (alVar != null && this.mHasBar != null) {
                if (this.mHasBar.booleanValue()) {
                    alVar.mo2557m();
                } else if (!this.mHasBar.booleanValue()) {
                    alVar.mo2558n();
                }
            }
        }
    }

    private void showSurfingBar() {
        al alVar = (al) getContext().queryFeature(al.class);
        if (this.mHasBar != null && !this.mHasBar.booleanValue() && alVar != null) {
            alVar.mo2557m();
        }
    }

    private void scrollPosToTop(int i, int i2, boolean z) {
        int max = Math.max(Math.min(i2 - getHeaderViewOffset(), this.mWebView.getContentHeight() - this.mWebView.getViewportBounds().height()), 0);
        if (z) {
            this.mWebView.mo434a(i, max, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
        } else {
            this.mWebView.scrollTo(i, max);
        }
    }

    private int getHeaderViewOffset() {
        return (this.mHasTitle && this.mImmersive) ? ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getPageHeaderHeight() : 0;
    }

    protected void onPageCreated(int i, String str) {
    }

    protected View js_getContentView() {
        return getContentView();
    }

    protected boolean js_isActive() {
        return isActive();
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        if (this.mShareEntranceContext == null || !this.mShareEntranceContext.m8873a(c0303e) || !containsDirectly(c0303e)) {
            return false;
        }
        removeSubController(c0303e);
        deactivate(c0303e);
        return true;
    }

    protected void webPageError(boolean z) {
        if (!this.mTransparent) {
            this.mErrorView.setVisibility(z ? 0 : 4);
        } else if (z) {
            this.mErrorDialog = js_showDialog(null, getString(C0258j.general__shared__network_error), getString(C0258j.general__shared__retry), getString(C0258j.general__shared__close), new bm(this), new bn(this));
        } else if (this.mErrorDialog != null && this.mErrorDialog.isShowing()) {
            this.mErrorDialog.dismiss();
            this.mErrorDialog = null;
        }
        if (z && !this.mWebView.mo1822k()) {
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

    protected ci newJavascriptImpl() {
        return new ci(this);
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
        if (UThread.isCurrentThread()) {
            return this.mWebView.getCurrentUrl();
        }
        return (String) UThread.m1035a(new bo(this));
    }

    protected String handleUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(Uri.parse(str).getHost())) {
            return C0641o.m2934i().m2999z() + str;
        }
        return str;
    }

    public void js_button(boolean z, String str) {
        UThread.runOnThread(new bp(this, z, str));
    }

    public void js_pay(String str, String str2, C1090d c1090d, JSONObject jSONObject) {
        UThread.runOnThread(new br(this, jSONObject, str2, c1090d, str));
    }

    protected int js_getPagePaddingBottom() {
        C0435s c0435s = (C0435s) getContext().queryFeature(C0435s.class);
        if (c0435s == null) {
            return 0;
        }
        return Math.max(0, ((int) AnimUtils.m1929b(getContext(), c0435s.getTheme().getPagePaddingBottom())) - 10);
    }

    public void setOnScrollListener(com.duokan.core.ui.cg cgVar) {
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
                setCookie(instance, parseCookie, "user_type", "" + PersonalPrefs.m5175a().m5210b(), false);
                setCookie(instance, parseCookie, "user_gender", "" + PersonalPrefs.m5175a().m5229g(), false);
                if (!TextUtils.isEmpty(C0709k.m3476a().m3514i())) {
                    setCookie(instance, parseCookie, "device_hash", C0709k.m3476a().m3514i(), false);
                }
                Iterable j = C0709k.m3476a().m3515j();
                if (j != null && j.size() > 0) {
                    setCookie(instance, parseCookie, "device_hash_set", TextUtils.join(",", j), false);
                }
                if (ReaderEnv.get().getBuildName().equals("Reader")) {
                    setCookie(instance, parseCookie, "_n", "1", false);
                }
                if (C0373z.m1052a()) {
                    setCookie(instance, parseCookie, "_m", "1", false);
                }
                sCookieSet = true;
            }
        }
    }

    private static void setCookie(CookieManager cookieManager, Map<String, String> map, String str, String str2, boolean z) {
        if (!map.containsKey(str) || !TextUtils.equals((CharSequence) map.get(str), str2)) {
            cookieManager.setCookie(".duokan.com", str + "=" + str2 + "; domain=" + ".duokan.com" + (z ? "; secure" : ""));
        }
    }

    private static Map<String, String> parseCookie(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (String str2 : str.split(VoiceWakeuperAidl.PARAMS_SEPARATE)) {
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

    private void clearUpdateMirrorRunnable() {
        this.mUpdateMirrorRunnable = null;
    }
}
