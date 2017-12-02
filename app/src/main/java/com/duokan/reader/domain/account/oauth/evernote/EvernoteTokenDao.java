package com.duokan.reader.domain.account.oauth.evernote;

public class EvernoteTokenDao {
    public final String mAuthToken;
    public final String mNotestoreUrl;
    public final int mUserId;
    public final String mWebApiUrlPrefix;

    public EvernoteTokenDao(String str, String str2, String str3, int i) {
        this.mAuthToken = str;
        this.mNotestoreUrl = str2;
        this.mWebApiUrlPrefix = str3;
        this.mUserId = i;
    }
}
