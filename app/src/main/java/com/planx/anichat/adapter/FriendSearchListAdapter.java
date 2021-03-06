package com.planx.anichat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.planx.anichat.R;

import java.util.List;

public class FriendSearchListAdapter extends BaseAdapter implements View.OnClickListener {
    private List<String> mList;
    private Context mContext;
    private FriendSearchListAdapter.InnerItemOnclickListener mListener;
    private int mPosition;

    public FriendSearchListAdapter(List<String> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }
    @Override
    public void onClick(View v) {
        mListener.itemClick(v);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mPosition = position;
        final FriendSearchListAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new FriendSearchListAdapter.ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_search_friend,
                    null);
            viewHolder.bt = (Button) convertView.findViewById(R.id.bt_search_add);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.search_user_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (FriendSearchListAdapter.ViewHolder) convertView.getTag();
        }
        viewHolder.bt.setOnClickListener(this);
        viewHolder.bt.setTag(position);
        viewHolder.tv.setText(mList.get(position));
        return convertView;
    }

    public final class ViewHolder {
        Button bt;
        TextView tv;
    }

    public interface InnerItemOnclickListener {
        void itemClick(View v);
    }

    public void setOnInnerItemOnClickListener(FriendSearchListAdapter.InnerItemOnclickListener listener){
        this.mListener=listener;
    }
}
