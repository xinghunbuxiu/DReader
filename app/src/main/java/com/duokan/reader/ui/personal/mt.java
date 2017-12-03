package com.duokan.reader.ui.personal;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.DkApp;
import com.duokan.reader.ui.general.PageHeaderView;

import java.util.Locale;

public class mt extends ActivatedController {
    static final /* synthetic */ boolean a = (!mt.class.desiredAssertionStatus());
    private final Locale[] b = new Locale[]{null, new Locale(Locale.CHINESE.getLanguage(), Locale.SIMPLIFIED_CHINESE.getCountry()), new Locale(Locale.CHINESE.getLanguage(), Locale.TRADITIONAL_CHINESE.getCountry())};
    private final int[] c = new int[]{j.personal__setup_language_view__default, j.personal__setup_language_view__chinese, j.personal__setup_language_view__chinese_traditional};
    private int d = -1;

    public mt(IFeature featrue) {
        super(featrue);
        setContentView(h.personal__setup_language_view);
        ((PageHeaderView) findViewById(g.personal__setup_language_view__header)).setLeftTitle(j.personal__setup_language_view__title);
        Locale userChosenLocale = DkApp.get().getUserChosenLocale();
        if (userChosenLocale == null) {
            this.d = 0;
        } else if (userChosenLocale.getLanguage().equalsIgnoreCase(Locale.CHINESE.getLanguage())) {
            if (userChosenLocale.getCountry().equalsIgnoreCase(Locale.TRADITIONAL_CHINESE.getCountry())) {
                this.d = 2;
            } else {
                this.d = 1;
            }
        } else if (userChosenLocale.getLanguage().equalsIgnoreCase(Locale.ENGLISH.getLanguage())) {
            this.d = 3;
        } else if (a) {
            this.d = 1;
        } else {
            throw new AssertionError();
        }
        a();
        View findViewById = findViewById(g.personal__setup_language_view__first);
        ((TextView) findViewById.findViewById(g.personal__setup_language_item_view__language)).setText(this.c[0]);
        findViewById.setOnClickListener(new mu(this));
        findViewById = findViewById(g.personal__setup_language_view__second);
        ((TextView) findViewById.findViewById(g.personal__setup_language_item_view__language)).setText(this.c[1]);
        findViewById.setOnClickListener(new mv(this));
        findViewById = findViewById(g.personal__setup_language_view__third);
        ((TextView) findViewById.findViewById(g.personal__setup_language_item_view__language)).setText(this.c[2]);
        findViewById.setOnClickListener(new mw(this));
    }

    private void a() {
        findViewById(g.personal__setup_language_view__first).findViewById(g.personal__setup_language_item_view__selected).setSelected(false);
        findViewById(g.personal__setup_language_view__second).findViewById(g.personal__setup_language_item_view__selected).setSelected(false);
        findViewById(g.personal__setup_language_view__third).findViewById(g.personal__setup_language_item_view__selected).setSelected(false);
        if (this.d == 0) {
            findViewById(g.personal__setup_language_view__first).findViewById(g.personal__setup_language_item_view__selected).setSelected(true);
        } else if (this.d == 1) {
            findViewById(g.personal__setup_language_view__second).findViewById(g.personal__setup_language_item_view__selected).setSelected(true);
        } else if (this.d == 2) {
            findViewById(g.personal__setup_language_view__third).findViewById(g.personal__setup_language_item_view__selected).setSelected(true);
        } else {
            findViewById(g.personal__setup_language_view__first).findViewById(g.personal__setup_language_item_view__selected).setSelected(true);
        }
    }

    private void a(int i) {
        a();
        getActivity().finish();
        DkApp.get().setUserChosenLocale(this.b[i]);
        Intent intent = new Intent(getActivity(), DkApp.get().getMainActivityClass());
        intent.setAction("android.intent.action.MAIN");
        getActivity().startActivity(intent);
    }
}
