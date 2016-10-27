package ua.com.sober.getwords.ui.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ua.com.sober.getwords.R;
import ua.com.sober.getwords.mvp.models.orm.Group;

/**
 * Created by dmitry on 10/26/16.
 */

public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.GroupViewHolder> {

    private List<Group> groups;

    public GroupsAdapter(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_rv_item, parent, false);
        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, int position) {
        Group group = groups.get(position);
        holder.groupNameTextView.setText(group.getName());
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class GroupViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final Context context;
        private CardView groupCardView;
        private TextView groupNameTextView;

        public GroupViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(this);
            groupCardView = (CardView) itemView.findViewById(R.id.group_card_view);
            groupNameTextView = (TextView) itemView.findViewById(R.id.group_name_text_view);
        }

        @Override
        public void onClick(View view) {
            Log.d("Test", "AdapterPosition: " + getAdapterPosition() +
                    ", LayoutPosition: " + getLayoutPosition()
            );
        }
    }
}
