package com.duokan.reader.domain.plugins.dict;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.core.ui.aj;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.domain.downloadcenter.C1014m;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.downloadcenter.C1025l;
import com.duokan.reader.ui.general.DkLabelView;
import java.io.File;

/* renamed from: com.duokan.reader.domain.plugins.dict.a */
class C1106a extends aj {
    /* renamed from: a */
    final /* synthetic */ DictDownloadController f5386a;

    C1106a(DictDownloadController dictDownloadController) {
        this.f5386a = dictDownloadController;
    }

    /* renamed from: a */
    public int mo486a() {
        return 1;
    }

    /* renamed from: a */
    public int mo487a(int i) {
        return mo506c();
    }

    /* renamed from: a */
    public View mo488a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f5386a.getContext()).inflate(C0245g.reading__translation_settings__titile, viewGroup, false);
        }
        ((DkLabelView) view.findViewById(C0244f.reading__translation_settings__title)).setText(this.f5386a.getString(C0247i.reading__translation_offline_dicts));
        return view;
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f5386a.f5385d.size();
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return this.f5386a.f5385d.get(i);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f5386a.getContext()).inflate(C0245g.reading__translation_settings__item, viewGroup, false);
        }
        C1114i c1114i = (C1114i) mo509d(i);
        ((TextView) view.findViewById(C0244f.reading__translation_settings__item_name)).setText(c1114i.m8407a());
        ((TextView) view.findViewById(C0244f.reading__translation_settings__item_size)).setText(((C1114i) mo509d(i)).m8408b());
        DkLabelView dkLabelView = (DkLabelView) view.findViewById(C0244f.reading__translation_settings__item_download);
        String str = C1115j.f5405a + File.separator + c1114i.m8409c();
        dkLabelView.setClickable(true);
        switch (C1112g.f5397a[this.f5386a.m8392a(str).ordinal()]) {
            case 1:
                dkLabelView.setTextColor(this.f5386a.getResources().getColor(C0241c.reading__custom_font_view__button_bg));
                dkLabelView.setBackgroundResource(C0243e.reading__custom_font_list_view__download_bg);
                dkLabelView.setText(String.format("%.1f%%", new Object[]{Float.valueOf(C1016b.m7857p().m7877b(str).m7796j())}));
                dkLabelView.setOnClickListener(new C1107b(this, r0));
                break;
            case 2:
                dkLabelView.setText(this.f5386a.getString(C0247i.reading__translation_settings__download));
                dkLabelView.setTextColor(this.f5386a.getResources().getColor(C0241c.reading__custom_font_view__button_bg));
                dkLabelView.setBackgroundResource(C0243e.reading__custom_font_list_view__download_bg);
                dkLabelView.setText(this.f5386a.getString(C0247i.reading__translation_settings__resume));
                dkLabelView.setOnClickListener(new C1108c(this, str));
                break;
            case 3:
                dkLabelView.setText(this.f5386a.getString(C0247i.reading__translation_settings__delete));
                dkLabelView.setTextColor(this.f5386a.getResources().getColor(C0241c.general__shared__ed6c00));
                dkLabelView.setBackgroundResource(C0243e.reading__reading_options_view__text_background_selected);
                dkLabelView.setOnClickListener(new C1109d(this, c1114i, i));
                break;
            default:
                dkLabelView.setText(this.f5386a.getString(C0247i.reading__translation_settings__download));
                dkLabelView.setTextColor(this.f5386a.getResources().getColor(C0241c.reading__custom_font_view__button_bg));
                dkLabelView.setBackgroundResource(C0243e.reading__custom_font_list_view__download_bg);
                dkLabelView.setOnClickListener(new C1111f(this, c1114i));
                break;
        }
        return view;
    }

    /* renamed from: a */
    private void m8396a(C1114i c1114i) {
        C1025l c1025l = new C1025l();
        c1025l.f5080b = c1114i.m8410d();
        c1025l.f5081c = C1115j.f5405a + File.separator + c1114i.m8409c();
        c1025l.f5079a = c1114i.m8407a();
        C1014m c1113h = new C1113h();
        c1113h.f5399a = c1114i.m8407a();
        c1025l.f5083e = c1113h;
        C1016b.m7857p().m7865a(c1025l);
    }
}
