package com.duokan.reader.ui.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.duokan.C0650x;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter.ChapterState;
import com.duokan.reader.ui.general.expandable.StateExpandableAdapter;
import com.duokan.reader.ui.general.expandable.StateExpandableAdapter.ExpandableAdapterState;

class bf extends StateExpandableAdapter {
    /* renamed from: a */
    static final /* synthetic */ boolean f11363a = (!bc.class.desiredAssertionStatus());
    /* renamed from: c */
    final /* synthetic */ bc f11364c;

    bf(bc bcVar) {
        this.f11364c = bcVar;
    }

    /* renamed from: a */
    public int mo486a() {
        int i = 0;
        if (this.f11364c.f11359c.length == 0) {
            return 0;
        }
        int length = this.f11364c.f11359c.length / 100;
        if (this.f11364c.f11359c.length % 100 > 0) {
            i = 1;
        }
        return i + length;
    }

    /* renamed from: h */
    public int mo2457h(int i) {
        if (i == mo486a() - 1) {
            return this.f11364c.f11359c.length - (i * 100);
        }
        if (this.f11364c.f11359c.length < 100) {
            return this.f11364c.f11359c.length;
        }
        return 100;
    }

    /* renamed from: i */
    public Object mo2458i(int i) {
        return null;
    }

    /* renamed from: b */
    public Object mo2456b(int i, int i2) {
        return this.f11364c.f11359c[(i * 100) + i2];
    }

    /* renamed from: h */
    public void mo2529h() {
        if (this.f11364c.f11359c != null) {
            for (int i = 0; i < mo486a(); i++) {
                for (int i2 = 0; i2 < mo2457h(i); i2++) {
                    ExpandableAdapterState expandableAdapterState = ((DkCloudFictionChapter) mo2456b(i, i2)).getChapterState().ordinal() < ChapterState.FREE.ordinal() ? ExpandableAdapterState.UNSELECT : ExpandableAdapterState.IGNORE;
                    if (m10580c(i, i2) == ExpandableAdapterState.SELECTED && expandableAdapterState != ExpandableAdapterState.IGNORE) {
                        expandableAdapterState = ExpandableAdapterState.SELECTED;
                    }
                    m10579a(i, i2, expandableAdapterState, false);
                }
            }
        }
    }

    /* renamed from: a */
    public View mo2455a(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null || view.findViewById(C0255g.store__fiction_toc_item_header_view__title) == null) {
            view = LayoutInflater.from(this.f11364c.getContext()).inflate(C0256h.store__fiction_toc_item_header_view, viewGroup, false);
        }
        int f = m10355f();
        View findViewById = view.findViewById(C0255g.store__fiction_toc_item_header_view__split);
        f = (f == -1 || f != i - 1) ? 4 : 0;
        findViewById.setVisibility(f);
        view.findViewById(C0255g.store__fiction_toc_item_header_view__expand).setSelected(z);
        ((TextView) view.findViewById(C0255g.store__fiction_toc_item_header_view__title)).setText(String.format(this.f11364c.getContext().getString(C0258j.store__fiction_chapter_view__chapter_group), new Object[]{Integer.valueOf((i * 100) + 1), Integer.valueOf((i * 100) + mo2457h(i))}));
        view.findViewById(C0255g.store__fiction_toc_item_header_view__choice).setVisibility(4);
        return view;
    }

    /* renamed from: a */
    public View mo2454a(int i, int i2, View view, ViewGroup viewGroup) {
        if (view == null || view.findViewById(C0255g.store__fiction_toc_item_view__title) == null) {
            view = LayoutInflater.from(this.f11364c.getContext()).inflate(C0256h.store__fiction_toc_item_view, viewGroup, false);
        }
        DkCloudFictionChapter dkCloudFictionChapter = (DkCloudFictionChapter) mo2456b(i, i2);
        ((TextView) view.findViewById(C0255g.store__fiction_toc_item_view__title)).setText(dkCloudFictionChapter.getTitle());
        TextView textView = (TextView) view.findViewById(C0255g.store__fiction_toc_item_view__update);
        if (dkCloudFictionChapter.isFree()) {
            textView.setText(C0258j.store__shared__free);
        } else if (new C0650x(this.f11364c.f11358b.getFiction().getBookUuid()).m3047b() == 0) {
            textView.setText(this.f11364c.getResources().getString(C0258j.store__shared__yuan) + String.format("%.2f", new Object[]{Float.valueOf(((float) dkCloudFictionChapter.getPrice()) / 100.0f)}));
        } else {
            textView.setText(this.f11364c.getResources().getString(C0258j.store__shared__yuan) + this.f11364c.f11358b.getFeeDescription());
        }
        ExpandableAdapterState c = m10580c(i, i2);
        View findViewById = view.findViewById(C0255g.store__fiction_toc_item_view__choice);
        textView = (TextView) view.findViewById(C0255g.store__fiction_toc_item_view__state);
        View findViewById2 = view.findViewById(C0255g.store__fiction_toc_item_view__lock);
        if (c != ExpandableAdapterState.IGNORE) {
            findViewById.setVisibility(4);
            textView.setVisibility(8);
            findViewById2.setVisibility(0);
        } else {
            findViewById.setVisibility(4);
            textView.setVisibility(0);
            switch (bh.f11367a[dkCloudFictionChapter.getChapterState().ordinal()]) {
                case 1:
                    textView.setText(C0258j.store__shared__order);
                    break;
                case 2:
                    if (!f11363a) {
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

    /* renamed from: j */
    public void mo2459j(int i) {
        this.f11364c.m1256d(i);
    }
}
