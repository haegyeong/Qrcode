// Generated code from Butter Knife. Do not modify!
package jmpt.cn.myeventbutterknife.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MyRecyclerViewAdapter$MyViewHolder$$ViewBinder<T extends jmpt.cn.myeventbutterknife.adapter.MyRecyclerViewAdapter.MyViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624091, "field 'iv'");
    target.iv = finder.castView(view, 2131624091, "field 'iv'");
    view = finder.findRequiredView(source, 2131624092, "field 'tvText'");
    target.tvText = finder.castView(view, 2131624092, "field 'tvText'");
    view = finder.findRequiredView(source, 2131624093, "field 'tvDate'");
    target.tvDate = finder.castView(view, 2131624093, "field 'tvDate'");
  }

  @Override public void unbind(T target) {
    target.iv = null;
    target.tvText = null;
    target.tvDate = null;
  }
}
