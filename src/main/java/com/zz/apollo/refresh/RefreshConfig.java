package com.zz.apollo.refresh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.core.ConfigConsts;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.zz.apollo.config.ApolloConfigMyTest;

@Component
public class RefreshConfig {
	 private static final Logger logger = LoggerFactory.getLogger(RefreshConfig.class);

	  private final ApolloConfigMyTest apolloConfigMyTest;
	  private final RefreshScope refreshScope;

	  public RefreshConfig(
	      final ApolloConfigMyTest apolloConfigMyTest,
	      final RefreshScope refreshScope) {
	    this.apolloConfigMyTest = apolloConfigMyTest;
	    this.refreshScope = refreshScope;
	  }

	  @ApolloConfigChangeListener(value = {ConfigConsts.NAMESPACE_APPLICATION, "TEST1.spring-simple", "my-test"},
	      interestedKeys = {"my.test.name"})
	  public void onChange(ConfigChangeEvent changeEvent) {
	    logger.info("before refresh {}", apolloConfigMyTest.toString());
	    refreshScope.refresh("apolloConfigMyTest");
	    logger.info("after refresh {}", apolloConfigMyTest.toString());
	  }
}
