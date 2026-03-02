package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class Slf4jRequestFilter implements Filter{
	private static final Logger log=LoggerFactory.getLogger(Slf4jRequestFilter.class);
	
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		log.info("Request Method : {}",requestSpec.getMethod());
		log.info("Triggering API URI: {}",requestSpec.getURI());
		return ctx.next(requestSpec, responseSpec);
	}
}
