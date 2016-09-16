package edu.stanford.protege.admin.ui;

import org.protege.editor.owl.ui.view.AbstractOWLViewComponent;

import java.awt.*;

/**
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public class ProjectView extends AbstractOWLViewComponent {
    private static final long serialVersionUID = 7179006680830288462L;
    private ProjectPanel projectPanel;

    @Override
    protected void initialiseOWLView() throws Exception {
        setLayout(new BorderLayout());
        setBorder(UiUtils.MATTE_BORDER);
        projectPanel = new ProjectPanel(getOWLEditorKit());
        add(projectPanel, BorderLayout.CENTER);
    }

    @Override
    protected void disposeOWLView() {
        projectPanel.dispose();
    }
}
