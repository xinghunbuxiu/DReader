package com.duokan.reader.ui.general.web;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.reader.ui.general.bo;

class r extends bo {
    static final /* synthetic */ boolean a = (!SearchController.class.desiredAssertionStatus());
    final /* synthetic */ SearchController c;

    r(SearchController searchController) {
        this.c = searchController;
    }

    public /* synthetic */ Object d(int i) {
        return c(i);
    }

    public int a() {
        int i = 1;
        if (this.c.hasHint()) {
            return 0;
        }
        int i2;
        if (this.c.hasHistory()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        i2 += 0;
        if (!this.c.hasHotWord()) {
            i = 0;
        }
        return i2 + i;
    }

    public int a(int i) {
        if (i == 0 && this.c.hasHint()) {
            return this.c.mSearchHint.size();
        }
        if (i == 0 && this.c.hasHistory()) {
            return this.c.mHistory.size();
        }
        if (i == 0 && this.c.hasHotWord()) {
            return this.c.mHotWord.size();
        }
        if (i == 1 && this.c.hasHistory() && this.c.hasHotWord()) {
            return this.c.mHotWord.size();
        }
        return 0;
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.c.getContext()).inflate(h.store__search_group_title_view, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(g.store__hot_word_item_view__text);
        if (i == 0 && this.c.hasHistory()) {
            textView.setText(j.store__search_view__history);
        } else if (i == 0 && this.c.hasHotWord()) {
            textView.setText(j.store__search_view__recommend);
        } else if (i == 1 && this.c.hasHistory() && this.c.hasHotWord()) {
            textView.setText(j.store__search_view__recommend);
        } else if (!a) {
            throw new AssertionError();
        }
        return view;
    }

    protected void b() {
    }

    protected void e(int i) {
        if (this.c.mLoadHistory) {
            this.c.loadHistoryForPh();
        } else {
            this.c.getHotWord();
        }
    }

    public int c() {
        if (this.c.hasHint()) {
            return this.c.mSearchHint.size();
        }
        return this.c.mHistory.size() + this.c.mHotWord.size();
    }

    public String c(int i) {
        if (this.c.hasHint()) {
            return (String) this.c.mSearchHint.get(i);
        }
        return (String) f(i).second;
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.findViewById(g.store__hot_word_item_view__text) == null) {
            view = LayoutInflater.from(this.c.getContext()).inflate(h.store__hot_word_item_view, viewGroup, false);
        }
        if (this.c.hasHint()) {
            ((TextView) view.findViewById(g.store__hot_word_item_view__text)).setText(c(i));
            ((ImageView) view.findViewById(g.store__hot_word_item_view__icon)).setImageResource(f.search__hot_world_item_view__hint);
            view.findViewById(g.store__hot_word_item_view__close).setVisibility(8);
        } else {
            Pair f = f(i);
            int[] b = b(i);
            if (((Integer) f.first).intValue() == 0) {
                this.c.setHistoryView(view, b[1], (String) f.second);
            } else if (((Integer) f.first).intValue() == 1) {
                this.c.setHotWordView(view, b[1], (String) f.second);
            } else if (!a) {
                throw new AssertionError();
            }
        }
        return view;
    }

    private Pair f(int i) {
        int[] b = b(i);
        if (b[0] == 0 && this.c.hasHistory()) {
            return new Pair(Integer.valueOf(0), this.c.mHistory.get(b[1]));
        }
        if (b[0] == 0 && this.c.hasHotWord()) {
            return new Pair(Integer.valueOf(1), this.c.mHotWord.get(b[1]));
        }
        if (b[0] == 1 && this.c.hasHistory() && this.c.hasHotWord()) {
            return new Pair(Integer.valueOf(1), this.c.mHotWord.get(b[1]));
        }
        if (a) {
            return null;
        }
        throw new AssertionError();
    }
}
