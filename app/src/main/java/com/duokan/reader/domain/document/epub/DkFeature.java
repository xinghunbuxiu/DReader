package com.duokan.reader.domain.document.epub;

public enum DkFeature {
    IMAGE_CLIP(true),
    IMAGE_GALLERY(true),
    IMAGE_MULTIFRAME(false),
    IMAGE_MULTICALLOUT(false),
    IMAGE_LINK(true),
    AUDIO(false),
    VIDEO(false),
    MEDIA_OVERLAY(false),
    RICH_NOTE(true),
    FORMULA(true),
    MODEL3D(false),
    SPREAD_FULLSCREEN(false),
    INTERACTIVE_FULLSCREEN(false),
    INTERACTIVE_TABLE(false),
    INTERACTIVE_CODE(true),
    FRAME_COMIC(false),
    PAGE_COMIC(false),
    VERTICAL_COMIC(false);

    private final boolean mLinearizable;

    private DkFeature(boolean z) {
        this.mLinearizable = z;
    }

    public boolean isLinearizable() {
        return this.mLinearizable;
    }
}
