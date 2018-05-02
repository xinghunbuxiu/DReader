package com.duokan.reader.ui.bookshelf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.common.FileTypeRecognizer;
import com.duokan.core.ui.aj;
import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;
import com.duokan.reader.ui.general.DkLabelView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class ex extends aj {
    List a;
    final /* synthetic */ er c;

    private ex(er erVar) {
        this.c = erVar;
        this.a = new ArrayList();
    }

    public /* synthetic */ Object d(int i) {
        return c(i);
    }

    public void a(List list) {
        int intValue;
        this.a = list;
        d();
        if (this.c.h.containsKey(this.c.e)) {
            intValue = ((Integer) this.c.h.get(this.c.e)).intValue();
        } else {
            intValue = 0;
        }
        this.c.a.scrollTo(0, intValue);
    }

    public List b() {
        return this.a;
    }

    public void a(boolean z) {
        for (ImportedFileInfo importedFileInfo : this.a) {
            if (z) {
                if (importedFileInfo.f() == FileStatus.UNSELECTED) {
                    importedFileInfo.a(FileStatus.SELECTED);
                }
            } else if (importedFileInfo.f() == FileStatus.SELECTED) {
                importedFileInfo.a(FileStatus.UNSELECTED);
            }
        }
        d();
    }

    public int c() {
        return this.a == null ? 0 : this.a.size();
    }

    public ImportedFileInfo c(int i) {
        if (this.a == null || this.a.size() <= i) {
            return null;
        }
        return (ImportedFileInfo) this.a.get(i);
    }

    public View a(View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.c.getContext()).inflate(h.bookshelf__shared__empty_view, viewGroup, false);
        inflate.findViewById(g.bookshelf__shared__empty_view__action).setVisibility(8);
        inflate.findViewById(g.bookshelf__shared__empty_view__text).setVisibility(8);
        ((TextView) inflate.findViewById(g.bookshelf__shared__empty_view__description)).setText(j.bookshelf__file_browser_view__empty_dir);
        return inflate;
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        fa faVar;
        if (view == null) {
            fa faVar2 = new fa();
            view = LayoutInflater.from(this.c.getContext()).inflate(h.bookshelf__file_browser_item_view, viewGroup, false);
            faVar2.d = new ez(this, view.findViewById(g.bookshelf__file_browser_item_view__action));
            faVar2.a = (ImageView) view.findViewById(g.bookshelf__file_browser_item_view__icon);
            faVar2.b = (TextView) view.findViewById(g.bookshelf__file_browser_item_view__value_text);
            faVar2.c = (TextView) view.findViewById(g.bookshelf__file_browser_item_view__file_attr);
            view.setTag(faVar2);
            faVar = faVar2;
        } else {
            faVar = (fa) view.getTag();
        }
        ImportedFileInfo c = c(i);
        File file = new File(c.c());
        faVar.d.d.setOnClickListener(null);
        if (file.isDirectory()) {
            faVar.a.setImageResource(f.general__shared__folder_icon);
            if (file.listFiles() != null) {
                faVar.c.setText(file.listFiles().length + this.c.getContext().getString(j.file_num));
            } else {
                faVar.c.setText("");
            }
            CharSequence d = c.d();
            if (d != null) {
                faVar.b.setText(d);
                faVar.d.a();
            }
        } else {
            faVar.a.setImageResource(gn.a(FileTypeRecognizer.a(c.c())));
            faVar.c.setText(String.format(this.c.getContext().getString(j.file_type), new Object[]{r4.toString()}) + " / " + String.format(this.c.getContext().getString(j.file_size), new Object[]{i.a(c.e())}));
            faVar.b.setText(i.c(c.c()));
            if (c.f() == FileStatus.IMPORTED) {
                faVar.d.b();
            } else {
                boolean z;
                ez ezVar = faVar.d;
                if (c.f() == FileStatus.SELECTED) {
                    z = true;
                } else {
                    z = false;
                }
                ezVar.a(z);
                faVar.d.d.setOnClickListener(new ey(this, i));
            }
        }
        return view;
    }

    public void d() {
        boolean z = true;
        super.d();
        int e = e();
        this.c.c.setText(String.format(this.c.d, new Object[]{Integer.valueOf(e)}));
        boolean f = f();
        DkLabelView g = this.c.c;
        if (f) {
            z = false;
        }
        g.setEnabled(z);
        this.c.c.setSelected(f);
        if (this.c.g != null) {
            this.c.g.a(g(), f);
        }
    }

    private int e() {
        int i = 0;
        for (ImportedFileInfo f : this.a) {
            int i2;
            if (f.f() == FileStatus.SELECTED) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i = i2 + i;
        }
        return i;
    }

    private boolean f() {
        for (ImportedFileInfo f : this.a) {
            if (f.f() != FileStatus.IMPORTED) {
                return false;
            }
        }
        return true;
    }

    private boolean g() {
        for (ImportedFileInfo f : this.a) {
            if (f.f() == FileStatus.UNSELECTED) {
                return false;
            }
        }
        return true;
    }
}
