package br.com.exemplo.bancoDemo.view;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import br.com.exemplo.bancoDemo.common.AgenciaVO;
import br.com.exemplo.bancoDemo.data.OperacoesContentProvider;
import br.com.exemplo.bancoDemo.data.OperacoesData;


public class OperacoesTableSort extends ApplicationWindow {
  private OperacoesData model;
  private TableViewer tv;

  public OperacoesTableSort() {
    super(null);
    model = new OperacoesData();
  }

  public void run() {
    setBlockOnOpen(true);
    open();
    Display.getCurrent().dispose();
  }

  protected void configureShell(Shell shell) {
    super.configureShell(shell);
    shell.setSize(300, 200);
  }

  protected Control createContents(Composite parent) {
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new GridLayout(1, false));

    Combo combo = new Combo(composite, SWT.READ_ONLY);
    combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

    tv = new TableViewer(composite);

    tv.setContentProvider(new OperacoesContentProvider());
    tv.setLabelProvider(new OperacoesLabelProvider());
    //tv.setSorter(new PlayerViewerSorter());

    Table table = tv.getTable();
    table.setLayoutData(new GridData(GridData.FILL_BOTH));

    TableColumn tc = new TableColumn(table, SWT.LEFT);
    tc.setText("Operação");
 /*   tc.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        ((PlayerViewerSorter) tv.getSorter())
            .doSort(PlayerConst.COLUMN_FIRST_NAME);
        tv.refresh();
      }
    });
*/
    tc = new TableColumn(table, SWT.LEFT);
    tc.setText("Tendência");
 /*   tc.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        ((PlayerViewerSorter) tv.getSorter())
            .doSort(PlayerConst.COLUMN_LAST_NAME);
        tv.refresh();
      }
    });
*/
    tc = new TableColumn(table, SWT.RIGHT);
    tc.setText("Volume financeiro");
/*    tc.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        ((PlayerViewerSorter) tv.getSorter()).doSort(PlayerConst.COLUMN_POINTS);
        tv.refresh();
      }
    });
*/
    for (int i = 0, n = model.agencia.length; i < n; i++) {
      combo.add(model.agencia[i].getNome());
    }

    combo.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        update(model.agencia[((Combo) event.widget).getSelectionIndex()]);
      }
    });

    combo.select(0);
    update(model.agencia[0]);

    for (int i = 0, n = table.getColumnCount(); i < n; i++) {
      table.getColumn(i).pack();
    }

    table.setHeaderVisible(true);
    table.setLinesVisible(true);

    return composite;
  }

  private void update(AgenciaVO agencia) {
    getShell().setText("Monitor de Agência: " + agencia.getCodigo() + " " + agencia.getNome());
    tv.setInput(agencia);
  }

  public static void main(String[] args) {
    new OperacoesTableSort().run();
  }
}