package com.zen.services.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import java.util.Iterator;

/**
 * Utility class for query order by clause creation.
 */
public final class SortingUtil {

	private static final Logger log = LoggerFactory.getLogger(SortingUtil.class);

	public static String createOrderByClause(Pageable pageRequest) {
		
        Sort sort = pageRequest.getSort();
        String orderByClause = "";
        if(sort != null && !sort.equals(Sort.unsorted())) {
        	log.info(sort.toString());
	        Iterator<Order> sortIterator = sort.iterator();
			Order order = null;
			orderByClause = "ORDER BY ";
			while(sortIterator.hasNext()) {
				order = sortIterator.next();
				log.info(order.toString());
				String columnName = order.getProperty();
				Direction direction = order.getDirection();
				orderByClause = orderByClause.concat(columnName + " " + direction);
				if (sortIterator.hasNext()) {
					log.info("sortIterator Has Next");
					orderByClause = orderByClause.concat(" , ");
				}
	        }
        }
		return orderByClause;
	}
	
public static String createOrderByClause(Pageable pageRequest, String reference) {
		
        Sort sort = pageRequest.getSort();
        String orderByClause = "";
        if(sort != null && !sort.equals(Sort.unsorted())){
	        Iterator<Order> sortIterator = sort.iterator();
			Order order = null;
			orderByClause = "ORDER BY ";
			while(sortIterator.hasNext()) {
				order = sortIterator.next();
				String columnName = order.getProperty();
				Direction direction = order.getDirection();
				orderByClause = orderByClause.concat(reference + "." +columnName + " " + direction);
				if (sortIterator.hasNext()) {
					orderByClause = orderByClause.concat(" , ");
				}
	        }
        }
		return orderByClause;
	}

}
