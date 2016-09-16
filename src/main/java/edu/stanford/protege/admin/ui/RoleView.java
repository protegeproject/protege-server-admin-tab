package edu.stanford.protege.admin.ui;

import org.protege.editor.owl.ui.view.AbstractOWLViewComponent;

import java.awt.*;

/**
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public class RoleView extends AbstractOWLViewComponent {
    private static final long serialVersionUID = -3116849348395587405L;
    private RolePanel rolePanel;

    @Override
    protected void initialiseOWLView() throws Exception {
        setLayout(new BorderLayout());
        setBorder(UiUtils.MATTE_BORDER);
        rolePanel = new RolePanel(getOWLEditorKit());
        add(rolePanel, BorderLayout.CENTER);
    }

    @Override
    protected void disposeOWLView() {
        rolePanel.dispose();
    }
}
