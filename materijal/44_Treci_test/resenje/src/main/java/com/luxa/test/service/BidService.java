package com.luxa.test.service;

import com.luxa.test.data.AuctionItemRepository;
import com.luxa.test.data.BidRepository;
import com.luxa.test.exception.ForbiddenException;
import com.luxa.test.model.AuctionItem;
import com.luxa.test.model.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private AuctionItemRepository auctionItemRepository;

    public Bid createBidForItem(Bid bid, AuctionItem auctionItem) {
        if (auctionItem.isSold()) {
            throw new ForbiddenException("ITEM_IS_SOLD");
        }

        int currentPrice = auctionItem.getBids().stream()
                .mapToInt(Bid::getPrice)
                .max()
                .orElse(auctionItem.getMinimumBidPrice());

        if (currentPrice >= bid.getPrice()) {
            throw new ForbiddenException("BID_TOO_LOW");
        }

        if (bid.getPrice() >= auctionItem.getBuyoutPrice()) {
            auctionItem.setSold(true);
            auctionItemRepository.save(auctionItem);
        }

        return bidRepository.save(bid);
    }
}
