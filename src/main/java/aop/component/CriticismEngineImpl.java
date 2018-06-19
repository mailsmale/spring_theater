package aop.component;

import org.springframework.stereotype.Component;

public class CriticismEngineImpl implements CriticismEngine {

    private String[] criticismPool;

    public CriticismEngineImpl() {
    }

    public CriticismEngineImpl(final String[] criticismPool) {
        super();
        this.criticismPool = criticismPool;
    }

    public String getCriticism() {
        return criticismPool[(int) (Math.random() * criticismPool.length)];
    }

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
