package com.duokan.reader.ui.reading;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import org.apache.http.HttpStatus;

import miuipub.date.Calendar;

class aet implements OnSeekBarChangeListener {
    final /* synthetic */ aem a;

    aet(aem com_duokan_reader_ui_reading_aem) {
        this.a = com_duokan_reader_ui_reading_aem;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        switch (this.a.f.getProgress()) {
            case 0:
                this.a.a.g(Integer.MAX_VALUE);
                return;
            case 100:
                this.a.a.g(900000);
                return;
            case HttpStatus.SC_OK /*200*/:
                this.a.a.g(1800000);
                return;
            case HttpStatus.SC_MULTIPLE_CHOICES /*300*/:
                this.a.a.g(2700000);
                return;
            default:
                this.a.a.g((int) Calendar.MILLISECOND_OF_HOUR);
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
            this.a.f.setProgress(0);
        } else if (i < 150) {
            this.a.f.setProgress(100);
        } else if (i < 250) {
            this.a.f.setProgress(HttpStatus.SC_OK);
        } else if (i < 350) {
            this.a.f.setProgress(HttpStatus.SC_MULTIPLE_CHOICES);
        } else {
            this.a.f.setProgress(HttpStatus.SC_BAD_REQUEST);
        }
    }
}
