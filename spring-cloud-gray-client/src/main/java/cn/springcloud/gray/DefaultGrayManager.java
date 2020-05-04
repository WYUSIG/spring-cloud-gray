package cn.springcloud.gray;

import cn.springcloud.gray.decision.PolicyDecisionManager;
import cn.springcloud.gray.request.track.GrayTrackHolder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultGrayManager extends SimpleGrayManager {


    public DefaultGrayManager(GrayTrackHolder grayTrackHolder, PolicyDecisionManager policyDecisionManager) {
        super(grayTrackHolder, policyDecisionManager);
    }

    @Override
    public boolean hasGray(String serviceId) {
        return GrayClientHolder.getGraySwitcher().state() && super.hasGray(serviceId);
    }
}
