package com.duokan.reader.ui.reading;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class adn implements ServiceConnection {
    final /* synthetic */ adm a;

    adn(adm com_duokan_reader_ui_reading_adm) {
        this.a = com_duokan_reader_ui_reading_adm;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.q = (aeu) iBinder;
        if (this.a.q != null && this.a.j != null) {
            this.a.q.a();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (this.a.q != null) {
            this.a.q.d();
        }
        this.a.q = null;
    }
}
