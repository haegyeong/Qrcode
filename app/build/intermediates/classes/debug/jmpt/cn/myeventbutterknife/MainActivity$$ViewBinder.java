// Generated code from Butter Knife. Do not modify!
package jmpt.cn.myeventbutterknife;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends jmpt.cn.myeventbutterknife.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624053, "field 'tabLayout'");
    target.tabLayout = finder.castView(view, 2131624053, "field 'tabLayout'");
    view = finder.findRequiredView(source, 2131624054, "field 'viewPager'");
    target.viewPager = finder.castView(view, 2131624054, "field 'viewPager'");
  }

  @Override public void unbind(T target) {
    target.tabLayout = null;
    target.viewPager = null;
  }
}
