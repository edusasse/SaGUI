package com.sagui.ext.common.render.generic;

import java.io.IOException;

import com.sagui.ext.common.render.IComponentRender;
import com.sagui.ext.common.render.RenderException;
import com.sagui.ext.common.render.util.RenderWriter;
import com.sagui.model.FatuComponent;


public class FatuScriptPropertyRender<T extends FatuComponent> implements IComponentRender<T> {

    private final String scriptToRender;

    public FatuScriptPropertyRender(String scriptToRender) {
        this.scriptToRender = scriptToRender;
    }
    
    @Override
    public boolean render(T component, RenderWriter out) throws RenderException {
        try {
            out.tab().append(scriptToRender).ln();
        } catch (IOException e) {
            throw new RenderException(e);
        }
        return true;
    }

    @Override
    public void update(T component, RenderWriter out) throws RenderException {
        // TODO Auto-generated method stub
        
    }

}
