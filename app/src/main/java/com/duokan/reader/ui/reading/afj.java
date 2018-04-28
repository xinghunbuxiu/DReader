package com.duokan.reader.ui.reading;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import org.apache.http.HttpStatus;

class afj implements OnSeekBarChangeListener {
    /* renamed from: a */
    final /* synthetic */ afd f9634a;

    afj(afd afd) {
        this.f9634a = afd;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        switch (this.f9634a.f9627d.getProgress()) {
            case 0:
                this.f9634a.f9624a.mo2098b(0.65f);
                return;
            case HttpStatus.SC_CONTINUE /*100*/:
                this.f9634a.f9624a.mo2098b(0.9f);
                return;
            case HttpStatus.SC_MULTIPLE_CHOICES /*300*/:
                this.f9634a.f9624a.mo2098b(1.4f);
                return;
            case HttpStatus.SC_BAD_REQUEST /*400*/:
                this.f9634a.f9624a.mo2098b(1.65f);
                return;
            default:
                this.f9634a.f9624a.mo2098b(1.15f);
                return;
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            int i2;
            if (i < 50) {
                i2 = 0;
            } else if (i < 150) {
                i2 = 100;
            } else if (i < 250) {
                i2 = HttpStatus.SC_OK;
            } else if (i < 350) {
                i2 = HttpStatus.SC_MULTIPLE_CHOICES;
            } else {
                i2 = HttpStatus.SC_BAD_REQUEST;
            }
            this.f9634a.f9627d.setProgress(i2);
        }
    }
}
