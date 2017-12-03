package com.duokan.reader;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.ActivatedController;
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
    public /* bridge */ /* synthetic */ void addSystemUiConditioner(SystemUiConditioner systemUiConditioner) {
        super.addSystemUiConditioner(systemUiConditioner);
    }

    public /* bridge */ /* synthetic */ void chooseNavigationBarColor(af afVar) {
        super.chooseNavigationBarColor(afVar);
    }

    public /* bridge */ /* synthetic */ void chooseNavigationBarMode(af afVar) {
        super.chooseNavigationBarMode(afVar);
    }

    public /* bridge */ /* synthetic */ void chooseStatusBarStyle(af afVar) {
        super.chooseStatusBarStyle(afVar);
    }

    public /* bridge */ /* synthetic */ void downloadBooks(c[] cVarArr) {
        super.downloadBooks(cVarArr);
    }

    public /* bridge */ /* synthetic */ float[] getEyesSavingModeDensity() {
        return super.getEyesSavingModeDensity();
    }

    public /* bridge */ /* synthetic */ Drawable getHeaderBackground() {
        return super.getHeaderBackground();
    }

    public /* bridge */ /* synthetic */ float getKeyboardBrightness() {
        return super.getKeyboardBrightness();
    }

    public /* bridge */ /* synthetic */ BrightnessMode getKeyboardBrightnessMode() {
        return super.getKeyboardBrightnessMode();
    }

    public /* bridge */ /* synthetic */ int getPageCount() {
        return super.getPageCount();
    }

    public /* bridge */ /* synthetic */ c getReadingBook() {
        return super.getReadingBook();
    }

    public /* bridge */ /* synthetic */ sh getReadingFeature() {
        return super.getReadingFeature();
    }

    public /* bridge */ /* synthetic */ float getScreenBrightness() {
        return super.getScreenBrightness();
    }

    public /* bridge */ /* synthetic */ BrightnessMode getScreenBrightnessMode() {
        return super.getScreenBrightnessMode();
    }

    public /* bridge */ /* synthetic */ float[] getScreenBrightnessRange() {
        return super.getScreenBrightnessRange();
    }

    public /* bridge */ /* synthetic */ int getScreenTimeout() {
        return super.getScreenTimeout();
    }

    public /* bridge */ /* synthetic */ r getTheme() {
        return super.getTheme();
    }

    public /* bridge */ /* synthetic */ long getTotalActiveTime() {
        return super.getTotalActiveTime();
    }

    public /* bridge */ /* synthetic */ void goHome(Runnable runnable) {
        super.goHome(runnable);
    }

    public /* bridge */ /* synthetic */ boolean inNightMode() {
        return super.inNightMode();
    }

    public /* bridge */ /* synthetic */ void navigate(Intent intent) {
        super.navigate(intent);
    }

    public /* bridge */ /* synthetic */ boolean navigate(String str, Object obj, boolean z, Runnable runnable) {
        return super.navigate(str, obj, z, runnable);
    }

    public /* bridge */ /* synthetic */ boolean navigateSmoothly(String str) {
        return super.navigateSmoothly(str);
    }

    public /* bridge */ /* synthetic */ boolean navigateSmoothly(String str, Runnable runnable) {
        return super.navigateSmoothly(str, runnable);
    }

    public /* bridge */ /* synthetic */ void openBook(c cVar) {
        super.openBook(cVar);
    }

    public /* bridge */ /* synthetic */ void openBook(c cVar, Document_a aVar, Runnable runnable) {
        super.openBook(cVar, aVar, runnable);
    }

    public /* bridge */ /* synthetic */ void openBook(String str, Document_a aVar) {
        super.openBook(str, aVar);
    }

    public /* bridge */ /* synthetic */ void prompt(String str) {
        super.prompt(str);
    }

    public /* bridge */ /* synthetic */ void prompt(String str, int i) {
        super.prompt(str, i);
    }

    public /* bridge */ /* synthetic */ boolean pushFloatingPage(ActivatedController activatedControllerVar) {
        return super.pushFloatingPage(activatedControllerVar);
    }

    public /* bridge */ /* synthetic */ boolean pushFloatingPageSmoothly(ActivatedController activatedControllerVar, Runnable runnable) {
        return super.pushFloatingPageSmoothly(activatedControllerVar, runnable);
    }

    public /* bridge */ /* synthetic */ boolean pushHalfPage(ActivatedController activatedControllerVar) {
        return super.pushHalfPage(activatedControllerVar);
    }

    public /* bridge */ /* synthetic */ boolean pushHalfPageSmoothly(ActivatedController activatedControllerVar, Runnable runnable) {
        return super.pushHalfPageSmoothly(activatedControllerVar, runnable);
    }

    public /* bridge */ /* synthetic */ boolean pushPage(ActivatedController activatedControllerVar) {
        return super.pushPage(activatedControllerVar);
    }

    public /* bridge */ /* synthetic */ boolean pushPageSmoothly(ActivatedController activatedControllerVar, Runnable runnable) {
        return super.pushPageSmoothly(activatedControllerVar, runnable);
    }

    public /* bridge */ /* synthetic */ void removeSystemUiConditioner(SystemUiConditioner systemUiConditioner) {
        super.removeSystemUiConditioner(systemUiConditioner);
    }

    public /* bridge */ /* synthetic */ void setKeyboardBrightness(float f) {
        super.setKeyboardBrightness(f);
    }

    public /* bridge */ /* synthetic */ void setKeyboardBrightnessMode(BrightnessMode brightnessMode) {
        super.setKeyboardBrightnessMode(brightnessMode);
    }

    public /* bridge */ /* synthetic */ void setQuitOnBack(boolean z) {
        super.setQuitOnBack(z);
    }

    public /* bridge */ /* synthetic */ void setScreenBrightness(float f) {
        super.setScreenBrightness(f);
    }

    public /* bridge */ /* synthetic */ void setScreenBrightnessMode(BrightnessMode brightnessMode) {
        super.setScreenBrightnessMode(brightnessMode);
    }

    public /* bridge */ /* synthetic */ void setScreenTimeout(int i) {
        super.setScreenTimeout(i);
    }

    public /* bridge */ /* synthetic */ void shareBooks(ActivatedController activatedControllerVar, c[] cVarArr) {
        super.shareBooks(activatedControllerVar, cVarArr);
    }

    public /* bridge */ /* synthetic */ void showBookHomePage(IFeature featrue, String str, String str2, boolean z, String str3) {
        super.showBookHomePage(featrue, str, str2, z, str3);
    }

    public /* bridge */ /* synthetic */ void showMenuFromBottom(hb hbVar) {
        super.showMenuFromBottom(hbVar);
    }

    public /* bridge */ /* synthetic */ void showMenuFromTop(gx gxVar) {
        super.showMenuFromTop(gxVar);
    }

    public /* bridge */ /* synthetic */ boolean showPopup(ActivatedController activatedControllerVar) {
        return super.showPopup(activatedControllerVar);
    }

    public /* bridge */ /* synthetic */ boolean showPopup(ActivatedController activatedControllerVar, int i, int i2) {
        return super.showPopup(activatedControllerVar, i, i2);
    }

    public /* bridge */ /* synthetic */ boolean showPopupSmoothly(ActivatedController activatedControllerVar, Runnable runnable) {
        return super.showPopupSmoothly(activatedControllerVar, runnable);
    }

    public /* bridge */ /* synthetic */ void switchEyesSavingMode(boolean z) {
        super.switchEyesSavingMode(z);
    }

    public /* bridge */ /* synthetic */ void switchNightMode(boolean z, boolean z2) {
        super.switchNightMode(z, z2);
    }

    public /* bridge */ /* synthetic */ void updateSystemUi(boolean z) {
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
