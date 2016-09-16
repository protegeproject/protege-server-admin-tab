package edu.stanford.protege.admin.ui;

import org.protege.editor.owl.ui.view.AbstractOWLViewComponent;

import java.awt.*;

/**
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public class OperationView extends AbstractOWLViewComponent {
    private static final long serialVersionUID = 2312008811379672027L;
    private OperationPanel operationPanel;

    @Override
    protected void initialiseOWLView() throws Exception {
        setLayout(new BorderLayout());
        setBorder(UiUtils.MATTE_BORDER);
        operationPanel = new OperationPanel(getOWLEditorKit());
        add(operationPanel, BorderLayout.CENTER);
    }

    @Override
    protected void disposeOWLView() {
        operationPanel.dispose();
    }
}
