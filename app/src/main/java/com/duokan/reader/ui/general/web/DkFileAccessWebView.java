package com.duokan.reader.ui.general.web;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;

public class DkFileAccessWebView extends DkWebView {
    @SuppressLint({"NewApi"})
    public DkFileAccessWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
    }
}
