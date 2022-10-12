package view;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import controller.LabyrinthController;
import javafx.animation.AnimationTimer;

public class Timer extends AnimationTimer {
	
	final Instant start = Instant.now();
    public int numOfStars = 0;
	private LabyrinthController controller;
	
    public Timer(LabyrinthController controller) {
		this.controller = controller;
	}

	@Override
    public void handle(long now) {
        String time = getTime();
        controller.setTime(time);
	}
	
	public String getTime() {
		Instant end = Instant.now();
        long millis = (Duration.between(start.plus(numOfStars*15, ChronoUnit.SECONDS), end)).toMillis();
        long second = (millis / 1000) % 60;
        long minute = (millis / (60000)) % 60;
        long hour = millis / (3600000);
        String time = String.format("%02d:%02d:%02d",
                hour, minute, second);
        return time;
	}
	
}
