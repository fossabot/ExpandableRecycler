package com.qk365.widget.er;

import java.util.ArrayList;
import java.util.List;

public class SimpleNode<T> implements Node<T> {

    private boolean expand = false;
    private int level = 0;
    private T value;
    private List<Node<T>> childNodes;

    public SimpleNode(int level, T value) {
        this.expand = false;
        this.level = level;
        this.value = value;
        childNodes = new ArrayList<>();
    }

    @Override
    public boolean isExpanded() {
        return expand;
    }

    @Override
    public void expand() {
        expand = true;
    }

    @Override
    public void collapse() {
        expand = false;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean hasChild() {
        return childNodes.size() != 0;
    }

    @Override
    public int getChildNodeCount() {
        return childNodes.size();
    }

    @Override
    public List<Node<T>> getChildNodes() {
        return childNodes;
    }

    protected void setChildNodes(List<Node<T>> nodes) {
        childNodes = nodes;
    }
}
