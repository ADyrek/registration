package de.smava.registration.orchestrator.integration.authorizationService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="authorization" )
public interface AuthorizationServiceClient {

    @PostMapping("/oauth/token")
    Object getToken(@RequestBody Object tokenRequest);

}
