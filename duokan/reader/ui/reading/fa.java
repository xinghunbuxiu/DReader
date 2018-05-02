package com.duokan.reader.ui.reading;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import com.duokan.b.c;
import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.b.i;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.TabBarView;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.jm;

public class fa extends ActivatedController {
    private final sh a = ((sh) getContext().queryFeature(sh.class));

    public fa(IFeature featrue) {
        super(featrue);
        setContentView(g.reading__custom_theme_view);
        ColorPickerView colorPickerView = (ColorPickerView) findViewById(f.reading__custom_theme_view__picker);
        TabBarView tabBarView = (TabBarView) findViewById(f.reading__custom_theme_view__tab_bar);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, UTools.getMinimumHeight(getContext(), 5.0f), 0);
        TextView textView = (TextView) tabBarView.c(g.reading__custom_theme_tab_view);
        textView.setText(getString(i.reading__custom_background_color_tab_view__title));
        textView.setLayoutParams(layoutParams);
        textView = (TextView) tabBarView.c(g.reading__custom_theme_tab_view);
        textView.setText(getString(i.reading__custom_text_color_tab_view__title));
        layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(UTools.getMinimumHeight(getContext(), 5.0f), 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        tabBarView.setMiddleDividerDrawable(new jm(getResources().getColor(c.general__shared__ffffff33)));
        tabBarView.setDividerScaleType(ScaleType.CENTER);
        tabBarView.setSelectionChangeListener(new fb(this, colorPickerView));
        colorPickerView.a(this.a.ae().B(), this.a.ae().C());
        colorPickerView.setOnColorChangedListenner(new fc(this, tabBarView));
    }
}
