package com.duokan.reader;

import android.graphics.drawable.Drawable;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.ui.bookshelf.gx;
import com.duokan.reader.ui.bookshelf.hb;
import com.duokan.reader.ui.reading.sh;
import com.duokan.reader.ui.ITheme;
import com.duokan.reader.ui.PushHalfPage;

public interface ReaderFeature extends ITheme, PushHalfPage {
    void addSystemUiConditioner(SystemUiConditioner systemUiConditioner);

    void downloadBooks(c... cVarArr);

    float[] getEyesSavingModeDensity();

    Drawable getHeaderBackground();

    float getKeyboardBrightness();

    BrightnessMode getKeyboardBrightnessMode();

    int getPageCount();

    c getReadingBook();

    sh getReadingFeature();

    float getScreenBrightness();

    BrightnessMode getScreenBrightnessMode();

    float[] getScreenBrightnessRange();

    int getScreenTimeout();

    long getTotalActiveTime();

    void goHome(Runnable runnable);

    boolean inNightMode();

    void openBook(c cVar);

    void openBook(c cVar, Document_a aVar, Runnable runnable);

    void openBook(String str, Document_a aVar);

    void prompt(String str);

    void prompt(String str, int i);

    void removeSystemUiConditioner(SystemUiConditioner systemUiConditioner);

    void setKeyboardBrightness(float f);

    void setKeyboardBrightnessMode(BrightnessMode brightnessMode);

    void setQuitOnBack(boolean z);

    void setScreenBrightness(float f);

    void setScreenBrightnessMode(BrightnessMode brightnessMode);

    void setScreenTimeout(int i);

    void shareBooks(ActivatedController activatedControllerVar, c... cVarArr);

    void showBookHomePage(IFeature featrue, String str, String str2, boolean z, String str3);

    void showMenuFromBottom(hb hbVar);

    void showMenuFromTop(gx gxVar);

    void switchEyesSavingMode(boolean z);

    void switchNightMode(boolean z, boolean z2);

    void updateSystemUi(boolean z);
}
