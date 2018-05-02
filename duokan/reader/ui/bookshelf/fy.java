package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.duokan.core.ui.HatGridView;
import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.eh;

import java.util.List;

public class fy extends FrameLayout {
    private HeaderView a;
    private DkLabelView b;
    private DkLabelView c;
    private int d;
    private String e;
    private gd f;
    private List g;
    private final fw h;
    private HatGridView i;
    private int j = 0;

    public fy(Context context, fw fwVar, Runnable runnable) {
        super(context);
        this.h = fwVar;
        a(runnable);
        this.d = 0;
    }

    public void a(List list) {
        this.d = 0;
        this.g = list;
        this.a.setLeftTitle(getContext().getString(j.scanresult) + "(" + this.g.size() + ")");
        this.j = getCanSelectNum();
        this.i.setVisibility(0);
        b();
    }

    public void a() {
        this.d = 0;
        this.a.setLeftTitle(getContext().getString(j.scanresult) + "(" + this.h.a() + ")");
        this.g = this.h.b();
        this.j = getCanSelectNum();
        this.i.setVisibility(0);
        b();
    }

    private void a(Runnable runnable) {
        View inflate = LayoutInflater.from(getContext()).inflate(h.bookshelf__file_import_view, null);
        this.a = (HeaderView) inflate.findViewById(g.bookshelf__file_import_view__title_view);
        this.a.setLeftTitle(getContext().getString(j.scanresult));
        this.c = (DkLabelView) this.a.findViewById(g.bookshelf__file_import_view__title_select);
        this.c.setText(getContext().getString(j.bookshelf__file_import_view__all));
        this.c.setOnClickListener(new fz(this));
        this.i = (HatGridView) inflate.findViewById(g.bookshelf__file_import_view__list);
        this.f = new gd();
        this.i.setAdapter(this.f);
        this.i.setOnItemClickListener(new ga(this));
        eh.a(this.i);
        this.b = (DkLabelView) inflate.findViewById(g.bookshelf__file_add_view__text);
        this.e = getContext().getString(j.import_confirm);
        this.b.setText(String.format(this.e, new Object[]{Integer.valueOf(this.d)}));
        this.b.setOnClickListener(new gb(this, runnable));
        this.i.setVisibility(4);
        addView(inflate);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 != i && this.i != null) {
            this.i.setNumColumns(eh.a(getContext(), i));
        }
    }

    private void b() {
        boolean z;
        boolean z2 = true;
        this.f.d();
        this.b.setEnabled(this.j != 0);
        DkLabelView dkLabelView = this.b;
        if (this.j == 0) {
            z = true;
        } else {
            z = false;
        }
        dkLabelView.setSelected(z);
        this.b.setText(String.format(this.e, new Object[]{Integer.valueOf(Math.max(0, this.d))}));
        if (this.j == 0) {
            this.c.setText(getContext().getString(j.bookshelf__file_import_view__all));
        } else {
            this.c.setText(getContext().getString(this.d == this.j ? j.bookshelf__file_import_view__inverse : j.bookshelf__file_import_view__all));
        }
        dkLabelView = this.c;
        if (this.j != 0) {
            z = true;
        } else {
            z = false;
        }
        dkLabelView.setEnabled(z);
        DkLabelView dkLabelView2 = this.c;
        if (this.j != 0) {
            z2 = false;
        }
        dkLabelView2.setSelected(z2);
    }

    private void a(int i) {
        if (this.g != null) {
            ImportedFileInfo importedFileInfo;
            int i2 = 0;
            gt gtVar = null;
            while (i2 < this.g.size()) {
                gtVar = (gt) this.g.get(i2);
                int a = gtVar.a();
                if (i >= 0 && i < a) {
                    importedFileInfo = (ImportedFileInfo) gtVar.b().get(i);
                    break;
                } else {
                    i -= a;
                    i2++;
                }
            }
            importedFileInfo = null;
            if (gtVar != null && importedFileInfo != null && gtVar.f() != FileStatus.IMPORTED && importedFileInfo.f() != FileStatus.IMPORTED) {
                if (importedFileInfo.f() == FileStatus.SELECTED) {
                    importedFileInfo.a(FileStatus.UNSELECTED);
                    this.d--;
                } else {
                    importedFileInfo.a(FileStatus.SELECTED);
                    this.d++;
                }
                gtVar.a(FileStatus.SELECTED);
                for (ImportedFileInfo importedFileInfo2 : gtVar.b()) {
                    if (importedFileInfo2.f() == FileStatus.UNSELECTED) {
                        gtVar.a(FileStatus.UNSELECTED);
                        break;
                    }
                }
                b();
            }
        }
    }

    private void c() {
        if (this.g != null) {
            this.d = 0;
            for (gt gtVar : this.g) {
                for (ImportedFileInfo importedFileInfo : gtVar.b()) {
                    if (importedFileInfo.f() == FileStatus.UNSELECTED) {
                        importedFileInfo.a(FileStatus.SELECTED);
                        gtVar.a(FileStatus.SELECTED);
                        this.d++;
                    } else if (importedFileInfo.f() == FileStatus.SELECTED) {
                        this.d++;
                    }
                }
            }
            b();
        }
    }

    private void d() {
        if (this.g != null) {
            this.d = 0;
            for (gt gtVar : this.g) {
                for (ImportedFileInfo importedFileInfo : gtVar.b()) {
                    if (importedFileInfo.f() == FileStatus.SELECTED) {
                        importedFileInfo.a(FileStatus.UNSELECTED);
                        gtVar.a(FileStatus.UNSELECTED);
                    }
                }
            }
            b();
        }
    }

    private int getCanSelectNum() {
        if (this.g == null) {
            return 0;
        }
        int i = 0;
        for (gt b : this.g) {
            for (ImportedFileInfo f : b.b()) {
                if (f.f() != FileStatus.IMPORTED) {
                    i++;
                }
            }
        }
        return i;
    }

    public void a(gt gtVar) {
        FileStatus f = gtVar.f();
        if (f != FileStatus.IMPORTED) {
            for (ImportedFileInfo importedFileInfo : gtVar.b()) {
                if (importedFileInfo.f() != FileStatus.IMPORTED) {
                    this.d = (f == FileStatus.SELECTED ? -1 : 1) + this.d;
                    importedFileInfo.a(f == FileStatus.SELECTED ? FileStatus.UNSELECTED : FileStatus.SELECTED);
                }
            }
            gtVar.a(f == FileStatus.SELECTED ? FileStatus.UNSELECTED : FileStatus.SELECTED);
            b();
        }
    }
}
