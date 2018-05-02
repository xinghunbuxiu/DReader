package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.epublib.DkeResourceDescriptor;

public class aw {
    public final String a;
    public final EpubResourceType b;
    public final String c;
    public final String d;
    public final long e;
    public final String f;
    public final String g;
    public final long h;
    public final boolean i;

    protected aw(DkeResourceDescriptor dkeResourceDescriptor) {
        switch (dkeResourceDescriptor.resourceType) {
            case 0:
                this.b = EpubResourceType.STRUCT;
                break;
            case 1:
                this.b = EpubResourceType.TEXT;
                break;
            case 2:
                this.b = EpubResourceType.IMAGE;
                break;
            case 3:
                this.b = EpubResourceType.FONT;
                break;
            case 4:
                this.b = EpubResourceType.MEDIA;
                break;
            default:
                this.b = EpubResourceType.UNKNOWN;
                break;
        }
        this.a = dkeResourceDescriptor.packUri;
        this.c = dkeResourceDescriptor.resourceUri;
        this.d = dkeResourceDescriptor.resourceMd5;
        this.e = dkeResourceDescriptor.resourceSize;
        this.f = dkeResourceDescriptor.lowQualityUri;
        this.g = dkeResourceDescriptor.lowQualityMd5;
        this.h = dkeResourceDescriptor.lowQualitySize;
        this.i = dkeResourceDescriptor.hasDrm;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((aw) obj).a);
    }
}
