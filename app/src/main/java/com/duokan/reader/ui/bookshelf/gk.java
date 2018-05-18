package com.duokan.reader.ui.bookshelf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.common.CommonUtils;
import com.duokan.common.FileTypeRecognizer;
import com.duokan.core.ui.aj;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;
import com.duokan.reader.ui.general.eg;

class gk extends aj {
    /* renamed from: a */
    final /* synthetic */ gf f6517a;

    private gk(gf gfVar) {
        this.f6517a = gfVar;
    }

    /* renamed from: d */
    public /* synthetic */ Object mo509d(int i) {
        return m9735c(i);
    }

    /* renamed from: c */
    public int mo506c() {
        if (mo486a() == 0) {
            return 0;
        }
        int i = 0;
        for (ha a : this.f6517a.f6508g) {
            i = a.m9760a() + i;
        }
        return i;
    }

    /* renamed from: a */
    public int mo486a() {
        return this.f6517a.f6508g == null ? 0 : this.f6517a.f6508g.size();
    }

    /* renamed from: a */
    public int mo487a(int i) {
        if (mo486a() == 0) {
            return 0;
        }
        return ((ha) this.f6517a.f6508g.get(i)).m9760a();
    }

    /* renamed from: c */
    public ImportedFileInfo m9735c(int i) {
        for (int i2 = 0; i2 < this.f6517a.f6508g.size(); i2++) {
            ha haVar = (ha) this.f6517a.f6508g.get(i2);
            int a = haVar.m9760a();
            if (i >= 0 && i < a) {
                return (ImportedFileInfo) haVar.m9762b().get(i);
            }
            i -= a;
        }
        return null;
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f6517a.getContext()).inflate(C0256h.bookshelf__shared__empty_view, viewGroup, false);
        inflate.findViewById(C0255g.bookshelf__shared__empty_view__action).setVisibility(8);
        inflate.findViewById(C0255g.bookshelf__shared__empty_view__text).setVisibility(8);
        ((TextView) inflate.findViewById(C0255g.bookshelf__shared__empty_view__description)).setText(C0258j.bookshelf__file_browser_empty_view_msg);
        return inflate;
    }

    /* renamed from: a */
    public View mo488a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f6517a.getContext()).inflate(C0256h.bookshelf__file_import_dir_view, viewGroup, false);
        }
        CheckBox checkBox = (CheckBox) view.findViewById(C0255g.bookshelf__file_import_dir_view__select);
        ha haVar = (ha) this.f6517a.f6508g.get(i);
        ((TextView) view.findViewById(C0255g.bookshelf__file_import_dir_view__path)).setText(haVar.m9085d());
        if (haVar.m9087f() == FileStatus.IMPORTED) {
            checkBox.setVisibility(4);
        } else {
            boolean z;
            if (haVar.m9087f() == FileStatus.SELECTED) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
            checkBox.setVisibility(0);
        }
        checkBox.setFocusableInTouchMode(false);
        checkBox.setClickable(false);
        view.setOnClickListener(new gl(this, haVar));
        view.setBackgroundDrawable(eg.m10554a(this.f6517a.getContext(), this.f6517a.f6510i, i));
        return view;
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f6517a.getContext()).inflate(C0256h.bookshelf__file_import_item_view, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(C0255g.bookshelf__file_import_item_view__icon);
        TextView textView = (TextView) view.findViewById(C0255g.bookshelf__file_import_item_view__first_line);
        TextView textView2 = (TextView) view.findViewById(C0255g.bookshelf__file_import_item_view__second_line);
        TextView textView3 = (TextView) view.findViewById(C0255g.bookshelf__file_import_item_view__msg);
        CheckBox checkBox = (CheckBox) view.findViewById(C0255g.bookshelf__file_import_item_view__check_box);
        ImportedFileInfo c = m9735c(i);
        textView.setText(CommonUtils.m610c(c.m9084c()));
        textView2.setText(String.format(this.f6517a.getContext().getString(C0258j.file_type), new Object[]{CommonUtils.m601a(c.m9085d())}) + " / " + String.format(this.f6517a.getContext().getString(C0258j.file_size), new Object[]{CommonUtils.m599a(c.m9086e())}));
        if (c.m9087f() == FileStatus.IMPORTED) {
            checkBox.setVisibility(8);
            textView3.setVisibility(0);
        } else {
            checkBox.setVisibility(0);
            textView3.setVisibility(8);
            checkBox.setChecked(c.m9087f() == FileStatus.SELECTED);
            checkBox.setFocusableInTouchMode(false);
            checkBox.setClickable(false);
        }
        imageView.setImageResource(gu.m9742a(FileTypeRecognizer.m567a(c.m9084c())));
        return view;
    }
}
