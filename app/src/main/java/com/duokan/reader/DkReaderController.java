package com.duokan.reader;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.sys.af;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.ui.C0457r;
import com.duokan.reader.ui.bookshelf.he;
import com.duokan.reader.ui.bookshelf.hi;
import com.duokan.reader.ui.reading.su;

public class DkReaderController extends ReaderController {
    public void addSystemUiConditioner(SystemUiConditioner systemUiConditioner) {
        super.addSystemUiConditioner(systemUiConditioner);
    }

    public void chooseNavigationBarColor(af afVar) {
        super.chooseNavigationBarColor(afVar);
    }

    public void chooseNavigationBarMode(af afVar) {
        super.chooseNavigationBarMode(afVar);
    }

    public void chooseStatusBarStyle(af afVar) {
        super.chooseStatusBarStyle(afVar);
    }

    public void downloadBooks(C0800c[] c0800cArr) {
        super.downloadBooks(c0800cArr);
    }

    public float[] getEyesSavingModeDensity() {
        return super.getEyesSavingModeDensity();
    }

    public Drawable getHeaderBackground() {
        return super.getHeaderBackground();
    }

    public float getKeyboardBrightness() {
        return super.getKeyboardBrightness();
    }

    public BrightnessMode getKeyboardBrightnessMode() {
        return super.getKeyboardBrightnessMode();
    }

    public int getPageCount() {
        return super.getPageCount();
    }

    public C0800c getReadingBook() {
        return super.getReadingBook();
    }

    public su getReadingFeature() {
        return super.getReadingFeature();
    }

    public float getScreenBrightness() {
        return super.getScreenBrightness();
    }

    public BrightnessMode getScreenBrightnessMode() {
        return super.getScreenBrightnessMode();
    }

    public float[] getScreenBrightnessRange() {
        return super.getScreenBrightnessRange();
    }

    public int getScreenTimeout() {
        return super.getScreenTimeout();
    }

    public C0457r getTheme() {
        return super.getTheme();
    }

    public long getTotalActiveTime() {
        return super.getTotalActiveTime();
    }

    public void goHome(Runnable runnable) {
        super.goHome(runnable);
    }

    public boolean inNightMode() {
        return super.inNightMode();
    }

    public void navigate(Intent intent) {
        super.navigate(intent);
    }

    public boolean navigate(String str, Object obj, boolean z, Runnable runnable) {
        return super.navigate(str, obj, z, runnable);
    }

    public boolean navigateSmoothly(String str) {
        return super.navigateSmoothly(str);
    }

    public boolean navigateSmoothly(String str, Runnable runnable) {
        return super.navigateSmoothly(str, runnable);
    }

    public void openBook(C0800c c0800c) {
        super.openBook(c0800c);
    }

    public void openBook(C0800c c0800c, C0896a c0896a, Runnable runnable) {
        super.openBook(c0800c, c0896a, runnable);
    }

    public void openBook(String str, C0896a c0896a) {
        super.openBook(str, c0896a);
    }

    public void prompt(String str) {
        super.prompt(str);
    }

    public void prompt(String str, int i) {
        super.prompt(str, i);
    }

    public boolean pushFloatingPage(ActivatedController c0303e) {
        return super.pushFloatingPage(c0303e);
    }

    public boolean pushFloatingPageSmoothly(ActivatedController c0303e, Runnable runnable) {
        return super.pushFloatingPageSmoothly(c0303e, runnable);
    }

    public boolean pushHalfPage(ActivatedController c0303e) {
        return super.pushHalfPage(c0303e);
    }

    public boolean pushHalfPageSmoothly(ActivatedController c0303e, Runnable runnable) {
        return super.pushHalfPageSmoothly(c0303e, runnable);
    }

    public boolean pushPage(ActivatedController c0303e) {
        return super.pushPage(c0303e);
    }

    public boolean pushPageSmoothly(ActivatedController c0303e, Runnable runnable) {
        return super.pushPageSmoothly(c0303e, runnable);
    }

    public void removeSystemUiConditioner(SystemUiConditioner systemUiConditioner) {
        super.removeSystemUiConditioner(systemUiConditioner);
    }

    public void setKeyboardBrightness(float f) {
        super.setKeyboardBrightness(f);
    }

    public void setKeyboardBrightnessMode(BrightnessMode brightnessMode) {
        super.setKeyboardBrightnessMode(brightnessMode);
    }

    public void setQuitOnBack(boolean z) {
        super.setQuitOnBack(z);
    }

    public void setScreenBrightness(float f) {
        super.setScreenBrightness(f);
    }

    public void setScreenBrightnessMode(BrightnessMode brightnessMode) {
        super.setScreenBrightnessMode(brightnessMode);
    }

    public void setScreenTimeout(int i) {
        super.setScreenTimeout(i);
    }

    public void shareBooks(ActivatedController c0303e, C0800c[] c0800cArr) {
        super.shareBooks(c0303e, c0800cArr);
    }

    public void showBookHomePage(IFeature mFeature, String str, String str2, boolean z, String str3) {
        super.showBookHomePage(mFeature, str, str2, z, str3);
    }

    public void showMenuFromBottom(hi hiVar) {
        super.showMenuFromBottom(hiVar);
    }

    public void showMenuFromTop(he heVar) {
        super.showMenuFromTop(heVar);
    }

    public boolean showPopup(ActivatedController c0303e) {
        return super.showPopup(c0303e);
    }

    public boolean showPopup(ActivatedController c0303e, int i, int i2) {
        return super.showPopup(c0303e, i, i2);
    }

    public boolean showPopupSmoothly(ActivatedController c0303e, Runnable runnable) {
        return super.showPopupSmoothly(c0303e, runnable);
    }

    public void switchEyesSavingMode(boolean z) {
        super.switchEyesSavingMode(z);
    }

    public void switchNightMode(boolean z, boolean z2) {
        super.switchNightMode(z, z2);
    }

    public void updateSystemUi(boolean z) {
        super.updateSystemUi(z);
    }

    private DkReaderController(IFeature mFeature) {
        super(mFeature);
    }

    private DkReaderController(IFeature mFeature, Uri uri) {
        super(mFeature, uri);
    }

    private DkReaderController(BaseActivity mActivity, C0800c c0800c) {
        super((IFeature) mActivity, c0800c);
    }

    public static DkReaderController from(BaseActivity mActivity, String str) {
        if (!DkApp.get().isWebAccessEnabled() && TextUtils.isEmpty(str)) {
            return null;
        }
        C0800c b = TextUtils.isEmpty(str) ? ai.m3980a().m3906b(ReaderEnv.get().getReadingBookUuid()) : ai.m3980a().m3906b(str);
        if (b != null) {
            return new DkReaderController(mActivity, b);
        }
        return null;
    }

    public static DkReaderController from(BaseActivity mActivity, C0800c c0800c) {
        return new DkReaderController(mActivity, c0800c);
    }

    public static DkReaderController from(BaseActivity mActivity, Uri uri) {
        return new DkReaderController((IFeature) mActivity, uri);
    }

    public static DkReaderController from(DkMainActivity dkMainActivity) {
        return new DkReaderController(dkMainActivity);
    }
}
