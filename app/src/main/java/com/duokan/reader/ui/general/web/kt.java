package com.duokan.reader.ui.general.web;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.p027b.UrlTools;
import com.duokan.reader.domain.statistics.C1163a;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLConnection;
import java.util.regex.Matcher;

class kt implements C1359g {
    /* renamed from: a */
    final /* synthetic */ StoreWebController f8115a;

    kt(StoreWebController storeWebController) {
        this.f8115a = storeWebController;
    }

    /* renamed from: a */
    public WebResourceResponse mo1856a(C1357e c1357e, String str) {
        if (!StoreWebController.sMirrorEnabled) {
            return null;
        }
        boolean z;
        StoreWebController.waitForStoreMirrorReady();
        File access$200 = StoreWebController.sStoreMirrorDir;
        WebLog c = WebLog.init();
        if (access$200 != null) {
            z = true;
        } else {
            z = false;
        }
        c.w(z);
        if (access$200 == null) {
            return null;
        }
        if (!access$200.exists()) {
            return null;
        }
        Uri a = UrlTools.parse(str);
        if (a == null) {
            return null;
        }
        if (!StoreWebController.sMirrorSchemePattern.matcher(a.getScheme() != null ? a.getScheme() : "").matches()) {
            return null;
        }
        CharSequence charSequence;
        Object group;
        String host = a.getHost();
        Matcher matcher = StoreWebController.sMirrorHostPattern.matcher(host != null ? host : "");
        String str2 = "";
        if (a.getPath() == null) {
            charSequence = "";
        } else if (a.getPath().endsWith("/")) {
            charSequence = a.getPath() + "index.html";
            C1163a.m8627k().m8640a(access$200);
        } else {
            charSequence = a.getPath();
        }
        Matcher matcher2 = StoreWebController.sMirrorPathPattern.matcher(charSequence);
        if (matcher.matches() && matcher2.matches() && matcher2.groupCount() >= 1) {
            group = matcher2.group(1);
        } else {
            group = host + a.getPath();
        }
        if (TextUtils.isEmpty(group)) {
            return null;
        }
        File file = new File(access$200, group);
        if (!file.exists()) {
            return null;
        }
        try {
            return new WebResourceResponse(URLConnection.guessContentTypeFromName(file.getName()), "", new FileInputStream(file));
        } catch (Throwable th) {
            WebLog.init().a(LogLevel.WARNING, "store", String.format("mirror exception(res=%s, ver=%s)", new Object[]{group, access$200.getName().split("\\.")[0]}), th);
            return null;
        }
    }
}
