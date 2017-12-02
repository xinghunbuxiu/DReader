package com.duokan.reader.ui.general.expandable;

import com.duokan.reader.ui.general.cd;

import java.util.HashMap;
import java.util.Map;

public abstract class StateExpandableAdapter extends cd {
    private Map a = new HashMap();
    private c c = null;
    private boolean d = false;

    public enum ExpandableAdapterState {
        SELECTED,
        UNSELECT,
        IGNORE
    }

    public abstract void h();

    public ExpandableAdapterState c(int i, int i2) {
        return (ExpandableAdapterState) k(i).get(Integer.valueOf(i2));
    }

    public void a(int i, int i2, ExpandableAdapterState expandableAdapterState, boolean z) {
        k(i).put(Integer.valueOf(i2), expandableAdapterState);
        if (z) {
            if (this.c != null) {
                this.c.a(i(), this.d);
            }
            g();
        }
    }

    public int i() {
        this.d = true;
        int i = 0;
        for (int i2 = 0; i2 < a(); i2++) {
            int i3 = 0;
            while (i3 < h(i2)) {
                int i4;
                ExpandableAdapterState c = c(i2, i3);
                if (c == ExpandableAdapterState.SELECTED) {
                    i4 = i + 1;
                } else {
                    if (c == ExpandableAdapterState.UNSELECT) {
                        this.d = false;
                    }
                    i4 = i;
                }
                i3++;
                i = i4;
            }
        }
        return i;
    }

    private Map k(int i) {
        Map map = (Map) this.a.get(Integer.valueOf(i));
        if (map != null) {
            return map;
        }
        map = new HashMap();
        this.a.put(Integer.valueOf(i), map);
        return map;
    }
}
