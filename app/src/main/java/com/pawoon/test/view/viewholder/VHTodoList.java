package com.pawoon.test.view.viewholder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.pawoon.test.R;
import com.pawoon.test.presenter.callback.RecyclerListener;
import com.pawoon.test.presenter.database.table.TodoListTable;

/**
 * Created by faizf on 07/05/2018.
 */

public class VHTodoList extends BaseViewHolder implements View.OnClickListener {

    TextView title;
    CheckBox checkBox;

    public VHTodoList(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        title = (TextView) findView(R.id.title);
        checkBox = (CheckBox) findView(R.id.checkbox);
        itemView.setOnClickListener(this);
    }

    public void setData(TodoListTable data) {
        title.setText(data.getTitle());
        if (data.getCompleted() == 1){
            checkBox.setChecked(true);
        }else {
            checkBox.setChecked(false);
        }
    }

    @Override
    public void onClick(View v) {
        recyclerListener.onItemClick(itemView.getTag());
    }
}
