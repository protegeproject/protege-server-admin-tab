package edu.stanford.protege.admin.model;

import edu.stanford.protege.metaproject.api.Project;
import org.protege.editor.core.ui.list.MListItem;

/**
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public interface ProjectMListItem extends MListItem {

    Project getProject();

}
