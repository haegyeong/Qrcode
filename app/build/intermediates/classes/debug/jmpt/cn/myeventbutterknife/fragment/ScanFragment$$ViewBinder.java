// Generated code from Butter Knife. Do not modify!
package jmpt.cn.myeventbutterknife.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ScanFragment$$ViewBinder<T extends jmpt.cn.myeventbutterknife.fragment.ScanFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624087, "field 'ivScanned'");
    target.ivScanned = finder.castView(view, 2131624087, "field 'ivScanned'");
    view = finder.findRequiredView(source, 2131624089, "field 'btnScan' and method 'startScan'");
    target.btnScan = finder.castView(view, 2131624089, "field 'btnScan'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.startScan(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624088, "field 'tvScanned'");
    target.tvScanned = finder.castView(view, 2131624088, "field 'tvScanned'");
  }

  @Override public void unbind(T target) {
    target.ivScanned = null;
    target.btnScan = null;
    target.tvScanned = null;
  }
}
