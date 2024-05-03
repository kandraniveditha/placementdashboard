package com.suchiit.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;

import com.suchiit.model.CreateDataRecordRequest;
import com.suchiit.model.DataRecord;
import com.suchiit.model.UpdateDataRecordRequest;


public interface DataRecordService {

	public String createDataRecord(CreateDataRecordRequest request);

	 public List<?> getAllDataRecord(String searchInput);
	 
	 public DataRecord getDataRecordById(String id);
	  
	  public ResponseEntity<?> updateDataRecord(UpdateDataRecordRequest request);
	  
	 public  ResponseEntity<?>  deleteDataRecord(String id);
	 
	 public Query getSearchQuery(String searchInput);
	 
	
}
