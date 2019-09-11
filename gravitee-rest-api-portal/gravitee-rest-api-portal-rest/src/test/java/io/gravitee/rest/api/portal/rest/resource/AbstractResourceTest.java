/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.rest.api.portal.rest.resource;

import static org.mockito.Mockito.mock;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import io.gravitee.rest.api.portal.rest.JerseySpringTest;
import io.gravitee.rest.api.portal.rest.mapper.ApiMapper;
import io.gravitee.rest.api.portal.rest.mapper.ApplicationMapper;
import io.gravitee.rest.api.portal.rest.mapper.KeyMapper;
import io.gravitee.rest.api.portal.rest.mapper.MemberMapper;
import io.gravitee.rest.api.portal.rest.mapper.PageMapper;
import io.gravitee.rest.api.portal.rest.mapper.PlanMapper;
import io.gravitee.rest.api.portal.rest.mapper.RatingMapper;
import io.gravitee.rest.api.portal.rest.mapper.SubscriptionMapper;
import io.gravitee.rest.api.security.authentication.AuthenticationProvider;
import io.gravitee.rest.api.security.authentication.AuthenticationProviderManager;
import io.gravitee.rest.api.security.cookies.JWTCookieGenerator;
import io.gravitee.rest.api.service.ApiKeyService;
import io.gravitee.rest.api.service.ApiMetadataService;
import io.gravitee.rest.api.service.ApiService;
import io.gravitee.rest.api.service.ApplicationService;
import io.gravitee.rest.api.service.EntrypointService;
import io.gravitee.rest.api.service.FetcherService;
import io.gravitee.rest.api.service.GroupService;
import io.gravitee.rest.api.service.MediaService;
import io.gravitee.rest.api.service.MembershipService;
import io.gravitee.rest.api.service.MessageService;
import io.gravitee.rest.api.service.NotifierService;
import io.gravitee.rest.api.service.PageService;
import io.gravitee.rest.api.service.ParameterService;
import io.gravitee.rest.api.service.PermissionService;
import io.gravitee.rest.api.service.PlanService;
import io.gravitee.rest.api.service.PolicyService;
import io.gravitee.rest.api.service.QualityMetricsService;
import io.gravitee.rest.api.service.RatingService;
import io.gravitee.rest.api.service.RoleService;
import io.gravitee.rest.api.service.SocialIdentityProviderService;
import io.gravitee.rest.api.service.SubscriptionService;
import io.gravitee.rest.api.service.SwaggerService;
import io.gravitee.rest.api.service.TagService;
import io.gravitee.rest.api.service.TaskService;
import io.gravitee.rest.api.service.TopApiService;
import io.gravitee.rest.api.service.UserService;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author Nicolas GERAUD (nicolas.geraud at graviteesource.com)
 * @author Florent CHAMFROY (florent.chamfroy at graviteesource.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public abstract class AbstractResourceTest extends JerseySpringTest {

    public AbstractResourceTest() {
        super(new AuthenticationProviderManager() {
            @Override
            public List<AuthenticationProvider> getIdentityProviders() {
                return Collections.emptyList();
            }

            @Override
            public Optional<AuthenticationProvider> findIdentityProviderByType(String type) {
                return Optional.empty();
            }
        });
    }

    public AbstractResourceTest(AuthenticationProviderManager authenticationProviderManager) {
        super(authenticationProviderManager);
    }

    @Autowired
    protected ApiService apiService;

    @Autowired
    protected ApplicationService applicationService;

    @Autowired
    protected PolicyService policyService;

    @Autowired
    protected UserService userService;

    @Autowired
    protected FetcherService fetcherService;

    @Autowired
    protected SwaggerService swaggerService;

    @Autowired
    protected MembershipService membershipService;

    @Autowired
    protected RoleService roleService;

    @Autowired
    @Qualifier("oauth2")
    protected AuthenticationProvider authenticationProvider;

    @Autowired
    protected PageService pageService;

    @Autowired
    protected GroupService groupService;

    @Autowired
    protected RatingService ratingService;

    @Autowired
    protected PermissionService permissionService;

    @Autowired
    protected NotifierService notifierService;

    @Autowired
    protected QualityMetricsService qualityMetricsService;

    @Autowired
    protected MessageService messageService;

    @Autowired
    protected SocialIdentityProviderService socialIdentityProviderService;

    @Autowired
    protected TagService tagService;

    @Autowired
    protected ParameterService parameterService;
    
    @Autowired
    protected ApiMetadataService metadataService;
    
    @Autowired
    protected PlanService planService;
    
    @Autowired
    protected SubscriptionService subscriptionService;
    
    @Autowired
    protected EntrypointService entrypointService;

    @Autowired
    protected ApiKeyService apiKeyService;
    
    @Autowired
    ApiMapper apiMapper;
    
    @Autowired
    PageMapper pageMapper;
    
    @Autowired
    PlanMapper planMapper;
    
    @Autowired
    RatingMapper ratingMapper;
    
    @Autowired
    SubscriptionMapper subscriptionMapper;
    
    @Autowired
    KeyMapper keyMapper;
    
    @Autowired
    ApplicationMapper applicationMapper;
    
    @Autowired
    MemberMapper memberMapper;
    
    @Configuration
    @PropertySource("classpath:/io/gravitee/rest/api/portal/rest/resource/jwt.properties")
    static class ContextConfiguration {

    	@Bean
    	public ApiService apiService() {
    		return mock(ApiService.class);
    	}

        @Bean
        public ApplicationService applicationService() {
            return mock(ApplicationService.class);
        }

        @Bean
        public UserService userService() {
            return mock(UserService.class);
        }

        @Bean
        public PolicyService policyService() {
            return mock(PolicyService.class);
        }

        @Bean
        public FetcherService fetcherService() {
            return mock(FetcherService.class);
        }

        @Bean
        public SwaggerService swaggerService() {
            return mock(SwaggerService.class);
        }

        @Bean
        public MembershipService membershipService() {
            return mock(MembershipService.class);
        }

        @Bean
        public RoleService roleService() {
            return mock(RoleService.class);
        }

        @Bean("oauth2")
        public AuthenticationProvider authenticationProvider() {
            return mock(AuthenticationProvider.class);
        }

        @Bean
        public PageService pageService() {
            return mock(PageService.class);
        }

        @Bean
        public GroupService groupService() {
            return mock(GroupService.class);
        }

        @Bean
        public RatingService ratingService() {
            return mock(RatingService.class);
        }

        @Bean
        public PermissionService permissionService() {
            return mock(PermissionService.class);
        }

        @Bean
        public NotifierService notifierService() {
            return mock(NotifierService.class);
        }

        @Bean
        public TopApiService topApiService() {
            return mock(TopApiService.class);
        }

        @Bean
        public JWTCookieGenerator jwtCookieGenerator() {
    	    return mock(JWTCookieGenerator.class);
        }

        @Bean
        public TaskService taskService() {
            return mock(TaskService.class);
        }

        @Bean
        public QualityMetricsService qualityMetricsService() {
            return mock(QualityMetricsService.class);
        }

        @Bean
        public MessageService messageService() {
            return mock(MessageService.class);
        }

        @Bean
        public SocialIdentityProviderService socialIdentityProviderService() {
            return mock(SocialIdentityProviderService.class);
        }

        @Bean
        public TagService tagService() {
            return mock(TagService.class);
        }

        @Bean
        public MediaService mediaService() {
            return mock(MediaService.class);
        }

        @Bean
        public ParameterService parameterService() {
            return mock(ParameterService.class);
        }
        
        @Bean
        public ApiMetadataService metadataService() {
            return mock(ApiMetadataService.class);
        }
        
        @Bean
        public PlanService planService() {
            return mock(PlanService.class);
        }
        
        @Bean
        public SubscriptionService subscriptionService() {
            return mock(SubscriptionService.class);
        }
        
        @Bean
        public EntrypointService entrypointService() {
            return mock(EntrypointService.class);
        }
        
        @Bean
        public ApiKeyService apiKeyService() {
            return mock(ApiKeyService.class);
        }
        
        @Bean
        public ApiMapper apiMapper() {
            return mock(ApiMapper.class);
        }
        
        @Bean
        public PageMapper pageMapper() {
            return mock(PageMapper.class);
        }
        
        @Bean
        public PlanMapper planMapper() {
            return mock(PlanMapper.class);
        }
        
        @Bean
        public RatingMapper ratingMapper() {
            return mock(RatingMapper.class);
        }
        
        @Bean
        public SubscriptionMapper subscriptionMapper() {
            return mock(SubscriptionMapper.class);
        }
        
        @Bean
        public KeyMapper keyMapper() {
            return mock(KeyMapper.class);
        }
        
        @Bean
        public ApplicationMapper applicationMapper() {
            return mock(ApplicationMapper.class);
        }
        
        @Bean
        public MemberMapper memberMapper() {
            return mock(MemberMapper.class);
        }
    }
}