package com.gcu.math.model.event;

import com.gcu.math.model.bean.Section;

/**
 * Created by Martin on 2016/10/17.
 */
public class SectionEvent {
    Section section;

    public SectionEvent(Section section) {
        this.section = section;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
