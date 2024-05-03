package com.suchiit.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.suchiit.constants.StatusConstants;
import com.suchiit.model.CreateDataRecordRequest;
import com.suchiit.model.DataRecord;
import com.suchiit.model.UpdateDataRecordRequest;
import com.suchiit.service.DataRecordService;


@Service
public class DataRecordServiceImpl implements DataRecordService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(DataRecordServiceImpl.class);
	
	@Override
	public String createDataRecord(CreateDataRecordRequest request) {
		LOGGER.info("DataRecord Creadted Successfully in Implementation");
Random rand=new Random();
		
		Criteria criteria=new Criteria();
		criteria.orOperator(
         Criteria.where("email")
        .regex(Pattern.compile(request.getEmail(), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
         Criteria.where("contactNumber")
         .regex(Pattern.compile(request.getContactNumber(), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
		
		Query query=new Query(criteria);
		DataRecord datarecord =this.mongoTemplate.findOne(query,DataRecord.class);
		if(datarecord == null) 
		{
			
		DataRecord newdatarecord=new DataRecord();
		//System.out.println("hiiiiii"+newdatarecord);
			 BeanUtils.copyProperties(request, newdatarecord);
			 newdatarecord.setId(newdatarecord.getFirstName().substring(0,3)+newdatarecord.getLastName().substring(0, 3)+rand.nextInt(9));
		newdatarecord.setStatus(StatusConstants.PENDING);
		newdatarecord.setRoles(StatusConstants.PENDING);
		newdatarecord.setCreatedAt(new Date(System.currentTimeMillis()));
		//newcandidate.setLastmodifiedDate(new Date(System.currentTimeMillis()));
		this.mongoTemplate.insert(newdatarecord);
		return "DataRecord Successfully created with id: "+newdatarecord.getId();
		}
		else {
			return "DataRecord Already exists";
		}
	}

	@Override
	public List<?> getAllDataRecord(String searchInput) {
		LOGGER.info("DataRecord get all records in Implementation");
		Query query=new Query();
		if(StringUtils.isEmpty(searchInput)) {
			query=this.getSearchQuery(searchInput);
		}
		List<DataRecord>datarecords=this.mongoTemplate.find(query,DataRecord.class);
		if(!CollectionUtils.isEmpty(datarecords)) {
		return datarecords;
	}else {
		return new ArrayList();
	}
	}

	@Override
	public DataRecord getDataRecordById(String id) {
		LOGGER.info("DataRecord get single records in Implementation");
		Query query=new Query();
		if(StringUtils.isEmpty(id)) {
			query.addCriteria(Criteria.where("_id").is(id));
			DataRecord datarecord=this.mongoTemplate.findOne(query, DataRecord.class);
			if(datarecord!=null) 
				return datarecord;
			
			else 
				return new DataRecord();
			}else 
				return new DataRecord();
	}

	@Override
	public ResponseEntity<?> updateDataRecord(UpdateDataRecordRequest request) {
		LOGGER.info("DataRecord Update records Successfully in Implementation");
		Query query = new Query();
		query.addCriteria(Criteria.where("candidateId").is(request.getCandidateId()));
		DataRecord datarecord = this.mongoTemplate.findOne(query,DataRecord.class);
		if (datarecord != null) {
			if (request.getFirstName() != null) {
				datarecord.setFirstName(request.getFirstName());
			}
		     if(request.getMiddleName()!=null) {
		    	 datarecord.setMiddleName(request.getMiddleName());
		     }
			if (request.getLastName() != null) {
				datarecord.setLastName(request.getLastName());
			}
			if(request.getDateOfBirth()!=null) {
				datarecord.setDateOfBirth(request.getDateOfBirth());
			}
			if (request.getEmail() != null) {
				datarecord.setEmail(request.getEmail());
			}
			if (request.getContactNumber() != null) {
				datarecord.setContactNumber(request.getContactNumber());
			}
			if (request.getAddress() != null) {
				datarecord.setAddress(request.getAddress());
			}
			if(request.getHigherEductaion()!=null) {
				datarecord.setHigherEductaion(request.getHigherEductaion());
			}
			if(request.getWorkExperience()!=null) {
				datarecord.setWorkExperience(request.getWorkExperience());
			}
		    if(request.getTechnology()!=null) {
		    	datarecord.setTechnology(request.getTechnology());
		    }
		    if(request.getPreferredModeOfWork()!=null) {
		    	datarecord.setPreferredModeOfWork(request.getPreferredModeOfWork());
		    }
		    if(request.getExpectedsalary()!=null) {
		    	datarecord.setExpectedsalary(request.getExpectedsalary());
		    }
		    if(request.getWorkAuthorization()!=null) {
		    	datarecord.setWorkAuthorization(request.getWorkAuthorization());
		    }
		    if(request.getJobSearchlocationpreference()!=null) {
		    	datarecord.setJobSearchlocationpreference(request.getJobSearchlocationpreference());
		    }
			if(request.getLastmodifiedDate()!=null) {
				datarecord.setLastmodifiedDate(request.getLastmodifiedDate());
			}
			this.mongoTemplate.save(datarecord);
			return new ResponseEntity<>("DataRecord"+ datarecord.getId() + " : is successfully updated",
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No DataRecord found with Id- " + request.getCandidateId(), HttpStatus.NOT_FOUND);
		
		}
	}

	@Override
	public ResponseEntity<?> deleteDataRecord(String id) {
		LOGGER.info("DataRecord Delete successfully in Implementation");
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		DataRecord datarecord = this.mongoTemplate.findOne(query, DataRecord.class);
		if (datarecord != null) {
			datarecord.setStatus("INACTIVE");	
			this.mongoTemplate.save(datarecord);
			return new ResponseEntity<>("DataRecord " + id+ ": is successfully deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No DataRecord found with Id-" + id, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Query getSearchQuery(String searchInput) {
		Query query = new Query();
		List<Criteria> criterias = new LinkedList<>();
		Criteria searchCriteria = new Criteria();
		searchCriteria.orOperator(
				Criteria.where("_id")
				        .regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
				Criteria.where("firstName")
			         	.regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
				Criteria.where("middleName")
				        .regex(Pattern.compile(searchInput,Pattern.CASE_INSENSITIVE| Pattern.UNICODE_CASE)),
			    Criteria.where("lastName")
			        	.regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
				Criteria.where("email")
				        .regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
		        Criteria.where("line")
		                .regex(Pattern.compile(searchInput,Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
			    Criteria.where("address.city")
						.regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
				Criteria.where("address.state")
						.regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
				Criteria.where("address.country")
						.regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
				Criteria.where("address.line")
						.regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
				Criteria.where("address.zipCode")
						.regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
				Criteria.where("phoneNumber")
				        .regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
				Criteria.where("higherEducation")
		                .regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
		        Criteria.where("dueDate")
		                .regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
		        Criteria.where("role")
		                .regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
		        Criteria.where("visaType")
		                .regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
	           	Criteria.where("comments")
                        .regex(Pattern.compile(searchInput, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
	
		criterias.add(searchCriteria);
		if (!CollectionUtils.isEmpty(criterias)) {
			Criteria criteria = new Criteria();
			criteria.andOperator(criterias.stream().toArray(Criteria[]::new));
			query.addCriteria(criteria);
		}
		return query;
	}

	}


