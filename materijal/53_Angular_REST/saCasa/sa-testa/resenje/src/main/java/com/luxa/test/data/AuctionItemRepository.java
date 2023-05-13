package com.luxa.test.data;

import com.luxa.test.model.AuctionItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {

}
