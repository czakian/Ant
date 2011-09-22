import java.awt.Color;

enum State {
    On, Off;

    // Cycle to the opposite state
    State next() {
        if (this == On)
            return Off;
        else
            return On;
    }

    // An arbitrary pretty colour for On cells
    final static Color OnColor = new Color((float)0.3, (float)0.1, (float)0.8);
}
