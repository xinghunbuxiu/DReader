package com.duokan.reader.ui.personal;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.ui.general.PageHeaderView;
import java.util.Locale;

public class nh extends ActivatedController {
    /* renamed from: a */
    static final /* synthetic */ boolean f8986a = (!nh.class.desiredAssertionStatus());
    /* renamed from: b */
    private final Locale[] f8987b = new Locale[]{null, new Locale(Locale.CHINESE.getLanguage(), Locale.SIMPLIFIED_CHINESE.getCountry()), new Locale(Locale.CHINESE.getLanguage(), Locale.TRADITIONAL_CHINESE.getCountry())};
    /* renamed from: c */
    private final int[] f8988c = new int[]{C0258j.personal__setup_language_view__default, C0258j.personal__setup_language_view__chinese, C0258j.personal__setup_language_view__chinese_traditional};
    /* renamed from: d */
    private int f8989d = -1;

    public nh(IFeature mFeature) {
        super(mFeature);
        setContentView(C0256h.personal__setup_language_view);
        ((PageHeaderView) findViewById(C0255g.personal__setup_language_view__header)).setLeftTitle(C0258j.personal__setup_language_view__title);
        Locale userChosenLocale = DkApp.get().getUserChosenLocale();
        if (userChosenLocale == null) {
            this.f8989d = 0;
        } else if (userChosenLocale.getLanguage().equalsIgnoreCase(Locale.CHINESE.getLanguage())) {
            if (userChosenLocale.getCountry().equalsIgnoreCase(Locale.TRADITIONAL_CHINESE.getCountry())) {
                this.f8989d = 2;
            } else {
                this.f8989d = 1;
            }
        } else if (userChosenLocale.getLanguage().equalsIgnoreCase(Locale.ENGLISH.getLanguage())) {
            this.f8989d = 3;
        } else if (f8986a) {
            this.f8989d = 1;
        } else {
            throw new AssertionError();
        }
        m12341a();
        View findViewById = findViewById(C0255g.personal__setup_language_view__first);
        ((TextView) findViewById.findViewById(C0255g.personal__setup_language_item_view__language)).setText(this.f8988c[0]);
        findViewById.setOnClickListener(new ni(this));
        findViewById = findViewById(C0255g.personal__setup_language_view__second);
        ((TextView) findViewById.findViewById(C0255g.personal__setup_language_item_view__language)).setText(this.f8988c[1]);
        findViewById.setOnClickListener(new nj(this));
        findViewById = findViewById(C0255g.personal__setup_language_view__third);
        ((TextView) findViewById.findViewById(C0255g.personal__setup_language_item_view__language)).setText(this.f8988c[2]);
        findViewById.setOnClickListener(new nk(this));
    }

    /* renamed from: a */
    private void m12341a() {
        findViewById(C0255g.personal__setup_language_view__first).findViewById(C0255g.personal__setup_language_item_view__selected).setSelected(false);
        findViewById(C0255g.personal__setup_language_view__second).findViewById(C0255g.personal__setup_language_item_view__selected).setSelected(false);
        findViewById(C0255g.personal__setup_language_view__third).findViewById(C0255g.personal__setup_language_item_view__selected).setSelected(false);
        if (this.f8989d == 0) {
            findViewById(C0255g.personal__setup_language_view__first).findViewById(C0255g.personal__setup_language_item_view__selected).setSelected(true);
        } else if (this.f8989d == 1) {
            findViewById(C0255g.personal__setup_language_view__second).findViewById(C0255g.personal__setup_language_item_view__selected).setSelected(true);
        } else if (this.f8989d == 2) {
            findViewById(C0255g.personal__setup_language_view__third).findViewById(C0255g.personal__setup_language_item_view__selected).setSelected(true);
        } else {
            findViewById(C0255g.personal__setup_language_view__first).findViewById(C0255g.personal__setup_language_item_view__selected).setSelected(true);
        }
    }

    /* renamed from: a */
    private void m12342a(int i) {
        m12341a();
        getActivity().finish();
        DkApp.get().setUserChosenLocale(this.f8987b[i]);
        Intent intent = new Intent(getActivity(), DkApp.get().getMainActivityClass());
        intent.setAction("android.intent.action.MAIN");
        getActivity().startActivity(intent);
    }
}
