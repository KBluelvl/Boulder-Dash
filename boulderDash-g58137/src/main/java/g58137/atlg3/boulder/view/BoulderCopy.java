package g58137.atlg3.boulder.view;

import g58137.atlg3.boulder.model.Facade;
import g58137.atlg3.boulder.model.Util.Observer;

public class BoulderCopy extends BoulderPane implements Observer {
    /**
     * Constructs a new BoulderCopy which initializes the offsets, facade, currLevel, nb and transition attributes.
     *
     * @param facade a given Facade.
     */
    public BoulderCopy(Facade facade) {
        super(facade);
        facade.register(this);
        display();
    }

    @Override
    public void update() {
        display();
    }
}
