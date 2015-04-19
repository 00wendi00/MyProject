package com.example.music.adapter;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.music.R;
import com.example.music.modle.Mp3Info;
import com.example.music.modle.MyApplication;

public class MyBaseAdapter extends BaseAdapter {
	
	private List<Mp3Info> mp3Infos;
	
	public MyBaseAdapter(List<Mp3Info> mp3Infos) {
		this.mp3Infos = mp3Infos;
	}

	@Override
	public int getCount() {
		return mp3Infos.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView ==null){
			convertView = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.music_list_item, null);
			holder = new ViewHolder();
			holder.img = (ImageView) convertView.findViewById(R.id.music_select);
			holder.title = (TextView) convertView.findViewById(R.id.music_title);
			holder.artist = (TextView) convertView.findViewById(R.id.music_Artist);
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.title.setText(mp3Infos.get(position).getTitle());
		holder.artist.setText(mp3Infos.get(position).getArtist());
		//每次加载adapter时判断labe的状态
		if(mp3Infos.get(position).getState()){
			holder.img.setVisibility(View.VISIBLE);
		}else{
			holder.img.setVisibility(View.GONE);
		}
		return convertView;
	}
	
    public final class ViewHolder{
        public ImageView img;
        public TextView title;
        public TextView artist;
    }
    
}
