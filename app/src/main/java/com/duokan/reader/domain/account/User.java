package com.duokan.reader.domain.account;

import android.text.TextUtils;

import org.json.JSONObject;

import java.io.Serializable;

public class User implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!User.class.desiredAssertionStatus());
    public String mIconUrl;
    public boolean mIsVip;
    public String mNickName;
    public String mUserId;

    public static void copy(User user, User user2) {
        user2.mUserId = user.mUserId;
        user2.mNickName = user.mNickName;
        user2.mIconUrl = user.mIconUrl;
        user2.mIsVip = user.mIsVip;
    }

    public void copy(User user) {
        this.mUserId = user.mUserId;
        this.mNickName = user.mNickName;
        this.mIconUrl = user.mIconUrl;
        this.mIsVip = user.mIsVip;
    }

    public String getAliasForDisplay() {
        if (TextUtils.isEmpty(this.mNickName)) {
            return this.mUserId;
        }
        return this.mNickName;
    }

    public void updateUserInfo(User user) {
        if (user != null) {
            this.mNickName = user.mNickName;
            this.mIconUrl = user.mIconUrl;
        }
    }

    public static User valueOfMiUserCard(JSONObject jSONObject) {
        User user = new User();
        try {
            user.mUserId = jSONObject.optString("userId");
            Object optString = jSONObject.optString("miliaoNick");
            if (TextUtils.isEmpty(optString)) {
                user.mNickName = user.mUserId;
            } else {
                user.mNickName = optString;
            }
            user.mIconUrl = jSONObject.optString("miliaoIcon");
            if (!TextUtils.isEmpty(user.mIconUrl)) {
                user.mIconUrl = user.mIconUrl.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
        }
        return user;
    }
}
