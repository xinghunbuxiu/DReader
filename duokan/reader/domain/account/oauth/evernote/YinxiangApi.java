package com.duokan.reader.domain.account.oauth.evernote;

import org.scribe.builder.api.EvernoteApi;
import org.scribe.model.Token;

public class YinxiangApi extends EvernoteApi {
    private static final String YINXIANG_URL = "https://app.yinxiang.com";

    public String getRequestTokenEndpoint() {
        return "https://app.yinxiang.com/oauth";
    }

    public String getAccessTokenEndpoint() {
        return "https://app.yinxiang.com/oauth";
    }

    public String getAuthorizationUrl(Token token) {
        return String.format("https://app.yinxiang.com/OAuth.action?oauth_token=%s", new Object[]{token.getToken()});
    }
}
