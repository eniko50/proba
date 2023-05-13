package com.luxa.test.service;

import com.luxa.test.data.AuctionItemRepository;
import com.luxa.test.data.BidRepository;
import com.luxa.test.model.AuctionItem;
import com.luxa.test.model.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuctionItemService {

    @Autowired
    private AuctionItemRepository auctionItemRepository;

    @Autowired
    private BidRepository bidRepository;

    public List<AuctionItem> findAll() {
        return auctionItemRepository.findAll();
    }

    public Optional<AuctionItem> findById(long id) {
        return auctionItemRepository.findById(id);
    }

    public AuctionItem save(AuctionItem auctionItem) {
        return auctionItemRepository.save(auctionItem);
    }

    public List<AuctionItem> findByJmbg(String jmbg) {
        return bidRepository.findAll().stream()
                .filter(bid -> jmbg.equals(bid.getJmbg()))
                .map(Bid::getItem)
                .distinct()
                .collect(Collectors.toList());
    }
}
