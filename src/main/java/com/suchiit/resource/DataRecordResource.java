package com.suchiit.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suchiit.model.CreateDataRecordRequest;
import com.suchiit.model.DataRecord;
import com.suchiit.model.UpdateDataRecordRequest;
import com.suchiit.service.DataRecordService;

@RestController
@RequestMapping("/placementdb/datarecords")
public class DataRecordResource {

	
	@Autowired
	private DataRecordService dataRecordService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(DataRecordResource.class);
	

	@CrossOrigin(value = "http://localhost:3000")
	@PostMapping("/createdatarecord")
	public ResponseEntity<String>createDataRecord(@RequestBody CreateDataRecordRequest request ){
		LOGGER.info("DataRecord Created Successfully in Resourse");
		return new ResponseEntity<String>(this.dataRecordService.createDataRecord(request),HttpStatus.OK);
		
	}
	
	
	@CrossOrigin(value = "http://localhost:3000")
	@GetMapping("/getdatarecord")
	public ResponseEntity<?>getAllDataRecord(@RequestParam(required=false) String searchInput){
		LOGGER.info("Get the All DataRecord ");
	return new ResponseEntity<>(this.dataRecordService.getAllDataRecord(searchInput),HttpStatus.OK);
		
	}
	
	@CrossOrigin(value = "http://localhost:3000")
	@GetMapping("/getbydatarecord")
	public ResponseEntity<?>getDataRecordById(@RequestParam String id){
		//System.out.println("Aaaaaaaaaa"+id);
		LOGGER.info("Get One Data Record");
		return new ResponseEntity<DataRecord>(this.dataRecordService.getDataRecordById(id),HttpStatus.OK);
	}
	
	@CrossOrigin(value = "http://localhost:3000")
	@PutMapping("/updatedatarecord")
	public ResponseEntity<?>updateDataRecord(@RequestBody UpdateDataRecordRequest request){
		LOGGER.info("Update The DataRecord");
		return this.dataRecordService.updateDataRecord(request);
	}
	
	@CrossOrigin(value = "http://localhost:3000")
	@DeleteMapping("/deletedatarecord")
	public ResponseEntity<?> deletecDataRecord(@RequestParam String id) {
		LOGGER.info("Delete the data Record");
		return this.dataRecordService.deleteDataRecord(id);
	}
}
