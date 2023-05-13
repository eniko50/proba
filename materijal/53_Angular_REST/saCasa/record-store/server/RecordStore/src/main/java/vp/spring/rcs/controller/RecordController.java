package vp.spring.rcs.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Record;
import vp.spring.rcs.service.RecordService;

@RestController
@RequestMapping(value = "/api/records")
public class RecordController {
	
	@Autowired
	RecordService recordService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Record>> getAll(@RequestParam(required=false, defaultValue="0") int ord,
			@RequestParam(required=false, defaultValue="0") int lowestPrice,
			@RequestParam(required=false, defaultValue="0") int highestPrice) {
		List<Record> records;
		if (ord==0) {
			if(lowestPrice != 0 || highestPrice != 0){
				records = recordService.findAllOrderByPriceAsc(lowestPrice,highestPrice);							
			}
			else{
				records = recordService.findAllOrderByPriceAsc();			
			}
		}
		else{
			if(lowestPrice != 0 || highestPrice != 0){
				records = recordService.findAllOrderByPriceDesc(lowestPrice,highestPrice);							
			}
			else{
				records = recordService.findAllOrderByPriceDesc();			
			}
		}
		return new ResponseEntity<>(records, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Record> getById(@PathVariable Long id) {
		Record record = recordService.findOne(id);
		
		if (record != null) {
			return new ResponseEntity<>(record, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Record> create(@RequestBody Record record) {
		Record retVal = recordService.save(record);

		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Record> update(@PathVariable Long id,
			@RequestBody Record record) {
		if (recordService.findOne(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		record.setId(id);
		Record retVal = recordService.save(record);

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Record record = recordService.findOne(id);
		if (record != null) {
			recordService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}



}
