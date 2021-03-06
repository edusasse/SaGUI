package com.sagui.model.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sagui.dataset.commons.visitor.HierarchicalVisitor;
import com.sagui.dataset.commons.visitor.VisitorDirection;
import com.sagui.model.FatuComponent;
import com.sagui.model.FatuContainer;
import com.sagui.model.container.panel.FatuPanel;

@SuppressWarnings("unchecked")
public class FatuFindComponentVisitor<T extends FatuComponent> extends HierarchicalVisitor<T> {

    private T found;
    private final String toFind;

    public FatuFindComponentVisitor(String toFind) {
        super(VisitorDirection.TO_BOTTON);
        this.toFind = toFind;
    }

    @Override
    protected Collection<T> getChildren(T parent) {
        if (parent instanceof FatuContainer) {
            FatuContainer<T> container = (FatuContainer<T>) parent;
            List<T> children = container.getChildren();
            // For Panel with Toolbars
            if (parent instanceof FatuPanel) {
                FatuPanel<?> panel = (FatuPanel<?>) parent;
                if (panel.getToolbar() != null) {
                    children = new ArrayList<T>(children);
                    children.add((T) panel.getToolbar());
                }
            }
            return children;
        }
        return Collections.emptyList();
    }

    @Override
    protected T getParent(T child) {
        return (T) child.getParent();
    }

    @Override
    protected boolean acceptParent(T parent) {
        if (StringUtils.equals(parent.getId(), toFind)) {
            found = parent;
            return false;
        }
        return true;
    }

    @Override
    protected boolean acceptChild(T child) {
        if (StringUtils.equals(child.getId(), toFind)) {
            found = child;
            return false;
        }
        return true;
    }

    public <CMP extends FatuComponent> CMP getFound() {
        return (CMP) this.found;
    }

}
