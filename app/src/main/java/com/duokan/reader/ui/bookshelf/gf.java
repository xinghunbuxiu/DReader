package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.duokan.core.ui.HatGridView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.eg;
import java.util.List;

public class gf extends FrameLayout {
    /* renamed from: a */
    private HeaderView f6502a;
    /* renamed from: b */
    private DkLabelView f6503b;
    /* renamed from: c */
    private DkLabelView f6504c;
    /* renamed from: d */
    private int f6505d;
    /* renamed from: e */
    private String f6506e;
    /* renamed from: f */
    private gk f6507f;
    /* renamed from: g */
    private List<ha> f6508g;
    /* renamed from: h */
    private final gd f6509h;
    /* renamed from: i */
    private HatGridView f6510i;
    /* renamed from: j */
    private int f6511j = 0;

    public gf(Context context, gd gdVar, Runnable runnable) {
        super(context);
        this.f6509h = gdVar;
        m9716a(runnable);
        this.f6505d = 0;
    }

    /* renamed from: a */
    public void m9728a(List<ha> list) {
        this.f6505d = 0;
        this.f6508g = list;
        this.f6502a.setLeftTitle(getContext().getString(C0258j.scanresult) + "(" + this.f6508g.size() + ")");
        this.f6511j = getCanSelectNum();
        this.f6510i.setVisibility(0);
        m9718b();
    }

    /* renamed from: a */
    public void m9726a() {
        this.f6505d = 0;
        this.f6502a.setLeftTitle(getContext().getString(C0258j.scanresult) + "(" + this.f6509h.mo1710a() + ")");
        this.f6508g = this.f6509h.mo1711b();
        this.f6511j = getCanSelectNum();
        this.f6510i.setVisibility(0);
        m9718b();
    }

    /* renamed from: a */
    private void m9716a(Runnable runnable) {
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__file_import_view, null);
        this.f6502a = (HeaderView) inflate.findViewById(C0255g.bookshelf__file_import_view__title_view);
        this.f6502a.setLeftTitle(getContext().getString(C0258j.scanresult));
        this.f6504c = (DkLabelView) this.f6502a.findViewById(C0255g.bookshelf__file_import_view__title_select);
        this.f6504c.setText(getContext().getString(C0258j.bookshelf__file_import_view__all));
        this.f6504c.setOnClickListener(new gg(this));
        this.f6510i = (HatGridView) inflate.findViewById(C0255g.bookshelf__file_import_view__list);
        this.f6507f = new gk();
        this.f6510i.setAdapter(this.f6507f);
        this.f6510i.setOnItemClickListener(new gh(this));
        eg.m10555a(this.f6510i);
        this.f6503b = (DkLabelView) inflate.findViewById(C0255g.bookshelf__file_add_view__text);
        this.f6506e = getContext().getString(C0258j.import_confirm);
        this.f6503b.setText(String.format(this.f6506e, new Object[]{Integer.valueOf(this.f6505d)}));
        this.f6503b.setOnClickListener(new gi(this, runnable));
        this.f6510i.setVisibility(4);
        addView(inflate);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 != i && this.f6510i != null) {
            this.f6510i.setNumColumns(eg.m10551a(getContext(), i));
        }
    }

    /* renamed from: b */
    private void m9718b() {
        boolean z;
        boolean z2 = true;
        this.f6507f.mo1691d();
        this.f6503b.setEnabled(this.f6511j != 0);
        DkLabelView dkLabelView = this.f6503b;
        if (this.f6511j == 0) {
            z = true;
        } else {
            z = false;
        }
        dkLabelView.setSelected(z);
        this.f6503b.setText(String.format(this.f6506e, new Object[]{Integer.valueOf(Math.max(0, this.f6505d))}));
        if (this.f6511j == 0) {
            this.f6504c.setText(getContext().getString(C0258j.bookshelf__file_import_view__all));
        } else {
            this.f6504c.setText(getContext().getString(this.f6505d == this.f6511j ? C0258j.bookshelf__file_import_view__inverse : C0258j.bookshelf__file_import_view__all));
        }
        dkLabelView = this.f6504c;
        if (this.f6511j != 0) {
            z = true;
        } else {
            z = false;
        }
        dkLabelView.setEnabled(z);
        DkLabelView dkLabelView2 = this.f6504c;
        if (this.f6511j != 0) {
            z2 = false;
        }
        dkLabelView2.setSelected(z2);
    }

    /* renamed from: a */
    private void m9714a(int i) {
        if (this.f6508g != null) {
            ImportedFileInfo importedFileInfo;
            int i2 = 0;
            ha haVar = null;
            while (i2 < this.f6508g.size()) {
                haVar = (ha) this.f6508g.get(i2);
                int a = haVar.m9760a();
                if (i >= 0 && i < a) {
                    importedFileInfo = (ImportedFileInfo) haVar.m9762b().get(i);
                    break;
                } else {
                    i -= a;
                    i2++;
                }
            }
            importedFileInfo = null;
            if (haVar != null && importedFileInfo != null && haVar.m9087f() != FileStatus.IMPORTED && importedFileInfo.m9087f() != FileStatus.IMPORTED) {
                if (importedFileInfo.m9087f() == FileStatus.SELECTED) {
                    importedFileInfo.m9083a(FileStatus.UNSELECTED);
                    this.f6505d--;
                } else {
                    importedFileInfo.m9083a(FileStatus.SELECTED);
                    this.f6505d++;
                }
                haVar.m9083a(FileStatus.SELECTED);
                for (ImportedFileInfo importedFileInfo2 : haVar.m9762b()) {
                    if (importedFileInfo2.m9087f() == FileStatus.UNSELECTED) {
                        haVar.m9083a(FileStatus.UNSELECTED);
                        break;
                    }
                }
                m9718b();
            }
        }
    }

    /* renamed from: c */
    private void m9719c() {
        if (this.f6508g != null) {
            this.f6505d = 0;
            for (ha haVar : this.f6508g) {
                for (ImportedFileInfo importedFileInfo : haVar.m9762b()) {
                    if (importedFileInfo.m9087f() == FileStatus.UNSELECTED) {
                        importedFileInfo.m9083a(FileStatus.SELECTED);
                        haVar.m9083a(FileStatus.SELECTED);
                        this.f6505d++;
                    } else if (importedFileInfo.m9087f() == FileStatus.SELECTED) {
                        this.f6505d++;
                    }
                }
            }
            m9718b();
        }
    }

    /* renamed from: d */
    private void m9722d() {
        if (this.f6508g != null) {
            this.f6505d = 0;
            for (ha haVar : this.f6508g) {
                for (ImportedFileInfo importedFileInfo : haVar.m9762b()) {
                    if (importedFileInfo.m9087f() == FileStatus.SELECTED) {
                        importedFileInfo.m9083a(FileStatus.UNSELECTED);
                        haVar.m9083a(FileStatus.UNSELECTED);
                    }
                }
            }
            m9718b();
        }
    }

    private int getCanSelectNum() {
        if (this.f6508g == null) {
            return 0;
        }
        int i = 0;
        for (ha b : this.f6508g) {
            for (ImportedFileInfo f : b.m9762b()) {
                if (f.m9087f() != FileStatus.IMPORTED) {
                    i++;
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    public void m9727a(ha haVar) {
        FileStatus f = haVar.m9087f();
        if (f != FileStatus.IMPORTED) {
            for (ImportedFileInfo importedFileInfo : haVar.m9762b()) {
                if (importedFileInfo.m9087f() != FileStatus.IMPORTED) {
                    this.f6505d = (f == FileStatus.SELECTED ? -1 : 1) + this.f6505d;
                    importedFileInfo.m9083a(f == FileStatus.SELECTED ? FileStatus.UNSELECTED : FileStatus.SELECTED);
                }
            }
            haVar.m9083a(f == FileStatus.SELECTED ? FileStatus.UNSELECTED : FileStatus.SELECTED);
            m9718b();
        }
    }
}
