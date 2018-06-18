package aop.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AudienceXML {

    Logger LOG = LoggerFactory.getLogger(AudienceXML.class.getName());

    public void perform() {
    }

    public void silenceCellPhones() {
        LOG.info("Please silence cell phones!");
    }

    public void takeSeats() {
        LOG.info("Please take your seat!");
    }

    public void applause() {
        LOG.info("<CLAP CLAP CLAP>!");
    }

    public void demandRefund() {
        LOG.info("Demanding a refund!");
    }

}
