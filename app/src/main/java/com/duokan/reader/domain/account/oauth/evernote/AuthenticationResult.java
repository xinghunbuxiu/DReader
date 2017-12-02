package com.duokan.reader.domain.account.oauth.evernote;

public class AuthenticationResult {
    private String authToken;
    private String noteStoreUrl;
    private int userId;
    private String webApiUrlPrefix;

    public AuthenticationResult(String str, String str2, String str3, int i) {
        this.authToken = str;
        this.noteStoreUrl = str2;
        this.webApiUrlPrefix = str3;
        this.userId = i;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public String getNoteStoreUrl() {
        return this.noteStoreUrl;
    }

    public String getWebApiUrlPrefix() {
        return this.webApiUrlPrefix;
    }

    public int getUserId() {
        return this.userId;
    }
}
