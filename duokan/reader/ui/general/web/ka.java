package com.duokan.reader.ui.general.web;

import android.net.Uri;
import android.webkit.WebResourceResponse;

import com.duokan.core.b.UrlTools;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.WebLog;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLConnection;
import java.util.regex.Matcher;

class ka implements g {
    final /* synthetic */ StoreWebController a;

    ka(StoreWebController storeWebController) {
        this.a = storeWebController;
    }

    public WebResourceResponse a(e eVar, String str) {
        if (!StoreWebController.sMirrorEnabled) {
            return null;
        }
        boolean z;
        StoreWebController.waitForStoreMirrorReady();
        File access$200 = StoreWebController.sStoreMirrorDir;
        WebLog c = a.c();
        if (access$200 != null) {
            z = true;
        } else {
            z = false;
        }
        c.b(z);
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
        if (!StoreWebController.sMirrorHostPattern.matcher(a.getHost() != null ? a.getHost() : "").matches()) {
            return null;
        }
        CharSequence charSequence;
        if (a.getPath() == null) {
            charSequence = "";
        } else if (a.getPath().endsWith("/")) {
            charSequence = a.getPath() + "index.html";
            com.duokan.reader.domain.statistics.a.k().a(access$200);
        } else {
            charSequence = a.getPath();
        }
        Matcher matcher = StoreWebController.sMirrorPathPattern.matcher(charSequence);
        if (!matcher.matches()) {
            return null;
        }
        if (matcher.groupCount() < 1) {
            return null;
        }
        File file = new File(access$200, matcher.group(1));
        if (file.exists()) {
            try {
                return new WebResourceResponse(URLConnection.guessContentTypeFromName(file.getName()), "", new FileInputStream(file));
            } catch (Throwable th) {
                a.c().a(LogLevel.WARNING, "store", String.format("mirror exception(res=%s, ver=%s)", new Object[]{r5, access$200.getName().split("\\.")[0]}), th);
                return null;
            }
        }
        a.c().a(LogLevel.WARNING, "store", "mirror lost(res=%s, ver=%s)", r5, access$200.getName().split("\\.")[0]);
        return null;
    }
}
