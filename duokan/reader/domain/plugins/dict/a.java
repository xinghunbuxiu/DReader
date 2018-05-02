package com.duokan.reader.domain.plugins.dict;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.b.c;
import com.duokan.b.e;
import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.b.i;
import com.duokan.core.ui.aj;
import com.duokan.reader.domain.downloadcenter.b;
import com.duokan.reader.domain.downloadcenter.l;
import com.duokan.reader.domain.downloadcenter.m;
import com.duokan.reader.ui.general.DkLabelView;

import java.io.File;

class a extends aj {
    final /* synthetic */ DictDownloadController a;

    a(DictDownloadController dictDownloadController) {
        this.a = dictDownloadController;
    }

    public int a() {
        return 1;
    }

    public int a(int i) {
        return c();
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(g.reading__translation_settings__titile, viewGroup, false);
        }
        ((DkLabelView) view.findViewById(f.reading__translation_settings__title)).setText(this.a.getString(i.reading__translation_offline_dicts));
        return view;
    }

    public int c() {
        return this.a.d.size();
    }

    public Object d(int i) {
        return this.a.d.get(i);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(g.reading__translation_settings__item, viewGroup, false);
        }
        i iVar = (i) d(i);
        ((TextView) view.findViewById(f.reading__translation_settings__item_name)).setText(iVar.a());
        ((TextView) view.findViewById(f.reading__translation_settings__item_size)).setText(((i) d(i)).b());
        DkLabelView dkLabelView = (DkLabelView) view.findViewById(f.reading__translation_settings__item_download);
        String str = j.a + File.separator + iVar.c();
        dkLabelView.setClickable(true);
        switch (g.a[this.a.a(str).ordinal()]) {
            case 1:
                dkLabelView.setTextColor(this.a.getResources().getColor(c.reading__custom_font_view__button_bg));
                dkLabelView.setBackgroundResource(e.reading__custom_font_list_view__download_bg);
                dkLabelView.setText(String.format("%.1f%%", new Object[]{Float.valueOf(b.n().b(str).j())}));
                dkLabelView.setOnClickListener(new b(this, r0));
                break;
            case 2:
                dkLabelView.setText(this.a.getString(i.reading__translation_settings__download));
                dkLabelView.setTextColor(this.a.getResources().getColor(c.reading__custom_font_view__button_bg));
                dkLabelView.setBackgroundResource(e.reading__custom_font_list_view__download_bg);
                dkLabelView.setText(this.a.getString(i.reading__translation_settings__resume));
                dkLabelView.setOnClickListener(new c(this, str));
                break;
            case 3:
                dkLabelView.setText(this.a.getString(i.reading__translation_settings__delete));
                dkLabelView.setTextColor(this.a.getResources().getColor(c.general__shared__ed6c00));
                dkLabelView.setBackgroundResource(e.reading__reading_options_view__text_background_selected);
                dkLabelView.setOnClickListener(new d(this, iVar, i));
                break;
            default:
                dkLabelView.setText(this.a.getString(i.reading__translation_settings__download));
                dkLabelView.setTextColor(this.a.getResources().getColor(c.reading__custom_font_view__button_bg));
                dkLabelView.setBackgroundResource(e.reading__custom_font_list_view__download_bg);
                dkLabelView.setOnClickListener(new f(this, iVar));
                break;
        }
        return view;
    }

    private void a(i iVar) {
        l lVar = new l();
        lVar.b = iVar.d();
        lVar.c = j.a + File.separator + iVar.c();
        lVar.a = iVar.a();
        m hVar = new h();
        hVar.a = iVar.a();
        lVar.e = hVar;
        b.n().a(lVar);
    }
}
