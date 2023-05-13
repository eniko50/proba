package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.RecordRepository;
import vp.spring.rcs.model.Record;

@Component
public class RecordService {

	@Autowired
	RecordRepository recordRepository;

	public Record findOne(Long id) {
		return recordRepository.findOne(id);
	}

	public List<Record> findAll() {
		return recordRepository.findAll();
	}

	public Record save(Record Record) {
		return recordRepository.save(Record);
	}

	public void remove(Long id) {
		recordRepository.delete(id);
	}
	
	public List<Record> findAllOrderByPriceAsc(){
		return recordRepository.findAllByOrderByPriceAsc();
	}

	public List<Record> findAllOrderByPriceDesc(){
		return recordRepository.findAllByOrderByPriceDesc();
	}

	public List<Record> findAllOrderByPriceAsc(double lowestPrice, double higestPrice){
		return recordRepository.findByPriceBetweenOrderByPriceAsc(lowestPrice, higestPrice);
	}

	public List<Record> findAllOrderByPriceDesc(double lowestPrice, double higestPrice){
		return recordRepository.findByPriceBetweenOrderByPriceDesc(lowestPrice, higestPrice);
	}

}
