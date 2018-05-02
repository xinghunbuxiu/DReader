package com.duokan.reader.ui.personal;

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
import com.duokan.core.ui.aw;
import com.duokan.core.ui.w;
import com.duokan.reader.ui.bookshelf.gn;
import com.duokan.reader.ui.general.eh;
import com.duokan.reader.ui.personal.BooksUploadController.UploadBookStatus;

class u extends aw implements w {
    final /* synthetic */ t a;

    public /* synthetic */ Object d(int i) {
        return b(i);
    }

    public int a() {
        return this.a.l == null ? 0 : this.a.l.size();
    }

    public int a(int i) {
        return this.a.l == null ? 0 : ((s) this.a.l.get(i)).d();
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.findViewById(g.bookshelf__file_upload_dir_view__path) == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.bookshelf__file_upload_dir_view, viewGroup, false);
        }
        CheckBox checkBox = (CheckBox) view.findViewById(g.bookshelf__file_upload_dir_view__select);
        s sVar = (s) this.a.l.get(i);
        ((TextView) view.findViewById(g.bookshelf__file_upload_dir_view__path)).setText(sVar.a());
        if (sVar.f()) {
            boolean z;
            if (sVar.c() == UploadBookStatus.SELECTED) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
            checkBox.setVisibility(0);
        } else {
            checkBox.setVisibility(4);
        }
        checkBox.setFocusableInTouchMode(false);
        checkBox.setClickable(false);
        view.setOnClickListener(new v(this, i));
        view.setBackgroundDrawable(eh.a(this.a.getContext(), this.a.b, i));
        return view;
    }

    public int c() {
        if (this.a.l == null) {
            return 0;
        }
        int i = 0;
        for (s d : this.a.l) {
            i = d.d() + i;
        }
        return i;
    }

    public r b(int i) {
        int i2 = 0;
        int a = a();
        int i3 = 0;
        while (i2 < a) {
            int a2 = a(i2);
            if (i < i3 + a2) {
                return (r) ((s) this.a.l.get(i2)).b().get(i - i3);
            }
            i3 += a2;
            i2++;
        }
        return null;
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        r b = b(i);
        if (view == null || view.findViewById(g.bookshelf__file_upload_item_view__icon) == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.bookshelf__file_upload_item_view, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(g.bookshelf__file_upload_item_view__icon);
        TextView textView = (TextView) view.findViewById(g.bookshelf__file_upload_item_view__attrs);
        TextView textView2 = (TextView) view.findViewById(g.bookshelf__file_upload_item_view__msg);
        CheckBox checkBox = (CheckBox) view.findViewById(g.bookshelf__file_upload_item_view__check_box);
        ((TextView) view.findViewById(g.bookshelf__file_upload_item_view__name)).setText(i.d(b.b()));
        String a = i.a(b.b());
        textView.setText((a != null ? a.toUpperCase() : "") + " | " + i.a(b.c()));
        if (b.e()) {
            boolean z;
            checkBox.setVisibility(0);
            textView2.setVisibility(8);
            if (b.d() == UploadBookStatus.SELECTED) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
            checkBox.setFocusableInTouchMode(false);
            checkBox.setClickable(false);
        } else {
            checkBox.setVisibility(8);
            textView2.setVisibility(0);
            textView2.setText(b.d() == UploadBookStatus.UPLOADED ? j.bookshelf__shared__file_same_name : j.bookshelf__shared__file_not_exist);
        }
        imageView.setImageResource(gn.b(FileTypeRecognizer.a(b.b())));
        return view;
    }

    public View a(View view, ViewGroup viewGroup) {
        return LayoutInflater.from(this.a.getContext()).inflate(h.bookshelf__books_upload_emtpy_view, viewGroup, false);
    }
}
