package com.duokan.reader.ui.personal;

import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.HeaderView;

public class a extends e {
    public a(y yVar) {
        super(yVar);
        setContentView(h.general__about_view);
        ((HeaderView) findViewById(g.general__about_view__title)).setLeftTitle(j.general__shared__about);
        String versionName = ReaderEnv.get().getVersionName();
        int versionCode = ReaderEnv.get().getVersionCode();
        int newVersion = ReaderEnv.get().getNewVersion();
        TextView textView = (TextView) findViewById(g.general__about_view__already_latest);
        TextView textView2 = (TextView) findViewById(g.general__about_view__update);
        ((TextView) findViewById(g.general__about_view__current_version)).setText(String.format(getString(j.personal__about_view__current_view), new Object[]{versionName + "." + (ReaderEnv.get().getVersionCode() % 1000000)}));
        if (versionCode >= newVersion) {
            textView.setVisibility(0);
            textView2.setVisibility(8);
            return;
        }
        textView.setVisibility(8);
        textView2.setVisibility(0);
        textView2.setText(getString(j.personal__about_view__update));
        textView2.setOnClickListener(new b(this));
    }
}
