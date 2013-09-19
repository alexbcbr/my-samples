package com.nosql;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class GridFSTest {

	public static void main(String[] args) throws UnknownHostException {
		
		FileInputStream fis = null;
		
		MongoClient client = new MongoClient("localhost", 27010);
		DB db = client.getDB("course");
		
		GridFS arquivos = new GridFS(db, "pdfs");
		
		try {
			fis = new FileInputStream("mongo.pdf");
			GridFSInputFile pdf = arquivos.createFile(fis, "mongo.pdf");
			
			BasicDBObject meta = new BasicDBObject("descroption", "Alex");
			ArrayList<String> tags = new ArrayList<>();
			
			tags.add("singing");
			tags.add("opera");
			meta.append("tags", tags);
			
			pdf.setMetaData(meta);
			pdf.save();
			
			System.out.println("Object ID:" + pdf.get("_id"));
			
			GridFSDBFile gridfile = arquivos.findOne(new BasicDBObject("filename", "mongo.pdf"));
			
			FileOutputStream fos = new FileOutputStream("pdf_copy.pdf");
			gridfile.writeTo(fos);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
