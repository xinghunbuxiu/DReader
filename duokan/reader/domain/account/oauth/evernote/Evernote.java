package com.duokan.reader.domain.account.oauth.evernote;

import android.content.Context;
import android.net.Uri;

public interface Evernote {
    String[] beginAuth(String str, String str2, String str3);

    Object completeAuth(String str, String str2, String str3, Uri uri, String str4, String str5);

    void delete(String str);

    String getCallbackScheme();

    EvernoteUser getUser(String str);

    boolean isLoggedIn();

    void output(String str, String str2, String str3, String str4, String str5);

    boolean persistAuthenticationToken(Context context, String str, Object obj);
}
