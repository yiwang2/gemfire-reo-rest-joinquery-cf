package io.pivotal.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.stereotype.Repository;

import io.pivotal.bookshop.domain.BookMaster;

@Repository
public class GemfireTemplateBookMasterDao {

	@Autowired
	GemfireTemplate bookMasterTemplate;
	
	public BookMaster get(Integer id) {
		return bookMasterTemplate.get(id);
	}
}
