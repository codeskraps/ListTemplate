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

import android.app.ListActivity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ListTemplateActivity extends ListActivity implements OnClickListener {
	
	private ListItemAdapter listItemAdapter;
	private Button btnAdd = null;
	private EditText etxtNew = null;
	
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.list_activity);
        
        /*
         * Set and fill the Adapter
         */
        listItemAdapter = new ListItemAdapter(this);
        setListAdapter(listItemAdapter);
        
        Drawable drawable = getResources().getDrawable(R.drawable.icon);
        
        for(int k = 0; k < 100; k++)
        {
        	listItemAdapter.addItem(new ListItem(false, "Item " + Integer.toString(k), drawable));
        }
        
        /*
         * Add Button
         */
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        
        etxtNew = (EditText) findViewById(R.id.etxtNew);
    }
    
    /*
     * Add a new Item to the list 
     */
	@Override
	public void onClick(View v) {
		Drawable drawable = getResources().getDrawable(R.drawable.icon);
		
		listItemAdapter.addItem(new ListItem(false, etxtNew.getText().toString(), drawable));
	}
}