package br.com.exemplo.jface;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class OlaMundo extends ApplicationWindow {

	  public OlaMundo() {
	    super(null);
	  }

	  public void runa() {
	    setBlockOnOpen(true);
	    open();
	    Display.getCurrent().dispose();
	  }

	  protected Control createContents(Composite parent) {
	  	Composite composite = new Composite(parent, SWT.NONE);
	  	composite.setLayout(new GridLayout(1, false));
	  	
	    Label label = new Label(composite, SWT.CENTER);
	    label.setText("Ola Mundo 2");
	    
	    Button show = new Button(composite, SWT.PUSH);
	    show.setText("Ok");
	    show.addSelectionListener(new SelectionAdapter(){
	    	public void widgetSelected(SelectionEvent event){
	    	    MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Titulo", "Mensagem de Aviso");
	    	}
	    }	
	    );
	    
	    return composite;
	  }

	  public static void main(String[] args) {
	    new OlaMundo().runa();
	  }
}
