package com.sagui.model.container.toolbar;

import com.sagui.model.FatuComponent;


public interface IFatuSupportToolbar {

    public <TB extends FatuComponent> FatuToolbar<TB> getToolbar();
    
    public <TB extends FatuComponent> void setToolbar(FatuToolbar<TB> toolbar);
    
    
}
