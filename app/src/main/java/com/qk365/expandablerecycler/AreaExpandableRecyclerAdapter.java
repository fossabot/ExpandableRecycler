package com.qk365.expandablerecycler;

import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.qk365.widget.er.ExpandableRecyclerAdapter;
import com.qk365.widget.er.Node;

public class AreaExpandableRecyclerAdapter extends ExpandableRecyclerAdapter<Area, RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_FOLDER = 1;
    private final int VIEW_TYPE_FILE = 2;

    private int LEVEL_PADDING = 0;
    private int TOP_PADDING = 0;
    private int BOTTOM_PADDING = 0;

    public AreaExpandableRecyclerAdapter(RecyclerView recycler) {
        super(recycler);

        LEVEL_PADDING = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, recycler.getContext().getResources().getDisplayMetrics());
        TOP_PADDING = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, recycler.getContext().getResources().getDisplayMetrics());
        BOTTOM_PADDING = TOP_PADDING;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).hasChild() ? VIEW_TYPE_FOLDER : VIEW_TYPE_FILE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case VIEW_TYPE_FILE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file, parent, false);
                holder = new FileViewHolder(view);
                break;
            case VIEW_TYPE_FOLDER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_folder, parent, false);
                holder = new FolderViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, int viewType, Node<Area> node) {
        switch (viewType) {
            case VIEW_TYPE_FILE:
                ((FileViewHolder) holder).setName(node.getValue().getCeaCode() + node.getValue().getCeaName());
                break;
            case VIEW_TYPE_FOLDER:
                ((FolderViewHolder) holder).setName(node.getValue().getCeaCode() + node.getValue().getCeaName());
                ((FolderViewHolder) holder).setExpandState(node.isExpanded());
                break;
        }
        holder.itemView.setPadding(LEVEL_PADDING * node.getLevel(), TOP_PADDING, TOP_PADDING, 0);
    }

    class FolderViewHolder extends RecyclerView.ViewHolder {

        private TextView mName;
        private CheckBox mIndicator;
        private CheckBox mIcon;

        public FolderViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.name);
            mIndicator = itemView.findViewById(R.id.folder_indicator);
            mIcon = itemView.findViewById(R.id.folder_icon);
        }

        public void setName(String name) {
            mName.setText(name);
        }

        public void setExpandState(boolean expanded) {
            mIndicator.setChecked(expanded);
            mIcon.setChecked(expanded);
        }
    }

    class FileViewHolder extends RecyclerView.ViewHolder {

        private TextView mName;

        public FileViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.name);
        }

        public void setName(String name) {
            mName.setText(name);
        }
    }
}
