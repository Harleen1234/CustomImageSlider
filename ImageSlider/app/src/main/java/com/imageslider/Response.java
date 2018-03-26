
package com.imageslider;

import java.util.ArrayList;
import java.util.List;


public class Response {

    private List<String> sliderImage = new ArrayList<String>();
    private List<String> pageImage = new ArrayList<String>();
    private List<String> bannerImage = new ArrayList<String>();

    /**
     * 
     * @return
     *     The sliderImage
     */
    public List<String> getSliderImage() {
        return sliderImage;
    }

    /**
     * 
     * @param sliderImage
     *     The slider_image
     */
    public void setSliderImage(List<String> sliderImage) {
        this.sliderImage = sliderImage;
    }

    /**
     * 
     * @return
     *     The pageImage
     */
    public List<String> getPageImage() {
        return pageImage;
    }

    /**
     * 
     * @param pageImage
     *     The page_image
     */
    public void setPageImage(List<String> pageImage) {
        this.pageImage = pageImage;
    }

    /**
     * 
     * @return
     *     The bannerImage
     */
    public List<String> getBannerImage() {
        return bannerImage;
    }

    /**
     * 
     * @param bannerImage
     *     The banner_image
     */
    public void setBannerImage(List<String> bannerImage) {
        this.bannerImage = bannerImage;
    }

}
