package com.duokan.reader.ui.reading;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.TabBarView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ui.general.iw;

public class fe extends ActivatedController {
    /* renamed from: a */
    private final su f10136a = ((su) getContext().queryFeature(su.class));

    public fe(IFeature mFeature) {
        super(mFeature);
        setContentView(C0245g.reading__custom_theme_view);
        ColorPickerView colorPickerView = (ColorPickerView) findViewById(C0244f.reading__custom_theme_view__picker);
        TabBarView tabBarView = (TabBarView) findViewById(C0244f.reading__custom_theme_view__tab_bar);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, AnimUtils.m1932b(getContext(), 5.0f), 0);
        TextView textView = (TextView) tabBarView.m1322c(C0245g.reading__custom_theme_tab_view);
        textView.setText(getString(C0247i.reading__custom_background_color_tab_view__title));
        textView.setLayoutParams(layoutParams);
        textView = (TextView) tabBarView.m1322c(C0245g.reading__custom_theme_tab_view);
        textView.setText(getString(C0247i.reading__custom_text_color_tab_view__title));
        layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(AnimUtils.m1932b(getContext(), 5.0f), 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        tabBarView.setMiddleDividerDrawable(new iw(getResources().getColor(C0241c.general__shared__ffffff33)));
        tabBarView.setDividerScaleType(ScaleType.CENTER);
        tabBarView.setSelectionChangeListener(new ff(this, colorPickerView));
        colorPickerView.m12407a(this.f10136a.ae().m12441B(), this.f10136a.ae().m12442C());
        colorPickerView.setOnColorChangedListenner(new fg(this, tabBarView));
    }
}
