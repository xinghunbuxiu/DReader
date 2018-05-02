package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;

import java.util.Map;
import java.util.Map.Entry;

import miuipub.date.Calendar;

class aag implements ag {
    final /* synthetic */ aaf a;

    aag(aaf com_duokan_reader_ui_reading_aaf) {
        this.a = com_duokan_reader_ui_reading_aaf;
    }

    public void a(Map map) {
        a.c().b(map.size() == this.a.a.size());
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            int intValue = ((Integer) entry.getValue()).intValue();
            this.a.d.P.remove(str);
            if (intValue >= Calendar.MILLISECOND_OF_SECOND) {
                this.a.d.Q.put(str, Integer.valueOf(intValue));
            }
        }
        this.a.d.a(false);
        if (this.a.c != null) {
            this.a.c.a(map);
        }
    }
}
