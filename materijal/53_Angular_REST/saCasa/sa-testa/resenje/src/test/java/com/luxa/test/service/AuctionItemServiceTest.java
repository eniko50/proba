package com.luxa.test.service;

import com.luxa.test.data.AuctionItemRepository;
import com.luxa.test.data.BidRepository;
import com.luxa.test.model.AuctionItem;
import com.luxa.test.model.Bid;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuctionItemServiceTest {

    @Autowired
    private AuctionItemRepository auctionItemRepository;

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private AuctionItemService auctionItemService;

    @After
    public void after() {
        bidRepository.deleteAll();
        auctionItemRepository.deleteAll();
    }

    @Test
    public void testSave() {
        long initialCount = auctionItemRepository.count();
        AuctionItem auctionItem = new AuctionItem();
        auctionItem.setName("name");
        auctionItem.setMinimumBidPrice(100);
        auctionItem.setBuyoutPrice(1000);

        auctionItemRepository.save(auctionItem);

        long endCount = auctionItemRepository.count();
        Assert.assertEquals(initialCount + 1, endCount);
    }

    @Test
    public void testFindByJmbg() {
        AuctionItem item1 = createAuctionItem("item1", 100, 1000);
        AuctionItem item2 = createAuctionItem("item2", 200, 2000);

        Bid bid1 = new Bid(120, "FN1", "LN1", "JMBG1", item1);
        Bid bid2 = new Bid(130, "FN2", "LN2", "JMBG2", item1);
        Bid bid3 = new Bid(140, "FN1", "LN1", "JMBG1", item1);
        Bid bid4 = new Bid(250, "FN4", "LN4", "JMBG4", item2);

        bidRepository.save(bid1);
        bidRepository.save(bid2);
        bidRepository.save(bid3);
        bidRepository.save(bid4);

        List<AuctionItem> items = auctionItemService.findByJmbg("JMBG1");
        Assert.assertEquals(1, items.size());

        AuctionItem item = items.get(0);
        Assert.assertEquals("item1", item.getName());
        Assert.assertEquals(100, item.getMinimumBidPrice());
        Assert.assertEquals(1000, item.getBuyoutPrice());
    }

    private AuctionItem createAuctionItem(String name, int minimumBidPrice, int buyoutPrice) {
        AuctionItem auctionItem = new AuctionItem();
        auctionItem.setName(name);
        auctionItem.setMinimumBidPrice(minimumBidPrice);
        auctionItem.setBuyoutPrice(buyoutPrice);

        return auctionItemRepository.save(auctionItem);
    }
}