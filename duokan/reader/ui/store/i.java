package com.duokan.reader.ui.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.reader.common.webservices.duokan.DkStoreBookTocInfo;
import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.general.deprecatedDkTextView;

class i extends bo {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public /* synthetic */ Object d(int i) {
        return c(i);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.store__toc_item_view, null);
        }
        DkStoreBookTocInfo c = c(i);
        if (c != null) {
            ((TextView) view.findViewById(g.store__toc_item_view__title)).setText(c.mTitle);
            deprecatedDkTextView com_duokan_reader_ui_general_deprecatedDkTextView = (deprecatedDkTextView) view.findViewById(g.store__toc_item_view__preview);
            com_duokan_reader_ui_general_deprecatedDkTextView.setText(c.mPreview);
            com_duokan_reader_ui_general_deprecatedDkTextView.setUseBitmapCache(true);
            com_duokan_reader_ui_general_deprecatedDkTextView = (deprecatedDkTextView) view.findViewById(g.store__toc_item_view__second);
            com_duokan_reader_ui_general_deprecatedDkTextView.setText(c.getChilidLine());
            com_duokan_reader_ui_general_deprecatedDkTextView.setUseBitmapCache(true);
        }
        return view;
    }

    public int c() {
        return this.a.b == null ? 0 : this.a.b.length;
    }

    public DkStoreBookTocInfo c(int i) {
        if (this.a.b == null || this.a.b.length <= i) {
            return null;
        }
        return this.a.b[i];
    }

    protected void e(int i) {
    }

    protected void b() {
    }
}
