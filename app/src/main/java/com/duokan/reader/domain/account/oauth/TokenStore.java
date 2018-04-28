package com.duokan.reader.domain.account.oauth;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.duokan.reader.domain.account.oauth.evernote.EvernoteTokenDao;

public class TokenStore {
    private static TokenStore instentce = null;

    public interface OnAccessTokenBindListener {
        void onOk();
    }

    public interface OnAccessTokenUnbindListener {
        void onOk();
    }

    private TokenStore() {
    }

    public static synchronized TokenStore getInstance() {
        TokenStore tokenStore;
        synchronized (TokenStore.class) {
            if (instentce == null) {
                instentce = new TokenStore();
            }
            tokenStore = instentce;
        }
        return tokenStore;
    }

    public boolean canAccessTokenSyncToCloud(String str) {
        return str.equals("weibo");
    }

    public void bindAccessToken(Context context, String str, String str2, String str3, String str4, String str5, String str6, OnAccessTokenBindListener onAccessTokenBindListener) {
        bindLocalAccessToken(context, str, str2, str3, str4, str5, str6);
        if (onAccessTokenBindListener != null) {
            onAccessTokenBindListener.onOk();
        }
    }

    private void bindLocalAccessToken(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Editor edit = context.getSharedPreferences("TOKEN", 0).edit();
        edit.putString(str + "_userId", str2);
        edit.putString(str + "_username", str6);
        edit.putString(str + "_expires", str5);
        edit.putString(str + "_refresh_token", str4);
        edit.putString(str + "_token", str3);
        edit.apply();
    }

    public String getUserId(Context context, String str) {
        return context.getSharedPreferences("TOKEN", 0).getString(str + "_userId", "");
    }

    public String getAccessToken(Context context, String str) {
        return context.getSharedPreferences("TOKEN", 0).getString(str + "_token", "");
    }

    public void unbindAccessToken(Context context, String str, OnAccessTokenUnbindListener onAccessTokenUnbindListener) {
        unbindLocalAccessToken(context, str);
        if (onAccessTokenUnbindListener != null) {
            onAccessTokenUnbindListener.onOk();
        }
    }

    private void unbindLocalAccessToken(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("TOKEN", 0);
        String str2 = str + "_token";
        if (str.equals("yinxiang") || str.equals("evernote")) {
            logOut(context, str);
        } else if (sharedPreferences.contains(str2)) {
            Editor edit = sharedPreferences.edit();
            edit.remove(str2);
            edit.remove(str + "_expires");
            edit.apply();
        }
    }

    public boolean isBindAccessToken(Context context, String str) {
        boolean z = true;
        SharedPreferences sharedPreferences = context.getSharedPreferences("TOKEN", 0);
        long parseLong = Long.parseLong(sharedPreferences.getString(str + "_expires", "0"));
        if (str.equals("yinxiang") || str.equals("evernote")) {
            if (getAuthenticationResult(context, str) == null) {
                z = false;
            }
            return z;
        } else if (!sharedPreferences.contains(str + "_token") || parseLong <= System.currentTimeMillis()) {
            return false;
        } else {
            return true;
        }
    }

    public String getUserName(Context context, String str) {
        return context.getSharedPreferences("TOKEN", 0).getString(str + "_username", "");
    }

    public void setUserName(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences("TOKEN", 0).edit();
        edit.putString(str + "_username", str2);
        edit.apply();
    }

    public boolean hasLoginEvernote(Context context) {
        return isBindAccessToken(context, "evernote") || isBindAccessToken(context, "yinxiang");
    }

    public void setAuthenticationToken(Context context, String str, EvernoteTokenDao evernoteTokenDao) {
        Editor edit = context.getSharedPreferences("TOKEN", 0).edit();
        edit.putString(str + "_token", evernoteTokenDao.mAuthToken);
        edit.putString(str + "_notestoreUrl", evernoteTokenDao.mNotestoreUrl);
        edit.putString(str + "_webApiUrlPrefix", evernoteTokenDao.mWebApiUrlPrefix);
        edit.putInt(str + "_userId", evernoteTokenDao.mUserId);
        edit.putString(str + "_username", "");
        edit.apply();
    }

    public void logOut(Context context, String str) {
        Editor edit = context.getSharedPreferences("TOKEN", 0).edit();
        edit.remove(str + "_token");
        edit.remove(str + "_notestoreUrl");
        edit.remove(str + "_webApiUrlPrefix");
        edit.remove(str + "_userId");
        edit.remove(str + "_username");
        edit.apply();
    }

    public EvernoteTokenDao getAuthenticationResult(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("TOKEN", 0);
        Object string = sharedPreferences.getString(str + "_token", null);
        Object string2 = sharedPreferences.getString(str + "_notestoreUrl", null);
        Object string3 = sharedPreferences.getString(str + "_webApiUrlPrefix", null);
        int i = sharedPreferences.getInt(str + "_userId", -1);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3) || i == -1) {
            return null;
        }
        return new EvernoteTokenDao(string, string2, string3, i);
    }
}
