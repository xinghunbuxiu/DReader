package com.duokan.reader.domain.store;

public abstract class DkStoreCategory extends DkStoreItem {
    public abstract int getBookCount();

    public abstract String getCategoryId();

    public abstract DkStoreCategory[] getChildBookCategories();

    public abstract String getChildCategoriesLabel();

    public abstract String getCoverUri();

    public abstract String getDescription();

    public abstract String getImageUri();

    public abstract String getLabel();

    public abstract String getTitles();
}
