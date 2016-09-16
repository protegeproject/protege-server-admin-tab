package edu.stanford.protege.admin.ui;

import edu.stanford.protege.admin.AdminTabManager;
import edu.stanford.protege.admin.model.AdminTabEvent;
import edu.stanford.protege.admin.model.AdminTabListener;
import edu.stanford.protege.metaproject.api.ServerConfiguration;
import edu.stanford.protege.metaproject.serialization.DefaultJsonSerializer;
import org.protege.editor.core.Disposable;
import org.protege.editor.core.ui.error.ErrorLogPanel;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.client.ClientSession;
import org.protege.editor.owl.client.LocalHttpClient;
import org.protege.editor.owl.client.event.ClientSessionChangeEvent;
import org.protege.editor.owl.client.event.ClientSessionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;

/**
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public class JsonSerializationPanel extends JPanel implements Disposable {
    private static final long serialVersionUID = -7661839896289542987L;
    private AdminTabManager configManager;
    private JTextArea textArea;
    private JScrollPane scrollpane;
    private ClientSession session;

    /**
     * Constructor
     *
     * @param editorKit OWL editor kit
     */
    public JsonSerializationPanel(OWLEditorKit editorKit) {
        configManager = AdminTabManager.get(editorKit);
        configManager.addListener(listener);
        session = ClientSession.getInstance(editorKit);
        session.addListener(sessionListener);
        initUi();
    }

    private void initUi() {
        setLayout(new BorderLayout());
        textArea = new JTextArea((session.getActiveClient() != null ? getJsonString() : ""));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setBorder(UiUtils.EMPTY_BORDER);

        scrollpane = new JScrollPane(textArea);
        Border border = new EmptyBorder(1, 5, 1, 5);
        scrollpane.setBorder(border);
        add(scrollpane, BorderLayout.CENTER);
    }

    private AdminTabListener listener = event -> {
        if( event.equals(AdminTabEvent.CONFIGURATION_CHANGED) || event.equals(AdminTabEvent.CONFIGURATION_RESET)) {
            update();
        }
    };

    private ClientSessionListener sessionListener = event -> {
        if(event.hasCategory(ClientSessionChangeEvent.EventCategory.USER_LOGIN) || event.hasCategory(ClientSessionChangeEvent.EventCategory.USER_LOGOUT)) {
            removeAll();
            initUi();
        }
    };

    private void update() {
        textArea.setText(getJsonString());
        textArea.setCaretPosition(0);
    }

    private void highlightText(String searchWord) {
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);

        int offset = textArea.getText().indexOf(searchWord);
        int length = searchWord.length();
        textArea.setCaretPosition(offset);

        while (offset != -1) {
            try {
                textArea.getHighlighter().addHighlight(offset, offset + length, painter);
                offset = textArea.getText().indexOf(searchWord, offset + 1);
            } catch (BadLocationException e) {
                ErrorLogPanel.showErrorDialog(e);
            }
        }
    }

    private String getJsonString() {
        DefaultJsonSerializer serializer = new DefaultJsonSerializer();
        return serializer.write(LocalHttpClient.current_user().getCurrentConfig(), ServerConfiguration.class);
    }

    @Override
    public void dispose() {
        configManager.removeListener(listener);
        session.removeListener(sessionListener);
    }
    
}
