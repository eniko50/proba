package vp.spring.rcs.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vp.spring.rcs.model.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
	List<Record> findAllByOrderByPriceAsc();
	List<Record> findAllByOrderByPriceDesc();
	List<Record> findByPriceBetweenOrderByPriceAsc(double lowestPrice, double higestPrice);
	List<Record> findByPriceBetweenOrderByPriceDesc(double lowestPrice, double higestPrice);
}
