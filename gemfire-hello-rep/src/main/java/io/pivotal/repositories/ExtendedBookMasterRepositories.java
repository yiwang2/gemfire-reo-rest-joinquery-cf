package io.pivotal.repositories;

import java.util.*;

import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.execute.Execution;
import org.apache.geode.cache.execute.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.pivotal.bookshop.domain.BookMaster;
import io.pivotal.functions.IBookMasterCustomFunctionExecutions;
import org.apache.geode.cache.*;

@Component
public class ExtendedBookMasterRepositories implements IExtendedBookMasterRepositories{

	
	//@Autowired
	//private IBookMasterCustomFunctionExecutions bookMasterCustomFunctionExecutions;

	@Override
	public List<BookMaster> findAllBooksWithLowQuantity() {
		//return bookMasterCustomFunctionExecutions.findAllBooksWithLowQuantity();
		Cache cache = CacheFactory.getAnyInstance();
		Execution execution = FunctionService.onRegion(cache.getRegion("/BookMaster"));
		Object queryBookWIthLowQuantityResult = execution.execute("findAllBooksWithLowQuantity").getResult();
		
		return (ArrayList<BookMaster>)queryBookWIthLowQuantityResult;
	}
	

}
