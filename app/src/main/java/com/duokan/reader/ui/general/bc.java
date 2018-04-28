package com.duokan.reader.ui.general;

import java.util.Iterator;
import java.util.LinkedList;

public class bc<T> implements ba<T> {
    /* renamed from: a */
    private LinkedList<az<T>> f6965a = new LinkedList();
    /* renamed from: b */
    private az<T> f6966b;

    /* renamed from: a */
    public void mo1749a(az<T> azVar, boolean z) {
        if (z) {
            this.f6966b = azVar;
            Iterator it = this.f6965a.iterator();
            while (it.hasNext()) {
                az<T> azVar2 = (az) it.next();
                if (azVar2 != azVar && azVar2.isChecked()) {
                    azVar2.setChecked(false);
                }
            }
        } else if (azVar == this.f6966b) {
            this.f6966b = null;
        }
    }
}
