package com.duokan.reader.domain.account.oauth.evernote;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.b.b;
import com.duokan.b.g;
import com.duokan.common.i;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.f;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.OAuthCallback;
import com.duokan.reader.domain.account.oauth.TokenStore;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.af;
import com.duokan.reader.ui.general.dj;
import com.duokan.reader.ui.general.jq;

public class EvernoteOAuthDialog extends af {
    private static final int FAILED = 2;
    private static final int INFO_FAILED = 3;
    private static final int SUCCESS = 1;
    private OAuthCallback mCallback = null;
    private String mConsumerKey = null;
    private String mConsumerSecret = null;
    private ActivatedController mCurController;
    private Animation mDisAnimation;
    private EvernoteOAuthController mEvernoteController = null;
    private jq mProgressDialog = null;
    private FrameLayout mRootView = null;
    private Animation mShowAnimation;
    private EvernoteOAuthController mYinxiangController = null;

    public class EvernoteOAuthController extends ActivatedController {
        static final /* synthetic */ boolean $assertionsDisabled = (!EvernoteOAuthDialog.class.desiredAssertionStatus() ? true : $assertionsDisabled);
        static final String EXTRA_CONSUMER_KEY = "CONSUMER_KEY";
        static final String EXTRA_CONSUMER_SECRET = "CONSUMER_SECRET";
        static final String EXTRA_EVERNOTE_HOST = "EVERNOTE_HOST";
        static final String EXTRA_REQUEST_TOKEN = "REQUEST_TOKEN";
        static final String EXTRA_REQUEST_TOKEN_SECRET = "REQUEST_TOKEN_SECRET";
        private final String TAG = EvernoteOAuthController.class.getName();
        private AsyncTask mBeginAuthSyncTask = null;
        private AsyncTask mCompleteAuthSyncTask = null;
        private f mDialog;
        private String mEvernoteHost = null;
        private String mEvernoteName = null;
        private HeaderView mHeaderView;
        private final Evernote mListener;
        private String mRequestToken = null;
        private String mRequestTokenSecret = null;
        private AsyncTask mUserInfoAsyncTask = null;
        private WebView mWebView;
        private WebViewClient mWebViewClient = new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (!Uri.parse(str).getScheme().equals(EvernoteOAuthController.this.mListener.getCallbackScheme())) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                if (EvernoteOAuthController.this.mCompleteAuthSyncTask != null) {
                    return true;
                }
                EvernoteOAuthController.this.mCompleteAuthSyncTask = new CompleteAuthAsyncTask().execute(new Uri[]{r1});
                return true;
            }
        };

        class BeginAuthAsyncTask extends AsyncTask {
            private BeginAuthAsyncTask() {
            }

            protected void onPreExecute() {
                EvernoteOAuthDialog.this.mProgressDialog.show();
            }

            protected String doInBackground(Void... voidArr) {
                String[] beginAuth = EvernoteOAuthController.this.mListener.beginAuth(EvernoteOAuthController.this.mEvernoteHost, EvernoteOAuthDialog.this.mConsumerKey, EvernoteOAuthDialog.this.mConsumerSecret);
                EvernoteOAuthController.this.mRequestToken = beginAuth[1];
                EvernoteOAuthController.this.mRequestTokenSecret = beginAuth[2];
                return beginAuth[0];
            }

            protected void onPostExecute(String str) {
                EvernoteOAuthDialog.this.mProgressDialog.dismiss();
                if (TextUtils.isEmpty(str)) {
                    EvernoteOAuthDialog.this.exit(EvernoteOAuthController.this, 2);
                } else {
                    EvernoteOAuthController.this.mWebView.loadUrl(str);
                }
            }
        }

        class CompleteAuthAsyncTask extends AsyncTask {
            private CompleteAuthAsyncTask() {
            }

            protected void onPreExecute() {
                EvernoteOAuthDialog.this.mProgressDialog.show();
            }

            protected Object doInBackground(Uri... uriArr) {
                return EvernoteOAuthController.this.mListener.completeAuth(EvernoteOAuthController.this.mEvernoteHost, EvernoteOAuthDialog.this.mConsumerKey, EvernoteOAuthDialog.this.mConsumerSecret, uriArr[0], EvernoteOAuthController.this.mRequestToken, EvernoteOAuthController.this.mRequestTokenSecret);
            }

            protected void onPostExecute(Object obj) {
                EvernoteOAuthDialog.this.mProgressDialog.dismiss();
                if (EvernoteOAuthController.this.mListener.persistAuthenticationToken(EvernoteOAuthController.this.getContext(), EvernoteOAuthController.this.mEvernoteName, obj)) {
                    EvernoteOAuthController.this.mUserInfoAsyncTask = new UserInfoAsyncTask();
                    EvernoteOAuthController.this.mUserInfoAsyncTask.execute(new Object[0]);
                    return;
                }
                EvernoteOAuthDialog.this.exit(EvernoteOAuthController.this, 2);
            }
        }

        class UserInfoAsyncTask extends AsyncTask {
            private UserInfoAsyncTask() {
            }

            protected EvernoteUser doInBackground(Object... objArr) {
                return EvernoteOAuthController.this.mListener.getUser(EvernoteOAuthController.this.mEvernoteHost);
            }

            protected void onPostExecute(EvernoteUser evernoteUser) {
                if (evernoteUser != null) {
                    TokenStore.getInstance().setUserName(EvernoteOAuthController.this.getContext(), EvernoteOAuthController.this.mEvernoteName, TextUtils.isEmpty(evernoteUser.mName) ? evernoteUser.mUserName : evernoteUser.mName);
                    EvernoteOAuthDialog.this.exit(EvernoteOAuthController.this, 1);
                    return;
                }
                EvernoteOAuthDialog.this.exit(EvernoteOAuthController.this, 3);
            }
        }

        public EvernoteOAuthController(IFeature featrue, Evernote evernote, f fVar, String str) {
            super(featrue);
            this.mEvernoteName = str;
            this.mListener = evernote;
            this.mEvernoteHost = getBaseServerUrl();
            this.mDialog = fVar;
            setContentView(g.account__oauth_web_view);
            this.mHeaderView = (HeaderView) findViewById(com.duokan.b.f.account__oauth_web_view__title);
            this.mHeaderView.setOnBackListener(new dj(EvernoteOAuthDialog.this) {
                public boolean onBack() {
                    EvernoteOAuthController.this.stop();
                    EvernoteOAuthDialog.this.mCallback.onOauthFailed("");
                    EvernoteOAuthController.this.mDialog.dismiss();
                    return true;
                }
            });
            initHeaderView();
            this.mWebView = (WebView) findViewById(com.duokan.b.f.account__oauth_web_view__web);
            this.mWebView.setWebViewClient(this.mWebViewClient);
            this.mWebView.getSettings().setJavaScriptEnabled(true);
            i.a(this.mWebView);
            af.initWebViewCenterDialog((af) fVar, this.mWebView);
            if (TextUtils.isEmpty(EvernoteOAuthDialog.this.mConsumerKey) || TextUtils.isEmpty(EvernoteOAuthDialog.this.mConsumerSecret)) {
                this.mDialog.cancel();
            }
        }

        public void start() {
            this.mBeginAuthSyncTask = new BeginAuthAsyncTask().execute(new Void[0]);
        }

        public void stop() {
            this.mWebView.stopLoading();
            this.mWebView.clearView();
            this.mWebView.invalidate();
            if (this.mBeginAuthSyncTask != null) {
                this.mBeginAuthSyncTask.cancel(true);
            }
            if (this.mCompleteAuthSyncTask != null) {
                this.mCompleteAuthSyncTask.cancel(true);
            }
            if (this.mUserInfoAsyncTask != null) {
                this.mUserInfoAsyncTask.cancel(true);
            }
        }

        private String getBaseServerUrl() {
            if (TextUtils.equals("yinxiang", this.mEvernoteName)) {
                return "app.yinxiang.com";
            }
            if (TextUtils.equals("evernote", this.mEvernoteName)) {
                return "www.evernote.com";
            }
            if ($assertionsDisabled) {
                return null;
            }
            throw new AssertionError();
        }

        private void initHeaderView() {
            if (TextUtils.equals("yinxiang", this.mEvernoteName)) {
                this.mHeaderView.setLeftTitle(com.duokan.b.i.account__oauth_web_view__title);
                this.mHeaderView.a();
                this.mHeaderView.b(getString(com.duokan.b.i.account__oauth_web_view__change1)).setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        EvernoteOAuthDialog.this.doChange();
                    }
                });
            } else if (TextUtils.equals("evernote", this.mEvernoteName)) {
                this.mHeaderView.setLeftTitle(com.duokan.b.i.account__oauth_web_view__title1);
                this.mHeaderView.a();
                this.mHeaderView.b(getString(com.duokan.b.i.account__oauth_web_view__change)).setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        EvernoteOAuthDialog.this.doChange();
                    }
                });
            }
            af.initCenterDialogHeaderStyle(this.mHeaderView);
        }
    }

    public EvernoteOAuthDialog(Activity activity, Evernote evernote, String str, String str2, OAuthCallback oAuthCallback) {
        super(activity);
        this.mConsumerKey = str;
        this.mConsumerSecret = str2;
        this.mCallback = oAuthCallback;
        this.mRootView = new FrameLayout(getContext());
        setContentView(this.mRootView);
        this.mProgressDialog = new jq(getContext());
        this.mProgressDialog.a(true);
        this.mProgressDialog.a(getContext().getString(com.duokan.b.i.account__oauth__loading));
        this.mYinxiangController = new EvernoteOAuthController(MyContextWrapper.getFeature(getContext()), evernote, this, "yinxiang");
        this.mCurController = this.mYinxiangController;
        this.mEvernoteController = new EvernoteOAuthController(MyContextWrapper.getFeature(getContext()), evernote, this, "evernote");
        this.mRootView.addView(this.mYinxiangController.getContentView(), new LayoutParams(-1, -1));
        this.mRootView.addView(this.mEvernoteController.getContentView(), new LayoutParams(-1, -1));
        this.mEvernoteController.getContentView().setVisibility(8);
        this.mShowAnimation = AnimationUtils.loadAnimation(getContext(), b.general__shared__alpha_show);
        this.mDisAnimation = AnimationUtils.loadAnimation(getContext(), b.general__shared__alpha_dismiss);
    }

    public void start() {
        this.mYinxiangController.start();
    }

    private void doChange() {
        if (this.mCurController == this.mYinxiangController) {
            this.mYinxiangController.stop();
            this.mShowAnimation.setAnimationListener(new AnimationListener() {
                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    EvernoteOAuthDialog.this.mEvernoteController.getContentView().setVisibility(0);
                    EvernoteOAuthDialog.this.mShowAnimation.setAnimationListener(null);
                }
            });
            this.mDisAnimation.setAnimationListener(new AnimationListener() {
                public void onAnimationStart(Animation animation) {
                    EvernoteOAuthDialog.this.mEvernoteController.getContentView().startAnimation(EvernoteOAuthDialog.this.mShowAnimation);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    EvernoteOAuthDialog.this.mYinxiangController.getContentView().setVisibility(8);
                    EvernoteOAuthDialog.this.mDisAnimation.setAnimationListener(null);
                }
            });
            this.mYinxiangController.getContentView().startAnimation(this.mDisAnimation);
            this.mCurController = this.mEvernoteController;
            this.mEvernoteController.start();
            return;
        }
        this.mEvernoteController.stop();
        this.mShowAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                EvernoteOAuthDialog.this.mYinxiangController.getContentView().setVisibility(0);
                EvernoteOAuthDialog.this.mShowAnimation.setAnimationListener(null);
            }
        });
        this.mDisAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {
                EvernoteOAuthDialog.this.mYinxiangController.getContentView().startAnimation(EvernoteOAuthDialog.this.mShowAnimation);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                EvernoteOAuthDialog.this.mEvernoteController.getContentView().setVisibility(8);
                EvernoteOAuthDialog.this.mDisAnimation.setAnimationListener(null);
            }
        });
        this.mEvernoteController.getContentView().startAnimation(this.mDisAnimation);
        this.mCurController = this.mYinxiangController;
        this.mYinxiangController.start();
    }

    private void exit(ActivatedController activatedControllerVar, int i) {
        if (this.mCurController == activatedControllerVar) {
            this.mProgressDialog.dismiss();
            switch (i) {
                case 1:
                    this.mCallback.onOauthSuccess();
                    break;
                case 3:
                    this.mCallback.onGetUserNameFailed();
                    break;
                default:
                    this.mCallback.onOauthFailed("");
                    break;
            }
            dismiss();
        }
    }

    public void dismiss() {
        this.mYinxiangController.stop();
        this.mEvernoteController.stop();
        if (this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
        }
        super.dismiss();
    }

    protected void onCancel() {
        super.onCancel();
        this.mCallback.onOauthFailed("");
    }
}
