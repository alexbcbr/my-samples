package com.swg.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class OlaMundo {
	  public static void main(String[] args) {
	  	
	  	//* representa a janela do windows
	    Display display = new Display();
	    
	    //* abstracao to elemento mais top-level da janela
	    Shell shell = new Shell(display);
	    
	    //* texto
	    Label label = new Label(shell, SWT.CENTER);
	    label.setText("Hello, World");
	    label.setBounds(shell.getClientArea());
	    
	    //* abrir janela
	    shell.open();
	    
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }
	    display.dispose();
	  }
}
