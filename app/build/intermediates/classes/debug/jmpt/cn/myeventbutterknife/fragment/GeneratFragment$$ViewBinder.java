// Generated code from Butter Knife. Do not modify!
package jmpt.cn.myeventbutterknife.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class GeneratFragment$$ViewBinder<T extends jmpt.cn.myeventbutterknife.fragment.GeneratFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624077, "field 'textInputLayout'");
    target.textInputLayout = finder.castView(view, 2131624077, "field 'textInputLayout'");
    view = finder.findRequiredView(source, 2131624079, "field 'btnDelete' and method 'clearText'");
    target.btnDelete = finder.castView(view, 2131624079, "field 'btnDelete'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.clearText(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624082, "field 'btnGenerate' and method 'generate'");
    target.btnGenerate = finder.castView(view, 2131624082, "field 'btnGenerate'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.generate(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624083, "field 'btnDiscard' and method 'discard'");
    target.btnDiscard = finder.castView(view, 2131624083, "field 'btnDiscard'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.discard(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624084, "field 'btnSave' and method 'save'");
    target.btnSave = finder.castView(view, 2131624084, "field 'btnSave'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.save(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624080, "field 'tvHint'");
    target.tvHint = finder.castView(view, 2131624080, "field 'tvHint'");
    view = finder.findRequiredView(source, 2131624081, "field 'ivGenerated'");
    target.ivGenerated = finder.castView(view, 2131624081, "field 'ivGenerated'");
    view = finder.findRequiredView(source, 2131624078, "method 'onTextChanged'");
    ((android.widget.TextView) view).addTextChangedListener(
      new android.text.TextWatcher() {
        @Override public void onTextChanged(
          java.lang.CharSequence p0,
          int p1,
          int p2,
          int p3
        ) {
          target.onTextChanged(p0, p1, p2, p3);
        }
        @Override public void beforeTextChanged(
          java.lang.CharSequence p0,
          int p1,
          int p2,
          int p3
        ) {
          
        }
        @Override public void afterTextChanged(
          android.text.Editable p0
        ) {
          
        }
      });
  }

  @Override public void unbind(T target) {
    target.textInputLayout = null;
    target.btnDelete = null;
    target.btnGenerate = null;
    target.btnDiscard = null;
    target.btnSave = null;
    target.tvHint = null;
    target.ivGenerated = null;
  }
}
