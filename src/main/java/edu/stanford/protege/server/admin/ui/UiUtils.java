package edu.stanford.protege.server.admin.ui;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * @author Rafael Gonçalves <br>
 * Center for Biomedical Informatics Research <br>
 * Stanford University
 */
public class UiUtils {

    public static final Color
            BORDER_COLOR = new Color(220, 220, 220);

    public static final Border
            MATTE_BORDER = new MatteBorder(1, 1, 1, 1, BORDER_COLOR),
            EMPTY_BORDER = new EmptyBorder(0,0,0,0);

}
