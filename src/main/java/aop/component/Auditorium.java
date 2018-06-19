package aop.component;

import org.springframework.stereotype.Component;

@Component
public class Auditorium {

    private Performance performance;

    public void perform() {
        this.performance.perform();
    }

    public void performEvent(final Performance performance) {
        this.setPerformance(performance);
        this.perform();
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }
}
