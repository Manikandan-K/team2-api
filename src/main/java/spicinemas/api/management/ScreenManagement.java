package spicinemas.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spicinemas.api.db.ScreenRepository;
import spicinemas.api.model.Screen;

@Component
public class ScreenManagement {
    @Autowired
    private ScreenRepository screenRepository;

    public Screen getScreenById(long screenId) {
        return screenRepository.getScreenById(screenId);
    }
}
