package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.epublib.DkeResourceDescriptor;

public class aw {
    /* renamed from: a */
    public final String f4492a;
    /* renamed from: b */
    public final EpubResourceType f4493b;
    /* renamed from: c */
    public final String f4494c;
    /* renamed from: d */
    public final String f4495d;
    /* renamed from: e */
    public final long f4496e;
    /* renamed from: f */
    public final String f4497f;
    /* renamed from: g */
    public final String f4498g;
    /* renamed from: h */
    public final long f4499h;
    /* renamed from: i */
    public final boolean f4500i;

    protected aw(DkeResourceDescriptor dkeResourceDescriptor) {
        switch (dkeResourceDescriptor.resourceType) {
            case 0:
                this.f4493b = EpubResourceType.STRUCT;
                break;
            case 1:
                this.f4493b = EpubResourceType.TEXT;
                break;
            case 2:
                this.f4493b = EpubResourceType.IMAGE;
                break;
            case 3:
                this.f4493b = EpubResourceType.FONT;
                break;
            case 4:
                this.f4493b = EpubResourceType.MEDIA;
                break;
            default:
                this.f4493b = EpubResourceType.UNKNOWN;
                break;
        }
        this.f4492a = dkeResourceDescriptor.packUri;
        this.f4494c = dkeResourceDescriptor.resourceUri;
        this.f4495d = dkeResourceDescriptor.resourceMd5;
        this.f4496e = dkeResourceDescriptor.resourceSize;
        this.f4497f = dkeResourceDescriptor.lowQualityUri;
        this.f4498g = dkeResourceDescriptor.lowQualityMd5;
        this.f4499h = dkeResourceDescriptor.lowQualitySize;
        this.f4500i = dkeResourceDescriptor.hasDrm;
    }

    public int hashCode() {
        return this.f4492a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f4492a.equals(((aw) obj).f4492a);
    }
}
