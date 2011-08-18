/**
 * List Template
 * Copyright (C) Carles Sentis 2011 <carlesentis@gmail.com>
 *
 * List Template is free software: you can
 * redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later
 * version.
 *  
 * List Template is distributed in the hope that it
 * will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *  
 * You should have received a copy of the GNU
 * General Public License along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 */

package com.listtemplate;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ListItemAdapter extends BaseAdapter implements OnCheckedChangeListener, OnClickListener {
	private static final String TAG = ListItemAdapter.class.getSimpleName();

	private Context context;
	private LayoutInflater mInflater = null;
	private List<ListItem> mItems = new ArrayList<ListItem>(); 	// Our List of Items from ListItem.java

	public ListItemAdapter(Context context) {
		Log.d(TAG, "Constructor");
		this.context = context;
		mInflater = LayoutInflater.from(context);
	}

	public void addItem(ListItem it) {
		mItems.add(it);											// Adding Items to the list
	}

	public void setListItems(List<ListItem> lit) {				// Adding Items by passing a whole new List
		mItems = lit;
	}

	public int getCount() {
		return mItems.size();
	}

	public Object getItem(int position) {
		return mItems.get(position);
	}

	public long getItemId(int position) {
		return position;
	}
	
	/*
	 * This gets called every time ListView needs a new Row Item
	 * position holds the position on the row in the ListView
	 * convertView is the new view we have to filled with our custom --> list_item.xml
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vHolder = null;

		if (convertView != null)
			vHolder = (ViewHolder) convertView.getTag();								// convertView is been recycled
		else {
			convertView = (View) mInflater.inflate(R.layout.list_item, null);			// Set content of new View with list_item.xml

			vHolder = new ViewHolder();
			vHolder.checkBox = ((CheckBox) convertView.findViewById(R.id.lstChkbox));	// Getting pointers
			vHolder.textView = ((TextView) convertView.findViewById(R.id.lstText));
			vHolder.imageView = ((ImageView) convertView.findViewById(R.id.listImage));

			vHolder.checkBox.setOnCheckedChangeListener(this);							// Setting Listeners
			vHolder.imageView.setOnClickListener(this);
			
			convertView.setTag(vHolder);
		}

		vHolder.checkBox.setId(position);												// This is part of the Adapter APi
		vHolder.textView.setId(position);												// Do not delete !!!
		vHolder.imageView.setId(position);

		
		if (mItems.get(position).getChecked()) {										// Setting parameters for the View from our mItems list
			vHolder.checkBox.setChecked(true);
		} else {
			vHolder.checkBox.setChecked(false);
		}

		vHolder.textView.setText(mItems.get(position).getText());
		vHolder.imageView.setImageDrawable(mItems.get(position).getmImage());
		
		return convertView;
	}
	
	public static class ViewHolder {
		CheckBox checkBox;
		TextView textView;
		ImageView imageView;
	}

	/*
	 * Ok for this test but Toast are going to show every time the row comes into View
	 */
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		Log.d(TAG, "Checked");
		int position = buttonView.getId();

		if (isChecked) {
			mItems.get(position).setChecked(true);
			Toast.makeText(context, mItems.get(position).getText(), Toast.LENGTH_LONG).show();
		} else {
			mItems.get(buttonView.getId()).setChecked(false);
		}
	}

	@Override
	public void onClick(View v) {
		Toast.makeText(context, "ImageClicked", Toast.LENGTH_LONG).show();
	}
}