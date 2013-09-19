package com.nosql;

import java.util.Arrays;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Classe de teste para a manipulação de documentos BSON
 * @author alexbc
 * 
 */
public class BSONDocument {

	/**
	 * Método para executar os exemplos.
	 */
	public static void main(String[] args) {
		BsonDAO c = new BsonDAO();

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
			c.findOne();
//			c.findAllWithSort();
//			c.findWithDotNotation();
//			c.update(new BasicDBObject("username", "alex"),
//					 new BasicDBObject("$set", new BasicDBObject("age", 45)));
			
//			c.remove(new BasicDBObject("username", "alex"));
			c.closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
