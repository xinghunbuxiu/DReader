package com.duokan.reader.ui.general.web;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;

import com.duokan.core.b.UrlTools;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.fl;
import com.duokan.core.ui.fr;

public class b extends fl {
    private final kd a;

    public b(kd kdVar) {
        this.a = kdVar;
    }

    public boolean a(ConsoleMessage consoleMessage) {
        LogLevel logLevel;
        switch (d.a[consoleMessage.messageLevel().ordinal()]) {
            case 1:
            case 2:
                logLevel = LogLevel.ERROR;
                break;
            default:
                logLevel = LogLevel.INFO;
                break;
        }
        a.c().a(logLevel, "webview", "%s(src: %s, line: %getScaledTouchSlop)", consoleMessage.message(), consoleMessage.sourceId(), Integer.valueOf(consoleMessage.lineNumber()));
        return super.a(consoleMessage);
    }

    public void a(fr frVar, String str) {
        super.a(frVar, str);
        Uri a = UrlTools.parse(frVar.getCurrentUrl());
        if (a != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(a.getHost()) || !str.contains(a.getHost())) {
                TaskHandler.postTask(new c(this, str));
            }
        }
    }

    public boolean a(fr frVar, String str, String str2, JsResult jsResult) {
        this.a.showDialog(str2, false, jsResult);
        return true;
    }

    public boolean b(fr frVar, String str, String str2, JsResult jsResult) {
        this.a.showDialog(str2, true, jsResult);
        return true;
    }
}
