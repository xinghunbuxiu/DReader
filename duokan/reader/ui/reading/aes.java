package com.duokan.reader.ui.reading;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import org.apache.http.HttpStatus;

class aes implements OnSeekBarChangeListener {
    final /* synthetic */ aem a;

    aes(aem com_duokan_reader_ui_reading_aem) {
        this.a = com_duokan_reader_ui_reading_aem;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        switch (this.a.e.getProgress()) {
            case 0:
                this.a.a.b(0.75f);
                return;
            case 100:
                this.a.a.b(1.0f);
                return;
            case HttpStatus.SC_MULTIPLE_CHOICES /*300*/:
                this.a.a.b(1.5f);
                return;
            case HttpStatus.SC_BAD_REQUEST /*400*/:
                this.a.a.b(1.75f);
                return;
            default:
                this.a.a.b(1.25f);
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
            this.a.e.setProgress(i2);
        }
    }
}
