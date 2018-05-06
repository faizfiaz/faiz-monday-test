package com.project.base.presenter.callback;


public interface RecyclerListener {
    void onItemClick(Object o);
    void onItemClickWithCondition(Object o, boolean condition);
    void update(Object o, int amount);
}
