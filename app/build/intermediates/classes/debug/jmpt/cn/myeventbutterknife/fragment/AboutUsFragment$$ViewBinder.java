// Generated code from Butter Knife. Do not modify!
package jmpt.cn.myeventbutterknife.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class AboutUsFragment$$ViewBinder<T extends jmpt.cn.myeventbutterknife.fragment.AboutUsFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624072, "field 'red'");
    target.red = finder.castView(view, 2131624072, "field 'red'");
    view = finder.findRequiredView(source, 2131624074, "field 'green'");
    target.green = finder.castView(view, 2131624074, "field 'green'");
    view = finder.findRequiredView(source, 2131624076, "field 'blue'");
    target.blue = finder.castView(view, 2131624076, "field 'blue'");
    view = finder.findRequiredView(source, 2131624070, "field 'qrbg'");
    target.qrbg = finder.castView(view, 2131624070, "field 'qrbg'");
    view = finder.findRequiredView(source, 2131624066, "field 'layout'");
    target.layout = finder.castView(view, 2131624066, "field 'layout'");
  }

  @Override public void unbind(T target) {
    target.red = null;
    target.green = null;
    target.blue = null;
    target.qrbg = null;
    target.layout = null;
  }
}
