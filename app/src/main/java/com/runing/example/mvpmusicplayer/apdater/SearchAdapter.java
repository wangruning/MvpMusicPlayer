package com.runing.example.mvpmusicplayer.apdater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.runing.example.mvpmusicplayer.R;
import com.runing.example.mvpmusicplayer.base.BaseRVAdapter;
import com.runing.example.mvpmusicplayer.data.bean.Music;
import com.runing.example.mvpmusicplayer.util.TimeUtils;

import java.util.List;

/**
 * Created by runing on 2016/5/14.
 * <p/>
 * This file is part of MvpMusicPlayer.
 * MvpMusicPlayer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * MvpMusicPlayer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with MvpMusicPlayer.  If not, see <http://www.gnu.org/licenses/>.
 */
public final class SearchAdapter extends BaseRVAdapter<SearchAdapter.ViewHolder> {

    private Context mContext;

    private float mItemMargin;

    public SearchAdapter(Context mContext, List<?> mData) {
        super(mData);
        this.mContext = mContext;
        mItemMargin = mContext.getResources().getDimension(R.dimen.margin_normal);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_music_list, null);
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.topMargin = (int) mItemMargin;
        params.leftMargin = (int) (mItemMargin / 2);
        params.rightMargin = (int) (mItemMargin / 2);

        itemView.setLayoutParams(params);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Music data = (Music) getItemData(position);
        holder.name.setText(data.getTitle());
        holder.singer.setText(data.getArtist());
        holder.time.setText(TimeUtils.millis2MSStr(data.getDuration()));
        holder.more.setVisibility(View.GONE);
    }

    protected static final class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView singer;
        private TextView time;
        private ImageView more;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            singer = (TextView) itemView.findViewById(R.id.tv_singer);
            time = (TextView) itemView.findViewById(R.id.tv_time);
            more = (ImageView) itemView.findViewById(R.id.iv_more);
        }
    }
}
