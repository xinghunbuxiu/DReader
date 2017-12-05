package com.duokan.reader;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.af;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.ui.bookshelf.gx;
import com.duokan.reader.ui.bookshelf.hb;
import com.duokan.reader.ui.r;
import com.duokan.reader.ui.reading.sh;

public class DkReaderController extends ReaderController {
    public  void addSystemUiConditioner(SystemUiConditioner systemUiConditioner) {
        super.addSystemUiConditioner(systemUiConditioner);
    }

    public  void chooseNavigationBarColor(af afVar) {
        super.chooseNavigationBarColor(afVar);
    }

    public  void chooseNavigationBarMode(af afVar) {
        super.chooseNavigationBarMode(afVar);
    }

    public  void chooseStatusBarStyle(af afVar) {
        super.chooseStatusBarStyle(afVar);
    }

    public  void downloadBooks(c[] cVarArr) {
        super.downloadBooks(cVarArr);
    }

    public  float[] getEyesSavingModeDensity() {
        return super.getEyesSavingModeDensity();
    }

    public  Drawable getHeaderBackground() {
        return super.getHeaderBackground();
    }

    public  float getKeyboardBrightness() {
        return super.getKeyboardBrightness();
    }

    public  BrightnessMode getKeyboardBrightnessMode() {
        return super.getKeyboardBrightnessMode();
    }

    public  int getPageCount() {
        return super.getPageCount();
    }

    public  c getReadingBook() {
        return super.getReadingBook();
    }

    public  sh getReadingFeature() {
        return super.getReadingFeature();
    }

    public  float getScreenBrightness() {
        return super.getScreenBrightness();
    }

    public  BrightnessMode getScreenBrightnessMode() {
        return super.getScreenBrightnessMode();
    }

    public  float[] getScreenBrightnessRange() {
        return super.getScreenBrightnessRange();
    }

    public  int getScreenTimeout() {
        return super.getScreenTimeout();
    }

    public  r getTheme() {
        return super.getTheme();
    }

    public  long getTotalActiveTime() {
        return super.getTotalActiveTime();
    }

    public  void goHome(Runnable runnable) {
        super.goHome(runnable);
    }

    public  boolean inNightMode() {
        return super.inNightMode();
    }

    public  void navigate(Intent intent) {
        super.navigate(intent);
    }

    public  boolean navigate(String str, Object obj, boolean z, Runnable runnable) {
        return super.navigate(str, obj, z, runnable);
    }

    public  boolean navigateSmoothly(String str) {
        return super.navigateSmoothly(str);
    }

    public  boolean navigateSmoothly(String str, Runnable runnable) {
        return super.navigateSmoothly(str, runnable);
    }

    public  void openBook(c cVar) {
        super.openBook(cVar);
    }

    public  void openBook(c cVar, Document_a aVar, Runnable runnable) {
        super.openBook(cVar, aVar, runnable);
    }

    public  void openBook(String str, Document_a aVar) {
        super.openBook(str, aVar);
    }

    public  void prompt(String str) {
        super.prompt(str);
    }

    public  void prompt(String str, int i) {
        super.prompt(str, i);
    }

    public  boolean pushFloatingPage(ActivatedController activatedControllerVar) {
        return super.pushFloatingPage(activatedControllerVar);
    }

    public  boolean pushFloatingPageSmoothly(ActivatedController activatedControllerVar, Runnable runnable) {
        return super.pushFloatingPageSmoothly(activatedControllerVar, runnable);
    }

    public  boolean pushHalfPage(ActivatedController activatedControllerVar) {
        return super.pushHalfPage(activatedControllerVar);
    }

    public  boolean pushHalfPageSmoothly(ActivatedController activatedControllerVar, Runnable runnable) {
        return super.pushHalfPageSmoothly(activatedControllerVar, runnable);
    }

    public  boolean pushPage(ActivatedController activatedControllerVar) {
        return super.pushPage(activatedControllerVar);
    }

    public  boolean pushPageSmoothly(ActivatedController activatedControllerVar, Runnable runnable) {
        return super.pushPageSmoothly(activatedControllerVar, runnable);
    }

    public  void removeSystemUiConditioner(SystemUiConditioner systemUiConditioner) {
        super.removeSystemUiConditioner(systemUiConditioner);
    }

    public  void setKeyboardBrightness(float f) {
        super.setKeyboardBrightness(f);
    }

    public  void setKeyboardBrightnessMode(BrightnessMode brightnessMode) {
        super.setKeyboardBrightnessMode(brightnessMode);
    }

    public  void setQuitOnBack(boolean z) {
        super.setQuitOnBack(z);
    }

    public  void setScreenBrightness(float f) {
        super.setScreenBrightness(f);
    }

    public  void setScreenBrightnessMode(BrightnessMode brightnessMode) {
        super.setScreenBrightnessMode(brightnessMode);
    }

    public  void setScreenTimeout(int i) {
        super.setScreenTimeout(i);
    }

    public  void shareBooks(ActivatedController activatedControllerVar, c[] cVarArr) {
        super.shareBooks(activatedControllerVar, cVarArr);
    }

    public  void showBookHomePage(IFeature featrue, String str, String str2, boolean z, String str3) {
        super.showBookHomePage(featrue, str, str2, z, str3);
    }

    public  void showMenuFromBottom(hb hbVar) {
        super.showMenuFromBottom(hbVar);
    }

    public  void showMenuFromTop(gx gxVar) {
        super.showMenuFromTop(gxVar);
    }

    public  boolean showPopup(ActivatedController activatedControllerVar) {
        return super.showPopup(activatedControllerVar);
    }

    public  boolean showPopup(ActivatedController activatedControllerVar, int i, int i2) {
        return super.showPopup(activatedControllerVar, i, i2);
    }

    public  boolean showPopupSmoothly(ActivatedController activatedControllerVar, Runnable runnable) {
        return super.showPopupSmoothly(activatedControllerVar, runnable);
    }

    public  void switchEyesSavingMode(boolean z) {
        super.switchEyesSavingMode(z);
    }

    public  void switchNightMode(boolean z, boolean z2) {
        super.switchNightMode(z, z2);
    }

    public  void updateSystemUi(boolean z) {
        super.updateSystemUi(z);
    }

    private DkReaderController(IFeature featrue) {
        super(featrue);
    }

    private DkReaderController(IFeature featrue, Uri uri) {
        super(featrue, uri);
    }

    private DkReaderController(BaseActivity baseActivityVar, c cVar) {
        super((IFeature) baseActivityVar, cVar);
    }

    public static DkReaderController from(BaseActivity baseActivityVar, String str) {
        if (!DkApp.get().isWebAccessEnabled() && TextUtils.isEmpty(str)) {
            return null;
        }
        c b = TextUtils.isEmpty(str) ? ai.a().b(ReaderEnv.get().getReadingBookUuid()) : ai.a().b(str);
        if (b != null) {
            return new DkReaderController(baseActivityVar, b);
        }
        return null;
    }

    public static DkReaderController from(BaseActivity baseActivityVar, c cVar) {
        return new DkReaderController(baseActivityVar, cVar);
    }

    public static DkReaderController from(BaseActivity baseActivityVar, Uri uri) {
        return new DkReaderController((IFeature) baseActivityVar, uri);
    }

    public static DkReaderController from(DkMainActivity dkMainActivity) {
        return new DkReaderController(dkMainActivity);
    }
}
