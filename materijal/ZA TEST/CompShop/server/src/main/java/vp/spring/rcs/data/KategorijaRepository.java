package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.rcs.model.Kategorija;

public interface KategorijaRepository extends JpaRepository<Kategorija, Long> {

}
