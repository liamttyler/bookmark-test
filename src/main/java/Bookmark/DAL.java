package Bookmark;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Link;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.SortDirection;

public class DAL {
	
	public Key add(String name, String url, String category) {
		
		Key key = null;
		
		if (name != null && url != null && category != null) {
			
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
			Entity entity = new Entity("Bookmark");
			
			entity.setProperty("name", name);
			entity.setProperty("url", new Link(url));
			entity.setProperty("category", category);
			
			key = datastore.put(entity);
			
		}
		return key;
	}
	
	public List<Entity> getAll() {
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Query findQuery = new Query("Bookmark");
		findQuery.addSort("name", SortDirection.ASCENDING);

		PreparedQuery pq = datastore.prepare(findQuery);
		FetchOptions option = FetchOptions.Builder.withLimit(500);
		
		List<Entity> results = pq.asList(option);
		
		return results;
	}
	
	public static void delete(String name) {
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		if(name != null && !name.isEmpty()) {
		Key key = KeyFactory.createKey("name", name);
		datastore.delete(key);
		}
	}
	
} 
