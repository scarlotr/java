// .ui.xml template last modified: 1576570328000
package com.geekbrains.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class AddTaskFormWidget_AddTaskFormBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.geekbrains.gwt.client.AddTaskFormWidget>, com.geekbrains.gwt.client.AddTaskFormWidget.AddTaskFormBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("Создать")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.geekbrains.gwt.client.AddTaskFormWidget owner) {


    return new Widgets(owner).get_f_DecoratorPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final com.geekbrains.gwt.client.AddTaskFormWidget owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.submitClick((com.google.gwt.event.dom.client.ClickEvent) event);
      }
    };

    public Widgets(final com.geekbrains.gwt.client.AddTaskFormWidget owner) {
      this.owner = owner;
    }

    SafeHtml template_html1() {
      return template.html1();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private com.geekbrains.gwt.client.AddTaskFormWidget_AddTaskFormBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private com.geekbrains.gwt.client.AddTaskFormWidget_AddTaskFormBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final com.geekbrains.gwt.client.AddTaskFormWidget_AddTaskFormBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.geekbrains.gwt.client.AddTaskFormWidget_AddTaskFormBinderImpl_GenBundle) GWT.create(com.geekbrains.gwt.client.AddTaskFormWidget_AddTaskFormBinderImpl_GenBundle.class);
      // Setup section.

      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for f_DecoratorPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.DecoratorPanel get_f_DecoratorPanel1() {
      return build_f_DecoratorPanel1();
    }
    private com.google.gwt.user.client.ui.DecoratorPanel build_f_DecoratorPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.DecoratorPanel f_DecoratorPanel1 = (com.google.gwt.user.client.ui.DecoratorPanel) GWT.create(com.google.gwt.user.client.ui.DecoratorPanel.class);
      // Setup section.
      f_DecoratorPanel1.add(get_form());

      return f_DecoratorPanel1;
    }

    /**
     * Getter for form called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FormPanel get_form() {
      return build_form();
    }
    private com.google.gwt.user.client.ui.FormPanel build_form() {
      // Creation section.
      final com.google.gwt.user.client.ui.FormPanel form = (com.google.gwt.user.client.ui.FormPanel) GWT.create(com.google.gwt.user.client.ui.FormPanel.class);
      // Setup section.
      form.add(get_f_VerticalPanel2());
      form.setMethod("POST");

      this.owner.form = form;

      return form;
    }

    /**
     * Getter for f_VerticalPanel2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_f_VerticalPanel2() {
      return build_f_VerticalPanel2();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_f_VerticalPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel2 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.
      f_VerticalPanel2.add(get_f_Label3());
      f_VerticalPanel2.add(get_f_HorizontalPanel4());
      f_VerticalPanel2.add(get_f_HorizontalPanel6());
      f_VerticalPanel2.add(get_f_HorizontalPanel8());
      f_VerticalPanel2.add(get_f_HorizontalPanel10());
      f_VerticalPanel2.add(get_btnSubmit());
      f_VerticalPanel2.setSpacing(10);

      return f_VerticalPanel2;
    }

    /**
     * Getter for f_Label3 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label3() {
      return build_f_Label3();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label3() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label3.setText("Добавить задачу");

      return f_Label3;
    }

    /**
     * Getter for f_HorizontalPanel4 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel4() {
      return build_f_HorizontalPanel4();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel4 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel4.add(get_f_Label5());
      f_HorizontalPanel4.add(get_nameText());

      return f_HorizontalPanel4;
    }

    /**
     * Getter for f_Label5 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label5() {
      return build_f_Label5();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label5() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label5.setWidth("100px");
      f_Label5.setText("Name:");

      return f_Label5;
    }

    /**
     * Getter for nameText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.TextBox get_nameText() {
      return build_nameText();
    }
    private com.google.gwt.user.client.ui.TextBox build_nameText() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox nameText = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      nameText.setName("name");

      this.owner.nameText = nameText;

      return nameText;
    }

    /**
     * Getter for f_HorizontalPanel6 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel6() {
      return build_f_HorizontalPanel6();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel6 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel6.add(get_f_Label7());
      f_HorizontalPanel6.add(get_ownerText());

      return f_HorizontalPanel6;
    }

    /**
     * Getter for f_Label7 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label7() {
      return build_f_Label7();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label7() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label7.setWidth("100px");
      f_Label7.setText("Owner:");

      return f_Label7;
    }

    /**
     * Getter for ownerText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.TextBox get_ownerText() {
      return build_ownerText();
    }
    private com.google.gwt.user.client.ui.TextBox build_ownerText() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox ownerText = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      ownerText.setName("owner");

      this.owner.ownerText = ownerText;

      return ownerText;
    }

    /**
     * Getter for f_HorizontalPanel8 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel8() {
      return build_f_HorizontalPanel8();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel8 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel8.add(get_f_Label9());
      f_HorizontalPanel8.add(get_executorText());

      return f_HorizontalPanel8;
    }

    /**
     * Getter for f_Label9 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label9() {
      return build_f_Label9();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label9() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label9.setWidth("100px");
      f_Label9.setText("Executor:");

      return f_Label9;
    }

    /**
     * Getter for executorText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.TextBox get_executorText() {
      return build_executorText();
    }
    private com.google.gwt.user.client.ui.TextBox build_executorText() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox executorText = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      executorText.setName("executor");

      this.owner.executorText = executorText;

      return executorText;
    }

    /**
     * Getter for f_HorizontalPanel10 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel10() {
      return build_f_HorizontalPanel10();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel10 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel10.add(get_f_Label11());
      f_HorizontalPanel10.add(get_descriptionText());

      return f_HorizontalPanel10;
    }

    /**
     * Getter for f_Label11 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label11() {
      return build_f_Label11();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label11() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label11 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label11.setWidth("100px");
      f_Label11.setText("Description:");

      return f_Label11;
    }

    /**
     * Getter for descriptionText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.TextBox get_descriptionText() {
      return build_descriptionText();
    }
    private com.google.gwt.user.client.ui.TextBox build_descriptionText() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox descriptionText = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      descriptionText.setName("description");

      this.owner.descriptionText = descriptionText;

      return descriptionText;
    }

    /**
     * Getter for btnSubmit called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_btnSubmit() {
      return build_btnSubmit();
    }
    private com.google.gwt.user.client.ui.Button build_btnSubmit() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnSubmit = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnSubmit.setHTML(template_html1().asString());
      btnSubmit.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

      return btnSubmit;
    }
  }
}
