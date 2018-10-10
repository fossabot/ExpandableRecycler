package com.qk365.widget.er;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public abstract class ExpandableRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private List<Node<T>> mItems = new ArrayList<>();

    public ExpandableRecyclerAdapter(RecyclerView recycler) {
        if (recycler == null) {
            throw new IllegalArgumentException("recycler cannot be null");
        }
        recycler.setLayoutManager(new LinearLayoutManager(recycler.getContext()));
        recycler.setAdapter(this);
    }

    public void setItems(List<Node<T>> nodes) {
        mItems.clear();
        mItems.addAll(nodes);
        notifyDataSetChanged();
    }

    public abstract void onBindViewHolder(VH holder, int position, int viewType, Node<T> node);

    @Override
    public void onBindViewHolder(VH holder, final int position) {
        Node<T> node = mItems.get(position);
        if (node.hasChild()) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Node<T> iNode = mItems.get(position);
                    if (iNode.isExpanded()) {
                        collapse(position);
                    } else {
                        expand(position);
                    }
                }
            });
        }

        onBindViewHolder(holder, position, getItemViewType(position), node);
    }

    private void collapse(int position) {
        Node<T> node = mItems.get(position);
        if (!node.isExpanded()) {
            return;
        }
        node.collapse();
        mItems.set(position, node);
        notifyItemChanged(position);
        int last = position + node.getChildNodeCount();
        for (int i = last; i > position; i--) {
            collapse(i);
            mItems.remove(i);
        }
        notifyItemRangeRemoved(position + 1, node.getChildNodeCount());
        notifyItemRangeChanged(position + 1, mItems.size() - position - 1);
    }

    private void expand(int position) {
        Node<T> node = mItems.get(position);
        if (node.isExpanded()) {
            return;
        }
        node.expand();
        mItems.set(position, node);
        notifyItemChanged(position);
        int last = position + node.getChildNodeCount();
        mItems.addAll(position + 1, node.getChildNodes());
        notifyItemRangeInserted(position + 1, node.getChildNodeCount());
        notifyItemRangeChanged(last + 1, mItems.size() - last);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public Node<T> getItem(int position) {
        return mItems.get(position);
    }

}
