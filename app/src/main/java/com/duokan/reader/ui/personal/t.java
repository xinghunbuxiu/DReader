package com.duokan.reader.ui.personal;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.duokan.c.d;
import com.duokan.core.app.x;
import com.duokan.reader.domain.micloud.bj;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.DkListView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.eh;
import com.duokan.reader.ui.personal.BooksUploadController.UploadBookStatus;

import java.util.LinkedList;
import java.util.List;

public class t extends FrameLayout {
    private HeaderView a;
    private DkListView b;
    private DkLabelView c;
    private DkLabelView d;
    private TextView e;
    private View f;
    private int g;
    private long h;
    private String i;
    private int j;
    private u k;
    private List l;

    public void a(int i, List list) {
        this.b.setVisibility(0);
        this.g = 0;
        this.h = 0;
        this.l = list;
        this.a.setLeftTitle(getContext().getString(j.bookshelf__file_upload_view__title) + "(" + i + ")");
        this.j = 0;
        for (s sVar : list) {
            this.j = sVar.e() + this.j;
        }
        a();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 != i && this.b != null) {
            this.b.setNumColumns(eh.a(getContext(), i));
        }
    }

    private List getSelectedUploadBookInfos() {
        List linkedList = new LinkedList();
        int a = this.k.a();
        for (int i = 0; i < a; i++) {
            for (r rVar : ((s) this.l.get(i)).b()) {
                if (rVar.d() == UploadBookStatus.SELECTED) {
                    linkedList.add(rVar);
                }
            }
        }
        return linkedList;
    }

    private void a() {
        this.k.d();
        this.f.setVisibility(0);
        bj a = ((com.duokan.reader.ui.bookshelf.bj) x.a(getContext()).queryFeature(com.duokan.reader.ui.bookshelf.bj.class)).a();
        if (this.h > 0) {
            this.c.setText(String.format(this.i, new Object[]{i.a(this.h)}));
            if (this.h > a.b) {
                this.d.setVisibility(0);
                this.d.setText(getResources().getString(j.bookshelf__file_upload_view__quota_waring, new Object[]{i.a(a.b)}));
                this.c.setEnabled(false);
                this.c.setSelected(true);
                this.c.setTextColor(getResources().getColor(d.general__shared__888888));
            } else {
                this.d.setVisibility(8);
                this.c.setEnabled(true);
                this.c.setSelected(false);
                this.c.setTextColor(getResources().getColor(d.general__shared__ffffff));
            }
        } else {
            this.d.setVisibility(8);
            this.c.setText(j.bookshelf__file_upload_view__upload);
            this.c.setEnabled(false);
            this.c.setSelected(true);
            this.c.setTextColor(getResources().getColor(d.general__shared__888888));
        }
        if (this.g < this.j) {
            this.e.setText(j.bookshelf__upload_books_view__select_all);
        } else {
            this.e.setText(j.bookshelf__upload_books_view__unselect_all);
        }
        if (this.l == null || this.l.isEmpty()) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
        }
    }

    private void a(int i) {
        if (this.l != null) {
            s sVar = (s) this.l.get(i);
            if (sVar.f()) {
                if (sVar.c() == UploadBookStatus.SELECTED) {
                    sVar.a(UploadBookStatus.UNSELECTED);
                    for (r rVar : sVar.b()) {
                        if (rVar.e() && rVar.d() == UploadBookStatus.SELECTED) {
                            this.g--;
                            this.h -= rVar.c();
                            rVar.a(UploadBookStatus.UNSELECTED);
                        }
                    }
                } else {
                    sVar.a(UploadBookStatus.SELECTED);
                    for (r rVar2 : sVar.b()) {
                        if (rVar2.e() && rVar2.d() != UploadBookStatus.SELECTED) {
                            rVar2.a(UploadBookStatus.SELECTED);
                            this.h += rVar2.c();
                            this.g++;
                        }
                    }
                }
                a();
            }
        }
    }
}
