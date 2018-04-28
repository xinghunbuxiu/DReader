package com.duokan.reader.ui.general.expandable;

import com.duokan.reader.ui.general.cd;
import java.util.HashMap;
import java.util.Map;

public abstract class StateExpandableAdapter extends cd {
    /* renamed from: a */
    private Map<Integer, Map<Integer, ExpandableAdapterState>> f7173a = new HashMap();
    /* renamed from: c */
    private C1331c f7174c = null;
    /* renamed from: d */
    private boolean f7175d = false;

    public enum ExpandableAdapterState {
        SELECTED,
        UNSELECT,
        IGNORE
    }

    /* renamed from: h */
    public abstract void mo2529h();

    /* renamed from: c */
    public ExpandableAdapterState m10580c(int i, int i2) {
        return (ExpandableAdapterState) m10578k(i).get(Integer.valueOf(i2));
    }

    /* renamed from: a */
    public void m10579a(int i, int i2, ExpandableAdapterState expandableAdapterState, boolean z) {
        m10578k(i).put(Integer.valueOf(i2), expandableAdapterState);
        if (z) {
            if (this.f7174c != null) {
                this.f7174c.m10583a(m10582i(), this.f7175d);
            }
            mo1715g();
        }
    }

    /* renamed from: i */
    public int m10582i() {
        this.f7175d = true;
        int i = 0;
        for (int i2 = 0; i2 < mo486a(); i2++) {
            int i3 = 0;
            while (i3 < mo2457h(i2)) {
                int i4;
                ExpandableAdapterState c = m10580c(i2, i3);
                if (c == ExpandableAdapterState.SELECTED) {
                    i4 = i + 1;
                } else {
                    if (c == ExpandableAdapterState.UNSELECT) {
                        this.f7175d = false;
                    }
                    i4 = i;
                }
                i3++;
                i = i4;
            }
        }
        return i;
    }

    /* renamed from: k */
    private Map<Integer, ExpandableAdapterState> m10578k(int i) {
        Map<Integer, ExpandableAdapterState> map = (Map) this.f7173a.get(Integer.valueOf(i));
        if (map != null) {
            return map;
        }
        Map hashMap = new HashMap();
        this.f7173a.put(Integer.valueOf(i), hashMap);
        return hashMap;
    }
}
