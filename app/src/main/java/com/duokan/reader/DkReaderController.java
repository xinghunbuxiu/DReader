package com.duokan.reader;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.e;
import com.duokan.core.app.m;
import com.duokan.core.app.y;
import com.duokan.core.sys.af;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.document.a;
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

    public /* bridge */ /* synthetic */ void openBook(c cVar, a aVar, Runnable runnable) {
        super.openBook(cVar, aVar, runnable);
    }

    public /* bridge */ /* synthetic */ void openBook(String str, a aVar) {
        super.openBook(str, aVar);
    }

    public /* bridge */ /* synthetic */ void prompt(String str) {
        super.prompt(str);
    }

    public /* bridge */ /* synthetic */ void prompt(String str, int i) {
        super.prompt(str, i);
    }

    public /* bridge */ /* synthetic */ boolean pushFloatingPage(e eVar) {
        return super.pushFloatingPage(eVar);
    }

    public /* bridge */ /* synthetic */ boolean pushFloatingPageSmoothly(e eVar, Runnable runnable) {
        return super.pushFloatingPageSmoothly(eVar, runnable);
    }

    public /* bridge */ /* synthetic */ boolean pushHalfPage(e eVar) {
        return super.pushHalfPage(eVar);
    }

    public /* bridge */ /* synthetic */ boolean pushHalfPageSmoothly(e eVar, Runnable runnable) {
        return super.pushHalfPageSmoothly(eVar, runnable);
    }

    public /* bridge */ /* synthetic */ boolean pushPage(e eVar) {
        return super.pushPage(eVar);
    }

    public /* bridge */ /* synthetic */ boolean pushPageSmoothly(e eVar, Runnable runnable) {
        return super.pushPageSmoothly(eVar, runnable);
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

    public /* bridge */ /* synthetic */ void shareBooks(e eVar, c[] cVarArr) {
        super.shareBooks(eVar, cVarArr);
    }

    public /* bridge */ /* synthetic */ void showBookHomePage(y yVar, String str, String str2, boolean z, String str3) {
        super.showBookHomePage(yVar, str, str2, z, str3);
    }

    public /* bridge */ /* synthetic */ void showMenuFromBottom(hb hbVar) {
        super.showMenuFromBottom(hbVar);
    }

    public /* bridge */ /* synthetic */ void showMenuFromTop(gx gxVar) {
        super.showMenuFromTop(gxVar);
    }

    public /* bridge */ /* synthetic */ boolean showPopup(e eVar) {
        return super.showPopup(eVar);
    }

    public /* bridge */ /* synthetic */ boolean showPopup(e eVar, int i, int i2) {
        return super.showPopup(eVar, i, i2);
    }

    public /* bridge */ /* synthetic */ boolean showPopupSmoothly(e eVar, Runnable runnable) {
        return super.showPopupSmoothly(eVar, runnable);
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

    private DkReaderController(y yVar) {
        super(yVar);
    }

    private DkReaderController(y yVar, Uri uri) {
        super(yVar, uri);
    }

    private DkReaderController(m mVar, c cVar) {
        super((y) mVar, cVar);
    }

    public static DkReaderController from(m mVar, String str) {
        if (!DkApp.get().isWebAccessEnabled() && TextUtils.isEmpty(str)) {
            return null;
        }
        c b = TextUtils.isEmpty(str) ? ai.a().b(ReaderEnv.get().getReadingBookUuid()) : ai.a().b(str);
        if (b != null) {
            return new DkReaderController(mVar, b);
        }
        return null;
    }

    public static DkReaderController from(m mVar, c cVar) {
        return new DkReaderController(mVar, cVar);
    }

    public static DkReaderController from(m mVar, Uri uri) {
        return new DkReaderController((y) mVar, uri);
    }

    public static DkReaderController from(DkMainActivity dkMainActivity) {
        return new DkReaderController(dkMainActivity);
    }
}
