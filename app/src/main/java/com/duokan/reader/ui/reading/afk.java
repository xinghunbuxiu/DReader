package com.duokan.reader.ui.reading;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import miuipub.date.Calendar;
import org.apache.http.HttpStatus;

class afk implements OnSeekBarChangeListener {
    /* renamed from: a */
    final /* synthetic */ afd f9635a;

    afk(afd afd) {
        this.f9635a = afd;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        switch (this.f9635a.f9628e.getProgress()) {
            case 0:
                this.f9635a.f9624a.mo2143g(Integer.MAX_VALUE);
                return;
            case HttpStatus.SC_CONTINUE /*100*/:
                this.f9635a.f9624a.mo2143g(900000);
                return;
            case HttpStatus.SC_OK /*200*/:
                this.f9635a.f9624a.mo2143g(1800000);
                return;
            case HttpStatus.SC_MULTIPLE_CHOICES /*300*/:
                this.f9635a.f9624a.mo2143g(2700000);
                return;
            default:
                this.f9635a.f9624a.mo2143g((int) Calendar.MILLISECOND_OF_HOUR);
                return;
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (!z) {
            return;
        }
        if (i < 50) {
            this.f9635a.f9628e.setProgress(0);
        } else if (i < 150) {
            this.f9635a.f9628e.setProgress(100);
        } else if (i < 250) {
            this.f9635a.f9628e.setProgress(HttpStatus.SC_OK);
        } else if (i < 350) {
            this.f9635a.f9628e.setProgress(HttpStatus.SC_MULTIPLE_CHOICES);
        } else {
            this.f9635a.f9628e.setProgress(HttpStatus.SC_BAD_REQUEST);
        }
    }
}
