package com.duokan.reader.domain.account.oauth.evernote;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;

import com.evernote.edam.notestore.NoteStore.Client;
import com.evernote.edam.userstore.UserStore;
import com.evernote.thrift.protocol.TBinaryProtocol;
import com.evernote.thrift.protocol.TProtocol;

import org.apache.http.HttpHost;

import java.io.File;
import java.util.Locale;

public class EvernoteSession extends Utils {
    public static final String HOST_CHINA = "app.yinxiang.com";
    public static final String HOST_PRODUCTION = "www.evernote.com";
    public static final String HOST_SANDBOX = "sandbox.evernote.com";
    public static final int REQUEST_CODE_OAUTH = 1010101;
    private AuthenticationResult mAuthenticationResult;
    private EvernoteCallback mCallback;
    private String mConsumerKey;
    private String mConsumerSecret;
    private File mDataDirectory;
    private String mEvernoteName;
    private String mUserAgentString;

    public EvernoteSession(Context context, String str, String str2, String str3, String str4, File file, EvernoteCallback evernoteCallback) {
        this.mEvernoteName = str;
        this.mConsumerKey = str2;
        this.mConsumerSecret = str3;
        this.mCallback = evernoteCallback;
        initUserAgentString(context);
        this.mAuthenticationResult = getAuthenticationResult(context);
        if (file != null) {
            this.mDataDirectory = file;
        } else {
            this.mDataDirectory = context.getFilesDir();
        }
    }

    private AuthenticationResult getAuthenticationResult(Context context) {
        EvernoteTokenDao authenticationResult = this.mCallback.getAuthenticationResult(context, this.mEvernoteName);
        if (authenticationResult != null) {
            return new AuthenticationResult(authenticationResult.mAuthToken, authenticationResult.mNotestoreUrl, authenticationResult.mWebApiUrlPrefix, authenticationResult.mUserId);
        }
        return null;
    }

    public boolean isLoggedIn() {
        return this.mAuthenticationResult != null;
    }

    public void logOut(Context context, String str) {
        this.mAuthenticationResult = null;
        this.mCallback.logOut(context, str);
    }

    public String getAuthToken() {
        if (this.mAuthenticationResult != null) {
            return this.mAuthenticationResult.getAuthToken();
        }
        return null;
    }

    public AuthenticationResult getmAuthenticationResult() {
        return this.mAuthenticationResult;
    }

    public Client createNoteStore() {
        if (isLoggedIn()) {
            TProtocol tBinaryProtocol = new TBinaryProtocol(new TEvernoteHttpClient(this.mAuthenticationResult.getNoteStoreUrl(), this.mUserAgentString, this.mDataDirectory));
            return new Client(tBinaryProtocol, tBinaryProtocol);
        }
        throw new IllegalStateException();
    }

    public UserStore.Client createUserStore(String str) {
        String str2 = "";
        if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            str2 = str.contains(":") ? "http://" : "https://";
        }
        TProtocol tBinaryProtocol = new TBinaryProtocol(new TEvernoteHttpClient(str2 + str + "/edam/user", this.mUserAgentString, this.mDataDirectory));
        return new UserStore.Client(tBinaryProtocol, tBinaryProtocol);
    }

    private void initUserAgentString(Context context) {
        String packageName;
        NameNotFoundException e;
        String str;
        Locale locale;
        int i = 0;
        try {
            packageName = context.getPackageName();
            try {
                i = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
            } catch (NameNotFoundException e2) {
                e = e2;
                Log.e("tag", e.getMessage());
                str = packageName + " Android/" + i;
                locale = Locale.getDefault();
                if (locale == null) {
                    str = str + " (" + locale.toString() + "); ";
                } else {
                    str = str + " (" + Locale.US + ");";
                }
                this.mUserAgentString = (str + "Android/" + VERSION.RELEASE + "; ") + Build.MODEL + "/" + VERSION.SDK_INT + ";";
            }
        } catch (NameNotFoundException e3) {
            NameNotFoundException nameNotFoundException = e3;
            packageName = null;
            e = nameNotFoundException;
            Log.e("tag", e.getMessage());
            str = packageName + " Android/" + i;
            locale = Locale.getDefault();
            if (locale == null) {
                str = str + " (" + Locale.US + ");";
            } else {
                str = str + " (" + locale.toString() + "); ";
            }
            this.mUserAgentString = (str + "Android/" + VERSION.RELEASE + "; ") + Build.MODEL + "/" + VERSION.SDK_INT + ";";
        }
        str = packageName + " Android/" + i;
        locale = Locale.getDefault();
        if (locale == null) {
            str = str + " (" + Locale.US + ");";
        } else {
            str = str + " (" + locale.toString() + "); ";
        }
        this.mUserAgentString = (str + "Android/" + VERSION.RELEASE + "; ") + Build.MODEL + "/" + VERSION.SDK_INT + ";";
    }

    public String getUserAgentString() {
        return this.mUserAgentString;
    }

    public boolean persistAuthenticationToken(Context context, String str, Object obj) {
        return persistAuthenticationToken(context, str, (EvernoteAuthToken) obj);
    }

    protected boolean persistAuthenticationToken(Context context, String str, EvernoteAuthToken evernoteAuthToken) {
        if (context == null || evernoteAuthToken == null) {
            return false;
        }
        this.mCallback.setAuthenticationToken(context, str, new EvernoteTokenDao(evernoteAuthToken.getToken(), evernoteAuthToken.getNoteStoreUrl(), evernoteAuthToken.getWebApiUrlPrefix(), evernoteAuthToken.getUserId()));
        this.mAuthenticationResult = new AuthenticationResult(evernoteAuthToken.getToken(), evernoteAuthToken.getNoteStoreUrl(), evernoteAuthToken.getWebApiUrlPrefix(), evernoteAuthToken.getUserId());
        return true;
    }
}
