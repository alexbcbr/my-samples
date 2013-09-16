package com.nosql;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;

public class BSONDocument {

	private MongoClient client;
	private DB courseDB;
	private DBCollection collection;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BSONDocument c = new BSONDocument();

		DBObject _doc = new BasicDBObject();
		_doc.put("username", "alex");
		_doc.put("birthdate", new Date(234832432));
		_doc.put("programmer", true);
		_doc.put("age", 10);
		_doc.put("languages", Arrays.asList("Java", "C"));
		_doc.put("address", new BasicDBObject("street", "20 Main")
		.append("town", "Westfield")
		.append("zip", "560003"));

		try {
			c.createConnection();
			//			c.insert(_doc);
//			c.findAll();
			System.out.println("*****************");
			c.findWithDotNotation();
			c.closeConnection();


		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public void createConnection() throws UnknownHostException {
		client = new MongoClient("localhost", 27010);
		courseDB = client.getDB("course");
		collection = courseDB.getCollection("insertTest");
	}

	public void closeConnection() throws UnknownHostException {
		client.close();
	}
	
	public void insert(DBObject doc) {
		collection.insert(doc); //* single insert
		System.out.println(doc);
	}
	
	public void findOne() {
		DBObject one = collection.findOne(); //* single insert
		System.out.println("\nFind one:" + one);
	}

	
	public void findAll() {
		DBCursor cursor = collection.find();
		try {
			while (cursor.hasNext()) {
				DBObject element = cursor.next();
				System.out.println("\nFind all: " + element);
			}
			
			long count = collection.count();
			System.out.println("\ncount:" + count);


		} finally {
			cursor.close();
		}
	}

	public void findWithArgument() {

		DBObject query = new BasicDBObject("username", "alex")
		.append("age", new BasicDBObject("$gt", 5))
		.append("age", new BasicDBObject("$lt", 11));

		DBCursor oneCriteria = collection.find(query,
											   new BasicDBObject("birthdate", false)
											  ); //* single document with criteria
		
		try {
			while (oneCriteria.hasNext()) {
				DBObject element = oneCriteria.next();
				System.out.println("\nFind with criteria: " + element);
			}

		} finally {
			oneCriteria.close();
		}

	}

	public void findWithDotNotation() {
		
		QueryBuilder builder = QueryBuilder.start("address.zip").greaterThan("560001");
		
		DBCursor oneCriteria = collection.find(builder.get(),
											   new BasicDBObject("address.street", true).
											   append("_id",  false));
		
		try {
			while (oneCriteria.hasNext()) {
				DBObject element = oneCriteria.next();
				System.out.println("\nFind with criteria: " + element);
			}

		} finally {
			oneCriteria.close();
		}

	}

}
