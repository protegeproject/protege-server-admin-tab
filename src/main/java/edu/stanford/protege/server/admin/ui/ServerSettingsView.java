package edu.stanford.protege.server.admin.ui;

import org.protege.editor.owl.ui.view.AbstractOWLViewComponent;

import java.awt.*;

/**
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public class ServerSettingsView extends AbstractOWLViewComponent {
    private static final long serialVersionUID = 1233108774356546780L;
    private ServerSettingsPanel settingsPanel;

    @Override
    protected void initialiseOWLView() throws Exception {
        setLayout(new BorderLayout());
        settingsPanel = new ServerSettingsPanel(getOWLEditorKit());
        add(settingsPanel, BorderLayout.CENTER);
    }

    @Override
    protected void disposeOWLView() {
        settingsPanel.dispose();
    }
}
