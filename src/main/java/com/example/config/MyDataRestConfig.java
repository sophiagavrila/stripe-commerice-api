package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.example.models.Product;
import com.example.models.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	
	/**
	 * Currently this is configured for GET requests (READ only) 
	 * Alternatively, we could have built a RestController, but then we lose
	 * Spring Data REST support for Paging & Sorting
	 * 
	 * https://docs.spring.io/spring-data/rest/docs/2.0.0.M1/reference/html/paging-chapter.html
	 */
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) { // this is from Spring Data Rest

        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH};

        // disable HTTP methods for Product: PUT, POST, DELETE and PATCH
        config.getExposureConfiguration()
                .forDomainType(Product.class) // a.k.a Apply to Repo for: ProductCategory
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)) // single item
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)); // collection

        // disable HTTP methods for ProductCategory: PUT, POST, DELETE and PATCH
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class) // a.k.a Apply to Repo for: ProductCategory
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)) // single item
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)); // collection

    }


}