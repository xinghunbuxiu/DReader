package com.duokan.reader;

import android.graphics.drawable.Drawable;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.C0437t;
import com.duokan.reader.ui.bookshelf.he;
import com.duokan.reader.ui.bookshelf.hi;
import com.duokan.reader.ui.reading.su;

public interface ReaderFeature extends C0435s, C0437t {
    void addSystemUiConditioner(SystemUiConditioner systemUiConditioner);

    void downloadBooks(C0800c... c0800cArr);

    float[] getEyesSavingModeDensity();

    Drawable getHeaderBackground();

    float getKeyboardBrightness();

    BrightnessMode getKeyboardBrightnessMode();

    int getPageCount();

    C0800c getReadingBook();

    su getReadingFeature();

    float getScreenBrightness();

    BrightnessMode getScreenBrightnessMode();

    float[] getScreenBrightnessRange();

    int getScreenTimeout();

    long getTotalActiveTime();

    void goHome(Runnable runnable);

    boolean inNightMode();

    void openBook(C0800c c0800c);

    void openBook(C0800c c0800c, C0896a c0896a, Runnable runnable);

    void openBook(String str, C0896a c0896a);

    void prompt(String str);

    void prompt(String str, int i);

    void removeSystemUiConditioner(SystemUiConditioner systemUiConditioner);

    void setKeyboardBrightness(float f);

    void setKeyboardBrightnessMode(BrightnessMode brightnessMode);

    void setQuitOnBack(boolean z);

    void setScreenBrightness(float f);

    void setScreenBrightnessMode(BrightnessMode brightnessMode);

    void setScreenTimeout(int i);

    void shareBooks(ActivatedController c0303e, C0800c... c0800cArr);

    void showBookHomePage(IFeature mFeature, String str, String str2, boolean z, String str3);

    void showMenuFromBottom(hi hiVar);

    void showMenuFromTop(he heVar);

    void switchEyesSavingMode(boolean z);

    void switchNightMode(boolean z, boolean z2);

    void updateSystemUi(boolean z);
}
