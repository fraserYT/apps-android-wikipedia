package org.wikipedia.dataclient.mwapi.page;

import android.support.annotation.Nullable;

import org.wikipedia.dataclient.page.PageRemaining;
import org.wikipedia.page.Page;
import org.wikipedia.page.Section;

import java.util.Collections;
import java.util.List;

/**
 * Gson POJO for loading remaining page content.
 */
public class MwMobileViewPageRemaining implements PageRemaining {
    @SuppressWarnings("unused") @Nullable private Mobileview mobileview;

    @Override
    public void mergeInto(Page page) {
        page.addRemainingSections(getSections());
    }

    private List<Section> getSections() {
        if (mobileview != null) {
            return mobileview.getSections();
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * Almost everything is in this inner class.
     */
    public static class Mobileview {
        @SuppressWarnings("unused") private List<Section> sections;

        @Nullable
        public List<Section> getSections() {
            return sections;
        }
    }
}
