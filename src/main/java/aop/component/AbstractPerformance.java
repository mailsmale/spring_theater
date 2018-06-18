package aop.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPerformance implements Performance {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass().getName());
    private String performanceName;

    public AbstractPerformance() {
        this.performanceName = this.getClass().getSimpleName();
    }

    @Override
    public void perform() {
        LOG.info(String.format("Performing '%s'", this.getClass().getName()));
    }

    @Override
    public String getPerformanceName() {
        return performanceName;
    }

    public void setPerformanceName(String performanceName) {
        this.performanceName = performanceName;
    }
}
