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

public class BSONDocument {

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

		c.insert(_doc);
		c.find();


	}

	public void insert(DBObject doc) {
		try {
			MongoClient client = new MongoClient("localhost", 27010);
			DB courseDB = client.getDB("course");
			DBCollection collection = courseDB.getCollection("insertTest");

			collection.insert(doc); //* single insert

			System.out.println(doc);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void find() {
		try {
			MongoClient client = new MongoClient("localhost", 27010);
			DB courseDB = client.getDB("course");
			DBCollection collection = courseDB.getCollection("insertTest");

			DBObject one = collection.findOne(); //* single insert
			System.out.println("\nFind one:" + one);

			DBCursor cursor = collection.find();
			try {
				while (cursor.hasNext()) {
					DBObject element = cursor.next();
					System.out.println("\nFind all: " + element);
				}

			} finally {
				cursor.close();
			}

			long count = collection.count();
			System.out.println("\ncount:" + count);
			
			DBObject query = new BasicDBObject("username", "alex")
							.append("age", new BasicDBObject("$gt", 5))
							.append("$lt", 11);
			
			DBCursor oneCriteria = collection.find(query); //* single document with criteria
			try {
				while (oneCriteria.hasNext()) {
					DBObject element = oneCriteria.next();
					System.out.println("\nFind with criteria: " + element);
				}

			} finally {
				cursor.close();
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
