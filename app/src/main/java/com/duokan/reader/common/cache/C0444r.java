package com.duokan.reader.common.cache;

import android.content.ContentValues;

/* renamed from: com.duokan.reader.common.cache.r */
public interface C0444r<TItem, TJson> {
    aa[] getPropertyDefinitions();

    ContentValues getPropertyValues(TItem tItem);

    String getUniqueId(TItem tItem);

    TJson serializeItemCorePropertiesToJson(TItem tItem);

    TJson serializeItemToJson(TItem tItem, TJson tJson);
}
