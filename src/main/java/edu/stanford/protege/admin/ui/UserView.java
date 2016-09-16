package edu.stanford.protege.admin.ui;

import org.protege.editor.owl.ui.view.AbstractOWLViewComponent;

import java.awt.*;

/**
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public class UserView extends AbstractOWLViewComponent {
    private static final long serialVersionUID = -2533900438454769439L;
    private UserPanel userPanel;

    @Override
    protected void initialiseOWLView() throws Exception {
        setLayout(new BorderLayout());
        setBorder(UiUtils.MATTE_BORDER);
        userPanel = new UserPanel(getOWLEditorKit());
        add(userPanel, BorderLayout.CENTER);
    }

    @Override
    protected void disposeOWLView() {
        userPanel.dispose();
    }
}
