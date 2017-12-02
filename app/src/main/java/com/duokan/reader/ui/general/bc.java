package com.duokan.reader.ui.general;

import java.util.Iterator;
import java.util.LinkedList;

public class bc implements ba {
    private LinkedList a = new LinkedList();
    private az b;

    public void a(az azVar, boolean z) {
        if (z) {
            this.b = azVar;
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                az azVar2 = (az) it.next();
                if (azVar2 != azVar && azVar2.isChecked()) {
                    azVar2.setChecked(false);
                }
            }
        } else if (azVar == this.b) {
            this.b = null;
        }
    }
}
