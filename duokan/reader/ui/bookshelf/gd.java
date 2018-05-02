package com.duokan.reader.ui.bookshelf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.common.FileTypeRecognizer;
import com.duokan.core.ui.aj;
import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;
import com.duokan.reader.ui.general.eh;

class gd extends aj {
    final /* synthetic */ fy a;

    private gd(fy fyVar) {
        this.a = fyVar;
    }

    public /* synthetic */ Object d(int i) {
        return c(i);
    }

    public int c() {
        if (a() == 0) {
            return 0;
        }
        int i = 0;
        for (gt a : this.a.g) {
            i = a.a() + i;
        }
        return i;
    }

    public int a() {
        return this.a.g == null ? 0 : this.a.g.size();
    }

    public int a(int i) {
        if (a() == 0) {
            return 0;
        }
        return ((gt) this.a.g.get(i)).a();
    }

    public ImportedFileInfo c(int i) {
        for (int i2 = 0; i2 < this.a.g.size(); i2++) {
            gt gtVar = (gt) this.a.g.get(i2);
            int a = gtVar.a();
            if (i >= 0 && i < a) {
                return (ImportedFileInfo) gtVar.b().get(i);
            }
            i -= a;
        }
        return null;
    }

    public View a(View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.a.getContext()).inflate(h.bookshelf__shared__empty_view, viewGroup, false);
        inflate.findViewById(g.bookshelf__shared__empty_view__action).setVisibility(8);
        inflate.findViewById(g.bookshelf__shared__empty_view__text).setVisibility(8);
        ((TextView) inflate.findViewById(g.bookshelf__shared__empty_view__description)).setText(j.bookshelf__file_browser_empty_view_msg);
        return inflate;
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.bookshelf__file_import_dir_view, viewGroup, false);
        }
        CheckBox checkBox = (CheckBox) view.findViewById(g.bookshelf__file_import_dir_view__select);
        gt gtVar = (gt) this.a.g.get(i);
        ((TextView) view.findViewById(g.bookshelf__file_import_dir_view__path)).setText(gtVar.d());
        if (gtVar.f() == FileStatus.IMPORTED) {
            checkBox.setVisibility(4);
        } else {
            boolean z;
            if (gtVar.f() == FileStatus.SELECTED) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
            checkBox.setVisibility(0);
        }
        checkBox.setFocusableInTouchMode(false);
        checkBox.setClickable(false);
        view.setOnClickListener(new ge(this, gtVar));
        view.setBackgroundDrawable(eh.a(this.a.getContext(), this.a.i, i));
        return view;
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.bookshelf__file_import_item_view, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(g.bookshelf__file_import_item_view__icon);
        TextView textView = (TextView) view.findViewById(g.bookshelf__file_import_item_view__first_line);
        TextView textView2 = (TextView) view.findViewById(g.bookshelf__file_import_item_view__second_line);
        TextView textView3 = (TextView) view.findViewById(g.bookshelf__file_import_item_view__msg);
        CheckBox checkBox = (CheckBox) view.findViewById(g.bookshelf__file_import_item_view__check_box);
        ImportedFileInfo c = c(i);
        textView.setText(i.c(c.c()));
        textView2.setText(String.format(this.a.getContext().getString(j.file_type), new Object[]{i.a(c.d())}) + " / " + String.format(this.a.getContext().getString(j.file_size), new Object[]{i.a(c.e())}));
        if (c.f() == FileStatus.IMPORTED) {
            checkBox.setVisibility(8);
            textView3.setVisibility(0);
        } else {
            checkBox.setVisibility(0);
            textView3.setVisibility(8);
            checkBox.setChecked(c.f() == FileStatus.SELECTED);
            checkBox.setFocusableInTouchMode(false);
            checkBox.setClickable(false);
        }
        imageView.setImageResource(gn.a(FileTypeRecognizer.a(c.c())));
        return view;
    }
}
