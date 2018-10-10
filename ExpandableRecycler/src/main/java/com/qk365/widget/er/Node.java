package com.qk365.widget.er;

import java.util.List;

public interface Node<T> {

    boolean isExpanded();

    void expand();

    void collapse();

    int getLevel();

    void setLevel(int level);

    T getValue();

    void setValue(T value);

    boolean hasChild();

    int getChildNodeCount();

    List<Node<T>> getChildNodes();

}
