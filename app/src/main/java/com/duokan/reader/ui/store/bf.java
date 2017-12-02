package com.duokan.reader.ui.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.reader.common.webservices.duokan.y;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter.ChapterState;
import com.duokan.reader.ui.general.expandable.StateExpandableAdapter;
import com.duokan.reader.ui.general.expandable.StateExpandableAdapter.ExpandableAdapterState;

class bf extends StateExpandableAdapter {
    static final /* synthetic */ boolean a = (!bc.class.desiredAssertionStatus());
    final /* synthetic */ bc c;

    bf(bc bcVar) {
        this.c = bcVar;
    }

    public int a() {
        int i = 0;
        if (this.c.c.length == 0) {
            return 0;
        }
        int length = this.c.c.length / 100;
        if (this.c.c.length % 100 > 0) {
            i = 1;
        }
        return i + length;
    }

    public int h(int i) {
        if (i == a() - 1) {
            return this.c.c.length - (i * 100);
        }
        if (this.c.c.length < 100) {
            return this.c.c.length;
        }
        return 100;
    }

    public Object i(int i) {
        return null;
    }

    public Object b(int i, int i2) {
        return this.c.c[(i * 100) + i2];
    }

    public void h() {
        if (this.c.c != null) {
            for (int i = 0; i < a(); i++) {
                for (int i2 = 0; i2 < h(i); i2++) {
                    ExpandableAdapterState expandableAdapterState = ((DkCloudFictionChapter) b(i, i2)).getChapterState().ordinal() < ChapterState.FREE.ordinal() ? ExpandableAdapterState.UNSELECT : ExpandableAdapterState.IGNORE;
                    if (c(i, i2) == ExpandableAdapterState.SELECTED && expandableAdapterState != ExpandableAdapterState.IGNORE) {
                        expandableAdapterState = ExpandableAdapterState.SELECTED;
                    }
                    a(i, i2, expandableAdapterState, false);
                }
            }
        }
    }

    public View a(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null || view.findViewById(g.store__fiction_toc_item_header_view__title) == null) {
            view = LayoutInflater.from(this.c.getContext()).inflate(h.store__fiction_toc_item_header_view, viewGroup, false);
        }
        int f = f();
        View findViewById = view.findViewById(g.store__fiction_toc_item_header_view__split);
        f = (f == -1 || f != i - 1) ? 4 : 0;
        findViewById.setVisibility(f);
        view.findViewById(g.store__fiction_toc_item_header_view__expand).setSelected(z);
        ((TextView) view.findViewById(g.store__fiction_toc_item_header_view__title)).setText(String.format(this.c.getContext().getString(j.store__fiction_chapter_view__chapter_group), new Object[]{Integer.valueOf((i * 100) + 1), Integer.valueOf((i * 100) + h(i))}));
        view.findViewById(g.store__fiction_toc_item_header_view__choice).setVisibility(4);
        return view;
    }

    public View a(int i, int i2, View view, ViewGroup viewGroup) {
        if (view == null || view.findViewById(g.store__fiction_toc_item_view__title) == null) {
            view = LayoutInflater.from(this.c.getContext()).inflate(h.store__fiction_toc_item_view, viewGroup, false);
        }
        DkCloudFictionChapter dkCloudFictionChapter = (DkCloudFictionChapter) b(i, i2);
        ((TextView) view.findViewById(g.store__fiction_toc_item_view__title)).setText(dkCloudFictionChapter.getTitle());
        TextView textView = (TextView) view.findViewById(g.store__fiction_toc_item_view__update);
        if (dkCloudFictionChapter.isFree()) {
            textView.setText(j.store__shared__free);
        } else if (new y(this.c.b.getFiction().getBookUuid()).b() == 0) {
            textView.setText(this.c.getResources().getString(j.store__shared__yuan) + String.format("%.2f", new Object[]{Float.valueOf(((float) dkCloudFictionChapter.getPrice()) / 100.0f)}));
        } else {
            textView.setText(this.c.getResources().getString(j.store__shared__yuan) + this.c.b.getFeeDescription());
        }
        ExpandableAdapterState c = c(i, i2);
        View findViewById = view.findViewById(g.store__fiction_toc_item_view__choice);
        textView = (TextView) view.findViewById(g.store__fiction_toc_item_view__state);
        View findViewById2 = view.findViewById(g.store__fiction_toc_item_view__lock);
        if (c != ExpandableAdapterState.IGNORE) {
            findViewById.setVisibility(4);
            textView.setVisibility(8);
            findViewById2.setVisibility(0);
        } else {
            findViewById.setVisibility(4);
            textView.setVisibility(0);
            switch (bh.a[dkCloudFictionChapter.getChapterState().ordinal()]) {
                case 1:
                    textView.setText(j.store__shared__order);
                    break;
                case 2:
                    if (!a) {
                        throw new AssertionError();
                    }
                    break;
                default:
                    textView.setVisibility(4);
                    break;
            }
            findViewById2.setVisibility(8);
        }
        return view;
    }

    public void j(int i) {
        this.c.d(i);
    }
}
