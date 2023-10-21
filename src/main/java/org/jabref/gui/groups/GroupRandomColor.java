package org.jabref.gui.groups;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The GroupRandomColor class provides methods for assigning random colors to top-level groups.
 * This class maintains a list of predefined colors for top-level groups and ensures that each group is assigned a unique color.
 */
public class GroupRandomColor {
    private static List<Color> topGroupColors = new ArrayList<>();
    private static int nextTopGroupColorIndex = 0;

    /**
     * Assigns a unique color to a top-level group. If the list of predefined colors is exhausted,
     * a new color is generated using the golden angle approximation.
     *
     * @return A Color object representing the assigned color for the top-level group.
     */
    public static Color assignTopGroupColor() {
        // Assign a predefined color from the list
        if (nextTopGroupColorIndex < topGroupColors.size()) {
            Color color = topGroupColors.get(nextTopGroupColorIndex);
            nextTopGroupColorIndex++;
            return color;
        } else {
            // Generate a new color using the golden angle approximation
            // Golden angle approximation
            double hue = (nextTopGroupColorIndex * 137.508) % 360;
            double saturation = 0.8;
            double brightness = 0.9;
            Color color = Color.hsb(hue, saturation, brightness);

            // Add the generated color to the list for future use
            topGroupColors.add(color);
            nextTopGroupColorIndex++;
            return color;
        }
    }
}
