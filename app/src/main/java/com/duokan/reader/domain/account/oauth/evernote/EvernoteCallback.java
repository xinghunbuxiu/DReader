package com.duokan.reader.domain.account.oauth.evernote;

import android.content.Context;

public interface EvernoteCallback {
    EvernoteTokenDao getAuthenticationResult(Context context, String str);

    void logOut(Context context, String str);

    void setAuthenticationToken(Context context, String str, EvernoteTokenDao evernoteTokenDao);
}
