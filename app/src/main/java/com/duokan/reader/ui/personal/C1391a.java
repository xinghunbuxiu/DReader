package com.duokan.reader.ui.personal;

import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.HeaderView;

/* renamed from: com.duokan.reader.ui.personal.a */
public class C1391a extends ActivatedController {
    public C1391a(IFeature mFeature) {
        super(mFeature);
        setContentView(C0256h.general__about_view);
        ((HeaderView) findViewById(C0255g.general__about_view__title)).setLeftTitle(C0258j.general__shared__about);
        String versionName = ReaderEnv.get().getVersionName();
        int versionCode = ReaderEnv.get().getVersionCode();
        int newVersion = ReaderEnv.get().getNewVersion();
        TextView textView = (TextView) findViewById(C0255g.general__about_view__already_latest);
        TextView textView2 = (TextView) findViewById(C0255g.general__about_view__update);
        ((TextView) findViewById(C0255g.general__about_view__current_version)).setText(String.format(getString(C0258j.personal__about_view__current_view), new Object[]{versionName + "." + (ReaderEnv.get().getVersionCode() % 1000000)}));
        if (versionCode >= newVersion) {
            textView.setVisibility(0);
            textView2.setVisibility(8);
            return;
        }
        textView.setVisibility(8);
        textView2.setVisibility(0);
        textView2.setText(getString(C0258j.personal__about_view__update));
        textView2.setOnClickListener(new C1392b(this));
    }
}
