package com.duokan.reader.ui.bookshelf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.common.CommonUtils;
import com.duokan.common.FileTypeRecognizer;
import com.duokan.core.ui.aj;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;
import com.duokan.reader.ui.general.DkLabelView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class fe extends aj {
    /* renamed from: a */
    List<ImportedFileInfo> f6438a;
    /* renamed from: c */
    final /* synthetic */ ey f6439c;

    private fe(ey eyVar) {
        this.f6439c = eyVar;
        this.f6438a = new ArrayList();
    }

    /* renamed from: d */
    public /* synthetic */ Object mo509d(int i) {
        return m9607c(i);
    }

    /* renamed from: a */
    public void m9603a(List<ImportedFileInfo> list) {
        int intValue;
        this.f6438a = list;
        mo1691d();
        if (this.f6439c.f6427h.containsKey(this.f6439c.f6424e)) {
            intValue = ((Integer) this.f6439c.f6427h.get(this.f6439c.f6424e)).intValue();
        } else {
            intValue = 0;
        }
        this.f6439c.f6420a.scrollTo(0, intValue);
    }

    /* renamed from: b */
    public List<ImportedFileInfo> m9605b() {
        return this.f6438a;
    }

    /* renamed from: a */
    public void m9604a(boolean z) {
        for (ImportedFileInfo importedFileInfo : this.f6438a) {
            if (z) {
                if (importedFileInfo.m9087f() == FileStatus.UNSELECTED) {
                    importedFileInfo.m9083a(FileStatus.SELECTED);
                }
            } else if (importedFileInfo.m9087f() == FileStatus.SELECTED) {
                importedFileInfo.m9083a(FileStatus.UNSELECTED);
            }
        }
        mo1691d();
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f6438a == null ? 0 : this.f6438a.size();
    }

    /* renamed from: c */
    public ImportedFileInfo m9607c(int i) {
        if (this.f6438a == null || this.f6438a.size() <= i) {
            return null;
        }
        return (ImportedFileInfo) this.f6438a.get(i);
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f6439c.getContext()).inflate(C0256h.bookshelf__shared__empty_view, viewGroup, false);
        inflate.findViewById(C0255g.bookshelf__shared__empty_view__action).setVisibility(8);
        inflate.findViewById(C0255g.bookshelf__shared__empty_view__text).setVisibility(8);
        ((TextView) inflate.findViewById(C0255g.bookshelf__shared__empty_view__description)).setText(C0258j.bookshelf__file_browser_view__empty_dir);
        return inflate;
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        fh fhVar;
        if (view == null) {
            fh fhVar2 = new fh();
            view = LayoutInflater.from(this.f6439c.getContext()).inflate(C0256h.bookshelf__file_browser_item_view, viewGroup, false);
            fhVar2.f6450d = new fg(this, view.findViewById(C0255g.bookshelf__file_browser_item_view__action));
            fhVar2.f6447a = (ImageView) view.findViewById(C0255g.bookshelf__file_browser_item_view__icon);
            fhVar2.f6448b = (TextView) view.findViewById(C0255g.bookshelf__file_browser_item_view__value_text);
            fhVar2.f6449c = (TextView) view.findViewById(C0255g.bookshelf__file_browser_item_view__file_attr);
            view.setTag(fhVar2);
            fhVar = fhVar2;
        } else {
            fhVar = (fh) view.getTag();
        }
        ImportedFileInfo c = m9607c(i);
        File file = new File(c.m9084c());
        fhVar.f6450d.f6445d.setOnClickListener(null);
        if (file.isDirectory()) {
            fhVar.f6447a.setImageResource(C0254f.general__shared__folder_icon);
            if (file.listFiles() != null) {
                fhVar.f6449c.setText(file.listFiles().length + this.f6439c.getContext().getString(C0258j.file_num));
            } else {
                fhVar.f6449c.setText("");
            }
            CharSequence d = c.m9085d();
            if (d != null) {
                fhVar.f6448b.setText(d);
                fhVar.f6450d.m9611a();
            }
        } else {
            fhVar.f6447a.setImageResource(gu.m9742a(FileTypeRecognizer.m567a(c.m9084c())));
            fhVar.f6449c.setText(String.format(this.f6439c.getContext().getString(C0258j.file_type), new Object[]{r4.toString()}) + " / " + String.format(this.f6439c.getContext().getString(C0258j.file_size), new Object[]{CommonUtils.m599a(c.m9086e())}));
            fhVar.f6448b.setText(CommonUtils.m610c(c.m9084c()));
            if (c.m9087f() == FileStatus.IMPORTED) {
                fhVar.f6450d.m9613b();
            } else {
                boolean z;
                fg fgVar = fhVar.f6450d;
                if (c.m9087f() == FileStatus.SELECTED) {
                    z = true;
                } else {
                    z = false;
                }
                fgVar.m9612a(z);
                fhVar.f6450d.f6445d.setOnClickListener(new ff(this, i));
            }
        }
        return view;
    }

    /* renamed from: d */
    public void mo1691d() {
        boolean z = true;
        super.mo1691d();
        int e = m9599e();
        this.f6439c.f6422c.setText(String.format(this.f6439c.f6423d, new Object[]{Integer.valueOf(e)}));
        boolean f = m9600f();
        DkLabelView g = this.f6439c.f6422c;
        if (f) {
            z = false;
        }
        g.setEnabled(z);
        this.f6439c.f6422c.setSelected(f);
        if (this.f6439c.f6426g != null) {
            this.f6439c.f6426g.mo1700a(m9601g(), f);
        }
    }

    /* renamed from: e */
    private int m9599e() {
        int i = 0;
        for (ImportedFileInfo f : this.f6438a) {
            int i2;
            if (f.m9087f() == FileStatus.SELECTED) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i = i2 + i;
        }
        return i;
    }

    /* renamed from: f */
    private boolean m9600f() {
        for (ImportedFileInfo f : this.f6438a) {
            if (f.m9087f() != FileStatus.IMPORTED) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    private boolean m9601g() {
        for (ImportedFileInfo f : this.f6438a) {
            if (f.m9087f() == FileStatus.UNSELECTED) {
                return false;
            }
        }
        return true;
    }
}
