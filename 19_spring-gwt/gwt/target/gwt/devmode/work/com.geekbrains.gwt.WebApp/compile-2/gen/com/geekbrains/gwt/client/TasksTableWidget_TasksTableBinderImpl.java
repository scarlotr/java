// .ui.xml template last modified: 1576570328000
package com.geekbrains.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class TasksTableWidget_TasksTableBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.geekbrains.gwt.client.TasksTableWidget>, com.geekbrains.gwt.client.TasksTableWidget.TasksTableBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.geekbrains.gwt.client.TasksTableWidget owner) {


    return new Widgets(owner).get_table();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final com.geekbrains.gwt.client.TasksTableWidget owner;


    public Widgets(final com.geekbrains.gwt.client.TasksTableWidget owner) {
      this.owner = owner;
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private com.geekbrains.gwt.client.TasksTableWidget_TasksTableBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private com.geekbrains.gwt.client.TasksTableWidget_TasksTableBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final com.geekbrains.gwt.client.TasksTableWidget_TasksTableBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.geekbrains.gwt.client.TasksTableWidget_TasksTableBinderImpl_GenBundle) GWT.create(com.geekbrains.gwt.client.TasksTableWidget_TasksTableBinderImpl_GenBundle.class);
      // Setup section.

      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for table called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.cellview.client.CellTable get_table() {
      return build_table();
    }
    private com.google.gwt.user.cellview.client.CellTable build_table() {
      // Creation section.
      final com.google.gwt.user.cellview.client.CellTable table = (com.google.gwt.user.cellview.client.CellTable) GWT.create(com.google.gwt.user.cellview.client.CellTable.class);
      // Setup section.
      table.setWidth("100%");
      table.setPageSize(15);

      this.owner.table = table;

      return table;
    }
  }
}
