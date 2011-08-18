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

import android.graphics.drawable.Drawable;

/**
 * Each Row Item in our List is store here and used in our adapter
 */
public class ListItem implements Comparable<ListItem> {

	private String mText = "";
	private boolean mChecked;
	private Drawable mImage;

	public ListItem(boolean checked, String text, Drawable imageView) {
		setChecked(checked);
		setText(text);
		setmImage(imageView);
	}

	public void setChecked(boolean value) {
		this.mChecked = value;
	}

	public boolean getChecked() {
		return this.mChecked;
	}

	public String getText() {
		return mText;
	}

	public void setText(String text) {
		mText = text;
	}

	public Drawable getmImage() {
		return mImage;
	}

	public void setmImage(Drawable mImage) {
		this.mImage = mImage;
	}

	/** Make ListItem comparable by its name */
	public int compareTo(ListItem other) {
		if (this.mText != null)
			return this.mText.compareTo(other.getText());
		else
			throw new IllegalArgumentException();
	}
}