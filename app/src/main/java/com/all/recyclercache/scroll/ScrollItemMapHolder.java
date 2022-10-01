// Dennis Lang
// Copyright LanDen Labs 2022
package com.all.recyclercache.scroll;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.all.recyclercache.R;

import java.lang.ref.WeakReference;


/**
 * Recycler View Holder for Map item
 */
public class ScrollItemMapHolder extends ScrollItemHolder {

    private final int idx;
    private WeakReference<TextView> txtViewRef;

    ScrollItemMapHolder(@NonNull View itemView, int idx) {
        super(itemView);
        this.idx = idx;
        getTv();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        // MemStats.cntViewHolder.decrementAndGet();
    }

    public TextView getTv() {
        if (txtViewRef == null || txtViewRef.get() == null) {
            txtViewRef = new WeakReference<>(itemView.findViewById(R.id.txtName));
        }
        return txtViewRef.get();
    }

    @Override
    public void onBindViewHolder(ScrollItem item) {
        getTv().setText("MapView Layer#" + idx);
    }

    @Override
    public void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
    }

    @Override
    public void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
    }
}
