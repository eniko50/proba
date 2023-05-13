package vp.spring.SpringDataJPACountry.data;

import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.SpringDataJPACountry.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}
