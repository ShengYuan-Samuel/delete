package com.ninstarscf.delete;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * @author Samuel
 * @time 2018/9/28 13:38
 * @describe
 */
public class FriendAdapter extends  RecyclerView.Adapter<FriendAdapter.Holder> implements View.OnClickListener {
    private List<QQPointBean> mList;
    private Context context;

    public FriendAdapter(List<QQPointBean> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int position) {
        QQPointBean messafe = mList.get(position);
        holder.messafePhotoCiv.setImageResource(messafe.getPhoto());
        holder.messageNameTv.setText(messafe.getName());
        holder.messageContentTv.setText(messafe.getContext());
        holder.messageTimeTv.setText(messafe.getTime());
        holder.newsNumberPv.setText(messafe.getNumber() + "");

        holder.messafePhotoCiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onHeadImgClickListener(position);
            }
        });
        holder.messageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onDeleteClickListener(position,holder.swipe_menu);
            }
        });
        holder.itemView.setTag(position);
    }

    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public void onClick(View v) {
        if (onClickListener != null) {
            onClickListener.onItemClickListener((int) v.getTag());
        }
    }

    public interface OnClickListener {
        void onHeadImgClickListener(int position);

        void onDeleteClickListener(int position,SwipeMenuLayout swipeMenuLayout);

        void onItemClickListener(int position);
    }

    @Override
    public int getItemCount() {
        return mList.isEmpty() ? 0 : mList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView messafePhotoCiv;
        TextView messageNameTv;
        TextView messageContentTv;
        TextView messageTimeTv;
        QQBezierView newsNumberPv;
        TextView messageDelete;
        SwipeMenuLayout swipe_menu;

        public Holder(View itemView) {
            super(itemView);
            messafePhotoCiv =  itemView.findViewById(R.id.message_photo_civ);
            messageNameTv = itemView.findViewById(R.id.message_name_tv);
            messageContentTv = itemView.findViewById(R.id.message_content_tv);
            messageTimeTv = itemView.findViewById(R.id.message_time_tv);
            newsNumberPv =itemView.findViewById(R.id.news_number_pv);
            messageDelete = itemView.findViewById(R.id.tv_to_delete);
            swipe_menu = itemView.findViewById(R.id.swipe_menu);
        }
    }
}
