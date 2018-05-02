package com.duokan.reader.ui.general.web;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.p027b.C0324a;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.fl;
import com.duokan.core.ui.fr;

/* renamed from: com.duokan.reader.ui.general.web.b */
public class C1353b extends fl {
    /* renamed from: a */
    private final li f7615a;

    public C1353b(li liVar) {
        this.f7615a = liVar;
    }

    /* renamed from: a */
    public boolean mo1836a(ConsoleMessage consoleMessage) {
        switch (C1355d.f7713a[consoleMessage.messageLevel().ordinal()]) {
            case 1:
            case 2:
                WebLog.init().a(LogLevel.ERROR, "webview", "%s(src: %s, line: %d)", consoleMessage.message(), consoleMessage.sourceId(), Integer.valueOf(consoleMessage.lineNumber()));
                break;
        }
        return super.mo1836a(consoleMessage);
    }

    /* renamed from: a */
    public void mo1835a(fr frVar, String str) {
        super.mo1835a(frVar, str);
        Uri a = C0324a.m734a(frVar.getCurrentUrl());
        if (a != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(a.getHost()) || !str.contains(a.getHost())) {
                UThread.runOnThread(new C1354c(this, str));
            }
        }
    }

    /* renamed from: a */
    public boolean mo1837a(fr frVar, String str, String str2, JsResult jsResult) {
        this.f7615a.showDialog(str2, false, jsResult);
        return true;
    }

    /* renamed from: b */
    public boolean mo1838b(fr frVar, String str, String str2, JsResult jsResult) {
        this.f7615a.showDialog(str2, true, jsResult);
        return true;
    }
}
