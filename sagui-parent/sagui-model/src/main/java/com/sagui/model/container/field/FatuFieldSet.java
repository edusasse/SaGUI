package com.sagui.model.container.field;

import java.awt.Insets;

import com.sagui.model.FatuComponent;
import com.sagui.model.container.FatuLayoutContainer;
import com.sagui.model.feature.FatuSize;
import com.sagui.model.feature.IFatuMarginFeature;
import com.sagui.model.feature.IFatuPaddingFeature;
import com.sagui.model.feature.IFatuSizeFeature;
import com.sagui.model.layout.IFatuLayoutManager;
import com.sagui.model.layout.IFatuLayoutRule;

public class FatuFieldSet<MGR extends IFatuLayoutManager<? extends IFatuLayoutRule<MGR>>> extends FatuLayoutContainer<FatuComponent, MGR> implements IFatuSizeFeature, IFatuPaddingFeature, IFatuMarginFeature {

    private FatuSize size;
    private String title;
    private Insets padding;
    private Insets margin;


    public FatuFieldSet(MGR layout) {
        super(layout);
    }

    @Override
    public void setSize(FatuSize size) {
    	Object oldValue = this.size;
        this.size = size;
        this.getPropertyChangeSupport().firePropertyChange("size", oldValue, this.size);
    }

    @Override
    public FatuSize getSize() {
        return this.size;
    }

    public void setTitle(String title) {
    	Object oldValue = this.title;
        this.title = title;
        this.getPropertyChangeSupport().firePropertyChange("title", oldValue, this.title);
    }

    public String getTitle() {
        return title;
    }
    
    public void setPadding(Insets padding) {
    	Object oldValue = this.padding;
        this.padding = padding;
        this.getPropertyChangeSupport().firePropertyChange("padding", oldValue, this.padding);
    }

    @Override
    public Insets getPadding() {
        return this.padding;
    }

    @Override
    public void setMargins(Insets margin) {
    	Object oldValue = this.margin;
        this.margin = margin;
        this.getPropertyChangeSupport().firePropertyChange("margins", oldValue, this.margin);
    }

    @Override
    public Insets getMargins() {
        return this.margin;
    }


}