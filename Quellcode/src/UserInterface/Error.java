package UserInterface;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class Error {

public static void open(String string, Exception e) {
	// TODO Automatisch generierter Methodenstub
	Display display = new Display();
    Shell shell = new Shell(display);

    int style = SWT.ICON_ERROR;
    
    //SWT.ICON_QUESTION | SWT.YES | SWT.NO
    
    MessageBox messageBox = new MessageBox(shell, style);
    messageBox.setMessage(string+e);
    int rc = messageBox.open();

    switch (rc) {
    case SWT.OK:
      break;
    case SWT.CANCEL:
      break;
    case SWT.YES:
      break;
    case SWT.NO:
      break;
    case SWT.RETRY:
      break;
    case SWT.ABORT:
      break;
    case SWT.IGNORE:
      break;
    }

    display.dispose();
}
public static void open2(String string) {
	// TODO Automatisch generierter Methodenstub
	Display display = new Display();
    Shell shell = new Shell(display);

    int style = SWT.ICON_ERROR;
    
    //SWT.ICON_QUESTION | SWT.YES | SWT.NO
    
    MessageBox messageBox = new MessageBox(shell, style);
    messageBox.setMessage(string);
    int rc = messageBox.open();

    switch (rc) {
    case SWT.OK:
      break;
    case SWT.CANCEL:
      break;
    case SWT.YES:
      break;
    case SWT.NO:
      break;
    case SWT.RETRY:
      break;
    case SWT.ABORT:
      break;
    case SWT.IGNORE:
      break;
    }

    display.dispose();
}
}
