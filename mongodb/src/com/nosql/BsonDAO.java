package com.nosql;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;

/**
 * Exemplos de implementação com o MongoDB utilizando documentos BSON
 * @author alexbc
 * 
 */
public class BsonDAO {

	/** The client. */
	private MongoClient client;
	
	/** The course db. */
	private DB courseDB;
	
	/** The collection. */
	private DBCollection collection;

	/**
	 * Cria a conexão com o servidor
	 * @throws UnknownHostException the unknown host exception
	 */
	public void createConnection() throws UnknownHostException {
		client = new MongoClient("localhost", 27010);
		courseDB = client.getDB("course");
		collection = courseDB.getCollection("insertTest");
	}

	/**
	 * Encerra conexão
	 * @throws UnknownHostException the unknown host exception
	 */
	public void closeConnection() throws UnknownHostException {
		client.close();
	}
	
	/**
	 * Inserir um documento BSON em uma collection
	 * @param doc the doc
	 */
	public void insert(DBObject doc) {
		collection.insert(doc); //* single insert
		System.out.println(doc);
	}
	
	/**
	 * Atualizar um documento BSON em uma collection
	 * @param doc the doc
	 */
	public void update(BasicDBObject source, BasicDBObject target) {
		collection.update(source, target); 
	}
	
	/**
	 * Remover um documento BSON em uma collection
	 * @param doc the doc
	 */
	public void remove(BasicDBObject source) {
		collection.remove(source); 
	}
	
	/**
	 * Buscar um item na collection
	 */
	public void findOne() {
		DBObject one = collection.findOne(); //* single insert
		System.out.println("\nFind one:" + one);
	}
	
	/**
	 * Buscar todos os registros da collection classificando-os por ordem decrecente 
	 * de ID e ordem crescente por nome limitando a apresentação 
	 * em 3 registros e pulando os primeiros 2 registros
	 */
	public void findAllWithSort() {
		DBCursor cursor = collection.find()
					.sort(new BasicDBObject("_id", -1).append("username", 1))
					.skip(2)
					.limit(3);
		
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

	/**
	 * Busca um documento utilizando argumentos de filtro
	 */
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

	/**
	 * Busca de um documneto usando dot notation.
	 */
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
