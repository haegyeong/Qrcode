// Generated code from Butter Knife. Do not modify!
package jmpt.cn.myeventbutterknife.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class HistoryFragment$$ViewBinder<T extends jmpt.cn.myeventbutterknife.fragment.HistoryFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624085, "field 'recyclerView'");
    target.recyclerView = finder.castView(view, 2131624085, "field 'recyclerView'");
    view = finder.findRequiredView(source, 2131624086, "field 'tvNodata'");
    target.tvNodata = finder.castView(view, 2131624086, "field 'tvNodata'");
  }

  @Override public void unbind(T target) {
    target.recyclerView = null;
    target.tvNodata = null;
  }
}
