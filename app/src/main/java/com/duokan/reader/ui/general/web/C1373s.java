package com.duokan.reader.ui.general.web;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.bo;

/* renamed from: com.duokan.reader.ui.general.web.s */
class C1373s extends bo {
    /* renamed from: a */
    static final /* synthetic */ boolean f8173a = (!SearchController.class.desiredAssertionStatus());
    /* renamed from: c */
    final /* synthetic */ SearchController f8174c;

    C1373s(SearchController searchController) {
        this.f8174c = searchController;
    }

    /* renamed from: d */
    public /* synthetic */ Object mo509d(int i) {
        return mo1556c(i);
    }

    /* renamed from: a */
    public int mo486a() {
        int i = 1;
        if (this.f8174c.hasHint()) {
            return 0;
        }
        int i2;
        if (this.f8174c.hasHistory()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        i2 += 0;
        if (!this.f8174c.hasHotWord()) {
            i = 0;
        }
        return i2 + i;
    }

    /* renamed from: a */
    public int mo487a(int i) {
        if (i == 0 && this.f8174c.hasHint()) {
            return this.f8174c.mSearchHint.size();
        }
        if (i == 0 && this.f8174c.hasHistory()) {
            return this.f8174c.mHistory.size();
        }
        if (i == 0 && this.f8174c.hasHotWord()) {
            return this.f8174c.mHotWord.size();
        }
        if (i == 1 && this.f8174c.hasHistory() && this.f8174c.hasHotWord()) {
            return this.f8174c.mHotWord.size();
        }
        return 0;
    }

    /* renamed from: a */
    public View mo488a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f8174c.getContext()).inflate(C0256h.store__search_group_title_view, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(C0255g.store__hot_word_item_view__text);
        if (i == 0 && this.f8174c.hasHistory()) {
            textView.setText(C0258j.store__search_view__history);
        } else if (i == 0 && this.f8174c.hasHotWord()) {
            textView.setText(C0258j.store__search_view__recommend);
        } else if (i == 1 && this.f8174c.hasHistory() && this.f8174c.hasHotWord()) {
            textView.setText(C0258j.store__search_view__recommend);
        } else if (!f8173a) {
            throw new AssertionError();
        }
        return view;
    }

    /* renamed from: b */
    protected void mo1555b() {
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
        if (this.f8174c.mLoadHistory) {
            this.f8174c.loadHistoryForPh();
        } else {
            this.f8174c.getHotWord();
        }
    }

    /* renamed from: c */
    public int mo506c() {
        if (this.f8174c.hasHint()) {
            return this.f8174c.mSearchHint.size();
        }
        return this.f8174c.mHistory.size() + this.f8174c.mHotWord.size();
    }

    /* renamed from: c */
    public String mo1556c(int i) {
        if (this.f8174c.hasHint()) {
            return (String) this.f8174c.mSearchHint.get(i);
        }
        return (String) m11297f(i).second;
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.findViewById(C0255g.store__hot_word_item_view__text) == null) {
            view = LayoutInflater.from(this.f8174c.getContext()).inflate(C0256h.store__hot_word_item_view, viewGroup, false);
        }
        if (this.f8174c.hasHint()) {
            ((TextView) view.findViewById(C0255g.store__hot_word_item_view__text)).setText(mo1556c(i));
            ((ImageView) view.findViewById(C0255g.store__hot_word_item_view__icon)).setImageResource(C0254f.search__hot_world_item_view__hint);
            view.findViewById(C0255g.store__hot_word_item_view__close).setVisibility(8);
        } else {
            Pair f = m11297f(i);
            int[] b = m1404b(i);
            if (((Integer) f.first).intValue() == 0) {
                this.f8174c.setHistoryView(view, b[1], (String) f.second);
            } else if (((Integer) f.first).intValue() == 1) {
                this.f8174c.setHotWordView(view, b[1], (String) f.second);
            } else if (!f8173a) {
                throw new AssertionError();
            }
        }
        return view;
    }

    /* renamed from: f */
    private Pair<Integer, String> m11297f(int i) {
        int[] b = m1404b(i);
        if (b[0] == 0 && this.f8174c.hasHistory()) {
            return new Pair(Integer.valueOf(0), this.f8174c.mHistory.get(b[1]));
        }
        if (b[0] == 0 && this.f8174c.hasHotWord()) {
            return new Pair(Integer.valueOf(1), this.f8174c.mHotWord.get(b[1]));
        }
        if (b[0] == 1 && this.f8174c.hasHistory() && this.f8174c.hasHotWord()) {
            return new Pair(Integer.valueOf(1), this.f8174c.mHotWord.get(b[1]));
        }
        if (f8173a) {
            return null;
        }
        throw new AssertionError();
    }
}
