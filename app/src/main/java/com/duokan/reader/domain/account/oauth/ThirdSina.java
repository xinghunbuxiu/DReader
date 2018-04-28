package com.duokan.reader.domain.account.oauth;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.OnActivityResultListener;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.WebSession.SessionState;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.common.webservices.duokan.p040a.C0626c;
import com.duokan.reader.common.webservices.duokan.p040a.C0627d;
import com.duokan.reader.domain.account.oauth.TokenStore.OnAccessTokenBindListener;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.ja;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

public class ThirdSina extends ThirdOAuth implements OnActivityResultListener, WeiboAuthListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int[] INVALID_TOKEN_ERRORS = new int[]{10006, 21301, 21314, 21315, 21316, 21317, 21319, 21327, 21332};
    private OAuthCallback mCallBack;
    private boolean mIsCancelled = false;
    private boolean mIsShareFinish = false;
    private SsoHandler mSsoHandler;
    private WebSession mUpdateSession;
    private AuthInfo mWeiboAuth;

    /* renamed from: com.duokan.reader.domain.account.oauth.ThirdSina$6 */
    class C07186 implements OnAccessTokenBindListener {
        C07186() {
        }

        public void onOk() {
            if (ThirdSina.this.mCallBack != null) {
                final ja jaVar = new ja(ThirdSina.this.getActivity());
                jaVar.m10843a(ThirdSina.this.getActivity().getString(C0247i.account__shared__exchange_username));
                jaVar.show();
                ThirdSina.this.fetchUserInfo(new FetchUserInfoHandler() {
                    public void onFetchUserInfoFinished(boolean z) {
                        jaVar.dismiss();
                        if (z) {
                            ThirdSina.this.mCallBack.onOauthSuccess();
                        } else {
                            ThirdSina.this.mCallBack.onGetUserNameFailed();
                        }
                    }
                });
            }
        }
    }

    static {
        boolean z;
        if (ThirdSina.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        $assertionsDisabled = z;
    }

    public ThirdSina(Activity activity) {
        super(activity, "weibo");
    }

    public String getSinaAppKey() {
        return ReaderEnv.get().forHd() ? "1851639596" : "2347354897";
    }

    public void oauth(OAuthCallback oAuthCallback) {
        this.mCallBack = oAuthCallback;
        this.mWeiboAuth = new AuthInfo(getActivity(), getSinaAppKey(), "https://api.weibo.com/oauth2/default.html", ThirdConstans.SINA_SCOPE);
        this.mSsoHandler = new SsoHandler(getActivity(), this.mWeiboAuth);
        this.mSsoHandler.authorize(this);
    }

    public void update(String str, Bitmap bitmap, String str2, UpdateHandler updateHandler) {
        update(str, bitmap, str2, true, updateHandler);
    }

    private void update(String str, Bitmap bitmap, String str2, boolean z, UpdateHandler updateHandler) {
        if ($assertionsDisabled || updateHandler != null) {
            String str3;
            this.mIsShareFinish = false;
            if (str.contains("http://www.duokan.com") || str.contains("https://www.duokan.com")) {
                str3 = str;
            } else {
                str3 = str + " https://www.duokan.com";
            }
            final Bitmap bitmap2 = bitmap;
            final String str4 = str2;
            final boolean z2 = z;
            final UpdateHandler updateHandler2 = updateHandler;
            this.mUpdateSession = new WebSession(ThirdSessionConfig.VALUE) {
                private ResponseHandleResult<Boolean> mResult = null;

                /* renamed from: com.duokan.reader.domain.account.oauth.ThirdSina$2$1 */
                class C07141 implements OAuthCallback {
                    C07141() {
                    }

                    public void onOauthSuccess() {
                        ThirdSina.this.update(str3, bitmap2, str4, false, updateHandler2);
                    }

                    public void onOauthFailed(String str) {
                        if (!TextUtils.isEmpty(str)) {
                            be.m10287a(ThirdSina.this.getActivity(), (CharSequence) str, 0).show();
                        }
                        updateHandler2.onUpdateError();
                    }

                    public void onGetUserNameFailed() {
                        updateHandler2.onUpdateError();
                    }
                }

                protected void onSessionTry() {
                    C0627d a;
                    C0237c c0237c = new C0237c(this);
                    if (bitmap2 != null || TextUtils.isEmpty(str4)) {
                        a = c0237c.mo376a(ThirdSina.this.makeUpdateRequest(str3, bitmap2));
                    } else {
                        a = c0237c.mo376a(ThirdSina.this.makeUpdateRequest(str3, c0237c.m545a(str4)));
                    }
                    ThirdSina.this.mIsShareFinish = true;
                    if (a.mo812a() != HttpStatus.SC_OK) {
                        this.mResult = new ResponseHandleResult(Boolean.valueOf(false), true);
                    } else {
                        this.mResult = ThirdSina.this.handleUpdateResponse(c0237c.m550b(a, HTTP.UTF_8));
                    }
                }

                protected void onSessionSucceeded() {
                    if (ThirdSina.this.mIsCancelled) {
                        onSessionCancelled();
                    }
                    if (this.mResult == null) {
                        updateHandler2.onUpdateError();
                    } else if (this.mResult.mNeedReauth) {
                        if (z2) {
                            ThirdSina.this.oauth(new C07141());
                        } else {
                            updateHandler2.onUpdateError();
                        }
                    } else if (((Boolean) this.mResult.mValue).booleanValue()) {
                        updateHandler2.onUpdateOk();
                    } else {
                        updateHandler2.onUpdateError();
                    }
                }

                protected void onSessionFailed() {
                    if (ThirdSina.this.mIsCancelled) {
                        onSessionCancelled();
                    }
                    updateHandler2.onUpdateError();
                }

                protected void onSessionCancelled() {
                    ThirdSina.this.mIsCancelled = false;
                    updateHandler2.onUpdateCancel();
                }
            };
            this.mUpdateSession.open();
            return;
        }
        throw new AssertionError();
    }

    public boolean isShareFinish() {
        return this.mIsShareFinish;
    }

    public void updateShareCancel() {
        if (this.mUpdateSession != null && !this.mUpdateSession.getIsClosed() && !this.mIsShareFinish && this.mUpdateSession.getSessionState() == SessionState.UNFINISHED) {
            this.mIsCancelled = true;
            this.mUpdateSession.close();
        }
    }

    public void fetchUserInfo(final FetchUserInfoHandler fetchUserInfoHandler) {
        if ($assertionsDisabled || fetchUserInfoHandler != null) {
            new WebSession(ThirdSessionConfig.VALUE) {
                private boolean mResult;

                protected void onSessionTry() {
                    C0237c c0237c = new C0237c(this);
                    this.mResult = ThirdSina.this.handleUserInfoResponse(c0237c.m550b(c0237c.mo376a(ThirdSina.this.makeFetchUserInfoRequest()), HTTP.UTF_8));
                }

                protected void onSessionSucceeded() {
                }

                protected void onSessionFailed() {
                    this.mResult = false;
                }

                protected void onSessionClosed() {
                    fetchUserInfoHandler.onFetchUserInfoFinished(this.mResult);
                    super.onSessionClosed();
                }
            }.open();
            return;
        }
        throw new AssertionError();
    }

    public void onCancel() {
        if (this.mCallBack != null) {
            this.mCallBack.onOauthFailed("");
        }
    }

    public void onComplete(Bundle bundle) {
        Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(bundle);
        if (parseAccessToken.isSessionValid()) {
            this.mTokenStore.bindAccessToken(getActivity(), this.mThirdName, parseAccessToken.getUid(), parseAccessToken.getToken(), "", String.valueOf(parseAccessToken.getExpiresTime()), "", new C07186());
        } else if (this.mCallBack != null) {
            this.mCallBack.onOauthFailed("");
        }
    }

    public void onWeiboException(WeiboException weiboException) {
        if (this.mCallBack != null) {
            this.mCallBack.onOauthFailed("");
        }
    }

    public void onActive() {
        ((BaseActivity) getActivity()).addOnActivityResultListener(this);
    }

    public void onDeactive() {
        ((BaseActivity) getActivity()).removeOnActivityResultListener(this);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mSsoHandler != null) {
            this.mSsoHandler.authorizeCallBack(i, i2, intent);
        }
    }

    protected C0624a makeFetchUserInfoRequest() {
        return new C0626c().m2853a(HttpGet.METHOD_NAME).m2856b(makeGetUrl("https://api.weibo.com/2/users/show.json", "access_token", this.mTokenStore.getAccessToken(DkApp.get().getTopActivity(), this.mThirdName), "uid", this.mTokenStore.getUserId(DkApp.get().getTopActivity(), this.mThirdName))).m2851a();
    }

    protected boolean handleUserInfoResponse(String str) {
        try {
            this.mTokenStore.setUserName(DkApp.get().getTopActivity(), this.mThirdName, new JSONObject(str).getString("screen_name"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected C0624a makeUpdateRequest(String str, Bitmap bitmap) {
        if (bitmap != null) {
            return makePostRequest("https://api.weibo.com/2/statuses/share.json", "pic", bitmap, "access_token", this.mTokenStore.getAccessToken(DkApp.get().getTopActivity(), this.mThirdName), "status", str);
        }
        return makePostRequest("https://api.weibo.com/2/statuses/share.json", "access_token", this.mTokenStore.getAccessToken(DkApp.get().getTopActivity(), this.mThirdName), "status", str);
    }

    protected ResponseHandleResult<Boolean> handleUpdateResponse(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("error_code")) {
                jSONObject.getString("created_at");
                return new ResponseHandleResult(Boolean.valueOf(true), false);
            } else if (isTokenInvalid(jSONObject.getInt("error_code"))) {
                return new ResponseHandleResult(Boolean.valueOf(false), true);
            } else {
                return new ResponseHandleResult(Boolean.valueOf(false), false);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return new ResponseHandleResult(Boolean.valueOf(false), false);
        }
    }

    private static boolean isTokenInvalid(int i) {
        for (int i2 : INVALID_TOKEN_ERRORS) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }
}
